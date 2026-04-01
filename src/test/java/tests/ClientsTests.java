package tests;

import base.BaseTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.admin.BasePage;
import pages.admin.DataEntry.ClientsPage;
import pages.website.HomePage;
import utilities.AuthHelper;
import utils.Assertions;

import static dataReader.ReadDataFromJson.dataModel;

public class ClientsTests extends BaseTests {

    BasePage basePage;
    ClientsPage clientsPage;
    HomePage homePage;

    private String logoSrc;

    @BeforeMethod
    public void setupAdminSession() {
        openAdmin();
        basePage = AuthHelper.login(driver);
    }

    @Test(priority = 1)
    public void addAndEditAndDeleteClient(){

        // ====== Control Panel ======
        clientsPage = basePage.openClients();
        clientsPage
                .clickAddButton()
                .enterArabicName(dataModel().Clients.nameAR)
                .enterEnglishName(dataModel().Clients.nameEN)
                .uploadLogo(System.getProperty("user.dir")+ "/src/test/resources/images/" + dataModel().Clients.logo)
                .clickSubmit();

        Assertions.myAssertTrue(basePage.isSuccessIconDisplayed() && basePage.isSuccessMessageDisplayed(), "Success popup is not displayed correctly");
        Assertions.myAssertEquals(basePage.getSuccessMessage(), "Created successfully");

        clientsPage
                .searchInputs(dataModel().Clients.nameEN);
        Assertions.myAssertEquals(basePage.getTableSearchResult(), dataModel().Clients.nameEN);
        logoSrc = clientsPage.openClientAndGetLogo();

        // ====== Website ======
        openWebsite();
        homePage = new HomePage(driver);
        Assertions.myAssertTrue(homePage.isClientLogoDisplayed(logoSrc), "Client is not displayed on website");

        // ====== Control Panel ======
        openAdmin();
        clientsPage = basePage.openClients();
        clientsPage
                .searchInputs(dataModel().Clients.nameEN)
                .clickSearchResult()
                .clickEditFeature()
                .enterArabicName(dataModel().Clients.editNameAR)
                .enterEnglishName(dataModel().Clients.editNameEN)
                .uploadLogo(System.getProperty("user.dir")+ "/src/test/resources/images/" + dataModel().Clients.logo)
                .clickSubmit();
        Assertions.myAssertTrue(basePage.isSuccessIconDisplayed() && basePage.isSuccessMessageDisplayed(), "Success popup is not displayed correctly");
        Assertions.myAssertEquals(basePage.getSuccessMessage(), "Updated successfully");

        clientsPage
                .clearSearchInputs()
                .searchInputs(dataModel().Clients.editNameEN);
        Assertions.myAssertEquals(basePage.getTableSearchResult(), dataModel().Clients.editNameEN);
//        logoSrc = clientsPage.openClientAndGetLogo();
//
//        // ====== Website ======
//        openWebsite();
//        homePage = new HomePage(driver);
//        Assertions.myAssertTrue(homePage.isClientLogoDisplayed(logoSrc), "Client is not displayed on website");

//        // ====== Control Panel ======
//        openAdmin();
//        clientsPage
//                .searchInputs(dataModel().Clients.editNameEN)
//                .clickSearchResult()
//                .clickDeleteFeature();
//        Assertions.myAssertTrue(basePage.isSuccessIconDisplayed() && basePage.isSuccessMessageDisplayed(), "Success popup is not displayed correctly");
//        Assertions.myAssertEquals(basePage.getSuccessMessage(), "Deleted successfully");
//
//        clientsPage
//                .searchInputs(dataModel().Clients.editNameEN);
//        Assertions.myAssertEquals(basePage.getNoDataAvailableMessage(), "No data available");
//
//        // ====== Website ======
//        openWebsite();
//        homePage = new HomePage(driver);
//        Assertions.myAssertTrue(homePage.isClientLogoNotDisplayed(logoSrc), "Client is still displayed on website");
//
    }
}


