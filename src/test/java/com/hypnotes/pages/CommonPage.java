package com.hypnotes.pages;

import org.openqa.selenium.support.PageFactory;

import static com.hypnotes.stepDefinitions.UIStepDef.Hooks.driver;

public abstract class CommonPage {

    public CommonPage() {
        PageFactory.initElements(driver, this);
    }

    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    ResetPassword resetPassword;
    MailSacPage mailSacPage;
    NewPassword newPassword;
    DashboardPage dashboardPage;
    ProfilePage profilePage;
    ClientsPage clientsPage;

    public ClientsPage getClientsPage() {
        if (clientsPage == null) {
            clientsPage = new ClientsPage();
        }
        return clientsPage;
    }

    public ProfilePage getProfilePage() {
        if (profilePage == null) {
            profilePage = new ProfilePage();
        }
        return profilePage;
    }

    public DashboardPage getDashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;
    }

    public NewPassword getNewPassword() {
        if (newPassword == null) {
            newPassword = new NewPassword();
        }
        return newPassword;
    }

    public MailSacPage getMailSacPage() {
        if (mailSacPage == null) {
            mailSacPage = new MailSacPage();
        }
        return mailSacPage;
    }

    public ResetPassword getResetPassword() {
        if (resetPassword == null) {
            resetPassword = new ResetPassword();
        }


        return resetPassword;
    }

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




