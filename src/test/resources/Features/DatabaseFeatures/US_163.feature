Feature: Database Coupon

  Scenario: As a user, I should be able to see coupon list in the coupons table.
    Given The codes should be unique for same user_id.
    Then close connection
