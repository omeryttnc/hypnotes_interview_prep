package com.hypnotes.pages;

import com.hypnotes.utilities.BrowserUtilities;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static com.hypnotes.stepDefinitions.UIStepDef.Hooks.driver;

public class ClientsPage extends CommonPage {
    @FindBy(xpath = "//span[text()='View Detail']")
    public List<WebElement> viewDeatils;

    //invoice
    @FindBy(xpath = "(//a[contains(@class,clientHeader_clientHeaderTab__yujJd)]/p)[4]")
    public WebElement invoice;


    @FindBy(css = "textarea[placeholder='Your Company']")
    public WebElement invoice_companyName;


    @FindBy(css = "[placeholder^='Company']")
    public WebElement invoice_address;

    @FindBy(css = "div.w-50 [placeholder^='City, State']")
    public WebElement invoice_city_state_zipcode;

    @FindBy(xpath = "(//input[@readonly and @class='invoice_input__75vJN  '])[1]")
    public WebElement invoice_country;

//    @FindBy(xpath = "//td[@title='2023-01-02']")
//    public WebElement calender;

    //bill

    @FindBy(xpath = "(//div[@class='view d-flex mt-5']//input[contains(@class,'invoice_input__75vJN')])[2]")
    public WebElement bill_clientName;

    @FindBy(xpath = "(//div[@class='view d-flex mt-5']//input[contains(@class,'invoice_input__75vJN')])[3]")
    public WebElement bill_clientAddress;

    @FindBy(xpath = "(//div[@class='view d-flex mt-5']//input[contains(@class,'invoice_input__75vJN')])[4]")
    public WebElement bill_clientCity;

    @FindBy(xpath = "(//div[@class='view d-flex mt-5']//input[contains(@class,'invoice_input__75vJN')])[5]")
    public WebElement bill_clientCountry;

    @FindBy(xpath = "(//input[@placeholder='Select date'])[1]")
    public WebElement bill_invoiceDate;

    @FindBy(xpath = "(//input[@placeholder='Select date'])[2]")
    public WebElement bill_dueDate;

    //item description
    @FindBy(xpath = "//div[@class='view invoices_row__5b9py d-flex']")
    public List<WebElement> itemDescription_cards;

    @FindBy(xpath = "(//span[@class='span invoices_boldDark__jRBno'])[1]")
    public WebElement amount;


    @FindBy(xpath = "(//div[@class='view invoices_row__5b9py d-flex'])//input[contains(@class,invoices_darkRight__o078y)]")
    public List<WebElement> itemDescription_cards_1_qty_2_rate;

// search --> [type='search']
// amount --> .span.invoices_boldDark__jRBno


    @FindBy(css = "div.mt-4 button.invoices_link__01VJH")
    public WebElement addLineItem;

    @FindBy(xpath = "(//div[@class='view w-50 d-flex justify-content-end']/span)[1]")
    public WebElement subTotal;

    @FindBy(css = ".span.invoices_darkBoldRight__p5p6Q")
    public WebElement total;


    @FindBy(xpath = "(//div[@class='view w-50 d-flex justify-content-end']/span)[2]")
    public WebElement saleTotal;

    @FindBy(xpath = "(//input[@class='invoice_input__75vJN '])[9]")
    public WebElement saleTotalPercantage;

    @FindBy(xpath = "(//textarea[@class='ant-input invoice_input__75vJN  w-100'])[1]")
    public WebElement notes;

    @FindBy(xpath = "(//textarea[@class='ant-input invoice_input__75vJN  w-100'])[2]")
    public WebElement terms_conditions;

    public void selectAndAssertDate(WebElement webElement, int dayToSkip) {
        webElement.click();
        WebElement webElementDate = driver.findElement(By.xpath("//td[@title='" + getDateForCalender(dayToSkip) + "']"));
        BrowserUtilities.waitForClickability(webElementDate, 10);
        webElementDate.click();
        BrowserUtilities.wait(3);
        Assert.assertEquals(getDateForAssertion(dayToSkip), webElement.getAttribute("value"));
    }

    public void clearAndSendDate(WebElement webElement, int dayToSkip) {
        BrowserUtilities.waitForVisibility(webElement, 10);
        String value = webElement.getAttribute("value");
        for (int i = 0; i < value.length(); i++) {
            webElement.sendKeys(Keys.BACK_SPACE);
        }
        BrowserUtilities.wait(3);
        webElement.sendKeys(getDateForAssertion(dayToSkip)+Keys.ENTER);
    }

    private String getDateForCalender(int dayToSkip) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, dayToSkip);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(calendar.getTime());
    }

    private String getDateForAssertion(int dayToSkip) {

        // 12-16-2022
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, dayToSkip);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        return simpleDateFormat.format(calendar.getTime());
    }


}
