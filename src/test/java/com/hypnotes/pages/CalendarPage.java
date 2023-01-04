package com.hypnotes.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CalendarPage extends CommonPage {
    @FindBy(css = "button.calendar_genricBtnTextSuccessBorder__cIuju")
    public WebElement scheduleAnAppointment;
    @FindBy(xpath = "//div[contains(@class,\"d-flex flex-row justify-content-between align-items-center\")]/button")
    public List<WebElement> colorToChange;
    @FindBy(xpath = "//input[contains(@class,\"color_color\")]")
    public WebElement colorCode;
    @FindBy(xpath = "//strong[text()='Color Schema Settings']")
    public WebElement colorSchemaSettings;

    @FindBy(xpath = "(//a[contains(@class,'fc-daygrid-event')])")
    public List<WebElement> allAppointmentOnCalendar;

    @FindBy(xpath = "//span[text()='Block Time']/..")
    public WebElement btnBlockTime;

    @FindBy(css = "button.blocktime_updateAndDelButton__1BUzY")
    public WebElement addBlockTimeButton_add;

    @FindBy(css = "[value=\"ShowedUp\"]")
    public WebElement markAs_ShowedUp;

    @FindBy(css = "[title='Next month']")
    public WebElement nextMonth;

    @FindBy(css = "[value=\"Reschedule\"]")
    public WebElement markAs_Reschedule;

    @FindBy(css = "[value=\"Canceled\"]")
    public WebElement markAs_Cancelled;

    @FindBy(css = "[value=\"Noshow\"]")
    public WebElement markAs_Noshow;

    @FindBy(xpath = "//button[@title='month view']")
    public WebElement viewMonth;

    @FindBy(xpath = "//button[@title='week view']")
    public WebElement viewWeek;

    @FindBy(xpath = "//button[@title='day view']")
    public WebElement viewDay;

    @FindBy(css = ".fc-col-header-cell-cushion")
    public List<WebElement> weeklyDays_title;

    @FindBy(css = ".fc-toolbar-title")
    public WebElement monthly_day_title;

    @FindBy(css = ".ant-btn-warn")
    public WebElement rescheduleAppointment;

    @FindBy(css = "[type='checkbox']")
    public WebElement collectPayment;

    @FindBy(css = ".ant-list-items button")
    public List<WebElement> availableTimes_from_reschedule_appointment;

    @FindBy(xpath = "//span[text()='Yes']")
    public WebElement yes_to_confirm;

    @FindBy(xpath = "//span[text()='Next']")
    public WebElement next_to_continue;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement reschedule_without_asking_users_permission;

    @FindBy(css = ".ant-checkbox-checked")
    public WebElement checkedBox;


    @FindBy(xpath = "(//div[@class='site-description-item-profile-wrapper'])[8]")
    public WebElement personalInfo_fullName;

    @FindBy(xpath = "(//div[@class='site-description-item-profile-wrapper'])[9]")
    public WebElement personalInfo_email;

    @FindBy(xpath = "(//div[@class='site-description-item-profile-wrapper'])[2]")
    public WebElement meetingInfo_time;

    @FindBy(xpath = "(//div[@class='site-description-item-profile-wrapper'])[4]")
    public WebElement meetingInfo_date;

    @FindBy(xpath = "//span[text()='Submit']")
    public WebElement submit;
}
