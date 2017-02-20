package com.ons.dp.frontend.test.page.publish;

import com.ons.dp.frontend.test.page.BasePage;
import com.ons.dp.frontend.test.util.CustomDates;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ProductPage extends BasePage {

    public By selectNewPage = By.id("pagetype");
    public By editionField = By.id("edition");
    public By releaseDateField = By.id("releaseDate");
    public By pageNameField = By.id("pagename");


    public void createBulletinPage(String pageType, String pageName, String editionName) {

        select(selectNewPage, pageType);
        sendKeys(editionField, editionName);
        sendKeys(releaseDateField, CustomDates.getDateInDiffFormat(+1));
        getElement(releaseDateField).sendKeys(Keys.ESCAPE);
        sendKeys(pageNameField, pageName);

        click(getButton(buttonElement, "Create page"));
    }
}


