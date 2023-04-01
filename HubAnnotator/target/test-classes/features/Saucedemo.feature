@JX-30
Feature: Swaglabs Website

	@TEST_JX-24 @TESTSET_JX-29
#	Scenario: login page
		Scenario Outline: login page
		    Given i am an existing user
		    When i open browser to "<url>": www.saucedemo.com
		    And fill correct username as "<Username>" and password as "<password>"
		    And press login button
		    Then i see my application dashboard
		    Examples:
		      |             url               | Username | password |
		      |   https://www.saucedemo.com/  |standard_user |   secret_sauce  |
	@TEST_JX-25 @TESTSET_JX-29
	Scenario: Verify Shopping cart
		Given Check all the products
		  And Select the product that you want to order
		  When Click on Add to cart
		  And it will add all your products in shopping cart
		  Then Click on shopping cart icon
	@TEST_JX-26 @TESTSET_JX-29
	Scenario: Continue Shopping
		Given Add another item
		    Then Checkout the product
		    And remove Item from cart
	@TEST_JX-27 @TESTSET_JX-29
	Scenario: Finishing order process
		Given Enter address information
		    Then Click Finish
	@TEST_JX-28 @TESTSET_JX-29
	Scenario: Logout from page
		Given goto react button
		    Then click logout
		    And Close Browser
		Scenario: Update Jira
			Given Token is Available

