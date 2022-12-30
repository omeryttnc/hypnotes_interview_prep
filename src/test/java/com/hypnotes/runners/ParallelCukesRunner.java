package com.hypnotes.runners;

import io.cucumber.core.cli.Main;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/reports/html/cucumber-Hypnotes_reports.html",
                "json:target/reports/json/json-reports/cucumber.json",
                "junit:target/reports/xml/xml-report/cucumber.xml",
                "rerun:target/reports/rerun.txt"
        },
        features = "src/test/resources/Features",
        glue = "com.hypnotes.stepDefinitions"
)
public class ParallelCukesRunner {
    public static void main(String[] args) {
        Main.run(new String[]{
                "--threads", "2",
                "-t", "@parallel",
                "-g", "com.hypnotes.stepDefinitions",
                "src/test/resources/Features"
        }, Thread.currentThread().getContextClassLoader());
    }
}
