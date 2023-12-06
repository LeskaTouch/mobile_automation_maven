package lib.factories;

import lib.ui_mobile_web.MobileWebSearchPageObject;
import lib.test_case.Platform;
import lib.ui_android.AndroidSearchPageObject;
import lib.ui_common.SearchPageObject;
import lib.ui_ios.IosSearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchPageObjectFactory {
    public static SearchPageObject get(RemoteWebDriver driver) {
        Platform platform = Platform.getInstance();

        if (platform.isIOS()){
            return new IosSearchPageObject(driver);
        } else if (platform.isAndroid()){
            return new AndroidSearchPageObject(driver);
        } else {
            return new MobileWebSearchPageObject(driver);
        }


    }
}
