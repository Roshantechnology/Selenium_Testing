
@tag
Feature: Error Validation
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce Website
    When Logged in with username <ename> and <password>
    Then "Incorrect email or password." message is displayed

   Examples: 
      | ename  								 | 	password 		| 
      | Autom@gmail.com |  Roshan1234 | 
     
