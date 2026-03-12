package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementActions;

public class LandingPage extends ElementActions {

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By signUpAndLogin = By.linkText("Signup / Login");
    private final By logo = By.xpath("//img[@src='/static/images/home/logo.png']");

    @Step("Click Login Button")
    public LoginPage clickOnSignUpAndLoginButton() {
        click(signUpAndLogin, 5);
        return new LoginPage(driver);
    }

    @Step("Verify Logo")
    public boolean isLogoDisplayed() {
        return isDisplayed(logo, 5);
    }
}