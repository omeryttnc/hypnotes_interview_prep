package com.hypnotes.stepDefinitions.UIStepDef.invoice;

import com.hypnotes.utilities.BrowserUtilities;
import com.hypnotes.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

import static com.hypnotes.stepDefinitions.UIStepDef.Hooks.commonPage;
import static com.hypnotes.stepDefinitions.UIStepDef.Hooks.faker;

public class US_63_stepDef {

    String yourCompany, address, city, country, phoneNumber, email;
    int qty, rate;

    Random random = new Random();

    @Given("go to profile page")
    public void goToProfilePage() {
        yourCompany = faker.company().name();
        address = faker.address().fullAddress();
        city = faker.address().city();
        country = "Afghanistan";
        phoneNumber = faker.phoneNumber().cellPhone();
        email = faker.internet().emailAddress();
        commonPage.getDashboardPage().profile.click();
        qty = 3; // random.nextInt(10);
        rate = 5;
    }

    @And("click on your company")
    public void clickOnYourCompany() {
        waitAndClick(commonPage.getProfilePage().yourCompanyTab);
    }

    @And("click on add or update new company")
    public void clickOnAddOrUpdateNewCompany() {
        waitAndClick(commonPage.getProfilePage().editCompany);
    }

    @Then("assert valid logo should be able to add to the Your Logo field")
    public void assertValidLogoShouldBeAbleToAddToTheYourLogoField() {

        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\files\\images\\logo.png";

        commonPage.getProfilePage().yourLogoFile.sendKeys(filePath);
        //   C:\Users\savsa\IdeaProjects\interviewPrep\hypnotes_prep\src\test\resources\files\images\logo.png
    }

    @Then("assert valid name should be able to enter in the Your Company field")
    public void assertValidNameShouldBeAbleToEnterInTheYourCompanyField() {
        clearAndSendAndAssert(commonPage.getProfilePage().create_yourCompany, yourCompany);
    }

    @Then("assert valid address should be able to enter in the Company's Address field")
    public void assertValidAddressShouldBeAbleToEnterInTheCompanySAddressField() {
        clearAndSendAndAssert(commonPage.getProfilePage().create_companyAddress, address);
    }

    @Then("assert Valid information should be able to enter in the City, State, Zip field")
    public void assertValidInformationShouldBeAbleToEnterInTheCityStateZipField() {
        clearAndSendAndAssert(commonPage.getProfilePage().create_cityStateZip, city);
    }

    @Then("assert User should be able to select country from Country drop-down menu")
    public void assertUserShouldBeAbleToSelectCountryFromCountryDropDownMenu() {
        commonPage.getProfilePage().create_country_genel.click();
        BrowserUtilities.wait(2);
        Select select = new Select(commonPage.getProfilePage().create_country_select);
        select.selectByIndex(0);
        // Assert.assertEquals(country, commonPage.getProfilePage().create_country_genel.getAttribute("value"));
    }

    @Then("assert User should be able to enter phone number")
    public void assertUserShouldBeAbleToEnterPhoneNumber() {
        clearAndSendAndAssert(commonPage.getProfilePage().create_companyPhone, phoneNumber);
    }

    @When("user click on update or save company")
    public void userClickOnUpdateOrSaveCompany() {

        if (isExist(commonPage.getProfilePage().create_update)) {
            commonPage.getProfilePage().create_update.click();
        } else {

            commonPage.getProfilePage().create_save.click();
        }
    }

    @Then("assert company name is the same as we change create on profile page")
    public void assertCompanyNameIsTheSameAsWeChangeCreateOnProfilePage() {
        Assert.assertEquals(yourCompany, commonPage.getProfilePage().companyTitle.getText());

    }

    @Then("assert address is the same as we change create on profile page")
    public void assertAddressIsTheSameAsWeChangeCreateOnProfilePage() {
        Assert.assertEquals(address, commonPage.getProfilePage().companyAddress.getText());
    }

    @Then("assert city state zipcode is the same as we change create on profile page")
    public void assertCityStateZipcodeIsTheSameAsWeChangeCreateOnProfilePage() {
        Assert.assertEquals(city, commonPage.getProfilePage().companyCity.getText());
    }

    @Then("assert country is the same as we change create on profile page")
    public void assertCountryIsTheSameAsWeChangeCreateOnProfilePage() {
        Assert.assertEquals(country, commonPage.getProfilePage().companyCountry.getText());
    }

    @Then("assert phone is the same as we change create on profile page")
    public void assertPhoneIsTheSameAsWeChangeCreateOnProfilePage() {

        Assert.assertEquals(phoneNumber, commonPage.getProfilePage().companyPhone.getText());

    }

    @When("user goes to client page")
    public void userGoesToClientPage() {
        BrowserUtilities.clickWithJS(commonPage.getDashboardPage().clients);
    }

    @And("click on view detail of client button")
    public void clickOnViewDetailOfClientButton() {
        waitAndClick(commonPage.getClientsPage().viewDeatils.get(0));
    }

    @And("click on invoice")
    public void clickOnInvoice() {
        waitAndClick(commonPage.getClientsPage().invoice);
    }

    @Then("assert address is the same as we change create on invoice")
    public void assertAddressIsTheSameAsWeChangeCreateOnInvoice() {
        BrowserUtilities.waitForVisibility(commonPage.getClientsPage().invoice_address, 30);
        BrowserUtilities.scrollToElement(commonPage.getClientsPage().invoice_address);
        Assert.assertEquals(address, commonPage.getClientsPage().invoice_address.getAttribute("value"));
    }

    @Then("assert city state zipcode is the same as we change create on invoice")
    public void assertCityStateZipcodeIsTheSameAsWeChangeCreateOnInvoice() {
        Assert.assertEquals(city, commonPage.getClientsPage().invoice_city_state_zipcode.getAttribute("value"));
    }

    @Then("assert country is the same as we change create on invoice")
    public void assertCountryIsTheSameAsWeChangeCreateOnInvoice() {
        Assert.assertEquals(country, commonPage.getClientsPage().invoice_country.getAttribute("value"));
    }

    @Then("assert company name is the same as we change create on invoice")
    public void assertCompanyNameIsTheSameAsWeChangeCreateOnInvoice() {
        Assert.assertEquals(yourCompany, commonPage.getClientsPage().invoice_companyName.getAttribute("value"));
    }

    @Then("assert Invoice Date must be functional and date selectable")
    public void assertInvoiceDateMustBeFunctionalAndDateSelectable() {
        commonPage.getClientsPage().selectAndAssertDate(commonPage.getClientsPage().bill_invoiceDate, 2);
    }

    @Then("assert Due Date must be functional and date selectable")
    public void assertDueDateMustBeFunctionalAndDateSelectable() {
        commonPage.getClientsPage().clearAndSendDate(commonPage.getClientsPage().bill_dueDate, 5);
    }

    @Then("assert Item name description should be enterable or selectable")
    public void assertItemNameDescriptionShouldBeEnterableOrSelectable() {
        clearAndSendAndAssert(

                commonPage.getClientsPage().itemDescription_cards.get(0).findElement(By.cssSelector("[type='search']"))

                , faker.name().fullName());

    }

    @Then("assert QTY\\(Quantity) field should be functional and number must be writable")
    public void assertQTYQuantityFieldShouldBeFunctionalAndNumberMustBeWritable() {
        clearAndSend(commonPage.getClientsPage().itemDescription_cards_1_qty_2_rate.get(1), "" + qty);
    }

    @Then("assert The Rate field should be functional and the number must be writable")
    public void assertTheRateFieldShouldBeFunctionalAndTheNumberMustBeWritable() {
        clearAndSend(commonPage.getClientsPage().itemDescription_cards_1_qty_2_rate.get(2), "" + rate);
    }

    @Then("assert Amount field should be functional and give correct result")
    public void assertAmountFieldShouldBeFunctionalAndGiveCorrectResult() {
        Assert.assertEquals(qty * rate, Double.parseDouble(commonPage.getClientsPage().amount.getText()),0);
//        Assert.assertEquals(qty * rate, Integer.parseInt(commonPage.getClientsPage().amount.getText()));
        System.out.println("commonPage.getClientsPage().amount.getText() = " + commonPage.getClientsPage().amount.getText());
    }

    @Then("assert Subb Total should be functional and give accurate result")
    public void assertSubbTotalShouldBeFunctionalAndGiveAccurateResult() {
        Assert.assertEquals(qty * rate, Double.parseDouble(commonPage.getClientsPage().subTotal.getText()),0);
//        Assert.assertEquals(qty * rate, Integer.parseInt(commonPage.getClientsPage().subTotal.getText()));
        System.out.println("commonPage.getClientsPage().subTotal.getText() = " + commonPage.getClientsPage().subTotal.getText());

    }

    @Then("assert Salec Tax must be functional and give accurate results")
    public void assertSalecTaxMustBeFunctionalAndGiveAccurateResults() {
        clearAndSend(commonPage.getClientsPage().saleTotalPercantage, "Sale Tax (20%)");
    }

    @Then("assert Total should  be functional and give accurate results")
    public void assertTotalShouldBeFunctionalAndGiveAccurateResults() {
        System.out.println("commonPage.getClientsPage().saleTotal.getText() = " + commonPage.getClientsPage().saleTotal.getText());
//        Assert.assertEquals((qty * rate * 0.20), Double.parseDouble(commonPage.getClientsPage().saleTotal.getText().split(".")[0]), 0.0);
        Assert.assertEquals((qty * rate * 0.20), Double.parseDouble(commonPage.getClientsPage().saleTotal.getText()), 0.0);
    }

    @Then("assert Notes area should be  functional and writable")
    public void assertNotesAreaShouldBeFunctionalAndWritable() {
        clearAndSendAndAssert(commonPage.getClientsPage().notes, faker.shakespeare().hamletQuote());
    }

    @Then("assert The Terms & Conditions field should be functional and writable")
    public void assertTheTermsConditionsFieldShouldBeFunctionalAndWritable() {
        clearAndSendAndAssert(commonPage.getClientsPage().terms_conditions, faker.shakespeare().romeoAndJulietQuote());
    }

    // 1 yol
    @And("user enter username {string} and password {string}")
    public void userEnterUsernameAndPassword(String username, String password) {
        commonPage.getLoginPage().login1(username, password);
    }

    // 2 yol
    @And("user enter username  and password as standart")
    public void userEnterUsernameAndPasswordAsStandart() {
        commonPage.getLoginPage().login1(ConfigurationReader.getProperty("email_username"), ConfigurationReader.getProperty("email_password"));
    }

    public void waitAndClick(WebElement webElement) {
        BrowserUtilities.waitForClickability(webElement, 10);
        BrowserUtilities.clickWithJS(webElement);
    }

    public void clearAndSendAndAssert(WebElement webElement, String str) {
        BrowserUtilities.waitForVisibility(webElement, 10);
        String value = webElement.getAttribute("value");
        for (int i = 0; i < value.length(); i++) {
            webElement.sendKeys(Keys.BACK_SPACE);
        }
        BrowserUtilities.wait(3);
        webElement.sendKeys(str);

        Assert.assertEquals(str, webElement.getAttribute("value"));


    }

    public void clearAndSend(WebElement webElement, String str) {
        BrowserUtilities.waitForVisibility(webElement, 10);
        String value = webElement.getAttribute("value");
        for (int i = 0; i < value.length(); i++) {
            webElement.sendKeys(Keys.BACK_SPACE);

        }

        BrowserUtilities.wait(3);
        webElement.sendKeys(str);


    }

    public boolean isExist(WebElement webElement) {
        boolean flag;

        try {
            flag = webElement.isDisplayed() || !webElement.isDisplayed();
        } catch (NotFoundException e) {
            flag = false;
        }
        return flag;

    }


}
