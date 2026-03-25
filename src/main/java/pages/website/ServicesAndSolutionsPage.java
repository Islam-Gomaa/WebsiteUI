package pages.website;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.admin.BasePage;

public class ServicesAndSolutionsPage extends BasePage<ServicesAndSolutionsPage> {

    public ServicesAndSolutionsPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By categoryCard(String name) {
        return By.xpath("//a[contains(@class,'service-card')][.//span[normalize-space()='" + name + "']]");
    }

    // Fluent setters — each returns `this` so calls can be chained

    @Step("Verify main category appeared")
    public boolean isCategoryDisplayed(String name) {
        By locator = categoryCard(name);
        int maxScrolls = 10;
        for (int i = 0; i < maxScrolls; i++) {
            if (waitForElementShort(locator, 2)) {
                scrollToElement(locator, 5);
                return isDisplayed(locator, 5);
            }
            scrollBy(0, 500);
        }
        return false;
    }

}
