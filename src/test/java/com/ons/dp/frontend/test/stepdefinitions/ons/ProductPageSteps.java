package com.ons.dp.frontend.test.stepdefinitions.ons;


import com.ons.dp.frontend.test.core.TestContext;
import com.ons.dp.frontend.test.page.webpage.ProductPage;
import com.ons.dp.frontend.test.stepdefinitions.BaseStepDefinition;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ProductPageSteps {

    public By page_header_title = By.cssSelector(".page-header__title");
    ProductPage productPage = new ProductPage();
    private BaseStepDefinition baseStepDefinition;

    public ProductPageSteps() {
        this.baseStepDefinition = new BaseStepDefinition();
    }

    @When("^I navigate to Business Investment time series dataset$")
    public void navigateToTimeSeries() throws Throwable {
        productPage.navigateToBusinessInvestmentDatasetPage();
    }

    @And("^I navigate to Labour productivity time series page$")
    public void iNavigateToLabourProductivityTimeSeriesPage() throws Throwable {
        productPage.navigateToLabourProductivityPage();
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

    @And("^the ONS website (does|does not) contain the new (.*) chart details$")
    public void getONSChartChanges(String exist, String chartType) throws InterruptedException {
        boolean exists = exist.length() <= 4;

        String pageName = TestContext.getCacheService().getDataMap().get("pageName").getStringData();
        String editionName = TestContext.getCacheService().getDataMap().get("editionName").getStringData();
        if (exists) {
            productPage.refresh();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (chartType.contains("bar")) {
                productPage.verifyBarChartData(pageName, editionName);
            } else {
                if (chartType.contains("line")) {
                    productPage.verifyLineChartData(pageName, editionName);
                }
            }


        } else {
            productPage.refresh();
            Assert.assertTrue("The changes are not on the ONS website", productPage.getElementText(page_header_title).contentEquals("404 - The webpage you are requesting does not exist on the site"));
        }

    }


    @When("^I customize time period$")
    public void iCustomizeTimePeriod() throws Throwable {
        productPage.customiseTimePeriod();
    }

    @Then("^chart should reflect the time period chosen$")
    public void chartShouldReflectTheTimePeriodChosen() throws Throwable {
        productPage.customisedGraph();
    }

    @And("^can download customised time series$")
    public void canDownloadCustomisedTimeSeries() throws Throwable {
        productPage.downloadCustomisedTimeSeries();
    }

    @And("^there should be a dataset download page$")
    public void thereShouldBeADatasetDownloadPage() throws Throwable {
        Assert.assertTrue(productPage.isDatasetDownloadBtnExists());
    }
}
