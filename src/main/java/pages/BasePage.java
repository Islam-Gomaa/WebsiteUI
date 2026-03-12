package pages;

import org.openqa.selenium.WebDriver;
import utilities.*;

public class BasePage extends ElementActions {

    protected WebDriver driver;

//    protected DropdownActions dropdown;
//    protected AlertUtil alerts;
//    protected FrameUtil frames;
//    protected ScrollUtil scroll;
//    protected ScreenshotUtil screenshot;

    public BasePage(WebDriver driver){

        super(driver);

        this.driver = driver;

//        dropdown = new DropdownActions(driver);
//        alerts = new AlertUtil(driver);
//        frames = new FrameUtil(driver);
//        scroll = new ScrollUtil(driver);
//        screenshot = new ScreenshotUtil(driver);
    }

}