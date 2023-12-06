package lib.factories;

import io.appium.java_client.AppiumDriver;
import lib.test_case.Platform;
import lib.ui_android.AndroidNavigationUI;
import lib.ui_common.NavigationUI;
import lib.ui_ios.IosNavigationUI;
import lib.ui_mobile_web.MobileWebNavigationUIPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUIFactory {
    public static NavigationUI get(RemoteWebDriver driver) {
        Platform platform = Platform.getInstance();

        if (platform.isIOS()){
            return new IosNavigationUI(driver);
        } else if (platform.isAndroid()){
            return new AndroidNavigationUI(driver);
        } else {
            return new MobileWebNavigationUIPageObject(driver);
        }

    }
}

