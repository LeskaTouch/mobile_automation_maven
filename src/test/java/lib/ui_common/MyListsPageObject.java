package lib.ui_common;

import io.appium.java_client.MobileDriver;
import io.qameta.allure.Step;
import lib.test_case.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListsPageObject extends MainPageObject {
    protected static String SAVED_ARTICLES_FOLDER,
    ARTICLE,
    ARTICLE_DESCRIPTION,
    DELETE_BUTTON, DELETE_BUTTON_FOR_ARTICLE,
    CLOSE_SYNC_POPUP;

    public MyListsPageObject(RemoteWebDriver driver){
        super(driver);

    }

    @Step("Click Folder with saved articles")
    public void openSavedArticlesFolder(){
        waitForElementAndClick(
                getLocator(SAVED_ARTICLES_FOLDER),
                "No saved articles are found",
                5);

    }

    public void closeSyncPopup() {
        waitForElementAndClick(getLocator(CLOSE_SYNC_POPUP), "NO SYNC POPUP CLOSE BTN", 5);
    }

    @Step("Delete the article '{article_name}' by swiping for mobile, click delete button for mobile web ")
    public void swipeByArticleToDelete(String article_name) {
        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
            swipeToTheLeft(
                    getLocator(getArticleName(article_name)),
                    "No article with " + article_name + "is found to swipe");
        } else {
            String remove_locator = getRemoveButtonByTitle(article_name);
            waitForElementAndClick(getLocator(remove_locator), "No article with " + article_name + "is found to delete", 5);
        }
    }

    private String getRemoveButtonByTitle(String article_name){
        return DELETE_BUTTON_FOR_ARTICLE.replace("{ARTICLE_NAME}", article_name);

    }
    @Step("Click the article with description '{article_description}'")

    public void clickArticleDescription(String article_description){

        waitForElementAndClick(
                    getLocator(getArticleDescription(article_description)),
                    "Article with" + article_description + "is not present",
                    5);

    }

    @Step("Click the article with the title '{article_title}'")
    public void clickArticleTitle(String article_title){

        waitForElementAndClick(
                getLocator(getArticleName(article_title)),
                "Article with " + article_title + " is not present",
                5);

    }

    private String getArticleName(String article_name){
        return ARTICLE.replace("{ARTICLE_NAME}", article_name);


    }
    private String getArticleDescription(String article_description){
        return ARTICLE_DESCRIPTION.replace("{ARTICLE_DESCRIPTION}", article_description);

    }





}
