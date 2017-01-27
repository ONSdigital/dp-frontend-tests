package com.ons.dp.frontend.test.stepdefinitions.florence;

import com.ons.dp.frontend.test.core.TestContext;
import com.ons.dp.frontend.test.model.User;
import com.ons.dp.frontend.test.page.publish.UsersAccess;
import com.ons.dp.frontend.test.util.AnyData;
import com.ons.dp.frontend.test.util.Helper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Random;

//import com.ons.dp.frontend.test.model.User.UserType;

public class UsersAccessSteps {


    public UsersAccess usersAndAccessPage = new UsersAccess();
    User createUser, randomUser;

    @Then("browse to users and access page")
    public void goToUsersAndAccess() {
        usersAndAccessPage.goToUsersAndAccessPage();
    }

    @Then("I create a new (.*) user")
    public void createRandomUser(String userType) {
        Random random = new Random();
        int number = random.nextInt(1000);
        String randomNumber = String.format("%03d", number);
        String randomUsername = "AutomatedUser" + randomNumber;
        String randomUserEmail = "automateduser" + randomNumber + "@testmail.com";
        randomUser = new User(randomUsername, randomUserEmail, "AutomatedUser" + randomNumber, userType);
        TestContext.getCacheService().setDataMap("userName", new AnyData(randomUsername));
        TestContext.getCacheService().setDataMap("userEmail", new AnyData(randomUserEmail));
        usersAndAccessPage.createUser(randomUser, userType);
    }

    @When("I delete the user:\"([^\"]*)\"$")
    public void deleteUser(String userToDelete) {
        usersAndAccessPage.deleteUser(userToDelete);
        Helper.pause(1000);
    }

    @When("I delete the user$")
    public void deleteRandomUser() {
        usersAndAccessPage.deleteUser(TestContext.getCacheService().getDataMap().get("userName").getStringData());
        Helper.pause(1000);
    }

    @Then("the user:\"([^\"]*)\" and email:\"([^\"]*)\" is displayed on the list of available users$")
    public void userEmailDisplayed(String user, String email) {
        Assert.assertTrue(usersAndAccessPage.doesTheUserNameExists(user));
        Assert.assertTrue(usersAndAccessPage.doesEmailExists(email));
    }

    @Then("the user is displayed on the list of available users$")
    public void checkUserDisplayed() {
        Assert.assertTrue(usersAndAccessPage.doesTheUserNameExists(TestContext.getCacheService().getDataMap().get("userName").getStringData()));

        Assert.assertTrue(usersAndAccessPage.doesEmailExists(TestContext.getCacheService().getDataMap().get("userEmail").getStringData()));
    }

    @Then("the user:\"([^\"]*)\" (does|does not) exist in the list$")
    public void check_user_in_the_list(String user, String does) {
        boolean exists = does.length() < 4 ? true : false;

        Assert.assertEquals("Should User exist on the page : " + exists, exists, usersAndAccessPage.doesTheUserNameExists(user));

    }

    @Then("the user (does|does not) exist in the list$")
    public void check_random_user_in_the_list(String does) {
        boolean exists = does.length() < 4 ? true : false;

        Assert.assertEquals("Should User exist on the page : " + exists, exists, usersAndAccessPage.doesTheUserNameExists(TestContext.getCacheService().getDataMap().get("userName").getStringData()));

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

}
