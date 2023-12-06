package lib.test_case;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.factories.WelcomePageFactory;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class CoreTestCase extends TestCase {

    protected RemoteWebDriver driver;

    @Override()
    public void setUp() throws Exception {
        super.setUp();


        driver = Platform.getInstance().getDriver();
        if (driver instanceof AppiumDriver){
            rotatePortrate();
            skipWelcomePage();
        }

        openWikiForMobileWeb();



    }



    public void tearDown() throws Exception {
        super.tearDown();
        driver.quit();
    }
    public void rotateLandscape(){
        if (driver instanceof AppiumDriver) {
            AppiumDriver appiumDriver = (AppiumDriver) driver;
            appiumDriver.rotate(ScreenOrientation.LANDSCAPE);
        }
    }

    public void rotatePortrate() {

        if (driver instanceof AppiumDriver) {
            AppiumDriver appiumDriver = (AppiumDriver) driver;
            appiumDriver.rotate(ScreenOrientation.PORTRAIT);
        }
    }

    public void skipWelcomePage(){
        WelcomePageFactory.get(driver).clickSkipButton();
    }

    protected void openWikiForMobileWeb(){
        if (Platform.getInstance().isWebMobile()) {
            driver.get("https://en.m.wikipedia.org");}
            else {System.out.println("Method openWikiForMobileWeb do nothing for platform ");}

}
    }

