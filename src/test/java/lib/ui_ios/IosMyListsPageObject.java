package lib.ui_ios;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.ios.IOSDriver;
import lib.ui_common.MyListsPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

public class IosMyListsPageObject extends MyListsPageObject {
    public IosMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    static{
        //ARTICLE = "xpath://XCUIElementTypeOther//XCUIElementTypeOther//XCUIElementTypeOther[@name='banner']//XCUIElementTypeStaticText[1][@value='{ARTICLE_NAME}']";
        ARTICLE = "xpath://XCUIElementTypeCollectionView/XCUIElementTypeCell[//XCUIElementTypeStaticText[@name='{ARTICLE_NAME}']]";
        ARTICLE_DESCRIPTION = "xpath://XCUIElementTypeCollectionView//XCUIElementTypeCell//XCUIElementTypeStaticText[2][@label='{ARTICLE_DESCRIPTION}']";
        DELETE_BUTTON ="xpath://XCUIElementTypeButton[@name='swipe action delete']";
        CLOSE_SYNC_POPUP = "xpath://XCUIElementTypeButton[@name='Close']";
    }
    @Override
    public void openSavedArticlesFolder(){

    }
    @Override
    public void swipeByArticleToDelete(String article_name){
        super.swipeByArticleToDelete(article_name);
        waitForElementAndClick(getLocator(DELETE_BUTTON), "No button to delete article for ios is found", 5);
    }

    @Override
    public void swipeToTheLeft(By locator, String error_to_show) {
        RemoteWebElement element = (RemoteWebElement)waitForElement(locator, "No article to delete", 5);

        driver.executeScript(
                "gesture: swipe",
                ImmutableMap.of("elementId", element.getId(),
                        "percentage", 10,
                        "direction", "left"));
    }
}
