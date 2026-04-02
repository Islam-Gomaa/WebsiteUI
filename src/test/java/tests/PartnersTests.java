package tests;

import base.BaseTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.admin.BasePage;
import pages.admin.DataEntry.PartnersPage;
import pages.website.HomePage;
import utilities.AuthHelper;
import utils.Assertions;

import static dataReader.ReadDataFromJson.dataModel;

public class PartnersTests extends BaseTests {

    BasePage basePage;
    PartnersPage partnersPage;
    HomePage homePage;

    private String logoSrc;

    @BeforeMethod
    public void setupAdminSession() {
        openAdmin();
        basePage = AuthHelper.login(driver);
    }

    @Test(priority = 1)
    public void shouldAddEditAndDeletePartnerSuccessfully() {

        // ====== Control Panel ======

        partnersPage = basePage.openPartners();

        partnersPage
                .clickAddButton()
                .enterArabicName(dataModel().Partners.nameAR)
                .enterEnglishName(dataModel().Partners.nameEN)
                .selectFieldDDL(dataModel().Partners.field)
                .uploadLogo(System.getProperty("user.dir") + "/src/test/resources/images/" + dataModel().Partners.logo)
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

        // ====== Control Panel ======

        partnersPage
                .closePopUpIcon()
                .searchInputs(dataModel().Partners.nameEN);

        Assertions.myAssertEquals(
                basePage.getTableSearchResult(),
                dataModel().Partners.nameEN);

        logoSrc = partnersPage.openPartnersAndGetLogo();

        System.out.println("LOGO SRC = " + logoSrc);

        // ====== Website ======

        openWebsite();
        homePage = new HomePage(driver);

        Assertions.myAssertTrue(
                homePage.isPartnerImageDisplayed(logoSrc),
                "Client is not displayed on website");

        // ====== Control Panel ======

        openAdmin();

        partnersPage = basePage.openPartners();
        partnersPage
                .searchInputs(dataModel().Partners.nameEN)
                .clickSearchResult()
                .clickEdit()
                .enterArabicName(dataModel().Partners.editNameAR)
                .enterEnglishName(dataModel().Partners.editNameEN)
                .uploadLogo(System.getProperty("user.dir") + "/src/test/resources/images/" + dataModel().Partners.logo)
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

        // ====== Control Panel ======

        partnersPage
                .closePopUpIcon()
                .clearSearchInputs()
                .searchInputs(dataModel().Partners.editNameEN);

        Assertions.myAssertEquals(
                basePage.getTableSearchResult(),
                dataModel().Partners.editNameEN);

        logoSrc = partnersPage.openPartnersAndGetLogo();

        System.out.println("LOGO SRC = " + logoSrc);

        // ====== Website ======

        openWebsite();
        homePage = new HomePage(driver);

        Assertions.myAssertTrue(
                homePage.isPartnerImageDisplayed(logoSrc),
                "Client is not displayed on website");

        // ====== Control Panel ======

        openAdmin();

        partnersPage = basePage.openPartners();
        partnersPage
                .clearSearchInputs()
                .searchInputs(dataModel().Partners.editNameEN)
                .clickSearchResult()
                .clickDelete();

        Assertions.myAssertTrue(
                basePage.isSuccessIconDisplayed()
                        && basePage.isSuccessMessageDisplayed(),
                "Success popup is not displayed correctly"
        );
        Assertions.myAssertEquals(
                basePage.getSuccessMessage(),
                "Deleted successfully"
        );

        // ====== Control Panel ======

        partnersPage
                .closePopUpIcon()
                .clearSearchInputs()
                .searchInputs(dataModel().Partners.editNameEN);

        Assertions.myAssertEquals(
                basePage.getNoDataAvailableMessage(),
                "No data available"
        );

        // ====== Website ======

        openWebsite();
        homePage = new HomePage(driver);

        Assertions.myAssertTrue(
                homePage.isPartnerLogoNotDisplayed(logoSrc),
                "Partner is still displayed on website ❌");

    }
}






