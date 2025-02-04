Feature: Swag Labs - Buying Swag

  Scenario: Validate Successful Login
    Given I am on the Swag Labs login page
    When I enter an accepted username
    And I enter a matching password
    And I click login
    Then the inventory page should be displayed

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