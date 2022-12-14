package com.hypnotes.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends CommonPage {
    @FindBy(css = ".justify-content-start")
    public WebElement activeSubscriptionYearType;
}
