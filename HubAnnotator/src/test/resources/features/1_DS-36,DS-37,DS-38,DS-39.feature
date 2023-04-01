@DS-35
Feature: Sprint 2 Execution Set

	@TEST_DS-36 @App1 @Highpriority @Regression @Smoke @Swag
	Scenario: Verify Login Functionality
		Given User Login to application
		When User is navigated to Swag Labs
		Then Logout
	@TEST_DS-37 @App1 @Highpriority @Regression @Smoke @Swag
	Scenario: Verify new item is added in to the list
		Given User Login to application
		When User is navigated to Swag Labs
		Then Add product
		Then Logout
	@TEST_DS-38 @App1 @Highpriority @Regression @Smoke @Swag
	Scenario: Verify new item is added in to the list
		Given User Login to application
		When User is navigated to Swag Labs
		Then Add product
		Then Remove Product
		Then Logout
	@TEST_DS-39 @App1 @Highpriority @Regression @Smoke @Swag
	Scenario: Verify Shopping cart
		Given User Login to application
		When User is navigated to Swag Labs
		Then Add product
		Then Remove Product
		Then Navigate to Cart
		Then Logout
