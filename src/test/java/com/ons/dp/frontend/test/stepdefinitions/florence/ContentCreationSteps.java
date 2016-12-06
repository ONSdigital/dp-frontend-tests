package com.ons.dp.frontend.test.stepdefinitions.florence;

import com.ons.dp.frontend.test.core.TestContext;
import com.ons.dp.frontend.test.page.publish.ContentCreation;
import com.ons.dp.frontend.test.util.AnyData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;


public class ContentCreationSteps {
ContentCreation contentCreation = new ContentCreation();

    @When("I navigate to Economy$")
    public void navigateTo() throws Exception {
        contentCreation.goToTimeSeries();
        contentCreation.upLoadFile();
        TestContext.getCacheService().setDataMap("versionsPublishedbefore",
                new AnyData(contentCreation.getNumberOfPublishedVersions()));
        contentCreation.save_Collection_for_review();
    }
    @And("^I review the files awaiting review$")
    public void reviewFilesInColl() throws Throwable {
        contentCreation.reviewFile();
    }


    @And("^I approve the collection$")
    public void approveTheColl() throws Throwable {
        contentCreation.approveCollection();
    }
}
