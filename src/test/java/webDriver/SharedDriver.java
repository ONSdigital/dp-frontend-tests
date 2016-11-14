/*
package webDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

*/
/**
 * Created by admin on 12/10/2016.
 *//*

public class SharedDriver extends EventFiringWebDriver

{
    public static WebDriver REAL_DRIVER = null;
    public static boolean IS_FIREFOX_DRIVER = false;
    public static boolean IS_CHROME_DRIVER = false;
    public static boolean IS_IE_DRIVER = false;
    public static boolean IS_SAFARI_DRIVER = false;


    public SharedDriver()
    {
        super(REAL_DRIVER);
    }

    static {

        try {
            if (REAL_DRIVER == null) {
                initiateRealDriver();
                customiseRealDriver();
            }

        } catch (final Exception e) {

            System.out.println("Sorry....I couldn't initialize your browser! :( ");
        }
    }

    private static void customiseRealDriver() {
        REAL_DRIVER.manage().window().maximize();
        REAL_DRIVER.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @cucumber.api.java.Before
    private static void initiateRealDriver() throws MalformedURLException {
        REAL_DRIVER = new FirefoxDriver();
        IS_FIREFOX_DRIVER = true;
        System.out.println(IS_FIREFOX_DRIVER);
        return;
    }

    @cucumber.api.java.After
    public void CloseBrowser(){
        REAL_DRIVER.close();
        REAL_DRIVER.quit();
    }

}
*/
