package com.ons.dp.frontend.test.stepdefinitions.florence;

import com.ons.dp.frontend.test.core.TestContext;
import com.ons.dp.frontend.test.page.publish.ContentCreation;
import com.ons.dp.frontend.test.util.AnyData;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;


public class ContentCreationSteps {
ContentCreation contentCreation = new ContentCreation();

    @When("^I browse to the content (.*) under collections$")
    public void browseToTheContent(String contentToBrowse) throws Exception {
        contentCreation.goToCMSContentLinks(contentToBrowse);
    }

    @And("^I upload a ([^\"]*) file$")
    public void iUploadAFile(String fileType) throws Throwable {
        contentCreation.upLoadFile(fileType);
        TestContext.getCacheService().setDataMap("versionsPublishedbefore",
                new AnyData(contentCreation.getNumberOfPublishedVersions()));

    }

    @And("^I submit the collection for review$")
    public void iSubmitTheCollectionForReview() throws Throwable {
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


    @And("^I create a new \"([^\"]*)\" and submit for review$")
    public void iCreateANew(String pageName) throws Throwable {
        contentCreation.createPageAndSaveForReview(pageName);

    }
}
