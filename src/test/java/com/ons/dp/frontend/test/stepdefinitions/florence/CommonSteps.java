package com.ons.dp.frontend.test.stepdefinitions.florence;


import com.ons.dp.frontend.test.page.BasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class CommonSteps {
    public By Select_a_document_to_view = By.id("docs-list");
    private BasePage basePage = new BasePage();

    @And("I logout of florence")
    public void logout_florence() {
        basePage.refresh();
        basePage.click(basePage.getlinkText("Logout"));
    }

    @And("I logout of ermintrude")
    public void logout_ermintrude() {
        basePage.refresh();
        basePage.click(basePage.getlinkText("Logout"));
    }

    @Then("^I should see the text \"([^\"]*)\" on the pop-up$")
    public void textPopupOnPage(String text) throws Throwable {
        basePage.getTextFromPageSource(text);
    }

    @And("^I select \"([^\"]*)\" from the (.*) dropdown$")
    public void iSelectFromTheSelectADocumentToViewDropdown(String text, String element) throws Throwable {
        basePage.select(Select_a_document_to_view, text);
    }

    @Then("^I should see the text \"([^\"]*)\"$")
    public void iShouldSeeTheText(String text) throws Throwable {
        basePage.getTextFromPageSource(text);
    }

    @Then("^I should see the text \"([^\"]*)\" on the \"([^\"]*)\"$")
    public void iShouldSeeTheTextOnThe(String text, String element) throws Throwable {
        Assert.assertTrue(basePage.getElementText(By.cssSelector(element)).equals(text));
        Assert.assertEquals(basePage.getElementText(By.cssSelector(element)), text);
    }
}
