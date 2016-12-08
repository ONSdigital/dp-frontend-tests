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

    @And("^I upload a ([^\"]*) file$")
    public void iUploadAFile(String fileType) throws Throwable {
        contentCreation.upLoadFile(fileType);
        TestContext.getCacheService().setDataMap("versionsPublishedbefore",
                new AnyData(contentCreation.getNumberOfPublishedVersions()));

    }


	@And("^I save and submit the collection for review")
	public void saveAndSubmitColl() {
		contentCreation.saveSubmitForReview();
	}


	@And("^I approve the collection$")
    public void approveTheColl() throws Throwable {
        contentCreation.approveCollection();
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

}
