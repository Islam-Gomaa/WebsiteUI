package pages.admin.Blogs;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.admin.BasePage;
import pages.admin.DataEntry.PartnersPage;

import java.time.Duration;

public class BlogsPage extends BasePage<BlogsPage> {

    public BlogsPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By titleArabic = By.cssSelector("input[placeholder='Enter  title in arabic']");
    private final By titleEnglish = By.cssSelector("input[placeholder='Enter title in English']");
    private final By categoryTypeDDL = By.cssSelector("textarea[class='v-field__input'][placeholder='Enter description in AR']");
    private final By categoryDDL = By.cssSelector("textarea[class='v-field__input'][placeholder='Enter description in EN']");
    private final By sectionsAR = By.cssSelector("[type='select'][updatekey='parent.id'] .v-input .v-input__control");
    private final By sectionsEN = By.cssSelector("[updatekey='parent.id'] .v-input__control [role='combobox'] .v-field__input");
    private final By contentAR = By.cssSelector("[type='imageUploader'] input[type='file']");
    private final By contentEN = By.cssSelector("input[placeholder='Enter title in arabic']");
    private final By briefAR = By.cssSelector("input[class='v-field__input'][placeholder='Enter Description (Arabic)']");
    private final By briefEN = By.cssSelector("input[class='v-field__input'][placeholder='Enter Description (English)']");
    private final By image = By.cssSelector("input[placeholder='Enter keywords']");
    private final By publishBlog = By.cssSelector("input[placeholder='Enter keywords']");




    // Fluent setters — each returns `this` so calls can be chained

    @Step("Enter Arabic Title")
    public BlogsPage enterArabicTitle(String name) {
        getElement(titleArabic,10)
                .sendKeys(Keys.chord(Keys.CONTROL,"a"), Keys.DELETE);
        sendKeys(titleArabic,10,name);
        return this;
    }

    @Step("Enter English Title")
    public BlogsPage enterEnglishTitle(String name) {
        getElement(titleEnglish,10)
                .sendKeys(Keys.chord(Keys.CONTROL,"a"), Keys.DELETE);
        sendKeys(titleEnglish,10,name);
        return this;
    }

    @Step("Select Category Type DDL")
    public BlogsPage selectCategoryTypeDDL(String value) {
        click(categoryTypeDDL, 50);
        Actions actions = new Actions(driver);
        actions.sendKeys(value)
                .pause(Duration.ofMillis(500))
                .sendKeys(Keys.ESCAPE)
                .perform();
        return this;
    }

    @Step("Select Category DDL")
    public BlogsPage selectCategoryDDL(String value) {
        click(categoryDDL, 50);
        Actions actions = new Actions(driver);
        actions.sendKeys(value)
                .pause(Duration.ofMillis(500))
                .sendKeys(Keys.ESCAPE)
                .perform();
        return this;
    }

    @Step("Enter Arabic Sections")
    public BlogsPage enterArabicSections(String name) {
        getElement(sectionsAR,10)
                .sendKeys(Keys.chord(Keys.CONTROL,"a"), Keys.DELETE);
        sendKeys(sectionsAR,10,name);
        return this;
    }

    @Step("Enter English Sections")
    public BlogsPage enterEnglishSections(String name) {
        getElement(sectionsEN,10)
                .sendKeys(Keys.chord(Keys.CONTROL,"a"), Keys.DELETE);
        sendKeys(sectionsEN,10,name);
        return this;
    }


    @Step("Enter Arabic Content")
    public BlogsPage enterArabicContent(String name) {
        getElement(contentAR,10)
                .sendKeys(Keys.chord(Keys.CONTROL,"a"), Keys.DELETE);
        sendKeys(contentAR,10,name);
        return this;
    }

    @Step("Enter English Content")
    public BlogsPage enterEnglishContent(String name) {
        getElement(contentEN,10)
                .sendKeys(Keys.chord(Keys.CONTROL,"a"), Keys.DELETE);
        sendKeys(contentEN,10,name);
        return this;
    }

    @Step("Enter Arabic Brief")
    public BlogsPage enterArabicBrief(String name) {
        getElement(briefAR,10)
                .sendKeys(Keys.chord(Keys.CONTROL,"a"), Keys.DELETE);
        sendKeys(briefAR,10,name);
        return this;
    }

    @Step("Enter English Brief")
    public BlogsPage enterEnglishBrief(String name) {
        getElement(briefEN,10)
                .sendKeys(Keys.chord(Keys.CONTROL,"a"), Keys.DELETE);
        sendKeys(briefEN,10,name);
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    @Step("Upload Image")
    public BlogsPage uploadImage(String filePath) {
        uploadFile(image, filePath);
        return this;
    }

    @Step("Enter keywords")
    public BlogsPage enterKeyWords() {
            click(publishBlog, 10);
        return this;
    }

}
