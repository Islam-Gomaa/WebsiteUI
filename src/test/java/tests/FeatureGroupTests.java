package tests;

import base.BaseTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import utilities.AuthHelper;
import pages.DataEntry.FeatureGroupPage;
import utils.Assertions;

import static dataReader.ReadDataFromJson.dataModel;

public class FeatureGroupTests extends BaseTests {

    BasePage basePage;
    FeatureGroupPage featureGroupPage;

    @BeforeMethod
    public void login() {
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
                .clickEditFeature()
                .enterArabicName(dataModel().FeatureGroup.editNameAR)
                .enterEnglishName(dataModel().FeatureGroup.editNameEN)
                .clickSubmit();

        Assertions.myAssertTrue(
                featureGroupPage.isSuccessIconDisplayed()
                        && featureGroupPage.isSuccessMessageDisplayed(),
                "Success popup is not displayed correctly"
        );

        Assertions.myAssertEquals(
                featureGroupPage.getSuccessMessage(),
                "Updated successfully"
        );
    }

    @Test(priority = 4)
    public void verifyAfterEditFeatureGroupTest() {

        featureGroupPage = basePage.openFeatureGroup();
        featureGroupPage
                .searchInputs(dataModel().FeatureGroup.editNameEN);


        Assertions.myAssertEquals(
                featureGroupPage.getTableSearchResult(),
                dataModel().FeatureGroup.editNameEN
        );
    }

    @Test(priority = 5)
    public void deleteFeatureGroupTest() {

        featureGroupPage = basePage.openFeatureGroup();
        featureGroupPage
                .searchInputs(dataModel().FeatureGroup.editNameEN)
                .clickSearchResult()
                .clickDeleteFeature();

        Assertions.myAssertTrue(
                featureGroupPage.isSuccessIconDisplayed()
                        && featureGroupPage.isSuccessMessageDisplayed(),
                "Success popup is not displayed correctly"
        );

        Assertions.myAssertEquals(
                featureGroupPage.getSuccessMessage(),
                "Deleted successfully"
        );
    }
}


