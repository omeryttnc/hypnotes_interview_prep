package com.hypnotes.stepDefinitions.UIStepDef;

import com.github.javafaker.Faker;
import com.hypnotes.pages.CommonPage;
import com.hypnotes.utilities.BrowserUtilities;
import com.hypnotes.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;


public class Hooks {
    public static WebDriver driver;
    public static CommonPage commonPage;
    public static Faker faker = new Faker();

    public static Actions actions;
    public static boolean isTestEnvironment;
    public static boolean isCookiesDeleted = true;

    @Before
    public void setup() {

        driver = Driver.getDriver();
        commonPage = new CommonPage() {
        };
        actions = new Actions(driver);
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshots");
        }
        if (isCookiesDeleted) {
            driver.manage().deleteAllCookies();
        }
        List<String> windowHandles = new ArrayList<>(Driver.getDriver().getWindowHandles());
        if (windowHandles.size() > 1) {
            driver.close();
            BrowserUtilities.switchToWindowWithIndex(0);
        }
    }

    @Before("@db")
    public void setupDatabase() {
        //   DataTableUtilities.createConnection();
    }

    @After("@db")
    public void closeDatabase() {
        // DataTableUtilities.closeConnection();
    }

}
