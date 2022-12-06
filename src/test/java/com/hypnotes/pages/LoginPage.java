package com.hypnotes.pages;

import com.hypnotes.enums.TherapistInfo;
import com.hypnotes.utilities.BrowserUtilities;
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

    public void login1(String username, String password) {
        loginButton_navbar.click();
        BrowserUtilities.waitForClickability(emailBox, 10);
        emailBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton_submit.click();
        BrowserUtilities.waitForPageToLoad(10);
    }

    public void login2(TherapistInfo therapistInfo) {
       // loginButton_navbar.click();
        BrowserUtilities.waitForClickability(emailBox, 30);
        emailBox.sendKeys(therapistInfo.getEmail());
        passwordBox.sendKeys(therapistInfo.getPassword());
        loginButton_submit.click();
        BrowserUtilities.waitForPageToLoad(10);
    }

}
