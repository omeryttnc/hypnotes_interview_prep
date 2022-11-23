package com.hypnotes.pages;

import com.hypnotes.utilities.BrowserUtilities;
import com.hypnotes.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static com.hypnotes.stepDefinitions.UIStepDef.Hooks.driver;

public abstract class CommonPage {

    public CommonPage() {
        PageFactory.initElements(driver, this);
    }

    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public RegisterPage getRegisterPage() {
        if (registerPage == null) {
            registerPage = new RegisterPage();
        }
        return registerPage;
    }
}




