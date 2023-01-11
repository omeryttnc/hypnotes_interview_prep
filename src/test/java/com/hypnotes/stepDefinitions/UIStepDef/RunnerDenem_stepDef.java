package com.hypnotes.stepDefinitions.UIStepDef;

import com.hypnotes.utilities.Driver;
import io.cucumber.java.en.Given;

import org.junit.Assert;

public class RunnerDenem_stepDef {
    @Given("fail olacak test")
    public void failOlacakTest() {
        Driver.getDriver().get("https://www.toeflresources.com/sample-toefl-essays/sample-essays-i/");
        //Assert.fail();
    }

    @Given("gececek  test")
    public void gececekTest() {
        Driver.getDriver().get("https://www.toeflresources.com/sample-toefl-essays/sample-essays-i/");
    }
}
