package tests;

import base.BaseTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.admin.BasePage;
import pages.admin.Blogs.BlogsPage;
import pages.website.HomePage;
import utilities.AuthHelper;
import utils.Assertions;

import static dataReader.ReadDataFromJson.dataModel;

public class BlogsTests extends BaseTests {

    BasePage basePage;
    BlogsPage blogsPage;
    HomePage homePage;

    private String logoSrc;

//    private String openClientAndGetLogo() {
//        blogsPage.clickSearchResult();
//        return blogsPage.getUploadedLogoSrc();
//    }

    @BeforeMethod
    public void setupAdminSession() {
        openAdmin();
        basePage = AuthHelper.login(driver);
    }

    @Test(priority = 1)
    public void addNewsTest(){

        // ====== Control Panel ======

        blogsPage = basePage.openBlogs();

        blogsPage
                .clickAddButton()
                .enterArabicTitle(dataModel().Partners.nameAR)
                .enterEnglishTitle(dataModel().Partners.nameEN)
                .selectCategoryTypeDDL(dataModel().Partners.field)
                .selectCategoryDDL(dataModel().Partners.field)
                .enterArabicSections(dataModel().Partners.field)
                .enterEnglishSections(dataModel().Partners.field)
                .enterArabicContent(dataModel().Partners.field)
                .enterEnglishContent(dataModel().Partners.field)
                .enterArabicBrief(dataModel().Partners.field)
                .enterEnglishBrief(dataModel().Partners.field)
                .uploadImage(System.getProperty("user.dir")+ "/src/test/resources/images/" + dataModel().Partners.logo)
                .clickPublishBlog()
                .clickSubmit();

        Assertions.myAssertTrue(
                basePage.isSuccessIconDisplayed()
                        && basePage.isSuccessMessageDisplayed(),
                "Success popup is not displayed correctly"
        );
        Assertions.myAssertEquals(
                basePage.getSuccessMessage(),
                "Created successfully"
        );
    }

//    @Test(priority = 2)
//    public void verifyAfterAddNewsTest() {
//
//        // ====== Control Panel ======
//
//        blogsPage = basePage.openBlogs();
//        blogsPage
//                .searchInputs(dataModel().Partners.nameEN);
//
//        Assertions.myAssertEquals(
//                basePage.getTableSearchResult(),
//                dataModel().Partners.nameEN);
//
////        logoSrc = openClientAndGetLogo();
//
//        System.out.println("LOGO SRC = " + logoSrc);
//
//        // ====== Website ======
//
//        openWebsite();
//        homePage = new HomePage(driver);
//
//        Assertions.myAssertTrue(
//                homePage.isPartnerImageDisplayed(logoSrc),
//                "Client is not displayed on website");
//    }
//
//    @Test(priority = 3)
//    public void editNewsTest() {
//
//        // ====== Control Panel ======
//
//        blogsPage = basePage.openBlogs();
//        blogsPage
//                .searchInputs(dataModel().Partners.nameEN)
//                .clickSearchResult()
//                .clickEditFeature()
//                .enterArabicName(dataModel().Partners.editNameAR)
//                .enterEnglishName(dataModel().Partners.editNameEN)
//                .uploadLogo(System.getProperty("user.dir")+ "/src/test/resources/images/" + dataModel().Partners.logo)
//                .clickSubmit();
//
//        Assertions.myAssertTrue(
//                basePage.isSuccessIconDisplayed()
//                        && basePage.isSuccessMessageDisplayed(),
//                "Success popup is not displayed correctly"
//        );
//        Assertions.myAssertEquals(
//                basePage.getSuccessMessage(),
//                "Updated successfully"
//        );
//    }
//
//    @Test(priority = 4)
//    public void verifyAfterEditNewsTest() {
//
//        // ====== Control Panel ======
//
//        blogsPage = basePage.openBlogs();
//        blogsPage
//                .searchInputs(dataModel().Partners.editNameEN);
//
//        Assertions.myAssertEquals(
//                basePage.getTableSearchResult(),
//                dataModel().Partners.editNameEN);
//
//        logoSrc = openClientAndGetLogo();
//
//        System.out.println("LOGO SRC = " + logoSrc);
//
//        // ====== Website ======
//
//        openWebsite();
//        homePage = new HomePage(driver);
//
//        Assertions.myAssertTrue(
//                homePage.isPartnerImageDisplayed(logoSrc),
//                "Client is not displayed on website");
//    }
//
//    @Test(priority = 5)
//    public void deleteNewsTest() {
//
//        // ====== Control Panel ======
//
//        blogsPage = basePage.openBlogs();
//        blogsPage
//                .searchInputs(dataModel().Partners.editNameEN)
//                .clickSearchResult()
//                .clickDeleteFeature();
//
//        Assertions.myAssertTrue(
//                basePage.isSuccessIconDisplayed()
//                        && basePage.isSuccessMessageDisplayed(),
//                "Success popup is not displayed correctly"
//        );
//        Assertions.myAssertEquals(
//                basePage.getSuccessMessage(),
//                "Deleted successfully"
//        );
//    }
//
//    @Test(priority = 6)
//    public void verifyAfterDeleteNewsTest() {
//
//        // ====== Control Panel ======
//
//        blogsPage = basePage.openBlogs();
//        blogsPage
//                .searchInputs(dataModel().Partners.editNameEN);
//
//
//        Assertions.myAssertEquals(
//                basePage.getNoDataAvailableMessage(),
//                "No data available"
//        );
//
//        System.out.println("LOGO SRC = " + logoSrc);
//
//        // ====== Website ======
//
//        openWebsite();
//        homePage = new HomePage(driver);
//
//        Assertions.myAssertTrue(
//                homePage.isPartnerLogoNotDisplayed(logoSrc),
//                "The News is still displayed on website ❌");
//    }
}


