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
        AnyData collName = TestContext.getCacheService().getDataMap().get("collectionName");
        collection.getCollection(collName.getStringData());
    }

}
