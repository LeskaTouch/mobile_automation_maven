package tests;


import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.factories.SearchPageObjectFactory;
import lib.test_case.CoreTestCase;
import lib.ui_common.SearchPageObject;
import org.junit.Test;

public class SearchTests extends CoreTestCase {
    @Test
    @Features(value = {@Feature(value="Search")})
    @DisplayName("Clear search input")
    @Description("We check that there is no 'x' button after search input is cleaned")
    public void testClearResult(){
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchElement();
        searchPageObject.typeSearchLine("Java");

        searchPageObject.waitSearchResultList();

        searchPageObject.clearSearch();
        searchPageObject.waitCloseButtonIsNotPresent();
    }

    @Test
    @Features(value = {@Feature(value="Search")})
    @DisplayName("Search by 'Java' title returns at least 5 articles")
    @Description("We check that 5 articles with title 'Java' is found")

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

    @Test
    @Features(value = {@Feature(value="Search")})
    @Severity(value= SeverityLevel.BLOCKER)
    @DisplayName("Compare the title and description of the found articles")
    @Description("We check that the title and description of the articles for search input 'Java' are as expected")

    public void testSearchArticleWithTitleAndDescription(){
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchElement();
        searchPageObject.typeSearchLine("Java");

        searchPageObject.waitForElementByTitleAndDescription("Java", "Island in Indonesia");
        searchPageObject.waitForElementByTitleAndDescription("JavaScript", "High-level programming language");
        searchPageObject.waitForElementByTitleAndDescription("Java (programming language)", "Object-oriented programming language");

    }
}
