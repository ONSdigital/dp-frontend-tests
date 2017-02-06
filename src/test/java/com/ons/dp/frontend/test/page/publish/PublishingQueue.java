package com.ons.dp.frontend.test.page.publish;

import com.ons.dp.frontend.test.model.DataTable;
import com.ons.dp.frontend.test.page.BasePage;
import com.ons.dp.frontend.test.util.Helper;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class PublishingQueue extends BasePage {

	public By collection_css = By.cssSelector(".table--primary");
    public By first_row_publishqueue_table = By.cssSelector(".table.table--primary>tbody>tr>td");
    public By collection_name_css = By.className("collection-name");
    public String publish_queue_link = "Publishing queue";
    public String publish_collection_link = "Publish collection";
    public By publish_queue_table = By.id("publish-name");

    Collection collection = new Collection();
    DataTable dataTable;

    public void publishQueue() {
        getWebDriverWait().until(ExpectedConditions.textToBe(getlinkText(publish_queue_link), publish_queue_link));
        Helper.pause(3000);
        click(getlinkText(publish_queue_link));
    }

	public void publishCollection(String collection) {
		getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(collection_css));
		dataTable = new DataTable(true);
        try {
            getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(first_row_publishqueue_table));
            dataTable.getLeftData().get("[manual collection]").click();
        } catch (Exception e) {
            refresh();
            publishQueue();
            getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(first_row_publishqueue_table));
            click(first_row_publishqueue_table);
        }
        Helper.pause(300);
		click(By.xpath("//h3[contains(text()," + collection + ")]"));
		waitUntilTextPresent(getButton(buttonElement, publish_collection_link), publish_collection_link);
        click(getButton(buttonElement, publish_collection_link));

    }


    public void waitUntilCollectionIsPublished() {
        String today = DateTime.now().dayOfMonth().toString();
        getWebDriverWait().until(ExpectedConditions.not(ExpectedConditions.textToBe(publish_queue_table, today)));
    }
}
