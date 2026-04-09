package pages.admin.DataEntry;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.admin.BasePage;

import java.time.Duration;

public class PartnersPage extends BasePage<PartnersPage> {

    public PartnersPage (WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By nameArabic = By.cssSelector("input[placeholder='Enter Name (Arabic)']");
    private final By nameEnglish = By.cssSelector("input[placeholder='Enter Name (English)']");
    private final By fieldDDL = By.cssSelector(".v-input__control [aria-haspopup='listbox']");
    private final By logo = By.cssSelector("[type='imageUploader'][placeholder='Enter logo'] input[type='file']");
    private final By uploadedLogoName = By.cssSelector(".file-name");

    // Fluent setters — each returns `this` so calls can be chained
    @Step("Enter Arabic Name")
    public PartnersPage enterArabicName(String name) {
        sendKeys(nameArabic,name);
        return this;
    }

    @Step("Enter English Name")
    public PartnersPage enterEnglishName(String name) {
        sendKeys(nameEnglish,name);
        return this;
    }

    @Step("Select Field DDL")
    public PartnersPage selectFieldDDL(String value) {
        click(fieldDDL);
        Actions actions = new Actions(driver);
        actions.sendKeys(value)
                .pause(Duration.ofMillis(500))
                .sendKeys(Keys.ESCAPE)
                .perform();
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    @Step("Upload The Logo")
    public PartnersPage uploadLogo(String filePath) {
        uploadFile(logo, filePath);
        return this;
    }

    @Step("Get Logo Src")
    public String getUploadedLogoSrc() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(driver -> {
            try {
                WebElement el = driver.findElement(uploadedLogoName);
                String text = el.getText();
                return (text != null && !text.trim().isEmpty()) ? text.trim() : null;
            } catch (StaleElementReferenceException e) {
                return null;
            }
        });
    }
    @Step("Open partner and get logo")
    public String openPartnersAndGetLogo() {
        clickSearchResult();
        return getUploadedLogoSrc();
    }

}
