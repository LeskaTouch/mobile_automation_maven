package lib.ui_ios;

import io.appium.java_client.MobileDriver;
import lib.ui_common.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IosSearchPageObject extends SearchPageObject {
    static {
        INIT_SEARCH_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_ELEMENT = "xpath://XCUIElementTypeSearchField[@label='Search Wikipedia']";
        SEARCH_RESULTS = "xpath://XCUIElementTypeCollectionView";
         CLEAR_BUTTON = "xpath://XCUIElementTypeButton[@name='Clear text']";
         SEARCH_RESULT_ITEM_TITLE = "xpath:(//XCUIElementTypeCollectionView//XCUIElementTypeCell//XCUIElementTypeStaticText[1])[{ORDER}]";
         ARTICLE_NAME_TEMPLATE = "xpath://XCUIElementTypeCollectionView//XCUIElementTypeCell//XCUIElementTypeStaticText[1][@label = '{TITLE}']";
         ARTICLE_TITLE_AND_DESCRIPTION = "xpath://XCUIElementTypeCollectionView//XCUIElementTypeCell//XCUIElementTypeOther[XCUIElementTypeStaticText[@label='{TITLE}'] and XCUIElementTypeStaticText[@label='{DESCRIPTION}']]";
         BACK_BUTTON ="xpath://XCUIElementTypeStaticText[@name='Cancel']";
    }

    public IosSearchPageObject(RemoteWebDriver driver){
        super(driver);

    }

}
