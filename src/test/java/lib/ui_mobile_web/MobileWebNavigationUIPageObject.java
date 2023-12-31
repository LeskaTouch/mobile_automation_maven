package lib.ui_mobile_web;

import lib.ui_common.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MobileWebNavigationUIPageObject extends NavigationUI {
    public MobileWebNavigationUIPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        SAVED_ARTICLE_BUTTON = "css:a[data-event-name='menu.watchlist']";
        MENU_BUTTON = "css:#mw-mf-main-menu-button";
    }
    @Override
    public void clickSavedArticles(){
        tryClickElementWithFewAttemp(
                getLocator(SAVED_ARTICLE_BUTTON),
                "No Saved button on the main screen is found",
                5);
    }
}
