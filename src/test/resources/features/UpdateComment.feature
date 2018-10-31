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
    And I send a post request "/projects/{Project1.id}/stories/{Story1.id}/comments" with data:
      | title | comment Test |
    And I verify the status code is "200"
    And I store the response as "Comment1"

  @deleteProject
  Scenario: Update a comment
    When I open a project "Project1.name"
    And I open a story "Story1.name"
    And I click action menu
    And I click the edit button
    And I set the comment
      | comment | edit |
    And I save the comment
    Then I verify if the comment is "Comment1.comment"