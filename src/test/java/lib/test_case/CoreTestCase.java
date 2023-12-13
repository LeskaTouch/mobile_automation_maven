package lib.test_case;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import junit.framework.TestCase;
import lib.factories.WelcomePageFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileOutputStream;
import java.util.Properties;

public abstract class CoreTestCase {

    protected RemoteWebDriver driver;

    @Before
    @Step("Initialize driver")
    public void setUp() throws Exception {

        driver = Platform.getInstance().getDriver();
        createAllurePropertyFile();
        if (driver instanceof AppiumDriver){
            rotatePortrate();
            skipWelcomePage();
        }

        openWikiForMobileWeb();



    }


    @After
    @Step("Terminate the driver")
    public void tearDown() {

        driver.quit();
    }
    @Step("Rotate mobile to landscape")
    public void rotateLandscape(){
        if (driver instanceof AppiumDriver) {
            AppiumDriver appiumDriver = (AppiumDriver) driver;
            appiumDriver.rotate(ScreenOrientation.LANDSCAPE);
        }
    }

    @Step("Rotate mobile to portrait")
    public void rotatePortrate() {

        if (driver instanceof AppiumDriver) {
            AppiumDriver appiumDriver = (AppiumDriver) driver;
            appiumDriver.rotate(ScreenOrientation.PORTRAIT);
        }
    }

    @Step("Skip welcome page for ios")
    public void skipWelcomePage(){
        WelcomePageFactory.get(driver).clickSkipButton();
    }

    @Step("Open wiki page in browser")
    protected void openWikiForMobileWeb(){
        if (Platform.getInstance().isWebMobile()) {
            driver.get("https://en.m.wikipedia.org");
        } else {
            System.out.println("Method openWikiForMobileWeb do nothing for platform ");
        }

}

    private void createAllurePropertyFile(){
        String path = System.getProperty("allure.results.directory");
        try {
            Properties prop = new Properties();
            FileOutputStream fos = new FileOutputStream(path + "/environment.properties");
            prop.setProperty("Environment", Platform.getInstance().getPlatform());
            prop.store(fos, "No comment");
            fos.close();
        } catch(Exception e) {
            System.err.println(e);

        }
    }

    }

