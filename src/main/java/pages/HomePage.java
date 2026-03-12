package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementActions;

public class HomePage extends ElementActions {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By loginUser = By.tagName("b");
    private final By logoutButton = By.linkText("Logout");

    @Step("Verify UserName")
    public String verifyUserName() {
        return getText(loginUser, 5);
    }

    @Step("Logout Method")
    public LandingPage logout() {
        click(logoutButton, 10);
        return new LandingPage(driver);
    }
}