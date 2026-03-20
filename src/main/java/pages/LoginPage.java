package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementActions;

public class LoginPage extends ElementActions {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By logo = By.cssSelector("img[src='/assets/logo_light.D0guCldj.svg'][class*='v-img__img']");
    private final By loginEmail = By.cssSelector("input[id*='input'][type='text']");
    private final By password = By.cssSelector("input[id*='input'][type='password']");
    private final By loginButton = By.cssSelector("button[type='submit'][class*='v-btn']");

    // Fluent setters — each returns `this` so calls can be chained
    @Step("Enter Email")
    public LoginPage enterEmail(String mail) {
        sendKeys(loginEmail, 10, mail);
        return this;
    }

    @Step("Enter Password")
    public LoginPage enterPassword(String passwordText) {
        sendKeys(password, 10, passwordText);
        return this;
    }

    @Step("Click Login Button")
    public BasePage clickLoginButton() {
        click(loginButton, 10);
        return new BasePage(driver);
    }

    @Step("Verify Logo")
    public boolean isLogoDisplayed() {
        return isDisplayed(logo, 10);
    }

}
