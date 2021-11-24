package com.yesbank.qa.stepDefination;

import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.yesbank.qa.factory.DriverFactory;
import com.yesbank.qa.pages.CustomerPage;
import com.yesbank.qa.pages.HomePage;
import com.yesbank.qa.pages.LoginPage;
import com.yesbank.qa.util.ElementUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CustomerStepDefination {
	
	private DriverFactory driverFactory;
	private WebDriver driver = driverFactory.getDriver();
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	CustomerPage customerPage;
	ElementUtil elementUtil = new ElementUtil(driver);
	Hooks hooks = new Hooks();
	
	//--------------------------Customer Menu Add Scenario----------------------------------

	@Given("User navigates to Application, Master Data Maintenance selects Customer menu and clicks on sub option Add")
	public void user_navigates_to_Application_Master_Data_Maintenance_selects_Customer_menu_and_clicks_on_sub_option_Add() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		
		customerPage=homePage.customerAddMenu();

	}//end

	@Then("User provides valid customer record details for Add operation using {string} clicks on Ok button and Add Confirm button")
	public void user_provides_valid_customer_record_details_for_Add_operation_using_clicks_on_Ok_button_and_Add_Confirm_button(String sheetName) throws InterruptedException, InvalidFormatException, IOException {
		customerPage.addCustomerRecord(sheetName);
	}//end
	
//	//------------------------Customer Menu Approve, Cancel Modify Action Scenario---------------------------------

	@Given("User navigates to Application, Master Data Maintenance selects Customer menu and clicks on sub option Approve")
	public void user_navigates_to_Application_Master_Data_Maintenance_selects_Customer_menu_and_clicks_on_sub_option_Approve() throws InterruptedException {
		homePage.LogOut();

		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();
		customerPage=homePage.customerApproveMenu();
	}//end

	@Then("User provides the valid customer record details using Sheet {string} and approves OR performs cancel modify action on the required record")
	public void user_provides_the_valid_customer_record_details_using_Sheet_and_approves_OR_performs_cancel_modify_action_the_required_record(String sheetName) throws InvalidFormatException, IOException, InterruptedException {
		customerPage.approveCustomerRecord(sheetName);
	}//end

	//-----------------------Customer Menu List Scenario-----------------------------------------	
	@Given("User navigates to Application, Master Data Maintenance selects Customer menu and clicks on sub option List")
	public void user_navigates_to_Application_Master_Data_Maintenance_selects_Customer_menu_and_clicks_on_sub_option_List() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();

		customerPage=homePage.customerListMenu();
	}//end

	@Then("User provides the valid customer record details using Sheet {string} to view the required record")
	public void user_provides_the_valid_customer_record_details_using_Sheet_to_view_the_required_record(String sheetName) throws InvalidFormatException, IOException, InterruptedException {
		customerPage.listCustomerRecord(sheetName);
	}//end

	//-----------------------Customer Menu Add Invalid Data Scenario-----------------------------------------	
	
	@Then("User provides invalid record details for Add operation using {string} and validates")
	public void user_provides_invalid_record_details_for_Add_operation_using_and_validates(String sheetName) throws InvalidFormatException, InterruptedException, IOException {
		customerPage.addCustomerRecordInvalidData(sheetName);
	}//end

	//-----------------------Customer Menu Modify Scenario-----------------------------------------	
	
	@Given("User navigates to Application, Master Data Maintenance selects Customer menu and clicks on sub option Modify")
	public void user_navigates_to_Application_Master_Data_Maintenance_selects_Customer_menu_and_clicks_on_sub_option_Modify() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();

		customerPage=homePage.customerModifyMenu();

	}//end

	@Then("User provides valid customer record details for Modify operation using {string} clicks on Ok button and Modify Confirm button")
	public void user_provides_valid_customer_record_details_for_Modify_operation_using_clicks_on_Ok_button_and_Modify_Confirm_button(String sheetName) throws InvalidFormatException, InterruptedException, IOException {
		customerPage.modifyCustomerRecord(sheetName);
	}//end
	
	//-----------------------Customer Menu Modify Invalid Data Scenario-----------------------------------------	

	@Then("User provides invalid customer record details for Modify operation using {string}")
	public void user_provides_invalid_customer_record_details_for_Modify_operation_using(String sheetName) throws InvalidFormatException, InterruptedException, IOException {
		customerPage.modifyCustomerRecordInvalidData(sheetName);
	}//end
	
	//-----------------------Customer Menu Delete Scenario-----------------------------------------	

	@Given("User navigates to Application, Master Data Maintenance selects Customer menu and clicks on sub option Delete")
	public void user_navigates_to_Application_Master_Data_Maintenance_selects_Customer_menu_and_clicks_on_sub_option_Delete() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();

		customerPage=homePage.customerDeleteMenu();
	}//end
	
	@Then("User provides record details for delete operation using {string}")
	public void user_provides_record_details_for_delete_operation_using(String sheetName) throws InvalidFormatException, IOException, InterruptedException {
		customerPage.deleteCustomerRecord(sheetName);
	}//end
	
	//-----------------------Customer Menu Confirm Delete,Cancel Delete Action Scenario----------------------------------------

	@Given("User navigates to Application, Master Data Maintenance selects Customer menu and clicks on sub option Confirm Delete")
	public void user_navigates_to_Application_Master_Data_Maintenance_selects_Customer_menu_and_clicks_on_sub_option_Confirm_Delete() throws InterruptedException {
		homePage.LogOut();

		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();
		customerPage=homePage.customerConfirmDeleteMenu();
	}//end
	
	@Then("User provides record details for confirming deletion OR cancelling deletion operation on record using {string}")
	public void user_provides_record_details_for_confirming_deletion_OR_cancelling_deletion_operation_of_record_using(String sheetName) throws InvalidFormatException, IOException, InterruptedException {
		customerPage.confirmDeleteCustomerRecord(sheetName);
	}//end


}
