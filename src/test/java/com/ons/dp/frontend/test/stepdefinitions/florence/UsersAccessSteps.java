package com.ons.dp.frontend.test.stepdefinitions.florence;

import com.ons.dp.frontend.test.model.User;
import com.ons.dp.frontend.test.model.User.UserType;
import com.ons.dp.frontend.test.page.publish.UsersAccess;
import com.ons.dp.frontend.test.util.Helper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Random;

public class UsersAccessSteps {


    public UsersAccess usersAndAccessPage = new UsersAccess();
    User createUser, randomUser;

    @Then("browse to users and access page")
    public void goToUsersAndAccess() {
        usersAndAccessPage.goToUsersAndAccessPage();
    }

    @Then("a user with username:\"([^\"]*)\",email: \"([^\"]*)\",password: \"([^\"]*)\" and user type: (Administrator|Publisher|Visualisation_Publisher|Viewer) is created$")
    public void createUser(String username, String email, String password, UserType userType) {
        createUser = new User(username, email, password, userType);
        usersAndAccessPage.createUser(createUser);


    }

    @Then("I create a new user")
    public void createUser() {
        Random random = new Random();
        int number = random.nextInt(1000);
        String randomNumber = String.format("%03d", number);
        randomUser = new User("AutomatedUser" + randomNumber, "AutomatedUser" + randomNumber + "@testmail.com",
                "AutomatedUser" + randomNumber, UserType.Viewer);
        //       usersAndAccessPage.createUser(randomUser);
    }

    @When("I delete the user:\"([^\"]*)\"$")
    public void deleteUser(String userToDelete) {
        usersAndAccessPage.deleteUser(userToDelete);
        Helper.pause(1000);
    }

    @Then("the user:\"([^\"]*)\" and email:\"([^\"]*)\" is displayed on the list of available users$")
    public void userEmailDisplayed(String user, String email) {
        Assert.assertTrue(usersAndAccessPage.doesTheUserNameExists(user));
        Assert.assertTrue(usersAndAccessPage.doesEmailExists(email));
    }

    @Then("the user:\"([^\"]*)\" (does|does not) exist in the list$")
    public void check_user_in_the_list(String user, String does) {
        boolean exists = does.length() < 4 ? true : false;

        Assert.assertEquals("Should User exist on the page : " + exists, exists, usersAndAccessPage.doesTheUserNameExists(user));

    }


    @Then("^I should have access to Collections$")
    public void accessCollection() throws Throwable {
        usersAndAccessPage.ClickOnLink("Collections");
        usersAndAccessPage.getTextFromPageSource("Select a collection");
        usersAndAccessPage.getTextFromPageSource("Create a collection");
    }

    @And("^I should have access to Publishing queue$")
    public void accessPublishing() throws Throwable {
        usersAndAccessPage.ClickOnLink("Publishing queue");
        usersAndAccessPage.getTextFromPageSource("Select a publish date");

    }

    @And("^I should have access to Reports$")
    public void accessReports() throws Throwable {
        usersAndAccessPage.ClickOnLink("Reports");
        usersAndAccessPage.getTextFromPageSource("Select a collection");
    }

    @And("^I should have access to Users and access$")
    public void accessUsers() throws Throwable {
        usersAndAccessPage.ClickOnLink("Users and access");
        usersAndAccessPage.getTextFromPageSource("Select a user");
    }

    @And("^I should have access to Teams$")
    public void accessTeams() throws Throwable {
        usersAndAccessPage.ClickOnLink("Teams");
        usersAndAccessPage.getTextFromPageSource("Select a team");
    }


    @And("^confirmation message is displayed as user created successfully$")
    public void confirmationDisplayed() throws Throwable {
        usersAndAccessPage.checkCreateNewUserConfirmation();
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
