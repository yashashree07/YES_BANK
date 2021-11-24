package com.yesbank.qa.stepDefination;

import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
//imports
import org.openqa.selenium.WebDriver;
import com.yesbank.qa.factory.DriverFactory;
import com.yesbank.qa.pages.HomePage;
import com.yesbank.qa.pages.LoginPage;
import com.yesbank.qa.pages.PurposeCodePage;
import com.yesbank.qa.util.ElementUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class PurposeCodeStepDefination {

	private DriverFactory driverFactory;
	private WebDriver driver = driverFactory.getDriver();
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	PurposeCodePage purposeCodePage; 
	ElementUtil elementUtil = new ElementUtil(driver);
	Hooks hooks = new Hooks();

	//----------------------PurposeCode Enter Valid Data Scenario------------------------------
	@Given("User navigates to Application, Master Data Maintenance selects Purpose Code menu and clicks on sub option Enter")
	public void user_navigates_to_Application_Master_Data_Maintenance_selects_Purpose_Code_menu_and_clicks_on_sub_option_Enter() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		
		purposeCodePage=homePage.purposeCodeEnterMenu();
		
	}//end

	@Then("User provides the valid record details using Sheet {string} clicks on Ok button and then on Submit button")
	public void user_provides_the_valid_record_details_using_Sheet_clicks_on_Ok_button_and_then_on_Submit_button(String sheetName) throws InvalidFormatException, IOException, InterruptedException {
		purposeCodePage.enterPurposeCodeRecord(sheetName);
	}//end

	//----------------------PurposeCode Approve, Reject Scenario------------------------------

	@Given("User navigates to Application, Master Data Maintenance selects Purpose Code menu and clicks on sub option Approve")
	public void user_navigates_to_Application_Master_Data_Maintenance_selects_Purpose_Code_menu_and_clicks_on_sub_option_Approve() throws InterruptedException {
		homePage.LogOut();

		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();
		purposeCodePage=homePage.purposeCodeApproveMenu();
		
	}//end

	@Then("User provides the valid record details using Sheet {string} and approves OR Rejects the required record")
	public void user_provides_the_valid_record_details_using_Sheet_and_approves_OR_Rejects_the_required_record(String sheetName) throws InvalidFormatException, IOException, InterruptedException {
		purposeCodePage.approveRejectPurposeCodeRecord(sheetName);
	}//end

	//----------------------PurposeCode List Scenario------------------------------

	@Given("User navigates to Application, Master Data Maintenance selects Purpose Code menu and clicks on sub option List")
	public void user_navigates_to_Application_Master_Data_Maintenance_selects_Purpose_Code_menu_and_clicks_on_sub_option_List() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		
		purposeCodePage=homePage.purposeCodeListMenu();
	}//end

	@Then("User provides the valid record details using Sheet {string} to view the required record")
	public void user_provides_the_valid_record_details_using_Sheet_to_view_the_required_record(String sheetName) throws InvalidFormatException, IOException, InterruptedException {
		purposeCodePage.listPurposeCodeRecord(sheetName);
	}//end

	//----------------------PurposeCode Delete Scenario------------------------------

	@Given("User navigates to Application, Master Data Maintenance selects Purpose Code menu and clicks on sub option Delete")
	public void user_navigates_to_Application_Master_Data_Maintenance_selects_Purpose_Code_menu_and_clicks_on_sub_option_Delete() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		
		purposeCodePage=homePage.purposeCodeDeleteMenu();

	}//end

	@Then("User provides the valid record details using Sheet {string} to Delete the required record")
	public void user_provides_the_valid_record_details_using_Sheet_to_Delete_the_required_record(String sheetName) throws InvalidFormatException, IOException, InterruptedException {
		purposeCodePage.deletepurposeCodeRecord(sheetName);
	}//end

	//----------------------PurposeCode Modify Valid Data Scenario------------------------------

	@Given("User navigates to Application, Master Data Maintenance selects Purpose Code menu and clicks on sub option Modify")
	public void user_navigates_to_Application_Master_Data_Maintenance_selects_Purpose_Code_menu_and_clicks_on_sub_option_Modify() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		
		purposeCodePage=homePage.purposeCodeModifyMenu();
	}//end

	@Then("User provides the valid record details using Sheet {string} for record modification")
	public void user_provides_the_valid_record_details_using_Sheet_for_record_modification(String sheetName) throws InvalidFormatException, IOException, InterruptedException {
		purposeCodePage.modifyPurposeCodeRecord(sheetName);
	}//end

	//----------------------PurposeCode Enter Invalid Data Scenario------------------------------

	@Then("User provides the Invalid record details using Sheet {string} for checking field level validation")
	public void user_provides_the_Invalid_record_details_using_Sheet_for_checking_field_level_validation(String sheetName) throws InvalidFormatException, IOException, InterruptedException {
		purposeCodePage.enterPurposeCodeRecordInvalidData(sheetName);
	}//end

	//----------------------PurposeCode Modify Invalid Data Scenario------------------------------
	@Then("User provides the Invalid record details using Sheet {string} for Modify operation")
	public void user_provides_the_Invalid_record_details_using_Sheet_for_Modify_operation(String sheetName) throws InvalidFormatException, IOException, InterruptedException {
		purposeCodePage.modifyPurposeCodeRecordInvalidData(sheetName);
	}//end



}
