package com.ons.dp.frontend.test.stepdefinitions.ons;

import com.ons.dp.frontend.test.page.webpage.SearchResultsPage;
import cucumber.api.java.en.Then;

public class SearchResultsPageSteps {

    SearchResultsPage searchResultsPage = new SearchResultsPage();

    @Then("^there should not be any search results related to \"([^\"]*)\" page$")
    public void thereShouldNotBeAnySearchResultsRelatedToPage(String searchText) throws Throwable {
        searchResultsPage.noSearchResults(searchText);
    }

    @Then("^there should be a search result related to \"([^\"]*)\" page$")
    public void thereShouldBeAResultRelatedToPage(String searchText) throws Throwable {
        searchResultsPage.searchResults(searchText);
    }
}
