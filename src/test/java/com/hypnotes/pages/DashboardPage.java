package com.hypnotes.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends CommonPage {
    @FindBy(css = "[href$='profile']")
    public WebElement profile;
    @FindBy(css = "[href$='clients']")
    public WebElement clients;

    @FindBy(css = "[href$='add-client']")
    public WebElement addClient;
    @FindBy(xpath = "//span[text()='Scheduling']")
    public WebElement scheduling;

    @FindBy(xpath = "//a[text()='Setting']")
    public WebElement scheduling_setting;

    @FindBy(xpath = "//a[text()='Calendar']")
    public WebElement scheduling_calendar;


}
