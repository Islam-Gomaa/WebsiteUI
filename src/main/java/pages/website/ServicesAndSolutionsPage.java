package pages.website;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.admin.BasePage;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class ServicesAndSolutionsPage extends BasePage<ServicesAndSolutionsPage> {

    public ServicesAndSolutionsPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    public By categoryCard(String name) {
        return By.xpath("//span[.='" + name + "']");
    }

    public By subCategoryCard(String name) {
        return By.xpath("//li[.='" + name + "']");
    }

    public By productCard(String name) {
        return By.xpath("//span[.='" + name + "']");
    }

    public By productTitle(String name) {
        return By.xpath("//h2[.='" + name + "']");
    }

    private By categoryLogo(String logoSrc, String name) {
        return By.cssSelector("img[src*='" + logoSrc + "'][alt='" + name + "']");
    }

    private By subCategoryLogo(String logoSrc, String name) {
        return By.cssSelector("img[src*='" + logoSrc + "'][alt='" + name + "']");
    }

    private By productLogo(String logoSrc, String name) {
        return By.cssSelector("img[src*='" + logoSrc + "'][alt='" + name + "']");
    }

    public By productDescription(String name) {
        return By.cssSelector("[class*='head-info'] p");
    }

    public By groupTitle(String name) {
        return By.cssSelector("[class*='capitalize text-center'] h2");
    }


    // Fluent setters — each returns `this` so calls can be chained

    @Step("Open category card")
    public ServicesAndSolutionsPage openCategory(String name) {
        click(categoryCard(name));
        return new ServicesAndSolutionsPage(driver);
    }

    @Step("Open subCategory card")
    public ServicesAndSolutionsPage openSubCategory(String name) {
        click(subCategoryCard(name));
        return new ServicesAndSolutionsPage(driver);
    }

    @Step("Open product card")
    public ServicesAndSolutionsPage openProduct(String name) {
        click(productCard(name));
        return new ServicesAndSolutionsPage(driver);
    }

//    @Step("Verify main category appeared")
//    public boolean isElementDisplayed(Function<String, By> locatorFunction, String name) {
//        int maxScrolls = 10;
//        for (int i = 0; i < maxScrolls; i++) {
//
//            By locator = locatorFunction.apply(name);
//
//            if (isElementPresent(locator)) {
//                scrollToElement(locator);
//                return true;
//            }
//            scrollBy(0, 500);
//        }
//        return false;
//    }

    @Step("Verify logo appeared")
    public boolean isImageDisplayed(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(d -> !d.findElements(locator).isEmpty());
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Step("Verify category logo appeared")
    public boolean isCategoryLogoDisplayed(String logoSrc, String name) {
        return isImageDisplayed(categoryLogo(logoSrc, name));
    }

    @Step("Verify sub category logo appeared")
    public boolean isSubCategoryLogoDisplayed(String logoSrc, String name) {
        return isImageDisplayed(subCategoryLogo(logoSrc, name));
    }

    @Step("Verify product logo appeared")
    public boolean isProductLogoDisplayed(String logoSrc, String name) {
        return isImageDisplayed(productLogo(logoSrc, name));
    }

    // Logo not appeared
    @Step("Verify image not appeared")
    public boolean isImageNotDisplayed(By locator) {
        return driver.findElements(locator).isEmpty();
    }

    @Step("Verify category logo not appeared")
    public boolean isCategoryLogoNotDisplayed(String logoSrc , String name) {
        return isImageNotDisplayed(categoryLogo(logoSrc, name));
    }
    @Step("Verify category logo not appeared")
    public boolean isSubCategoryLogoNotDisplayed(String logoSrc , String name) {
        return isImageNotDisplayed(subCategoryLogo(logoSrc, name));
    }
    @Step("Verify category logo not appeared")
    public boolean isProductLogoNotDisplayed(String logoSrc , String name) {
        return isImageNotDisplayed(productLogo(logoSrc, name));
    }


}
