Feature: Manage Epics

  Background:
    Given I log in as "user3"
    And I send a post request "/projects" with data:
      | name    | projectapi |
      | account | newAccount |
    And I verify the status code is "200"
    And I store the response as "Project1"
    And I send a post request "/projects/{Project1.id}/stories" with data:
      | name | storyapi |
    And I verify the status code is "200"
    And I store the response as "Story1"
    And I send a post request "/projects/{Project1.id}/stories/{Story1.id}/tasks" with data:
      | name | taskapi |
    And I verify the status code is "200"
    And I store the response as "Task1"

  @deleteProject
  Scenario: Create a new epic
    When I open a project "{Project1.name}"
    And I click the add epics button
    And I fill the epic
      | title | epicTest |
    And I store the table as "Epic1"
    Then I verify if the epic was created
    And I verify the "title" is "{Epic1.title}"
