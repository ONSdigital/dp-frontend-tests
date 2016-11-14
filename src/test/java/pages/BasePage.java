package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by admin on 14/10/2016.
 */
public class BasePage {
    public static WebDriver driver;
    public static boolean bResult;

    public  BasePage(WebDriver driver){
        BasePage.driver = driver;
        BasePage.bResult = true;
    }
}
