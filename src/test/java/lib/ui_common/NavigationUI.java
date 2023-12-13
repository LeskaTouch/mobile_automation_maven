package lib.ui_common;

import io.appium.java_client.MobileDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUI extends MainPageObject {

    protected static String SAVED_ARTICLE_BUTTON,
    MENU_BUTTON;
    public NavigationUI(RemoteWebDriver driver){
        super(driver);
    }

    @Step("Click Saved articled button")
    public void clickSavedArticles(){
        waitForElementAndClick(
                getLocator(SAVED_ARTICLE_BUTTON),
                "No Saved button on the main screen is found",
                5);
    }
    @Step("Click Menu button")
    public void clickMenuButton(){
        waitForElementAndClick(getLocator(MENU_BUTTON), "No Menu button is found", 5);
    }

}
