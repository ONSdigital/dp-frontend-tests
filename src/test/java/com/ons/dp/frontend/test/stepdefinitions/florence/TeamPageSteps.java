package com.ons.dp.frontend.test.stepdefinitions.florence;

import com.ons.dp.frontend.test.core.TestContext;
import com.ons.dp.frontend.test.page.publish.TeamsPage;
import com.ons.dp.frontend.test.stepdefinitions.BaseStepDefinition;
import com.ons.dp.frontend.test.util.AnyData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Random;


public class TeamPageSteps {

    public TeamsPage teamsPage = new TeamsPage();
    private BaseStepDefinition baseStepDefinition;

    public TeamPageSteps() {
        this.baseStepDefinition = new BaseStepDefinition();
    }

    @Then("^browse to teams page$")
    public void browseToTeamsPage() throws Throwable {
        teamsPage.goToTeamsPage();
    }


    @And("^a team with teamname:\"([^\"]*)\" is created$")
    public void aTeamWithTeamnameIsCreated(String teamName) throws Throwable {

        teamsPage.createTeam(teamName);
        TestContext.getCacheService().setDataMap("teamName", new AnyData(teamName));
    }

    @And("^new team should be created$")
    public void aTeamShouldBeCreated() throws Throwable {
        teamsPage.createTeam(TestContext.getCacheService().getDataMap().get("teamName").getStringData());
    }

    @And("^a new team is created$")
    public void randomTeamIsCreated() throws Throwable {
        Random random = new Random();
        int number = random.nextInt(1000);
        String randomNumber = String.format("%03d", number);
        String teamName = "TestTeam" + randomNumber;
        teamsPage.createTeam(teamName);
        TestContext.getCacheService().setDataMap("teamName", new AnyData(teamName));
    }

    @Then("^the team:\"([^\"]*)\" is displayed on the list of available teams$")
    public void theTeamIsDisplayedOnTheListOfAvailableTeams(String teamName) throws Throwable {
        Assert.assertTrue(teamsPage.doesTheTeamNameExist(teamName));
    }

    @Then("^the new team is displayed on the list of available teams$")
    public void theRandomTeamIsDisplayedOnTheListOfAvailableTeams() throws Throwable {
        Assert.assertTrue(teamsPage.doesTheTeamNameExist(TestContext.getCacheService().getDataMap().get("teamName").getStringData()));
    }

    @When("^I delete the team:\"([^\"]*)\"$")
    public void iDeleteTheTeam(String teamname) throws Throwable {
        teamsPage.deleteTeam(teamname);
    }

    @When("^I delete the new team$")
    public void iDeleteTheNewTeam() throws Throwable {
        teamsPage.deleteTeam(TestContext.getCacheService().getDataMap().get("teamName").getStringData());
    }


    @Then("^the team:\"([^\"]*)\" (does|does not) exist in the list$")
    public void theTeamDoesNotExistInTheList(String team, String does) throws Throwable {
        boolean exists = does.length() < 4 ? true : false;
        Assert.assertEquals("Should User exist on the page : " + exists, exists, teamsPage.doesTheTeamNameExist(team));
    }

    @Then("^the new team (does|does not) exist in the list$")
    public void theTeamDoesNotExistInTheList(String does) throws Throwable {
        boolean exists = does.length() < 4 ? true : false;
        Assert.assertEquals("Should User exist on the page : " + exists, exists, teamsPage.doesTheTeamNameExist(TestContext.getCacheService().getDataMap().get("teamName").getStringData()));
    }

    @And("^add a user (.*) to the team$")
    public void addAViewerToTheTeam(String user) throws Throwable {
        TestContext.getCacheService().setDataMap("user", new AnyData(user));
        teamsPage.addUserToTheTeam(user);
    }

    @And("^add the new user to the team$")
    public void addAUserToTheTeam() throws Throwable {
        teamsPage.addUserToTheTeam(TestContext.getCacheService().getDataMap().get("userEmail").getStringData());
    }


}