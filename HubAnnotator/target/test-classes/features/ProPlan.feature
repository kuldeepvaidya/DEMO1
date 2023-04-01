#Feature: proPlan Application
#  @Regression @Smoke @TC1 @UI @High @proPlan @Search
#  Scenario Outline: Planning and Awarding Contract
#    Given The buyer logs "<FileName>" "<Scenario>" into proPlan home page
#    When The buyer creates sourcing bundle
#    Then The buyer drafts the plan for sourcing bundle
#    Then buyer starts planning
#    Then buyer starts RFQ
#    Then Bidding by supplier is started
#    Then Negotiations with supplier
#    Then Contract awarding to supplier
#    Then The buyer logsout of the ProPlan application
#    Then The buyer closes the ProPlan Application
#
#    Examples:
#      |FileName           |Scenario |
#      |LoginproPlan       |TC001    |