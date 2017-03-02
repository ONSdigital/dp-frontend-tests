package com.ons.dp.frontend.test.page.webpage;

import com.ons.dp.frontend.test.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Homepage extends BasePage {
    public By search = By.id("nav-search");
    public By about = By.linkText("aboutus");
    public By search_Submit = By.id("nav-search-submit");

    public static String isLinkBroken(URL url) throws Exception

    {

        //url = new URL("http://yahoo.com");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try


        {

            connection.connect();

            String response = connection.getResponseMessage();

            connection.disconnect();

            return response;

        } catch (Exception exp)

        {

            return exp.getMessage();

        }

    }

    public void openHomePage() {
        navigateToUrl(getConfig().getOnsdevelop_URL());

    }

    public void openSandPitHomePage() {
        navigateToUrl(getConfig().getOnsSandpit_URL());
    }

    public void searchForTimeSeriesID(String timeSeriesID) {
        getElement(search).sendKeys(timeSeriesID);
        click(search_Submit);

    }

    public void goToPage(String linkToGoTo) {

        navigateToUrl(getConfig().getOnsdevelop_URL() + linkToGoTo);
    }

    public void goToSandpitPage(String linkToGoTo) {

        navigateToUrl(getConfig().getOnsSandpit_URL() + linkToGoTo);

    }

    public void openLiveHomePage() {
        navigateToUrl(getConfig().getOnsURL());
    }

    public List findAllLinks() {

        //  ArrayList<WebElement> elementList = new ArrayList();

        List<WebElement> elementList = getDriver().findElements(By.tagName("a"));

        //   elementList.addAll(getDriver().findElements(By.tagName("img")));

        List finalList = new ArrayList();
        ;

        for (WebElement element : elementList)

        {

            if (element.getAttribute("href") != null)

            {

                finalList.add(element);

            }

        }

        return finalList;
    }
}
