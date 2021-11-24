package com.yesbank.qa.stepDefination;
//imports
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.yesbank.qa.factory.DriverFactory;
import com.yesbank.qa.pages.BeneficiaryMaintenancePage;
import com.yesbank.qa.pages.HomePage;
import com.yesbank.qa.pages.LoginPage;
import com.yesbank.qa.util.ElementUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class BeneficiaryMaintenanceStepDefination {

	private DriverFactory driverFactory;
	private WebDriver driver = driverFactory.getDriver();
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	BeneficiaryMaintenancePage beneficiaryMaintenancePage;
	ElementUtil elementUtil = new ElementUtil(driver);
	Hooks hooks = new Hooks();
	
	//----------------------------Beneficiary Maintenance Enter Scenario------------------------
	@Given("User navigates to Application, Master Data Maintenance selects Beneficiary Maintenance menu and clicks on sub option Enter")
	public void user_navigates_to_Application_Master_Data_Maintenance_selects_Beneficiary_Maintenance_menu_and_clicks_on_sub_option_Enter() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();

		beneficiaryMaintenancePage=homePage.beneMaintainEnterMenu();

	}//end

	@Then("User provides the valid beneficiary record details using Sheet {string} clicks on Ok button and then on Submit button")
	public void user_provides_the_valid_beneficiary_record_details_using_Sheet_clicks_on_Ok_button_and_then_on_Submit_button(String sheetName) throws InvalidFormatException, IOException, InterruptedException {
		beneficiaryMaintenancePage.enterBeneficiaryRecord(sheetName);
	
	}//end
	
	//---------------------------Beneficiary Maintenance Approve,Reject Scenario------------------------
	@Given("User navigates to Application, Master Data Maintenance selects Beneficiary Maintenance menu and clicks on sub option Approve")
	public void user_navigates_to_Application_Master_Data_Maintenance_selects_Beneficiary_Maintenance_menu_and_clicks_on_sub_option_Approve() throws InterruptedException {
		homePage.LogOut();

		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();
		beneficiaryMaintenancePage=homePage.beneMaintainApproveMenu();

	}//end

	@Then("User provides the valid beneficiary record details using Sheet {string} and approves OR Rejects the required record")
	public void user_provides_the_valid_beneficiary_record_details_using_Sheet_and_approves_the_required_record(String sheetName) throws InvalidFormatException, IOException, InterruptedException {
		beneficiaryMaintenancePage.approveRejectBeneficiaryRecord(sheetName);
	}//end

	//---------------------------Beneficiary Maintenance List Scenario------------------------
	
	@Given("User navigates to Application, Master Data Maintenance selects Beneficiary Maintenance menu and clicks on sub option List")
	public void user_navigates_to_Application_Master_Data_Maintenance_selects_Beneficiary_Maintenance_menu_and_clicks_on_sub_option_List() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();

		beneficiaryMaintenancePage=homePage.beneMaintainListMenu();

	}//end

	@Then("User provides the valid beneficiary record details using Sheet {string} to view the record")
	public void user_provides_the_valid_beneficiary_record_details_using_Sheet_to_view_the_record(String sheetName) throws InvalidFormatException, IOException, InterruptedException {
		beneficiaryMaintenancePage.listBeneficiaryRecord(sheetName);
	}//end
	
	//---------------------------Beneficiary Maintenance Delete Scenario------------------------
	
	@Given("User navigates to Application, Master Data Maintenance selects Beneficiary Maintenance menu and clicks on sub option Delete")
	public void user_navigates_to_Application_Master_Data_Maintenance_selects_Beneficiary_Maintenance_menu_and_clicks_on_sub_option_Delete() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();

		beneficiaryMaintenancePage=homePage.beneMaintainDeleteMenu();
	}//end

	@Then("User provides the valid beneficiary record details using Sheet {string} to Delete the required beneficiary record")
	public void user_provides_the_valid_beneficiary_record_details_using_Sheet_to_Delete_the_required_beneficiary_record(String sheetName) throws InvalidFormatException, IOException, InterruptedException {
		beneficiaryMaintenancePage.deleteBeneficiaryRecord(sheetName);
	}//end
	
	//---------------------------Beneficiary Maintenance Modify Scenario------------------------
	
	@Given("User navigates to Application, Master Data Maintenance selects Beneficiary Maintenance menu and clicks on sub option Modify")
	public void user_navigates_to_Application_Master_Data_Maintenance_selects_Beneficiary_Maintenance_menu_and_clicks_on_sub_option_Modify() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();

		beneficiaryMaintenancePage=homePage.beneMaintainModifyMenu();

	}//end

	@Then("User provides the valid beneficiary record details using Sheet {string} to perform modification on required beneficiary record")
	public void user_provides_the_valid_beneficiary_record_details_using_Sheet_to_perform_modification_on_required_beneficiary_record(String sheetName) throws InvalidFormatException, IOException, InterruptedException {
		beneficiaryMaintenancePage.modifyBeneficiaryRecord(sheetName);
	}//end
	
	//---------------------------Beneficiary Maintenance Enter Invalid Data Scenario------------------------
	
	@Then("User provides the Invalid beneficiary record details using Sheet {string} and checks for validation messages displayed")
	public void user_provides_the_Invalid_beneficiary_record_details_using_Sheet_and_checks_for_validation_messages_displayed(String sheetName) throws InvalidFormatException, IOException, InterruptedException {
	   beneficiaryMaintenancePage.enterBeneficiaryRecordInvalidData(sheetName);
	   
	}//end
	
	//---------------------------Beneficiary Maintenance Modify Invalid Data Scenario------------------------
	
	@Then("User provides Invalid beneficiary record details using Sheet {string} for Modify operation")
	public void user_provides_Invalid_beneficiary_record_details_using_Sheet_for_Modify_operation(String sheetName) throws InvalidFormatException, IOException, InterruptedException {
	   beneficiaryMaintenancePage.modifyBeneficiaryRecordInvalidData(sheetName);
	}//end





}
