Feature: Manage Stories

  Background:
    Given I log in as "user1"
    And I send a post request "/projects" with data:
           | name              | projectapi |
           | new_account_name  | test       |
    And I verify the status code is "200"
    And I store the response as "Project1"

  @deleteProject
  Scenario: Create a new story
    When I open a project "Project1.name"
    And I click the add story button
    And I fill the story
    |story|storyTest|
    And I store the table as "Story1"
    Then I verify if the story is "Story1.story"