//package florence_pages;
//
//import org.openqa.selenium.WebDriver;
//import pages.BasePage;
//import utilities.CommonMethods;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Properties;
//
///**
// * Created by admin on 21/10/2016.
// */
//public class HomePage extends BasePage {
//    public CommonMethods commonMethods= new CommonMethods();
//    public static Properties Repository = new Properties();
//
//    public File f;
//    public FileInputStream FI;
//
//
//
//    public void loadPropertiesFile() throws IOException {
//        f = new File(System.getProperty("user.dir") + "//src//test//java//config//config.properties");
//        FI = new FileInputStream(f);
//        Repository.load(FI);
//    }
//
//    public void NavigateToFlorenceUrl() throws Exception {
//
//        loadPropertiesFile();
//        commonMethods.NavigateToUrl(Repository.get("florence_url").toString());
//
//    }
//
//}
