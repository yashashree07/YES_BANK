#Author: Yashashree Suryawanshi
@Version1.0 @Regression_Pack_DBLoads_Menu
Feature: DBload feature

@TC02_DBLoadfunctionality
  Scenario Outline: To upload Bank IFSC Codes through DBLoad Menu
    Given User navigates to Application, Master Data Maintenance selects DBLoads Menu
		Then User uploads IFSC list using "<SheetName>"
    
	Examples: 
     |SheetName       |
     |DBLoads_Uploads |