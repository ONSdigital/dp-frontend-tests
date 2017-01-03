package com.ons.dp.frontend.test.page.webpage;

import Util.Urls;
import com.ons.dp.frontend.test.page.BasePage;
import org.openqa.selenium.NoSuchElementException;

public class UrlsPage extends BasePage {

    public String Media = "news";

    public boolean isUrlDisplayed(String key) {
        try {
           // String expectedurl = getConfig().getOnsURL() + key;
            String expectedurl = Urls.urlMapping.get(key).toLowerCase();
            return getDriver().getCurrentUrl().equalsIgnoreCase(expectedurl);

        } catch (final NoSuchElementException e) {
            return false;
        }
    }


    public void NavigateToPage(String key){

        try {
            String navigateToUrl = Urls.urlMapping.get(key).toLowerCase();
            getDriver().navigate().to(navigateToUrl);

        } catch (final NoSuchElementException e) {

        }

    }
}
