package com.hypnotes.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/reports/html/failed_cucumber-Hypnotes_reports.html",
                "json:target/reports/json/failed_json-reports/cucumber.json",
                "junit:target/reports/xml/failed_xml-report/cucumber.xml"
        },
        features = "@target/reports/rerun.txt",
        glue = "com.hypnotes.stepDefinitions"

)

public class FailedRunner {
}
