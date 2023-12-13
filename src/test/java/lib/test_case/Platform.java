package lib.test_case;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import tests.ChangeAppConditionsTests;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Platform {
    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";
    private static final String URL_ANDROID ="http://127.0.0.1:4723";
    private static final String URL_IOS = "http://127.0.0.1:4723";
    private static final String PLATFORM = "PLATFORM";

    private static Platform instance;
    private static String WEB_MOBILE = "web_mobile";

    private Platform() {}

    public static Platform getInstance() {
        if (instance == null) {
            instance = new Platform();
        }

        return instance;
    }


    protected DesiredCapabilities getCapabilitiesAndroid() throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("appium:deviceName", "Pixel81");
            capabilities.setCapability("appium:automationName", "UiAutomator2");
            // capabilities.setCapability("appium:platformVersion", "8.1");
            capabilities.setCapability("appium:appPackage", "org.wikipedia");
            capabilities.setCapability("appium:appActvity", ".`main.MainActivity`");
            capabilities.setCapability("appium:app", "/Users/dariademskaya/Documents/JavaAppiumAutomation/JavaAppiumAutomation/apks/org.wikipedia.apk");

        return capabilities;


    }

    protected DesiredCapabilities getCapabilitiesIos() throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("appium:deviceName", "iPhone 14 Pro Max");
            capabilities.setCapability("appium:platformVersion", "17.0");
            capabilities.setCapability("appium:app", "/Users/dariademskaya/Documents/JavaAppiumAutomation/JavaAppiumAutomation/apks/Wikipedia693.app");
            capabilities.setCapability("appium:automationName", "XCUITest");
            capabilities.setCapability("xcodeOrgId", "OrgId");
            capabilities.setCapability("xcodeSigningId", "SignId");

        return capabilities;


    }

    protected RemoteWebDriver getDriver() throws Exception {

        if (isIOS()){
            return new IOSDriver<>(new URL(URL_IOS), getCapabilitiesIos());
        }

        if (isAndroid()) {
            return new AndroidDriver<>(new URL(URL_ANDROID), getCapabilitiesAndroid());
        }

        if (isWebMobile()){
            return new ChromeDriver(getChromeOptions());
        }

        throw new Exception("NO PLATFORM FOUND");

    }

    public boolean isAndroid() {
        return getPlatform().equals(PLATFORM_ANDROID);
    }

    public boolean isIOS() {
        return getPlatform().equals(PLATFORM_IOS);

    }

    public boolean isWebMobile(){
        return getPlatform().equals(WEB_MOBILE);
    }


    public String getPlatform(){
        return System.getenv(PLATFORM);
    }

    private ChromeOptions getChromeOptions() {
        Map<String, Object> deviceMetrics = new HashMap<String, Object>();
        deviceMetrics.put("width", 360);
        deviceMetrics.put("height", 640);
        deviceMetrics.put("pixelRation", 3.0);

        Map<String, Object> mobileEmulation = new HashMap<String, Object>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put ("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) ) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=340,640");
        return chromeOptions;
    }


}
