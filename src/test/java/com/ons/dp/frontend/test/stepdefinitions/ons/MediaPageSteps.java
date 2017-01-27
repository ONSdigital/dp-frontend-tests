package com.ons.dp.frontend.test.stepdefinitions.ons;

import com.ons.dp.frontend.test.page.webpage.MediaPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by manoj on 28/12/2016.
 */
public class MediaPageSteps {

    private MediaPage mediaPage = new MediaPage();

    @Then("^I should be provided with clickable links to all ONS published news$")
    public void i_should_be_provided_with_clickable_links_to_all_ONS_published_news() throws Throwable {
        mediaPage.IsLinksEnabled();
    }

    @And("^Links to published news are listed by date published$")
    public void linksToPublishedNewsAreListedByDatePublished() throws Throwable {
        mediaPage.IsPublishedNewsAreListedByDate();
    }

    @And("^I can refine results using keywords like \"([^\"]*)\"$")
    public void iCanRefineResultsUsingKeywordsLike(String keyword) throws Throwable {

        mediaPage.RefineSearchResultsByKeyWord(keyword);
    }

    @And("^Provided with links to The National Archives for archived releases$")
    public void providedWithLinksToTheNationalArchivesForArchivedReleases() throws Throwable {

        mediaPage.VerifyNationalArchivesLink();
    }

    @When("^I click first link in published news$")
    public void iClickFirstLinkInPublishedNews() throws Throwable {
        mediaPage.ClickFirstLinkInPublishedNews();

    }

    @And("^I should be provided with clickable links to all ONS published statements and letters$")
    public void iShouldBeProvidedWithClickableLinksToAllONSPublishedStatementsAndLetters() throws Throwable {

        mediaPage.IsLinksEnabled();
    }

    @And("^Links to published statements and letters are listed by date published$")
    public void linksToPublishedStatementsAndLettersAreListedByDatePublished() throws Throwable {

        mediaPage.IsPublishedNewsAreListedByDate();
    }

    @And("^Provided with a mailto email address - (.*)$")
    public void providedWithAMailtoEmailAddressMediaRelationsOnsGsiGovUk(String emailAddress) throws Throwable {

        mediaPage.IsMediaRelationsEmailEnabled(emailAddress);

    }

    @And("^Provided with a  \"([^\"]*)\" link within \"([^\"]*)\" section of the page$")
    public void providedWithALinkWithinSectionOfThePage(String link, String text) throws Throwable {

        mediaPage.VerifyLinkInABlock(link, text);
    }

    @And("^Provided with descriptive metadata$")
    public void providedWithDescriptiveMetadata() throws Throwable {

        mediaPage.CheckContentInGeneralAndStatisticalEnquiriesPage();
    }

    @And("^Provided with office location and address in Newport$")
    public void providedWithOfficeLocationAndAddressInNewport() throws Throwable {

        mediaPage.CheckNewportAddress();
    }

    @And("^Provided with office location and address in Titchfield$")
    public void providedWithOfficeLocationAndAddressInTitchfield() throws Throwable {

        mediaPage.CheckTitchfieldAddress();
    }

    @And("^Provided with office location and address in London$")
    public void providedWithOfficeLocationAndAddressInLondon() throws Throwable {

        mediaPage.CheckLondonAddress();
    }

    @And("^Each location has a clickable link to Google map$")
    public void eachLocationHasAClickableLinkToGoogleMap() throws Throwable {

        mediaPage.ClickableLinkToGoogleMap();
    }

    @When("^I view the links displayed on the website header$")
    public void iViewTheLinksDisplayedOnTheWebsiteHeader() throws Throwable {

        mediaPage.IsWebsiteHeaderLinksAreDisplayed();
    }

    @Then("^I should see the \"([^\"]*)\" link displayed$")
    public void iShouldSeeTheLinkDisplayed(String linkText) throws Throwable {
        mediaPage.IsMediaHeaderDisplayed(linkText);
    }

    @And("^Provided with a clickable link to the \"([^\"]*)\" section$")
    public void providedWithAClickableLinkToTheSection(String linkText) throws Throwable {
        mediaPage.IsLinkDisplayedAndEnabled(linkText);
    }

}


