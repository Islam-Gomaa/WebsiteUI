package pages.admin;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubscribesPage extends BasePage<SubscribesPage> {

    public SubscribesPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By deleteButton = By.cssSelector(".v-card-actions .flex button");
    private final By emailField = By.cssSelector("#myForm .v-row .field[value*='.com']");


    // Fluent setters —
    @Step("Delete Subscriber user")
    public SubscribesPage deleteSubscriber() {
        click(deleteButton);
        return this;
    }

    @Step("Get Actual Email ")
    public String getActualEmail() {
        return getAttribute(emailField, "value");
    }


}

