package pages.admin;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.admin.Blogs.BlogsPage;
import pages.website.ServicesAndSolutionsPage;
import pages.admin.DataEntry.*;
import utilities.ElementActions;

public class BasePage<T extends BasePage<T>> extends ElementActions {

    public BasePage(WebDriver driver){super(driver);}

    // Locators
    private final By englishBtn = By.cssSelector("[class*='flex items-center']");
    private final By searchInputs =  By.xpath("(//input[@placeholder='Search'])[2]");
    private final By clearSearchIcon = By.cssSelector(".mdi-close-circle[role='button']");
    private final By closePopUp = By.cssSelector("button[type='button'][aria-label='Close this dialog']");
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
    private final By blogs = By.xpath("//span[@class='ms-2 sub_link'][normalize-space()='Blogs'] ");
    private final By subBlogs = By.xpath("//span[@class='ms-3'][normalize-space()='Blogs'] ");
    private final By solutionsAndServices = By.cssSelector("a[aria-label='Solutions and Services'][class='link']");


    // Fluent setters

    @SuppressWarnings("unchecked")
    protected T self() {
        return (T) this;
    }

    @Step("Change Language")
    public T changeLanguage() {
        click(englishBtn);
        return self();
    }

    @Step("Search Inputs")
    public T searchInputs(String searchText) {
        clear(searchInputs);
        sendKeys(searchInputs, searchText);
        return self();
    }

    @Step("Clear Search Inputs")
    public T closePopUpIcon() {
        jsClick(closePopUp);
        return self();
    }

    @SuppressWarnings("UnusedReturnValue")
    @Step("Click on search result ")
    public T clickSearchResult() {
        click(dataTableSearchResult);
        return self();
    }
    @Step("Clear Search Inputs")
    public T clearSearchInputs() {
        jsClick(clearSearchIcon);
        return self();
    }

    @Step("Click Add Button")
    public T clickAddButton() {
        click(addBtn);
        return self();
    }

    @SuppressWarnings("UnusedReturnValue")
    @Step("Click Submit Btn")
    public T clickSubmit() {
        jsClick(submitBtn);
        return self();
    }

    @SuppressWarnings("UnusedReturnValue")
    @Step("Click Edit Btn")
    public T clickEdit() {
        getElements(editBtn).get(0).click();
        return self();
    }

    @Step("Get Item update")
    public String getTableSearchResult() {
        return getText(dataTableSearchResult);
    }

    @SuppressWarnings("UnusedReturnValue")
    @Step("Click Delete Btn")
    public void clickDelete() {
        getElements(deleteBtn).get(1).click();
    }

    @Step("Verify success icon appeared")
    public boolean isSuccessIconDisplayed() {
        return getElement(successIcon).isDisplayed();
    }

    @Step("Verify success message appeared")
    public boolean isSuccessMessageDisplayed() {
        return getElement(successIcon).isDisplayed();
    }

    @Step("Get success message")
    public String getSuccessMessage() {
        return getText(successMessage);
    }

    @Step("Get no data available message")
        public String getNoDataAvailableMessage() {
            return getText(noDataAvailableMessage);
    }

    @Step("Open Feature Group Page")
    public FeatureGroupPage openFeatureGroup() {
        click(dataEntry);
        click(featureGroup);
        return new FeatureGroupPage(driver);
    }

    @Step("Open UseCases Page")
    public UseCasesPage openUseCases() {
        click(dataEntry);
        click(useCases);
        return new UseCasesPage(driver);
    }

    @Step("Open Category Page")
    public CategoryPage openCategory() {
        click(dataEntry);
        click(category);
        return new CategoryPage(driver);
    }

    @Step("Open Clients Page")
    public ClientsPage openClients() {
        click(dataEntry);
        click(clients);
        return new ClientsPage(driver);
    }

    @Step("Open Partners Page")
    public PartnersPage openPartners() {
        click(dataEntry);
        click(partners);
        return new PartnersPage(driver);
    }

    @Step("Open Blogs Page")
    public BlogsPage openBlogs() {
        click(blogs);
        click(subBlogs);
        return new BlogsPage(driver);
    }

    // Website pages

    @Step("Open Services And Solutions Page")
    public ServicesAndSolutionsPage openServicesAndSolutions() {
        click(solutionsAndServices);
        return new ServicesAndSolutionsPage(driver);
    }

}