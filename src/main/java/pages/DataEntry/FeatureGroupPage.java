package pages.DataEntry;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utilities.ElementActions;

public class FeatureGroupPage extends ElementActions {

    public FeatureGroupPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By addBtn = By.cssSelector("button[class*='bg-primary teleport v-btn--density-default'][type='button']");
    private final By nameArabic = By.xpath("(//form[@id='myForm']//input[@type='text'])[1]");
    private final By nameEnglish = By.xpath("(//form[@id='myForm']//input[@type='text'])[2]");
    private final By submitBtn = By.cssSelector("[form='myForm'] > button[type='submit']");
    private final By successIcon = By.cssSelector(".swal2-icon-content img");
    private final By successMessage = By.cssSelector(".swal2-title");
    private final By editBtn = By.cssSelector(".v-card-actions > .flex > div > div > button");
    private final By deleteBtn = By.cssSelector(".v-card-actions > .flex > div > div > button");


    // Fluent setters — each returns `this` so calls can be chained
    @Step("Click Add Feature Group Btn")
    public FeatureGroupPage clickAddButton() {
        click(addBtn,10);
        return this;
    }

    @Step("Enter Arabic Name")
    public FeatureGroupPage enterArabicName(String name) {
        clear(nameEnglish, 10);
        sendKeys(nameArabic,10,name);
        return this;
    }

    @Step("Enter English Name")
    public FeatureGroupPage enterEnglishName(String name) {
        clear(nameEnglish, 10);
        sendKeys(nameEnglish,10,name);
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    @Step("Click Submit Btn")
    public FeatureGroupPage clickSubmit() {
        click(submitBtn,10);
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    @Step("Click Edit Btn")
    public FeatureGroupPage clickEditFeature() {
        getElements(editBtn,10).get(0).click();
        return this;
    }

    @Step("Click Delete Btn")
    public FeatureGroupPage clickDeleteFeature() {
        getElements(deleteBtn,10).get(1).click();
        return this;
    }

    @Step("Verify success icon appeared")
    public boolean isSuccessIconDisplayed() {
        return getElement(successIcon,10).isDisplayed();
    }

    @Step("Verify success message appeared")
    public boolean isSuccessMessageDisplayed() {
        return getElement(successIcon,10).isDisplayed();
    }

    @Step("Get success message")
    public String getSuccessMessage() {
        return getText(successMessage,10);
    }



}

