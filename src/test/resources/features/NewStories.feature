Feature: Manage Stories

  Background:
    Given I log in as "user1"
    And I click the create project button
    And I create a new project with fields:
      | name    | Public project |
      | account | newAccount     |
      | privacy | public         |

  @deleteProject
  Scenario: Create a new story
    When I click the add story button
    And I fill the story
    |title|storyTest|
    Then I verify if the story was created