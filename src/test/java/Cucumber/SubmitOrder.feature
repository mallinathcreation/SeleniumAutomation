
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file
  
Background:

Given: I landed on Ecommerce Page

  @Regression
  Scenario Outline: Postive test of Submitting the Order
  
    Given Loged in with username "<username>" and password "<password>"
    When  I add product "<productName>" to cart
    And Checkout "<productName>" and Submit
    Then "THANKYOU FOR THE ORDER." message is displayed on  Confirmation Page

    Examples: 
      | username  					| password 			| productName  |
      | joyee@gmail.com    | Joyee@007 	| ZARA COAT 3	|
      
