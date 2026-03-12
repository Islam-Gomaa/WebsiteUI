package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.DriverFactory;
import utilities.ConfigReader;

import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTests {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp(Method method) {

        System.out.println("Starting Test: " + method.getName());

        // create driver from configuration
        driver = DriverFactory.createDriver(ConfigReader.get("browser"));

        // maximize window
        driver.manage().window().maximize();

        // implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // open base url
        String url = ConfigReader.get("baseUrl");

        driver.get(url);

    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }

        System.out.println("Test Finished");

    }
}