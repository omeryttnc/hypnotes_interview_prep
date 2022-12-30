#"""Get Payment button should be clickable
#When the user Click the Get Payment button and Payment Options should appear
#Category options should be appear
#User should be able to select custom category
#Payment related parts should be functional
#Payment options must be clickable
#User should be able to pay 4 different ways: paypal, credit card, stripe, square
#Go to Payment button must be clickable
#When the user click  Go to Payment button the payment screen should appear"""

Feature: Client Info

  @standard
    @firefox
  Scenario Outline: As a user, I should be able to see various payment options
    When user goes to client page
    And click on view detail of client button
    And go to bottom page
    And click on getPayment on client info page
    Then assert Payment Options appear
    And assert category options should be appear
    And User should be able to select custom category
#    And Payment related parts should be functional
#    And Payment options must be clickable
    And User should be able to pay different ways: paypal, credit card, stripe, square <id> "<name>"
    Examples:
      | id | name        |
      | 0  | paypal      |
#      | 1  | credit card |
#      | 2  | stripe      |
#      | 3  | square      |
#    And Go to Payment button must be clickable
#    When the user click  Go to Payment button the payment screen should appear










