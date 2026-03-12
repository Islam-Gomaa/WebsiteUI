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
    private final By loginEmail = By.xpath("//input[@data-qa='login-email']");
    private final By password = By.xpath("//input[@data-qa='login-password']");
    private final By loginButton = By.xpath("//button[@data-qa='login-button']");

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
    public HomePage clickLoginButton() {
        click(loginButton, 10);
        return new HomePage(driver);
    }

}
