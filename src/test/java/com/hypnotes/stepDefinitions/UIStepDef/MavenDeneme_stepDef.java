package com.hypnotes.stepDefinitions.UIStepDef;

import io.cucumber.java.en.Given;

public class MavenDeneme_stepDef {

    @Given("sadece smoke")
    public void sadeceSmoke() {
        System.out.println("sadece smoke");
    }

    @Given("sadece regression")
    public void sadeceRegression() {
        System.out.println("sadece regression");
    }

    @Given("disable smoke")
    public void disableSmoke() {
        System.out.println("disable smoke");
    }

    @Given("smoke calendar")
    public void smokeCalendar() {
        System.out.println("smoke calender");
    }

    @Given("sadece calendar")
    public void sadeceCalendar() {
        System.out.println("sadece calender");
    }

    /**
     *
     *  // smoke regression
     *
     * mvn clean test "-Dcucumber.filter.tags=@smoke"
     * mvn clean test "-Dcucumber.filter.tags=@omer"
     * mvn clean test "-Dcucumber.filter.tags=@smoke and @calender"
     * mvn clean test "-Dcucumber.filter.tags=@smoke and @testEnvironment"
     * mvn clean test "-Dcucumber.filter.tags=@smoke or @calender"
     *
     * mvn clean test "-Dcucumber.filter.tags=(@smoke and @testEnvironment) and not @disable"
     *
     *
     * // parallel
     *
     * mvn clean verify "-Dcucumber.filter.tags=@smoke or @calender" -f parallelPom.xml
     *
     */
}
