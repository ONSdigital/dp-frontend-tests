package com.ons.dp.frontend.test.stepdefinitions.ons;


import com.ons.dp.frontend.test.core.TestContext;
import com.ons.dp.frontend.test.page.webpage.ProductPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ProductPageSteps {
    ProductPage productPage = new ProductPage();

    @When("^I navigate to Business Investment time series dataset$")
    public void navigateToTimeSeries() throws Throwable {
        productPage.navigateToBusinessInvestmentDatasetPage();
    }

    @And("^I click the previous versions$")
    public void clickPreviousVersions() throws Throwable {
        productPage.clickPreviousVersionsLink();
    }

    @Then("^I should see the new time series dataset$")
    public void shouldSeeTimeSeriesDataset() throws Throwable {
        int recentPubVer = productPage.getPublishedVersionRows();
        int prevPubVer = TestContext.getCacheService().getDataMap().get("versionsPublishedbefore").getIntData();
        Assert.assertTrue("Number of published versions in ONS website  :" + recentPubVer + "/n Number of published versions in Florence : " + prevPubVer,
                recentPubVer == (prevPubVer + 1));
    }

}
