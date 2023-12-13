package lib.ui_common;

import io.appium.java_client.MobileDriver;
import io.qameta.allure.Step;
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

    @Step("Waiting for the title element to appear")
    public WebElement waitForTitleElement(){

        return waitForElement(
                getLocator(ARTICLE_TITLE),
                "Title of the article is not found",
                5);
    }

    @Step("Get title text of the article")
    public String getTitleText(){
        WebElement el = waitForTitleElement();

        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
            return el.getAttribute(TITLE_ATTRIBUTE_NAME);
        } else {
            return el.getText();
        }
    }

    @Step("Compare the title of the article equals '{expected_title}'")
    public void assertTitleEquals(String expected_title){
        attach(takeScreenshots("click_article"));
        Assert.assertEquals("The title is not as expected", getTitleText(), expected_title);
    }

    @Step("Save the article to the reading list")
    public void saveArticle(){
        if (Platform.getInstance().isWebMobile()){
            deleteArticleIfAdded();
        }
        waitForElementAndClick(
                getLocator(SAVE_BUTTON),
                "No 'Save' button is found",
                1);
    }

    @Step("Go back from article page on mobile app")
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
    @Step ("Initialize search input")
    public void initSearchElement(){
        waitForElementAndClick(getLocator(INIT_SEARCH_ELEMENT),
                "No search field is found",
                15);

    };



}
