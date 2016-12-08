package com.ons.dp.frontend.test.stepdefinitions.florence;

import com.ons.dp.frontend.test.core.TestContext;
import com.ons.dp.frontend.test.page.publish.Collection;
import com.ons.dp.frontend.test.util.AnyData;
import com.ons.dp.frontend.test.util.RandomStringGen;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class CollectionSteps {
    Collection collection = new Collection();
	String collectionName = "";

    @Given("I create a (MANUAL|SCHEDULED) collection type$")
    public void createColl(String collType) {
	    collectionName = "AutoTest_" + RandomStringGen.getRandomString(5);
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
	    collection.deleteCollection(collectionName);

    }
    @And("^I delete all the worked on pages in the collection")
    public void deleteAllTheWorkedOnpages(){
	    collection.deleteAllWorkedPages(collectionName);
    }
    @And("^I select the collection$")
    public void selectTheCollection(){
	    collection.getCollection(collectionName);

    }

	@And("^I review the (.*) files awaiting review with data-url:(.*)$")
	public void reviewFilesInColl(String savedPage, String fileloc) throws Throwable {
		collection.reviewFile(collectionName, savedPage, fileloc);
	}

}
