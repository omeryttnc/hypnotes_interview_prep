package com.hypnotes.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewPassword extends CommonPage {
    @FindBy(xpath = "//h3")
    public WebElement newPassword_title;


    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;

    @FindBy(xpath = "//form/p")
    public WebElement successfullyChangedYourPassword;

    @FindBy(xpath = "//div/a[@class]")
    public WebElement goToLoginPage;
}
