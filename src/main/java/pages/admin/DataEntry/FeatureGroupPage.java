package pages.admin.DataEntry;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.admin.BasePage;

public class FeatureGroupPage extends BasePage<FeatureGroupPage> {

    public FeatureGroupPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By nameArabic = By.xpath("(//form[@id='myForm']//input[@type='text'])[1]");
    private final By nameEnglish = By.xpath("(//form[@id='myForm']//input[@type='text'])[2]");

    // Fluent setters — each returns `this` so calls can be chained

    @Step("Enter Arabic Name")
    public FeatureGroupPage enterArabicName(String name) {
        getElement(nameArabic)
                .sendKeys(Keys.chord(Keys.CONTROL,"a"), Keys.DELETE);
        sendKeys(nameArabic,name);
        return this;
    }

    @Step("Enter English Name")
    public FeatureGroupPage enterEnglishName(String name) {
        getElement(nameEnglish)
                .sendKeys(Keys.chord(Keys.CONTROL,"a"), Keys.DELETE);
        sendKeys(nameEnglish,name);
        return this;
    }

}

