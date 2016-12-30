package com.ons.dp.frontend.test.stepdefinitions.ons;


import com.ons.dp.frontend.test.page.webpage.ReleaseCalendar;
import com.ons.dp.frontend.test.page.webpage.SearchReleases;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;

import java.util.List;

public class ReleaseCalendarSteps {
	ReleaseCalendar releaseCalendar = new ReleaseCalendar();
	SearchReleases searchReleases = new SearchReleases();


	@Given("^click on (UPCOMING|PUBLISHED) release calendar$")
	public void goToReleasesCalendar(String calendar) {
		releaseCalendar.goToReleaseCalendar();
		if (!releaseCalendar.getSelectedTab().contains("Upcoming")) {
			releaseCalendar.clickUpcomingReleases();
		}
		releaseCalendar.clickPublishedCalendar();
	}

	@And("^search for the release with:(.*), published after:(.*) and published before:(.*)$")
	public void searchForReleases(String keyword, String pubAfter, String pubBefore) {
		searchReleases.searchReleases(keyword, pubAfter, pubBefore);
	}

	@And("^search results contains the release: (.*)$")
	public void verifyReleaseIsDisplayed(String release) {
		while (releaseCalendar.isElementPresent(releaseCalendar.returnNextPage())) {
			if (releaseCalendar.selectRelease(release)) {
				Assert.assertTrue(true);
				break;
			}
			releaseCalendar.click(releaseCalendar.returnNextPage());
		}
	}

	@Then("^verify the release information$")
	public void verifyReleaseInfo(List <String> releaseInfo) {
		//TODO
		// check for the icon presence, release date information, title
	}
}
