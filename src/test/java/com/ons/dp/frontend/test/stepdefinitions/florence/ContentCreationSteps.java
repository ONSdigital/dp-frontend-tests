package com.ons.dp.frontend.test.stepdefinitions.florence;

import com.ons.dp.frontend.test.page.ContentCreation;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;


public class ContentCreationSteps {
ContentCreation contentCreation = new ContentCreation();
    @When("I navigate to (.*)$")
    public void navigateTo(String taxonomy) throws Exception {
        contentCreation.goToGDP();
    }
    @And("^I review the files awaiting review$")
    public void reviewFilesInColl() throws Throwable {
        contentCreation.ReviewFile();
    }


    @And("^I approve the collection$")
    public void approveTheColl() throws Throwable {
        contentCreation.ApproveCollection();
    }
}
