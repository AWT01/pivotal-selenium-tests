Feature: Manage Stories

  Background:
    Given I log in as "user1"
    And I send a post request "/projects" with data:
    | name              | projectapi |
    | new_account_name  | test       |
    And I verify the status code is "200"
    And I store the response as "Project1"
    And I send a post request "/projects/{Project1.id}/stories" with data:
    |name|storyTest|
    And I verify the status code is "200"
    And I store the response as "Story1"

  @deleteProject
  Scenario: Update a story
    When I open a project "Project1.name"
    And I click the story
    And I fill the story
    |story|edited|
    And I store the table as "Story1"
    Then I verify if the story is "Story1.story"