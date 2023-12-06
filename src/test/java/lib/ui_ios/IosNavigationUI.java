package lib.ui_ios;

import io.appium.java_client.MobileDriver;
import lib.ui_common.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IosNavigationUI extends NavigationUI {

    static {SAVED_ARTICLE_BUTTON = "xpath://XCUIElementTypeButton[@name='Saved']";};

    public IosNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
