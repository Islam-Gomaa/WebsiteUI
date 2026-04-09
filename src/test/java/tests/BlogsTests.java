package tests;

import base.BaseTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.admin.BasePage;
import pages.admin.Blogs.BlogsPage;
import pages.website.BlogsWebPage;
import utilities.AuthHelper;
import utils.Assertions;

import static dataReader.ReadDataFromJson.dataModel;

public class BlogsTests extends BaseTests {

    BasePage basePage;
    BlogsPage blogsPage;
    BlogsWebPage blogsWebPage;

    private String logoSrc;


    @BeforeMethod
    public void setupAdminSession() {
        openAdmin();
        basePage = AuthHelper.login(driver);
    }

    @Test(priority = 1)
    public void shouldAddEditAndDeleteNewsSuccessfully(){

        // ====== Control Panel ======
        blogsPage = basePage.openBlogs();
        blogsPage
                .clickAddButton()
                .enterArabicTitle(dataModel().Blogs.titleArabic)
                .enterEnglishTitle(dataModel().Blogs.titleEnglish)
                .selectCategoryTypeDDL(dataModel().Blogs.categoryTypeNews)
                .selectCategoryDDL(dataModel().Blogs.category)
                .enterArabicSections(dataModel().Blogs.sectionsAR)
                .enterEnglishSections(dataModel().Blogs.sectionsEN)
                .enterArabicContent(dataModel().Blogs.contentAR)
                .enterEnglishContent(dataModel().Blogs.contentEN)
                .enterArabicBrief(dataModel().Blogs.briefAR)
                .enterEnglishBrief(dataModel().Blogs.briefEN)
                .uploadImage(System.getProperty("user.dir")+ "/src/test/resources/images/" + dataModel().Blogs.image)
                .clickPublishBlog()
                .clickAddBlog();

        Assertions.myAssertTrue(
                basePage.isSuccessIconDisplayed()
                        && basePage.isSuccessMessageDisplayed(),
                "Success popup is not displayed correctly"
        );
        Assertions.myAssertEquals(
                basePage.getSuccessMessage(),
                "Created successfully"
        );

        blogsPage
                .closePopUpIcon()
                .searchInputs(dataModel().Blogs.titleEnglish);

        Assertions.myAssertEquals(
                basePage.getTableSearchResult(),
                dataModel().Blogs.titleEnglish);

        logoSrc = blogsPage.openBlogAndGetLogo();

        // ====== Website ======

        openWebsite();
        blogsWebPage = basePage.openBlogsWebsite();
        blogsWebPage
                .blogSearchInputs(dataModel().Blogs.titleEnglish);

        Assertions.myAssertEquals(
                blogsWebPage.getBlogTitle(),
                dataModel().Blogs.titleEnglish);

        Assertions.myAssertTrue(
                blogsWebPage.isBlogLogoDisplayed(logoSrc),
                "News is not displayed on website");
        blogsWebPage
                .openBlogDetails(logoSrc);

        Assertions.myAssertEquals(
                blogsWebPage.getBlogContent(),
                dataModel().Blogs.contentEN);

        // ====== Control Panel ======

        openAdmin();

     blogsPage = basePage.openBlogs();
        blogsPage
                .searchInputs(dataModel().Blogs.titleEnglish)
                .clickSearchResult()
                .clickEditBlog()
                .enterArabicTitle(dataModel().Blogs.editTitleArabic)
                .enterEnglishTitle(dataModel().Blogs.editTitleEnglish)
                .enterArabicSections(dataModel().Blogs.editSectionsAR)
                .enterEnglishSections(dataModel().Blogs.editSectionsEN)
                .enterArabicContent(dataModel().Blogs.editContentAR)
                .enterEnglishContent(dataModel().Blogs.editContentEN)
                .enterArabicBrief(dataModel().Blogs.editBriefAR)
                .enterEnglishBrief(dataModel().Blogs.editBriefEN)
                .uploadImage(System.getProperty("user.dir")+ "/src/test/resources/images/" + dataModel().Blogs.image)
                .clickSaveBlog();

        Assertions.myAssertTrue(
                basePage.isSuccessIconDisplayed()
                        && basePage.isSuccessMessageDisplayed(),
                "Success popup is not displayed correctly"
        );
        Assertions.myAssertEquals(
                basePage.getSuccessMessage(),
                "Updated successfully"
        );

        blogsPage
                .closePopUpIcon()
                .searchInputs(dataModel().Blogs.editTitleEnglish);

        Assertions.myAssertEquals(
                basePage.getTableSearchResult(),
                dataModel().Blogs.editTitleEnglish);

        logoSrc = blogsPage.openBlogAndGetLogo();

        // ====== Website ======

        openWebsite();
        blogsWebPage = basePage.openBlogsWebsite();
        blogsWebPage
                .blogSearchInputs(dataModel().Blogs.editTitleEnglish);

        Assertions.myAssertEquals(
                blogsWebPage.getBlogTitle(),
                dataModel().Blogs.editTitleEnglish);

        Assertions.myAssertTrue(
                blogsWebPage.isBlogLogoDisplayed(logoSrc),
                "News is not displayed on website");
        blogsWebPage
                .openBlogDetails(logoSrc);

        Assertions.myAssertEquals(
                blogsWebPage.getBlogContent(),
                dataModel().Blogs.editContentEN);

        // ====== Control Panel ======

        openAdmin();

        blogsPage = basePage.openBlogs();
        blogsPage
                .searchInputs(dataModel().Blogs.editTitleEnglish)
                .clickSearchResult()
                .clickEditBlog()
                .clickDeleteBlog()
                .clickConfirmDeleteBlog();

        Assertions.myAssertTrue(
                basePage.isSuccessIconDisplayed(),
                "Success popup is not displayed correctly"
        );
//        Assertions.myAssertEquals(
//                basePage.getSuccessMessage(),
//                "Deleted successfully"
//        );
//
        blogsPage
                .closePopUpIcon()
                .clearSearchInputs()
                .searchInputs(dataModel().Blogs.editTitleEnglish);

        Assertions.myAssertTrue(
                basePage.isNoDataMessageCorrect(),
                "No data message is not displayed after search"
        );

        // ====== Website ======

        openWebsite();
        blogsWebPage = basePage.openBlogsWebsite();
        blogsWebPage
                .blogSearchInputs(dataModel().Blogs.editTitleEnglish);;

        Assertions.myAssertTrue(
                blogsWebPage.isBlogLogoNotDisplayed(logoSrc),
                "News is still displayed on website ❌");

    }
    @Test(priority = 2)
    public void shouldAddEditAndDeleteArticlesSuccessfully(){

    // ====== Control Panel ======
    blogsPage = basePage.openBlogs();
    blogsPage
            .clickAddButton()
            .enterArabicTitle(dataModel().Blogs.titleArabic)
            .enterEnglishTitle(dataModel().Blogs.titleEnglish)
            .selectCategoryTypeDDL(dataModel().Blogs.categoryTypeArticle)
            .selectCategoryDDL(dataModel().Blogs.category)
            .enterArabicSections(dataModel().Blogs.sectionsAR)
            .enterEnglishSections(dataModel().Blogs.sectionsEN)
            .enterArabicContent(dataModel().Blogs.contentAR)
            .enterEnglishContent(dataModel().Blogs.contentEN)
            .enterArabicBrief(dataModel().Blogs.briefAR)
            .enterEnglishBrief(dataModel().Blogs.briefEN)
            .uploadImage(System.getProperty("user.dir")+ "/src/test/resources/images/" + dataModel().Blogs.image)
            .clickPublishBlog()
            .clickAddBlog();

    Assertions.myAssertTrue(
            basePage.isSuccessIconDisplayed()
                    && basePage.isSuccessMessageDisplayed(),
            "Success popup is not displayed correctly"
    );
    Assertions.myAssertEquals(
            basePage.getSuccessMessage(),
            "Created successfully"
    );

    blogsPage
            .closePopUpIcon()
            .searchInputs(dataModel().Blogs.titleEnglish);

    Assertions.myAssertEquals(
            basePage.getTableSearchResult(),
            dataModel().Blogs.titleEnglish);

    logoSrc = blogsPage.openBlogAndGetLogo();

    // ====== Website ======

    openWebsite();
    blogsWebPage = basePage.openBlogsWebsite();
    blogsWebPage
                .openArticlesTab()
                .blogSearchInputs(dataModel().Blogs.titleEnglish);

    Assertions.myAssertEquals(
            blogsWebPage.getBlogTitle(),
            dataModel().Blogs.titleEnglish);

    Assertions.myAssertTrue(
            blogsWebPage.isBlogLogoDisplayed(logoSrc),
            "News is not displayed on website");
    blogsWebPage
            .openBlogDetails(logoSrc);

    Assertions.myAssertEquals(
            blogsWebPage.getBlogContent(),
            dataModel().Blogs.contentEN);

    // ====== Control Panel ======

    openAdmin();

    blogsPage = basePage.openBlogs();
    blogsPage
            .searchInputs(dataModel().Blogs.titleEnglish)
            .clickSearchResult()
            .clickEditBlog()
            .enterArabicTitle(dataModel().Blogs.editTitleArabic)
            .enterEnglishTitle(dataModel().Blogs.editTitleEnglish)
            .enterArabicSections(dataModel().Blogs.editSectionsAR)
            .enterEnglishSections(dataModel().Blogs.editSectionsEN)
            .enterArabicContent(dataModel().Blogs.editContentAR)
            .enterEnglishContent(dataModel().Blogs.editContentEN)
            .enterArabicBrief(dataModel().Blogs.editBriefAR)
            .enterEnglishBrief(dataModel().Blogs.editBriefEN)
            .uploadImage(System.getProperty("user.dir")+ "/src/test/resources/images/" + dataModel().Blogs.image)
            .clickSaveBlog();

    Assertions.myAssertTrue(
            basePage.isSuccessIconDisplayed()
                    && basePage.isSuccessMessageDisplayed(),
            "Success popup is not displayed correctly"
    );
    Assertions.myAssertEquals(
            basePage.getSuccessMessage(),
            "Updated successfully"
    );

    blogsPage
            .closePopUpIcon()
            .searchInputs(dataModel().Blogs.editTitleEnglish);

    Assertions.myAssertEquals(
            basePage.getTableSearchResult(),
            dataModel().Blogs.editTitleEnglish);

    logoSrc = blogsPage.openBlogAndGetLogo();

    // ====== Website ======

    openWebsite();
    blogsWebPage = basePage.openBlogsWebsite();

    blogsWebPage
            .openArticlesTab()
            .blogSearchInputs(dataModel().Blogs.editTitleEnglish);

    Assertions.myAssertEquals(
            blogsWebPage.getBlogTitle(),
            dataModel().Blogs.editTitleEnglish);

    Assertions.myAssertTrue(
            blogsWebPage.isBlogLogoDisplayed(logoSrc),
            "News is not displayed on website");
    blogsWebPage
            .openBlogDetails(logoSrc);

    Assertions.myAssertEquals(
            blogsWebPage.getBlogContent(),
            dataModel().Blogs.editContentEN);

    // ====== Control Panel ======

    openAdmin();

    blogsPage = basePage.openBlogs();
    blogsPage
            .searchInputs(dataModel().Blogs.editTitleEnglish)
            .clickSearchResult()
            .clickEditBlog()
            .clickDeleteBlog()
            .clickConfirmDeleteBlog();

    Assertions.myAssertTrue(
            basePage.isSuccessIconDisplayed(),
            "Success popup is not displayed correctly"
    );
//        Assertions.myAssertEquals(
//                basePage.getSuccessMessage(),
//                "Deleted successfully"
//        );
//
    blogsPage
            .closePopUpIcon()
            .clearSearchInputs()
            .searchInputs(dataModel().Blogs.editTitleEnglish);

    Assertions.myAssertTrue(
            basePage.isNoDataMessageCorrect(),
            "No data message is not displayed after search"
    );

    // ====== Website ======

    openWebsite();
    blogsWebPage = basePage.openBlogsWebsite();
    blogsWebPage
            .openArticlesTab()
            .blogSearchInputs(dataModel().Blogs.editTitleEnglish);;

    Assertions.myAssertTrue(
            blogsWebPage.isBlogLogoNotDisplayed(logoSrc),
            "News is still displayed on website ❌");

}
}