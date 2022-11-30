package com.hypnotes.stepDefinitions.UIStepDef.homePage;

import com.hypnotes.pages.CommonPage;
import com.hypnotes.pages.US_007_page;
import com.hypnotes.utilities.BrowserUtilities;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import javax.sql.rowset.BaseRowSet;

import static com.hypnotes.stepDefinitions.UIStepDef.Hooks.*;

public class US_007_stepDef extends CommonPage {

    @When("click on the youtube video")
    public void click_on_the_youtube_video() {

        driver.switchTo().frame(getHomePage().youtube_frame);
        BrowserUtilities.wait(3);


        BrowserUtilities.scrollToElement(getHomePage().youtube_play);
        BrowserUtilities.wait(5);
        BrowserUtilities.staleElementClick(getHomePage().youtube_play, 10);
        actions.sendKeys(Keys.SPACE).perform();
    }

    @Then("assert video is playing")
    public void assert_video_is_playing() {
        BrowserUtilities.wait(3);
        String startTime = getHomePage().youtube_attribute.getAttribute("currentTime");

        BrowserUtilities.wait(5);
        String endTime = getHomePage().youtube_attribute.getAttribute("currentTime");

        System.out.println(startTime + " " + endTime);
        Assert.assertNotEquals("youtube video su oynamadi", startTime, endTime);

    }

}
