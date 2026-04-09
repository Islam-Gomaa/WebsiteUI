package pages.admin.Blogs;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.admin.BasePage;
import pages.admin.DataEntry.PartnersPage;

import java.time.Duration;

public class BlogsPage extends BasePage<BlogsPage> {

    public BlogsPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By titleArabic = By.cssSelector("input[placeholder='Enter title in arabic']");
    private final By titleEnglish = By.cssSelector("input[placeholder='Enter title in english']");
    private final By categoryTypeDDL = By.xpath("(//div[@class='v-input__control']//div[@aria-haspopup='listbox'])[1]");
    private final By categoryDDL = By.xpath("(//div[@class='v-input__control']//div[@aria-haspopup='listbox'])[2]");
    private final By sectionsAR = By.cssSelector("input[placeholder='Enter sections in AR']");
    private final By sectionsEN = By.cssSelector("input[placeholder='Enter sections in EN']");
    private final By contentAR = By.cssSelector("textarea[placeholder='Enter content in AR']");
    private final By contentEN = By.cssSelector("textarea[placeholder='Enter content in EN']");
    private final By briefAR = By.cssSelector("textarea[placeholder='Enter brief in AR']");
    private final By briefEN = By.cssSelector("textarea[placeholder='Enter brief in EN']");
    private final By image = By.cssSelector("input[type='file']");
    private final By publishBlog = By.cssSelector("input[id*='checkbox'][aria-label='publish blog']");
    private final By addButton = By.cssSelector("[form='myForm'] button[type='submit']");
    private final By editButton = By.xpath("//button[.='Edit']");
    private final By saveButton = By.xpath("//button[.='Save']");
    private final By deleteButton = By.xpath("//button[.='Delete']");
    private final By confirmDeleteButton = By.xpath("//button[.='confirm']");
    private final By uploadedLogoName = By.cssSelector(".file-name");


    // Fluent setters — each returns `this` so calls can be chained

    @Step("Enter Arabic Title")
    public BlogsPage enterArabicTitle(String name) {
        sendKeys(titleArabic, name);
        return this;
    }

    @Step("Enter English Title")
    public BlogsPage enterEnglishTitle(String name) {
        sendKeys(titleEnglish,name);
        return this;
    }

    @Step("Select Category Type DDL")
    public BlogsPage selectCategoryTypeDDL(String value) {
        click(categoryTypeDDL);
        Actions actions = new Actions(driver);
        actions.sendKeys(value)
                .pause(Duration.ofMillis(500))
                .sendKeys(Keys.ESCAPE)
                .perform();
        return this;
    }

    @Step("Select Category DDL")
    public BlogsPage selectCategoryDDL(String value) {
        click(categoryDDL);
        Actions actions = new Actions(driver);
        actions.sendKeys(value)
                .pause(Duration.ofMillis(500))
                .sendKeys(Keys.ESCAPE)
                .perform();
        return this;
    }

    @Step("Enter Arabic Sections")
    public BlogsPage enterArabicSections(String name) {
        sendKeys(sectionsAR,name);
        return this;
    }

    @Step("Enter English Sections")
    public BlogsPage enterEnglishSections(String name) {
        sendKeys(sectionsEN,name);
        return this;
    }

    @Step("Enter Arabic Content")
    public BlogsPage enterArabicContent(String name) {
        sendKeys(contentAR,name);
        return this;
    }

    @Step("Enter English Content")
    public BlogsPage enterEnglishContent(String name) {
        sendKeys(contentEN,name);
        return this;
    }

    @Step("Enter Arabic Brief")
    public BlogsPage enterArabicBrief(String name) {
        sendKeys(briefAR,name);
        return this;
    }

    @Step("Enter English Brief")
    public BlogsPage enterEnglishBrief(String name) {
        sendKeys(briefEN,name);
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    @Step("Upload Image")
    public BlogsPage uploadImage(String filePath) {
        uploadFile(image, filePath);
        return this;
    }

    @Step("Click Publish Blog checkbox")
    public BlogsPage clickPublishBlog() {
            jsClick(publishBlog);
        return this;
    }

    @Step("Click Add Blog")
    public BlogsPage clickAddBlog() {
        click(addButton);
        return this;
    }

    @Step("Click Edit Blog")
    public BlogsPage clickEditBlog() {
        click(editButton);
        return this;
    }

    @Step("Click Save Blog")
    public BlogsPage clickSaveBlog() {
        click(saveButton);
        return this;
    }

    @Step("Click Delete Blog")
    public BlogsPage clickDeleteBlog() {
        click(deleteButton);
        return this;
    }

    @Step("Click Confirm  Delete Blog")
    public BlogsPage clickConfirmDeleteBlog() {
        click(confirmDeleteButton);
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

    @Step("Open blog and get logo")
    public String openBlogAndGetLogo() {
        clickSearchResult();
        return getUploadedLogoSrc();
    }

}
