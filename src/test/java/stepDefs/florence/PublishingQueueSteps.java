package stepDefs.florence;

import com.ons.dp.frontend.test.page.PublishingQueue;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;

/**
 * Created by admin on 05/12/2016.
 */
public class PublishingQueueSteps {

    PublishingQueue publishingQueue = new PublishingQueue();

    @When("^I click on Publishing queue and publish collection$")
    public void iClickOnPublishingQueueAndPublishCollection() throws Throwable {

        publishingQueue.ClickOnPublishingQueue();
        publishingQueue.PublishCollection();

    }


}
