package com.niyi.rest.cucumber;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty","json:target/cucumber-report/cucumber.json",
        "html:target/cucumber-report/cucumber-html-reports"}, features = "classpath:Feature")
public class CucumberIntegrationTest {
}