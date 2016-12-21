package com.ons.dp.frontend.test.stepdefinitions.florence;

import com.ons.dp.frontend.test.core.TestContext;
import com.ons.dp.frontend.test.model.ContentText;
import com.ons.dp.frontend.test.page.publish.ContentCreation;
import com.ons.dp.frontend.test.util.AnyData;
import com.ons.dp.frontend.test.util.RandomStringGen;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;


public class ContentCreationSteps {
    ContentCreation contentCreation = new ContentCreation();

    @When("^I browse to the content (.*) under collections$")
    public void browseToTheContent(String contentToBrowse) throws Exception {
        contentCreation.goToCMSContentLinks(contentToBrowse);

    }

    @And("^I click on Edit button$")
    public void clickOnActiveEditButton() {
        contentCreation.clickOnActiveEditButton();
    }

    @And("^I click on Create button$")
    public void clickOnActiveCreateButton() {
        contentCreation.clickOnActiveCreateButton();
    }

    @And("^I upload a ([^\"]*) file$")
    public void iUploadAFile(String fileType) throws Throwable {
        contentCreation.upLoadFile(fileType);
        TestContext.getCacheService().setDataMap("versionsPublishedbefore",
                new AnyData(contentCreation.getNumberOfPublishedVersions()));

    }


    @And("^I save and submit the collection for review")
    public void saveAndSubmitColl() {
        contentCreation.saveChangesForReview();
    }


    @And("^I approve the collection$")
    public void approveTheColl() throws Throwable {
        contentCreation.approveCollection();
    }


    @And("^I create a new \"([^\"]*)\" and submit for review$")
    public void iCreateANew(String pageType) throws Throwable {
        //String pageName = "AutoPage_" + RandomStringGen.getRandomString(5);
        // TestContext.getCacheService().setDataMap("pageName", new AnyData(pageName));
        contentCreation.createPageAndSaveForReview(pageType);

    }

    @And("^I click on the content header (.*)$")
    public void editContentHeader(String contentHeader) {
        contentCreation.editContentHeader(ContentText.valueOf(contentHeader));
    }

    @And("^I edit the content on the collection$")
    public void clickOnEdit() {
        contentCreation.clickOnActivatedEdit();
    }

    @And("^I edit the content within the active accordion")
    public void clickEditWithinAccordion() {
        contentCreation.clickEditAccordion();
    }

    @And("^I enter text into the markdown editor$")
    public void enterTextIntoEditor() {
        String textToEnter = RandomStringGen.getRandomString(200);
        TestContext.getCacheService().setDataMap("markdownText", new AnyData(textToEnter));
        contentCreation.enterTextIntoMarkDownEditor(textToEnter);
    }


    @And("^upload visulisation and submit for review$")
    public void uploadVisulisationAndSubmitForReview() throws Throwable {
        contentCreation.createVisualisationPageAndSaveForReview();
    }

    @And("^I enter keywords metadata and save for review$")
    public void iEnterKeywordsMetadata() throws Throwable {
        contentCreation.metaDataKeywords();
        contentCreation.saveSubmitForReview();
    }

    @And("^I delete the content$")
    public void iDeleteTheContent() throws Throwable {
        contentCreation.deleteContent();
    }
}
