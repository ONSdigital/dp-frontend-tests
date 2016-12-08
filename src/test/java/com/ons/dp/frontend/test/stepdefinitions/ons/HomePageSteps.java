package com.ons.dp.frontend.test.stepdefinitions.ons;


import com.ons.dp.frontend.test.page.webpage.Homepage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageSteps {
    Homepage homePage = new Homepage();

	@Given("^I navigate to the ONS Website$")
	public void iAmOnTheWebsite() throws Throwable {
        homePage.openHomePage();
    }

    @When("^I search for \"([^\"]*)\" timeseries dataset$")
    public void iSearchForTimeseriesDataset(String timeSeriesID) throws Throwable {
        homePage.searchForTimeSeriesID(timeSeriesID);
    }

	@When("^I browse to (.*) on the ONS page")
	public void gotoThePage(String pageToGo) {
		homePage.goToPage(pageToGo);
		System.out.println("Test");
	}

	@Then("^I browse to \"([^\"]*)\" on the ONS$")
	public void iBrowseToAboutusOnTheONS(String pagelink) {
		homePage.goToPage(pagelink);
		System.out.println("Test");
	}
}
