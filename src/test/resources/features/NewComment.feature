Feature: Manage comment

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

  @deleteProject
  Scenario: Create a new comment
    When I open a project "Project1.name"
    And I click the add story button
    And I set the comment
    |comment|test comment|
    And I save the comment
    Then I verify if the comment was created
    |comment|test comment|