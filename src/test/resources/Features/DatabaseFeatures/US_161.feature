Feature: Database Client

  @enterprise
  Scenario: As a user, I should be able to see clients in client_info table.
    Given click on add client side
    And enter first name for new client
    And enter last name for new client
    And enter phone number for new client
    And enter occupation for new client
    And enter email for new client
    And enter county for new client
    And click on add client bottom
    And click yes to confirm
    And collect created client Id
    Then compare information from UI to database
    Then close connection