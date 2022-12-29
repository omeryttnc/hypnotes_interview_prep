Feature: APi

  @premium
  Scenario: US_103 As a user, I should be able change category colors.
    Given get all color from backend
    And get all color from UI
    Then assert if UI color and backend color are matching
      | 0     | GroupSession |
      | 1     | Packages     |
      | 2     | Individual   |
      | 3     | ShowedUp     |
      | 4     | Canceled     |
      | 5     | Reschedule   |
      | 6     | Noshow       |
    When change color of from backend



