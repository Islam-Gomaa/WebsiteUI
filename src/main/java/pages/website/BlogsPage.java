package pages.website;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.admin.BasePage;

import java.time.Duration;


public class BlogsPage extends BasePage<BlogsPage> {

    public BlogsPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By clientLogo(String logoSrc) {
        return By.cssSelector("[aria-label='Our Clients'] img[src*='" + logoSrc + "']");
    }
    private By partnerLogo(String logoSrc) {
        return By.cssSelector(".position-relative [class='v-card-text py-0'] img[src*='" + logoSrc + "']");
    }


    // Fluent setters — each returns `this` so calls can be chained

    // Logo appeared
    @Step("Verify logo appeared")
    public boolean isImageDisplayed(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            return wait.until(d -> !d.findElements(locator).isEmpty());
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Step("Verify client logo appeared")
    public boolean isClientLogoDisplayed(String logoSrc) {
        return isImageDisplayed(clientLogo(logoSrc));
    }

    @Step("Verify partner logo appeared")
    public boolean isPartnerImageDisplayed(String logoSrc) {
        return isImageDisplayed(partnerLogo(logoSrc));
    }

    // Logo not appeared
    @Step("Verify image not appeared")
    public boolean isImageNotDisplayed(By locator) {
        return driver.findElements(locator).isEmpty();
    }

    @Step("Verify client logo not appeared")
    public boolean isClientLogoNotDisplayed(String logoSrc) {
        return isImageNotDisplayed(clientLogo(logoSrc));
    }

    @Step("Verify partner logo not appeared")
    public boolean isPartnerLogoNotDisplayed(String logoSrc) {
        return isImageNotDisplayed(partnerLogo(logoSrc));
    }
}
