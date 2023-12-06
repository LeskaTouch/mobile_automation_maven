package lib.ui_common;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class WelcomePageObject extends MainPageObject {
    protected static String LEARN_MORE,
            NEXT_BUTTON,
            NEW_WAYS,
            SEARCH_IS_OVER,
            MAKE_APP_BETTER,
            GET_STARTED,
    SKIP_BUTTON;


    public WelcomePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
    public void waitForLearnMoreLink(){
        waitForElement(getLocator(LEARN_MORE), "No 'Learn more about Wikipedia' text is found", 10 );

    }
    public void clickNextButton(){
        waitForElementAndClick(getLocator(NEXT_BUTTON), "No 'Next' button is found", 10);
    }

    public void waitForNewWaysToExplore(){
        waitForElement(getLocator(NEW_WAYS), "No 'New ways to explore' is found", 10);
    }
    public void waitForSearchInOverLanguages(){
        waitForElement(getLocator(SEARCH_IS_OVER), "No 'Search in over 300 languages' text is found", 10);
    }
    public void waitForHelpMakeAppBetter(){
        waitForElement(getLocator(MAKE_APP_BETTER), "No 'Help make the app better' text is found", 10 );
    }

    public void clickGetStartedButton(){
        waitForElementAndClick(getLocator(GET_STARTED), "No 'Get started' button is found", 10);
    }

    public void clickSkipButton(){
        waitForElementAndClick(getLocator(SKIP_BUTTON), "No Skip button is found", 5);
    }






}
