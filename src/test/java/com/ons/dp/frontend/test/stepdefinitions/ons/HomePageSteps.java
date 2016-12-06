package com.ons.dp.frontend.test.stepdefinitions.ons;


import com.ons.dp.frontend.test.page.webpage.Homepage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class HomePageSteps {
    Homepage homePage = new Homepage();

    @Given("^I am on the ONS Website$")
    public void iAmOnTheWebsite() throws Throwable {
        homePage.openHomePage();
    }

    @When("^I search for \"([^\"]*)\" timeseries dataset$")
    public void iSearchForTimeseriesDataset(String timeSeriesID) throws Throwable {
        homePage.searchForTimeSeriesID(timeSeriesID);
    }

}
