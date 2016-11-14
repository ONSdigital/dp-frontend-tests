package florence_stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import florence_pages.CollectionsPage;
import florence_pages.UsersAndAccessPage;
import org.openqa.selenium.WebDriver;
import stepDefs.Hooks;

/**
 * Created by admin on 01/11/2016.
 */
public class UsersAndAccessPageStepDefs {

    public WebDriver driver;
    private UsersAndAccessPage usersAndAccessPage;
    private CollectionsPage collectionsPage;


    public UsersAndAccessPageStepDefs(){
        driver = Hooks.driver;
        usersAndAccessPage = new UsersAndAccessPage(driver);
        collectionsPage = new CollectionsPage(driver);
    }

    @Then("^I should see the text \"([^\"]*)\" in the list of users$")
    public void iShouldSeeTheTextInTheListOfUsers(String text) throws Throwable {
           collectionsPage.SelectACollectionFromListOfCollections(text);
    }


    @Then("^the user \"([^\"]*)\" should be added to the team$")
    public void theUserShouldBeAddedToTheTeam(String text) throws Throwable {
        usersAndAccessPage.IsNewUserAddedToTheTeam(text);
    }


    @When("^I click on \"([^\"]*)\" page$")
    public void iClickOnPage(String text) throws Throwable {
        usersAndAccessPage.ClickOnCensusHomePage(text);
    }

    @And("^I click \"([^\"]*)\" button in Census$")
    public void iClickButtonInCensus(String buttonText) throws Throwable {
        usersAndAccessPage.ClickOnCreateButtonInCensus(buttonText);
    }
}
