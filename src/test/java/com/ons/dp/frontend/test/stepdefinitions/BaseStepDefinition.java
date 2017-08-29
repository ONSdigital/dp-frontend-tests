package com.ons.dp.frontend.test.stepdefinitions;

import com.ons.dp.frontend.test.page.BasePage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

public class BaseStepDefinition {

    BasePage basePage = new BasePage();

    @After
    public void embedScreenshots(Scenario scenario) throws InterruptedException {
        if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + basePage.getDriver().getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot) basePage.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }
    }
}
