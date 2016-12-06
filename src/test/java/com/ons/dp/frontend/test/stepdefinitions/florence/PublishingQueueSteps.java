package com.ons.dp.frontend.test.stepdefinitions.florence;

import com.ons.dp.frontend.test.page.publish.PublishingQueue;
import cucumber.api.java.en.When;


public class PublishingQueueSteps {

    PublishingQueue publishingQueue = new PublishingQueue();

    @When("^I click on publishing queue and publish collection$")
    public void publishCollection() throws Throwable {

        publishingQueue.publishQueue();
        publishingQueue.publishCollection();

    }


}
