@RaraliQATeam
Feature: eCommerceApp Shop page

  @DoTest
  Scenario: Adding one shopping item to cart
    When Launch eCommerceApp Shop page
    And Add an item to the cart
    Then The item should be added to cart
    
  @DoTest
  Scenario: Remove one item from cart
    When Launch eCommerceApp home page
    And Add item to cart
    And Navigate to cart page
    And Remove item from cart
    Then The toast should show item removed
    
  @DoTest
  Scenario: Clear Cart
    When Launch eCommApp home page
    And Add item to cart three times
    And Navigate to the cart page
    And Click clear cart button
    Then The toast should show cart is cleared
    
   @DoTest
  Scenario: Checkout
    When Launch eCommApp
    And Add three items to cart
    And Nav to the cart page
    And Click checkout button
    Then The toast should show checkout occurred