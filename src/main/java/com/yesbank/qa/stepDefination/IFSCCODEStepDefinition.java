package com.yesbank.qa.stepDefination;

import java.io.IOException;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import com.yesbank.qa.factory.DriverFactory;
import com.yesbank.qa.pages.HomePage;
import com.yesbank.qa.pages.IFSC_CODEPage;
import com.yesbank.qa.pages.LoginPage;
import com.yesbank.qa.util.ElementUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

/**
 * @Author -- Suvarna Prabhumatkari
 **/

public class IFSCCODEStepDefinition {
	private DriverFactory driverFactory;
	private WebDriver driver = DriverFactory.getDriver();
	IFSC_CODEPage ifsc_CodePage;
	Hooks hooks = new Hooks();
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	ElementUtil elementUtil = new ElementUtil(driver);

	// --------Add IFSC CODE----------//
	@Given("user goes to Maintenance and clicks on Static Data IFSCCODE Add menu")
	public void user_goes_to_maintenance_and_clicks_on_static_data_ifsccode_add_menu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		ifsc_CodePage = homePage.clickonIFSCCODEAddLink();
	}

	@Then("user enters invalid or blank data using {string}")
	public void user_enters_invalid_data_using_and(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		ifsc_CodePage = ifsc_CodePage.addIFSCCodewithInvalidData(SheetName);
	}

	@Then("user enters valid data using {string}")
	public void user_enters_valid_data_using_and(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		ifsc_CodePage = ifsc_CodePage.addIFSCCodewithValidData(SheetName);
	}

	// ----------Delete IFSC CODE-----------//
	@Given("user goes to Maintenance and clicks on Static Data IFSCCODE Delete menu")
	public void user_goes_to_maintenance_and_clicks_on_static_data_ifsccode_delete_menu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		ifsc_CodePage = homePage.clickonIFSCCODEDeleteLink();
	}

	@Then("user try to filter IFSC Code using invalid or valid data using {string}")
	public void user_try_to_filter_ifsc_code_using_invalid_data_using_and(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		ifsc_CodePage = ifsc_CodePage.deleteIFSCCode(SheetName);
	}
	
	//------------Confirm Delete IFSC Code----------------//
	@Given("user goes to Maintenance and clicks on Static Data IFSCCODE Confirm Delete menu")
	public void user_goes_to_Maintenance_and_clicks_on_Static_Data_IFSCCODE_Confirm_Delete_menu() throws InterruptedException {
		homePage.LogOut();
		
		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();
		ifsc_CodePage = homePage.clickonIFSCCODEConfirmDeleteLink();
	}

	@Then("user goes to Delete Confirm screen to approve the record using {string}")
	public void user_goes_to_Delete_Confirm_screen_to_approve_the_record_using(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		ifsc_CodePage =ifsc_CodePage.confirmDeleteIFSCCode(SheetName);
	}

	// ------------List IFSC CODE---------------//
	@Given("user goes to Maintenance and clicks on Static Data IFSCCODE List menu")
	public void user_goes_to_maintenance_and_clicks_on_static_data_ifsccode_list_menu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		ifsc_CodePage = homePage.clickonIFSCCODEListLink();
	}

	@Then("user view IFSC Code using invalid or valid data using {string}")
	public void user_view_ifsc_code_using_invalid_or_valid_data_using_and(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		ifsc_CodePage = ifsc_CodePage.viewIFSCCodeList(SheetName);
	}
	
	// -----------Approve IFSC CODE-----------------//
	@Given("user goes to Maintenance and clicks on Static Data IFSCCODE Approve menu")
	public void user_goes_to_Maintenance_and_clicks_on_Static_Data_IFSCCODE_Approve_menu() throws InterruptedException {
		homePage.LogOut();
		homePage=hooks.launchBrowser1();
		elementUtil.SHORT_TIMEOUT();
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
//		ifsc_CodePage = ifsc_CodePage.
	}

	@Then("user approves record using {string}")
	public void user_approves_record_using(String sheetName) throws InvalidFormatException, IOException, InterruptedException {
		ifsc_CodePage = ifsc_CodePage.approveIFSCCode(sheetName);
	}

}
