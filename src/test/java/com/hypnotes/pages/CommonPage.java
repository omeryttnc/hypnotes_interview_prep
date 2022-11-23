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

}




