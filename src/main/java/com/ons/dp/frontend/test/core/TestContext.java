package com.ons.dp.frontend.test.core;

import com.ons.dp.frontend.test.selenium.Browser;
import com.ons.dp.frontend.test.util.CacheService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class TestContext {
    public static Configuration configuration = new Configuration();

    public static WebDriver getDriver() {
        return Browser.initDriver(configuration);
    }

    public static Configuration getConfiguration() {
        return configuration;
    }

    public static CacheService getCacheService() {
        return CacheService.getInstance();
    }

    public static WebDriverWait getWebDriverWait() {
        return Browser.getWebDriverWait();
    }
    // Add Reports
    // Keeping everything for the basepage in one class
}
