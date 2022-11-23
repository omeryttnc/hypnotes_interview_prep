#"Under About Hypnotes? section on homepage, Youtube video should be clickable and the video should play.
#More about Hypnotes section should be visible.
#More about Hypnotes section should not contain spelling and logic mistakes.
#More about Hypnotes should be clickable and the relevant page should be seen. https://test.hypnotes.net/about-us "
#



Feature: homePage

  @007
  Scenario: As a user, I should be able to see various titles and make various controls on the homepage.
    Given go to website "https://test.hypnotes.net/"
    When click on the youtube video
    Then assert video is playing



