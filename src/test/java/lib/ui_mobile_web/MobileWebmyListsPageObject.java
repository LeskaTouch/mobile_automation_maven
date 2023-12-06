package lib.ui_mobile_web;

import lib.ui_common.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MobileWebmyListsPageObject extends MyListsPageObject {

    static{
        //ARTICLE = "xpath://XCUIElementTypeOther//XCUIElementTypeOther//XCUIElementTypeOther[@name='banner']//XCUIElementTypeStaticText[1][@value='{ARTICLE_NAME}']";
        ARTICLE = "xpath://li[contains(@class, 'with-watchstar')]/a[h3[text() = '{ARTICLE_NAME}']]";
        ARTICLE_DESCRIPTION = "xpath://li[contains(@class, 'with-watchstar')]/a[h3[text() = '{ARTICLE_NAME}']]";
        DELETE_BUTTON_FOR_ARTICLE="xpath://li[contains(@class, 'with-watchstar')][a/h3[text() = '{ARTICLE_NAME}']]/a[contains(@class, 'watch-this-article')]";
    }

    public MobileWebmyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
    @Override
    public void openSavedArticlesFolder(){

    }
    @Override
    public  void closeSyncPopup() {}
}
