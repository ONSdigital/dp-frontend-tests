package stepDefs.florence;

import com.ons.dp.frontend.test.page.ContentCreation;
import cucumber.api.java.en.When;


public class ContentCreationSteps {
ContentCreation contentCreation = new ContentCreation();
    @When("I navigate to (.*)$")
    public void navigateTo(String taxonomy) throws Exception {
        contentCreation.goToGDP();
    }
}
