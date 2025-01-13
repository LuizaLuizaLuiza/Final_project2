Feature: Buy products on website

  Scenario: User buy products in MyStore shop
    Given I'm logged in to My Store shop
    When I go to clothes tab
    And I choose product
    And I choose size
    And I choose quantity
    And I add product to the cart
    And I go to cart
    And I go to checkout
    And I confirm the address
    And I choose shipping method
    And I choose payment method
    And I agree terms
    And I confirm order
#    Then make screenshot
    And close browser
