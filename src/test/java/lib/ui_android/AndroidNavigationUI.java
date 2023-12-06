package lib.ui_android;

import io.appium.java_client.MobileDriver;
import lib.ui_common.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidNavigationUI extends NavigationUI {

    public AndroidNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }

    static {SAVED_ARTICLE_BUTTON = "xpath://*[@content-desc='Saved']";};
}
