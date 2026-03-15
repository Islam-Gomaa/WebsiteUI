package utilities;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

import static dataReader.ReadDataFromJson.dataModel;

public class AuthHelper {

    public static HomePage login(WebDriver driver) {

        LoginPage loginPage = new LoginPage(driver);

        return loginPage
                .enterEmail(dataModel().Login.validCredentials.Email)
                .enterPassword(dataModel().Login.validCredentials.Password)
                .clickLoginButton()
                .changeLanguage();
    }
}
