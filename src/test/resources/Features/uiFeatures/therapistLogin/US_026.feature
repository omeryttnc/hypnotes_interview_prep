#"Forgot your password? Reset should be clickable.
#When reset is clicked, the ""Forgot Password"" screen should appear.
#Forgot Password window should be functional
#Valid email must be entered in the Forgot Password window.
#Send Email button should be functional
#After entering the email, 'Send Email' should be clicked.
#After clicking the Send Email button, Email Reset Request should be seen in the mailbox.
#Please click ''here'' to reset your password. should be clickable
#After clicking Here the New Password screen should appear
#Email address, New Password buttons should be functioanal
#Must be entered with valid email and password
#Click Reset Password after entering valid credentials
#After clicking Reset Password, Login Page should appear"
#


Feature: Therapist(Log in)

  @day2
  Scenario: As a user Forgot your password? and I should be able to check the new password creation process_test_1
    Given go to website "https://test.hypnotes.net/"
    And click on the Login button
    Then assert reset button is displayed
    When click on reset button
    Then assert forgot password is displayed on the resetpage
    And assert user goes to "https://test.hypnotes.net/reset-password"
    When user enters email to forgot password
    And click on send email button on the forgot password page
    Then assert toast message as follow "If your email is registered to our system you will receive an email. Please check your email."
    When user goes to mail address
    Then assert last email title contains "Email Reset Request"
    When user click on the last email
    Then assert inner mail title is "Email Reset Request"
    When copy the link of reset password
    And go to the link of reset password
    Then assert new password is displayed
    When user enter email address
    And user enter email new password
    And click on the send email to change password
    Then assert "Successfully changed your password." is displayed
    When user click on the go to login page to login
    And assert user goes to "https://test.hypnotes.net/login"
    When user enter email address on the login page
    And user enter new password on the login page
    Then assert toast message as follow "Login Successful"


  @day2
  Scenario: As a user Forgot your password? and I should be able to check the new password creation process_test_2
    Given go to website "https://test.hypnotes.net/"
    And click on the Login button
    Then assert reset button is displayed
    When click on reset button
    Then assert forgot password is displayed on the resetpage
    And assert user goes to "https://test.hypnotes.net/reset-password"
    When user enters email to forgot password
    And click on send email button on the forgot password page
    Then assert toast message as follow "If your email is registered to our system you will receive an email. Please check your email."
    When user goes to mail address
    Then assert last email title contains "Email Reset Request"
    When user click on the last email
    Then assert inner mail title is "Email Reset Request"
    When user login mailsac
    When user click on the last email
    And user click on the login button on the mail
    And user goes second page
    And click here button
    Then assert new password is displayed
    When user enter email address
    And user enter email new password
    And click on the send email to change password
#    Then assert "Successfully changed your password." is displayed
    When user click on the go to login page to login
    And assert user goes to "https://test.hypnotes.net/login"
    When user enter email address on the login page
    And user enter new password on the login page
    Then assert toast message as follow "Login Successful"


















