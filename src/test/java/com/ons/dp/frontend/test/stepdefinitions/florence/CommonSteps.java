package com.ons.dp.frontend.test.stepdefinitions.florence;


import com.ons.dp.frontend.test.page.BasePage;
import com.ons.dp.frontend.test.page.webpage.UrlsPage;
import com.ons.dp.frontend.test.stepdefinitions.BaseStepDefinition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class CommonSteps {

    public By Select_a_document_to_view = By.id("docs-list");
    private BaseStepDefinition baseStepDefinition;
    private BasePage basePage = new BasePage();
    private UrlsPage urlsPage = new UrlsPage();

    public CommonSteps() {
        this.baseStepDefinition = new BaseStepDefinition();
    }

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

    @When("^I click on \"([^\"]*)\" link$")
    public void iClickOnLink(String linkText) throws Throwable {
        basePage.ClickOnLink(linkText);
    }

    @Then("^I should be on the (.*) page$")
    public void iShouldBeOnThePage(String key) throws Throwable {

        Assert.assertTrue(urlsPage.isUrlDisplayed(key));

    }

    @Then("^I should not be on the (.*) page$")
    public void iShouldNotBeOnThePage(String key) throws Throwable {
        Assert.assertFalse(urlsPage.isUrlDisplayed(key));
    }

    @Given("^I am on the \"([^\"]*)\" page$")
    public void iAmOnThePage(String Url) throws Throwable {

        urlsPage.NavigateToPage(Url);

    }

}
