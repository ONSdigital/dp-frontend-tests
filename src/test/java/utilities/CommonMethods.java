package utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by admin on 13/10/2016.
 */
public class CommonMethods
{
    protected final WebDriver driver;


    public CommonMethods(final WebDriver driver){
        this.driver = driver;

    }

    public boolean isUrlDisplayedX(String key) {
        try {
            String expectedurl = Urls.urlMapping.get(key);
            return driver.getCurrentUrl().equalsIgnoreCase(expectedurl);

        } catch (final NoSuchElementException e) {
            return false;
        }
    }

    public void NavigateToPage(String key){

        try {
            String navigateToUrl = Urls.urlMapping.get(key).toLowerCase();
             driver.navigate().to(navigateToUrl);

        } catch (final NoSuchElementException e) {

        }

    }

    public boolean isUrlDisplayed(String url) {
        try {
            return driver.getCurrentUrl().equalsIgnoreCase(url);

        } catch (final NoSuchElementException e) {
            return false;
        }
    }

    public void NavigateToUrl(final String url){
        driver.navigate().to(url);
    }

    public void ClickOnLink(final String linkText) throws InterruptedException {
        Thread.sleep(500);

        driver.findElement(By.linkText(linkText)).click();
    }


    public boolean IsLinkDisplayedAndEnabled(final String linkText){
        try {
           return driver.findElement(By.linkText(linkText)).isEnabled();
        }
        catch(final NoSuchElementException e){
            return false;
        }
    }

/*    public boolean visibilityOfElementWait(WebElement webElement) {
        if (webElement != null) {
            try {
                WebDriverWait wait = new WebDriverWait(driver., 20);
                wait.until(ExpectedConditions.visibilityOf(wrappedElement));
                highlightElement(webElement);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else
            System.out.print("PageElement " + webElement.getText() + " not exist");
        return false;
    }*/

    public WebElement isElementLoaded(WebElement elementToBeLoaded) {
        WebDriverWait wait = new WebDriverWait(driver, 500);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
        return element;
    }

    public void IsResultsDisplayedInDateOrder(List<WebElement> elements) throws ParseException {

        List<Date> expected = new ArrayList<>();
        List<Date> actual = new ArrayList<>();

        for (WebElement e : elements) {
            String text = e.getText();
            if (text.startsWith("| Released on ")) {
                //  String dateStr = text.split("| Released on ")[1];
                String dateStr = text.replace("| Released on ", "");

                DateFormat format = new SimpleDateFormat("d MMMM yyyy", Locale.ENGLISH);
                Date date = format.parse(dateStr);

                expected.add(date);
                actual.add(date);
            }

            Collections.sort(expected, Collections.reverseOrder());
            Assert.assertTrue(expected.equals(actual));

        }

    }

    public void EnterStringIntoFiled(String text, String element)
    {
        if(text.contains("Tomorrows Date"))
        {
            /*Date dt = new Date();
            DateTime dtOrg = new DateTime(dt);
            DateTime dtPlusOne = dtOrg.plusDays(1);
            text = dtPlusOne.toString();*/
            /*Date date = Calendar.getInstance().getTime();
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String today = formatter.format(date);*/

            /*Date dt = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(dt));
            c.add(Calendar.DATE, 1);  // number of days to add
            dt = sdf.format(c.getTime());*/



            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar c = Calendar.getInstance();
            c.setTime(new Date()); // Now use today date.
            c.add(Calendar.DATE, 1); // Adding 1 day
            text = sdf.format(c.getTime()).toString();


        }
        try {
            String mappedElement = Elements.elementMapping.get(element);
            driver.findElement(By.id(mappedElement)).sendKeys(text);
        }
        catch(NoSuchElementException e){
            String mappedElement = Elements.elementMapping.get(element);
            driver.findElement(By.cssSelector(mappedElement)).click();
        }
    }

    public void EnterStringIntoPopUpField(String text, String element)
    {
        String mappedElement = Elements.elementMapping.get(element);
        driver.findElement(By.xpath(mappedElement)).sendKeys(text);
    }

    public void ClickOnButton(String element){

        try {
            String mappedElement = Elements.elementMapping.get(element);
            driver.findElement(By.cssSelector(mappedElement)).click();

        } catch (NoSuchElementException e) {
            String mappedElement = Elements.elementMapping.get(element);
              driver.findElement(By.id(mappedElement)).click();
        }
    }

    public void SelectRadioButton(String element){
        String mappedElement = Elements.elementMapping.get(element);
        driver.findElement(By.id(mappedElement)).click();

    }

    public String GetTextFromElement(String element){

        String mappedElement = Elements.elementMapping.get(element);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(mappedElement)));


      return  driver.findElement(By.id(mappedElement)).getText();

    }

    public void SeeTheTextInAPage(String text) throws InterruptedException {

      //  WebDriverWait wait = new WebDriverWait(driver, 10);
      //  wait.until(ExpectedConditions.textToBePresentInElementLocated(element, text));
        Thread.sleep(3000);
        Assert.assertTrue(driver.getPageSource().contains(text));

    }


    public void SelectValueFromDropDown(String value, String elementID) {

        String mappedElement = Elements.elementMapping.get(elementID);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(mappedElement)));
        Select dropdown = new Select(driver.findElement(By.id(mappedElement)));
        dropdown.selectByVisibleText(value);
        Log.info("Selected " + value + " from the dropdown");

    }

    public void ClickOnARowInATable(String text, String tableElement) {

        String mappedElement = Elements.elementMapping.get(tableElement);
        WebElement table = driver.findElement(By.cssSelector(mappedElement));
        List<WebElement> allrows = table.findElements(By.tagName("tr"));
        List<WebElement> allcols = table.findElements(By.tagName("td"));

        for(WebElement row: allrows){
            List<WebElement> Cells = row.findElements(By.tagName("td"));
            for(WebElement Cell:Cells){
                if (Cell.getText().contains(text))
                    Cell.click();
                Log.info("Selected the selection " + tableElement + " in collections table");
                                break;


            }
        }
    }

    public void SelectTextInATable(String text, String tableElement) throws InterruptedException {
        String mappedElement = Elements.elementMapping.get(tableElement);
        List<WebElement> elements = driver.findElements(By.cssSelector(mappedElement));
        Thread.sleep(500);
        for (WebElement element: elements) {
            if(element.getText().contains(text)){

                /*WebDriverWait wait = new WebDriverWait(driver, 30);
                WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(mappedElement)));*/

                element.click();
                break;

            }

        }
        Log.info("Selected " + text + " in the " + tableElement + " table");



    }

    public void SeeTheTextInASectionOfAPage(String text, String sectionElement) {

        String mappedElement = Elements.elementMapping.get(sectionElement);
        String titleText = driver.findElement(By.xpath(mappedElement)).getText();
        Assert.assertTrue(titleText.contains(text));


    }

    public void ShouldNotSeeTheCollection(String text) throws InterruptedException {

        Thread.sleep(500);
        List<WebElement> linkResults = driver.findElements(By.cssSelector(".collection-name"));
        Thread.sleep(500);
        for (WebElement link : linkResults) {
            if(link.getText().contains(text)){
               Assert.assertFalse(text + " collection shown when it shouldn't be", false);

            }

        }


    }

    public void IsButtonEnabled(String buttonText) {

        String mappedElement = Elements.elementMapping.get(buttonText);
        Assert.assertTrue(driver.findElement(By.cssSelector(mappedElement)).isEnabled());
    }

    public void SelectCheckBox(String checkBoxText) {

        String mappedElement = Elements.elementMapping.get(checkBoxText);
        driver.findElement(By.cssSelector(mappedElement)).click();
        Log.info("Selected " + checkBoxText + " checkbox");
    }

    public void SelectLinkInARow(String linkText, String element) {
    }
}
