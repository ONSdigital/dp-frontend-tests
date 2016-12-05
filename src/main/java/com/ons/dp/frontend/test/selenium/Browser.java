package com.ons.dp.frontend.test.selenium;

import com.ons.dp.frontend.test.core.Configuration;
import com.ons.dp.frontend.test.util.Helper;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;
import java.util.logging.Logger;

public class Browser {

    private static Logger log = Logger.getLogger(Browser.class.getCanonicalName());
    private static WebDriver webDriver;
    private static WebDriverWait webDriverWait;
    public static WebDriver initDriver(Configuration configuration) {
        log.info("Initialising browser " + configuration.getBrowser().toString());
        if(webDriver==null) {
            setDriver(configuration.getBrowser().toUpperCase());
            setWebDriverWait(webDriver);
        }
        return webDriver;
    }
    public static WebDriverWait getWebDriverWait(){
        return webDriverWait;
    }
    public static void setWebDriverWait(WebDriver driver){
        webDriverWait = new WebDriverWait(driver, 1000);
    }

    public static void setDriver(String browser){
        switch (browser){
            case "FIREFOX":
                System.setProperty("webdriver.gecko.driver","/Applications/Firefox.app/Contents/MacOS/firefox");
                FirefoxProfile ffProfile = new FirefoxProfile();
                ffProfile.setEnableNativeEvents(false);
                DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
                desiredCapabilities.setCapability(FirefoxDriver.PROFILE, ffProfile);
                webDriver = new FirefoxDriver(desiredCapabilities);


                break;
            case "CHROME" :
                URL resource = Browser.class.getResource(Helper.getChromeDriverFileLocation());
                File file = new File(resource.getPath());
                if (file.exists()) {
                    log.info("CHROME DRIVER exists:" + file.getAbsolutePath());
                    file.setExecutable(true);
                }

                System.setProperty("webdriver.chrome.driver", resource.getPath());
                DesiredCapabilities desiredCapabilitiesChrome = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                desiredCapabilitiesChrome.setCapability(ChromeOptions.CAPABILITY, options);
                webDriver= new ChromeDriver();
                webDriver.manage().window().maximize();
                break;
            case "BROWSERSTACK" :
                // INIT browserstack class which will use the browser.json.
                // more work to be done here.
                break;
            default:
                System.setProperty("webdriver.gecko.driver","/home/giri/Downloads/firefox/browser/firefox");
                webDriver= new FirefoxDriver();
        }
        if(webDriver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) webDriver).executeScript("window.resizeTo(1024, 768);");
        }
        webDriver.manage().window().maximize();
        Dimension dim = new Dimension(1920, 1080);
        webDriver.manage().window().setSize(dim);
    }



}
