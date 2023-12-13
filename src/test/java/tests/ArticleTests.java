package tests;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.factories.ArticlePageObjectFactory;
import lib.factories.SearchPageObjectFactory;
import lib.test_case.CoreTestCase;
import lib.ui_common.ArticlePageObject;
import lib.ui_common.SearchPageObject;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {
    @Test
    @Features(value = {@Feature(value="Search"), @Feature(value="Article")})
    @Severity(value= SeverityLevel.BLOCKER)
    @DisplayName("Compare Article Title")
    @Description("We open article with the title Rafael Nadal and make sure the article is expected")

    public void testArticleTitle(){

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchElement();

        searchPageObject.typeSearchLine("Nadal");



        searchPageObject.clickArticleName("Rafael Nadal");

        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        articlePageObject.assertTitleEquals("Rafael Nadal");

    }
}
