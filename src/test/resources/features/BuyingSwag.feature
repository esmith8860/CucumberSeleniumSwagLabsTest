Feature: Swag Labs - Login

  Scenario: Validate Successful Login
    Given I am on the Swag Labs login page
    When I enter an accepted username
    And I enter a matching password
    And I click login
    Then the inventory page should be displayed