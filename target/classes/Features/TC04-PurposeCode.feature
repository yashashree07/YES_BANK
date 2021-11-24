#Author: 

@Version1.0
@Regression_Pack_PurposeCode_Menu
Feature: To test Functionality of Purpose Code Menu

@TC04_01_PurposeCode_Enter_ValidData
Scenario Outline: Testing of Enter functionality With Valid Data for Purpose Code Menu
Given User navigates to Application, Master Data Maintenance selects Purpose Code menu and clicks on sub option Enter
Then User provides the valid record details using Sheet "<SheetName>" clicks on Ok button and then on Submit button

Examples:
|SheetName                    |
|PurposeCode_EnterApproveList | 

@TC04_02_PurposeCode_Approve_Reject
Scenario Outline: Testing of Approve,Reject functionality for Purpose Code Menu
Given User navigates to Application, Master Data Maintenance selects Purpose Code menu and clicks on sub option Approve
Then User provides the valid record details using Sheet "<SheetName>" and approves OR Rejects the required record

Examples:
|SheetName                    |
|PurposeCode_EnterApproveList | 

@TC04_03_PurposeCode_List
Scenario Outline: Testing of List functionality for Purpose Code Menu
Given User navigates to Application, Master Data Maintenance selects Purpose Code menu and clicks on sub option List
Then User provides the valid record details using Sheet "<SheetName>" to view the required record

Examples:
|SheetName                    |
|PurposeCode_EnterApproveList | 

@TC04_04_PurposeCode_Enter_InvalidData
Scenario Outline: Testing of Enter functionality With Invalid Data for Purpose Code Menu
Given User navigates to Application, Master Data Maintenance selects Purpose Code menu and clicks on sub option Enter
Then User provides the Invalid record details using Sheet "<SheetName>" for checking field level validation

Examples:
|SheetName                    |
|PurposeCodeEnter_InvaliData  | 


@TC04_05_PurposeCode_Modify_ValidData
Scenario Outline: Testing of Modify functionality With Valid Data for Purpose Code Menu
Given User navigates to Application, Master Data Maintenance selects Purpose Code menu and clicks on sub option Modify
Then User provides the valid record details using Sheet "<SheetName>" for record modification

Examples:
|SheetName                     |
|PurposeCode_ModifyApproveList | 

@TC04_06_PurposeCode_Approve_Reject
Scenario Outline: Testing of Approve,Reject functionality for Purpose Code Menu
Given User navigates to Application, Master Data Maintenance selects Purpose Code menu and clicks on sub option Approve
Then User provides the valid record details using Sheet "<SheetName>" and approves OR Rejects the required record

Examples:
|SheetName                     |
|PurposeCode_ModifyApproveList | 

@TC04_07_PurposeCode_List
Scenario Outline: Testing of List functionality for Purpose Code Menu
Given User navigates to Application, Master Data Maintenance selects Purpose Code menu and clicks on sub option List
Then User provides the valid record details using Sheet "<SheetName>" to view the required record

Examples:
|SheetName                    |
|PurposeCode_ModifyApproveList| 

@TC04_08_PurposeCode_Modify_InvalidData
Scenario Outline: Testing of Modify functionality With Invalid Data for Purpose Code Menu
Given User navigates to Application, Master Data Maintenance selects Purpose Code menu and clicks on sub option Modify
Then User provides the Invalid record details using Sheet "<SheetName>" for Modify operation

Examples:
|SheetName                     |
|PurposeCode_ModifyInvalidData | 


@TC04_09_PurposeCode_Delete
Scenario Outline: Testing of Delete functionality With Valid Data for Purpose Code Menu
Given User navigates to Application, Master Data Maintenance selects Purpose Code menu and clicks on sub option Delete
Then User provides the valid record details using Sheet "<SheetName>" to Delete the required record

Examples:
|SheetName                     |
|PurposeCode_DeleteApproveList |

@TC04_10_PurposeCode_Approve_Reject
Scenario Outline: Testing of Approve,Reject functionality for Purpose Code Menu
Given User navigates to Application, Master Data Maintenance selects Purpose Code menu and clicks on sub option Approve
Then User provides the valid record details using Sheet "<SheetName>" and approves OR Rejects the required record

Examples:
|SheetName                     |
|PurposeCode_DeleteApproveList | 

@TC04_11_PurposeCode_List
Scenario Outline: Testing of List functionality for Purpose Code Menu
Given User navigates to Application, Master Data Maintenance selects Purpose Code menu and clicks on sub option List
Then User provides the valid record details using Sheet "<SheetName>" to view the required record

Examples:
|SheetName                    |
|PurposeCode_DeleteApproveList| 

