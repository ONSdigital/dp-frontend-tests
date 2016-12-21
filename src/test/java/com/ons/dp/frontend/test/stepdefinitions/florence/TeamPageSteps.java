package com.ons.dp.frontend.test.stepdefinitions.florence;

import com.ons.dp.frontend.test.core.TestContext;
import com.ons.dp.frontend.test.page.publish.TeamsPage;
import com.ons.dp.frontend.test.util.AnyData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class TeamPageSteps {

    public TeamsPage teamsPage = new TeamsPage();

    @Then("^browse to teams page$")
    public void browseToTeamsPage() throws Throwable {
        teamsPage.goToTeamsPage();
    }

    @And("^a team with teamname:\"([^\"]*)\" is created$")
    public void aTeamWithTeamnameIsCreated(String teamName) throws Throwable {
        teamsPage.createTeam(teamName);
        TestContext.getCacheService().setDataMap("teamName", new AnyData(teamName));
    }

    @Then("^the team:\"([^\"]*)\" is displayed on the list of available teams$")
    public void theTeamIsDisplayedOnTheListOfAvailableTeams(String teamName) throws Throwable {
        Assert.assertTrue(teamsPage.doesTheTeamNameExist(teamName));
    }

    @When("^I delete the team:\"([^\"]*)\"$")
    public void iDeleteTheTeam(String teamname) throws Throwable {
        teamsPage.deleteTeam(teamname);
    }

    @Then("^the team:\"([^\"]*)\" (does|does not) exist in the list$")
    public void theTeamDoesNotExistInTheList(String team, String does) throws Throwable {
        boolean exists = does.length() < 4 ? true : false;
        Assert.assertEquals("Should User exist on the page : " + exists, exists, teamsPage.doesTheTeamNameExist(team));


    }

    @And("^add a user (.*) to the team$")
    public void addAViewerToTheTeam(String user) throws Throwable {
        TestContext.getCacheService().setDataMap("user", new AnyData(user));
        teamsPage.addUserToTheTeam(user);

    }


}