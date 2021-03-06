package com.ons.dp.frontend.test.page.publish;

import Util.Log;
import Util.ScheduledTime;
import com.ons.dp.frontend.test.core.TestContext;
import com.ons.dp.frontend.test.model.DataTable;
import com.ons.dp.frontend.test.page.BasePage;
import com.ons.dp.frontend.test.util.CustomDates;
import com.ons.dp.frontend.test.util.Do;
import com.ons.dp.frontend.test.util.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class Collection extends BasePage {

    public By header = By.className("text-align-center");
    public By collection_name = By.id("collectionname");
    public By collection_table_id = By.id("collection-name");
    public By manual_publish = By.id("manualpublish");
    public By edit_collection_manual_publish = By.id("collection-editor-manual");
    public By sch_publish = By.id("scheduledpublish");
    public By team_name_id = By.id("team");
    public By custom_schedule = By.id("customschedule");
    public By calendar_entry_schedule = By.id("releaseschedule");
    public By select_a_calendar_entry = By.cssSelector(".btn.btn--primary.btn--inline-block.btn-select-release");
    public By search_for_a_release = By.id("js-modal-select__search");
    public By calendar_entry_list = By.id("js-modal-select__body");
    public By custom_date = By.id("date");
    public By custom_hour = By.id("hour");
    public By custom_min = By.id("min");
    public By create_collection = By.xpath("//button[text()[contains(.,'Create collection')]]");
    public By delete_collection = By.id("collection-delete");
    public By confirm_deletion = By.cssSelector("div.sa-confirm-button-container>button.confirm");
    public By pages_edited_approval = By.cssSelector("li.page-list__item");
    public By bulletin_pages_edited_approval = By.cssSelector(".page__item.page__item--bulletin");
    public By page_element = By.cssSelector("li.page-list__item>span");
    public By sweet_alert = By.cssSelector("div.sweet-alert.showSweetAlert.visible");
    public By progress_pages = By.id("in-progress-uris");
    public By completed_pages = By.id("complete-uris");
    public By reviewed_pages = By.id("reviewed-uris");
    public By page_delete = By.cssSelector("li.selected>div.page__buttons--list>button.page-delete");
    public By staticPage = By.cssSelector(".page__item.page__item--static_landing_page");
    public By confirm_delete = By.cssSelector(".confirm");
    public By work_on_collection = getButton(buttonElement, "Work on collection");
    public By edit_collection_details = By.cssSelector(".edit.btn-collection-edit.js-edit-collection");
    public By save_changes_button = getButton(buttonElement, "Save changes");
    public By create_edit_button = getButton(buttonElement, "Create/edit");
    public String reviewFileButt = ".btn.btn-page-edit[data-path='/text_to_replace']";


    DataTable dataTable;

    public boolean getCollection(String collectionName) {
        Helper.pause(1000);
        boolean elementPresent = false;
        Do.until(getDriver(), ExpectedConditions.presenceOfElementLocated(collection_table_id));
        dataTable = new DataTable(false);
        WebElement webElement = dataTable.getLeftData().get(collectionName);
        if (webElement != null) {
            elementPresent = true;
            webElement.click();
        }
        return elementPresent;

    }


    public void createCollection(String name, CollectionTypes collectionTypes, String teamname) {
        clickOnCollectionsLink();
        sendKeys(collection_name, name);
        selectTeam(teamname);
        switch (collectionTypes) {
            case MANUAL:
                click(manual_publish);
                break;
            case SCHEDULE_CUSTOM:
                click(sch_publish);
                click(custom_schedule);
                //getDriver().findElement(By.id("date")).sendKeys(CustomDates.getDate(1));
                getDriver().findElement(By.id("date")).sendKeys(CustomDates.getDate(0));
                getDriver().findElement(By.id("date")).sendKeys(Keys.ESCAPE);

                // Select Current Hour from the Hour dropdown
                select(custom_hour, ScheduledTime.currentHour());

                // HACK - Using JS modifing the min to enter in dropdown and pass a minute value in below method
                JavascriptExecutor js = (JavascriptExecutor) getDriver();
                String scheduledTime = ScheduledTime.differentTime(3);
                js.executeScript("document.getElementById(\"min\").childNodes[3].value =" + scheduledTime + "");
                break;

            case SCHEDULE_CALENDAR_ENTRY:
                click(sch_publish);
                click(calendar_entry_schedule);
                click(select_a_calendar_entry);
                Helper.pause(1000);
                String releaseName = TestContext.getCacheService().getDataMap().get("calendarEntry").getStringData();
                sendKeys(search_for_a_release, releaseName);
                Helper.pause(2000);
                selectACalendarEntry(releaseName);
                break;
        }
        click(create_collection);

    }

    public List<WebElement> getAllCalendarEntryReleases() {
        return (List<WebElement>) findElementsBy(calendar_entry_list);
    }

    public void selectACalendarEntry(String entryName) {
        for (WebElement entry : getAllCalendarEntryReleases()) {
            if (entry.getText().contains(entryName)) {
                entry.click();
                break;
            }
        }
    }

    public void selectTeam(String teamname) {
        if (teamname != null) {
            select(team_name_id, teamname);
        }
    }

    public void deleteCollection(String name) {
        refresh();
        if (getCollection(name)) {
            getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(delete_collection));
            click(delete_collection);
            getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(sweet_alert));
            click(confirm_deletion);
            Do.until(getDriver(), ExpectedConditions.invisibilityOfElementLocated(confirm_deletion));
            getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(sweet_alert));
        }
    }


    public void openSavedPage(String savedPage) {
        waitAfterCollSelection();
        ArrayList<WebElement> coll_edited_pages = (ArrayList<WebElement>) findElementsBy(pages_edited_approval);
        try {
            for (WebElement page : coll_edited_pages) {
                if (page.getText().contains(savedPage)) {
                    page.click();
                    break;
                }
            }
        } catch (NullPointerException ee) {
            Log.info("Couldn't find the reviewed page");
        }


    }

    public void openBulletinSavedPage(String savedPage) {
        waitAfterCollSelection();
        ArrayList<WebElement> coll_edited_pages = (ArrayList<WebElement>) findElementsBy(bulletin_pages_edited_approval);
        try {
            for (WebElement page : coll_edited_pages) {
                if (page.getText().contains(savedPage)) {
                    page.click();
                    break;
                }
            }
        } catch (NullPointerException ee) {
            Log.info("Couldn't find the bulletin reviewed page");
        }


    }


    public void checkDeletedPages(String deletedPage) {
        waitAfterCollSelection();
        ArrayList<WebElement> coll_deleted_pages = (ArrayList<WebElement>) findElementsBy(pages_edited_approval);
        try {
            for (WebElement page : coll_deleted_pages) {
                if (page.getText().contains(deletedPage)) {
                    break;
                }
            }
        } catch (NullPointerException ee) {
            Log.info("Couldn't find the deleted page");
        }
    }

    public void reviewFile(String collectionName, String savedPage, String reviewLoc) {
        openSavedPage(savedPage);
	    click(getContentId(reviewFileButt, reviewLoc.toLowerCase()));
    }

    public void reviewBulletionFile(String collectionName, String savedPage, String reviewLoc) {
        openBulletinSavedPage(savedPage);
        click(getContentId(reviewFileButt, reviewLoc.toLowerCase()));
    }


    public void editFile(String collectionName, String savedPage, String editLoc) {
        openSavedPage(savedPage);
        click(getContentId(reviewFileButt, editLoc.toLowerCase()));
    }

    public void deleteFile(String collectionName, String deletedPage) {
        checkDeletedPages(deletedPage);
    }

    public void waitAfterCollSelection() {
        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(progress_pages));
        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(reviewed_pages));
        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(completed_pages));
        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(getButton(buttonElement,
                "Import timeseries")));
        Helper.pause(1000);
        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(getButton(buttonElement, "Restore content")));
    }

    // returns true when all the pages are deleted
    public boolean deleteAllWorkedPages(String collectionName) {
        waitAfterCollSelection();
        ArrayList<WebElement> coll_edited_pages = (ArrayList<WebElement>) findElementsBy(pages_edited_approval);
        while (coll_edited_pages.size() > 0) {
            getWebDriverWait().until(ExpectedConditions.elementToBeClickable(coll_edited_pages.get(0)));
            getWebDriverWait().until(ExpectedConditions.visibilityOf(coll_edited_pages.get(0)));
            ;
            if (coll_edited_pages.get(0).isEnabled() && coll_edited_pages.get(0).isDisplayed()) {
                click(page_element);
            }
            getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(page_delete));
            verifyElementsPresent(page_delete);
            click(page_delete);
            verifyElementsPresent();
            click(confirm_deletion);
            getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(sweet_alert));
            verifyElementsNotPresent(sweet_alert);
            coll_edited_pages = (ArrayList<WebElement>) findElementsBy(pages_edited_approval);
        }
        return findElementsBy(pages_edited_approval).size() == 0 ? true : false;
    }

    public void clickOnCollectionsLink() {
        click(By.linkText("Collections"));
    }

    public void changeScheduledToManualCollection() {
        Helper.pause(500);
        click(edit_collection_details);
        Helper.pause(2000);
        click(edit_collection_manual_publish);
        Helper.pause(2000);
        click(save_changes_button);
        Helper.pause(500);
        refresh();
    }

    public void clickOnCreateEditButton() {
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(create_edit_button));
        click(create_edit_button);
    }

    public enum CollectionTypes {
        MANUAL, SCHEDULE_CUSTOM, SCHEDULE_CALENDAR_ENTRY;
    }


}
