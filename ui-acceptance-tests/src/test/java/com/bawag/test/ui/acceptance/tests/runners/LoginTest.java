package com.bawag.test.ui.acceptance.tests.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (plugin = {
                "pretty",
                "json:target/login.json",
                "html:target/htmlreports/login"},
                monochrome = true,
                features = "src/test/resources/features/login.feature",
                glue = {"com.bawag.test.ui.acceptance.tests.step.definitions", "com.bawag.test.ui.acceptance.tests.config.driver"})
public class LoginTest {
}