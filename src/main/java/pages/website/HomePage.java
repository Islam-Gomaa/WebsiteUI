package pages.website;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.admin.BasePage;
import pages.admin.DataEntry.PartnersPage;

import java.time.Duration;


public class HomePage extends BasePage<HomePage> {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By clientLogo(String logoSrc) {
        return By.cssSelector("[aria-label='Our Clients'] img[src*='" + logoSrc + "']");
    }
    private By partnerLogo(String logoSrc) {
        return By.cssSelector(".position-relative [class='v-card-text py-0'] img[src*='" + logoSrc + "']");
    }

    // Locators of subscribes in footer
    private final By subscribeIcon  = By.xpath("//span[@class='v-btn__content']//span[.='Subscribe']");
    private final By subscribeBtn = By.cssSelector(".v-footer .btn-container button[type='submit']");
    private final By subscribeInput = By.cssSelector(".v-footer input[placeholder='Enter your email address']");
    private final By subscribeTitle = By.cssSelector(".v-footer .v-container .w-full h2");
    private final By subscribeDescription = By.cssSelector(".v-footer .v-container .w-full span[class*='text']");
    private final By subscribedSuccessfullyMessage = By.cssSelector("span[class=snackbar-message]");

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

    @Step("Verify Subscribe Icon of Button appeared")
    public boolean isSubscribeIconOfButtonDisplayed() {
        return getElement(subscribeIcon).isDisplayed();
    }

    @Step("Verify Subscribe to the Newsletter in footer appeared")
    public boolean isSubscribeTitleDisplayed() {
        return getElement(subscribeTitle).isDisplayed();
    }

    @Step("Verify subscribe Description in footer appeared")
    public boolean isSubscribeDescriptionDisplayed() {
        return getElement(subscribeDescription).isDisplayed();
    }

    @Step("Verify subscribe Description in footer appeared")
    public boolean isSubscribedSuccessfullyMessageDisplayed() {
        return getElement(subscribedSuccessfullyMessage).isDisplayed();
    }

    @Step("Enter Email Address for subscribers ")
    public HomePage enterSubscribeEmail(String name) {
        sendKeys(subscribeInput,name);
        return this;
    }
    @Step("Click subscribe Button ")
    public HomePage clickSubscribeBtn() {
        click(subscribeBtn);
        return this;
    }

}
