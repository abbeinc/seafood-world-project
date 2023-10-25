@regression
Feature: User should be able to choose food and place order online
Background:
  Given user at the Order Online page

  Scenario: user choosing dinner and place an order
     When user click Dinner Plate
    And choose Large Shrimp and choosing option (grilled) and side (asparagus) press Add to cart
    Then user should see his order in the cart
    And total price should be the sum of subtotal prices plus 11% tax

    Scenario: user choose two dinners and place an order
       When user click Dinner Plate
      And choose Large Shrimp and choosing option (grilled) and side (asparagus) press Add to cart
      And choose Chicken Tenders and choosing option (broccoli)
      Then user should see his two orders
      And user should see his correct total prices with 11% tax

      Scenario: user choose two appetizers and place an order
        When user click Appetizers and and choose Buffalo Chicken Wings
        And user pick "Spicy Hot Sauce" and "Blue Cheese"
        And choose 2 plates and click Add to cart and  view Cart
        Then total price will be subtotal plus 11% tax



