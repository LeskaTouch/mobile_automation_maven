package lib.ui_ios;

import io.appium.java_client.AppiumDriver;
import lib.ui_common.WelcomePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IosWelcomePage extends WelcomePageObject {
    static {
        LEARN_MORE = "name:Learn more about Wikipedia";
        NEXT_BUTTON = "name:Next";
         NEW_WAYS = "id:New ways to explore";
         SEARCH_IS_OVER = "id:Search in over 300 languages";
         MAKE_APP_BETTER = "id:Help make the app better";
         GET_STARTED = "name:Get started";
         SKIP_BUTTON = "name:Skip";
    }

    public IosWelcomePage(RemoteWebDriver driver) {
        super(driver);
    }
}
