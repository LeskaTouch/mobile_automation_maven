package tests;


import lib.factories.SearchPageObjectFactory;
import lib.test_case.CoreTestCase;
import lib.ui_common.SearchPageObject;

public class SearchTests extends CoreTestCase {
    public void testClearResult(){
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchElement();
        searchPageObject.typeSearchLine("Java");

        searchPageObject.waitSearchResultList();

        searchPageObject.clearSearch();
        searchPageObject.waitCloseButtonIsNotPresent();
    }

    public void testSearchResultsAreRelevant(){
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchElement();

        searchPageObject.typeSearchLine("Java");
        searchPageObject.waitSearchResultList();

        searchPageObject.assertSearchResultHasText("Java", 1);

        searchPageObject.assertSearchResultHasText("Java", 2);
        searchPageObject.assertSearchResultHasText("Java", 3);
        searchPageObject.assertSearchResultHasText("Java", 4);
        searchPageObject.assertSearchResultHasText("Java", 5);

    }

    public void testSearchArticleWithTitleAndDescription(){
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchElement();
        searchPageObject.typeSearchLine("Java");

        searchPageObject.waitForElementByTitleAndDescription("Java", "Island in Indonesia");
        searchPageObject.waitForElementByTitleAndDescription("JavaScript", "High-level programming language");
        searchPageObject.waitForElementByTitleAndDescription("Java (programming language)", "Object-oriented programming language");

    }
}
