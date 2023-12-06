package lib.factories;

import io.appium.java_client.AppiumDriver;
import lib.test_case.Platform;
import lib.ui_android.AndroidArticlePageObject;
import lib.ui_common.ArticlePageObject;
import lib.ui_ios.IosArticlePageObject;
import lib.ui_mobile_web.MobileWebArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ArticlePageObjectFactory {
    public static ArticlePageObject get(RemoteWebDriver driver) {
        Platform platform = Platform.getInstance();

        if (platform.isIOS()){
            return new IosArticlePageObject(driver);
        } else if (platform.isAndroid()){
            return new AndroidArticlePageObject(driver);
        } else
        {
            return new MobileWebArticlePageObject(driver);
        }

    }
}
