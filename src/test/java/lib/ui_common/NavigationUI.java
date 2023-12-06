package lib.ui_common;

import io.appium.java_client.MobileDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUI extends MainPageObject {

    protected static String SAVED_ARTICLE_BUTTON,
    MENU_BUTTON;
    public NavigationUI(RemoteWebDriver driver){
        super(driver);
    }

    public void clickSavedArticles(){
        waitForElementAndClick(
                getLocator(SAVED_ARTICLE_BUTTON),
                "No Saved button on the main screen is found",
                5);
    }

    public void clickMenuButton(){
        waitForElementAndClick(getLocator(MENU_BUTTON), "No Menu button is found", 5);
    }

}
