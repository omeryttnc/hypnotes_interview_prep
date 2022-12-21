package com.hypnotes.pages;

import com.hypnotes.enums.TherapistInfo;
import com.hypnotes.utilities.BrowserUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.hypnotes.stepDefinitions.UIStepDef.Hooks.*;

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
    public List<WebElement> toastMessage;

    public void login1(String username, String password) {
        loginButton_navbar.click();
        BrowserUtilities.waitForClickability(emailBox, 10);
        emailBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton_submit.click();
        BrowserUtilities.waitForPageToLoad(10);
    }

    public void loginTestEnvironment(TherapistInfo therapistInfo) {
        driver.get("https://test.hypnotes.net/login");
        BrowserUtilities.waitForClickability(emailBox, 30);
        emailBox.sendKeys(therapistInfo.getEmail());
        passwordBox.sendKeys(therapistInfo.getPassword());
        loginButton_submit.click();
        BrowserUtilities.waitForPageToLoad(10);
        userSessionID = driver.manage().getCookieNamed("PHPSESSID").toString();
        isTestEnvironment = true;
    }

    public void loginProductEnvironment(TherapistInfo therapistInfo) {
        driver.get("https://hypnotes.net/login");
        BrowserUtilities.waitForClickability(emailBox, 30);
        emailBox.sendKeys(therapistInfo.getEmail());
        passwordBox.sendKeys(therapistInfo.getPassword());
        loginButton_submit.click();
        BrowserUtilities.waitForPageToLoad(10);
        userSessionID = driver.manage().getCookieNamed("PHPSESSID").toString();
        isTestEnvironment = false;
    }

}
