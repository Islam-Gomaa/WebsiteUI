package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.DataEntry.*;
import utilities.ElementActions;

public class HomePage extends ElementActions {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By englishBtn = By.cssSelector("[class*='flex items-center']");
    private final By searchInputs =  By.cssSelector("[class='v-field__field'] > input[id*='input']");
    private final By dataTableSearchResult = By.cssSelector(".v-data-table__tbody > tr");
    private final By dataEntry = By.xpath("//span[normalize-space()='Data Entry']");
    private final By featureGroup = By.xpath("//span[normalize-space()='Feature Group']");
    private final By useCases = By.xpath("//span[normalize-space()='Use Cases']");
    private final By category = By.xpath("//span[normalize-space()='Category']");
    private final By clients = By.xpath("//span[normalize-space()='Clients']");
    private final By partners = By.xpath("//span[normalize-space()='Partners']");


    @Step("Change Language")
    public HomePage changeLanguage() {
        click(englishBtn, 10);
        return this;
    }

    @Step("Search Inputs")
    public HomePage searchInputs(String searchText) {
        getElement(searchInputs , 10).get(1).clear(searchInputs,10);
        sendKeys(searchInputs, 10, searchText);
        return this;
    }

    @Step("Click on search result ")
    public HomePage clickSearchResult() {
        click(dataTableSearchResult, 10);
        return this;
    }

    @Step("Open Feature Group Page")
    public FeatureGroupPage openFeatureGroup() {
        click(dataEntry,10);
        click(featureGroup,10);
        return new FeatureGroupPage(driver);
    }

    @Step("Open UseCases Page")
    public UseCasesPage openUseCases() {
        click(dataEntry,10);
        click(useCases,10);
        return new UseCasesPage(driver);
    }

    @Step("Open Category Page")
    public CategoryPage openCategory() {
        click(dataEntry,10);
        click(category,10);
        return new CategoryPage(driver);
    }

    @Step("Open Clients Page")
    public ClientsPage openClients() {
        click(dataEntry,10);
        click(clients,10);
        return new ClientsPage(driver);
    }

    @Step("Open Partners Page")
    public PartnersPage openPartners() {
        click(dataEntry,10);
        click(partners,10);
        return new PartnersPage(driver);
    }


}