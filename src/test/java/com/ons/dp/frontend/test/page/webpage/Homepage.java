package com.ons.dp.frontend.test.page.webpage;

import com.ons.dp.frontend.test.page.BasePage;
import org.openqa.selenium.By;

public class Homepage extends BasePage {
    public By search = By.id("nav-search");

    public void openHomePage() {
        navigateToUrl(getConfig().getOnsdevelop_URL());

    }

    public void searchForTimeSeriesID(String timeSeriesID) {
        getElement(search).sendKeys(timeSeriesID);

    }

}
