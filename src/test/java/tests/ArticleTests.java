package tests;
import lib.factories.ArticlePageObjectFactory;
import lib.factories.SearchPageObjectFactory;
import lib.test_case.CoreTestCase;
import lib.ui_common.ArticlePageObject;
import lib.ui_common.SearchPageObject;

public class ArticleTests extends CoreTestCase {
    public void testArticleTitle(){

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchElement();

        searchPageObject.typeSearchLine("Nadal");
        searchPageObject.clickArticleName("Rafael Nadal");

        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        articlePageObject.assertTitleEquals("Rafael Nadal");

    }
}
