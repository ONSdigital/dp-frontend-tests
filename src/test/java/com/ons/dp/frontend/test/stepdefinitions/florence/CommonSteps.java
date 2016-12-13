package com.ons.dp.frontend.test.stepdefinitions.florence;


import com.ons.dp.frontend.test.page.BasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class CommonSteps {
    private BasePage basePage = new BasePage();

    @And("I logout of florence")
    public void logout_florence() {
        basePage.refresh();
        basePage.click(basePage.getlinkText("Logout"));
    }

    @Then("^I should see the text \"([^\"]*)\" on the pop-up$")
    public void textPopupOnPage(String text) throws Throwable {
        basePage.getTextFromPageSource(text);
    }
}
