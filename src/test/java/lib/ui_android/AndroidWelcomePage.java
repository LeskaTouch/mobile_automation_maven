package lib.ui_android;

import io.appium.java_client.AppiumDriver;
import lib.ui_common.WelcomePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidWelcomePage extends WelcomePageObject {

    public AndroidWelcomePage(RemoteWebDriver driver) {
        super(driver);
    }
    @Override
    public void clickSkipButton(){

    }
}
