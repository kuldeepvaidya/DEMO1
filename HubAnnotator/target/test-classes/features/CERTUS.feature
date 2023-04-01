#Feature: CERTUS Application
#
#  @Regression @Smoke @TC1 @UI @High @certus @componentcertificate
#  Scenario Outline: Submitting component certificate
#    Given The supplier logs into CERTUS application using "<FileName>" "<Scenario>"
#    When the supplier selects a part number and assigns to a new document "<FileName>" "<Scenario>"
##    And the supplier fills in the metadata details and submits for approval
##    Then the status of the document is In Approval
##    And the supplier logs out of the application
#
#    Examples:
#      | FileName       | Scenario |
#      | CertusTestData | TC001    |
