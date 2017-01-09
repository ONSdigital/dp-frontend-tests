package com.ons.dp.frontend.test.stepdefinitions.florence;

import com.ons.dp.frontend.test.core.TestContext;
import com.ons.dp.frontend.test.model.CalendarEntry;
import com.ons.dp.frontend.test.model.ContentText;
import com.ons.dp.frontend.test.model.FoiEntry;
import com.ons.dp.frontend.test.page.publish.ContentCreation;
import com.ons.dp.frontend.test.util.AnyData;
import com.ons.dp.frontend.test.util.CustomDates;
import com.ons.dp.frontend.test.util.RandomStringGen;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import java.util.List;


public class ContentCreationSteps {
    ContentCreation contentCreation = new ContentCreation();

    @When("^I browse to the content (.*) under collections$")
    public void browseToTheContent(String contentToBrowse) throws Exception {
        contentCreation.goToCMSContentLinks(contentToBrowse);

    }

    @And("^I click on Edit button$")
    public void clickOnActiveEditButton() {
        contentCreation.clickOnActiveEditButton();
    }

    @And("^I click on Create button$")
    public void clickOnActiveCreateButton() {
        contentCreation.clickOnActiveCreateButton();
    }

    @And("^I upload a ([^\"]*) file$")
    public void iUploadAFile(String fileType) throws Throwable {
        contentCreation.upLoadFile(fileType);
        TestContext.getCacheService().setDataMap("versionsPublishedbefore",
                new AnyData(contentCreation.getNumberOfPublishedVersions()));

    }


    @And("^I save and submit the collection for review")
    public void saveAndSubmitColl() {
        contentCreation.saveChangesForReview();
    }


    @And("^I approve the collection$")
    public void approveTheColl() throws Throwable {
        contentCreation.approveCollection();
    }


    @And("^I create a new \"([^\"]*)\" and submit for review$")
    public void iCreateANew(String pageType) throws Throwable {
	    //String pageName = "AutoPage_" + RandomStringGen.getRandomString(5);
	    // TestContext.getCacheService().setDataMap("pageName", new AnyData(pageName));
	    contentCreation.createPageAndSaveForReview(pageType);
    }

	@And("^create a new calendar entry$")
	public void calendarEntry() throws Throwable {
		String pageName = RandomStringGen.getRandomString(8);
		contentCreation.createCalendarEntry(CustomDates.getDate(1), "09:30", pageName);
		TestContext.getCacheService().setDataMap("calendarEntry", new AnyData(pageName));
	}

	@And("^add the following details to the calendary entry$")
	public void editCalendarEntry(List <CalendarEntry> calendarEntry) {
		calendarEntry.get(0).setSummary(TestContext.getCacheService().getDataMap().get("collectionName").getStringData());
		TestContext.getCacheService().setDataMap("CalendarDetails", new AnyData(calendarEntry.get(0)));
		contentCreation.addCalendarMetaData(calendarEntry.get(0));
	}

    @And("^I click on the content header (.*)$")
    public void editContentHeader(String contentHeader) {
        contentCreation.editContentHeader(ContentText.valueOf(contentHeader));
    }

    @And("^I edit the content on the collection$")
    public void clickOnEdit() {
        contentCreation.clickOnActivatedEdit();
    }

    @And("^I edit the content within the active accordion")
    public void clickEditWithinAccordion() {
        contentCreation.clickEditAccordion();
    }

    @And("^I enter text into the markdown editor$")
    public void enterTextIntoEditor() {
        String textToEnter = RandomStringGen.getRandomString(200);
        TestContext.getCacheService().setDataMap("markdownText", new AnyData(textToEnter));
        contentCreation.enterTextIntoMarkDownEditor(textToEnter);
    }


    @And("^upload visulisation and submit for review$")
    public void uploadVisulisationAndSubmitForReview() throws Throwable {
        contentCreation.createVisualisationPageAndSaveForReview();
    }

    @And("^I enter keywords metadata and save for review$")
    public void iEnterKeywordsMetadata() throws Throwable {
        contentCreation.metaDataKeywords();
        contentCreation.saveSubmitForReview();
    }

    @And("^I delete the content$")
    public void iDeleteTheContent() throws Throwable {
        contentCreation.deleteContent();
    }

    @And("^create a new FOI entry$")
    public void createANewFOIEntry() throws Throwable {
        String pageName = RandomStringGen.getRandomString(8);
        contentCreation.createFOIEntry(CustomDates.getDate(-1), pageName);
        TestContext.getCacheService().setDataMap("foiEntry", new AnyData(pageName));
    }

    @And("^add the following details to the FOI entry$")
    public void addTheFollowingDetailsToTheFOIEntry(List<FoiEntry> fOIEntry) throws Throwable {
        //  fOIEntry.get(0).setSummary(TestContext.getCacheService().getDataMap().get("collectionName").getStringData());
        TestContext.getCacheService().setDataMap("FOIDetails", new AnyData(fOIEntry.get(0)));
        contentCreation.addFOIEntryMetadata(fOIEntry.get(0));
    }
}
