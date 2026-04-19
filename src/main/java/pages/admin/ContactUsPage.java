package pages.admin;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.admin.Blogs.BlogsPage;
import pages.admin.DataEntry.ClientsPage;
import utilities.Waits;

import java.time.Duration;

public class ContactUsPage extends BasePage<ContactUsPage> {

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By contactUsPageTitle = By.cssSelector(".content-header h1[class*='page-title']");
    private final By contactUsPageDescription = By.cssSelector(".content-header p[class*='page-description']");
    private final By nameInput = By.cssSelector("input[autocomplete='name']");
    private final By emailInput = By.cssSelector("input[autocomplete='email']");
    private final By phoneInput = By.cssSelector("input[autocomplete='tel']");
    private final By requestDDL = By.xpath("(//div[@aria-haspopup='listbox'] //div[@class='v-field__input'])[1]");
    private final By requestTypeDDL = By.xpath("(//div[@aria-haspopup='listbox'] //div[@class='v-field__input'])[2]");
    private final By subjectInput = By.xpath("(//div[contains(@class,'v-row')] //input[@type='text'][@class='v-field__input'])[2]");
    private final By messageTextarea = By.cssSelector(".v-row textarea[class='v-field__input']");
    private final By submitBtn = By.cssSelector(".v-col button[type='submit']");
    private final By phoneTitle = By.xpath("//div[contains(@class,'v-container')] //p[.='Phone']");
    private final By phoneNum = By.xpath("//div[contains(@class,'v-container')]  //a[contains(@title,'(+966)')]");
    private final By mailTitle = By.xpath("//div[contains(@class,'v-container')] //p[.='Email']");
    private final By mailContent = By.xpath("//div[contains(@class,'v-container')]  //a[contains(@title,'@')]");
    private final By address = By.xpath("//div[contains(@class,'v-container')] //p[.='Address']");
    private final By addressContent = By.xpath("//div[contains(@class,'v-container')]  //a[contains(@title,'Riyadh, Saudi Arabia')]");
    private final By contactHeaderTitle  = By.xpath("//div[contains(@class,'v-container')]  //h3[.//span[text()='Get in Touch']]");
    private final By contactHeaderDescription = By.xpath("//div[contains(@class,'v-container')]  //p[contains(.,'Please fill out the form')]");
    private final By map = By.cssSelector(".maplibregl-map");

    // Fluent setters —

    @Step("Enter Contact Name")
    public ContactUsPage enterContactName(String name) {
        sendKeys(nameInput,name);
        return this;
    }

    @Step("Enter Contact Email")
    public ContactUsPage enterContactEmail(String name) {
        sendKeys(emailInput,name);
        return this;
    }

    @Step("Enter Contact Phone")
    public ContactUsPage enterContactPhone(String name) {
        sendKeys(phoneInput,name);
        return this;
    }

    @Step("Select Request DDL")
    public ContactUsPage selectRequestDDL(String value) {
        click(requestDDL);
        Actions actions = new Actions(driver);
        actions.sendKeys(value)
                .pause(Duration.ofMillis(500))
                .sendKeys(Keys.ESCAPE)
                .perform();
        return this;
    }

    @Step("Select Request Type DDL")
    public ContactUsPage selectRequestTypeDDL(String value) {
        click(requestTypeDDL);
        Actions actions = new Actions(driver);
        actions.sendKeys(value)
                .pause(Duration.ofMillis(500))
                .sendKeys(Keys.ESCAPE)
                .perform();
        return this;
    }

    @Step("Enter Contact Subject")
    public ContactUsPage enterContactSubject(String name) {
        sendKeys(subjectInput,name);
        return this;
    }

    @Step("Enter Contact Message")
    public ContactUsPage enterContactMessage(String name) {
        sendKeys(messageTextarea,name);
        return this;
    }

    @Step("Click Contact submit Button")
    public ContactUsPage clickSubmitButton() {
        click(submitBtn);
        return this;
    }


}

