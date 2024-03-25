Feature: Testing of Registration form

  Background:
    Given set up driver for Editing test

  @Editing
  Scenario Outline: Test editing of the field New Password an logging in with the new password
    Given User is on Log in Page for logging in and further editing
    When I enter valid email of an already registered user "<email>"
    And I enter valid password of an already registered user "<oldPassword>"
    And I click button Submit to log in
    And I click the link Edit account
    And I input new password in the field Password "<newPassword>"
    And I input the same new password in the field Password Confirmation "<newPassword>"
    And I click button Submit to confirm the changing of password
    And I click link Logout on Account Page
    And I confirm logging out pressing Yes on the alert message
    And I enter valid email of an already registered user "<email>"
    And I enter new password of an already registered user "<newPassword>"
    And I click button Submit to log in
    Then I see a logged-in Account Page with my name and email after logging in with new password
    Examples:
      | email        | oldPassword | newPassword |
      | a104@aaa.aaa | 111111111   | 222222222   |