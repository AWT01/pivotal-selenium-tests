$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/NewEpics.feature");
formatter.feature({
  "name": "Manage Epics",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "I create a new project using API",
  "keyword": "Given "
});
formatter.match({
  "location": "CommonSteps.iCreateNewProject()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I log in as \"user1\"",
  "keyword": "And "
});
formatter.match({
  "location": "CommonSteps.iLogInAs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I open the project created with API:",
  "keyword": "And "
});
formatter.match({
  "location": "CommonSteps.iOpenProjectCreatedWithAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click the add epics button",
  "keyword": "And "
});
formatter.match({
  "location": "EpicsSteps.iClickAddEpicsButton()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Create a new epic",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@deleteProject"
    }
  ]
});
formatter.step({
  "name": "I click the add epics button",
  "keyword": "When "
});
formatter.match({
  "location": "EpicsSteps.iClickAddEpicsButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I fill the epic",
  "rows": [
    {
      "cells": [
        "title",
        "epicTest"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "EpicsSteps.iFillStoryTitle(String,String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify if the epic was created",
  "keyword": "Then "
});
formatter.match({
  "location": "EpicsSteps.iVerifyIfStoryWasCreated()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});