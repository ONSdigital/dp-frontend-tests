//package pages;
//
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import utilities.CommonMethods;
//import utilities.Log;
//import webDriver.Hooks;
//
//import java.text.ParseException;
//import java.util.List;
//
////import org.testng.Assert;
//
//
///**
// * Created by admin on 12/10/2016.
// */
//public class MediaPage extends BasePage {
//
//    public final String MediaURL = "https://www.ons.gov.uk/news";
//    public CommonMethods commonMethods = new CommonMethods();
//
//
//    public boolean isPageDisplayed() {
//        return commonMethods.isUrlDisplayed(MediaURL);
//    }
//
//    public void ClickOnLink(String linkText) throws InterruptedException {
//        commonMethods.ClickOnLink(linkText);
//        Log.info("Clicked on " + linkText + " link");
//    }
//
//    public void IsLinksEnabled() {
//
//        List<WebElement> Results = driver.findElements(By.cssSelector(".search-results__title>a"));
//        for (WebElement e : Results) {
//            System.out.println(e.getText());
//            Assert.assertTrue(e.isEnabled());
//
//        }
//
//    }
//
//    public void IsPublishedNewsAreListedByDate() throws ParseException {
//        List<WebElement> Results = Hooks.driver.findElements(By.cssSelector(".search-results__meta"));
//        commonMethods.IsResultsDisplayedInDateOrder(Results);
//
//    }
//
//    public void RefineSearchResultsByKeyWord(String keyword) {
//
//        driver.findElement(By.id("input-keywords")).clear();
//        driver.findElement(By.id("input-keywords")).sendKeys(keyword);
//        WebElement resultElement = driver.findElement(By.cssSelector(".search-results__title>a"));
//        commonMethods.isElementLoaded(resultElement);
//
//        List<WebElement> Results = driver.findElements(By.cssSelector(".search-results__title>a"));
//        commonMethods.isElementLoaded(resultElement);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException ex) {
//            ex.printStackTrace();
//        }
//        List<WebElement> Results1 = driver.findElements(By.cssSelector(".search-results__title>a"));
//        if (Results1.size() == 0) {
//
//            System.out.println("There are no news results related to CRIME keyword");
//
//        } else {
//            for (WebElement e : Results1) {
//
//                Assert.assertTrue(e.getText().toLowerCase().contains(keyword));
//
//            }
//        }
//    }
//
//    public void VerifyNationalArchivesLink() {
//
//        Assert.assertTrue(driver.findElement(By.cssSelector(".tiles__content.tiles__content--nav>p>a")).getAttribute("href").equals("http://webarchive.nationalarchives.gov.uk/20160105160709/http://www.ons.gov.uk/ons/index.html"));
//    }
//
//    public void ClickFirstLinkInPublishedNews() {
//        driver.findElement(By.cssSelector(".search-results__title>a")).click();
//    }
//
//    public void IsMediaRelationsEmailEnabled(String email) {
//
//        Assert.assertTrue(driver.findElement(By.linkText(email)).isEnabled());
//
//    }
//
//    public void VerifyLinkInABlock(String link, String text) {
//
//        WebElement blockElement = driver.findElement(By.cssSelector(".tiles__item.tiles__item--nav-type.flush-col"));
//        WebElement textElement = blockElement.findElement(By.xpath("./h3"));
//
//        Assert.assertTrue(textElement.getText().contains(text));
//
//        WebElement emailElement = blockElement.findElement(By.xpath(".//div/ul/li/a"));
//
//        Assert.assertTrue(emailElement.getText().contains(link));
//
//        Assert.assertTrue(emailElement.isEnabled());
//
//    }
//
//    public void CheckContentInGeneralAndStatisticalEnquiriesPage() {
//
//        Assert.assertTrue(driver.getPageSource().contains("We handle email enquiries in line with the Freedom of Information Act 2000."));
//
//    }
//
//    public void CheckNewportAddress() {
//
//        WebElement addressResult = driver.findElement(By.cssSelector(".section__content--static-markdown"));
//
//        Assert.assertTrue(addressResult.getText().contains("Government Buildings\n" +
//                "Cardiff Road\n" +
//                "Newport\n" +
//                "South Wales\n" +
//                "NP10 8XG"));
//
//        Assert.assertTrue(addressResult.getText().contains("Newport"));
//
//        Assert.assertTrue(addressResult.getText().contains("Our headquarters are in South Wales, and are 2 miles from Newport city centre, and just off the M4."));
//
//    }
//
//    public void CheckTitchfieldAddress() {
//
//        WebElement addressResult = driver.findElement(By.cssSelector(".section__content--static-markdown"));
//
//        Assert.assertTrue(addressResult.getText().contains("Segensworth Road\n" +
//                "Titchfield\n" +
//                "Fareham\n" +
//                "Hampshire\n" +
//                "PO15 5RR"));
//
//        Assert.assertTrue(addressResult.getText().contains("Titchfield"));
//
//        Assert.assertTrue(addressResult.getText().contains("The Titchfield office is located midway between Portsmouth and Southampton."));
//
//    }
//
//    public void CheckLondonAddress() {
//
//        WebElement addressResult = driver.findElement(By.cssSelector(".section__content--static-markdown"));
//
//        Assert.assertTrue(addressResult.getText().contains("1 Drummond Gate\n" +
//                "Pimlico\n" +
//                "London\n" +
//                "SW1V 2QQ"));
//
//        Assert.assertTrue(addressResult.getText().contains("London"));
//
//        Assert.assertTrue(addressResult.getText().contains("Our London office is in Pimlico, central London, 2 minutes from Pimlico tube station."));
//
//
//    }
//
//    public void ClickableLinkToGoogleMap() {
//
//        WebElement iFrame = driver.findElements(By.tagName("iframe")).get(0);
//        driver.switchTo().frame(iFrame);
//        Assert.assertTrue(driver.findElement(By.linkText("Sign in")).isEnabled());
//        driver.switchTo().defaultContent();
//        WebElement iFrame1 = driver.findElements(By.tagName("iframe")).get(1);
//        driver.switchTo().frame(iFrame1);
//        Assert.assertTrue(driver.findElement(By.linkText("Sign in")).isEnabled());
//        driver.switchTo().defaultContent();
//        WebElement iFrame2 = driver.findElements(By.tagName("iframe")).get(2);
//        driver.switchTo().frame(iFrame2);
//        Assert.assertTrue(driver.findElement(By.linkText("Sign in")).isEnabled());
//        driver.switchTo().defaultContent();
//    }
//
//    public void IsWebsiteHeaderLinksAreDisplayed() {
//        List<WebElement> headerLinks = driver.findElements(By.cssSelector(".secondary-nav__link.js-nav-clone__link"));
//        for (WebElement e : headerLinks) {
//
//            Assert.assertTrue(e.isEnabled());
//            Assert.assertTrue(e.isDisplayed());
//
//        }
//
//    }
//
//    public void IsMediaHeaderDisplayed(String linktext) {
//
//        Assert.assertTrue(commonMethods.IsLinkDisplayedAndEnabled(linktext));
//
//    }
//
//
//}