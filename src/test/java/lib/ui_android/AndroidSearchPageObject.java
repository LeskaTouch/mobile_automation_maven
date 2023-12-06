package lib.ui_android;

import io.appium.java_client.MobileDriver;
import lib.ui_common.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchPageObject {

    public AndroidSearchPageObject(RemoteWebDriver driver) {
        super(driver);

    }

    static {
        INIT_SEARCH_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_container']";
          SEARCH_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_src_text']";
          SEARCH_RESULTS = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']//*[@class='android.view.ViewGroup']";
          CLEAR_BUTTON = "id:org.wikipedia:id/search_close_btn";
          BACK_BUTTON = "xpath://*[@content-desc='Navigate up']";
          SEARCH_RESULT_ITEM_TITLE = "xpath:(//*[@resource-id='org.wikipedia:id/search_results_list']//*[@resource-id='org.wikipedia:id/page_list_item_title'])[{ORDER}]";
          ARTICLE_NAME_TEMPLATE = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title'][@text = '{TITLE}']";
          ARTICLE_TITLE_AND_DESCRIPTION = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']//*[@class='android.view.ViewGroup'][*[@text = '{DESCRIPTION}'] and *[@text='{TITLE}']]";
    }
}
