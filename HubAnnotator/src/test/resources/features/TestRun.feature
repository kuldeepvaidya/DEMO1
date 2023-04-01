#@DS-8
#Feature: Swaglabs Website
#@TEST_DS-1 @TESTSET_DS-7
#Scenario Outline: login page
#			Given i am an existing user
#			When i open browser to "<url>": www.saucedemo.com
#			And fill correct username as "<Username>" and password as "<password>"
#			And press login button
#			Then i see my application dashboard
#			Examples:
#			  |             url               | Username | password |
#			  |   https://www.saucedemo.com/  |standard_user |   secret_sauce  |
#	@TEST_DS-2 @TESTSET_DS-7
#	Scenario: Verify Shopping cart
#		Given Check all the products
#				  And Select the product that you want to order
#				  When Click on Add to cart
#				  And it will add all your products in shopping cart
#				  Then Click on shopping cart icon
#	@TEST_DS-3 @TESTSET_DS-7
#	Scenario: Continue Shopping
#		Given Add another item
#				    Then Checkout the product
#				    And remove Item from cart
#	@TEST_DS-4 @TESTSET_DS-7
#	Scenario: Finishing order process
#		Given Enter address information
#				    Then Click Finish
#	@TEST_DS-5 @TESTSET_DS-7
#	Scenario: Logout from page
#		Given goto react button
#				    Then click logout
#				    And Close Browser
#
##	@TEST_DS-6 @TESTSET_DS-7
##	Scenario: Update Jira
##		Given Token is Available
