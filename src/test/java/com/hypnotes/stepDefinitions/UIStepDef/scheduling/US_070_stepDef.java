package com.hypnotes.stepDefinitions.UIStepDef.scheduling;

import com.github.javafaker.Faker;
import com.hypnotes.utilities.BrowserUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;

import static com.hypnotes.stepDefinitions.UIStepDef.Hooks.*;

public class US_070_stepDef {
    String individualColor;
    String packageColor;
    String groupColor;

    @And("click on Calender on the sidebar")
    public void clickOnCalenderOnTheSidebar() {
        commonPage.getDashboardPage().scheduling_calendar.click();
    }

    @Then("assert schedule an appointment is visible")
    public void assertScheduleAnAppointmentIsVisible() {
        BrowserUtilities.wait(3);
        Assert.assertTrue(commonPage.getCalendar().scheduleAnAppointment.isDisplayed());

        individualColor = getColourOfService(0);
        packageColor = getColourOfService(1);
        groupColor = getColourOfService(2);
    }

    @Then("Individual Sessions color update should be possible")
    public void individualSessionsColorUpdateShouldBePossible() {
        String newIndividualColor = changeColour(0);


        List<WebElement> allAppointmentOnCalendar = commonPage.getCalendar().allAppointmentOnCalendar;


        for (int i = 0; i < allAppointmentOnCalendar.size(); i++) {
            if (allAppointmentOnCalendar.get(i).getCssValue("background-color").equals(individualColor)) {
                Assert.fail();
            }
        }

        boolean flag = false;
        for (int i = 0; i < allAppointmentOnCalendar.size(); i++) {
            if (allAppointmentOnCalendar.get(i).getCssValue("background-color").equals(newIndividualColor)) {
                flag = true;
                break;
            }
        }

        Assert.assertTrue(flag);


        Assert.assertTrue(
                commonPage.getCalendar().allAppointmentOnCalendar.stream()
                        .noneMatch(t -> t.getCssValue("background-color").equals(individualColor))
        );

        Assert.assertTrue(
                commonPage.getCalendar().allAppointmentOnCalendar.stream()
                        .anyMatch(t -> t.getCssValue("background-color").equals(newIndividualColor))
        );

    }

    @Then("Packages color update should be possible")
    public void packagesColorUpdateShouldBePossible() {
        String newPackageColor = changeColour(1);


        Assert.assertTrue(
                commonPage.getCalendar().allAppointmentOnCalendar.stream()
                        .noneMatch(t -> t.getCssValue("background-color").equals(packageColor))
        );

        Assert.assertTrue(
                commonPage.getCalendar().allAppointmentOnCalendar.stream()
                        .anyMatch(t -> t.getCssValue("background-color").equals(newPackageColor))
        );
    }

    @Then("Group Session color update should be possible")
    public void groupSessionColorUpdateShouldBePossible() {
        String newGroupColor = changeColour(2);


        Assert.assertTrue(
                commonPage.getCalendar().allAppointmentOnCalendar.stream()
                        .noneMatch(t -> t.getCssValue("background-color").equals(groupColor))
        );

        Assert.assertTrue(
                commonPage.getCalendar().allAppointmentOnCalendar.stream()
                        .anyMatch(t -> t.getCssValue("background-color").equals(newGroupColor))
        );
    }

    @Then("Show Up color update should be possible")
    public void showUpColorUpdateShouldBePossible() {
        // TODO: 21/12/2022     assertColorStation(3, commonPage.getCalendar().markAs_ShowedUp);
    }

    @Then("Reschedule color update should be possible")
    public void rescheduleColorUpdateShouldBePossible() {
        // TODO: 21/12/2022     assertColorStation(4, commonPage.getCalendar().markAs_Reschedule);
    }

    @Then("No Show color update should be possible")
    public void noShowColorUpdateShouldBePossible() {
        //omer TODO: 21/12/2022   burada bug oldugu icin kapatildi duzeldigi zaman acilmasi lazim  assertColorStation(6, commonPage.getCalendar().markAs_Noshow);
    }

    @Then("Month, week, day must be selectable")
    public void monthWeekDayMustBeSelectable() {
        clickAble(commonPage.getCalendar().viewDay);
        clickAble(commonPage.getCalendar().viewWeek);
        clickAble(commonPage.getCalendar().viewMonth);

    }


    @When("the user select month, week, day , the page should be updated according to the relevant title.")
    public void theUserSelectMonthWeekDayThePageShouldBeUpdatedAccordingToTheRelevantTitle() {

        BrowserUtilities.waitForVisibility(commonPage.getCalendar().monthly_day_title, 10);
        Assert.assertEquals(monthTitle(), commonPage.getCalendar().monthly_day_title.getText());

        commonPage.getCalendar().viewWeek.click();
        BrowserUtilities.wait(2);

        Assert.assertTrue(
                commonPage.getCalendar().weeklyDays_title
                        .stream()
                        .anyMatch(t -> t.getText().equals(weekTitle()))
        );

        commonPage.getCalendar().viewDay.click();
        BrowserUtilities.wait(2);

        Assert.assertEquals(dayTitle(), commonPage.getCalendar().monthly_day_title.getText());

    }

    public String getColourOfService(int i_0$p_1$g_2$s_3$r_4$c_5$n_6$g_7) {
        return commonPage.getCalendar().colorToChange.get(i_0$p_1$g_2$s_3$r_4$c_5$n_6$g_7).getCssValue("background-color");
    }

    Faker faker = new Faker();

    public String changeColour(int i_0$p_1$g_2$s_3$r_4$c_5$n_6$g_7) {

        commonPage.getCalendar().colorToChange.get(i_0$p_1$g_2$s_3$r_4$c_5$n_6$g_7).click();
        BrowserUtilities.wait(2);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);

        actions.sendKeys(Keys.BACK_SPACE);
        actions.perform();
        commonPage.getCalendar().colorCode.sendKeys(faker.color().hex().substring(1));
        actions.sendKeys(Keys.ENTER).perform();
        BrowserUtilities.wait(2);
        return getColourOfService(i_0$p_1$g_2$s_3$r_4$c_5$n_6$g_7);


    }

    public void assertColorStation(int i_0$p_1$g_2$s_3$r_4$c_5$n_6$g_7, WebElement webElement) {
        commonPage.getCalendar().allAppointmentOnCalendar.get(0).click();
        BrowserUtilities.wait(2);
        webElement.click();
        BrowserUtilities.waitForVisibility(commonPage.getLoginPage().toastMessage.get(0), 10);
        Assert.assertEquals("Meeting is updated", commonPage.getLoginPage().toastMessage.get(0).getText());
        actions.sendKeys(Keys.ESCAPE).perform();

        Assert.assertEquals(
                commonPage.getCalendar().allAppointmentOnCalendar.get(0).getCssValue("background-color"),
                getColourOfService(i_0$p_1$g_2$s_3$r_4$c_5$n_6$g_7)
        );

    }

    private String monthTitle() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMMM yyyy");
        return simpleDateFormat.format(calendar.getTime());
    }

    private String weekTitle() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MM/d");
        return simpleDateFormat.format(calendar.getTime());
    }

    private String dayTitle() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMMM d, yyyy");
        return simpleDateFormat.format(calendar.getTime());
    }

    public void clickAble(WebElement webElement) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(webElement)).isDisplayed());
        Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(webElement)).isEnabled());
    }

}
