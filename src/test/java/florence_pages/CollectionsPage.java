//package florence_pages;
//
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import pages.BasePage;
//import utilities.CommonMethods;
//import utilities.Log;
//
//import java.util.List;
//
////import org.testng.Assert;
//
///**
// * Created by admin on 21/10/2016.
// */
//public class CollectionsPage extends BasePage {
//
//
//
//    public String AmIOnCollectionsSection() {
//        return driver.findElement(By.xpath(".//*[@id='main']/section[2]/h1")).getText();
//    }
//
//    public String AmIOnWorkingOnCollectionSection() {
//        return driver.findElement(By.xpath(".//*[@id='working-on']/a")).getText();
//    }
//
//    public void ClickAStaticLandinGpage(String text) {
//
//        List<WebElement> linkResults = driver.findElements(By.cssSelector(".js-browse__item-title.page__item.page__item--static_landing_page"));
//
//
//        for (WebElement link : linkResults) {
//            if (link.getText().contains(text)) {
//                link.click();
//                break;
//
//            }
//
//        }
//        Log.info("Clicked on About Us Static landing page");
//    }
//
//    public void ClickOnEditButton(String text) {
//        WebElement element = driver.findElement(By.cssSelector(".page__buttons.page__buttons--list.selected"));
//
//        WebElement actualElement = element.findElement(By.xpath("./span/button"));
//        actualElement.click();
//
//        Log.info("Clicked on Edit button");
//
//    }
//
//    public void ClickOnEditButtonInContent() {
//        driver.findElement(By.id("content-edit")).click();
//    }
//
//    public void SelectACollectionFromListOfCollections(String text) throws InterruptedException {
//        Thread.sleep(500);
//        List<WebElement> linkResults = driver.findElements(By.cssSelector(".collection-name"));
//        Thread.sleep(500);
//        for (WebElement link : linkResults) {
//            if (link.getText().contains(text)) {
//                link.click();
//                break;
//
//            }
//
//        }
//
//    }
//
//    public void SeeTheCollectionInAListOfCollections(String text) throws InterruptedException {
//        Thread.sleep(500);
//        List<WebElement> linkResults = driver.findElements(By.cssSelector(".collection-name"));
//        Thread.sleep(500);
//        for (WebElement link : linkResults) {
//            if (link.getText().contains(text)) {
//                Log.info(text + " is showing in list of collections");
//                break;
//
//            }
//
//        }
//
//    }
//
//    public void ClickOnThePageToReview() throws InterruptedException {
//
//        Thread.sleep(500);
//        WebElement element = driver.findElement(By.cssSelector(".page__item.page__item--static_landing_page"));
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.visibilityOf(element));
//        WebElement element2 = driver.findElement(By.cssSelector(".page__item.page__item--static_landing_page"));
//        element2.click();
//    }
//
//    public void SelectACollectionInPublishingQueue(String text, String linkText) throws InterruptedException {
//        Thread.sleep(500);
//        commonMethods.ClickOnLink(linkText);
//        Thread.sleep(500);
//        text = "[" + text + "]";
//        WebElement baseTable = driver.findElement(By.cssSelector(".table.table--primary.table--fixed-height-27.js-selectable-table"));
//        List<WebElement> tableRows = baseTable.findElements(By.tagName("tr"));
//
//        for (WebElement row : tableRows) {
//            if (row.getText().contains(text)) {
//                Thread.sleep(500);
//                row.click();
//                break;
//            }
//        }
//
//    }
//
//    public void SeeTextInASectionOfThePage(String text) throws InterruptedException {
//        Thread.sleep(500);
//        Assert.assertTrue(driver.findElement(By.cssSelector(".section__content--static-markdown>p")).getText().contains(text));
//    }
//
//    public void IsThisTabSelected(String text) {
//
//        WebElement element = driver.findElement(By.cssSelector(".nav__item.nav__item--workspace.nav__item--browse.js-workspace-nav__item.selected"));
//        Assert.assertTrue(element.getText().contains(text));
//    }
//
//    public void IsEditAndCreateButtonShowing(String buttonText) {
//
//        WebElement element = driver.findElement(By.cssSelector(".page__buttons.page__buttons--list.selected"));
//        Assert.assertTrue(element.getText().contains(buttonText));
//    }
//
//
//    public void IsWebPreviewHomePageDisplayed() {
//
//        driver.switchTo().frame(driver.findElement(By.id("iframe")));
//        WebElement element = driver.findElement(By.cssSelector(".page-intro__title.page-intro__title--home"));
//        Assert.assertTrue(element.getText().contains("Office for National Statistics"));
//        driver.switchTo().defaultContent();
//    }
//
//    public void IsTaxonomyDisplayed() {
//
//        WebElement element = driver.findElement(By.xpath(".//*[@id='browse-tree']/section/nav/ul/li"));
//        Assert.assertTrue(element.getText().contains("Home"));
//        Assert.assertTrue(element.getText().contains("A-Z"));
//        Assert.assertTrue(element.getText().contains("About us"));
//        Assert.assertTrue(element.getText().contains("Business, industry and trade"));
//        Assert.assertTrue(element.getText().contains("Census"));
//        Assert.assertTrue(element.getText().contains("Classifications"));
//        Assert.assertTrue(element.getText().contains("Economy"));
//        Assert.assertTrue(element.getText().contains("Emergency information for ONS staff"));
//        Assert.assertTrue(element.getText().contains("Employment and labour market"));
//        Assert.assertTrue(element.getText().contains("Help"));
//        Assert.assertTrue(element.getText().contains("Media"));
//        Assert.assertTrue(element.getText().contains("Methodology"));
//        Assert.assertTrue(element.getText().contains("People, population and community"));
//        Assert.assertTrue(element.getText().contains("Surveys"));
//        Assert.assertTrue(element.getText().contains("releases"));
//
//    }
//
//    public void SeeTextOnThePopUp(String text) {
//
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".confirm")));
//
//    }
//
//    public void ClickOnTheVisualisationPageToReview() {
//
//        WebElement element = driver.findElement(By.cssSelector(".page__item.page__item--visualisation"));
//
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.visibilityOf(element));
//        element.click();
//    }
//}
