package utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

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

    protected WebElement getElement(By locator) {
        return Waits.waitForPresence(driver, locator);
    }

    protected List<WebElement> getElements(By locator) {
        return Waits.waitForAllVisible(driver, locator);
    }

    protected boolean isElementDisplayed(By locator) {
        try {
            return Waits.waitForVisible(driver, locator).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    protected WebElement waitForVisibility(By locator) {
        return Waits.waitForVisible(driver, locator);
    }

    protected WebElement waitForPresence(By locator) {
        return Waits.waitForPresence(driver, locator);
    }

    @Step("Get elements count")
    protected int getElementsCount(By locator) {
        return getElements(locator).size();
    }

    // ================= CLICK =================

    @Step("Click element")
    protected void click(By locator) {
        Waits.waitForClickable(driver, locator).click();
    }

    @Step("Double Click element")
    protected void doubleClick(By locator) {
        WebElement element = getElement(locator);
        actions.doubleClick(element).perform();
    }

    @Step("JS Click element")
    protected void jsClick(By locator) {
        WebElement element = getElement(locator);
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        js.executeScript("arguments[0].click();", element);
    }

    @Step("Submit element")
    protected void submit(By locator) {
        getElement(locator).submit();
    }

    @Step("Click element by index")
    protected void clickByIndex(By locator, int index) {
        List<WebElement> elements = getElements(locator);

        if (index >= elements.size()) {
            throw new RuntimeException("Index out of bounds for locator: " + locator);
        }

        elements.get(index).click();
    }

// ================= INPUT =================

    @Step("Send keys")
    protected void sendKeys(By locator, CharSequence... keys) {
        WebElement element = getElement(locator);
        element.clear();
        element.sendKeys(keys);
    }

    @Step("Clear field")
    protected void clear(By locator) {
        getElement(locator).clear();
    }

    @Step("Upload file: {filePath}")
    protected void uploadFile(By locator, String filePath) {
        WebElement element = getElement(locator);
        element.sendKeys(filePath);
    }

    @Step("Select from searchable DDL")
    public void selectFromSearchableDDL(By locator, String value) {
        click(locator);
        sendKeys(locator, value);
        sendKeys(locator, Keys.ESCAPE);
    }

    // ================= GET DATA =================

    @Step("Get element text")
    protected String getText(By locator) {
        return getElement(locator).getText();
    }

    @Step("Get text by index")
    protected String getTextByIndex(By locator, int index) {

        List<WebElement> elements = getElements(locator);

        if (index >= elements.size()) {
            throw new RuntimeException("Index out of bounds for locator: " + locator);
        }

        return elements.get(index).getText();
    }

    @Step("Get attribute")
    protected String getAttribute(By locator, String attribute) {
        return getElement(locator).getAttribute(attribute);
    }

    @Step("Get CSS value")
    protected String getCssValue(By locator, String css) {
        return getElement(locator).getCssValue(css);
    }

    @Step("Get tag name")
    protected String getTagName(By locator) {
        return getElement(locator).getTagName();
    }

// ================= BOOLEAN CHECKS =================

    @Step("Check element displayed")
    protected boolean isDisplayed(By locator) {
        try {
            return getElement(locator).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @Step("Check element enabled")
    protected boolean isEnabled(By locator) {
        return getElement(locator).isEnabled();
    }

    @Step("Check element selected")
    protected boolean isSelected(By locator) {
        return getElement(locator).isSelected();
    }

// ================= MOUSE ACTIONS =================

    @Step("Hover over element")
    protected void hover(By locator) {
        actions.moveToElement(getElement(locator)).perform();
    }

    @Step("Right click element")
    protected void rightClick(By locator) {
        actions.contextClick(getElement(locator)).perform();
    }

    @Step("Drag and drop")
    protected void dragAndDrop(By source, By target) {
        actions.dragAndDrop(
                getElement(source),
                getElement(target)
        ).perform();
    }

    @Step("Click and hold")
    protected void clickAndHold(By locator) {
        actions.clickAndHold(getElement(locator)).perform();
    }

    @Step("Release element")
    protected void release(By locator) {
        actions.release(getElement(locator)).perform();
    }

// ================= SCROLL =================

    @Step("Scroll to element")
    protected void scrollToElement(By locator) {
        WebElement element = getElement(locator);

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
    protected void highlight(By locator) {

        WebElement element = getElement(locator);

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