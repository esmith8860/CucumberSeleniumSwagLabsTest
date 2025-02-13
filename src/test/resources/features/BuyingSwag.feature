Feature: Swag Labs - Buying Swag

  @login
  Scenario: Validate Successful Login
    Given I am on the Swag Labs login page
    When I enter an accepted username
    And I enter a matching password
    And I click login
    Then the inventory page should be displayed

  @buying_swag
  Scenario: Validate Successful Purchase
    Given I successfully login
    When I click on Add to cart
    And I click on Your Cart
    And I click on Checkout
    And I enter a first name
    And I enter a last name
    And I enter a zip code
    And I click Continue
    And I click Finish
    Then I should be presented with a Thank You message

  @login
  Scenario: Validate Successful Login with Credentials
    Given I am on the Swag Labs login page
    When I enter "standard_user" as the username
    And I enter "secret_sauce" as the password
    And I click login
    Then the inventory page should be displayed

  @buying_swag
  Scenario: Validate Successful Purchase with Inputs
    Given I successfully login
    When I click on Add to cart
    And I click on Your Cart
    And I click on Checkout
    And I enter the following data on Checkout Your Information page
      | John  |
      | Doe   |
      | 00000 |
    And I click Continue
    And I click Finish
    Then I should be presented with a Thank You message