package com.hypnotes.stepDefinitions.UIStepDef;

import com.github.javafaker.Faker;
import com.hypnotes.enums.TherapistInfo;
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
    public static String userSessionID;
    public static boolean isCookiesDeleted = true;

    public static boolean isHeadless = false;
    public static String browserType = "chrome";

    public static boolean isFullScreen = true;
    public static int width;
    public static int height;

    @Before(value = "@headless", order = 0)
    public void setIsHeadless() {
        isHeadless = true;
    }

    @Before(value = "@firefox", order = 0)
    public void setIsChrome() {
        browserType = "firefox";
    }


    @Before(value = "@iPhone12", order = 0)
    public void setiPhone12() {
        isFullScreen = false;
        width = 390;
        height = 844;
    }

    @Before(order = 1)
    public void setup() {

        driver = Driver.getDriver();
        commonPage = new CommonPage() {
        };
        actions = new Actions(driver);
    }

    @Before(order = 2, value = "@basic")
    public void loginAsBasic() {
        commonPage.getLoginPage().loginTestEnvironment(TherapistInfo.BASIC);
    }

    @Before(order = 2, value = "@standard")
    public void loginAsStandard() {
        commonPage.getLoginPage().loginTestEnvironment(TherapistInfo.STANDARD);
    }
    @Before(order = 2, value = "@premium")
    public void loginAsPremium() {
        commonPage.getLoginPage().loginTestEnvironment(TherapistInfo.PREMIUM);
    }

    @Before(order = 2, value = "@THERAPIST_BASIC")
    public void loginAsTHERAPIST_BASIC() {
        commonPage.getLoginPage().loginProductEnvironment(TherapistInfo.THERAPIST_BASIC);
    }

    @Before(order = 2, value = "@enterprise")
    public void loginAsEnterprise() {
        commonPage.getLoginPage().loginTestEnvironment(TherapistInfo.ENTERPRISE);
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
