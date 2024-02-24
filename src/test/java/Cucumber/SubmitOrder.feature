
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

	Background:
	Given I landed on Ecommerce Website

  @tag2
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username <name> and <password>
    When I add product <productName> to cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | name  								 | 	password 		| productName |
      | Automation12@gmail.com |  Roshan@1234 | ADIDAS ORIGINAL |
     
