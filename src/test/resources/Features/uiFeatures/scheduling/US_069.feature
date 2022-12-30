#"Settings
#When the Scheduling(Settings) button is clicked, the Online Info page should be displayed.
#Add Block Time, Save, Off Day buttons must be clickable on the Online Info page.
#Flexible Time Meeting button should be clickable
#Customize your url option should be clickable
#Flexible Time Meeting button should be clickable
#When Add Block Time is added, it should be listed under Blocked Times
#The added Block Time should appear as a red time in the Schedule An Appointment section
#Update and Delete options should appear under the Blocked Times heading.
#When you click on the update option, the time button should appear for the new update.
#Clicking Delete, the message Blocked Time Deleted should appear
#Clicking Off day should see the color change for the relevant day.
#Off day' days must be active in the Schedule An Appointment section
#When the user click on Customize your url should visible the Upgrade Now page
#Show All Subscription Plans and Cancel button on Upgrade Now page should be functional
#When the user click to Show All Subscription Plans, the Subscription page should appear
#When the user click to  Cancel button should return to the Upgrade Now page"

Feature: Scheduling Settings

  @basic
  Scenario: As a user, I should be able to perform various actions in the Scheduling(Settings) Page
    When click on scheduling on the sidebar
    And click on the setting on the sidebar
    Then assert the Online Info page should be displayed
    And assert number of client limit is clickable
    And assert off day limit is clickable
    And assert flexible time meeting is clickable
    And assert show canceled meeting is clickable
    When Add Block Time is added, it should be listed under Blocked Times
    Then assert Update and Delete options should appear under the Blocked Times heading
    When you click on the update option, the time button should appear for the new update
    When Clicking Delete, the message Blocked Time Deleted should appear
    And assert save is clickable
#  Clicking Off day should see the color change for the relevant day.
#  Off day' days must be active in the Schedule An Appointment section
  @basic
  Scenario: part 2
    When click on scheduling on the sidebar
    And click on the setting on the sidebar
    When the user click on Customize your url should visible the Upgrade Now page
    When Show All Subscription Plans and Cancel button on Upgrade Now page should be functional
    When the user click to Show All Subscription Plans, the Subscription page should appear

  @basic
  Scenario: part 3
    When click on scheduling on the sidebar
    And click on the setting on the sidebar
    When the user click on Customize your url should visible the Upgrade Now page
    When the user click to  Cancel button should return to the Upgrade Now page















