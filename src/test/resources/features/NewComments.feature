Feature: Manage comment

  Background:
    Given I log in as "user1"
    And I send a post request "/projects" with data:
      | name             | projectapi |
      | new_account_name | test       |
    And I verify the status code is "200"
    And I store the response as "Project1"
    And I send a post request "/projects/{Project1.id}/stories" with data:
      | name | storyapi |
    And I verify the status code is "200"
    And I store the response as "Story1"

  @deleteProject
  Scenario: Create a new comment
    When I open a project "Project1.name"
    And I open a story "Story1.name"
    And I create a new comment
      | comment | test comment |
    And I store the table as "Comment1"
    Then I verify if comment is "Comment1.comment"