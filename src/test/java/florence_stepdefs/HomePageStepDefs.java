package florence_stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import florence_pages.CollectionsPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import florence_pages.HomePage;
//import org.testng.Assert;
import stepDefs.Hooks;

/**
 * Created by admin on 21/10/2016.
 */
public class HomePageStepDefs {

    private HomePage homePage;
    public WebDriver driver;
    private CollectionsPage collectionsPage;

    public HomePageStepDefs() {

        driver = Hooks.driver;
        homePage = new HomePage(driver);
        collectionsPage = new CollectionsPage(driver);
    }

    @Given("^I am on the Florence HomePage$")
    public void iAmOnTheFlorenceHomePage() throws Throwable {
          homePage.NavigateToFlorenceUrl();
    }

  /*  @When("^I enter \"([^\"]*)\" in the (.*) field$")
    public void iEnterInTheEmailField(String email, String element) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I enter \"([^\"]*)\" in the password field$")
    public void iEnterInThePasswordField(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }*/

    /*@And("^I click Login$")
    public void iClickLogin() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }*/

    @Then("^I should be on the collections section$")
    public void iShouldBeOnTheCollectionsSection() throws Throwable {

        Assert.assertEquals(collectionsPage.AmIOnCollectionsSection(), "Create a collection");

    }


}
