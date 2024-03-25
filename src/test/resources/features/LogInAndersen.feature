Feature: Testing of Log in form

  Background:
    Given set up driver for Login test

  @Login
  Scenario Outline: Test Logging in with an empty form
    Given User is on Log in Page for logging in
    When I don't enter any data in Email field "<email>"
    And I don't enter any data in Password field "<password>"
    And I click button Sign In
    Then I see an error message
    Examples:
      | email | password |
      |       |          |