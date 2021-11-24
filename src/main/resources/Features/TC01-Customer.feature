#Author: 

@Version1.0
@Regression_Pack_Customer_Menu
Feature: To test Functionality of Customer Menus

@TC01_01_Customer_Add
Scenario Outline: Testing of Add functionality With Valid Data for Customer Menu
Given User navigates to Application, Master Data Maintenance selects Customer menu and clicks on sub option Add
Then User provides valid customer record details for Add operation using "<SheetName>" clicks on Ok button and Add Confirm button

Examples: 
|SheetName                |
|Customer_AddApproveList  |

@TC01_02_Customer_Approve
Scenario Outline: Testing of Approve,List functionality for Customer Menu
Given User navigates to Application, Master Data Maintenance selects Customer menu and clicks on sub option Approve
Then User provides the valid customer record details using Sheet "<SheetName>" and approves OR performs cancel modify action on the required record

Examples: 
|SheetName                |
|Customer_AddApproveList  |

@TC01_03_Customer_List
Scenario Outline: Testing of List functionality for Customer Menu
Given User navigates to Application, Master Data Maintenance selects Customer menu and clicks on sub option List
Then User provides the valid customer record details using Sheet "<SheetName>" to view the required record

Examples:
|SheetName               |
|Customer_AddApproveList | 

@TC01_04_Customer_Add_InvalidData
Scenario Outline: Testing of Add functionality With Invalid Data for Customer Menu
Given User navigates to Application, Master Data Maintenance selects Customer menu and clicks on sub option Add
Then User provides invalid record details for Add operation using "<SheetName>" and validates

Examples: 
|SheetName                |
|Customer_AddInvalidData  |

@TC01_05_Customer_Modify
Scenario Outline: Testing of Modify functionality With Valid Data for Customer Menu
Given User navigates to Application, Master Data Maintenance selects Customer menu and clicks on sub option Modify
Then User provides valid customer record details for Modify operation using "<SheetName>" clicks on Ok button and Modify Confirm button

Examples: 
|SheetName                    |
| Customer_ModifyApproveList  |

@TC01_06_Customer_Approve_Reject
Scenario Outline: Testing of Approve,List functionality for Customer Menu
Given User navigates to Application, Master Data Maintenance selects Customer menu and clicks on sub option Approve
Then User provides the valid customer record details using Sheet "<SheetName>" and approves OR performs cancel modify action on the required record

Examples: 
|SheetName                   |
|Customer_ModifyApproveList  |

@TC01_07_Customer_List
Scenario Outline: Testing of List functionality for Customer Menu
Given User navigates to Application, Master Data Maintenance selects Customer menu and clicks on sub option List
Then User provides the valid customer record details using Sheet "<SheetName>" to view the required record

Examples:
|SheetName                  |
|Customer_ModifyApproveList | 

@TC01_08_Customer_ModifyInvalidData
Scenario Outline: Testing of Modify functionality With Invalid Data for Customer Menu
Given User navigates to Application, Master Data Maintenance selects Customer menu and clicks on sub option Modify
Then User provides invalid customer record details for Modify operation using "<SheetName>" 

Examples: 
|SheetName                    |
| Customer_ModifyInvalidData  |

@TC01_09_Customer_Delete
Scenario Outline: Testing of Delete functionality for Customer Menu
Given User navigates to Application, Master Data Maintenance selects Customer menu and clicks on sub option Delete
Then User provides record details for delete operation using "<SheetName>" 

Examples: 
|SheetName                       |
| Customer_DeleteConfirmDelList  | 

@TC01_10_Customer_ConfirmDelete
Scenario Outline: Testing of Confirm Delete functionality for Customer Menu
Given User navigates to Application, Master Data Maintenance selects Customer menu and clicks on sub option Confirm Delete
Then User provides record details for confirming deletion OR cancelling deletion operation on record using "<SheetName>" 

Examples: 
|SheetName                       |
| Customer_DeleteConfirmDelList  | 

@TC01_11_Customer_List
Scenario Outline: Testing of List functionality for Customer Menu
Given User navigates to Application, Master Data Maintenance selects Customer menu and clicks on sub option List
Then User provides the valid customer record details using Sheet "<SheetName>" to view the required record

Examples:
|SheetName                     |
|Customer_DeleteConfirmDelList | 



