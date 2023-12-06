package tests;
import lib.factories.ArticlePageObjectFactory;
import lib.factories.SearchPageObjectFactory;
import lib.test_case.CoreTestCase;
import lib.ui_common.ArticlePageObject;
import lib.ui_common.SearchPageObject;

public class ChangeAppConditionsTests extends CoreTestCase {
    public void testRotationTest(){
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchElement();
        searchPageObject.typeSearchLine("Java");

        searchPageObject.clickArticleName("Java (programming language)");
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);

        String title_before = articlePageObject.getTitleText();
        articlePageObject.assertTitleEquals("Java (programming language)");
        rotateLandscape();

        String title_after = articlePageObject.getTitleText();

        assertEquals("Titles before and after rotation are not the same", title_after, title_before);
        rotatePortrate();

    }
}
