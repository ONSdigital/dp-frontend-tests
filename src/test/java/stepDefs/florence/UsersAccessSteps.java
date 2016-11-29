package stepDefs.florence;

import com.ons.dp.frontend.test.model.User;
import com.ons.dp.frontend.test.model.User.*;

import com.ons.dp.frontend.test.page.UsersAccess;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 * Created by admin on 01/11/2016.
 */
public class UsersAccessSteps {


    public UsersAccess usersAndAccessPage = new UsersAccess();
    User createUser;

    @Then("browse to users and access page")
    public void goToUsersAndAccess(){
        usersAndAccessPage.goToUsersAndAccessPage();
    }

    @Then("a user with username:\"([^\"]*)\",email: \"([^\"]*)\",password: \"([^\"]*)\" and user type: (Administrator|Publisher|Visualisation_Publisher|Viewer) is created$")
    public void createUser(String username, String email, String password, UserType userType){
        createUser = new User(username, email, password, userType);
        usersAndAccessPage.createUser(createUser);

    }

    @Then("the user is displayed on the list of available users")
    public void userisdisplayedOnTheList(){
        Assert.assertTrue(usersAndAccessPage.doesTheUserExistOnTheList(createUser.getUsername()));
    }

    @Then("^I should see the text \"([^\"]*)\" in the list of users$")
    public void iShouldSeeTheTextInTheListOfUsers(String text) throws Throwable {
  //      collectionsPage.SeeTheCollectionInAListOfCollections(text);
    }


    @Then("^the user \"([^\"]*)\" should be added to the team$")
    public void theUserShouldBeAddedToTheTeam(String text) throws Throwable {
 //       usersAndAccessPage.IsNewUserAddedToTheTeam(text);
    }


//
//    @When("^I click on \"([^\"]*)\" page$")
//    public void iClickOnPage(String text) throws Throwable {
//        usersAndAccessPage.ClickOnCensusHomePage(text);
//    }
//
//    @And("^I click \"([^\"]*)\" button in Census$")
//    public void iClickButtonInCensus(String buttonText) throws Throwable {
//        usersAndAccessPage.ClickOnCreateButtonInCensus(buttonText);
//    }
//
//    @Then("^I should see the text \"([^\"]*)\" in the list of teams$")
//    public void iShouldSeeTheTextInTheListOfTeams(String text) throws Throwable {
//        usersAndAccessPage.SelectATeamFromListOfTeams(text);
//    }
}
