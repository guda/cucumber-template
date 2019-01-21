package com.bawag.test.ui.acceptance.tests.util;

import com.bawag.test.ui.acceptance.tests.config.driver.WebDriverFactory;
import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotEmbedder {
    private static String SCREENSHOT = System.getProperty("screenshot");

    public ScreenshotEmbedder() {
    }

    public static void embed(Scenario scenario) {
        if (SCREENSHOT != null) {
            if (SCREENSHOT.equals("A")) {
                scenario.embed(getScreenshot(), "image/png");
            }

            if (SCREENSHOT.equals("P") && !scenario.isFailed()) {
                scenario.embed(getScreenshot(), "image/png");
            }

            if (SCREENSHOT.equals("F") && scenario.isFailed()) {
                scenario.embed(getScreenshot(), "image/png");
            }
        }

    }

    private static byte[] getScreenshot() {
        return (byte[]) ((TakesScreenshot) WebDriverFactory.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
