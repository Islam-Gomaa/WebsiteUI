package tests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LandingPage;
import utils.Assertions;

import static dataReader.ReadDataFromJson.dataModel;

public class LoginTests extends BaseTests {

    String userName;
    HomePage homePage;
    LandingPage landingPage;

    @Test
    public void loginWithCorrectEmailAndPassword() {

        homePage = landingPage
                .clickOnSignUpAndLoginButton()
                .enterEmail(dataModel().Login.validCredentials.Email)
                .enterPassword(dataModel().Login.validCredentials.Password)
                .clickLoginButton();

        userName = homePage.verifyUserName();
        Assertions.myAssertEquals(userName, dataModel().Login.validCredentials.UserName);
    }

    @Test(dependsOnMethods = "loginWithCorrectEmailAndPassword")
    public void logout() {

        LandingPage landingPage = homePage.logout();
        Assertions.myAssertTrue(landingPage.isLogoDisplayed(), "Logo is not displayed");
    }
}
