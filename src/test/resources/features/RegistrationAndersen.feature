Feature: Testing of Registration form

  Background:
    Given set up driver for Registration test

  @Registration
  Scenario Outline: Test registration of a non-existent user positive
    Given User is on Log in Page
    When I click button Registration
    And I enter first name in the field First Name "<firstName>"
    And I enter last name in the field Last Name "<lastName>"
    And I input date of birth in the field Date of Birth "<dateOfBirth>"
    And I input email in the field Email "<email>"
    And I input password in the field Password "<password>"
    And I input the same password in the field Password Confirmation "<passwordConfirmation>"
    And I click button Submit
    Then I see a logged-in Account Page with my name and email
    Examples:
      | firstName | lastName | dateOfBirth | email        | password  | passwordConfirmation |
      | Sam       | Smith    | 01.01.2000  | a104@aaa.aaa | 111111111 | 111111111            |