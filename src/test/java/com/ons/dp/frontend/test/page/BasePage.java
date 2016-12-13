package com.ons.dp.frontend.test.page;


import com.ons.dp.frontend.test.core.Configuration;
import com.ons.dp.frontend.test.core.TestContext;
import com.ons.dp.frontend.test.util.Do;
import com.ons.dp.frontend.test.util.Helper;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class BasePage {

    public String buttonElement = "//button[text()[contains(.,'replace')]]";
    public By linkText = By.linkText("text_to_replace");

    public WebDriver getDriver(){
     return   TestContext.getDriver();
    }

    public Configuration getConfig(){
        return TestContext.getConfiguration();
    }


    public WebDriverWait getWebDriverWait(){
        return TestContext.getWebDriverWait();
    }

    public void navigateToUrl(String url){
        getDriver().get(url);
    }

    public By getlinkText(String link) {
        return By.linkText(link);
    }
    public WebElement getElement(final By by) {
        Do.until(getDriver(), presenceOfElementLocated(by));
        return getDriver().findElement(by);
    }
    public WebElement getElement(final By by, long timeout) {
        return Do.until(getDriver(), ExpectedConditions.presenceOfElementLocated(by), timeout);
    }

    public By getButton(String idToGenerate, String textValue){
        return By.xpath(idToGenerate.replace("replace",textValue));
    }



    public void refresh() {
        getDriver().navigate().refresh();
    }

    public void refreshAfterSecs(int seconds) {
        sleepInSecs(seconds);
        getDriver().navigate().refresh();
    }
    public void sleepInSecs(int secs) {
        try {
            Thread.sleep(1000 * secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyUrlContains(String contains) {
        getWebDriverWait().until(urlContains(contains));
    }

    public void verifyElementNotVisible(By... byItems) {
        for (By by : byItems) {
            Do.until(getDriver(), invisibilityOfElementLocated(by));
        }
    }

    public void verifyElementsNotPresent(By... byItems) {
        try {
            for (By by : byItems) {
                List<WebElement> elements = getDriver().findElements(by);
                if (!elements.isEmpty()) {
                    System.out.println("No Element Present");

                }
            }
        }
        catch(Exception ee){
            ee.printStackTrace();
            }
    }

    public void verifyElementsPresent(By... byItems) {
        for (By by : byItems) {
            Do.until(getDriver(), presenceOfElementLocated(by));
        }
    }

    public boolean isElementNotPresent(By by) {
        return getDriver().findElements(by).isEmpty();
    }

    public boolean isElementPresent(By by) {
        try {
            final WebElement element = getElement(by);
            return element != null && element.isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isElementPresentWithOutWait(By by) {
        try {
            return getDriver().findElement(by).isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean isAttributePresent(By elementCss, String attributeName) {
        final WebElement element = getElement(elementCss);
        return element != null && element.isDisplayed() && StringUtils.isNotBlank(element.getAttribute(attributeName));
    }

    public boolean isAttributePresent(By elementCss, String attributeName, String attributeValue) {
        final WebElement element = getElement(elementCss);
        return element != null && element.isDisplayed() && StringUtils.isNotBlank(element.getAttribute(attributeName)) &&
                ((element.getAttribute(attributeName)).contains(attributeValue));
    }

    public boolean isTextPresent(By by, Long timeout) {
        WebElement element = getElement(by, timeout);
        return element != null && element.isDisplayed() && StringUtils.isNotBlank(element.getText());
    }

    public boolean isTextPresent(By by) {

        final WebElement element = getElement(by);
        return element != null && element.isDisplayed() && StringUtils.isNotBlank(element.getText());
    }
    public String getAttributeText(By by, String attribute) {
        return getElement(by).getAttribute(attribute);
    }

    public String getPageTitle() {
        return getDriver().getTitle();
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }
    public boolean pageSourceContains(String text) {
        return getDriver().getPageSource().contains(text);
    }

    public void clear(By by) {
        Helper.pause(1000);
        Do.until(getDriver(), presenceOfElementLocated(by));
       getElement(by).clear();
    }
    public void click(By by) {
        Helper.pause(500);
        Do.until(getDriver(), presenceOfElementLocated(by));
//        Do.until(getDriver(), elementToBeClickable(by));
        getElement(by).click();
    }

    public void sendKeys(By by, String text){
        Helper.pause(500);
        Do.until(getDriver(), presenceOfElementLocated(by));
       getElement(by).sendKeys(text);
    }
    public List<WebElement> findElementsBy(By by) {
        return getDriver().findElements(by);
    }

    public List<WebElement> findElementsByWithoutWait(By by) {
        return getDriver().findElements(by);
    }
    public String getElementText(By by) {
        Do.until(getDriver(), presenceOfElementLocated(by));
        return getElement(by).getText();
    }

    public boolean waitUntilTextPresent(By by, String text) {
        return getWebDriverWait().until(textToBePresentInElementLocated(by, text));
    }
    public boolean isEnabled(By by) {
        try {
            return getElement(by).isEnabled();
        } catch (final NoSuchElementException e) {
            return false;
        }
    }
    public void fillWithValue(By by, String value) {
        try {
            clear(by);
        } catch (Exception ex) {
            // some elements can't be cleared - eg. dropdowns
        }
        WebElement element = getElement(by);

        if (value != null) {
            element.sendKeys(value);
        }
    }

    public void select(By by, String value) {
        Helper.pause(1000);
        try {
            WebElement element = getElement(by);
            Select select = new Select(element);
            select.selectByVisibleText(value);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    public void deselect(By by) {
        WebElement webElement = getElement(by);
        if(getElement(by).isSelected()){ webElement.click();}
        }
        public void select(By by) {
            if(! getElement(by).isSelected()){
                click(by);
            }
        }

    public By getContentId(String cssString, String text) {
        String content = cssString.replace("text_to_replace", text);
        return By.cssSelector(content);
    }


    public void ClickOnLink(final String linkText) throws InterruptedException {
        getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(By.linkText(linkText)));
        getElement(By.linkText(linkText)).click();
    }


    public void getTextFromPageSource(String text) {

        getDriver().getPageSource().contains(text);

    }






























}


