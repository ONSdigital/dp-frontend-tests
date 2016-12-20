package com.ons.dp.frontend.test.stepdefinitions.ons;


import com.ons.dp.frontend.test.core.TestContext;
import com.ons.dp.frontend.test.page.BasePage;
import com.ons.dp.frontend.test.page.webpage.Homepage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePageSteps {
    public By page_title = By.cssSelector(".page-intro__title");
    public By page_header_title = By.cssSelector(".page-header__title");
    Homepage homePage = new Homepage();
    BasePage basePage = new BasePage();

    @Given("I navigate to the ONS Website$")
    public void iAmOnTheWebsite() throws Throwable {
        homePage.openHomePage();
    }

    @When("I search for \"([^\"]*)\" timeseries dataset$")
    public void iSearchForTimeseriesDataset(String timeSeriesID) throws Throwable {
        homePage.searchForTimeSeriesID(timeSeriesID);
    }

    @When("I browse to (.*) on the ONS page")
    public void gotoThePage(String pageToGo) {
        homePage.goToPage(pageToGo);
        System.out.println("Test");
    }

    @Then("^I browse to \"([^\"]*)\" on the ONS$")
    public void browseToAboutUs(String pagelink) {
        homePage.goToPage(pagelink);
        System.out.println("Test");
    }

    @And("^the ONS website contains the published changes$")
    public void getONSChanges() {
        Assert.assertTrue("The changes are not on the ONS website", homePage.pageSourceContains(TestContext.getCacheService().getDataMap().get("markdownText").getStringData()));
    }

    @And("^the ONS website (does|does not) contain the classifications changes$")
    public void getONSClassificationChanges(String exist) {
        boolean exists = exist.length() <= 4;

        if (exists) {
            basePage.refresh();
            Assert.assertTrue("The changes are not on the ONS website", homePage.getElementText(page_title).contentEquals("Admin Page"));
        } else {
            basePage.refresh();
            Assert.assertTrue("The changes are not on the ONS website", homePage.getElementText(page_header_title).contentEquals(
                    "404 - The webpage you are requesting does not exist on the site"));
        }

    }


}
