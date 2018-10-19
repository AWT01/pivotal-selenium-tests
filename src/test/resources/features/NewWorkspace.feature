Feature: Create a New Workspace

  @deleteWorkspace
  Scenario: Create a new workspace
    Given I log in as "user1"
    When I switch tab to workspaces
    And I click the create button
    And I create a new workspace with fields:
    |name | test |
    Then I verify if the workspace is created


