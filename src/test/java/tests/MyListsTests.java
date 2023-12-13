package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.factories.ArticlePageObjectFactory;
import lib.factories.MyListsFactory;
import lib.factories.NavigationUIFactory;
import lib.factories.SearchPageObjectFactory;
import lib.test_case.CoreTestCase;
import lib.test_case.Platform;
import lib.ui_common.*;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyListsTests extends CoreTestCase {
    @Test
    @Features(value = {@Feature(value="Search"), @Feature(value="Article"),@Feature(value="My Lists")})
    @Severity(value= SeverityLevel.NORMAL)
    @DisplayName("Delete the saved article")
    @Description("We add 2 articles to the folder, delete one article and check that the remained article has the expected title 'Roger Federer' ")
    public void testSaveArticles(){
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        NavigationUI navigationUI = NavigationUIFactory.get(driver);
        MyListsPageObject myListsPageObject = MyListsFactory.get(driver);

        searchPageObject.initSearchElement();
        searchPageObject.typeSearchLine("Roger Federer");

        searchPageObject.clickArticleName("Roger Federer");

        if (Platform.getInstance().isWebMobile()){
            articlePageObject.saveArticle();

            AuthorizationPageObject authorizationPageObject= new AuthorizationPageObject(driver);
            authorizationPageObject.clickLogInButton();
            authorizationPageObject.enterLogInData("Leskatouch", "12042021");
            authorizationPageObject.submitForm();
            articlePageObject.waitForTitleElement();
            articlePageObject.deleteArticleIfAdded();
        }

        articlePageObject.saveArticle();


        articlePageObject.clickBackButton();

        if (Platform.getInstance().isIOS()|| Platform.getInstance().isAndroid()) {
            searchPageObject.clearSearch();
        } else {
            articlePageObject.initSearchElement();
        }


        searchPageObject.typeSearchLine("Nadal");
        searchPageObject.clickArticleName("Rafael Nadal");

        articlePageObject.deleteArticleIfAdded();
        articlePageObject.saveArticle();

        articlePageObject.clickBackButton();
        searchPageObject.clickBackButton();
        if (Platform.getInstance().isWebMobile()){
            navigationUI.clickMenuButton();
        }

        navigationUI.clickSavedArticles();
        myListsPageObject.openSavedArticlesFolder();
        myListsPageObject.closeSyncPopup();

        myListsPageObject.swipeByArticleToDelete("Rafael Nadal");


        if (Platform.getInstance().isAndroid()||Platform.getInstance().isIOS()){

            myListsPageObject.clickArticleDescription("Swiss tennis player (born 1981)");}
        else {
            driver.navigate().refresh();
            myListsPageObject.clickArticleTitle("Roger Federer");
        }

        articlePageObject.waitForTitleElement();
        articlePageObject.assertTitleEquals("Roger Federer");

    }
}
