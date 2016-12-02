package stepDefs.florence;

import com.ons.dp.frontend.test.page.Collection;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class CollectionSteps {
    Collection collection = new Collection();

    @Given("I create a collection:(.*)$")
    public void createColl(String name) {
        collection.createCollection(name, Collection.CollectionTypes.MANUAL);
    }

    @And("^I delete the collection:(.*)$")
    public void iDeleteTheCollection(String name) throws Throwable {
        collection.deleteCollection(name);
    }

}
