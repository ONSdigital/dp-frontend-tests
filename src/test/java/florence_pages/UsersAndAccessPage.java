package florence_pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import utilities.CommonMethods;
import utilities.Log;

import java.util.List;

/**
 * Created by admin on 01/11/2016.
 */
public class UsersAndAccessPage extends BasePage
{
    public CommonMethods commonMethods;
    public UsersAndAccessPage(WebDriver driver) {
        super(driver);
        commonMethods = new CommonMethods(driver);
    }

    public void SeeTheTextInATable(String text){

        List<WebElement> linkResults = driver.findElements(By.cssSelector(".collection-name"));
        for (WebElement link : linkResults) {
            if(link.getText().contains(text)){
                Log.info("User created successfully");
                 break;

            }

        }

    }

    public void IsNewUserAddedToTheTeam(String text){

        Assert.assertTrue(driver.findElement(By.cssSelector(".team-list>li")).getText().contains(text));

    }

    public void ClickOnCensusHomePage(String text) {
        List<WebElement> linkResults = driver.findElements(By.cssSelector(".js-browse__item-title.page__item.page__item--home_page_census"));

        for (WebElement link : linkResults) {
            if(link.getText().contains(text)){
                link.click();
                break;

            }

        }
        Log.info("Clicked on Census home page");

    }

    public void ClickOnCreateButtonInCensus(String buttonText) {

        WebElement element = driver.findElement(By.cssSelector(".page__buttons.page__buttons--list.selected"));

        WebElement actualElement = element.findElement(By.xpath("./span/button[2]"));
        actualElement.click();

        Log.info("Clicked on Create button");
    }
}
