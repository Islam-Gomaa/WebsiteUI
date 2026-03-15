package tests;

import base.BaseTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.AuthHelper;
import pages.DataEntry.FeatureGroupPage;
import utils.Assertions;

import static dataReader.ReadDataFromJson.dataModel;

public class FeatureGroupTests extends BaseTests {

    String userName;
    HomePage homePage;
    LoginPage loginPage;
    FeatureGroupPage featureGroupPage;

    @BeforeMethod
    public void login() {

        homePage = AuthHelper.login(driver);

    }

    @Test
    public void createFeatureGroupTest() {

        featureGroupPage = homePage.openFeatureGroup();

        featureGroupPage
                .clickAddButton()
                .enterArabicName(dataModel().FeatureGroup.nameAr)
                .enterEnglishName(dataModel().FeatureGroup.nameEn)
                .clickSubmit();


        Assertions.myAssertTrue(
                featureGroupPage.isSuccessIconDisplayed()
                        && featureGroupPage.isSuccessMessageDisplayed(),
                "Success popup is not displayed correctly"
        );

        Assertions.myAssertEquals(
                featureGroupPage.getSuccessMessage(),
                "Created successfully"
        );
    }

    @Test
    public void editFeatureGroupTest() {

        featureGroupPage = homePage.openFeatureGroup();
        homePage
                .searchInputs(dataModel().FeatureGroup.nameAr)
                .clickSearchResult();

//        featureGroupPage
//                .clickEditFeature()
//                .enterArabicName(dataModel().FeatureGroup.editNameEn)
//                .enterEnglishName(dataModel().FeatureGroup.editNameEn)
//                .clickSubmit();
//
//        Assertions.myAssertTrue(
//                featureGroupPage.isSuccessIconDisplayed()
//                        && featureGroupPage.isSuccessMessageDisplayed(),
//                "Success popup is not displayed correctly"
//        );
//
//        Assertions.myAssertEquals(
//                featureGroupPage.getSuccessMessage(),
//                "Updated successfully"
//        );
    }

//    @Test
//    public void deleteFeatureGroupTest() {
//
//        featureGroupPage = homePage.openFeatureGroup();
//        homePage
//                .searchInputs(dataModel().FeatureGroup.editNameEn)
//                .clickSearchResult();
//
//        featureGroupPage
//                .clickDeleteFeature();
//
//        Assertions.myAssertTrue(
//                featureGroupPage.isSuccessIconDisplayed()
//                        && featureGroupPage.isSuccessMessageDisplayed(),
//                "Success popup is not displayed correctly"
//        );
//
//        Assertions.myAssertEquals(
//                featureGroupPage.getSuccessMessage(),
//                "Deleted successfully"
//        );
//    }
}


