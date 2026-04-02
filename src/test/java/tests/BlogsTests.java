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
//        // ====== Control Panel ======
//
//        clientsPage
//                .closePopUpIcon()
//                .searchInputs(dataModel().Clients.nameEN);
//
//        Assertions.myAssertEquals(
//                basePage.getTableSearchResult(),
//                dataModel().Clients.nameEN);
//
//        logoSrc = clientsPage.openClientAndGetLogo();
//
//        System.out.println("LOGO SRC = " + logoSrc);
//
//        // ====== Website ======
//
//        openWebsite();
//        homePage = new HomePage(driver);
//
//        Assertions.myAssertTrue(
//                homePage.isClientLogoDisplayed(logoSrc),
//                "Client is not displayed on website");
//
//        // ====== Control Panel ======
//
//        openAdmin();
//
//        clientsPage = basePage.openClients();
//        clientsPage
//                .searchInputs(dataModel().Clients.nameEN)
//                .clickSearchResult()
//                .clickEditFeature()
//                .enterArabicName(dataModel().Clients.editNameAR)
//                .enterEnglishName(dataModel().Clients.editNameEN)
//                .uploadLogo(System.getProperty("user.dir") + "/src/test/resources/images/" + dataModel().Clients.logo)
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
//
//        // ====== Control Panel ======
//
//        clientsPage
//                .closePopUpIcon()
//                .clearSearchInputs()
//                .searchInputs(dataModel().Clients.editNameEN);
//
//        Assertions.myAssertEquals(
//                basePage.getTableSearchResult(),
//                dataModel().Clients.editNameEN);
//
//        logoSrc = clientsPage.openClientAndGetLogo();
//
//        System.out.println("LOGO SRC = " + logoSrc);
//
//        // ====== Website ======
//
//        openWebsite();
//        homePage = new HomePage(driver);
//
//        Assertions.myAssertTrue(
//                homePage.isClientLogoDisplayed(logoSrc),
//                "Client is not displayed on website");
//
//        // ====== Control Panel ======
//
//        openAdmin();
//
//        clientsPage = basePage.openClients();
//        clientsPage
//                .clearSearchInputs()
//                .searchInputs(dataModel().Clients.editNameEN)
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
//
//        // ====== Control Panel ======
//
//        clientsPage
//                .closePopUpIcon()
//                .clearSearchInputs()
//                .searchInputs(dataModel().Clients.editNameEN);
//
//        Assertions.myAssertEquals(
//                basePage.getNoDataAvailableMessage(),
//                "No data available"
//        );
//
//        // ====== Website ======
//
//        openWebsite();
//        homePage = new HomePage(driver);
//
//        Assertions.myAssertTrue(
//                homePage.isClientLogoNotDisplayed(logoSrc),
//                "Client is still displayed on website ❌");
//
    }
}