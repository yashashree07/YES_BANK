#Author: Suvarna Prabhumatkari
@Version1.0 @Regression_Pack_IFSCCODE_Menu
Feature: To Test IFSCCODE Functionality

  @TC03_01_AddIFSCCODEwithInvaliddata
  Scenario Outline: To add IFSC Code with Invalid/Blank data
    Given user goes to Maintenance and clicks on Static Data IFSCCODE Add menu
    Then user enters invalid or blank data using "<SheetName>"

    Examples: 
      | SheetName            |
      | IFSC_Add_InvalidData |

  @TC03_02_AddIFSCCODEwithValiddata
  Scenario Outline: To add IFSC Code with Valid data
    Given user goes to Maintenance and clicks on Static Data IFSCCODE Add menu
    Then user enters valid data using "<SheetName>"

   
    Examples: 
      | SheetName          |
      | IFSC_Add_ValidData |

  @TC03_03_ApproveIFSCCode
  Scenario Outline: To Approve IFSC Code
    Given user goes to Maintenance and clicks on Static Data IFSCCODE Approve menu
    Then user approves record using "<SheetName>"

    Examples: 
      | SheetName    |
      | IFSC_Approve |

  @TC03_04_DeleteIFSCCODE
  Scenario Outline: To delete IFSC Code
    Given user goes to Maintenance and clicks on Static Data IFSCCODE Delete menu
    Then user try to filter IFSC Code using invalid or valid data using "<SheetName>"

    Examples: 
      | SheetName   |
      | IFSC_Delete |

  @TC03_04_ConfirmDeleteIFSCCODE
  Scenario Outline: Confirm delete IFSC Code
    Given user goes to Maintenance and clicks on Static Data IFSCCODE Confirm Delete menu
    Then user goes to Delete Confirm screen to approve the record using "<SheetName>"

    Examples: 
      | SheetName          |
      | IFSC_ConfirmDelete |

  @TC03_05_ListIFSCCODE
  Scenario Outline: To List IFSC Code
    Given user goes to Maintenance and clicks on Static Data IFSCCODE List menu
    Then user view IFSC Code using invalid or valid data using "<SheetName>"

   
    Examples: 
      | SheetName |
      | IFSC_List |
