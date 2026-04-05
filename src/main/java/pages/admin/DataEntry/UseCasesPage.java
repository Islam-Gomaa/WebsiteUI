package pages.admin.DataEntry;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.admin.BasePage;

public class UseCasesPage extends BasePage<UseCasesPage> {

    public  UseCasesPage (WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By titleArabic = By.cssSelector("input[placeholder='Enter  title in arabic']");
    private final By titleEnglish = By.cssSelector("input[placeholder='Enter title in English']");
    private final By contentArabic = By.cssSelector("textarea[class='v-field__input'][placeholder='Enter content in AR']");
    private final By contentEnglish = By.cssSelector("textarea[class='v-field__input'][placeholder='Enter content in EN']");
    private final By imageInArabic = By.cssSelector("[type='imageUploader'][placeholder='Enter image in arabic'] input[type='file']");
    private final By imageInEnglish = By.cssSelector("[type='imageUploader'][placeholder='Enter image in english'] input[type='file']");

    // Fluent setters — each returns `this` so calls can be chained

    @Step("Enter Arabic Title")
    public UseCasesPage enterArabicTitle(String name) {
        getElement(titleArabic)
                .sendKeys(Keys.chord(Keys.CONTROL,"a"), Keys.DELETE);
        sendKeys(titleArabic,name);
        return this;
    }

    @Step("Enter English Title")
    public UseCasesPage enterEnglishTitle(String name) {
        getElement(titleEnglish)
                .sendKeys(Keys.chord(Keys.CONTROL,"a"), Keys.DELETE);
        sendKeys(titleEnglish,name);
        return this;
    }
    @Step("Enter Arabic Content")
    public UseCasesPage enterArabicContent(String name) {
        getElement(contentArabic)
                .sendKeys(Keys.chord(Keys.CONTROL,"a"), Keys.DELETE);
        sendKeys(contentArabic,name);
        return this;
    }

    @Step("Enter English Content")
    public UseCasesPage enterEnglishContent(String name) {
        getElement(contentEnglish)
                .sendKeys(Keys.chord(Keys.CONTROL,"a"), Keys.DELETE);
        sendKeys(contentEnglish,name);
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    @Step("Upload Arabic Image")
    public UseCasesPage uploadArabicImage(String filePath) {
        uploadFile(imageInArabic, filePath);
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    @Step("Upload English Image")
    public UseCasesPage uploadEnglishImage(String filePath) {
        uploadFile(imageInEnglish, filePath);
        return this;
    }


}
