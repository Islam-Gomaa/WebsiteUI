package tests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.admin.BasePage;
import pages.website.ContactUsWebPage;
import pages.website.HomePage;
import utilities.AuthHelper;
import utils.Assertions;

import static dataReader.ReadDataFromJson.dataModel;

public class ContactUsTests extends BaseTests {

    BasePage basePage;
    ContactUsWebPage contactUsWebPage;
    HomePage homePage;

    @Test(priority = 1)
    public void addAndDeleteSubscribesTest() {

        // ====== Website ======

        openWebsite();
        homePage = new HomePage(driver);
        contactUsWebPage = homePage.openContactUsWebsite();
        contactUsWebPage
//                .clickContactName()
                .enterContactName(dataModel().ContactUs.name)
                .enterContactEmail(dataModel().ContactUs.email)
                .enterContactPhone(dataModel().ContactUs.phone)
                .selectRequestDDL(dataModel().ContactUs.requestDDL)
                .selectRequestTypeDDL(dataModel().ContactUs.requestTypeDDL)
                .enterContactSubject(dataModel().ContactUs.subject)
                .enterContactMessage(dataModel().ContactUs.message)
                .clickSubmitButton();






//        Assertions.myAssertTrue(
//                homePage.isSubscribeIconOfButtonDisplayed(),"Subscribe button is not displayed");
//
//        Assertions.myAssertTrue(
//                homePage.isSubscribeTitleDisplayed(),"Subscribe title is not displayed");
//
//        Assertions.myAssertTrue(
//                homePage.isSubscribeDescriptionDisplayed(),"Subscribe description is not displayed");
//
//        homePage
//                .enterSubscribeEmail(dataModel().Subscribes.email)
//                .clickSubscribeBtn();
//
//        Assertions.myAssertTrue(
//                homePage.isSubscribedSuccessfullyMessageDisplayed(),"Subscribed Successfully message is not displayed");
//
//        // ====== Control Panel ======
//
//        openAdmin();
//        basePage = AuthHelper.login(driver);
//
//        contactUsWebPage = basePage.openSubscribers();
//        contactUsWebPage
//                .searchInputs(dataModel().Subscribes.email)
//                .clickSearchResult();
//
//        Assertions.myAssertEquals(
//                contactUsWebPage.getActualEmail(),dataModel().Subscribes.email,"Actual email is not displayed");
//
//        contactUsWebPage
//                .deleteSubscriber();
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
    }
}


