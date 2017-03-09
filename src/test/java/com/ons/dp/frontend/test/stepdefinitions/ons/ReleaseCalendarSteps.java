package com.ons.dp.frontend.test.stepdefinitions.ons;


import com.ons.dp.frontend.test.core.TestContext;
import com.ons.dp.frontend.test.model.CalendarEntry;
import com.ons.dp.frontend.test.page.webpage.ReleaseCalendar;
import com.ons.dp.frontend.test.page.webpage.SearchReleases;
import com.ons.dp.frontend.test.stepdefinitions.BaseStepDefinition;
import com.ons.dp.frontend.test.util.AnyData;
import com.ons.dp.frontend.test.util.CustomDates;
import com.ons.dp.frontend.test.util.Helper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ReleaseCalendarSteps {
	ReleaseCalendar releaseCalendar = new ReleaseCalendar();
	SearchReleases searchReleases = new SearchReleases();
	private BaseStepDefinition baseStepDefinition;

	public ReleaseCalendarSteps() {
		this.baseStepDefinition = new BaseStepDefinition();
	}

	@Given("^click on (UPCOMING|PUBLISHED) release calendar$")
	public void goToReleasesCalendar(String calendar) {
		releaseCalendar.goToReleaseCalendar();
		if (!releaseCalendar.getSelectedTab().contains("Upcoming") && (calendar.contains("UPCOMING"))) {
			releaseCalendar.clickUpcomingReleases();
		} else {
			releaseCalendar.clickPublishedCalendar();
		}
		TestContext.getCacheService().setDataMap("releaseType", new AnyData(calendar));
	}

	@And("^search for the release with keyword, published after and published before dates")
	public void searchForReleases() {
		String releaseTitle = TestContext.getCacheService().getDataMap().get("calendarEntry").getStringData();
		searchReleases.searchReleases(releaseTitle, CustomDates.getDate(-1), CustomDates.getDate(2));
	}

	@And("^search results contains the release information$")
	public void verifyReleaseIsDisplayed() throws InterruptedException {
		// Waiting for a minute as search not updating straight away
		Thread.sleep(60000);
		releaseCalendar.refresh();
		Thread.sleep(60000);
		releaseCalendar.refresh();
		String releaseTitle = TestContext.getCacheService().getDataMap().get("calendarEntry").getStringData();
		while (releaseCalendar.isElementPresent(releaseCalendar.returnNextPage())) {
			releasePresent(releaseTitle);
			releaseCalendar.click(releaseCalendar.returnNextPage());
		}
		releasePresent(releaseTitle);

	}

	public void releasePresent(String release) {
		boolean releasePresent = releaseCalendar.selectRelease(release) ? true : false;
		assertTrue(releasePresent);
	}

	@Then("^verify the release information$")
	public void verifyReleaseInfo() {
		// verifies the actual header contains the details from the cucumber
		String releaseName = TestContext.getCacheService().getDataMap().get("calendarEntry").getStringData();
		String releaseType = TestContext.getCacheService().getDataMap().get("releaseType").getStringData();
		CalendarEntry calendarEntry = (CalendarEntry) TestContext.getCacheService().getDataMap().get("CalendarDetails").getDataObject();
		assertTrue(releaseCalendar.getElementText(releaseCalendar.releaseHeader).contains(releaseName),
				"Actual Title :" + releaseCalendar.getElementText(releaseCalendar.releaseHeader) + "\n" +
						"Expected Title :" + calendarEntry.getSummary());
		assertEquals(releaseCalendar.getContactName(), calendarEntry.getContactName());
//		if(releaseCalendar.getContactEmail()!=null) {
//			assertEquals(releaseCalendar.getContactEmail(), calendarEntry.getContactEmail());
//		}
		if (releaseCalendar.doesImageExist()) {
			assertTrue(calendarEntry.getOnsimage().equalsIgnoreCase("true"));
		}
		if (releaseType.equalsIgnoreCase("UPCOMING")) {
			assertTrue(releaseCalendar.isElementPresent(releaseCalendar.alert_title));
		}
		if (calendarEntry.getProvisionalDateRange() != null) {
			assertTrue(releaseCalendar.pageSourceContains(calendarEntry.getProvisionalDateRange()));
		}
		if (calendarEntry.getNextRelease() != null) {
			assertTrue(releaseCalendar.pageSourceContains(calendarEntry.getNextRelease()));
		}
		assertTrue(releaseCalendar.pageSourceContains(calendarEntry.getSummary()));


	}

	@And("^search results contains the bulletin information$")
	public void searchResultsContainsTheBulletinInformation() throws Throwable {
		String bulletinPage = TestContext.getCacheService().getDataMap().get("bulletinPage").getStringData();
		releaseCalendar.refresh();
		Helper.pause(1000);
		releaseCalendar.refresh();

		assertTrue(releaseCalendar.pageSourceContains(bulletinPage.replace(" ()", "")));


	}
}
