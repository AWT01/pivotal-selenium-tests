Feature: Create a New Workspace

  @deleteWorkspace
  Scenario: Create a new workspace
    Given I log in as "user1"
    When I switch tab to workspaces and click the create button
    And I fill the fields of Create new workspace and press the create button
    |name | test |
    Then I verify if the workspace is created


