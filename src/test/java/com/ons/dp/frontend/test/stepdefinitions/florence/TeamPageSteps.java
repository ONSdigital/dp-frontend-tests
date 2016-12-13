package com.ons.dp.frontend.test.stepdefinitions.florence;

import com.ons.dp.frontend.test.page.publish.TeamsPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

/**
 * Created by admin on 09/12/2016.
 */
public class TeamPageSteps {

    public TeamsPage teamsPage = new TeamsPage();

    @Then("^browse to teams page$")
    public void browseToTeamsPage() throws Throwable {
        teamsPage.goToTeamsPage();
    }

    @And("^a team with teamname:\"([^\"]*)\" is created$")
    public void aTeamWithTeamnameIsCreated(String teamName) throws Throwable {
        teamsPage.createTeam(teamName);
    }

    @Then("^the team:\"([^\"]*)\" is displayed on the list of available teams$")
    public void theTeamIsDisplayedOnTheListOfAvailableTeams(String teamName) throws Throwable {
        Assert.assertTrue(teamsPage.doesTheTeamNameExists(teamName));
    }

    @When("^I delete the team:\"([^\"]*)\"$")
    public void iDeleteTheTeam(String teamname) throws Throwable {
        teamsPage.deleteTeam(teamname);
    }

    @Then("^the team:\"([^\"]*)\" (does|does not) not exist in the list$")
    public void theTeamDoesNotExistInTheList(String team, String does) throws Throwable {
        int exist = does.length();
        if (exist > 4) {
            org.junit.Assert.assertTrue("Team is not deleted", teamsPage.doesTheTeamNameExists(team));
        } else {
            // org.junit.Assert.assertFalse("Team does not exist", teamsPage.doesTheTeamNameExists(team));
            org.junit.Assert.assertFalse(teamsPage.doesTheTeamNameExists(team));
        }
    }
}
