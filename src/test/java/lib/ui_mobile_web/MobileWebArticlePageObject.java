package lib.ui_mobile_web;

import lib.ui_common.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MobileWebArticlePageObject extends ArticlePageObject {
    public MobileWebArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
    static {
        ARTICLE_TITLE = "css:#firstHeading";
        SAVE_BUTTON = "xpath://a[@id='ca-watch'][contains(., 'Watch')]";
        // BACK_BUTTON = "xpath://XCUIElementTypeButton[@name='Back']";
        // TITLE_ATTRIBUTE_NAME = "accessibilityValue";
        DELETE_ADDED_ARTICLE_BUTTON = "xpath://a[@id='ca-watch'][contains(., 'Unwatch')]";
        INIT_SEARCH_ELEMENT = "css:button#searchIcon";

    }
}
