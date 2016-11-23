package stepDefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
//import org.junit.Assert;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
import pages.MediaPage;
import utilities.CommonMethods;
import utilities.Log;
import utilities.Urls;

import static java.awt.SystemColor.text;


/**
 * Created by admin on 13/10/2016.
 */
public class CommonStepDefs extends Urls{

    public CommonMethods commonMethods;
    public WebDriver driver;
    private MediaPage mediaPage;
    private Urls uRLs;

    public CommonStepDefs()  {
        driver = Hooks.driver;

        commonMethods = new CommonMethods(driver);
        mediaPage = new MediaPage(driver);
        uRLs = new Urls();
    }

    @Then("^I should be on the (.*) page$")
    public void iShouldBeOnThePage(String key) throws Throwable {

        Assert.assertTrue(commonMethods.isUrlDisplayedX(key));

    }

    @Then("^I should not be on the (.*) page$")
    public void iShouldNotBeOnThePage(String key) throws Throwable {
        Assert.assertFalse(commonMethods.isUrlDisplayedX(key));
    }

    @Given("^I am on the \"([^\"]*)\" page$")
    public void iAmOnThePage(String Url) throws Throwable {

        commonMethods.NavigateToPage(Url);

    }

    @When("^I enter \"([^\"]*)\" in the (.*) field$")
    public void iEnterTextInTheField(String text, String element) throws Throwable {
          commonMethods.EnterStringIntoFiled(text, element);
    }

    @And("^I click \"([^\"]*)\" button$")
    public void iClickButton(String element) throws Throwable {

        Thread.sleep(100);
        commonMethods.ClickOnButton(element);
        Thread.sleep(500);
        Log.info("Clicked on " + element + " button");
    }

    @And("^I select (.*) radio button$")
    public void iSelectRadioButton(String element) throws Throwable {
        commonMethods.SelectRadioButton(element);

    }

    //@Given("^I click on \"([^\"]*)\" link$")
    @When("^I click on \"([^\"]*)\" link$")
    //@Then("^I click on \"([^\"]*)\" link$")
    public void iClickOnMediaLink(String linkText) throws Throwable {

        mediaPage.ClickOnLink(linkText);

    }

    @Then("^I should see the text \"([^\"]*)\" in \"([^\"]*)\" section$")
    public void iShouldSeeTheTextInSection(String text, String element) throws Throwable {
        Assert.assertTrue(commonMethods.GetTextFromElement(element).contains(text));
    }


    @Then("^I should see the text \"([^\"]*)\"$")
    public void iShouldSeeTheText(String text) throws Throwable {
         commonMethods.SeeTheTextInAPage(text);
    }

    @When("^I navigate to \"([^\"]*)\" Website$")
    public void iNavigateToWebsite(String Url) throws Throwable {
        String navigateToUrl = Urls.urlMapping.get(Url).toLowerCase();
        commonMethods.NavigateToUrl(navigateToUrl);
    }

    @Given("^I am on the \"([^\"]*)\" Website$")
    public void iAmOnTheWebsite(String Url) throws Throwable {
        String navigateToUrl = Urls.urlMapping.get(Url).toLowerCase();
        commonMethods.NavigateToUrl(navigateToUrl);
    }

    @And("^I select \"([^\"]*)\" from the (.*) dropdown$")
    public void iSelectFromTheSelectTheTeamTheCollectionCanBePreviewedByDropdown(String value, String elementID) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        commonMethods.SelectValueFromDropDown(value, elementID);
    }

    @When("^I select \"([^\"]*)\" in the (.*) Table$")
    public void iSelectInTheCollectionsTable(String text, String tableElement) throws Throwable {
        commonMethods.SelectTextInATable(text, tableElement);
    }

    @Then("^I should see the text \"([^\"]*)\" in the (.*) section$")
    public void iShouldSeeTheTextInThePageTitleSection(String text, String sectionElement) throws Throwable {
        commonMethods.SeeTheTextInASectionOfAPage(text, sectionElement);
    }

    @And("^I enter \"([^\"]*)\" in the (.*) pop-up text box$")
    public void iEnterInTheConfirmDeletionFieldPopUp(String text, String element) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        commonMethods.EnterStringIntoPopUpField(text, element);
    }

    @Then("^I should not see the \"([^\"]*)\" collection$")
    public void iShouldNotSeeTheCollection(String text) throws Throwable {
        commonMethods.ShouldNotSeeTheCollection(text);
    }

    @And("^I should see \"([^\"]*)\" dimension with \"([^\"]*)\" option selected and \"([^\"]*)\" link$")
    public void iShouldSeeDimensionWithOptionSelectedAndLink(String text, String element, String linkText) throws Throwable {

    }

    @And("^I should see the \"([^\"]*)\" button is enabled$")
    public void iShouldSeeTheButtonIsEnabled(String buttonText) throws Throwable {
        commonMethods.IsButtonEnabled(buttonText);
    }

    @When("^I select \"([^\"]*)\" check box$")
    public void iSelectCheckBox(String checkBoxText) throws Throwable {
        commonMethods.SelectCheckBox(checkBoxText);
    }

    @When("^I click the \"([^\"]*)\" link for \"([^\"]*)\" dimension$")
    public void iClickTheLinkForSexDimension(String linkText, String element) throws Throwable {
        commonMethods.SelectLinkInARow(linkText, element);
    }

    @And("^I should see \"([^\"]*)\" dimension with (.*) option selected and \"([^\"]*)\" link$")
    public void iShouldSeeDimensionWithAgeGroupOptionSelectedAndLink(String text, String element, String linkText) throws Throwable {

    }

    @And("^I refresh the page$")
    public void iRefreshThePage() throws Throwable {
        driver.navigate().refresh();
    }
}



