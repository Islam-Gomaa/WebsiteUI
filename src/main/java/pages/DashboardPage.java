package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementActions;

public class DashboardPage extends ElementActions {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By blogsTab = By.cssSelector("button[role='tab'][value='blog']");
    private final By productsTab = By.cssSelector("button[role='tab'][value='product']");
    private final By customersTab = By.cssSelector("button[role='tab'][value='client']");

    private final By articlesAndNewsCountTitle = By.cssSelector(".d-flex.flex-column > h5.font-weight-bold");
    private final By articlesAndNewsNumber = By.cssSelector(".d-flex.flex-column > h4.font-weight-bold");

    private final By  articlesByDate = By.cssSelector(".d-flex.align-center > h5.mb-3");

    private final By  highCharts = By.cssSelector(".highcharts-background");




    private final By loginEmail = By.cssSelector("input[id*='input'][type='text']");
    private final By password = By.cssSelector("input[id*='input'][type='password']");
    private final By loginButton = By.cssSelector("button[type='submit'][class*='v-btn']");

    // Fluent setters — each returns `this` so calls can be chained
    @Step("Enter Email")
    public DashboardPage enterEmail(String mail) {
        sendKeys(loginEmail, 10, mail);
        return this;
    }

    @Step("Enter Password")
    public DashboardPage enterPassword(String passwordText) {
        sendKeys(password, 10, passwordText);
        return this;
    }

    @Step("Click Login Button")
    public HomePage clickLoginButton() {
        click(loginButton, 10);
        return new HomePage(driver);
    }

//    @Step("Verify Logo")
//    public boolean isLogoDisplayed() {
//        return isDisplayed(logo, 5);
//    }

}
