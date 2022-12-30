package com.hypnotes.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResetPassword extends CommonPage {

    @FindBy(xpath = "//h3")
    public WebElement forgotPassword_text;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement emailSubmitButton;
}
