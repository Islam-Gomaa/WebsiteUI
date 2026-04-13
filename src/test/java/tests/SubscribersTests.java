package tests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.admin.BasePage;
import pages.admin.SubscribesPage;
import pages.website.HomePage;
import utilities.AuthHelper;
import utils.Assertions;

import static dataReader.ReadDataFromJson.dataModel;

public class SubscribersTests extends BaseTests {

    BasePage basePage;
    SubscribesPage subscribesPage;
    HomePage homePage;

    @Test(priority = 1)
    public void addAndDeleteSubscribesTest() {

        // ====== Website ======

        openWebsite();
        homePage = new HomePage(driver);

        Assertions.myAssertTrue(
                homePage.isSubscribeIconOfButtonDisplayed(),"Subscribe button is not displayed");

        Assertions.myAssertTrue(
                homePage.isSubscribeTitleDisplayed(),"Subscribe title is not displayed");

        Assertions.myAssertTrue(
                homePage.isSubscribeDescriptionDisplayed(),"Subscribe description is not displayed");

        homePage
                .enterSubscribeEmail(dataModel().Subscribes.email)
                .clickSubscribeBtn();

        Assertions.myAssertTrue(
                homePage.isSubscribedSuccessfullyMessageDisplayed(),"Subscribed Successfully message is not displayed");


        // ====== Control Panel ======

        openAdmin();
        basePage = AuthHelper.login(driver);

        subscribesPage = basePage.openSubscribers();
        subscribesPage
                .searchInputs(dataModel().Subscribes.email)
                .clickSearchResult();

        Assertions.myAssertEquals(
                subscribesPage.getActualEmail(),dataModel().Subscribes.email,"Actual email is not displayed");

        subscribesPage
                .deleteSubscriber();

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
}


