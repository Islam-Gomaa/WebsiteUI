package utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.List;

public class ElementActions {

    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected Actions actions;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);
    }

    // ================= ELEMENTS =================

    protected WebElement getElement(By locator, int timeout) {
        return Waits.waitForPresence(driver, locator, timeout);
    }

    protected List<WebElement> getElements(By locator, int timeout) {
        return Waits.waitForAllVisible(driver, locator, timeout);
    }

    protected boolean waitForElementShort(By locator, int timeout) {
        try {
            return waitForVisibility(locator, timeout).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private static Wait<WebDriver> buildWait(WebDriver driver, int timeout) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    protected WebElement waitForVisibility(By locator, int timeout) {
        return buildWait(driver, timeout)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForPresence(By locator, int timeout) {
        return buildWait(driver, timeout)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static List<WebElement> waitForAllVisible(WebDriver driver, By locator, int timeout) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static List<WebElement> waitForAllPresence(WebDriver driver, By locator, int timeout) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    @Step("Get elements count")
    protected int getElementsCount(By locator, int timeout) {

        return getElements(locator, timeout).size();
    }

    // ================= CLICK =================

    @Step("Click element")
    protected void click(By locator, int timeout) {
        Waits.waitForClickable(driver, locator, timeout).click();
    }

    @Step("Double Click element")
    protected void doubleClick(By locator, int timeout) {
        WebElement element = getElement(locator, timeout);
        actions.doubleClick(element).perform();
    }

    @Step("JS Click element")
    protected void jsClick(By locator, int timeout) {
        WebElement element = getElement(locator, timeout);
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        js.executeScript("arguments[0].click();", element);
    }

    @Step("Submit element")
    protected void submit(By locator, int timeout) {
        getElement(locator, timeout).submit();
    }

    @Step("Click element by index")
    protected void clickByIndex(By locator, int index, int timeout) {

        List<WebElement> elements = getElements(locator, timeout);

        if (index >= elements.size()) {
            throw new RuntimeException("Index out of bounds for locator: " + locator);
        }

        elements.get(index).click();
    }

    // ================= INPUT =================

    @Step("Send keys")
    protected void sendKeys(By locator, int timeout, CharSequence... keys) {
        WebElement element = getElement(locator, timeout);
        element.clear();
        element.sendKeys(keys);
    }

    @Step("Clear field")
    protected void clear(By locator) {
        getElement(locator, 10).clear();
    }


    @Step("Upload file: {filePath}")
    protected void uploadFile(By locator, String filePath) {

        WebElement element = getElement(locator, 10);

        element.sendKeys(filePath);
    }

    @Step("Select from searchable DDL")
    public void selectFromSearchableDDL(By locator, String value) {
        click(locator, 10);
        sendKeys(locator, 10, value);
        sendKeys(locator, 10, Keys.ESCAPE);
    }

    // ================= GET DATA =================

    @Step("Get element text")
    protected String getText(By locator, int timeout) {
        return getElement(locator, timeout).getText();
    }

    @Step("Get text by index")
    protected String getTextByIndex(By locator, int index, int timeout) {

        List<WebElement> elements = getElements(locator, timeout);

        if (index >= elements.size()) {
            throw new RuntimeException("Index out of bounds for locator: " + locator);
        }

        return elements.get(index).getText();
    }

    @Step("Get attribute")
    protected String getAttribute(By locator, int timeout, String attribute) {
        return getElement(locator, timeout).getAttribute(attribute);
    }

    @Step("Get CSS value")
    protected String getCssValue(By locator, int timeout, String css) {
        return getElement(locator, timeout).getCssValue(css);
    }

    @Step("Get tag name")
    protected String getTagName(By locator, int timeout) {
        return getElement(locator, timeout).getTagName();
    }

    // ================= BOOLEAN CHECKS =================

    @Step("Check element displayed")
    protected boolean isDisplayed(By locator, int timeout) {

        try {
            return getElement(locator, timeout).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Check element enabled")
    protected boolean isEnabled(By locator, int timeout) {
        return getElement(locator, timeout).isEnabled();
    }

    @Step("Check element selected")
    protected boolean isSelected(By locator, int timeout) {
        return getElement(locator, timeout).isSelected();
    }

    // ================= MOUSE ACTIONS =================

    @Step("Hover over element")
    protected void hover(By locator, int timeout) {

        actions.moveToElement(getElement(locator, timeout)).perform();
    }

    @Step("Right click element")
    protected void rightClick(By locator, int timeout) {
        actions.contextClick(getElement(locator, timeout)).perform();
    }

    @Step("Drag and drop")
    protected void dragAndDrop(By source, By target, int timeout) {
        actions.dragAndDrop(
                getElement(source, timeout),
                getElement(target, timeout)
        ).perform();
    }

    @Step("Click and hold")
    protected void clickAndHold(By locator, int timeout) {
        actions.clickAndHold(getElement(locator, timeout)).perform();
    }

    @Step("Release element")
    protected void release(By locator, int timeout) {
        actions.release(getElement(locator, timeout)).perform();
    }

    // ================= SCROLL =================

    @Step("Scroll to element")
    protected void scrollToElement(By locator, int timeout) {
        WebElement element = getElement(locator, timeout);

        js.executeScript(
                "arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});",
                element
        );
    }

    @Step("Scroll page by X,Y")
    protected void scrollBy(int x, int y) {
        js.executeScript("window.scrollBy(arguments[0],arguments[1]);", x, y);
    }

    @Step("Scroll to top")
    protected void scrollToTop() {
        js.executeScript("window.scrollTo(0,0)");
    }

    @Step("Scroll to bottom")
    protected void scrollToBottom() {
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    // ================= DEBUG =================

    @Step("Highlight element")
    protected void highlight(By locator, int timeout) {

        WebElement element = getElement(locator, timeout);

        js.executeScript(
                "arguments[0].style.border='3px solid red'",
                element
        );
    }

    // =============== VIEW ELEMENT ================

    @Step("Verify Is Element In Viewport")
    public boolean isElementInViewport(WebElement el) {

        Object result = ((JavascriptExecutor) driver).executeScript(
                "var rect = arguments[0].getBoundingClientRect();" +
                        "return (rect.top >= 0 && rect.left >= 0 && " +
                        "rect.bottom <= window.innerHeight && " +
                        "rect.right <= window.innerWidth);",
                el
        );

        return result != null && (Boolean) result;
    }

    @Step("Verify Is Element Partially In Viewport")
    public boolean isElementPartiallyInViewport(WebElement el) {
        return Boolean.TRUE.equals(
                ((JavascriptExecutor) driver).executeScript(
                        "var rect = arguments[0].getBoundingClientRect();" +
                                "return (rect.top < window.innerHeight && rect.bottom > 0);",
                        el
                )
        );
    }
}