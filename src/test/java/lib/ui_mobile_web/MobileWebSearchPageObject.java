package lib.ui_mobile_web;

import lib.ui_common.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MobileWebSearchPageObject extends SearchPageObject {
    public MobileWebSearchPageObject (RemoteWebDriver driver) {
        super(driver);

    }

    static {
        INIT_SEARCH_ELEMENT = "css:button#searchIcon"; // #=id
        SEARCH_ELEMENT = "css:form.search-box>input[type=search]";
        SEARCH_RESULTS = "css:ul.page-list>li.page-summary";
        CLEAR_BUTTON = "css:div.header-action>button.cdx-button.cancel";
        SEARCH_RESULT_ITEM_TITLE = "css:ul.page-list>li.page-summary:nth-child({ORDER})>a>h3";
        ARTICLE_NAME_TEMPLATE = "xpath://ul[contains(@class, 'page-list')]/li/a/h3[.='{TITLE}']";
        ARTICLE_TITLE_AND_DESCRIPTION = "xpath://ul[contains(@class, 'page-list')]/li[a/div[@class=\"wikidata-description\"][contains(text(), \"{DESCRIPTION}\")] and a/h3[contains(., \"{TITLE}\")]]";
    }
}
