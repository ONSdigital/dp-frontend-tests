package stepDefs.florence;

import com.ons.dp.frontend.test.model.User;
import com.ons.dp.frontend.test.model.User.*;

import com.ons.dp.frontend.test.page.UsersAccess;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Random;

/**
 * Created by admin on 01/11/2016.
 */
public class UsersAccessSteps {


    public UsersAccess usersAndAccessPage = new UsersAccess();
    User createUser,randomUser;

    @Then("browse to users and access page")
    public void goToUsersAndAccess(){
        usersAndAccessPage.goToUsersAndAccessPage();
    }

    @Then("a user with username:\"([^\"]*)\",email: \"([^\"]*)\",password: \"([^\"]*)\" and user type: (Administrator|Publisher|Visualisation_Publisher|Viewer) is created$")
    public void createUser(String username, String email, String password, UserType userType){
        createUser = new User(username, email, password, userType);
        usersAndAccessPage.createUser(createUser);

    }
    @Then("I create a new user")
    public void createUser(){
        Random random = new Random();
        int number = random.nextInt(1000);
        String randomNumber = String.format("%03d", number);
        randomUser = new User("AutomatedUser"+randomNumber, "AutomatedUser"+randomNumber+"@testmail.com",
                "AutomatedUser"+randomNumber, UserType.Viewer);
 //       usersAndAccessPage.createUser(randomUser);
    }
    @When("I delete the user:\"([^\"]*)\"$")
    public void deleteUser(String userToDelete){
        usersAndAccessPage.deleteUser(userToDelete);
    }

    @Then("the user:\"([^\"]*)\" and email:\"([^\"]*)\" is displayed on the list of available users$")
    public void userisdisplayedOnTheList(String user, String email){
        Assert.assertTrue(usersAndAccessPage.doesTheUserNameExists(user));
        Assert.assertTrue(usersAndAccessPage.doesEmailExists(email));
    }
    @Then("the user:\"([^\"]*)\" (does|does not) exist in the list$")
    public void check_user_in_the_list(String user, String does){
        int exist = does.length();
        if(exist>4) {
            Assert.assertTrue("User is not deleted", usersAndAccessPage.doesTheUserNameExists(user));
        }
        else{
            Assert.assertFalse("User does not exist", usersAndAccessPage.doesTheUserNameExists(user));
        }
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
