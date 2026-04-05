package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class Waits {

    private static final int DEFAULT_TIMEOUT = 10;
    private static final int POLLING = 500;

    // ================= WAIT BUILDER =================

    private static Wait<WebDriver> getWait(WebDriver driver) {
        return getWait(driver, DEFAULT_TIMEOUT);
    }

    private static Wait<WebDriver> getWait(WebDriver driver, int timeout) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(POLLING))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    // ================= VISIBILITY =================

    public static WebElement waitForVisible(WebDriver driver, By locator) {
        return getWait(driver).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForVisible(WebDriver driver, By locator, int timeout) {
        return getWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static List<WebElement> waitForAllVisible(WebDriver driver, By locator) {
        return getWait(driver).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static List<WebElement> waitForAllVisible(WebDriver driver, By locator, int timeout) {
        return getWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    // ================= CLICKABLE =================

    public static WebElement waitForClickable(WebDriver driver, By locator) {
        return getWait(driver).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForClickable(WebDriver driver, By locator, int timeout) {
        return getWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(locator));
    }

    // ================= PRESENCE =================

    public static WebElement waitForPresence(WebDriver driver, By locator) {
        return getWait(driver).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement waitForPresence(WebDriver driver, By locator, int timeout) {
        return getWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // ================= INVISIBILITY =================

    public static boolean waitForInvisibility(WebDriver driver, By locator) {
        return getWait(driver).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static boolean waitForInvisibility(WebDriver driver, By locator, int timeout) {
        return getWait(driver, timeout).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    // ================= TEXT =================

    public static boolean waitForTextToBe(WebDriver driver, By locator, String text) {
        return getWait(driver).until(ExpectedConditions.textToBe(locator, text));
    }

    // ================= ATTRIBUTE =================

    public static boolean waitForAttributeContains(WebDriver driver, By locator, String attribute, String value) {
        return getWait(driver).until(ExpectedConditions.attributeContains(locator, attribute, value));
    }

    // ================= ALERT =================

    public static Alert waitForAlert(WebDriver driver) {
        return getWait(driver).until(ExpectedConditions.alertIsPresent());
    }

    // ================= FRAME =================

    public static void waitForFrameAndSwitch(WebDriver driver, By locator) {
        getWait(driver).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    // ================= PAGE LOAD =================

    public static void waitForPageLoad(WebDriver driver) {
        getWait(driver).until(webDriver ->
                ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete")
        );
    }
}