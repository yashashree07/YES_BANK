$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/resources/Features/TC04-PurposeCode.feature");
formatter.feature({
  "name": "To test Functionality of Purpose Code Menu",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Version1.0"
    },
    {
      "name": "@Regression_Pack_PurposeCode_Menu"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Testing of List functionality for Purpose Code Menu",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@TC04_07_PurposeCode_List"
    }
  ]
});
formatter.step({
  "name": "User navigates to Application, Master Data Maintenance selects Purpose Code menu and clicks on sub option List",
  "keyword": "Given "
});
formatter.step({
  "name": "User provides the valid record details using Sheet \"\u003cSheetName\u003e\" to view the required record",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "SheetName"
      ]
    },
    {
      "cells": [
        "PurposeCode_ModifyApproveList"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Testing of List functionality for Purpose Code Menu",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Version1.0"
    },
    {
      "name": "@Regression_Pack_PurposeCode_Menu"
    },
    {
      "name": "@TC04_07_PurposeCode_List"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User navigates to Application, Master Data Maintenance selects Purpose Code menu and clicks on sub option List",
  "keyword": "Given "
});
formatter.match({
  "location": "PurposeCodeStepDefination.user_navigates_to_Application_Master_Data_Maintenance_selects_Purpose_Code_menu_and_clicks_on_sub_option_List()"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchFrameException: No frame element found by name or id toc\nBuild info: version: \u00273.14.0\u0027, revision: \u0027aacccce0\u0027, time: \u00272018-08-02T20:05:20.749Z\u0027\nSystem info: host: \u0027DESKTOP-02413D4\u0027, ip: \u0027172.24.192.1\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_221\u0027\nDriver info: driver.version: unknown\r\n\tat org.openqa.selenium.remote.RemoteWebDriver$RemoteTargetLocator.frame(RemoteWebDriver.java:881)\r\n\tat com.yesbank.qa.util.ElementUtil.GoToFrame(ElementUtil.java:47)\r\n\tat com.yesbank.qa.stepDefination.PurposeCodeStepDefination.user_navigates_to_Application_Master_Data_Maintenance_selects_Purpose_Code_menu_and_clicks_on_sub_option_List(PurposeCodeStepDefination.java:62)\r\n\tat ✽.User navigates to Application, Master Data Maintenance selects Purpose Code menu and clicks on sub option List(file:src/main/resources/Features/TC04-PurposeCode.feature:64)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "User provides the valid record details using Sheet \"PurposeCode_ModifyApproveList\" to view the required record",
  "keyword": "Then "
});
formatter.match({
  "location": "PurposeCodeStepDefination.user_provides_the_valid_record_details_using_Sheet_to_view_the_required_record(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});