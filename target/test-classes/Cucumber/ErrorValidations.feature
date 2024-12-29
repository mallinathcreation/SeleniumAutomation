
@tag
Feature: Error Validations
  I want to use this template for my feature file

  @ErrorValidations
  Scenario Outline: Negative Test of Login
    Given I landed on Ecommerce Page
    When Loged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

   Examples: 
      | name  						|  password 		|
      | joyee@gmail.commm |    Joyee@0077 	| 
