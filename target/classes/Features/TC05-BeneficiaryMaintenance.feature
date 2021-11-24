#Author: 

@Version1.0
@Regression_Pack_BeneficiaryMaintenance_Menu
Feature: To test Functionality of Beneficiary Maintenance Menus

@TC05_01_BeneficiaryMaintenance_Enter_ValidData
Scenario Outline: Testing of Enter functionality With Valid Data for Beneficiary Maintenance Menu
Given User navigates to Application, Master Data Maintenance selects Beneficiary Maintenance menu and clicks on sub option Enter
Then User provides the valid beneficiary record details using Sheet "<SheetName>" clicks on Ok button and then on Submit button

Examples:
|SheetName                     |
|BeneMaintain_EnterApproveList | 

@TC05_02_BeneficiaryMaintenance_Approve_Reject
Scenario Outline: Testing of Approve,Reject functionality for Beneficiary Maintenance Menu
Given User navigates to Application, Master Data Maintenance selects Beneficiary Maintenance menu and clicks on sub option Approve
Then User provides the valid beneficiary record details using Sheet "<SheetName>" and approves OR Rejects the required record

Examples:
|SheetName                     |
|BeneMaintain_EnterApproveList | 

@TC05_03_BeneficiaryMaintenance_List
Scenario Outline: Testing of List functionality for Beneficiary Maintenance Menu
Given User navigates to Application, Master Data Maintenance selects Beneficiary Maintenance menu and clicks on sub option List
Then User provides the valid beneficiary record details using Sheet "<SheetName>" to view the record

Examples:
|SheetName                     |
|BeneMaintain_EnterApproveList | 

@TC05_04_BeneficiaryMaintenance_Delete
Scenario Outline: Testing of Delete functionality With Valid Data for Beneficiary Maintenance Menu
Given User navigates to Application, Master Data Maintenance selects Beneficiary Maintenance menu and clicks on sub option Delete
Then User provides the valid beneficiary record details using Sheet "<SheetName>" to Delete the required beneficiary record

Examples:
|SheetName                      |
|BeneMaintain_DeleteApproveList |

@TC05_05_BeneficiaryMaintenance_Approve_Reject
Scenario Outline: Testing of Approve,Reject functionality for Beneficiary Maintenance Menu
Given User navigates to Application, Master Data Maintenance selects Beneficiary Maintenance menu and clicks on sub option Approve
Then User provides the valid beneficiary record details using Sheet "<SheetName>" and approves OR Rejects the required record

Examples:
|SheetName                      |
|BeneMaintain_DeleteApproveList | 

@TC05_06_BeneficiaryMaintenance_List
Scenario Outline: Testing of List functionality for Beneficiary Maintenance Menu
Given User navigates to Application, Master Data Maintenance selects Beneficiary Maintenance menu and clicks on sub option List
Then User provides the valid beneficiary record details using Sheet "<SheetName>" to view the record

Examples:
|SheetName                      |
|BeneMaintain_DeleteApproveList | 

@TC05_07_BeneficiaryMaintenance_Modify_ValidData
Scenario Outline: Testing of Modify functionality With Valid Data for Beneficiary Maintenance Menu
Given User navigates to Application, Master Data Maintenance selects Beneficiary Maintenance menu and clicks on sub option Modify
Then User provides the valid beneficiary record details using Sheet "<SheetName>" to perform modification on required beneficiary record

Examples:
|SheetName                     |
|BeneMaintain_ModifyApproveList| 

@TC05_08_BeneficiaryMaintenance_Approve_Reject_ManualApproval
Scenario Outline: Testing of Approve,Reject functionality for Beneficiary Maintenance Menu
Given User navigates to Application, Master Data Maintenance selects Beneficiary Maintenance menu and clicks on sub option Approve
Then User provides the valid beneficiary record details using Sheet "<SheetName>" and approves OR Rejects the required record

Examples:
|SheetName                      |
|BeneMaintain_ModifyApproveList | 

@TC05_09_BeneficiaryMaintenance_List
Scenario Outline: Testing of List functionality for Beneficiary Maintenance Menu
Given User navigates to Application, Master Data Maintenance selects Beneficiary Maintenance menu and clicks on sub option List
Then User provides the valid beneficiary record details using Sheet "<SheetName>" to view the record

Examples:
|SheetName                      |
|BeneMaintain_ModifyApproveList |  


@TC05_10_BeneficiaryMaintenance_Enter_InvalidData
Scenario Outline: Testing of Enter functionality With Invalid Data for Beneficiary Maintenance Menu
Given User navigates to Application, Master Data Maintenance selects Beneficiary Maintenance menu and clicks on sub option Enter
Then User provides the Invalid beneficiary record details using Sheet "<SheetName>" and checks for validation messages displayed

Examples:
|SheetName                     |
|BeneMaintain_EnterInvalidData | 

@TC05_11_BeneficiaryMaintenance_Modify_InvalidData
Scenario Outline: Testing of Modify functionality With Invalid Data for Beneficiary Maintenance Menu
Given User navigates to Application, Master Data Maintenance selects Beneficiary Maintenance menu and clicks on sub option Modify
Then User provides Invalid beneficiary record details using Sheet "<SheetName>" for Modify operation

Examples:
|SheetName                     |
|BeneMaintain_ModifyInvalidData|

