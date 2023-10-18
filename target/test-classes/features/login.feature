
Feature: User should be able to use login function
  Scenario: user enters registered email and valid password
    Given user at the My Account page
    When user enters registered email and password
    Then user should see his account

    Scenario: user enters not registered email and password
      Given user at the My Account page
      When user enters not registered email and password and press login
      Then user should not be able to login


