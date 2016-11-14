package pages;

import org.openqa.selenium.WebDriver;
import utilities.CommonMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * Created by admin on 13/10/2016.
 */
public class HomePage extends BasePage
{

    public CommonMethods commonMethods;
    public static Properties Repository = new Properties();
    public File f;
    public FileInputStream FI;

    public HomePage(WebDriver driver)     {
        super(driver);
        commonMethods = new CommonMethods(driver);

    }

    public void loadPropertiesFile() throws IOException {
        f = new File(System.getProperty("user.dir") + "//src//test//java//config//config.properties");
        FI = new FileInputStream(f);
        Repository.load(FI);
    }



    public void NavigateToUrl() throws IOException {
        loadPropertiesFile();
        commonMethods.NavigateToUrl(Repository.get("url").toString());

    }

}
