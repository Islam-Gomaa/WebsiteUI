package tests;

import base.BaseTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.admin.BasePage;
import utilities.AuthHelper;
import pages.admin.DataEntry.FeatureGroupPage;
import utils.Assertions;

import static dataReader.ReadDataFromJson.dataModel;

public class FeatureGroupTests extends BaseTests {

    BasePage basePage;
    FeatureGroupPage featureGroupPage;

    @BeforeMethod
    public void setupAdminSession() {
        openAdmin();
        basePage = AuthHelper.login(driver);
    }

    @Test(priority = 1)
    public void createFeatureGroupTest() {

        featureGroupPage = basePage.openFeatureGroup();

        featureGroupPage
                .clickAddButton()
                .enterArabicName(dataModel().FeatureGroup.nameAR)
                .enterEnglishName(dataModel().FeatureGroup.nameEN)
                .clickSubmit();

        // assertion on control panel
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
    public void verifyAfterAddFeatureGroupTest() {

        featureGroupPage = basePage.openFeatureGroup();
        featureGroupPage
                .searchInputs(dataModel().FeatureGroup.nameEN);

        // assertion on control panel
        Assertions.myAssertEquals(
                basePage.getTableSearchResult(),
                dataModel().FeatureGroup.nameEN
        );
    }

    @Test(priority = 3)
    public void editFeatureGroupTest() {

        featureGroupPage = basePage.openFeatureGroup();
        featureGroupPage
                .searchInputs(dataModel().FeatureGroup.nameEN)
                .clickSearchResult()
                .clickEdit()
                .enterArabicName(dataModel().FeatureGroup.editNameAR)
                .enterEnglishName(dataModel().FeatureGroup.editNameEN)
                .clickSubmit();

        // assertion on control panel
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
    public void verifyAfterEditFeatureGroupTest() {

        featureGroupPage = basePage.openFeatureGroup();
        featureGroupPage
                .searchInputs(dataModel().FeatureGroup.editNameEN);

        // assertion on control panel
        Assertions.myAssertEquals(
                basePage.getTableSearchResult(),
                dataModel().FeatureGroup.editNameEN
        );
    }

    @Test(priority = 5)
    public void deleteFeatureGroupTest() {

        featureGroupPage = basePage.openFeatureGroup();
        featureGroupPage
                .searchInputs(dataModel().FeatureGroup.editNameEN)
                .clickSearchResult()
                .clickDelete();

        // assertion on control panel
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
    public void verifyAfterDeleteFeatureGroupTest() {

        featureGroupPage = basePage.openFeatureGroup();
        featureGroupPage
                .searchInputs(dataModel().FeatureGroup.editNameEN);

        // assertion on control panel
        Assertions.myAssertEquals(
                basePage.getNoDataAvailableMessage(),
                "No data available"
        );
    }
}


