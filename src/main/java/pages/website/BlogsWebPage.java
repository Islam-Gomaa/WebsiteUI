package pages.website;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.admin.BasePage;
import utilities.Waits;

import java.time.Duration;


public class BlogsWebPage extends BasePage<BlogsWebPage> {

    public BlogsWebPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By articlesTab = By.cssSelector("button[type='button'][value='1'].v-btn");
    private final By newsTab = By.cssSelector("button[type='button'][value='2'].v-btn");
    private final By searchInBlogs = By.cssSelector("input[placeholder='Search in Blogs']");
    private By blogLogo(String logoSrc) {
        return By.cssSelector("#main-content .post__cover img[src*='" + logoSrc + "']");
    }
    private final By blogTitle = By.cssSelector("#main-content .post__title");
    private final By blogContent = By.cssSelector(".sub-page .animation-item .section-reveal p");

    // Fluent setters — each returns `this` so calls can be chained

    @Step("Open News Tab")
    public BlogsWebPage openNewsTab() {
        Waits.waitForClickable(driver, newsTab);
        click(newsTab);
        return this;
    }

    @Step("Open Articles Tab")
    public BlogsWebPage openArticlesTab() {
        Waits.waitForClickable(driver, articlesTab);
        click(articlesTab);
        return this;
    }
    @Step("Open Blog details in website")
    public BlogsWebPage openBlogDetails(String logoSrc) {
        click(blogLogo(logoSrc));
        return this;
    }

    @Step("Search Inputs")
    public BlogsWebPage blogSearchInputs(String searchText) {
        Waits.waitForVisible(driver, searchInBlogs);
        sendKeys(searchInBlogs, searchText);
        Waits.waitForResultsToAppear(driver, blogTitle, 0);
        return this;
    }
    @Step("Verify blog title appeared")
    public boolean isBlogTitleDisplayed() {
        return getElement(blogTitle).isDisplayed();
    }

    @Step("Get Blog Title")
    public String getBlogTitle() {
        scrollToElement(blogTitle);
        Waits.waitForResultsToAppear(driver, blogTitle, 0);
        return getText(blogTitle);
    }

    @Step("Get Blog Brief")
    public String getBlogContent() {
        Waits.waitForResultsToAppear(driver, blogContent, 0);
        return getText(blogContent);
    }

    @Step("Verify logo appeared")
    public boolean isImageDisplayed(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(d -> !d.findElements(locator).isEmpty());
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Step("Verify Blog logo appeared")
    public boolean isBlogLogoDisplayed(String logoSrc) {
        return isImageDisplayed(blogLogo(logoSrc));
    }

    // Logo not appeared
    @Step("Verify image not appeared")
    public boolean isImageNotDisplayed(By locator) {
        return driver.findElements(locator).isEmpty();
    }

    @Step("Verify blog logo not appeared")
    public boolean isBlogLogoNotDisplayed(String logoSrc) {
        return isImageNotDisplayed(blogLogo(logoSrc));
    }

}
