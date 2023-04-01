#Feature: Supplier portal
#  @Regression @Smoke @TC1 @UI @DSP1  @ABCD
#  Scenario Outline: Validate the fields in DAIMLER TRUCK SUPPLIER PORTAL
#Given User Logins to supplier portal Using "<FileName>" "<Scenario>"
#    When User is on Home page
#    Then Validating the  Homepage field
#    Then Validating the procurement field
#    Then Validating the Collaboration field
#    Then Validating the Sustainability field
#    Then Validating the Support field
#    Then logs out of Supplier Portal
#
#    Examples:
#      | FileName    | Scenario |
#      | DSPTestdata | TC01     |
#
#  @Regression @Smoke @TC1 @UI @DSP @ABCD
#  Scenario Outline: Login using  Invalid Credentials
#    Given Validating login using invalid credentials "<FileName>" "<Scenario>"
#    Examples:
#      | FileName    | Scenario |
#      | DSPTestdata | TC02     |
#
#  @Regression @Smoke @TC1 @UI @DSP @ABCD
#  Scenario Outline: Login using  Invalid Credentials
#    Given Validating login using invalid credentials "<FileName>" "<Scenario>"
#    Examples:
#      | FileName    | Scenario |
#      | DSPTestdata | TC02     |
#
#  @Regression @Smoke @TC1 @UI @DSP
#  Scenario Outline: Validate subsidiaries_icons
#    Given User Logins to supplier portal  "<FileName>" "<Scenario>"
#    And validate subsidiaries icons
#    Examples:
#      | FileName    | Scenario |
#      | DSPTestdata | TC01     |
#  @Regression @Smoke @TC1 @UI @DSP
#  Scenario Outline: Validate SiteNavigationFooterMenu
#    Given User Logins to supplier portal with "<FileName>" "<Scenario>"
#    And validate SiteNavigationFooterMenu
#    Examples:
#      | FileName            | Scenario |
#      | LoginSupplierPortal | TC01     |
#  @Regression @Smoke @TC1 @UI @DSP
#  Scenario Outline:
#    Given validate Header Items Guest by using "<FileName>" "<Scenario>"
#    Examples:
#      | FileName            | Scenario |
#      | LoginSupplierPortal | TC01     |