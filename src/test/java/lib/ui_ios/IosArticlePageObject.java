package lib.ui_ios;

import io.appium.java_client.MobileDriver;
import lib.ui_common.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IosArticlePageObject extends ArticlePageObject {
    public IosArticlePageObject(RemoteWebDriver driver){
        super(driver);

    }

    static {
        ARTICLE_TITLE = "xpath://*[@name='banner']/XCUIElementTypeOther[1]/XCUIElementTypeStaticText";
        SAVE_BUTTON = "xpath://XCUIElementTypeButton[@name='Save for later']";
        BACK_BUTTON = "xpath://XCUIElementTypeButton[@name='Back']";
        TITLE_ATTRIBUTE_NAME = "accessibilityValue";
    }

    @Override
    public String getTitleText() {
        return waitForTitleElement().getText();
    }
}
