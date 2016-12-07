package com.ons.dp.frontend.test.page.publish;

import com.ons.dp.frontend.test.model.DataTable;
import com.ons.dp.frontend.test.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class PublishingQueue extends BasePage {

    public By collection_css = By.cssSelector(".table.table--primary.table--fixed-height-27.js-selectable-table>tbody>tr>td");
    public By collection_name_css = By.cssSelector(".collection-name");
    public String publish_queue_link = "Publishing queue";
    public String publish_collection_link = "Publish collection";
    Collection collection = new Collection();
    DataTable dataTable;

    public void publishQueue() {
        getWebDriverWait().until(ExpectedConditions.textToBe(getlinkText(publish_queue_link), publish_queue_link));
        click(getlinkText(publish_queue_link));
    }

    public void publishCollection() {

        waitUntilTextPresent(collection_css, "[manual collection]");
        dataTable = new DataTable(true);
        dataTable.getLeftData().get("[manual collection]").click();

        click(collection_name_css);
        waitUntilTextPresent(getButton(buttonElement, publish_collection_link), publish_collection_link);
        click(getButton(buttonElement, publish_collection_link));

    }


}