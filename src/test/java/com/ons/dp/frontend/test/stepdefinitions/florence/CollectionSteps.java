package com.ons.dp.frontend.test.stepdefinitions.florence;

import com.ons.dp.frontend.test.core.TestContext;
import com.ons.dp.frontend.test.page.publish.Collection;
import com.ons.dp.frontend.test.page.publish.ContentCreation;
import com.ons.dp.frontend.test.stepdefinitions.BaseStepDefinition;
import com.ons.dp.frontend.test.util.AnyData;
import com.ons.dp.frontend.test.util.RandomStringGen;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class CollectionSteps {
    Collection collection = new Collection();
    ContentCreation contentCreation = new ContentCreation();
    private BaseStepDefinition baseStepDefinition;

    public CollectionSteps() {
        this.baseStepDefinition = new BaseStepDefinition();
    }

    @Given("I create a (MANUAL|SCHEDULED_CUSTOM|SCHEDULED_CALENDAR_ENTRY) collection type$")
    public void createColl(String collType) {

        String collectionName = "AutoTest_" + RandomStringGen.getRandomString(5);
        TestContext.getCacheService().setDataMap("collectionName", new AnyData(collectionName));
        //String teamName = TestContext.getCacheService().getDataMap().get("teamName").getStringData();
        switch (collType) {
            case "MANUAL":
                collection.createCollection(collectionName, Collection.CollectionTypes.MANUAL, null);
                break;
            case "SCHEDULED_CUSTOM":
                String teamName = TestContext.getCacheService().getDataMap().get("teamName").getStringData();
                collection.createCollection(collectionName, Collection.CollectionTypes.SCHEDULE_CUSTOM, teamName);
                break;
            case "SCHEDULED_CALENDAR_ENTRY":
                collection.createCollection(collectionName, Collection.CollectionTypes.SCHEDULE_CALENDAR_ENTRY, null);
                break;

        }
    }

    @And("^I delete the collection$")
    public void deleteCollection() throws Throwable {
        String colName = TestContext.getCacheService().getDataMap().get("collectionName").getStringData();
        collection.deleteCollection(colName);

    }

    @And("^I delete all the worked on pages in the collection")
    public void deleteAllTheWorkedOnpages() {
        String colName = TestContext.getCacheService().getDataMap().get("collectionName").getStringData();
        collection.deleteAllWorkedPages(colName);
    }

    @And("^I select the collection$")
    public void selectTheCollection() {
        collection.clickOnCollectionsLink();
        String colName = TestContext.getCacheService().getDataMap().get("collectionName").getStringData();
        collection.getCollection(colName);

    }

    @And("^I review the (.*) files awaiting review with data-url:(.*)$")
    public void reviewFilesInColl(String savedPage, String fileloc) throws Throwable {
        String colName = TestContext.getCacheService().getDataMap().get("collectionName").getStringData();
        collection.reviewFile(colName, savedPage, fileloc);
    }

    @And("^I review the files awaiting review with data-url:(.*)$")
    public void reviewFilesInTheColl(String fileloc) throws Throwable {
        String colName = TestContext.getCacheService().getDataMap().get("collectionName").getStringData();
        String randonPageName = TestContext.getCacheService().getDataMap().get("pageName").getStringData();
        collection.reviewFile(colName, randonPageName, fileloc.replace("random page", randonPageName));
    }

    @And("^I review the chart file awaiting review with data-url:(.*)$")
    public void reviewChartFilesInTheColl(String fileloc) throws Throwable {
        String colName = TestContext.getCacheService().getDataMap().get("collectionName").getStringData();
        String randonPageName = TestContext.getCacheService().getDataMap().get("pageName").getStringData();
        String randonEditionName = TestContext.getCacheService().getDataMap().get("editionName").getStringData();
        collection.reviewFile(colName, randonPageName, fileloc.replace("random page", randonPageName + "/" + randonEditionName));
    }

    @And("^I review the (.*) bulletin file awaiting review with data-url:(.*)$")
    public void reviewBulletinFileInColl(String savedPage, String fileloc) throws Throwable {
        String colName = TestContext.getCacheService().getDataMap().get("collectionName").getStringData();
        TestContext.getCacheService().setDataMap("bulletinPage", new AnyData(savedPage));
        collection.reviewBulletionFile(colName, savedPage, fileloc);
    }

	@And("^I review the calendar entry files awaiting review$")
	public void reviewFiles() throws Throwable {
		String savedPage = TestContext.getCacheService().getDataMap().get("calendarEntry").getStringData();
		String colName = TestContext.getCacheService().getDataMap().get("collectionName").getStringData();
		String fileLoc = "releases/" + savedPage;
		collection.reviewFile(colName, savedPage, fileLoc);
	}

    @And("^I edit the pages in progress and save for review$")
    public void iReviewThePagesInProgressAndSaveForReview() throws Throwable {
        String savedPage = TestContext.getCacheService().getDataMap().get("calendarEntry").getStringData();
        String colName = TestContext.getCacheService().getDataMap().get("collectionName").getStringData();
        String fileLoc = "releases/" + savedPage;
        collection.editFile(colName, savedPage, fileLoc);
        contentCreation.saveSubmitForReview();
    }


    @And("^the collection (does|does not) exist$")
    public void checkForCollection(String does) {
        boolean shouldExist = does.length() < 4 ? true : false;
        AnyData collName = TestContext.getCacheService().getDataMap().get("collectionName");
        Assert.assertEquals("Collection exists on the collection table", shouldExist, collection.getCollection(collName.getStringData()));
    }


    @Then("^I review the (.*) files awaiting deletion$")
    public void reviewDeletionFilesInColl(String deletedPage) throws Throwable {
        String colName = TestContext.getCacheService().getDataMap().get("collectionName").getStringData();
        collection.deleteFile(colName, deletedPage);
    }

    @Then("^I review the file awaiting deletion$")
    public void reviewDeletionRandomFilesInColl() throws Throwable {
        String colName = TestContext.getCacheService().getDataMap().get("collectionName").getStringData();
        collection.deleteFile(colName, TestContext.getCacheService().getDataMap().get("pageName").getStringData());
    }

    @And("^I review the (.*) file awaiting review with data url (.*)$")
    public void reviewFile(String fileName, String filePath) throws Throwable {
        String savedPage = TestContext.getCacheService().getDataMap().get(fileName).getStringData();
        String colName = TestContext.getCacheService().getDataMap().get("collectionName").getStringData();
        String fileLoc = filePath + "/" + savedPage;
        collection.reviewFile(colName, savedPage, fileLoc);
    }


    @And("^I change the Scheduled collection to Manual collection$")
    public void iChangeTheScheduledCollectionToManualCollection() throws Throwable {
        collection.changeScheduledToManualCollection();
    }

    @And("^I click on Create/edit button$")
    public void iClickOnCreateEditButton() throws Throwable {
        collection.clickOnCreateEditButton();
    }
}
