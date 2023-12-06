package lib.factories;

import io.appium.java_client.AppiumDriver;
import lib.test_case.Platform;
import lib.ui_android.AndroidMyListsPageObject;
import lib.ui_common.MyListsPageObject;
import lib.ui_ios.IosMyListsPageObject;
import lib.ui_mobile_web.MobileWebmyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyListsFactory {
    public static MyListsPageObject get(RemoteWebDriver driver) {
        Platform platform = Platform.getInstance();

        if (platform.isIOS()){
            return new IosMyListsPageObject(driver);
        } else if (platform.isAndroid()) {
            return new AndroidMyListsPageObject(driver);}
        else {return new MobileWebmyListsPageObject(driver);}

    }
}
