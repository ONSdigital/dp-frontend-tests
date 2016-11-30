package stepDefs.florence;

import com.ons.dp.frontend.test.page.Collection;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

/**
 * Created by admin on 30/11/2016.
 */
public class CollectionSteps {
    Collection collection = new Collection();

    @Given("I create a collection")
    public void createColl(){
        collection.createCollection("TimeSeriesAuto", Collection.CollectionTypes.MANUAL);
    }

    @And("^I delete the collection$")
    public void iDeleteTheCollection() throws Throwable {
        collection.deleteCollection();
    }
}
