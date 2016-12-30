package com.ons.dp.frontend.test.page.webpage;


import com.ons.dp.frontend.test.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;


public class ReleaseCalendar extends BasePage {

	public String releaseCalendar = "Release calendar";
	public By selectedTab = By.cssSelector("span.tab__link--active");
	public String publishedReleasesTab = "Published releases";
	public String upcomingReleasesTab = "Upcoming releases";
	public By releases = By.cssSelector("h3.search-results__title > a");
	public String pageLinks = "//a[contains(text(),'replace')]";
	public By results_size = By.id("page-size");
	public By releaseHeader = By.cssSelector("h1.page-intro__title>span.page-intro__type");
	public By alert_title = By.cssSelector("p.alert__title margin-top-md--1");
	public By contact_info = By.cssSelector("a[data-ga-event-category='mailto']");
	public By releaseDate = By.xpath("//p[contains(text(),'Release date:')]");
	public By nextReleaseDate = By.xpath("//p[contains(text(),'Next release:')]");
	public By ons_image = By.cssSelector("img.meta__image");

	public void goToReleaseCalendar() {
		getlinkText(releaseCalendar);
	}

	public String getSelectedTab() {
		return getElement(selectedTab).getText();
	}

	public void clickUpcomingReleases() {
		click(getlinkText(upcomingReleasesTab));
	}

	public void clickPublishedCalendar() {
		click(getlinkText(publishedReleasesTab));
	}

	public ArrayList <WebElement> getAllReleasesOnPage() {
		return (ArrayList <WebElement>) findElementsBy(releases);
	}

	public void selectRelease(String release) {
		for (WebElement rel : getAllReleasesOnPage()) {
			if (rel.getText().equalsIgnoreCase(release)) {
				rel.click();
				break;
			}
		}
	}

	public void goToPageLink(String page) {
		click(By.xpath(pageLinks.replace("replace", page)));
	}

	public void resultsPerPage(String value) {
		select(results_size, value);
	}

	public String getContactName() {
		return getElementText(contact_info);
	}

	public String getContactEmail() {
		return getAttributeText(contact_info, "data-ga-event-label");
	}

	public boolean doesAlertTitleExist() {
		return isElementPresent(alert_title);
	}

	public boolean doesImageExist() {
		return isElementPresent(ons_image);
	}
}
