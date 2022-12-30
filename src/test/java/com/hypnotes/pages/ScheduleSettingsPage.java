package com.hypnotes.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ScheduleSettingsPage extends CommonPage {

    @FindBy(css = ".ant-descriptions-title")
    public WebElement onlineInfoTitle;

    @FindBy(css = "#customizeYourUrl span")
    public WebElement customizeYourUrl;

    @FindBy(css = "#flexibleButton")
    public WebElement flexibleTimeMeeting;

    @FindBy(css = "#showButton")
    public WebElement showCanceledMeeting;

    @FindBy(css = "#clientLimit")
    public List<WebElement> numberOfClientLimit;

    @FindBy(css = "[type='number']")
    public WebElement numberForTheClientLimit;

    @FindBy(css = "#offDay")
    public List<WebElement> offDay;

    @FindBy(css = "#blockButton")
    public List<WebElement> addBlockTime;

    @FindBy(css = ".ant-select-selection-search input")
    public List<WebElement> startDay_0_endDay_1_time;

    @FindBy(css = "#submit")
    public WebElement save;

    @FindBy(css = "[type='search']")
    public List<WebElement> addBlockTime_start__2_end__1;

    @FindBy(css = "[name='delete']")
    public List<WebElement> deleteBlockTime;

    @FindBy(xpath = "(//button[@name='update'])[1]")
    public WebElement updateBlockTime_genel;

    @FindBy(xpath = "(//button[@name='update'])[2]")
    public WebElement updateBlockTime_popup;

    @FindBy(xpath = "//span[text()='Show All Subscription Plans']")
    public WebElement showAllSubscriptionPlans;


    @FindBy(xpath = "//span[text()='Cancel']")
    public WebElement showAllSubscriptionPlans_cancel;


}
