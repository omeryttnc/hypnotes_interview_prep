package com.hypnotes.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.WatchEvent;

public class US_007_page extends CommonPage {
    @FindBy(css = ".ytp-large-play-button-red-bg")
    public WebElement youtube_play;

    @FindBy(css = "[src*='youtube']")
    public WebElement youtube_frame;

    @FindBy(css = ".video-stream.html5-main-video")
    public WebElement youtube_attribute;






}
