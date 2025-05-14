package com.catfact.api.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        tags = "@api and @breends_api",
        glue = {"com/catfact"},
        plugin = {
                "pretty", "json:target/cucumber/cucumber-reports.json",
                "pretty", "html:target/cucumber/cucumber-reports.html",
                "junit:target/xml-junit/junit.xml",
        },
        features = {"src/main/resources/features"})
public class TestRunnerBreends {
}
