package com.ons.dp.frontend.test.page.webpage;

import Util.Log;
import com.ons.dp.frontend.test.page.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.util.List;


public class MediaPage extends BasePage {

  //  public CommonMethods commonMethods;
    public final String MediaURL = "https://www.ons.gov.uk/news";
  private UrlsPage urlsPage= new UrlsPage();


    /*public MediaPage(WebDriver driver)  {
        super(driver);

        commonMethods = new CommonMethods(driver);
    }*/

    public boolean isPageDisplayed() {
        return urlsPage.isUrlDisplayed(MediaURL);
    }

    public void ClickOnLink(String linkText) throws InterruptedException {
        ClickOnLink(linkText);
       // click(linkText);
        Log.info("Clicked on " + linkText + " link");
    }

    public void IsLinksEnabled() {

        List<WebElement> Results = getDriver().findElements(By.cssSelector(".search-results__title>a"));
        for (WebElement e : Results) {
            System.out.println(e.getText());
            Assert.assertTrue(e.isEnabled());

        }

    }

    public void IsPublishedNewsAreListedByDate() throws ParseException {
        List<WebElement> Results = getDriver().findElements(By.cssSelector(".search-results__meta"));
        IsResultsDisplayedInDateOrder(Results);

    }

    public void RefineSearchResultsByKeyWord(String keyword){

        getDriver().findElement(By.id("input-keywords")).clear();
        getDriver().findElement(By.id("input-keywords")).sendKeys(keyword);
        WebElement resultElement = getDriver().findElement(By.cssSelector(".search-results__title>a"));
        isElementLoaded(resultElement);

        List<WebElement> Results = getDriver().findElements(By.cssSelector(".search-results__title>a"));
        isElementLoaded(resultElement);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        List<WebElement> Results1 = getDriver().findElements(By.cssSelector(".search-results__title>a"));
        if(Results1.size() == 0){

            System.out.println("There are no news results related to CRIME keyword");

        }else{
            for (WebElement e : Results1) {

                Assert.assertTrue(e.getText().toLowerCase().contains(keyword));

            }}
    }
    public void VerifyNationalArchivesLink(){

        Assert.assertTrue(getDriver().findElement(By.cssSelector(".tiles__content.tiles__content--nav>p>a")).getAttribute("href").equals("http://webarchive.nationalarchives.gov.uk/20160105160709/http://www.ons.gov.uk/ons/index.html"));
    }

    public void ClickFirstLinkInPublishedNews(){
        getDriver().findElement(By.cssSelector(".search-results__title>a")).click();
    }

    public void IsMediaRelationsEmailEnabled(String email){

        Assert.assertTrue(getDriver().findElement(By.linkText(email)).isEnabled());

    }

    public void VerifyLinkInABlock(String link, String text){

        WebElement blockElement= getDriver().findElement(By.cssSelector(".tiles__item.tiles__item--nav-type.flush-col"));
        WebElement textElement = blockElement.findElement(By.xpath("./h3"));

        Assert.assertTrue(textElement.getText().contains(text));

        WebElement emailElement = blockElement.findElement(By.xpath(".//div/ul/li/a"));

        Assert.assertTrue(emailElement.getText().contains(link));

        Assert.assertTrue(emailElement.isEnabled());

    }

    public void CheckContentInGeneralAndStatisticalEnquiriesPage(){

        Assert.assertTrue(getDriver().getPageSource().contains("We handle email enquiries in line with the Freedom of Information Act 2000."));

    }

    public void CheckNewportAddress(){

        WebElement addressResult = getDriver().findElement(By.cssSelector(".section__content--static-markdown"));

        Assert.assertTrue(addressResult.getText().contains("Government Buildings\n" +
                "Cardiff Road\n" +
                "Newport\n" +
                "South Wales\n" +
                "NP10 8XG"));

        Assert.assertTrue(addressResult.getText().contains("Newport"));

        Assert.assertTrue(addressResult.getText().contains("Our headquarters are in South Wales, and are 2 miles from Newport city centre, and just off the M4."));

    }

    public void CheckTitchfieldAddress(){

        WebElement addressResult = getDriver().findElement(By.cssSelector(".section__content--static-markdown"));

        Assert.assertTrue(addressResult.getText().contains("Segensworth Road\n" +
                "Titchfield\n" +
                "Fareham\n" +
                "Hampshire\n" +
                "PO15 5RR"));

        Assert.assertTrue(addressResult.getText().contains("Titchfield"));

        Assert.assertTrue(addressResult.getText().contains("The Titchfield office is located midway between Portsmouth and Southampton."));

    }

    public void CheckLondonAddress(){

        WebElement addressResult = getDriver().findElement(By.cssSelector(".section__content--static-markdown"));

        Assert.assertTrue(addressResult.getText().contains("1 Drummond Gate\n" +
                "Pimlico\n" +
                "London\n" +
                "SW1V 2QQ"));

        Assert.assertTrue(addressResult.getText().contains("London"));

        Assert.assertTrue(addressResult.getText().contains("Our London office is in Pimlico, central London, 2 minutes from Pimlico tube station."));



    }

    public void ClickableLinkToGoogleMap(){

        WebElement iFrame = getDriver().findElements(By.tagName("iframe")).get(0);
        getDriver().switchTo().frame(iFrame);
        Assert.assertTrue(getDriver().findElement(By.linkText("Sign in")).isEnabled());
        getDriver().switchTo().defaultContent();
        WebElement iFrame1 = getDriver().findElements(By.tagName("iframe")).get(1);
        getDriver().switchTo().frame(iFrame1);
        Assert.assertTrue(getDriver().findElement(By.linkText("Sign in")).isEnabled());
        getDriver().switchTo().defaultContent();
        WebElement iFrame2 = getDriver().findElements(By.tagName("iframe")).get(2);
        getDriver().switchTo().frame(iFrame2);
        Assert.assertTrue(getDriver().findElement(By.linkText("Sign in")).isEnabled());
        getDriver().switchTo().defaultContent();
    }

    public void IsWebsiteHeaderLinksAreDisplayed(){
        List<WebElement> headerLinks = getDriver().findElements(By.cssSelector(".secondary-nav__link.js-nav-clone__link"));
        for (WebElement e : headerLinks) {

            Assert.assertTrue(e.isEnabled());
            Assert.assertTrue(e.isDisplayed());

        }

    }

    public void IsMediaHeaderDisplayed(String linktext){

        Assert.assertTrue(IsLinkDisplayedAndEnabled(linktext));

    }


}
