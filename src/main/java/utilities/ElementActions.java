package utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

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
        return Waits.waitForVisible(driver, locator, timeout);
    }

    protected List<WebElement> getElements(By locator, int timeout) {
        return Waits.waitForAllVisible(driver, locator, timeout);
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

    @Step("JS Click element")
    protected void jsClick(By locator, int timeout) {
        WebElement element = getElement(locator, timeout);
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

    @Step("Send text: {text}")
    protected void sendKeys(By locator, int timeout, String text) {

        WebElement element = getElement(locator, timeout);

        element.clear();
        element.sendKeys(text);
    }

    @Step("Send text and press Enter")
    protected void sendKeysAndEnter(By locator, int timeout, String text) {

        WebElement element = getElement(locator, timeout);

        element.clear();
        element.sendKeys(text + Keys.ENTER);
    }

    @Step("Clear field")
    protected void clear(By locator, int timeout) {
        getElement(locator, timeout).clear();
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

    @Step("Double click element")
    protected void doubleClick(By locator, int timeout) {
        actions.doubleClick(getElement(locator, timeout)).perform();
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

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                getElement(locator, timeout)
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
}