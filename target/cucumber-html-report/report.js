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
  "name": "Testing of Delete functionality With Valid Data for Purpose Code Menu",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@TC04_09_PurposeCode_Delete"
    }
  ]
});
formatter.step({
  "name": "User navigates to Application, Master Data Maintenance selects Purpose Code menu and clicks on sub option Delete",
  "keyword": "Given "
});
formatter.step({
  "name": "User provides the valid record details using Sheet \"\u003cSheetName\u003e\" to Delete the required record",
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
        "PurposeCode_DeleteApproveList"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Testing of Delete functionality With Valid Data for Purpose Code Menu",
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
      "name": "@TC04_09_PurposeCode_Delete"
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
  "name": "User navigates to Application, Master Data Maintenance selects Purpose Code menu and clicks on sub option Delete",
  "keyword": "Given "
});
formatter.match({
  "location": "PurposeCodeStepDefination.user_navigates_to_Application_Master_Data_Maintenance_selects_Purpose_Code_menu_and_clicks_on_sub_option_Delete()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User provides the valid record details using Sheet \"PurposeCode_DeleteApproveList\" to Delete the required record",
  "keyword": "Then "
});
formatter.match({
  "location": "PurposeCodeStepDefination.user_provides_the_valid_record_details_using_Sheet_to_Delete_the_required_record(String)"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:51)\r\n\tat com.sun.proxy.$Proxy16.click(Unknown Source)\r\n\tat com.yesbank.qa.util.ElementUtil.clickElement(ElementUtil.java:37)\r\n\tat com.yesbank.qa.pages.PurposeCodePage.deletepurposeCodeRecord(PurposeCodePage.java:497)\r\n\tat com.yesbank.qa.stepDefination.PurposeCodeStepDefination.user_provides_the_valid_record_details_using_Sheet_to_Delete_the_required_record(PurposeCodeStepDefination.java:86)\r\n\tat ✽.User provides the valid record details using Sheet \"PurposeCode_DeleteApproveList\" to Delete the required record(file:src/main/resources/Features/TC04-PurposeCode.feature:84)\r\n",
  "status": "failed"
});
formatter.after({
  "error_message": "org.openqa.selenium.NoSuchWindowException: no such window: target window already closed\nfrom unknown error: web view not found\n  (Session info: chrome\u003d96.0.4664.45)\nBuild info: version: \u00273.14.0\u0027, revision: \u0027aacccce0\u0027, time: \u00272018-08-02T20:05:20.749Z\u0027\nSystem info: host: \u0027DESKTOP-02413D4\u0027, ip: \u0027172.24.192.1\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_221\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 96.0.4664.45, chrome: {chromedriverVersion: 96.0.4664.45 (76e4c1bb2ab46..., userDataDir: C:\\Users\\Lenovo\\AppData\\Loc...}, goog:chromeOptions: {debuggerAddress: localhost:62169}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:virtualAuthenticators: true}\nSession ID: 5858de9d04ae4d2d58f821409b12e672\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:548)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:605)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.getScreenshotAs(RemoteWebDriver.java:294)\r\n\tat com.yesbank.qa.stepDefination.Hooks.tearDown(Hooks.java:71)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:65)\r\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\r\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:65)\r\n\tat cucumber.runner.TestStep.run(TestStep.java:50)\r\n\tat cucumber.runner.TestCase.run(TestCase.java:50)\r\n\tat cucumber.runner.Runner.runPickle(Runner.java:50)\r\n\tat io.cucumber.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:68)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:23)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:144)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:65)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat io.cucumber.junit.Cucumber$RunCucumber.evaluate(Cucumber.java:174)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:89)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:41)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:542)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:770)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:464)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:210)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
});