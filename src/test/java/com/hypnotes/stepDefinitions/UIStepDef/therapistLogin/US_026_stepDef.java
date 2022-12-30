package com.hypnotes.stepDefinitions.UIStepDef.therapistLogin;

import com.hypnotes.utilities.BrowserUtilities;
import com.hypnotes.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import static com.hypnotes.stepDefinitions.UIStepDef.Hooks.*;

public class US_026_stepDef {

    String token;
    String password;

    @And("click on the Login button")
    public void clickOnTheLoginButton() {
        commonPage.getLoginPage().loginButton_navbar.click();
        BrowserUtilities.wait(3);
    }

    @Then("assert reset button is displayed")
    public void assertResetButtonIsDisplayed() {
        Assert.assertTrue(commonPage.getLoginPage().resetButton.isDisplayed());
    }

    @When("click on reset button")
    public void clickOnResetButton() {
        BrowserUtilities.clickWithJS(commonPage.getLoginPage().resetButton);
    }

    @Then("assert forgot password is displayed on the resetpage")
    public void assertForgotPasswordIsDisplayedOnTheResetpage() {
        BrowserUtilities.waitForVisibility(commonPage.getResetPassword().forgotPassword_text, 10);
        Assert.assertTrue(commonPage.getResetPassword().forgotPassword_text.isDisplayed());
    }

    @And("assert user goes to {string}")
    public void assertUserGoesTo(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @When("user enters email to forgot password")
    public void userEntersEmailToForgotPassword() {
        commonPage.getResetPassword().emailBox.sendKeys(ConfigurationReader.getProperty("clientEmail"));
    }

    @And("click on send email button on the forgot password page")
    public void clickOnSendEmailButtonOnTheForgotPasswordPage() {
        commonPage.getResetPassword().emailSubmitButton.click();

    }

    @Then("assert toast message as follow {string}")
    public void assertToastMessageAsFollow(String toastMessage) {
        BrowserUtilities.waitForVisibility(commonPage.getLoginPage().toastMessage.get(0), 10);
        Assert.assertEquals(toastMessage, commonPage.getLoginPage().toastMessage.get(0).getText());

    }

    @When("user goes to mail address")
    public void userGoesToMailAddress() {
        driver.get("https://mailsac.com/inbox/" + ConfigurationReader.getProperty("clientEmail"));
        driver.navigate().refresh();
        BrowserUtilities.wait(2);
    }

    @Then("assert last email title contains {string}")
    public void assertLastEmailTitleContains(String resetTitle) {
        Assert.assertTrue(commonPage.getMailSacPage().allEmailsTitle.get(0).getText().contains(resetTitle));

    }

    @When("user click on the last email")
    public void userClickOnTheLastEmail() {
        commonPage.getMailSacPage().allEmailsTitle.get(0).click();
        BrowserUtilities.wait(3);
    }

    @Then("assert inner mail title is {string}")
    public void assertInnerMailTitleIs(String resetTitle) {
        Assert.assertEquals(resetTitle, commonPage.getMailSacPage().emailResetRequest.getText());
    }

    @When("copy the link of reset password")
    public void copyTheLinkOfResetPassword() {
        token = commonPage.getMailSacPage().token.getText();

        BrowserUtilities.wait(10);
    }

    @And("go to the link of reset password")
    public void goToTheLinkOfResetPassword() {
        driver.get(token);
        BrowserUtilities.wait(3);
    }

    @Then("assert new password is displayed")
    public void assertNewPasswordIsDisplayed() {
        Assert.assertEquals("New Password", commonPage.getNewPassword().newPassword_title.getText());

    }

    @When("user enter email address")
    public void userEnterEmailAddress() {
        commonPage.getNewPassword().email.sendKeys(ConfigurationReader.getProperty("clientEmail"));
    }

    @And("user enter email new password")
    public void userEnterEmailNewPassword() {
        password = faker.internet().password(8, 10, true, true, true);

        commonPage.getNewPassword().password.sendKeys(password);
    }

    @And("click on the send email to change password")
    public void clickOnTheSendEmailToChangePassword() {
        commonPage.getNewPassword().submit.click();
    }

    @Then("assert {string} is displayed")
    public void assertIsDisplayed(String toast) {
        BrowserUtilities.waitForVisibility(commonPage.getLoginPage().toastMessage.get(0), 10);
        Assert.assertEquals(toast, commonPage.getLoginPage().toastMessage.get(0).getText());
    }

    @When("user click on the go to login page to login")
    public void userClickOnTheGoToLoginPageToLogin() {
        commonPage.getNewPassword().goToLoginPage.click();
        BrowserUtilities.wait(3);
    }

    @When("user enter email address on the login page")
    public void userEnterEmailAddressOnTheLoginPage() {
        commonPage.getLoginPage().emailBox.sendKeys(ConfigurationReader.getProperty("clientEmail"));
    }

    @And("user enter new password on the login page")
    public void userEnterNewPasswordOnTheLoginPage() {
        commonPage.getLoginPage().passwordBox.sendKeys(password);
        commonPage.getLoginPage().loginButton_submit.click();
    }

    @When("user login mailsac")
    public void userLoginMailsac() {
        commonPage.getMailSacPage().loginMail();
    }

    @And("user click on the login button on the mail")
    public void userClickOnTheLoginButtonOnTheMail() {
        commonPage.getMailSacPage().loginMail_inside.click();
    }

    @And("user goes second page")
    public void userGoesSecondPage() {
        BrowserUtilities.switchToWindowWithIndex(1);
        BrowserUtilities.wait(2);
    }

    @And("click here button")
    public void clickHereButton() {
        commonPage.getMailSacPage().clickHere.click();
        BrowserUtilities.wait(3);
    }

}
