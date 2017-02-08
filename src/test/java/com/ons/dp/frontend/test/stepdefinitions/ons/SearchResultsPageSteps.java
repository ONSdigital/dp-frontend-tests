package com.ons.dp.frontend.test.stepdefinitions.ons;

import com.ons.dp.frontend.test.core.TestContext;
import com.ons.dp.frontend.test.page.webpage.SearchResultsPage;
import com.ons.dp.frontend.test.stepdefinitions.BaseStepDefinition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class SearchResultsPageSteps {

    SearchResultsPage searchResultsPage = new SearchResultsPage();
    private BaseStepDefinition baseStepDefinition;


    public SearchResultsPageSteps() {
        this.baseStepDefinition = new BaseStepDefinition();
    }

    @Then("^there should not be any search results related to \"([^\"]*)\" page$")
    public void thereShouldNotBeAnySearchResultsRelatedToPage(String searchText) throws Throwable {
        searchResultsPage.noSearchResults(TestContext.getCacheService().getDataMap().get("pageName").getStringData());
    }

    @Then("^there should be a search result related to \"([^\"]*)\" page$")
    public void thereShouldBeAResultRelatedToPage(String searchText) throws Throwable {
        searchResultsPage.searchResults(TestContext.getCacheService().getDataMap().get("pageName").getStringData());
    }

    @And("^I click on search result$")
    public void iClickOnSearchResult() throws Throwable {
        String searchResult = TestContext.getCacheService().getDataMap().get("foiEntry").getStringData();
        searchResultsPage.findResultAndClick(searchResult);
    }
}
