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

    private String openClientAndGetLogo() {
        clientsPage.clickSearchResult();
        return clientsPage.getUploadedLogoSrc();
    }

    @BeforeMethod
    public void setupAdminSession() {
        openAdmin();
        basePage = AuthHelper.login(driver);
    }

    @Test(priority = 1)
    public void addClientTest(){

        // ====== Control Panel ======

        clientsPage = basePage.openClients();

        clientsPage
                .clickAddButton()
                .enterArabicName(dataModel().Clients.nameAR)
                .enterEnglishName(dataModel().Clients.nameEN)
                .uploadLogo(System.getProperty("user.dir")+ "/src/test/resources/images/" + dataModel().Clients.logo)
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

    @Test(priority = 2)
    public void verifyAfterAddClientTest() {

        // ====== Control Panel ======

        clientsPage = basePage.openClients();
        clientsPage
                .searchInputs(dataModel().Clients.nameEN);

        Assertions.myAssertEquals(
                basePage.getTableSearchResult(),
                dataModel().Clients.nameEN);

        logoSrc = openClientAndGetLogo();

        System.out.println("LOGO SRC = " + logoSrc);

        // ====== Website ======

        openWebsite();
        homePage = new HomePage(driver);

        Assertions.myAssertTrue(
                homePage.isImageDisplayed(logoSrc),
                "Client is not displayed on website");
    }

    @Test(priority = 3)
    public void editClientTest() {

        // ====== Control Panel ======

        clientsPage = basePage.openClients();
        clientsPage
                .searchInputs(dataModel().Clients.nameEN)
                .clickSearchResult()
                .clickEditFeature()
                .enterArabicName(dataModel().Clients.editNameAR)
                .enterEnglishName(dataModel().Clients.editNameEN)
                .uploadLogo(System.getProperty("user.dir")+ "/src/test/resources/images/" + dataModel().Clients.logo)
                .clickSubmit();

        Assertions.myAssertTrue(
                basePage.isSuccessIconDisplayed()
                        && basePage.isSuccessMessageDisplayed(),
                "Success popup is not displayed correctly"
        );
        Assertions.myAssertEquals(
                basePage.getSuccessMessage(),
                "Updated successfully"
        );
    }

    @Test(priority = 4)
    public void verifyAfterEditClientTest() {

        // ====== Control Panel ======

        clientsPage = basePage.openClients();
        clientsPage
                .searchInputs(dataModel().Clients.editNameEN);

        Assertions.myAssertEquals(
                basePage.getTableSearchResult(),
                dataModel().Clients.editNameEN);

        logoSrc = openClientAndGetLogo();

        System.out.println("LOGO SRC = " + logoSrc);

        // ====== Website ======

        openWebsite();
        homePage = new HomePage(driver);

        Assertions.myAssertTrue(
                homePage.isImageDisplayed(logoSrc),
                "Client is not displayed on website");
    }

    @Test(priority = 5)
    public void deleteClientTest() {

        // ====== Control Panel ======

        clientsPage = basePage.openClients();
        clientsPage
                .searchInputs(dataModel().Clients.editNameEN)
                .clickSearchResult()
                .clickDeleteFeature();

        Assertions.myAssertTrue(
                basePage.isSuccessIconDisplayed()
                        && basePage.isSuccessMessageDisplayed(),
                "Success popup is not displayed correctly"
        );
        Assertions.myAssertEquals(
                basePage.getSuccessMessage(),
                "Deleted successfully"
        );
    }

    @Test(priority = 6)
    public void verifyAfterDeleteClientTest() {

        // ====== Control Panel ======

        clientsPage = basePage.openClients();
        clientsPage
                .searchInputs(dataModel().Clients.editNameEN);


        Assertions.myAssertEquals(
                basePage.getNoDataAvailableMessage(),
                "No data available"
        );

        System.out.println("LOGO SRC = " + logoSrc);

        // ====== Website ======

        openWebsite();
        homePage = new HomePage(driver);

        Assertions.myAssertTrue(
                homePage.isImageNotDisplayed(logoSrc),
                "Client is still displayed on website ❌");
    }
}


