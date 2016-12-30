package com.ons.dp.frontend.test.page.webpage;

import com.ons.dp.frontend.test.page.BasePage;
import org.openqa.selenium.By;

public class SearchReleases extends BasePage {

	public By input_keyword = By.id("input-keywords");
	public By after_day = By.name("fromDateDay");
	public By after_month = By.name("fromDateMonth");
	public By after_year = By.name("fromDateYear");
	public By to_day = By.name("toDateDay");
	public By to_month = By.name("toDateMonth");
	public By to_year = By.name("toDateYear");
	public By clearAll = By.id("clear-search");
	public By fieldSet = By.cssSelector("legend.filters__title");

	public void searchReleases(String keyword, String pubAfter, String pubBefore) {
		click(clearAll);
		String[] pubAfterDate = pubAfter.split("/");
		String[] pubBeforeDate = pubBefore.split("/");
		sendKeys(input_keyword, keyword);
		sendKeys(after_day, pubAfterDate[0]);
		sendKeys(after_month, pubAfterDate[1]);
		sendKeys(after_year, pubAfterDate[2]);
		sendKeys(to_day, pubBeforeDate[0]);
		sendKeys(to_month, pubBeforeDate[1]);
		sendKeys(to_year, pubBeforeDate[2]);
		click(fieldSet);
	}

}
