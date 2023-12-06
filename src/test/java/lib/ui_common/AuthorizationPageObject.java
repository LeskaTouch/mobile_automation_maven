package lib.ui_common;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainPageObject {

    private static final String
    LOGIN_BUTTON="xpath://body/div/div/a[span[text()='Log in']]",
    LOGIN_INPUT="css:input#wpName1",
    PASSWORD_INPUT="css:input#wpPassword1",
    SUBMIT_BUTTON="css:button.mw-htmlform-submit";
  public AuthorizationPageObject(RemoteWebDriver driver){
        super(driver);
  }

  public void clickLogInButton(){
      System.out.println(LOGIN_BUTTON);
      waitForElementAndClick(getLocator(LOGIN_BUTTON), "No Log in button is found", 10);
  }

  public void enterLogInData(String login, String password){
      waitForElementAndSendKeys(getLocator(LOGIN_INPUT), "No login field", 15, login);
      waitForElementAndSendKeys(getLocator(PASSWORD_INPUT), "No password field", 15, password);

  }

  public void submitForm(){
      waitForElementAndClick(getLocator(SUBMIT_BUTTON), "No submit button is found", 10);

  }

}
