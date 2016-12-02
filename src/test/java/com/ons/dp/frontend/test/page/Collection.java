package com.ons.dp.frontend.test.page;

import com.ons.dp.frontend.test.model.DataTable;
import com.ons.dp.frontend.test.util.Do;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Collection extends BasePage{

        public By header = By.className("text-align-center");
        public By collection_name = By.id("collectionname");
        public By manual_publish  = By.id("manualpublish");
        public By sch_publish     = By.id("scheduledpublish");
        public By custom_schedule =  By.id("customschedule");
        public By create_collection = By.xpath("//button[text()[contains(.,'Create collection')]]");
        public By delete_collection = By.id("collection-delete");
        public By confirm_deletion = By.className("confirm");
        DataTable dataTable;

    public boolean getCollection(String collectionName) {
        boolean elementPresent = false;
            Do.until(getDriver(), ExpectedConditions.presenceOfElementLocated(collection_name));
            dataTable = new DataTable();
        WebElement webElement = dataTable.getLeftData().get(collectionName);
        if (webElement != null) {
            elementPresent = true;
            webElement.click();
        }
        return elementPresent;

        }

    public void createCollection(String name, CollectionTypes collectionTypes) {
            sendKeys(collection_name,name);
            switch(collectionTypes){
                case MANUAL:
                    click(manual_publish);
                    break;
                default:
                    click(manual_publish);
            }
            click(create_collection);
        }

    public void deleteCollection(String name) {

        if (getCollection(name)) {
            click(delete_collection);
            click(confirm_deletion);
            Do.until(getDriver(), ExpectedConditions.invisibilityOfElementLocated(confirm_deletion));
        }
        }

    public enum CollectionTypes {
        MANUAL, SCHEDULE;
        }



}
