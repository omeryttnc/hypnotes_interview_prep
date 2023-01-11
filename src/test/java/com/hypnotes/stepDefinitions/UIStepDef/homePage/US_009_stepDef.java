package com.hypnotes.stepDefinitions.UIStepDef.homePage;

import com.hypnotes.pages.HomePage;
import com.hypnotes.pages.LoginPage;
import com.hypnotes.pages.US_009_page;
import com.hypnotes.utilities.BrowserUtilities;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.hypnotes.stepDefinitions.UIStepDef.Hooks.driver;

public class US_009_stepDef {
    US_009_page page = new US_009_page();

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Given("go to website {string}")
    public void go_to_website(String url) {

        driver.get(url);
        BrowserUtilities.wait(5);
    }

    @When("go to testimonials")
    public void go_to_testimonials() {

        BrowserUtilities.scrollToElement(page.button_next);
        BrowserUtilities.wait(5);
    }

    @When("click on first dot")
    public void click_on_first_dot() {
        page.dots.get(0).click();


    }

    @Then("assert previous button is not enabled")
    public void assert_previous_button_is_not_enabled() {

        Assert.assertFalse("previous button gosterildi", page.button_previous.isEnabled());
    }

    @Then("assert next button is enabled")
    public void assert_next_button_is_enabled() {
        Assert.assertTrue(page.button_next.isEnabled());
    }

    @Then("first testimonials is displayed")
    public void first_testimonials_is_displayed() {
        Assert.assertTrue(page.testimonials.get(0).isDisplayed());
    }

    @When("click on the last dot")
    public void click_on_the_last_dot() {

        BrowserUtilities.wait(2);

        page.dots.get(page.dots.size() - 1).click();
        BrowserUtilities.wait(2);
    }

    @Then("assert previous button is enabled")
    public void assert_previous_button_is_enabled() {
        Assert.assertTrue(page.button_previous.isEnabled());

    }

    @Then("assert next button is not enabled")
    public void assert_next_button_is_not_enabled() {
        Assert.assertFalse(page.button_next.isEnabled());

    }

    @Then("last testimonials is displayed")
    public void last_testimonials_is_displayed() {
        List<WebElement> testimonials = page.testimonials;
        Assert.assertTrue(testimonials.get(testimonials.size() - 1).isDisplayed());

    }

    @Test
    public void name() {

    }
}
