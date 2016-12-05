package com.ons.dp.frontend.test.page;

import com.fasterxml.jackson.databind.deser.Deserializers;
import com.ons.dp.frontend.test.model.DataTable;
import com.ons.dp.frontend.test.util.Do;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by admin on 05/12/2016.
 */
public class PublishingQueue extends BasePage {

    public By collection_css = By.cssSelector(".table.table--primary.table--fixed-height-27.js-selectable-table>tbody>tr>td");
    public By collection_name_css = By.cssSelector(".collection-name");
    Collection collection = new Collection();
    DataTable dataTable;

    public void ClickOnPublishingQueue() {
        click(getlinkText("Publishing queue"));
    }

    public void PublishCollection() {

        waitUntilTextPresent(collection_css, "[manual collection]");
        //collection.getCollection("[manual collection]");
        //    getRightDataCollection("[manual collection]");
        dataTable = new DataTable("PublishingQueue");
        dataTable.getLeftData().get("[manual collection]").click();

        click(collection_name_css);
        waitUntilTextPresent(getButton(buttonElement, "Publish collection"), "Publish collection");
        click(getButton(buttonElement, "Publish collection"));

    }

    public boolean getRightDataCollection(String collectionName) {
        boolean elementPresent = false;
        // Do.until(getDriver(), ExpectedConditions.presenceOfElementLocated(collection_name));
        dataTable = new DataTable();
        WebElement webElement = dataTable.getRightData().get(collectionName);
        if (webElement != null) {
            elementPresent = true;
            webElement.click();
        }
        return elementPresent;

    }
}
