package com.ons.dp.frontend.test.page.publish;


import com.ons.dp.frontend.test.model.ContentText;
import com.ons.dp.frontend.test.page.BasePage;
import com.ons.dp.frontend.test.util.Helper;
import com.ons.dp.frontend.test.util.RandomStringGen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.ArrayList;


public class ContentCreation extends BasePage {


    //  public By selectedPage = By.cssSelector(".page__buttons.page__buttons--list.selected>span>button.");
    public By activeEditButton = By.cssSelector(".selected>span>button");
	public By activeCreateButton = By.cssSelector(".selected>span>button>button");
	public By submit_button = By.cssSelector("form#UploadForm > div > button[type='submit']");
	public By awaiting_review = By.cssSelector(".page__item.page__item--timeseries_dataset");
	public By version_rows = By.cssSelector("div#version-section>div");
	public String content_css = ".js-browse__item[data-url='text_to_replace']>span>span";
	public String reviewFileButt = ".btn.btn-page-edit[data-path='/text_to_replace']";
	public String directory_css = ".selected > ul > li > span > span.js-browse__item-title.page__item.page__item--directory";
	public String content_headers = "//h1[text()[contains(.,'text_to_replace')]]";
	public By file_label_text = By.id("label");
	public By fileUpload = By.name("files");
	public By selectNewPage = By.id("pagetype");
	public By pageNameField = By.id("pagename");
	public String active_dataset_buttons = ".selected > span > span >button.btn-browse-text_to_replace";

	public By fileUploadResp = By.id("response");
	public int publishedVersions = 0;

	public int getNumberOfPublishedVersions() {
		return publishedVersions;
	}

	public By getActiveDatasetButtons(String buttonText) {
        return By.cssSelector(active_dataset_buttons.replace("text_to_replace", buttonText));
    }

	public ArrayList<WebElement> getVersionRows() {
		return (ArrayList<WebElement>) findElementsBy(version_rows);
	}

	public ArrayList<WebElement> getDirectoryElements(){
       return (ArrayList<WebElement>) findElementsBy(By.cssSelector(directory_css));
    }

    public By getContentId(String cssString, String text) {
        String content = cssString.replace("text_to_replace", text);
        return By.cssSelector(content);
    }
    public WebElement getDirectoryElement(String directoryName){
        WebElement dirnameToReturn =null;
        for(WebElement dir: getDirectoryElements()){
            if(dir.getText().contains(directoryName)){
                dirnameToReturn = dir;
                break;
            }
        }
        return dirnameToReturn;
    }

    public By getContentHeaders(String title){
        return By.xpath(content_headers.replace("text_to_replace",title));
    }

	public void getPublishedVersions() {
		publishedVersions = findElementsBy(version_rows).size();

	}


	public void goToCMSContentLinks(String contentFinder) {
		String[] splitString = contentFinder.split("/");
		StringBuilder sb = new StringBuilder();
		for (String ss : splitString) {
			sb.append("/" + ss);
			try {
				getElement(getContentId(content_css, sb.toString()));
				click(getContentId(content_css, sb.toString()));
			} catch (Exception ee) {
				getDirectoryElement(ss).click();
			}

		}
		click(activeEditButton);
	}


    public void upLoadFile(String fileType) {
        click(getContentHeaders(ContentText.DOWNLOAD_OPTIONS.getContentString()));
		waitUntilTextPresent(getButton(buttonElement, ContentText.UPDATE_ADD_SUPLEMENTARY_FILE.getContentString()), ContentText.UPDATE_ADD_SUPLEMENTARY_FILE.getContentString());
		click(getButton(buttonElement, ContentText.UPDATE_ADD_SUPLEMENTARY_FILE.getContentString()));
		click(getContentHeaders(ContentText.VERSIONS.getContentString()));
		waitUntilTextPresent(getButton(buttonElement, ContentText.ADD_VERSION.getContentString()), ContentText.ADD_VERSION.getContentString());
        getPublishedVersions();
        click(getButton(buttonElement, ContentText.ADD_VERSION.getContentString()));
		sendKeys(file_label_text, RandomStringGen.getRandomString(4));
        String fileLoc = new File(ChooseFile(fileType)).getAbsolutePath();
        sendKeys(fileUpload, fileLoc);
		getWebDriverWait().until(ExpectedConditions.invisibilityOfElementWithText(fileUploadResp, "Uploading . . ."));
		click(submit_button);
		getWebDriverWait().until(ExpectedConditions.invisibilityOfElementWithText(fileUploadResp, "Uploading . . ."));
    }

    public String ChooseFile(String fileType) {
        String fileLocToReturn = "";
        switch (fileType) {
            case "CSDB":
                fileLocToReturn = "src/test/resources/files/cxnv.csdb";
                break;
            case "CSV":
                fileLocToReturn = "src/test/resources/files/cxnv.csx";
                break;
            case "XLS":
                fileLocToReturn = "src/test/resources/files/cxnv.xls";
                break;

        }
        return fileLocToReturn;

    }


    public void save_Collection_for_review() throws Exception {
        Helper.pause(10000);
        waitUntilTextPresent(getButton(buttonElement, ContentText.SAVE_SUBMIT_RETURN_TO_PARENT.getContentString()), ContentText.SAVE_SUBMIT_RETURN_TO_PARENT.getContentString());
	    click(getButton(buttonElement, ContentText.SAVE_SUBMIT_RETURN_TO_PARENT.getContentString()));
	    Helper.pause(10000);
        waitUntilTextPresent(getButton(buttonElement, ContentText.SAVE_SUBMIT_FOR_REVIEW.getContentString()), ContentText.SAVE_SUBMIT_FOR_REVIEW.getContentString());
	    click(getButton(buttonElement, ContentText.SAVE_SUBMIT_FOR_REVIEW.getContentString()));
	    Helper.pause(10000);

	}


	public void reviewFile() {
		click(awaiting_review);
        click(getContentId(reviewFileButt, "economy/grossdomesticproductgdp/datasets/businessinvestment/current"));
    }

	public void approveCollection() {
        Helper.pause(5000);
        waitUntilTextPresent(getButton(buttonElement, ContentText.SAVE_SUBMIT_APPROVAL_RETURN_TO_PARENT.getContentString()), ContentText.SAVE_SUBMIT_APPROVAL_RETURN_TO_PARENT.getContentString());
		click(getButton(buttonElement, ContentText.SAVE_SUBMIT_APPROVAL_RETURN_TO_PARENT.getContentString()));

		waitUntilTextPresent(getButton(buttonElement, ContentText.SAVE_SUBMIT_FOR_APPROVAL.getContentString()), ContentText.SAVE_SUBMIT_FOR_APPROVAL.getContentString());
		click(getButton(buttonElement, ContentText.SAVE_SUBMIT_FOR_APPROVAL.getContentString()));

		waitUntilTextPresent(getButton(buttonElement, ContentText.APPROVE_COLLECTION.getContentString()), ContentText.APPROVE_COLLECTION.getContentString());
		click(getButton(buttonElement, ContentText.APPROVE_COLLECTION.getContentString()));
        Helper.pause(5000);


        }

	public void createPageAndSaveForReview(String pageName) {
		click(getButton(buttonElement, "Create"));
		select(selectNewPage, pageName);
		sendKeys(pageNameField, "Admin Page");
		click(getButton(buttonElement, "Create page"));
		Helper.pause(10000);
		waitUntilTextPresent(getButton(buttonElement, ContentText.SAVE_SUBMIT_FOR_REVIEW.getContentString()), ContentText.SAVE_SUBMIT_FOR_REVIEW.getContentString());
		click(getButton(buttonElement, ContentText.SAVE_SUBMIT_FOR_REVIEW.getContentString()));
	}


}
