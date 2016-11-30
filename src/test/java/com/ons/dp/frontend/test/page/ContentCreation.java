package com.ons.dp.frontend.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 30/11/2016.
 */
public class ContentCreation extends BasePage {

    public String content_ids = "//li[@data-url='/economy')]]";
    public By getContentIds(String content){
      return  By.xpath(content_ids.replace("replace",content));
    }
    public By landingPage = By.cssSelector(".js-browse__item-title page__item page__item--taxonomy_landing_page");
    public By productpage = By.cssSelector("js-browse__item-title page__item page__item--product_page");
    public ArrayList<WebElement> landingPageElements = new ArrayList<>();
    public ArrayList<WebElement> productPageElements = new ArrayList<>();
    public void getLandingPageElements(){
        landingPageElements = (ArrayList<WebElement>) findElementsBy(landingPage);
    }
    public void getProductPageElements(){
        productPageElements = (ArrayList<WebElement>) findElementsBy(productpage);
    }
    public void searchAndClickLP(String taxonomy){
        for(WebElement webElement: landingPageElements){
            if(webElement.getText().contains(taxonomy)){
                webElement.click();
                break;
            }
        }
    }
    public void searchAndClickPP(String taxonomy){
        for(WebElement webElement: productPageElements){
            if(webElement.getText().contains(taxonomy)){
                webElement.click();
                break;
            }
        }
    }

    public void goToGDP(){
        getLandingPageElements();
        searchAndClickLP("Economy");
        searchAndClickPP("Gross Domestic Product (GDP)");

        click(getContentIds("datasets"));
    }
}
