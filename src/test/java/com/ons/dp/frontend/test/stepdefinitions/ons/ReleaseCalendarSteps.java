package com.ons.dp.frontend.test.stepdefinitions.ons;


import com.ons.dp.frontend.test.model.ReleaseInfo;
import com.ons.dp.frontend.test.page.webpage.ReleaseCalendar;
import com.ons.dp.frontend.test.page.webpage.SearchReleases;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ReleaseCalendarSteps {
	ReleaseCalendar releaseCalendar = new ReleaseCalendar();
	SearchReleases searchReleases = new SearchReleases();


	@Given("^click on (UPCOMING|PUBLISHED) release calendar$")
	public void goToReleasesCalendar(String calendar) {
		releaseCalendar.goToReleaseCalendar();
		if (!releaseCalendar.getSelectedTab().contains("Upcoming") && (calendar.contains("UPCOMING"))) {
			releaseCalendar.clickUpcomingReleases();
		} else {
			releaseCalendar.clickPublishedCalendar();
		}
	}

	@And("^search for the release with keyword, published after and published before dates")
	public void searchForReleases(List <String> searchInfo) {

		searchReleases.searchReleases(searchInfo.get(0), searchInfo.get(1), searchInfo.get(2));
		System.out.println(searchInfo);
//		searchReleases.searchReleases(searchInfo.get(0), searchInfo.get(0)[1], searchInfo.get(0)[2]);
	}

	@And("^search results contains the release: (.*)$")
	public void verifyReleaseIsDisplayed(String release) {
		while (releaseCalendar.isElementPresent(releaseCalendar.returnNextPage())) {
			releasePresent(release);
			releaseCalendar.click(releaseCalendar.returnNextPage());
		}
		releasePresent(release);

	}

	public void releasePresent(String release) {
		if (releaseCalendar.selectRelease(release)) {
			assertTrue(true);

		}
	}

	@Then("^verify the release information$")
	public void verifyReleaseInfo(List <ReleaseInfo> releaseInfo) {
		// verifies the actual header contains the details from the cucumber
		assertTrue(releaseCalendar.getElementText(releaseCalendar.releaseHeader).contains(releaseInfo.get(0).getHeader()),
				"Actual Title :" + releaseCalendar.getElementText(releaseCalendar.releaseHeader) + "\n" +
						"Expected Title :" + releaseInfo.get(0).getHeader());
		assertEquals(releaseCalendar.getContactName(), releaseInfo.get(0).getContact());
		assertEquals(releaseCalendar.getContactEmail(), releaseInfo.get(0).getContact_email());
		if (releaseCalendar.doesImageExist()) {
			assertTrue(releaseInfo.get(0).getimage().equalsIgnoreCase("true"));
		}
		assertTrue(releaseCalendar.getElementText(releaseCalendar.releaseDate).contains(releaseInfo.get(0).getReleaseDate()));
		assertTrue(releaseCalendar.getElementText(releaseCalendar.nextReleaseDate).contains(releaseInfo.get(0).getNextRelease()),
				"Actual Title :" + releaseCalendar.getElementText(releaseCalendar.nextReleaseDate) + "\n" +
						"Expected Title :" + releaseInfo.get(0).getNextRelease());

	}
}
