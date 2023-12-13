package lib.ui_common;

import io.appium.java_client.MobileDriver;
import io.qameta.allure.Step;
import lib.test_case.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class SearchPageObject extends MainPageObject {
    protected static String

    INIT_SEARCH_ELEMENT,
     SEARCH_ELEMENT,
     SEARCH_RESULTS,
     CLEAR_BUTTON,
     SEARCH_RESULT_ITEM_TITLE,
    ARTICLE_NAME_TEMPLATE,
    ARTICLE_TITLE_AND_DESCRIPTION,
    BACK_BUTTON;


    public SearchPageObject(RemoteWebDriver driver){
        super(driver);
    };

    @Step("Click search input field")
    public void initSearchElement(){
        waitForElementAndClick(getLocator(INIT_SEARCH_ELEMENT),
                "No search field is found",
                15);

    };
    @Step("Type the text '{search_line}' to search ")

    public void typeSearchLine(String search_line){
        waitForElementAndSendKeys(
                getLocator(SEARCH_ELEMENT),
                "No tapped search field is found",
                5,
                search_line);

    }
    @Step("Wait for search results to appear")

    public void waitSearchResultList(){
        waitForElement(
                getLocator(SEARCH_RESULTS),
                "No results",
                5);


    }
    @Step("Click 'x' button to clear search input")

    public void clearSearch(){
        waitForElementAndClick(
                getLocator(CLEAR_BUTTON),
                "Search is not closed",
                5);
    }

    @Step("Make sure that 'x' is not shown")
    public void waitCloseButtonIsNotPresent(){
        waitForElementNorPresent(
                getLocator(CLEAR_BUTTON),
                "Close button is present",
                5);

    }

    @Step("Make sure that the text of the element is equals to '{expected_text}'")
    public void assertSearchResultHasText(String expected_text, int item_order){
        assertElementHasText(
                getLocator(getSearchResultItemTitleXpath(item_order)),
                expected_text,
                expected_text + " is not present in each line");
    }



    @Step("Click the article with name '{article_id}' ")
    public void clickArticleName(String article_id){

        String article_xpath = getArticleNameXpath(article_id);

        waitForElementAndClick(
                getLocator(article_xpath),
                "No article is found for: " + article_id,
                5);
    }


    @Step("Wait for the article with title '{title}' and description '{description}' to appear")
    public WebElement waitForElementByTitleAndDescription(String title, String description) {
        return waitForElement(
                getLocator(getSearchResultItemByTitleAndDescription(title, description)),
                "No article with TITLE " + title + " and DESCRIPTION " + description + " is found",
                5);
    }

    @Step("Click Back button")
    public void clickBackButton() {
        if (Platform.getInstance().isAndroid()|| Platform.getInstance().isIOS()) {
            waitForElementAndClick(
                getLocator(BACK_BUTTON),
                "No back button is found for second search",
                5);
        }
    }

    // TEMPLATES METHODS
    private String getSearchResultItemTitleXpath(int order){
        return SEARCH_RESULT_ITEM_TITLE.replace("{ORDER}", Integer.toString(order));
    }
    private String getArticleNameXpath(String title){
        return ARTICLE_NAME_TEMPLATE.replace("{TITLE}", title);

    }

    private String getSearchResultItemByTitleAndDescription(String title, String description){
        return  ARTICLE_TITLE_AND_DESCRIPTION.replace("{TITLE}", title).replace ("{DESCRIPTION}", description);
    }
    // TEMPLATES METHODS

}
