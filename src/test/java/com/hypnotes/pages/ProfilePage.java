package com.hypnotes.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends CommonPage {
    @FindBy(xpath = "//div[text()='Your Company']")
    public WebElement yourCompanyTab;

    @FindBy(css = ".ant-card-head-title")
    public WebElement companyTitle;


    @FindBy(css = "[aria-label='edit']")
    public WebElement editCompany;


    @FindBy(css = "button [aria-label='plus']")
    public WebElement addNewCompany;


    @FindBy(xpath = "(//span[contains(@class,'ant-typography-secondary')])[1]")
    public WebElement companyAddress;

    @FindBy(xpath = "(//span[contains(@class,'ant-typography-secondary')])[2]")
    public WebElement companyCity;

    @FindBy(xpath = "(//span[contains(@class,'ant-typography-secondary')])[3]")
    public WebElement companyCountry;

    @FindBy(xpath = "(//span[contains(@class,'ant-typography-secondary')])[4]")
    public WebElement companyPhone;


    // create new category


    @FindBy(css = "button.invoice_imageChange__eejJa")
    public WebElement yourLogoRemove;

    @FindBy(xpath = "(//input[@type='file'])[2]")
    public WebElement yourLogoFile;

    @FindBy(xpath = "(//div[contains(@class,\"compTab_companyInputs__AvJBu\")])[1]/input")
    public WebElement create_yourCompany;

    @FindBy(xpath = "(//div[contains(@class,\"compTab_companyInputs__AvJBu\")])[2]/input")
    public WebElement create_companyAddress;


    @FindBy(xpath = "(//div[contains(@class,\"compTab_companyInputs__AvJBu\")])[3]/input")
    public WebElement create_cityStateZip;


    @FindBy(xpath = "(//div[contains(@class,\"compTab_companyInputs__AvJBu\")])[4]/input")
    public WebElement create_country_genel;


    @FindBy(css = "select.invoice_select__WnoPF  ")
    public WebElement create_country_select;


    @FindBy(xpath = "(//div[contains(@class,\"compTab_companyInputs__AvJBu\")])[5]/input")
    public WebElement create_companyUrl;


    @FindBy(xpath = "(//div[contains(@class,\"compTab_companyInputs__AvJBu\")])[6]/input")
    public WebElement create_companyPhone;

    @FindBy(xpath = "(//div[contains(@class,\"compTab_companyInputs__AvJBu\")])[7]/input")
    public WebElement create_companyEmail;


    @FindBy(xpath = "(//span[text()='Save'])[3]")
    public WebElement create_save;

    @FindBy(xpath = "(//span[text()='Update'])")
    public WebElement create_update;


}
