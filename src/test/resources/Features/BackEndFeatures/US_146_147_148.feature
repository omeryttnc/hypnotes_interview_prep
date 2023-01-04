Feature: As a user I should able to add update and remove education

  Background: set session step
    Given get session Id

  Scenario: add education from backend
    When add education step
    Then assert add education take place correctly

  Scenario: update education from backend
    When update education step
    Then assert update education take place correctly

  Scenario: remove education from backend
    When remove education step
    Then assert remove education take place correctly
