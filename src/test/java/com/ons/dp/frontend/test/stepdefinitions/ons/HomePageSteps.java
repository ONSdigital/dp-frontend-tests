package com.ons.dp.frontend.test.stepdefinitions.ons;


import com.ons.dp.frontend.test.core.TestContext;
import com.ons.dp.frontend.test.model.FoiEntry;
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
    public By content_section_text = By.cssSelector(".section__content--static-markdown>p");
    public By column_text = By.xpath("//div[@class='col-wrap']/p");
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

        // AnyData pageName = TestContext.getCacheService().getDataMap().get("pageName");
        if (exists) {
            basePage.refresh();
            Assert.assertTrue("The changes are not on the ONS website", homePage.getElementText(page_title).contentEquals("bDsx5G8"));
        } else {
            basePage.refresh();
            Assert.assertTrue("The changes are not on the ONS website", homePage.getElementText(page_header_title).contentEquals(
                    "404 - The webpage you are requesting does not exist on the site"));
        }

    }

    @Then("^the ONS website (does|does not) contain the classifications changes with page \"([^\"]*)\"$")
    public void theONSWebsiteDoesContainTheClassificationsChangesWithPage(String exist, String pageName) throws Throwable {

        boolean exists = exist.length() <= 4;

        if (exists) {
            basePage.refresh();
            Assert.assertTrue("The changes are not on the ONS website", homePage.getElementText(page_title).contentEquals(pageName));
        } else {
            basePage.refresh();
            Assert.assertTrue("The changes are not on the ONS website", homePage.getElementText(page_header_title).contentEquals(
                    "404 - The webpage you are requesting does not exist on the site"));
        }
    }


    @When("^I search for \"([^\"]*)\" in the ONS Website$")
    public void iSearchForInTheONSWebsite(String text) throws Throwable {
        homePage.searchForTimeSeriesID(text);
    }

    @Given("^I am on the ONS HomePage$")
    public void iAmOnTheONSHomePage() throws Throwable {
        homePage.openHomePage();
    }

    @And("^I navigate to (.*) on the ONS Website$")
    public void iNavigateToBusinessInvestmentTimeSeriesDatasetOnTheONSWebsite(String urlPath) throws Throwable {
        String pagelink = TestContext.getCacheService().getDataMap().get("foiEntry").getStringData();
        homePage.goToPage(urlPath + pagelink);

    }

    @Then("^the ONS website does contain the FOI changes$")
    public void theONSWebsiteDoesContainTheFOIChanges() throws Throwable {

        String pagename = TestContext.getCacheService().getDataMap().get("foiEntry").getStringData();
        FoiEntry foiEntry = (FoiEntry) TestContext.getCacheService().getDataMap().get("FOIDetails").getDataObject();

        Assert.assertEquals(homePage.getElementText(page_title), "Freedom of Information (FOI):\n" + pagename);

        Assert.assertEquals(homePage.getElementText(content_section_text), foiEntry.getMarkdownText());

        // Assert.assertEquals(homePage.getElementText(column_text), CustomDates.getDate(-1).);

    }

    @When("^I search for the changes in the ONS Website$")
    public void iSearchForTheChangesInTheONSWebsite() throws Throwable {
        String text = TestContext.getCacheService().getDataMap().get("foiEntry").getStringData();
        homePage.searchForTimeSeriesID(text);
    }


}
