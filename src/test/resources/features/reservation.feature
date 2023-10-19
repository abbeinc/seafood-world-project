@single
Feature: user should be able to reserve a table online
  Background:
    Given user at the contact page

  Scenario: user fill up all the fields and send reservation

    When user enters name, email, message and click send
    Then user should see message

  Scenario: user fill up all fields except Name
    When user enters email, message and click send
    Then user should see warning message

  Scenario: user fill up all fields except Email
    When user enters name, message and click send
    Then user should see warning message

  Scenario: user fill up all fields except text Msg
    When user enters name, email  and click send
    Then user should see message


  Scenario: user does not fill up any fields and click submit
    When user click send button
    Then user should see warning message


  Scenario Outline: user can't send message if email is not correct
    When user enters name, "<email>", message and click send
    Then user should see warning message
    Examples:
      | email               |
      | @gmail.com          |
      | name@.com           |
      | namegmail.com       |
      | name@@gmail.com     |
      | name@gmail.com.     |
      | name@name@gmail.com |
      | name@gmail          |

    Scenario: user should see on contact page correct address, opening hours and phone number
      When user scroll page down
      Then user should see correct information

    Scenario: user should see map on the contact page
      When user scroll all the way down
      Then user should see map

      Scenario: user should see facebook picture link
        When user click on the facebook picture link
        Then user should see Facebook page