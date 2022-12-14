package com.hypnotes.stepDefinitions.UIStepDef.clientInfo;

import com.hypnotes.utilities.BrowserUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Random;

import static com.hypnotes.stepDefinitions.UIStepDef.Hooks.commonPage;

public class US_051_stepDef {
    @And("click on getPayment on client info page")
    public void clickOnGetPaymentOnClientInfoPage() {
        BrowserUtilities.clickWithJS(commonPage.getClientsPage().getPayment);
    }

    @Then("assert Payment Options appear")
    public void assertPaymentOptionsAppear() {
        BrowserUtilities.waitForVisibility(commonPage.getPaymentPage().paymentOptionsTitle, 10);
        Assert.assertEquals("Payment options", commonPage.getPaymentPage().paymentOptionsTitle.getText());


    }

    @And("assert category options should be appear")
    public void assertCategoryOptionsShouldBeAppear() {

        commonPage.getPaymentPage().selectCategory_genel.click();
        BrowserUtilities.wait(2);

        Assert.assertTrue(commonPage.getPaymentPage().selectCategory_list.get(0).isDisplayed());
    }

    @And("User should be able to select custom category")
    public void userShouldBeAbleToSelectCustomCategory() {
        int size = commonPage.getPaymentPage().selectCategory_list.size();
        Random random = new Random();
        int clickIndex = random.nextInt(size);
        commonPage.getPaymentPage().selectCategory_list.get(clickIndex).click();

    }

    @And("User should be able to pay different ways: paypal, credit card, stripe, square {int} {string}")
    public void userShouldBeAbleToPayDifferentWaysPaypalCreditCardStripeSquareId(int index, String name) {

        commonPage.getPaymentPage().ticks_list.get(index).click();
        switch (index) {
            case 0:
                commonPage.getPaymentPage().payWithPaypal();
                break;
            case 1:
                commonPage.getPaymentPage().payWithCreditCard();
                break;
            case 2:
                commonPage.getPaymentPage().payWithStripe();
                break;
            case 3:
                commonPage.getPaymentPage().payWithSquare();
                break;

        }


    }
}
