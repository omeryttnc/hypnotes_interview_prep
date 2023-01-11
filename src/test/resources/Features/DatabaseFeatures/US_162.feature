Feature: Database Category

  @db
  Scenario: As a user, I should be able to see category colors in the category_color table for correct user.
    Given collect color information from backend
    Given collect color information from database
    Then compare color information from database
#    Then close connection
