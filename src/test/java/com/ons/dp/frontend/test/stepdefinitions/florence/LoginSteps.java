package com.ons.dp.frontend.test.stepdefinitions.florence;

import com.ons.dp.frontend.test.page.publish.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginSteps {
    public By page_title = By.cssSelector(".page-intro__title");
    public By page_header_title = By.cssSelector(".page-header__title");
    LoginPage loginPage = new LoginPage();

    @Given("I login as user: (.*) and password (.*)$")
    public void loginUser(String username, String pwd) {
        loginPage.openAndLogin(username, pwd);
    }

    @Given("I am logged in as an admin$")
    public void adminLogin() {
        loginPage.openAndLogin("admin@test.com", "one two three four");
        //      loginPage.openAndLogin("florence@magicroundabout.ons.gov.uk", "one two three four");
    }

    @Given("I am logged in as a publisher$")
    public void publisherLogin() {
        loginPage.openAndLogin("publisher@test.com", "one two three four");
    }

    @Given("I am logged in as a visualisation publisher$")
    public void visualisationPublisherLogin() {
        loginPage.openAndLogin("visualisationpublisher@test.com", "one two three four");
    }

    @Given("I am logged in as a lead publisher$")
    public void leadPublisherLogin() {
        loginPage.openAndLogin("publisher2@test.com", "one two three four");
    }

    @Given("I am logged in as a viewer$")
    public void viewerLogin() {
        loginPage.openAndLogin("viewer@test.com", "one two three four");
    }

    @Given("I am logged into Ermintrude website as a viewer$")
    public void viewerErmintudeLogin() {
        loginPage.openAndLoginToErmintrude("viewer@test.com", "one two three four");
    }


    @Given("^I am logged in as an another visualisation publisher$")
    public void iAmLoggedInAsAnAnotherVisualisationPublisher() throws Throwable {
        loginPage.openAndLogin("visualisationpublisher2@test.com", "one two three four");
    }


    @When("^I browse to \"([^\"]*)\" in a new tab on florence$")
    public void iBrowseToInANewTabOnFlorence(String url) throws Throwable {

        // loginPage.openANewTab();
        // loginPage.switchToNewTab();
        loginPage.goToPage(url);
    }

    @And("^the Florence website (does|does not) contain the classifications changes$")
    public void getFlorenceClassificationChanges(String exist) {
        boolean exists = exist.length() <= 4;

        if (exists) {
            loginPage.refresh();
            Assert.assertTrue("The changes are not on the ONS website", loginPage.getElementText(page_title).contentEquals("Admin Page"));
        } else {
            loginPage.refresh();
            Assert.assertTrue("The changes are not on the ONS website", loginPage.getElementText(page_header_title).contentEquals(
                    "404 - The webpage you are requesting does not exist on the site"));
        }

    }

    @And("^I switch back to florence$")
    public void iSwitchBackToFlorence() throws Throwable {
        loginPage.switchBackToMainTab();
    }

    @And("^I browse to florence$")
    public void iBrowseToFlorence() throws Throwable {
        loginPage.openLoginPage();
    }
}
