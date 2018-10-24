Feature: Manage Epics

  Background:
    Given I log in as "user1"
    And I click the create project button
    And I create a new project with fields:
      | name    | Public project |
      | account | newAccount     |
      | privacy | public         |

  @deleteProject
  Scenario: Create a new epic
    When I click the add epics button
    And I fill the epic
      |title|epicTest|
    Then I verify if the epic was created
