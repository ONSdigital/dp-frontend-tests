package com.ons.dp.frontend.test.stepdefinitions.florence;

import com.ons.dp.frontend.test.core.TestContext;
import com.ons.dp.frontend.test.page.publish.PublishingQueue;
import cucumber.api.java.en.When;


public class PublishingQueueSteps {

    PublishingQueue publishingQueue = new PublishingQueue();

    @When("^I click on publishing queue and publish collection$")
    public void publishCollection() throws Throwable {

        publishingQueue.publishQueue();
	    publishingQueue.publishCollection(TestContext.getCacheService().getDataMap().get("collectionName").getStringData());

    }

    @When("^I click on publishing queue and publish scheduled collection$")
    public void publishScheduledCollection() throws Throwable {

        publishingQueue.publishQueue();
        // Wait till scheduled time then collection automatically publishes
        Thread.sleep(100000);

    }


}
