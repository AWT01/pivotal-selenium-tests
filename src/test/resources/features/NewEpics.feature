Feature: Manage Epics

  Background:
    Given I log in as "user1"
    And I send a post request "/projects" with data:
      | name              | projectapi |
      | new_account_name  | test       |
    And I verify the status code is "200"
    And I store the response as "Project1"
  @deleteProject
  Scenario: Create a new epic
    When I open a project "Project1.name"
    And I click the add epics button
    And I fill the epic
      | title | epicTest |
    And I store the table as "Epic1"
    Then I verify if epic title is "Epic1.title"
