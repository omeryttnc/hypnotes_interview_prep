package com.hypnotes.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends CommonPage {
    @FindBy(xpath = "//a[text()='Login']")
    public WebElement loginButton_navbar;

    @FindBy(xpath = "//a[text()='Reset']")
    public WebElement resetButton;


    @FindBy(xpath = "//input[@name='username']")
    public WebElement emailBox;


    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit']/span")
    public WebElement loginButton_submit;


    @FindBy(xpath = "//div[@class='ant-message-notice-content']//span[2]")
    public WebElement toastMessage;




}
