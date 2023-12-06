package lib.factories;

import io.appium.java_client.AppiumDriver;
import lib.test_case.Platform;
import lib.ui_android.AndroidWelcomePage;
import lib.ui_common.WelcomePageObject;
import lib.ui_ios.IosWelcomePage;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WelcomePageFactory {
    public static WelcomePageObject get(RemoteWebDriver driver) {
        Platform platform = Platform.getInstance();

        if (platform.isIOS()){
            return new IosWelcomePage(driver);
        } else

        {
            return new AndroidWelcomePage(driver);
        }


    }

}
