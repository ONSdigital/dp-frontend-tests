package com.ons.dp.frontend.test.page.webpage;

import Util.Log;
import com.ons.dp.frontend.test.page.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;


public class SearchResultsPage extends BasePage {

    public By search_results_text = By.cssSelector(".search-page__results-text");
    public By allresults_tab = By.cssSelector(".tab__link--active");
    public By search_help_text = By.id("js-search-help");
    public By numberOf_SearchResults_css = By.cssSelector(".search-results__title");

    public String no_results_text = "Sorry, no results were found that contain " + "‘" + "text" + "’";

    public String results_text = "1 results containing " + "‘" + "text" + "’" + "," + " sorted by relevance";

    public void noSearchResults(String searchText) {

        String actualText = getElementText(search_results_text);

        String expectedText = no_results_text.replace("text", searchText);

        Assert.assertTrue(actualText.contains(expectedText));

        Assert.assertEquals("All results (0)", getElementText(allresults_tab));

        Assert.assertTrue(getElementText(search_help_text).contains("You could try one of the following:\nsearch again using different words"));

    }

    public void searchResults(String searchText) throws InterruptedException {
        // Waiting for a minute as search not updating straight away
        Thread.sleep(60000);
        refresh();
        Thread.sleep(60000);
        refresh();
        //String actualText = getElementText(search_results_text);

        String expectedText = results_text.replace("text", searchText);

        Assert.assertTrue(getElementText(search_results_text).contains(expectedText));

        Assert.assertEquals("All results (1)", getElementText(allresults_tab));

        findResultAndClick(searchText);

        Assert.assertTrue(pageSourceContains(searchText));


    }

    public void findResultAndClick(String expectedResult) {

        ArrayList<WebElement> searchResults = (ArrayList<WebElement>) findElementsBy(numberOf_SearchResults_css);
        try {
            for (WebElement result : searchResults) {
                if (result.getText().contains(expectedResult)) {
                    result.click();
                    break;
                }
            }
        } catch (NullPointerException ee) {
            Log.info("Couldn't find the expected page");
        }

    }
}
