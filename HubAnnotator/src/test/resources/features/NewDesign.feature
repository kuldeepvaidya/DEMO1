@DS-8
Feature: Sprint 1 Execution Set

    @App1 @Regression @Smoke @Highpriority @Swag
    Scenario: Verify Login Functionality
        Given User Login to application
        When User is navigated to Swag Labs
        Then Logout


    @App1 @Regression @Smoke @Highpriority @Swag
    Scenario: Verify new item is added in to the list
        Given User Login to application
        When User is navigated to Swag Labs
        Then Add product
        Then Logout

    @App1 @Regression @Smoke @Highpriority @Swag
    Scenario: Verify new item is added in to the list
        Given User Login to application
        When User is navigated to Swag Labs
        Then Add product
        Then Remove Product
        Then Logout

    @App1 @Regression @Smoke @Highpriority @Swag
    Scenario: Verify Shopping cart
        Given User Login to application
        When User is navigated to Swag Labs
        Then Add product
        Then Remove Product
        Then Navigate to Cart
        Then Logout