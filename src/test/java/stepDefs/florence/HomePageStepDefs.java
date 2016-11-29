//package stepDefs.florence;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import florence_pages.CollectionsPage;
//import florence_pages.HomePage;
//import org.junit.Assert;
//import org.openqa.selenium.WebDriver;
//import webDriver.Hooks;
//
////import org.testng.Assert;
//
///**
// * Created by admin on 21/10/2016.
// */
//public class HomePageStepDefs {
//
//    public WebDriver driver;
//    private HomePage homePage= new HomePage();
//    private CollectionsPage collectionsPage = new CollectionsPage();
//
//
//    @Given("^I am on the Florence HomePage$")
//    public void iAmOnTheFlorenceHomePage() throws Throwable {
//        homePage.NavigateToFlorenceUrl();
//    }
//
//  /*  @When("^I enter \"([^\"]*)\" in the (.*) field$")
//    public void iEnterInTheEmailField(String email, String element) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @And("^I enter \"([^\"]*)\" in the password field$")
//    public void iEnterInThePasswordField(String arg0) throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }*/
//
//    /*@And("^I click Login$")
//    public void iClickLogin() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }*/
//
//    @Then("^I should be on the collections section$")
//    public void iShouldBeOnTheCollectionsSection() throws Throwable {
//
//        Assert.assertEquals(collectionsPage.AmIOnCollectionsSection(), "Create a collection");
//
//    }
//
//
//}
