package com.hypnotes.pages;

import com.hypnotes.utilities.BrowserUtilities;
import com.hypnotes.utilities.ConfigurationReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.hypnotes.stepDefinitions.UIStepDef.Hooks.*;

public class PaymentPage extends CommonPage {


    @FindBy(css = ".ant-modal-title")
    public WebElement paymentOptionsTitle;

    @FindBy(css = "#service-form_selectedCategory")
    public WebElement selectCategory_genel;

    @FindBy(css = ".ant-select-item-option-content")
    public List<WebElement> selectCategory_list;

    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    public WebElement paypal_tick;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement credit_tick;

    @FindBy(xpath = "(//input[@type='checkbox'])[3]")
    public WebElement stripe_tick;

    @FindBy(xpath = "(//input[@type='checkbox'])[4]")
    public WebElement squad_tick;

    @FindBy(xpath = "//button[@type='submit' and @class='ant-btn ant-btn-primary']")
//    @FindBy(xpath = "(//input[@type='checkbox'])")
    public List<WebElement> ticks_list;


    @FindBy(xpath = "//button[@type='submit' and @class='ant-btn ant-btn-primary']")
    public WebElement payment_go_payment;

    //paypal
    @FindBy(css = "#header")
    public WebElement paypal_header;

    @FindBy(css = "#email")
    public WebElement paypal_email;

    @FindBy(css = "#password")
    public WebElement paypal_password;

    @FindBy(css = "#btnLogin")
    public WebElement paypal_btnLogin_down;

    @FindBy(css = ".css-ltr-1m7plzc-button-Button")
    public WebElement paypal_btnLogin_up;

    @FindBy(css = "#btnNext")
    public WebElement paypal_btnNext;

    @FindBy(css = "#transactionCart")
    public WebElement paypal_amount;

    @FindBy(css = ".continueButton")
    public WebElement paypal_continueButton;

    @FindBy(css = "#confirmButtonTop")
    public WebElement paypal_confirmButtonTop;

    @FindBy(css = "#payment-submit-btn")
    public WebElement paypal_payNow;

    @FindBy(css = ".ant-result-title")
    public WebElement successfullyPayment_Title;

    //credit card
    @FindBy(css = "#pan")
    public WebElement credit_card;

    @FindBy(css = "#fullName")
    public WebElement credit_name;

    @FindBy(css = "#expireDate")
    public WebElement credit_expireDate;

    @FindBy(css = "#cvv")
    public WebElement credit_cvv;

    @FindBy(css = "#zipCode")
    public WebElement credit_zipcode;

    //stripe
    @FindBy(css = "#cardNumber")
    public WebElement stripe_cardNumber;

    @FindBy(css = "#email")
    public WebElement stripe_email;

    @FindBy(css = "#cardExpiry")
    public WebElement stripe_cardExpiry;

    @FindBy(css = "#cardCvc")
    public WebElement stripe_cardCvc;

    @FindBy(css = "#billingName")
    public WebElement stripe_billingName;

    @FindBy(css = ".SubmitButton-IconContainer")
    public WebElement stripe_subscribe;

    @FindBy(css = "#billingPostalCode")
    public WebElement stripe_billingPostalCode;

    @FindBy(css = ".ant-result-title")
    public WebElement successMessage;

    @FindBy(css = "[data-testid='header-cart-total']")
    public WebElement totalPrice;

    // square

    @FindBy(css = "#cardNumber:nth-child(1)")
    public WebElement squareCardNumber;
    @FindBy(css = "#expirationDate")
    public WebElement squareExpirationDate;
    @FindBy(css = "#cvv")
    public WebElement squareCVV;
    @FindBy(css = "#postalCode")
    public WebElement squareZip;
    @FindBy(css = "#rswp-card-button")
    public WebElement squarePay;

    @FindBy(css = ".sq-card-iframe-container iframe")
    public WebElement squareIframe;

    @FindBy(css = ".ant-result-subtitle")
    public WebElement successfullyCreatedAMeetingWith_title;

    public void payWithPaypal() {

        payment_go_payment.click();
        BrowserUtilities.wait(2);
        BrowserUtilities.switchToWindowWithIndex(1);
        BrowserUtilities.wait(2);

        if (BrowserUtilities.isExist(paypal_btnLogin_up)) {
            paypal_btnLogin_up.click();
            BrowserUtilities.wait(3);
        }

        paypal_email.sendKeys(ConfigurationReader.getProperty("paypal_username"));

        if (BrowserUtilities.isExist(paypal_btnNext)) {
            paypal_btnNext.click();
            BrowserUtilities.wait(2);
        }

        paypal_password.sendKeys(ConfigurationReader.getProperty("paypal_password"));

        paypal_btnLogin_down.click();
        BrowserUtilities.waitAndClick(paypal_payNow);

        BrowserUtilities.waitForVisibility(successfullyPayment_Title, 10);
        Assert.assertEquals("Successfully Payment", successfullyPayment_Title.getText());
    }

    public void payWithCreditCard() {
        credit_name.sendKeys(faker.name().fullName());
        credit_card.sendKeys(ConfigurationReader.getProperty("stripe_card_number"));
        credit_expireDate.sendKeys(ConfigurationReader.getProperty("stripe_expire_month_year"));
        credit_cvv.sendKeys(ConfigurationReader.getProperty("stripe_cvv"));
        credit_zipcode.sendKeys(ConfigurationReader.getProperty("stripe_zip"));

        payment_go_payment.click();

        BrowserUtilities.waitForVisibility(commonPage.loginPage.toastMessage.get(0), 10);
        Assert.assertEquals("successful payment", commonPage.loginPage.toastMessage.get(0).getText());

    }

    public void payWithStripe() {
        payment_go_payment.click();
        BrowserUtilities.wait(2);
        BrowserUtilities.switchToWindowWithIndex(1);
        BrowserUtilities.wait(2);

        stripe_email.sendKeys(faker.internet().emailAddress());
        stripe_cardNumber.sendKeys(ConfigurationReader.getProperty("stripe_card_number"));
        stripe_cardExpiry.sendKeys(ConfigurationReader.getProperty("stripe_expire_month_year"));
        stripe_cardCvc.sendKeys(ConfigurationReader.getProperty("stripe_cvv"));
        stripe_billingName.sendKeys(faker.name().fullName());
        stripe_billingPostalCode.sendKeys(ConfigurationReader.getProperty("stripe_zip"));

        stripe_subscribe.click();

        BrowserUtilities.waitForVisibility(successfullyPayment_Title, 10);
        Assert.assertEquals("Successfully Payment", successfullyPayment_Title.getText());
    }

    public void payWithSquare() {
        BrowserUtilities.wait(3);

        driver.switchTo().frame(squareIframe);
        BrowserUtilities.wait(2);
        squareCardNumber.sendKeys(ConfigurationReader.getProperty("square_card_number"));
        BrowserUtilities.wait(3);
        squareExpirationDate.sendKeys(ConfigurationReader.getProperty("square_expire_year_month"));
        squareCVV.sendKeys(ConfigurationReader.getProperty("square_cvv"));
        squareZip.sendKeys(ConfigurationReader.getProperty("square_zip"));

        driver.switchTo().parentFrame(); //default
        BrowserUtilities.wait(2);
        squarePay.click();


        BrowserUtilities.waitForVisibility(commonPage.loginPage.toastMessage.get(0), 10);
        Assert.assertEquals("successful payment", commonPage.loginPage.toastMessage.get(0).getText());

    }

}
