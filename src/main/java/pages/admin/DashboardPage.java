package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementActions;

public class DashboardPage extends ElementActions {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private final By blogsTab = By.cssSelector("button[role='tab'][value='blog']");
    private final By productsTab = By.cssSelector("button[role='tab'][value='product']");
    private final By customersTab = By.cssSelector("button[role='tab'][value='client']");
    private final By articlesAndNewsCountTitle = By.cssSelector(".d-flex.flex-column > h5.font-weight-bold");
    private final By articlesAndNewsNumber = By.cssSelector(".d-flex.flex-column > h4.font-weight-bold");
    private final By  articlesByDate = By.cssSelector(".d-flex.align-center > h5.mb-3");
    private final By  highCharts = By.cssSelector(".highcharts-background");
}
