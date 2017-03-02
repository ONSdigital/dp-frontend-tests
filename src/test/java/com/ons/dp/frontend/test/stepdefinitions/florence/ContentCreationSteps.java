package com.ons.dp.frontend.test.stepdefinitions.florence;

import com.ons.dp.frontend.test.core.TestContext;
import com.ons.dp.frontend.test.model.CalendarEntry;
import com.ons.dp.frontend.test.model.ContentText;
import com.ons.dp.frontend.test.model.FoiEntry;
import com.ons.dp.frontend.test.page.publish.ContentCreation;
import com.ons.dp.frontend.test.stepdefinitions.BaseStepDefinition;
import com.ons.dp.frontend.test.util.AnyData;
import com.ons.dp.frontend.test.util.CustomDates;
import com.ons.dp.frontend.test.util.RandomStringGen;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import java.util.List;


public class ContentCreationSteps {
    ContentCreation contentCreation = new ContentCreation();
    private BaseStepDefinition baseStepDefinition;

    public ContentCreationSteps() {
        this.baseStepDefinition = new BaseStepDefinition();
    }

    @When("^I browse to the content (.*) under collections$")
    public void browseToTheContent(String contentToBrowse) throws Exception {
        if (contentToBrowse.contains("random page")) {
            String pageName = TestContext.getCacheService().getDataMap().get("pageName").getStringData();
            contentToBrowse = contentToBrowse.replace("random page", pageName.toLowerCase());
        }
        contentCreation.goToCMSContentLinks(contentToBrowse);

    }

    @And("^I browse to the releases content under collections$")
    public void iBrowseToTheReleasesContentUnderCollections() throws Throwable {
        contentCreation.goToReleasesFolder();
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
        // String pageName = "AutoPage" + RandomStringGen.getRandomString(5);
        //  TestContext.getCacheService().setDataMap("pageName", new AnyData(pageName));
        contentCreation.createPageAndSaveForReview(pageType, TestContext.getCacheService().getDataMap().get("pageName").getStringData());
    }

    @And("^I create a \"([^\"]*)\" and submit for review$")
    public void iCreateAPage(String pageType) throws Throwable {
        String pageName = "AutoPage" + RandomStringGen.getRandomString(5);
        TestContext.getCacheService().setDataMap("pageName", new AnyData(pageName));
        contentCreation.createPageAndSaveForReview(pageType, TestContext.getCacheService().getDataMap().get("pageName").getStringData());
    }

	@And("^create a new calendar entry$")
	public void calendarEntry() throws Throwable {
		String pageName = RandomStringGen.getRandomString(8);
		contentCreation.createCalendarEntry(CustomDates.getDate(1), "09:30", pageName);
		TestContext.getCacheService().setDataMap("calendarEntry", new AnyData(pageName));
	}

    @And("^create a new release calendar entry and submit for review$")
    public void createANewReleaseCalendarEntry() throws Throwable {
        String pageName = RandomStringGen.getRandomString(8);
        contentCreation.createReleaseCalendarEntry(CustomDates.getDate(1), "09:30", pageName);
        TestContext.getCacheService().setDataMap("calendarEntry", new AnyData(pageName));
    }

    @And("^add the following details to the calendar entry$")
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
        contentCreation.createFOIEntry(CustomDates.getDateInDiffFormat(-1), pageName);
        TestContext.getCacheService().setDataMap("foiEntry", new AnyData(pageName));
    }

    @And("^add the following details to the FOI entry$")
    public void addTheFollowingDetailsToTheFOIEntry(List<FoiEntry> fOIEntry) throws Throwable {
        //  fOIEntry.get(0).setSummary(TestContext.getCacheService().getDataMap().get("collectionName").getStringData());
        TestContext.getCacheService().setDataMap("FOIDetails", new AnyData(fOIEntry.get(0)));
        contentCreation.addFOIEntryMetadata(fOIEntry.get(0));
    }

    @And("^I create a new \"([^\"]*)\" with page name \"([^\"]*)\" and submit for review$")
    public void iCreateANewWithPageNameAndSubmitForReview(String pageType, String pageName) throws Throwable {
        contentCreation.createPageAndSave(pageType, pageName);
    }

    @And("^add a bar chart$")
    public void addAChart() throws Throwable {
        contentCreation.addContentToContentSection();
        contentCreation.metaDataTabInChartData();
        contentCreation.chartTabForBarChartData();
        contentCreation.advancedTabForBarChart();
        contentCreation.annotationTabForChart();

    }

    @And("^add a line chart$")
    public void addALineChart() throws Throwable {
        contentCreation.addContentToContentSection();
        contentCreation.metaDataTabInChartData();
        contentCreation.chartTabForLineChartData();
        contentCreation.advancedTabForLineChart();

    }

    @And("^verify the bar chart data in preview$")
    public void verifyTheChartDataInPreview() throws Throwable {
        contentCreation.verifyBarChartDataInPreview();
        contentCreation.saveTheChart();
    }

    @And("^verify the line chart data in preview$")
    public void verifyTheLineChartDataInPreview() throws Throwable {
        contentCreation.verifyLineChartDataInPreview();
        contentCreation.saveTheChart();
    }

    @And("^I get the chart data$")
    public void iGetTheChartData() throws Throwable {
        contentCreation.getChartData();
    }
}
