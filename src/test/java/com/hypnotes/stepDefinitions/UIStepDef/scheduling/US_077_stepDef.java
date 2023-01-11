package com.hypnotes.stepDefinitions.UIStepDef.scheduling;

import com.hypnotes.utilities.BrowserUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.hypnotes.stepDefinitions.UIStepDef.Hooks.commonPage;

public class US_077_stepDef {

    @Given("delete all meetings")
    public void deleteAllMeetings() {
    }

    @And("set meeting for client")
    public void setMeetingForClient() {
    }

    @And("click on the first meeting")
    public void clickOnTheFirstMeeting() {
    }

    @Then("assert if date and time is matching")
    public void assertIfDateAndTimeIsMatching() {
    }

    @And("assert if client info is matching")
    public void assertIfClientInfoIsMatching() {
    }

    @When("click on the reschedule appointment")
    public void clickOnTheRescheduleAppointment() {
    }

    @And("click on collect Payment")
    public void clickOnCollectPayment() {
    }

    @And("select suitable time")
    public void selectSuitableTime() {
    }

    @And("click yes to confirm")
    public void clickYesToConfirm() {
        BrowserUtilities.clickWithJS(commonPage.getClientsPage().yesToContinue);
    }

    @When("click next to continue")
    public void clickNextToContinue() {
    }

    @Then("assert reschedule without asking for users permission button is working")
    public void assertRescheduleWithoutAskingForUsersPermissionButtonIsWorking() {
    }

    @When("click on the submit")
    public void clickOnTheSubmit() {
    }
}
