Feature: User Registration
  As a user
  I want to register successfully on the Jumia website
  So that I can access my account and make purchases

  Scenario: User Registration
    Given the user is on the Jumia homepage
    When the user clicks on the "Account" button
    And selects the "Sign In" option
    And fills in all the required personal data
    And clicks on the "Register" button
    Then the user should receive a successfully registered message