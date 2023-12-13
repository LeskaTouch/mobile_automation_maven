package tests;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.factories.ArticlePageObjectFactory;
import lib.factories.SearchPageObjectFactory;
import lib.test_case.CoreTestCase;
import lib.ui_common.ArticlePageObject;
import lib.ui_common.SearchPageObject;
import org.junit.Assert;
import org.junit.Test;

public class ChangeAppConditionsTests extends CoreTestCase {
    @Test
    @Features(value = {@Feature(value="Search"), @Feature(value="Article")})
    @Severity(value= SeverityLevel.NORMAL)
    @DisplayName("Compare titles before and after rotation")
    @Description("We check that the title of the article before and after the rotation is the same")
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

        Assert.assertEquals("Titles before and after rotation are not the same", title_after, title_before);
        rotatePortrate();

    }
}
