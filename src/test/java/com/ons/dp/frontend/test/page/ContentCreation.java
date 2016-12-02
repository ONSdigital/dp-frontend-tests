package com.ons.dp.frontend.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class ContentCreation extends BasePage {

    private String content_css = ".js-browse__item[data-url='/text_to_replace']>span>span";
    private String directory_css = ".selected > ul > li > span > span.js-browse__item-title.page__item.page__item--directory";
    private String content_headers = "//h1[text()[contains(.,'text_to_replace')]]";
    private By file_label_text = By.id("label");
    private By fileUpload = By.name("files");
    private String active_dataset_buttons = ".selected > span > span >button.btn-browse-text_to_replace";

    public By getActiveDatasetButtons(String buttonText) {
        return By.cssSelector(active_dataset_buttons.replace("text_to_replace", buttonText));
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


    public void goToGDP(){
        click(getContentId(content_css,"economy"));
        click(getContentId(content_css,"economy/grossdomesticproductgdp"));
        getDirectoryElement("datasets").click();
        click(getContentId(content_css,"economy/grossdomesticproductgdp/datasets/businessinvestment"));
        //waitUntilTextPresent(getButton(buttonElement,"Edit"), "Edit");
        click(getActiveDatasetButtons("Edit"));
        click(getContentHeaders("Download options"));
        click(getActiveDatasetButtons("Update / Add supplementary file"));
        click(getContentHeaders("Versions"));
        click(getActiveDatasetButtons("Add version"));
        sendKeys(file_label_text, "999");
        sendKeys(fileUpload, "src/test/resources/files/cxnv.csdb");
        click(getActiveDatasetButtons("Submit"));


        }
}
