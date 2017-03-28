Feature: Login application

Scenario: Successful Login the application
    Given User is on the index page
    When User Navigate to the login page
    And User enter Username and Password
    Then Welcome message displayed 