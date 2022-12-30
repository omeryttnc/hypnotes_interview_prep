package com.hypnotes.pages;

import com.hypnotes.utilities.BrowserUtilities;
import com.hypnotes.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MailSacPage extends CommonPage {

    @FindBy(xpath = "//td[@class='col-xs-5 ng-binding']")
    public List<WebElement> allEmailsTitle;


    @FindBy(xpath = "//h1/strong")
    public WebElement emailResetRequest;

    @FindBy(xpath = "//pre")
    public WebElement token;

    @FindBy(xpath = "//a[@class='btn btn-danger btn-xs']")
    public WebElement loginMail;
    @FindBy(xpath = "(//a[@class='btn btn-info btn-xs'])[1]")
    public WebElement loginMail_inside;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;

    @FindBy(xpath = "//a[text()='here']")
    public WebElement clickHere;


    public void loginMail(){
        loginMail.click();
        BrowserUtilities.wait(3);
        username.sendKeys(ConfigurationReader.getProperty("email_username"));
        password.sendKeys(ConfigurationReader.getProperty("email_password"));
        submit.click();
        BrowserUtilities.wait(3);


    }


}
