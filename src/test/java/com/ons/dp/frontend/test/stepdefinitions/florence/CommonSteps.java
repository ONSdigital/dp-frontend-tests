package com.ons.dp.frontend.test.stepdefinitions.florence;


import com.ons.dp.frontend.test.page.BasePage;
import cucumber.api.java.en.And;

public class CommonSteps {
    private BasePage basePage = new BasePage();

    @And("I log out of florence")
    public void logout_florence() {
        basePage.click(basePage.getlinkText("Logout"));
    }
}
