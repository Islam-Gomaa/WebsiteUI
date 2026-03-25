package pages.website;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.admin.BasePage;

import java.time.Duration;


public class HomePage extends BasePage<HomePage> {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By clientLogo(String logoSrc) {
        return By.cssSelector("[aria-label='Our Clients'] img[src*='" + logoSrc + "']");
    }

    // Fluent setters — each returns `this` so calls can be chained
    @Step("Verify client logo appeared")
    public boolean isImageDisplayed(String logoSrc) {
        By locator = clientLogo(logoSrc);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            return wait.until(driver -> !driver.findElements(locator).isEmpty());
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Step("Verify client logo not appeared")

    public boolean isImageNotDisplayed(String logoSrc) {
        By locator = clientLogo(logoSrc);
        return driver.findElements(locator).isEmpty();
    }
}
