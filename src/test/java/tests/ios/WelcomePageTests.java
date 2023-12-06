package tests.ios;

import lib.factories.WelcomePageFactory;
import lib.test_case.CoreTestCase;
import lib.ui_common.WelcomePageObject;
import org.junit.Test;

public class WelcomePageTests extends CoreTestCase {
    @Test
    public void testWelcomePage(){
        WelcomePageObject welcomePageObject = WelcomePageFactory.get(driver);
        welcomePageObject.waitForLearnMoreLink();
        welcomePageObject.clickNextButton();
        welcomePageObject.waitForNewWaysToExplore();
        welcomePageObject.clickNextButton();
        welcomePageObject.waitForSearchInOverLanguages();
        welcomePageObject.clickNextButton();
        welcomePageObject.waitForHelpMakeAppBetter();
        welcomePageObject.clickGetStartedButton();

    }
}
