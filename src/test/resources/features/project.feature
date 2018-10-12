Feature: Project

  Scenario: Project creation within pivotal application
    Given I log in as "hapsneeze" "test12345"
    When I create a new project with name "ProjectCucumber" with privacy set to "false"
    Then The project is created