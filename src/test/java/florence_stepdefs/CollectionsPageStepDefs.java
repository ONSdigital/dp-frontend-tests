package florence_stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import florence_pages.CollectionsPage;
import florence_pages.UsersAndAccessPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
import stepDefs.Hooks;
import utilities.CommonMethods;

/**
 * Created by admin on 21/10/2016.
 */
public class CollectionsPageStepDefs {

    public WebDriver driver;
    private CollectionsPage collectionsPage;
    private CommonMethods commonMethods;
    private UsersAndAccessPage usersAndAccessPage;

    public CollectionsPageStepDefs(){

        driver = Hooks.driver;
        collectionsPage = new CollectionsPage(driver);
        commonMethods = new CommonMethods(driver);
        usersAndAccessPage = new UsersAndAccessPage(driver);

    }

    @Then("^I should be on the Working on \"([^\"]*)\" section$")
    public void iShouldBeOnTheWorkingOnCollectionSection(String text) throws Throwable {

        Assert.assertEquals(collectionsPage.AmIOnWorkingOnCollectionSection(), "Working on: " + text);

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

    @Then("^I should be directed to the \"([^\"]*)\" tab$")
    public void iShouldBeDirectedToTab(String text) throws Throwable {
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

    @And("^The taxonomy is displayed$")
    public void theTaxonomyIsDisplayed() throws Throwable {
        collectionsPage.IsTaxonomyDisplayed();
    }

    @Then("^I should see the text \"([^\"]*)\" on the pop-up$")
    public void iShouldSeeTheTextOnThePopUp(String text) throws Throwable {
        collectionsPage.SeeTextOnThePopUp(text);
        commonMethods.SeeTheTextInAPage(text);
    }

    @And("^I should see the text \"([^\"]*)\" in the list of collections$")
    public void iShouldSeeTheTextInTheListOfCollections(String text) throws Throwable {
        usersAndAccessPage.SeeTheTextInATable(text);
    }

    @And("^I click on the visualisation publisher page awaiting review$")
    public void iClickOnTheVisualisationPublisherPageAwaitingReview() throws Throwable {
        collectionsPage.ClickOnTheVisualisationPageToReview();
    }
}
