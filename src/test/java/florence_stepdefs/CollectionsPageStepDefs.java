package florence_stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import florence_pages.CollectionsPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
import stepDefs.Hooks;

/**
 * Created by admin on 21/10/2016.
 */
public class CollectionsPageStepDefs {

    public WebDriver driver;
    private CollectionsPage collectionsPage;

    public CollectionsPageStepDefs(){

        driver = Hooks.driver;
        collectionsPage = new CollectionsPage(driver);

    }

    @Then("^I should be on the Working on Collection section$")
    public void iShouldBeOnTheWorkingOnCollectionSection() throws Throwable {

        Assert.assertEquals(collectionsPage.AmIOnWorkingOnCollectionSection(), "Working on: Release Calendar");

    }

    @When("^I click on \"([^\"]*)\" static landing page$")
    public void iClickOnStaticLandingPage(String text) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        collectionsPage.ClickAStaticLandinGpage(text);

    }

    @And("^I click on \"([^\"]*)\" option$")
    public void iClickOnOption(String text) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        collectionsPage.ClickOnEditButton(text)         ;

    }

    @And("^click on Edit button in Content section$")
    public void clickOnEditButtonInContentSection() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        collectionsPage.ClickOnEditButtonInContent();
    }

    @When("^I click on \"([^\"]*)\" collection$")
    public void iClickOnCollection(String text) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        collectionsPage.SelectACollectionFromListOfCollections(text);
    }

    @And("^I click on the page awaiting review$")
    public void iClickOnThePageAwaitingReview() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        collectionsPage.ClickOnThePageToReview();
    }

    @Then("^a \"([^\"]*)\" should be shown in \"([^\"]*)\"$")
    public void aShouldBeShownIn(String text, String linkText) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        collectionsPage.SelectACollectionInPublishingQueue(text, linkText);
    }

    @Then("^I should see the text \"([^\"]*)\" on the bottom of the page$")
    public void iShouldSeeTheTextInTheBottomOfThePage(String text) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        collectionsPage.SeeTextInASectionOfThePage(text);
    }


    @Then("^I should be directed to \"([^\"]*)\" tab in Florence by default$")
    public void iShouldBeDirectedToTabInFlorenceByDefault(String text) throws Throwable {
        collectionsPage.IsThisTabSelected(text);
    }

    @And("^Presented with \"([^\"]*)\" button$")
    public void presentedWithAnButton(String buttonText) throws Throwable {
        collectionsPage.IsEditAndCreateButtonShowing(buttonText);
    }


    @And("^The web preview is displayed$")
    public void theWebPreviewIsDisplayed() throws Throwable {
        collectionsPage.IsWebPreviewHomePageDisplayed();
    }
}
