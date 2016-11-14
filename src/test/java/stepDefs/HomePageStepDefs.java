package stepDefs;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

//import webDriver.SharedDriver;


/**
 * Created by admin on 13/10/2016.
 */
public class HomePageStepDefs
{

    private HomePage homePage;
    public WebDriver driver;

    public HomePageStepDefs() {

         driver = Hooks.driver;
         homePage = new HomePage(driver);
    }

    @Given("^I am on the ONS HomePage$")
    public void iAmOnTheONSHomePage() throws Throwable {

          homePage.NavigateToUrl();
    }


}
