#"Invoice
#A valid logo should be able to add to the Your Logo field
#A valid name should be able to enter in the Your Company field
#A valid name should be able to enter in the Your Name field
#A valid address should be able to enter in the Company's Address field
#Valid information should be able to enter in the City, State, Zip field
#User should be able to select country from Country drop-down menu
#Bill To:
#A valid name should be able to enter in the Client Name field.
#A valid address should be able to enter in the Client's Address field
#Valid information should be able to enter in the City, State, Zip field
#Country Drop-Down must be functional
#User should be able to select country from Country drop-down menu
#Invoice#
#field must be functional and writable
#Invoice Date must be functional and date selectable
#Due Date must be functional and date selectable
#Item name description should be enterable or selectable
#QTY(Quantity) field should be functional and number must be writable
#The Rate field should be functional and the number must be writable
#Amount field should be functional and give correct result
#Subb Total should be functional and give accurate result
#Salec Tax must be functional and give accurate results
#Total should  be functional and give accurate results
#Add Line Item should be able to clickable
#A new item name description field should be created when the Add Line button is clicked.
#Notes area should be  functional and writable
#The Terms & Conditions field should be functional and writable"
#
Feature: invoice

  @standard
   Scenario: As a user, I should be able to add Therapist information to the Invoice field
    Given go to profile page
    And click on your company
    And click on add or update new company
    Then assert valid logo should be able to add to the Your Logo field
    Then assert valid name should be able to enter in the Your Company field
    Then assert valid address should be able to enter in the Company's Address field
    Then assert Valid information should be able to enter in the City, State, Zip field
    Then assert User should be able to select country from Country drop-down menu
    Then assert User should be able to enter phone number
    When user click on update or save company
    Then assert toast message as follow "Your company information has been updated"
    Then assert company name is the same as we change create on profile page
    Then assert address is the same as we change create on profile page
    Then assert city state zipcode is the same as we change create on profile page
    Then assert country is the same as we change create on profile page
    Then assert phone is the same as we change create on profile page
    When user goes to client page
    And click on view detail of client button
    And click on invoice
    Then assert address is the same as we change create on invoice
    Then assert city state zipcode is the same as we change create on invoice
    Then assert country is the same as we change create on invoice
#    Then assert phone is the same as we change create on invoice
    Then assert company name is the same as we change create on invoice

    Then assert Invoice Date must be functional and date selectable
    Then assert Due Date must be functional and date selectable
    Then assert Item name description should be enterable or selectable
    Then assert QTY(Quantity) field should be functional and number must be writable
    Then assert The Rate field should be functional and the number must be writable
    Then assert Amount field should be functional and give correct result
    Then assert Subb Total should be functional and give accurate result
    Then assert Salec Tax must be functional and give accurate results
    Then assert Total should  be functional and give accurate results
    Then assert Notes area should be  functional and writable
    Then assert The Terms & Conditions field should be functional and writable

