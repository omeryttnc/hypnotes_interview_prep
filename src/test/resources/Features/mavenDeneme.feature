Feature: maven deneme

  @smoke2
  @testEnvironment
  Scenario: sadece smoke
    Given sadece smoke

  @regression
  @testEnvironment
  Scenario: sadece regression
    Given sadece regression


  @disable
  @smoke2
  @testEnvironment
  Scenario: disable smoke
    Given disable smoke

  @smoke2
  @calender
  @testEnvironment
  Scenario: smoke calender
    Given smoke calendar


  @calender
  @testEnvironment
  Scenario: smoke calender
    Given sadece calendar



