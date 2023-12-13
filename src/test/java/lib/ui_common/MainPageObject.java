package lib.ui_common;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.aspectj.util.FileUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.regex.Pattern;

public class MainPageObject {
    protected RemoteWebDriver driver;

    public MainPageObject(RemoteWebDriver driver){
        this.driver = driver;

    }
    public void assertElementHasText(By by, String expected_text, String error_message) {
        WebElement element = waitForElement(by, "Title element is not found with parameters " + by, 5);
        String actual_text = element.getText();

        System.out.println(actual_text);
        Assert.assertTrue(error_message, actual_text.contains(expected_text));
    }

    public void assertElementHasDescription(By by, String expected_text, String error_message) {
        WebElement element = waitForElement(by, "Title element is not found with parameters " + by, 5);
        String actual_text = element.getAttribute("contentDescription");

        Assert.assertTrue(error_message, actual_text.equals(expected_text));
    }

    public WebElement waitForElement(By selector, String error_message, long timeoutinseconds){
        WebDriverWait wait = new WebDriverWait(driver, timeoutinseconds);
        wait.withMessage(error_message);
        return wait.until(ExpectedConditions.presenceOfElementLocated(selector));
    }

    public WebElement waitForElementAndClick(By locator, String error_message, long timeoutinseconds){
        WebElement element = waitForElement(locator, error_message, timeoutinseconds);
        element.click();
        return  element;

    }
    public WebElement waitForElementAndSendKeys(By locator, String error_message, long timeoutinseconds, String keys){
        WebElement element = waitForElement(locator, error_message, timeoutinseconds);


        element.sendKeys(keys);
        return element;


    }

    public boolean waitForElementNorPresent(By selector, String error_message, long timeinseconds ){
        WebDriverWait wait = new WebDriverWait(driver,timeinseconds);
        wait.withMessage(error_message);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(selector));
    }

    public void swipeToTheLeft(By locator, String error_to_show){
        if (driver instanceof MobileDriver) {
            WebElement element_to_swipe = waitForElement(locator, error_to_show, 10);
            int x_left = element_to_swipe.getLocation().x;
            int y_top = element_to_swipe.getLocation().y;
            int y_bottom = y_top + element_to_swipe.getSize().height;
            int x_right = x_left + element_to_swipe.getSize().width;
            int y_middle = (y_bottom + y_top) / 2;
            TouchAction action = new TouchAction((MobileDriver)driver);
            //action.press(x_right-50,y_middle).waitAction(Duration.ofMillis(200)).moveTo(x_left+10,y_middle);
            action.press(PointOption.point(x_right - 50, y_middle)).waitAction(WaitOptions.waitOptions(Duration.of(200, ChronoUnit.MILLIS))).moveTo(PointOption.point(x_left + 10, y_middle));
            action.release().perform();
        }
    }

    public int numberOfElements(By locator){

        int number_of_elements = driver.findElements(locator).size();
        return number_of_elements;

    }



    public void assertElementPresent(By locator, String error_message_no_title){
        if (numberOfElements(locator) == 0) {
            Assert.fail(error_message_no_title);
        }

    }

    public String getElementAttribute(By locator, String error_message,String attribute, long timeout){
        WebElement element = waitForElement(locator,error_message, timeout);
        return element.getAttribute(attribute);
    }

    public By getLocator(String locator){
        String[] divided_locator = locator.split(Pattern.quote(":"), 2);
        String by_type = divided_locator[0];
        String by_value = divided_locator[1];
        if (by_type.equals("xpath")){
            return By.xpath(by_value);
        } else if (by_type.equals("id")){
            return By.id(by_value);
        } else if (by_type.equals("name")) {
            return By.name(by_value);
        }  else if (by_type.equals("css")) {
            return By.cssSelector(by_value);
        }
        else {
            throw new IllegalArgumentException("The locator contains neither id nor xpath");
        }

    }

    public boolean isElementPresent(String selector) {
        System.out.println(selector);
            return numberOfElements(getLocator(selector)) > 0;
        }

        public void tryClickElementWithFewAttemp(By locator, String error_message, int number_attempt){
        int current_attempt= 0;
        boolean need_more_attempt=true;
        while (need_more_attempt) {
            try {
                waitForElementAndClick(locator, error_message, 1);
                need_more_attempt = false;
            } catch (Exception e) {
                if (current_attempt > number_attempt) {
                    waitForElement(locator, error_message, 1);
                }
            }
            ++current_attempt;
        }
    }
    public String takeScreenshots(String name){
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir") + "/" + name + "_screenshot.png";
        try {
            File newFile = new File(path);
            Files.deleteIfExists(newFile.toPath());

            FileUtils.moveFile(srcFile, newFile);
        } catch(IOException e) {
            System.out.println("Cannot take a screenshot: " + e.getMessage());
        }

        return path;
    }

    @Attachment
    public static byte[] attach(String path345) {
        try {
            return Files.readAllBytes(Paths.get(path345));
        } catch(IOException e) {
            System.out.println("Can not attach file: " + e.getMessage());
        }

        return new byte[0];
    }
}
