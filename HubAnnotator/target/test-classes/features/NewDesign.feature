@DS-8
Feature: Sprint 1 Execution Set

#@App1 @Regression @Smoke @Highpriority @Swag
#Scenario: Verify Login functionality
#    Given User Login to application

    @App1 @Regression @Smoke @Highpriority @Swag
    Scenario: Verify new item is added in to the list
        Given User Login to application
        When User is navigated to Swag Labs
        Then Add product
        Then Logout


    @App1 @Regression @Smoke @Highpriority @Swag
    Scenario: Verify new item is added in to the list and Removed from the list
        Given User Login to application
        When User is navigated to Swag Labs
        Then Add product
        Then Remove Prouct
        Then Logout

    @App1 @Regression @Smoke @Highpriority @Swag
    Scenario: Verify new item is added in to the list and Removed from the list and verify Cart
        Given User Login to application
        When User is navigated to Swag Labs
        Then Add product
        Then Remove Prouct
        Then Navigate to Cart
        Then Logout