package com.yesbank.qa.stepDefination;

import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
//imports
import org.openqa.selenium.WebDriver;
import com.yesbank.qa.factory.DriverFactory;
import com.yesbank.qa.pages.DBLoadsPage;
import com.yesbank.qa.pages.HomePage;
import com.yesbank.qa.pages.LoginPage;
import com.yesbank.qa.util.ElementUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DBLoadsStepDefination {

	private DriverFactory driverFactory;
	private WebDriver driver = driverFactory.getDriver();
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	DBLoadsPage dbloads;
	ElementUtil elementUtil = new ElementUtil(driver);
	Hooks hooks = new Hooks();
	
	@Given("User navigates to Application, Master Data Maintenance selects DBLoads Menu")
	public void user_navigates_to_Application_Master_Data_Maintenance_selects_DBLoads_Menu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.SHORT_TIMEOUT();
		
		dbloads=homePage.dbloadsMenu();

	}//end

	@Then("User uploads IFSC list using {string}")
	public void user_uploads_IFSC_list_using(String sheetName) throws InvalidFormatException, InterruptedException, IOException {
		dbloads.addIFSCCodeList(sheetName);
	}//end


}
