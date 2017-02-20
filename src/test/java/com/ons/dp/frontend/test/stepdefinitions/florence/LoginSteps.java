package com.ons.dp.frontend.test.stepdefinitions.florence;

import com.ons.dp.frontend.test.core.TestContext;
import com.ons.dp.frontend.test.page.publish.LoginPage;
import com.ons.dp.frontend.test.stepdefinitions.BaseStepDefinition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginSteps {

    public By page_title = By.cssSelector(".page-intro__title");
    public By page_header_title = By.cssSelector(".page-header__title");
    LoginPage loginPage = new LoginPage();
    private BaseStepDefinition baseStepDefinition;

    public LoginSteps() {
        this.baseStepDefinition = new BaseStepDefinition();
    }

    @Given("I login as user: (.*) and password (.*)$")
    public void loginUser(String username, String pwd) {
        loginPage.openAndLogin(username, pwd);
    }

    @Given("I am logged in as an admin$")
    public void adminLogin() {
        loginPage.openAndLogin("admin@test.com", "one two three four");
    }

    @Given("I am logged in as a publisher in sandpit env$")
    public void publisherLoginInSandpitEnv() {
        loginPage.openAndLoginToSandpit("publisher@test.com", "one two three four");
    }

    @Given("I am logged in as a lead publisher in sandpit env$")
    public void leadPublisherLoginInSandpitEnv() {
        loginPage.openAndLoginToSandpit("publisher2@test.com", "one two three four");
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

    @Given("I am logged in as a viewer into florence website$")
    public void viewerLogin() {
        loginPage.openAndLoginIntoFlorence("viewer@test.com", "one two three four");
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
        loginPage.refresh();
        //   loginPage.openANewTab();
        //   loginPage.switchToNewTab();
        String randomPageName = TestContext.getCacheService().getDataMap().get("pageName").getStringData();

        loginPage.goToFlorencePreviewPage((url.replace("random page", randomPageName)));
        if (loginPage.getDriver().getPageSource().contains("Restricted")) {
            loginPage.getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.linkText("log in")));
            loginPage.click(By.linkText("log in"));
            loginPage.openAndLogin("publisher@test.com", "one two three four");
            loginPage.goToFlorencePreviewPage((url.replace("random page", randomPageName)));
        }
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
        loginPage.goToFlorence();
    }
}
