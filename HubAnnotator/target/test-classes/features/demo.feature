@DS-8
Feature: Sprint 1 Execution Set

	@TEST_DS-1 @TESTSET_DS-7 @App1 @Regression @Smoke

	Scenario Outline: Verify Login Functionality
		Given i am an existing user
	    When i open browser to "<url>": www.saucedemo.com
	    And fill correct username as "<Username>" and password as "<password>"
	    And press login button
	    Then i see my application dashboard

	    Examples:
		|             url               | Username     | password        |
		|   https://www.saucedemo.com/  |standard_user |   secret_sauce  |

	@TEST_DS-2 @TESTSET_DS-7 @App1 @Regression
	Scenario: Verify Shopping cart
		Given Check all the products
		And Select the product that you want to order
		When Click on Add to cart
		And it will add all your products in shopping cart
		Then Click on shopping cart icon

	@TEST_DS-3 @TESTSET_DS-7 @App1 @Purchase @Regresssion @Smoke
	Scenario: Verify that User is able to buy products
		Given Add another item
		Then Checkout the product
		And remove Item from cart

	@TEST_DS-4 @TESTSET_DS-7 @App1 @Smoke
	Scenario: Verify Transaction details
		Given Enter address information
		Then Click Finish

	@TEST_DS-5 @TESTSET_DS-7 @App1 @Regression @Smoke
	Scenario: Verify Session is closed
		Given goto react button
		Then click logout
		And Close Browser
