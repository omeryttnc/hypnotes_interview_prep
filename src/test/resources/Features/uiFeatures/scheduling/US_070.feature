#"Calendar
#When the user click to Scheduling(Calendar) button , the Calendar page should be displayed.
#Individual Sessions color update should be possible
#Packages color update should be possible
#Group Session color update should be possible
#Show Up color update should be possible
#Reschedule color update should be possible
#No Show color update should be possible
#Month, week, day must be selectable
#When  the user select month, week, day , the page should be updated according to the relevant title.
#When the user click to Schedule An Appointment , the relevant page should be displayed.
#Block Time must be clickable
#When the user click to  Block Time, the corresponding Block Dates page should appear"
#


Feature: Scheduling Calender

  @premium
  Scenario: As a user, I should be able to perform various actions in the Scheduling(Calendar) Page
    Given click on scheduling on the sidebar
    And click on Calender on the sidebar
    Then assert schedule an appointment is visible
    Then Individual Sessions color update should be possible
    Then Packages color update should be possible
    Then Group Session color update should be possible
    Then Show Up color update should be possible
    Then Reschedule color update should be possible
    Then No Show color update should be possible


  @premium
  Scenario: As a user, I should be able to perform various actions in the Scheduling(Calendar) Page part 2
    Then Month, week, day must be selectable
    When  the user select month, week, day , the page should be updated according to the relevant title.
#    When the user click to Schedule An Appointment , the relevant page should be displayed.
