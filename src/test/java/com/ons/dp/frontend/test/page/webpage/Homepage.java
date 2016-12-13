package com.ons.dp.frontend.test.page.webpage;

import com.ons.dp.frontend.test.page.BasePage;
import org.openqa.selenium.By;

public class Homepage extends BasePage {
    public By search = By.id("nav-search");
    public By about = By.linkText("aboutus");

    public void openHomePage() {
        navigateToUrl(getConfig().getOnsURL());

    }

    public void searchForTimeSeriesID(String timeSeriesID) {
        getElement(search).sendKeys(timeSeriesID);

    }

    public void goToPage(String linkToGoTo) {
        navigateToUrl(getConfig().getOnsdevelop_URL() + "/" + linkToGoTo);
    }

}
