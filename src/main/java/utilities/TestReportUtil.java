package utilities;

import io.qameta.allure.Allure;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;

public class TestReportUtil {

    protected WebDriver driver;

    public TestReportUtil(WebDriver driver) {
        this.driver = driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenShot(Method method) {

        if (driver == null) return;

        byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment(
                method.getName() + " Screenshot",
                "image/png",
                new ByteArrayInputStream(screenshot),
                "png"
        );
    }

    public void setStatus(Method method, org.testng.ITestResult result) {

        if (driver == null) return;

        highlightElement();

        takeScreenShot(method);

        if (result.getStatus() == org.testng.ITestResult.FAILURE) {

            String reason = result.getThrowable() != null ?
                    result.getThrowable().getMessage() : "Unknown Error";

            Allure.addAttachment(
                    "Failure Reason",
                    new ByteArrayInputStream(reason.getBytes())
            );
        }
    }

    private void highlightElement() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                    "document.activeElement?.style.border='3px solid red'"
            );
        } catch (Exception ignored) {
        }
    }

}