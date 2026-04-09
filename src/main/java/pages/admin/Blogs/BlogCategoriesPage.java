package pages.admin.Blogs;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.admin.BasePage;

import java.time.Duration;

public class BlogCategoriesPage extends BasePage<BlogCategoriesPage> {

    public BlogCategoriesPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By titleArabic = By.cssSelector("input[placeholder='Enter Name (Arabic)']");
    private final By titleEnglish = By.cssSelector("input[placeholder='Enter Name (English)']");
    private final By descriptionArabic = By.cssSelector("textarea[type='textarea'][placeholder='Enter Description (Arabic)']");
    private final By descriptionEnglish = By.cssSelector("textarea[type='textarea'][placeholder='Enter Description (English)']");

    // Fluent setters — each returns `this` so calls can be chained

    @Step("Enter Arabic Title")
    public BlogCategoriesPage enterArabicTitle(String name) {
        sendKeys(titleArabic, name);
        return this;
    }

    @Step("Enter English Title")
    public BlogCategoriesPage enterEnglishTitle(String name) {
        sendKeys(titleEnglish,name);
        return this;
    }

    @Step("Enter Arabic Title")
    public BlogCategoriesPage enterDescriptionArabic(String name) {
        sendKeys(descriptionArabic, name);
        return this;
    }

    @Step("Enter English Title")
    public BlogCategoriesPage enterDescriptionEnglish(String name) {
        sendKeys(descriptionEnglish,name);
        return this;
    }


}
