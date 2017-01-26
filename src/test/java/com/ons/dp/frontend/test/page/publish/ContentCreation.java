package com.ons.dp.frontend.test.page.publish;


import com.ons.dp.frontend.test.core.TestContext;
import com.ons.dp.frontend.test.model.CalendarEntry;
import com.ons.dp.frontend.test.model.ContentText;
import com.ons.dp.frontend.test.model.FoiEntry;
import com.ons.dp.frontend.test.page.BasePage;
import com.ons.dp.frontend.test.util.CustomDates;
import com.ons.dp.frontend.test.util.Helper;
import com.ons.dp.frontend.test.util.RandomStringGen;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.ArrayList;

import static com.ons.dp.frontend.test.core.TestContext.configuration;


public class ContentCreation extends BasePage {


	//  public By selectedPage = By.cssSelector(".page__buttons.page__buttons--list.selected>span>button.");
	public By activeEditButton = By.cssSelector(".selected>span>button");
	public By activeCreateButton = By.cssSelector(".selected>span>button.btn-browse-create");
	public By submit_button = By.cssSelector("form#UploadForm > div > button[type='submit']");
	public By version_rows = By.cssSelector("div#version-section>div");
	public String content_css = ".js-browse__item[data-url='text_to_replace']>span>span";
	public String directory_css = ".selected > ul > li > span > span.js-browse__item-title.page__item.page__item--directory";
	public String child_directory_css = ".active > li > span > span.js-browse__item-title.page__item.page__item--directory";
	public String content_headers = "//h1[text()[contains(.,'text_to_replace')]]";
	public By file_label_text = By.id("label");
	public By fileUpload = By.name("files");
	public By selectNewPage = By.id("pagetype");
	public By pageNameField = By.id("pagename");
	public String active_dataset_buttons = ".selected > span > span >button.btn-browse-text_to_replace";
	public By editAccordion = By.cssSelector("div.ui-accordion-content-active > div#sortable-content > div > div > button#content-edit");

	public By fileUploadResp = By.id("response");
	public int publishedVersions = 0;
	public By markdownEditor = By.id("wmd-input");
	public By visualisation_uniqueID = By.id("visualisation-uid");
	public By metadata_keywords = By.xpath(".//*[@id='keywordsTag']/li/input");
	public By metadata = By.xpath("//div[@class='edit-section']/div");
	public By hamburger_icon = By.cssSelector(".page__container.selected>span>span>button.hamburger-icon");
	public By activeDeleteButton = By.cssSelector(".page__container.selected>span>span>span>button.btn-browse-delete");
	public By releaseDate = By.id("releaseDate");
	public By hour = By.id("hour");
	public By min = By.id("min");
	public By summary = By.id("summary");
	public By provisonalDate = By.id("provisionalDate");
	public By finalise = By.name("finalised");
	public By nextRelease = By.id("nextRelease");
	public By contactName = By.id("contactName");
	public By contactEmail = By.id("contactEmail");
	public By telephone = By.id("contactTelephone");
	public By onsCheckBox = By.id("natStat-checkbox");
	public By cancelled = By.name("cancelled");

	public By title = By.id("title");
	public By metaDescription = By.id("metaDescription");
	public By content = By.xpath("//div[@id='content']/div");
	public By contentEdit = By.id("content-edit");

	public By releasesFolder = By.xpath(".//*[@id='browse-tree']/section/nav/ul/li/ul/li[14]/span/span[1]");
	public By create_link = By.linkText("Create");
	public By create_page_btn = By.cssSelector(".btn-page-create");


	public int getNumberOfPublishedVersions() {
		return publishedVersions;
	}

	public By getActiveDatasetButtons(String buttonText) {
		return By.cssSelector(active_dataset_buttons.replace("text_to_replace", buttonText));
	}

	public ArrayList <WebElement> getVersionRows() {
		return (ArrayList <WebElement>) findElementsBy(version_rows);
	}

	public ArrayList <WebElement> getDirectoryElements() {
		return (ArrayList <WebElement>) findElementsBy(By.cssSelector(directory_css));
	}

	public ArrayList<WebElement> getChildDirectoryElements() {
		return (ArrayList<WebElement>) findElementsBy(By.cssSelector(child_directory_css));
	}

	public void enterTextIntoMarkDownEditor(String textToEnter) {
		clear(markdownEditor);
		sendKeys(markdownEditor, textToEnter);
	}

	public WebElement getDirectoryElement(String directoryName) {
		WebElement dirnameToReturn = null;
		//try {
		//WebElement dirnameToReturn = null;
		for (WebElement dir : getDirectoryElements()) {
			if (dir.getText().contains(directoryName)) {
				dirnameToReturn = dir;
				break;
			}
			}
		if (dirnameToReturn == null) {
			for (WebElement dir : getChildDirectoryElements()) {
				if (dir.getText().contains(directoryName)) {
					dirnameToReturn = dir;
					break;
				}
			}

		}
		return dirnameToReturn;
		}


	public By getContentHeaders(String title) {
		return By.xpath(content_headers.replace("text_to_replace", title));
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
		//  click(activeEditButton);
	}

	public void goToReleasesFolder() {

		click(releasesFolder);
		//createCalendarEntry();
		click(create_link);
	}

	public void clickOnActiveEditButton() {
		click(activeEditButton);
	}

	public void clickOnActiveCreateButton() {
		click(activeCreateButton);
	}

	public void clickOnActivatedEdit() {
		click(activeEditButton);
	}

	public void clickEditAccordion() {
		getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(editAccordion));
		click(editAccordion);
	}

	public void editContentHeader(ContentText contentText) {
		click(getContentHeaders(contentText.getContentString()));
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
		if (configuration.getBrowser().toUpperCase().contains("BROWSERSTACK")) {
			sendKeys(fileUpload, "C:\\Users\\hello\\Downloads\\cxnv.csdb");
		} else {
			sendKeys(fileUpload, fileLoc);
		}

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

	public void saveChangesForReview() {
		try {
			getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(getButton(buttonElement, "Save,")));
			click(getButton(buttonElement, "Save,"));
			Helper.pause(1000);
		} catch (Exception ee) {
			getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(getButton(buttonElement, "Save changes and exit")));
			click(getButton(buttonElement, "Save changes and exit"));
		}
		saveSubmitForReview();
	}

	public void saveSubmitForReview() {
		waitUntilTextPresent(getButton(buttonElement, ContentText.SAVE_SUBMIT_FOR_REVIEW.getContentString()), ContentText.SAVE_SUBMIT_FOR_REVIEW.getContentString());
		click(getButton(buttonElement, ContentText.SAVE_SUBMIT_FOR_REVIEW.getContentString()));
		Helper.pause(1000);
	}


	public void approveCollection() {
		try {
			waitUntilTextPresent(getButton(buttonElement, ContentText.SAVE_SUBMIT_APPROVAL_RETURN_TO_PARENT.getContentString()), ContentText.SAVE_SUBMIT_APPROVAL_RETURN_TO_PARENT.getContentString());
			click(getButton(buttonElement, ContentText.SAVE_SUBMIT_APPROVAL_RETURN_TO_PARENT.getContentString()));
		} catch (Exception ee) {
			System.out.println("save and submit for approval And Return to parent does not exist");
		}
		try {
			waitUntilTextPresent(getButton(buttonElement, ContentText.SAVE_SUBMIT_FOR_APPROVAL.getContentString()), ContentText.SAVE_SUBMIT_FOR_APPROVAL.getContentString());
			click(getButton(buttonElement, ContentText.SAVE_SUBMIT_FOR_APPROVAL.getContentString()));
		} catch (Exception ee) {
			System.out.println("submit for approval does not exist");
		}
		try {
			waitUntilTextPresent(getButton(buttonElement, ContentText.APPROVE_COLLECTION.getContentString()), ContentText.APPROVE_COLLECTION.getContentString());
			click(getButton(buttonElement, ContentText.APPROVE_COLLECTION.getContentString()));
		} catch (Exception ee) {
			System.out.println("Approve Collection does not exist");
		}

		Helper.pause(1000);
	}

	public void createPageAndSaveForReview(String pageType) {
		click(getButton(buttonElement, "Create"));
		select(selectNewPage, pageType);
		sendKeys(pageNameField, "bDsx5G8");
		click(getButton(buttonElement, "Create page"));
		saveSubmitForReview();
	}

	public void createPageAndSave(String pageType, String pageName) {
		click(getButton(buttonElement, "Create"));
		select(selectNewPage, pageType);
		sendKeys(pageNameField, pageName);
		click(getButton(buttonElement, "Create page"));
		saveSubmitForReview();
	}

	public void createCalendarEntry(String releaseDateText, String releaseTime, String randomPageName) {
		click(getButton(buttonElement, "Create"));
		select(selectNewPage, "Calendar entry");
		sendKeys(releaseDate, releaseDateText);
		getElement(releaseDate).sendKeys(Keys.ESCAPE);
		String times[] = releaseTime.split(":");
		select(hour, times[0]);
		select(min, times[1]);
		sendKeys(pageNameField, randomPageName);
		click(getButton(buttonElement, "Create page"));
	}

	public void createReleaseCalendarEntry(String releaseDateText, String releaseTime, String randomPageName) {

		select(selectNewPage, "Calendar entry");
		sendKeys(releaseDate, releaseDateText);
		getElement(releaseDate).sendKeys(Keys.ESCAPE);
		String times[] = releaseTime.split(":");
		select(hour, times[0]);
		select(min, times[1]);
		sendKeys(pageNameField, randomPageName);
		click(getButton(buttonElement, "Create page"));
		saveSubmitForReview();
	}

	public void createVisualisationPageAndSaveForReview() {
		click(getButton(buttonElement, "Upload visualisation"));
		select(selectNewPage, "Visualisation");

		//sendKeys(visualisation_uniqueID, "DVC126");
		sendKeys(visualisation_uniqueID, RandomStringGen.getRandomString(5));
		sendKeys(pageNameField, "Visualisation Page");
		click(getButton(buttonElement, "Create page"));
		saveSubmitForReview();

	}


	public void metaDataKeywords() {
		Helper.pause(1000);
		click(metadata);
		Helper.pause(1000);
		sendKeys(metadata_keywords, "bit");

	}

	public void deleteContent() {
		Helper.pause(1000);
		click(hamburger_icon);
		Helper.pause(4000);
		getWebDriverWait().until(ExpectedConditions.visibilityOf(getElement(activeDeleteButton)));
		click(activeDeleteButton);

	}

	public void addCalendarMetaData(CalendarEntry calendarEntry) {
		click(metadata);
		sendKeys(summary, calendarEntry.getSummary());
		sendKeys(provisonalDate, CustomDates.getDate(2));
		calendarEntry.setProvisionalDateRange(getElementText(provisonalDate));
		calendarEntry.setReleaseDate(getElementText(releaseDate));
		boolean finalChkBox = String.valueOf(calendarEntry.getFinalise()).equals("true");
		boolean onsImgChkBox = String.valueOf(calendarEntry.getOnsimage()).equals("true");
		boolean cancelChkBox = String.valueOf(calendarEntry.getCancelled()).equals("true");
		if (finalChkBox) {
			click(finalise);
		}
		sendKeys(nextRelease, CustomDates.getDate(30));
		sendKeys(contactName, String.valueOf(calendarEntry.getContactName()));
		if (calendarEntry.getContactEmail() != null) {
			sendKeys(contactEmail, String.valueOf(calendarEntry.getContactEmail()));
		}
		calendarEntry.setNextRelease(getElementText(nextRelease));
		if (calendarEntry.getTelephone() != null) {
			sendKeys(telephone, String.valueOf(calendarEntry.getTelephone()));
		}
		if (onsImgChkBox) {
			click(onsCheckBox);
		}
		if (cancelChkBox) {
			click(cancelled);
		}
		saveSubmitForReview();
	}

	public void createFOIEntry(String releaseDateText, String randomPageName) {
		click(activeCreateButton);
		select(selectNewPage, "FOI");
		sendKeys(releaseDate, releaseDateText);
		getElement(releaseDate).sendKeys(Keys.ESCAPE);
		sendKeys(pageNameField, randomPageName);
		//click(getButton(buttonElement, "Create page"));
		click(create_page_btn);
	}

	public void addFOIEntryMetadata(FoiEntry foiEntry) {

		click(metadata);
		//sendKeys(title, foiEntry.getTitle());
		getElementText(title).equals(TestContext.getCacheService().getDataMap().get("foiEntry").getStringData());
		sendKeys(metadata_keywords, foiEntry.getKeywords());
		sendKeys(metaDescription, foiEntry.getMetaDescription());

		click(content);
		click(contentEdit);
		sendKeys(markdownEditor, foiEntry.getMarkdownText());
		click(getButton(buttonElement, "Save changes and exit"));

		saveSubmitForReview();


	}


}
