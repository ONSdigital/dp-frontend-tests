package stepDefs.florence;

import com.ons.dp.frontend.test.page.Collection;
import com.ons.dp.frontend.test.page.ContentCreation;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class CollectionSteps {
    Collection collection = new Collection();
    ContentCreation contentCreation = new ContentCreation();

    @Given("I create a collection:(.*)$")
    public void createColl(String name) {
        collection.createCollection(name, Collection.CollectionTypes.MANUAL);
    }

    @And("^I delete the collection:(.*)$")
    public void iDeleteTheCollection(String name) throws Throwable {
        collection.deleteCollection(name);
    }

    @When("^I select \"([^\"]*)\" collection$")
    public void iSelectCollection(String collectionName) throws Throwable {
        collection.getCollection(collectionName);
    }

    @And("^I review the files awaiting review$")
    public void iReviewTheFilesAwaitingReview() throws Throwable {
        contentCreation.ReviewFile();
    }


    @And("^I Approve the collection$")
    public void iApproveTheCollection() throws Throwable {
        contentCreation.ApproveCollection();
    }


}
