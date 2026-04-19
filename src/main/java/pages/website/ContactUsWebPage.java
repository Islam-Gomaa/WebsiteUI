package pages.website;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.admin.BasePage;
import utilities.Waits;

import java.time.Duration;
import java.util.List;

public class ContactUsWebPage extends BasePage<ContactUsWebPage> {

    public ContactUsWebPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By contactUsPageTitle = By.cssSelector(".content-header h1[class*='page-title']");
    private final By contactUsPageDescription = By.cssSelector(".content-header p[class*='page-description']");
    private final By nameInput = By.xpath("//div[@class='v-field__field'] //label[.='Name']");
    private final By emailInput = By.xpath("(//div[@class='v-field__field'] //input[@type='text'])[2]");
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

    @Step("Click Contact Name")
    public ContactUsWebPage clickContactName() {
        click(nameInput);
        return this;
    }

    @Step("Enter Contact Name")
    public ContactUsWebPage enterContactName(String name) {
        sendKeys(nameInput,name);
        return this;
    }

    @Step("Enter Contact Email")
    public ContactUsWebPage enterContactEmail(String name) {
        sendKeys(emailInput,name);
        return this;
    }

    @Step("Enter Contact Phone")
    public ContactUsWebPage enterContactPhone(String name) {
        sendKeys(phoneInput,name);
        return this;
    }

    @Step("Select Request DDL")
    public ContactUsWebPage selectRequestDDL(String value) {
            click(requestDDL);

            Actions actions = new Actions(driver);
            Waits.waitForAllVisible(driver, requestDDL);

            List<WebElement> allOptions = driver.findElements(requestDDL);

            for (int i = 0; i < allOptions.size(); i++) {

                String currentText = allOptions.get(i).getText().trim();

                if (currentText.equalsIgnoreCase(value)) {
                    actions.sendKeys(Keys.ENTER).perform();
                    return this;
                }

                actions.sendKeys(Keys.ARROW_DOWN).perform();
            }

            throw new RuntimeException("Value not found in dropdown: " + value);
        }
    @Step("Select Request Type DDL")
        public ContactUsWebPage selectRequestTypeDDL(String value) {
            click(requestDDL);

            Actions actions = new Actions(driver);

            for (int i = 0; i < 5; i++) {

                String currentText = driver.switchTo().activeElement().getText().trim();

                if (currentText.equalsIgnoreCase(value)) {
                    actions.sendKeys(Keys.ENTER).perform();
                    return this;
                }

                actions.sendKeys(Keys.ARROW_DOWN).perform();
            }

            throw new RuntimeException("Value not found: " + value);
        }

    @Step("Enter Contact Subject")
    public ContactUsWebPage enterContactSubject(String name) {
        sendKeys(subjectInput,name);
        return this;
    }

    @Step("Enter Contact Message")
    public ContactUsWebPage enterContactMessage(String name) {
        sendKeys(messageTextarea,name);
        return this;
    }

    @Step("Click Contact submit Button")
    public ContactUsWebPage clickSubmitButton() {
        click(submitBtn);
        return this;
    }


}

