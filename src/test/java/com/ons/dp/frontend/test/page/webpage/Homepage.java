package com.ons.dp.frontend.test.page.webpage;

import com.ons.dp.frontend.test.page.BasePage;
import org.openqa.selenium.By;

public class Homepage extends BasePage {
    public By search = By.id("nav-search");
    public By about = By.linkText("aboutus");
    public By search_Submit = By.id("nav-search-submit");

    public void openHomePage() {
        navigateToUrl(getConfig().getOnsdevelop_URL());

    }

    public void openSandPitHomePage() {
        navigateToUrl(getConfig().getOnsSandpit_URL());
    }

    public void searchForTimeSeriesID(String timeSeriesID) {
        getElement(search).sendKeys(timeSeriesID);
        click(search_Submit);

    }

    public void goToPage(String linkToGoTo) {

        navigateToUrl(getConfig().getOnsdevelop_URL() + linkToGoTo);
    }

    public void goToSandpitPage(String linkToGoTo) {

        navigateToUrl(getConfig().getOnsSandpit_URL() + linkToGoTo);
    }

    public void openLiveHomePage() {
        navigateToUrl(getConfig().getOnsURL());
    }
}
