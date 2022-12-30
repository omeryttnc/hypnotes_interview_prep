package com.hypnotes.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends CommonPage {
    @FindBy(css = ".ytp-large-play-button-red-bg")
    public WebElement youtube_play;

    @FindBy(css = "[src*='youtube']")
    public WebElement youtube_frame;

    @FindBy(css = ".video-stream.html5-main-video")
    public WebElement youtube_attribute;

    @FindBy(css = ".dot")
    public List<WebElement> dots;



    @FindBy(css = ".details.LandingPage_textDark__EZpFS")
    public List<WebElement> testimonials;

    @FindBy(css = "[aria-label='Previous']")
    public WebElement button_previous;

    @FindBy(css = "[aria-label='Next']")
    public WebElement button_next;

    @FindBy(css = ".BaseFooter_footerCol__kUthZ ul li")
    public List<WebElement> footerLinks;
}
