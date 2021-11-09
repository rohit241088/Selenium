Feature: Search feature

  Scenario Outline: Search and verify results
    Given I am on Search page
    When I search for the <value>
    Then I verify the <status>

    Examples: 
      | value          | status  |
      | "Rohit Sharma" | success |
