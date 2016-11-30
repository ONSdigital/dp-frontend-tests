package com.ons.dp.frontend.test.model;


import com.ons.dp.frontend.test.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataTable {
    BasePage basePage = new BasePage();
    public String collectionTableRowStr = "//table/tbody/tr";
    public By collectionTableRowID = By.xpath(collectionTableRowStr);

    public ArrayList<WebElement> tableRows = new ArrayList<>();

    public Map<String, WebElement> leftData = new HashMap<>();

    public Map<String, WebElement> rightData = new HashMap<>();
    public Map<String, String> tableContents = new HashMap<>();

    public int numberOfRows=0;

    public DataTable(){
        populateTableRows();
        populateLeftNameELements();
        populateRightNameElement();
        populateTableContents();
    }

    public Map<String, WebElement> getLeftData(){
        return leftData;
    }
    public Map<String, WebElement> getRightData(){
        return rightData;
    }
    public Map<String, String> getTableContents(){return tableContents;}
    public ArrayList<WebElement> getTableRowElements() {
        return tableRows;
    }
    public void populateLeftNameELements() {
        for(int row =1;row<=numberOfRows;row++) {
            String collectionName = collectionTableRowStr+"["+row+"]/td[1]";
            leftData.put(basePage.getElementText(By.xpath(collectionName)),basePage.getElement(By.xpath(collectionName)));
        }

    }
    public void populateRightNameElement(){
            for(int row =1;row<=numberOfRows;row++) {
            String collectionName = collectionTableRowStr+"["+row+"]/td[2]";
            rightData.put(basePage.getElementText(By.xpath(collectionName)),basePage.getElement(By.xpath(collectionName)));
            }
    }
    public void populateTableRows(){
        tableRows = (ArrayList<WebElement>) basePage.findElementsBy(collectionTableRowID);
        numberOfRows = tableRows.size();
    }
    public void populateTableContents(){
        for(int row =1;row<=numberOfRows;row++) {
            String name = collectionTableRowStr+"["+row+"]/td[1]";
            String details = collectionTableRowStr+"["+row+"]/td[2]";
            tableContents.put(basePage.getElementText(By.xpath(name)),basePage.getElementText(By.xpath(details)));
        }
    }





}
