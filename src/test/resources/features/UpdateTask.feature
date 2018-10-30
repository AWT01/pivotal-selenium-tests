Feature: Manage task

  Background:
    Given I log in as "user1"
    And I send a post request "/projects" with data:
    | name              | projectapi |
    | new_account_name  | test       |
    And I verify the status code is "200"
    And I store the response as "Project1"
    And I send a post request "/projects/{Project1.id}/stories" with data:
    |title|storyTest|
    And I verify the status code is "200"
    And I store the response as "Story1"
    And I send a post request "/projects/{Project1.id}/stories/{Story1.id}/tasks" with data:
    |title|taskTest|
    And I verify the status code is "200"
    And I store the response as "Task1"

  @deleteProject
  Scenario: Update task
    When I open a project "Project1.name"
    And I click the story
    And I select the task
    And I set the name of the task
      |title|edited|
    And I save the task
    Then I verify if the task was created
      |title|taskTestedited|