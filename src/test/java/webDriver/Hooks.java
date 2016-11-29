//package webDriver;
//
//
//import cucumber.api.Scenario;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.safari.SafariDriver;
//import org.openqa.selenium.safari.SafariOptions;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.Properties;
//import java.util.concurrent.TimeUnit;
//
//public class Hooks {
//
//    public static WebDriver driver;
//    public static Properties Repository = new Properties();
//    public static int indexSI = 1;
//    public File f;
//    public FileInputStream FI;
//    public String startTime;
//
//
//    public void init() throws IOException {
//        loadPropertiesFile();
//        selectBrowser(Repository.getProperty("browser"));
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//    }
//
//    public void loadPropertiesFile() throws IOException {
//        f = new File(System.getProperty("user.dir") + "//src//test//java//config//config.properties");
//        FI = new FileInputStream(f);
//        Repository.load(FI);
//
//        // f = new
//        // File(System.getProperty("user.dir")+"\\src\\com\\actiTime\\pageLocators\\loginpage.properties");
//        // FI = new FileInputStream(f);
//        // Repository.load(FI);
//
//    }
//
//
//    //@Before
//
//    /**
//     * Delete all cookies at the start of each scenario to avoid
//     * shared state between tests
//     */
//   /* public void openBrowser() throws MalformedURLException {
//        System.out.println("Called openBrowser");
//        driver = new FirefoxDriver();
//        driver.manage().deleteAllCookies();
//        driver.manage().window().maximize();
//    }*/
//    public WebDriver selectBrowser(String browser) throws MalformedURLException {
//        if (browser.equals("firefox") || browser.equals("FIREFOX")) {
//            System.setProperty("webdriver.firefox.bin","/home/giri/Downloads/firefox/firefox");
//            driver = new FirefoxDriver();
//            driver.manage().deleteAllCookies();
//            driver.manage().window().maximize();
//            return driver;
//        } else if (browser.equals("chrome") || browser.equals("CHROME")) {
//            System.out.println("chrome browser");
//
//            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//java//BrowserDrivers//chromedriver");
//
//            // /Users/admin/dev/SampleONSProject/src/test/java/BrowserDrivers
//
//            driver = new ChromeDriver();
//            Dimension targetSize = new Dimension(1920, 1080);
//            driver.manage().window().setSize(targetSize);
//            return driver;
//        } else if (browser.equals("ie") || browser.equals("IE")) {
//            driver = new InternetExplorerDriver();
//            driver.manage().window().maximize();
//            return driver;
//        } else if (browser.equals("safari") || browser.equals("SAFARI")) {
//            DesiredCapabilities capabilities = DesiredCapabilities.safari();
//            capabilities.setCapability(SafariOptions.CAPABILITY, new SafariOptions());
//            driver = new SafariDriver(capabilities);
//            // driver = new SafariDriver();
//            driver.manage().window().maximize();
//            return driver;
//        } else if (browser.equals("remotedriver") || browser.equals("REMOTEDRIVER")) {
//            DesiredCapabilities caps = new DesiredCapabilities();
//
//            caps.setCapability("browser", "Chrome");
//            caps.setCapability("browser_version", "54.0");
//            caps.setCapability("os", "Windows");
//            caps.setCapability("os_version", "8");
//            caps.setCapability("resolution", "1024x768");
//            caps.setCapability("browserstack.debug", true);
//            caps.setCapability("browserstack.local", true);
//
//            driver = new RemoteWebDriver(new URL("https://robchambers3:pK8K1X2RvsqffFDqyYnW@hub-cloud.browserstack.com/wd/hub"), caps);
//
//            return driver;
//        }
//
//        return null;
//    }
//
//
//    @After
//    /**
//     * Embed a screenshot in test report if test is marked as failed
//     */
//    public void embedScreenshot(Scenario scenario) {
//
//        if (scenario.isFailed()) {
//            try {
//                scenario.write("Current Page URL is " + driver.getCurrentUrl());
////            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
//                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//                scenario.embed(screenshot, "image/png");
//            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
//                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
//            }
//
//        }
//
////        CucumberResultsOverview results = new CucumberResultsOverview();
////        results.setOutputDirectory("target");
////        results.setOutputName("cucumber-results");
////        results.setSourceFile("./src/test/resources/cucumber.json");
//        //results.executeFeaturesOverviewReport();
//
//        driver.quit();
//        //driver.close();
//        driver = null;
//
//
//    }
//
//
//}
