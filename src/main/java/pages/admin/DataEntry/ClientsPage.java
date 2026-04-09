package pages.admin.DataEntry;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.admin.BasePage;

import java.time.Duration;

public class ClientsPage extends BasePage<ClientsPage> {

    public  ClientsPage (WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By nameArabic = By.cssSelector("input[placeholder='Enter Name (Arabic)']");
    private final By nameEnglish = By.cssSelector("input[placeholder='Enter Name (English)']");
    private final By logo = By.cssSelector("[type='imageUploader'][placeholder='Enter logo'] input[type='file']");
    private final By uploadedLogoName = By.cssSelector(".file-name");

    // Fluent setters — each returns `this` so calls can be chained
    @Step("Enter Arabic Name")
    public ClientsPage enterArabicName(String name) {
        sendKeys(nameArabic,name);
        return this;
    }

    @Step("Enter English Name")
    public ClientsPage enterEnglishName(String name) {
        sendKeys(nameEnglish,name);
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    @Step("Upload The Logo")
    public ClientsPage uploadLogo(String filePath) {
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

    @Step("Open client and get logo")
    public String openClientAndGetLogo() {
        clickSearchResult();
        return getUploadedLogoSrc();
    }

}
