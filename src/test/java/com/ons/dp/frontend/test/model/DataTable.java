package com.ons.dp.frontend.test.model;


import com.ons.dp.frontend.test.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataTable {
    BasePage basePage = new BasePage();
    public String collectionTableRowStr = "//table/tbody/tr";
    public By collectionTableRowID = By.xpath(collectionTableRowStr);

    public ArrayList<WebElement> tableRows = new ArrayList<>();

    public Map<String, WebElement> collection = new HashMap<>();
    public int numberOfRows=0;

    public DataTable(){
        populateTableRows();
        populateCollection();
    }

    public Map<String, WebElement> getCollection(){
        return collection;
    }
    public ArrayList<WebElement> getTableRowElements() {
        return tableRows;
    }
    public void populateCollection() {
        for(int row =0;row<numberOfRows;row++) {
            String collectionName = collectionTableRowStr+"["+row+"]/td[0]";

            WebElement collectionDate = basePage.getElement(By.xpath(collectionTableRowStr+"["+row+"]/td[1]"));
            collection.put(collectionName,collectionDate);
        }
        }
    public void populateTableRows(){
        tableRows = (ArrayList<WebElement>) basePage.findElementsBy(collectionTableRowID);
        numberOfRows = tableRows.size();
    }





}
