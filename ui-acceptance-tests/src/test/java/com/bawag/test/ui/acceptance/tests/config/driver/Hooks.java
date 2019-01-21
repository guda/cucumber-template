package com.bawag.test.ui.acceptance.tests.config.driver;

import com.bawag.test.ui.acceptance.tests.config.driver.WebDriverFactory;
import com.bawag.test.ui.acceptance.tests.util.ScreenshotEmbedder;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp() {
        WebDriverFactory.createWebDriver();
        WebDriverFactory.getWebDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

    }

    @After
    public void cleanUp(Scenario scenario) {
        ScreenshotEmbedder.embed(scenario);
        WebDriverFactory.closeWebDriver();
    }
}
