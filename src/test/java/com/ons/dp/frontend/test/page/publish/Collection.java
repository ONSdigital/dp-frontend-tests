package com.ons.dp.frontend.test.page.publish;

import Util.Log;
import com.ons.dp.frontend.test.model.DataTable;
import com.ons.dp.frontend.test.page.BasePage;
import com.ons.dp.frontend.test.util.CustomDates;
import com.ons.dp.frontend.test.util.Do;
import com.ons.dp.frontend.test.util.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class Collection extends BasePage {

    public By header = By.className("text-align-center");
    public By collection_name = By.id("collectionname");
    public By collection_table_id = By.id("collection-name");
    public By manual_publish = By.id("manualpublish");
    public By sch_publish = By.id("scheduledpublish");
    public By team_name_id = By.id("team");
    public By custom_schedule = By.id("customschedule");

    public By custom_date = By.id("date");
    public By custom_hour = By.id("hour");
    public By custom_min = By.id("min");



    public By create_collection = By.xpath("//button[text()[contains(.,'Create collection')]]");
    public By delete_collection = By.id("collection-delete");
    public By confirm_deletion = By.cssSelector("div.sa-confirm-button-container>button.confirm");
    public By pages_edited_approval = By.cssSelector("li.page-list__item");
    public By page_element = By.cssSelector("li.page-list__item>span");
    public By sweet_alert = By.cssSelector("div.sweet-alert.showSweetAlert.visible");
    public By progress_pages = By.id("in-progress-uris");
    public By completed_pages = By.id("complete-uris");
    public By reviewed_pages = By.id("reviewed-uris");
    public By page_delete = By.cssSelector("li.selected>div.page__buttons--list>button.page-delete");
    public By staticPage = By.cssSelector(".page__item.page__item--static_landing_page");
    public By confirm_delete = By.cssSelector(".confirm");
    public By work_on_collection = getButton(buttonElement, "Work on collection");
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
        sendKeys(collection_name, name);
        selectTeam(teamname);
        switch (collectionTypes) {
            case MANUAL:
                click(manual_publish);
                break;
            case SCHEDULE_CUSTOM:
                click(sch_publish);
                click(custom_schedule);
                // sendKeys(custom_date, CustomDates.getTomorrowsDate());
                getDriver().findElement(By.id("date")).sendKeys(CustomDates.getTomorrowsDate());
                getDriver().findElement(By.id("date")).sendKeys(Keys.ESCAPE);
                select(custom_hour, "10");
                select(custom_min, "30");
        }
        click(create_collection);
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

    public void reviewFile(String collectionName, String savedPage, String reviewLoc) {
        openSavedPage(savedPage);
        click(getContentId(reviewFileButt, reviewLoc));
    }

    public void waitAfterCollSelection() {
        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(progress_pages));
        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(reviewed_pages));
        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(completed_pages));
        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(getButton(buttonElement,
                "Edit collection details")));
        Helper.pause(1000);
        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(getButton(buttonElement, "Work on collection")));
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

    public enum CollectionTypes {
        MANUAL, SCHEDULE_CUSTOM;
    }


}
