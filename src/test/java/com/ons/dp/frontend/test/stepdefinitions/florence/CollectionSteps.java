package com.ons.dp.frontend.test.stepdefinitions.florence;

import com.ons.dp.frontend.test.core.TestContext;
import com.ons.dp.frontend.test.page.publish.Collection;
import com.ons.dp.frontend.test.util.AnyData;
import com.ons.dp.frontend.test.util.RandomStringGen;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class CollectionSteps {
    Collection collection = new Collection();

    @Given("I create a (MANUAL|SCHEDULED_CUSTOM) collection type$")
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
//            default:
//                collection.createCollection(collectionName, Collection.CollectionTypes.MANUAL,teamName);
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
}
