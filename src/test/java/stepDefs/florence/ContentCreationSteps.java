package stepDefs.florence;

import com.ons.dp.frontend.test.page.ContentCreation;
import cucumber.api.java.en.When;

/**
 * Created by admin on 30/11/2016.
 */
public class ContentCreationSteps {
ContentCreation contentCreation = new ContentCreation();
    @When("I navigate to (.*)$")
    public void navigateTo(String taxonomy){
        contentCreation.goToGDP();
    }
}
