package pages.admin;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.website.ServicesAndSolutionsPage;
import pages.admin.DataEntry.*;
import utilities.ElementActions;

public class BasePage<T extends BasePage<T>> extends ElementActions {

    public BasePage(WebDriver driver){super(driver);}

    // Locators
    private final By englishBtn = By.cssSelector("[class*='flex items-center']");
    private final By searchInputs =  By.xpath("(//input[@placeholder='Search'])[2]");
    private final By dataTableSearchResult = By.xpath("//tbody[@class='v-data-table__tbody']/tr[1]/td[2]");
    private final By addBtn = By.cssSelector("#teleported-items .flex .v-btn");
    private final By submitBtn = By.cssSelector("button[form='myForm'][type='submit']");
    private final By successIcon = By.cssSelector(".swal2-icon-content img");
    private final By successMessage = By.cssSelector(".swal2-title");
    private final By editBtn = By.cssSelector(".v-card-actions .flex button");
    private final By deleteBtn = By.cssSelector(".v-card-actions .flex button");
    private final By noDataAvailableMessage = By.cssSelector(".v-data-table tr td .flex-col");

    // Page's locators
    private final By dataEntry = By.xpath("//span[normalize-space()='Data Entry']");
    private final By featureGroup = By.xpath("//span[normalize-space()='Feature Group']");
    private final By useCases = By.xpath("//span[normalize-space()='Use Cases']");
    private final By category = By.xpath("//span[normalize-space()='Category']");
    private final By clients = By.xpath("//span[normalize-space()='Clients']");
    private final By partners = By.xpath("//span[normalize-space()='Partners']");
    private final By solutionsAndServices = By.cssSelector("a[aria-label='Solutions and Services'][class='link']");


    // Fluent setters

    @SuppressWarnings("unchecked")
    protected T self() {
        return (T) this;
    }

    @Step("Change Language")
    public T changeLanguage() {
        click(englishBtn, 10);
        return self();
    }

    @Step("Search Inputs")
    public T searchInputs(String searchText) {
        clear(searchInputs);
        sendKeys(searchInputs , 10 , searchText);
        return self();
    }

    @SuppressWarnings("UnusedReturnValue")
    @Step("Click on search result ")
    public T clickSearchResult() {
        click(dataTableSearchResult, 10);
        return self();
    }

    @Step("Click Add Button")
    public T clickAddButton() {
        click(addBtn,10);
        return self();
    }

    @SuppressWarnings("UnusedReturnValue")
    @Step("Click Submit Btn")
    public T clickSubmit() {
        jsClick(submitBtn,10);
        return self();
    }

    @SuppressWarnings("UnusedReturnValue")
    @Step("Click Edit Btn")
    public T clickEditFeature() {
        getElements(editBtn,10).get(0).click();
        return self();
    }

    @Step("Get Item update")
    public String getTableSearchResult() {
        return getText(dataTableSearchResult,10);
    }

    @SuppressWarnings("UnusedReturnValue")
    @Step("Click Delete Btn")
    public void clickDeleteFeature() {
        getElements(deleteBtn,10).get(1).click();
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

    @Step("Get no data available message")
        public String getNoDataAvailableMessage() {
            return getText(noDataAvailableMessage,10);
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

    // Website pages

    @Step("Open Services And Solutions Page")
    public ServicesAndSolutionsPage openServicesAndSolutions() {
        click(solutionsAndServices,10);
        return new ServicesAndSolutionsPage(driver);
    }

}