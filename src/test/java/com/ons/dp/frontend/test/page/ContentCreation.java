package com.ons.dp.frontend.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Random;

public class ContentCreation extends BasePage {

    public String content_css = ".js-browse__item[data-url='/text_to_replace']>span>span";
    public String directory_css = ".selected > ul > li > span > span.js-browse__item-title.page__item.page__item--directory";
    public String content_headers = "//h1[text()[contains(.,'text_to_replace')]]";
    public By file_label_text = By.id("label");
    public By fileUpload = By.name("files");

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
        click(getButton(buttonElement,"Edit"));
        click(getContentHeaders("Download options"));
        click(getButton(buttonElement,"Update / Add supplementary file"));
        click(getContentHeaders("Versions"));
        click(getButton(buttonElement,"Add version"));
        sendKeys(file_label_text, "999");
        sendKeys(fileUpload, "src/test/resources/files/cxnv.csdb");
        click(getButton(buttonElement,"Submit"));


        }
}
