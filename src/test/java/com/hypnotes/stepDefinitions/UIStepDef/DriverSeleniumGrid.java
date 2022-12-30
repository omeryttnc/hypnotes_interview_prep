package com.hypnotes.stepDefinitions.UIStepDef;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSeleniumGrid {

    WebDriver chromeDriver;
    WebDriver firefoxDriver;

    @Before
    public void setUp() throws MalformedURLException {

        // firefox
        DesiredCapabilities desiredCapabilitiesFirefox = new DesiredCapabilities();
        desiredCapabilitiesFirefox.setCapability(CapabilityType.BROWSER_NAME, "firefox");
        firefoxDriver = new RemoteWebDriver(new URL("http://192.168.0.3:4444"), desiredCapabilitiesFirefox);


        // chrome
        DesiredCapabilities desiredCapabilitiesChrome = new DesiredCapabilities();
        desiredCapabilitiesChrome.setCapability(CapabilityType.BROWSER_NAME, "chrome");
//        desiredCapabilitiesChrome.setPlatform(Platform.WINDOWS);
        chromeDriver = new RemoteWebDriver(new URL("http://192.168.0.3:4444"), desiredCapabilitiesChrome);

    }

    @Test
    public void test1() {
        firefoxDriver.get("https://test.hypnotes.net/");
        System.out.println("firefoxDriver.getCurrentUrl() = " + firefoxDriver.getCurrentUrl());

        chromeDriver.get("https://uk.linkedin.com/");
        System.out.println("chromeDriver.getCurrentUrl() = " + chromeDriver.getCurrentUrl());
    }

    @Test
    public void test2() {
        firefoxDriver.get("https://test.hypnotes.net/");
        System.out.println("firefoxDriver.getCurrentUrl() = " + firefoxDriver.getCurrentUrl());

        chromeDriver.get("https://uk.linkedin.com/");
        System.out.println("chromeDriver.getCurrentUrl() = " + chromeDriver.getCurrentUrl());
    }

    @Test
    public void test3() {
        firefoxDriver.get("https://test.hypnotes.net/");
        System.out.println("firefoxDriver.getCurrentUrl() = " + firefoxDriver.getCurrentUrl());

        chromeDriver.get("https://uk.linkedin.com/");
        System.out.println("chromeDriver.getCurrentUrl() = " + chromeDriver.getCurrentUrl());
    }

    @After
    public void thearUp() {
        firefoxDriver.quit();
        chromeDriver.quit();
    }
}
