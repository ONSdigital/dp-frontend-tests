package com.ons.dp.frontend.test.stepdefinitions.florence;

import com.ons.dp.frontend.test.core.TestContext;
import com.ons.dp.frontend.test.page.publish.PublishingQueue;
import com.ons.dp.frontend.test.stepdefinitions.BaseStepDefinition;
import cucumber.api.java.en.When;


public class PublishingQueueSteps {

    PublishingQueue publishingQueue = new PublishingQueue();
    private BaseStepDefinition baseStepDefinition;

    public PublishingQueueSteps() {
        this.baseStepDefinition = new BaseStepDefinition();
    }

    @When("^I click on publishing queue and publish collection$")
    public void publishCollection() throws Throwable {

        publishingQueue.publishQueue();
	    publishingQueue.publishCollection(TestContext.getCacheService().getDataMap().get("collectionName").getStringData());

    }

    @When("^I click on publishing queue and publish scheduled collection$")
    public void publishScheduledCollection() throws Throwable {

        publishingQueue.publishQueue();
        // publishingQueue.waitUntilCollectionIsPublished();
        // Wait till scheduled time then collection automatically publishes
        Thread.sleep(100000);

    }


}
