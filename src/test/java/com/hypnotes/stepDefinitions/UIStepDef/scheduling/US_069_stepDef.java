package com.hypnotes.stepDefinitions.UIStepDef.scheduling;

import com.hypnotes.utilities.BrowserUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.hypnotes.stepDefinitions.UIStepDef.Hooks.actions;
import static com.hypnotes.stepDefinitions.UIStepDef.Hooks.commonPage;

public class US_069_stepDef {


    @When("click on scheduling on the sidebar")
    public void clickOnSchedulingOnTheSidebar() {
        commonPage.getDashboardPage().scheduling.click();
        BrowserUtilities.wait(3);
    }

    @And("click on the setting on the sidebar")
    public void clickOnTheSettingOnTheSidebar() {
        commonPage.getDashboardPage().scheduling_setting.click();
    }

    @Then("assert the Online Info page should be displayed")
    public void assertTheOnlineInfoPageShouldBeDisplayed() {
        BrowserUtilities.waitForVisibility(commonPage.getScheduleSettingsPage().onlineInfoTitle, 10);

        Assert.assertTrue(commonPage.getScheduleSettingsPage().onlineInfoTitle.isDisplayed());

    }

    @And("assert number of client limit is clickable")
    public void assertNumberOfClientLimitIsClickable() {
        Assert.assertFalse(BrowserUtilities.isExist(commonPage.getScheduleSettingsPage().numberForTheClientLimit));
        commonPage.getScheduleSettingsPage().numberOfClientLimit.get(0).click();
        BrowserUtilities.wait(2);

        Assert.assertTrue(BrowserUtilities.isExist(commonPage.getScheduleSettingsPage().numberForTheClientLimit));

    }

    @And("assert off day limit is clickable")
    public void assertOffDayLimitIsClickable() {

        Assert.assertTrue(commonPage.getScheduleSettingsPage().startDay_0_endDay_1_time.get(0).isEnabled());

        commonPage.getScheduleSettingsPage().offDay.get(0).click();
        BrowserUtilities.wait(2);

        Assert.assertFalse(commonPage.getScheduleSettingsPage().startDay_0_endDay_1_time.get(0).isEnabled());

        commonPage.getScheduleSettingsPage().offDay.get(0).click();
        BrowserUtilities.wait(2);

        Assert.assertTrue(commonPage.getScheduleSettingsPage().startDay_0_endDay_1_time.get(0).isEnabled());


    }

    @And("assert flexible time meeting is clickable")
    public void assertFlexibleTimeMeetingIsClickable() {
        Assert.assertEquals(
                "false",
                commonPage.getScheduleSettingsPage().flexibleTimeMeeting.getAttribute("aria-checked")
        );

        commonPage.getScheduleSettingsPage().flexibleTimeMeeting.click();

        BrowserUtilities.wait(2);
        Assert.assertEquals(
                "true",
                commonPage.getScheduleSettingsPage().flexibleTimeMeeting.getAttribute("aria-checked")
        );

        commonPage.getScheduleSettingsPage().flexibleTimeMeeting.click();

    }

    @And("assert show canceled meeting is clickable")
    public void assertShowCanceledMeetingIsClickable() {
        Assert.assertEquals(
                "false",
                commonPage.getScheduleSettingsPage().showCanceledMeeting.getAttribute("aria-checked")
        );

        commonPage.getScheduleSettingsPage().showCanceledMeeting.click();

        BrowserUtilities.wait(2);
        Assert.assertEquals(
                "true",
                commonPage.getScheduleSettingsPage().showCanceledMeeting.getAttribute("aria-checked")
        );

        commonPage.getScheduleSettingsPage().showCanceledMeeting.click();


    }

    @When("Add Block Time is added, it should be listed under Blocked Times")
    public void addBlockTimeIsAddedItShouldBeListedUnderBlockedTimes() {
        commonPage.getScheduleSettingsPage().addBlockTime.get(0).click();
        BrowserUtilities.wait(2);
        List<WebElement> addBlockTime_start__2_end__1 = commonPage.getScheduleSettingsPage().addBlockTime_start__2_end__1;

        addBlockTime_start__2_end__1.get(addBlockTime_start__2_end__1.size() - 2).click();
        BrowserUtilities.wait(2);
        actions.sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.ARROW_DOWN);

        actions.sendKeys(Keys.ENTER);

        actions.sendKeys(Keys.TAB);


        actions.sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.ARROW_DOWN);

        actions.sendKeys(Keys.ENTER);

        actions.sendKeys(Keys.TAB);

        actions.sendKeys(Keys.ENTER);

        actions.perform();
        assertToastMessage("Block Time is added");

    }

    @Then("assert Update and Delete options should appear under the Blocked Times heading")
    public void assertUpdateAndDeleteOptionsShouldAppearUnderTheBlockedTimesHeading() {
        Assert.assertTrue(commonPage.getScheduleSettingsPage().updateBlockTime_genel.isDisplayed());
        Assert.assertTrue(commonPage.getScheduleSettingsPage().deleteBlockTime.get(0).isDisplayed());
    }

    @When("you click on the update option, the time button should appear for the new update")
    public void youClickOnTheUpdateOptionTheTimeButtonShouldAppearForTheNewUpdate() {
        commonPage.getScheduleSettingsPage().updateBlockTime_genel.click();
        BrowserUtilities.wait(2);
        List<WebElement> addBlockTime_start__2_end__1 = commonPage.getScheduleSettingsPage().addBlockTime_start__2_end__1;

        addBlockTime_start__2_end__1.get(addBlockTime_start__2_end__1.size() - 2).click();
        Assert.assertTrue(commonPage.getScheduleSettingsPage().updateBlockTime_popup.isDisplayed());

        BrowserUtilities.wait(2);
        actions.sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.ARROW_DOWN);

        actions.sendKeys(Keys.ENTER);

        actions.sendKeys(Keys.TAB);


        actions.sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.ARROW_DOWN);

        actions.sendKeys(Keys.ENTER);

        actions.sendKeys(Keys.TAB);

        actions.sendKeys(Keys.ENTER);

        actions.perform();
        assertToastMessage("Block Time is updated");

    }

    @When("Clicking Delete, the message Blocked Time Deleted should appear")
    public void clickingDeleteTheMessageBlockedTimeDeletedShouldAppear() {
        BrowserUtilities.waitForClickability(commonPage.getScheduleSettingsPage().deleteBlockTime.get(0), 10);
        commonPage.getScheduleSettingsPage().deleteBlockTime.get(0).click();
        assertToastMessage("Block Time is deleted");


    }

    @And("assert save is clickable")
    public void assertSaveIsClickable() {
        actions.sendKeys(Keys.ESCAPE).perform();
        BrowserUtilities.wait(2);
        BrowserUtilities.clickWithJS(commonPage.getScheduleSettingsPage().save);
        assertToastMessage("Settings saved.");
    }

    @When("the user click on Customize your url should visible the Upgrade Now page")
    public void theUserClickOnCustomizeYourUrlShouldVisibleTheUpgradeNowPage() {
        commonPage.getScheduleSettingsPage().customizeYourUrl.click();
        BrowserUtilities.wait(2);
    }

    @When("Show All Subscription Plans and Cancel button on Upgrade Now page should be functional")
    public void showAllSubscriptionPlansAndCancelButtonOnUpgradeNowPageShouldBeFunctional() {
        commonPage.getScheduleSettingsPage().showAllSubscriptionPlans.click();
        BrowserUtilities.wait(2);
        BrowserUtilities.switchToWindowWithIndex(1);
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(2);
    }

    @When("the user click to Show All Subscription Plans, the Subscription page should appear")
    public void theUserClickToShowAllSubscriptionPlansTheSubscriptionPageShouldAppear() {
        Assert.assertTrue(commonPage.getSettings().activeSubscriptionYearType.isDisplayed());
    }

    @When("the user click to  Cancel button should return to the Upgrade Now page")
    public void theUserClickToCancelButtonShouldReturnToTheUpgradeNowPage() {
        commonPage.getScheduleSettingsPage().showAllSubscriptionPlans_cancel.click();
        BrowserUtilities.wait(3);
        Assert.assertFalse(BrowserUtilities.isExist(commonPage.getSettings().activeSubscriptionYearType));
        Assert.assertTrue(BrowserUtilities.isExist(commonPage.getScheduleSettingsPage().flexibleTimeMeeting));
    }

    public void assertToastMessage(String message) {
        boolean flag = false;
        for (int i = 0; i < commonPage.getLoginPage().toastMessage.size(); i++) {
            if (commonPage.getLoginPage().toastMessage.get(i).getText().equals(message)) {
                flag = true;
                break;
            }
        }

        Assert.assertTrue(flag);


        BrowserUtilities.waitForVisibility(commonPage.getLoginPage().toastMessage.get(0), 10);
        int count = 5;
        while (commonPage.getLoginPage().toastMessage.stream()
                .anyMatch(t -> t.getText().equals(message))) {
            Assert.assertTrue(
                    commonPage.getLoginPage().toastMessage.stream().anyMatch(t -> t.getText().equals(message))
            );
            BrowserUtilities.wait(1);
            count--;
            if (count == 0) {
                break;
            }
        }
        // Assert.assertEquals(message, commonPage.getLoginPage().toastMessage.get(0).getText());
    }
}
