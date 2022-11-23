package com.hypnotes.stepDefinitions.UIStepDef.homePage;

import com.hypnotes.pages.CommonPage;
import com.hypnotes.utilities.BrowserUtilities;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.hypnotes.stepDefinitions.UIStepDef.Hooks.*;

public class US_011_stepDef extends CommonPage {
    @Given("go to bottom page")
    public void go_to_bottom_page() {
        actions.sendKeys(Keys.END).perform();
        BrowserUtilities.wait(5);
    }

    @Then("assert titles are displayed")
    public void assert_titles_are_displayed(DataTable dataTable) {
        List<String> column = dataTable.column(0);

        for (int i = 0; i < column.size(); i++) {
            Assert.assertEquals(column.get(i), commonPage.getHomePage().footerLinks.get(i).getText());
        }


    }


    @When("the user clicks {string} the link and verifies that the url is the expected {string}")
    public void theUserClicksTheLinkAndVerifiesThatTheUrlIsTheExpected(String index, String url) {
        int i = Integer.parseInt(index);

        getHomePage().footerLinks.get(i).click();
        BrowserUtilities.wait(2);
        Assert.assertEquals(url, driver.getCurrentUrl());

    }
}
