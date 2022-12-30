#"When the user click to Next button , the Confirmation line should be entered
#Confirm Meeting Details should appear in the Confirmation section
#Do not notify client should  be clickable
#Reschedule without asking for user's permission should be clickable
#Submit button should be clickable
#When the user click to Submit  btn, the Payment Required screen should appear
#Various payment options should appear
#Paypal/Stripe/Pay with credit or debit should be selectable
#Paypal/Stripe/Pay with credit or debit should come after Go to Payment option
#Payment should be able to make  after the required information is entered on the Paypal/Stripe/Pay with credit or debit screen
#""Successfully Paid and Thanks for choosing Hypnotes"" should be visible
#After the payment is completed, the Details line should be able to switch to PayPal
#PayPal
#sandbox@personal.example.com
#NvR29+Ww
#Stripe
#4242 4242 4242 4242
#Next date
#CVC: 3 digit code
#Authorize.net
#4111111111111111         exp:2025-12
#cvv:999                                                                                                                                                                                   Square
#pan:4111 1111 1111 1111111
#exp:ileri tarih
#cvv:111 (edited)
#In the Details section, Successfully created a meeting with and various details should be visible
#Close button should be clickable
#When the user click to Close button , the Meet Info menu should appear
#It should be possible to log out from the Meet Info menu
#when the user Click on Book an appointment than should display the Book an appointment screen
#Should be visible  on Reschedule Meeting Calendar"

Feature:

  @enterprise
  Scenario Outline:
    Given delete all meetings
    And set meeting for client
    And click on the first meeting
    Then assert if date and time is matching
    And assert if client info is matching
    When click on the reschedule appointment
    And click on collect Payment
    And select suitable time
    And click yes to confirm
    When click next to continue
    Then assert reschedule without asking for users permission button is working
    When click on the submit
    And User should be able to pay different ways: paypal, credit card, stripe, square <id> "<name>"
    Examples:
      | id | name        |
      | 0  | paypal      |
      | 1  | credit card |
      | 2  | stripe      |
      | 3  | squad       |

