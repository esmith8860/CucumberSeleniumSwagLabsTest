Feature: Swag Labs - Buying Swag

  Background:
    Given I am on the Swag Labs Home Page

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
  @ListIterator
  Scenario: Validate Successful Purchase with Inputs through a List Iterator
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

  @buying_swag
  @ListUsingGetMethod
  Scenario: Validate Successful Purchase with Inputs through an Array List
    Given I successfully login
    When I click on Add to cart
    And I click on Your Cart
    And I click on Checkout
    And I input the following data on Checkout Your Information page
      | Ashley  |
      | Brown   |
      | 11111   |
    And I click Continue
    And I click Finish
    Then I should be presented with a Thank You message

  @buying_swag
  @Stream
  Scenario: Validate Successful Purchase with Inputs through a Stream
    Given I successfully login
    When I click on Add to cart
    And I click on Your Cart
    And I click on Checkout
    And I complete the following data on Checkout Your Information page
      | Marty  |
      | Smith  |
      | 22222  |
    And I click Continue
    And I click Finish
    Then I should be presented with a Thank You message

  @buying_swag
  @AllItems
  Scenario: Validate the correct price of all items added to the cart
    Given I successfully login
    When I click on all of the items
    And I click on Your Cart
    And I click on Checkout
    And I enter the following data on Checkout Your Information page
      | John  |
      | Doe   |
      | 00000 |
    And I click Continue
    Then I should be presented with the correct total

  @buying_swag
  @AllItemsDeselected
  Scenario: Validate the items are showing add to cart after being deselected
    Given I successfully login
    When I click on all of the items
    And I click on Your Cart
    And I remove all items from Your Cart
    And I click Continue Shopping
    Then all items should show Add to cart