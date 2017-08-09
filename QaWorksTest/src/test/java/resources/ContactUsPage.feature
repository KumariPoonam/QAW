Feature: Testing the Contact Page

  Scenario Outline: Valid Submission

    Given I am on homepage
    And   I have navigate to the Contact page
    And   I enter Name field with "<name>"
    And   I enter Email field with "<email>"
    And   I enter Message field with"<message>"
    And   I click on the Send button
    Then  I see that the message has been sent
    Examples:
      | name    | email                | message                                   |
      | jbloggs | j.bloggs@qaworks.com | Please contact me I want to find out more |

