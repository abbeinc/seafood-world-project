
Feature: User should be able to create account
  Scenario: user can register  with the valid username, email and a password
    Given user at the My Account page
    When user enters valid username, email and click register button
    Then user should see message Hello username
    And user can edit password and account
