package com.ons.dp.frontend.test.stepdefinitions.florence;

import com.ons.dp.frontend.test.core.TestContext;
import com.ons.dp.frontend.test.page.publish.Collection;
import com.ons.dp.frontend.test.util.AnyData;
import com.ons.dp.frontend.test.util.RandomStringGen;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class CollectionSteps {
    Collection collection = new Collection();

    @Given("I create a (MANUAL|SCHEDULED) collection type$")
    public void createColl(String collType) {
        String collectionName = "AutoTest_" + RandomStringGen.getRandomString(5);
        TestContext.getCacheService().setDataMap("collectionName", new AnyData(collectionName));
            switch (collType){
            case "MANUAL":
                    collection.createCollection(collectionName,Collection.CollectionTypes.MANUAL);
                    break;
                default:
                    collection.createCollection(collectionName,Collection.CollectionTypes.MANUAL);
        }
     }

    @And("^I delete the collection$")
    public void deleteCollection() throws Throwable {
        String colName = TestContext.getCacheService().getDataMap().get("collectionName").getStringData();
        collection.deleteCollection(colName);

    }
    @And("^I delete all the worked on pages in the collection")
    public void deleteAllTheWorkedOnpages(){
        String colName = TestContext.getCacheService().getDataMap().get("collectionName").getStringData();
        collection.deleteAllWorkedPages(colName);
    }
    @And("^I select the collection$")
    public void selectTheCollection(){
	    collection.getCollection(collectionName);

    }

	@And("^I review the (.*) files awaiting review with data-url:(.*)$")
	public void reviewFilesInColl(String savedPage, String fileloc) throws Throwable {
		collection.reviewFile(collectionName, savedPage, fileloc);
	}


    @And("^the collection (does|does not) exist$")
    public void checkForCollection(String does) {
        boolean shouldExist = does.length() < 4 ? true : false;
        AnyData collName = TestContext.getCacheService().getDataMap().get("collectionName");
        Assert.assertEquals("Collection exists on the collection table", shouldExist, collection.getCollection(collName.getStringData()));
    }


}
