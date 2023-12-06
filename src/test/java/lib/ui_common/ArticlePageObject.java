package lib.ui_common;

import io.appium.java_client.MobileDriver;
import lib.test_case.Platform;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject {

    protected static String ARTICLE_TITLE,
    SAVE_BUTTON,
    BACK_BUTTON,
    TITLE_ATTRIBUTE_NAME,
    DELETE_ADDED_ARTICLE_BUTTON,
    INIT_SEARCH_ELEMENT;

    public ArticlePageObject(RemoteWebDriver driver){
        super(driver);
    }

    public WebElement waitForTitleElement(){

        return waitForElement(
                getLocator(ARTICLE_TITLE),
                "Title of the article is not found",
                5);
    }

    public String getTitleText(){
        WebElement el = waitForTitleElement();

        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
            return el.getAttribute(TITLE_ATTRIBUTE_NAME);
        } else {
            return el.getText();
        }
    }

    public void assertTitleEquals(String expected_title){
        Assert.assertEquals("The title is not as expected", getTitleText(), expected_title);
    }

    public void saveArticle(){
        if (Platform.getInstance().isWebMobile()){
            deleteArticleIfAdded();
        }
        waitForElementAndClick(
                getLocator(SAVE_BUTTON),
                "No 'Save' button is found",
                1);
    }

    public void clickBackButton(){
        if (Platform.getInstance().isAndroid()|| Platform.getInstance().isIOS()) {
            waitForElementAndClick(
                    getLocator(BACK_BUTTON),
                    "No back button is found for second search", 1);
        }
    }

    public void deleteArticleIfAdded(){
        System.out.println(DELETE_ADDED_ARTICLE_BUTTON);
        if (isElementPresent(DELETE_ADDED_ARTICLE_BUTTON)){
            waitForElementAndClick(getLocator(DELETE_ADDED_ARTICLE_BUTTON), "Can not find delete the added article button", 10);
            waitForElement(getLocator(SAVE_BUTTON), "No save article button is found", 10);
        }


    }
    public void initSearchElement(){
        waitForElementAndClick(getLocator(INIT_SEARCH_ELEMENT),
                "No search field is found",
                15);

    };



}
