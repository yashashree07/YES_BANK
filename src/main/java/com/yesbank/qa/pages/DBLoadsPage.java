package com.yesbank.qa.pages;

/*
 * Class Description :
 * Class namely DBLoadsPage is a class which involves different methods related to DB Loads Menu which helps user in
 * performing operation related to DB Loads Menu
 */

//imports
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yesbank.qa.util.ElementUtil;
import com.yesbank.qa.util.FileReadUtils;

public class DBLoadsPage {

	private WebDriver driver;
	ElementUtil elementUtil;
	FileReadUtils fileReader;
	HomePage homePage;
	List<Map<String, String>> test_Data;

	Logger log = Logger.getLogger(DBLoadsPage.class);

	//DBLoads Page WebElements

	@FindBy(name="loadType")
	WebElement selectLoadtype;

	@FindBy(name="forceUpdate")
	WebElement forceUpdate;

	@FindBy(name="fileName")
	WebElement fileName;

	@FindBy(xpath="//input[@value='OK']")
	WebElement oKBtn;

	@FindBy(name="back")
	WebElement backBtn;

	@FindBy(xpath="//*[@id=\"pageBody\"]/form/table/tbody/tr/td/table/tbody/tr[6]/td/input[2]")
	WebElement confirmBtn;

	@FindBy(xpath="//input[@name='reveal']")
	WebElement statusBtn;

	@FindBy(xpath = "//p[@class='errormessages']")
	WebElement errormessages;

	@FindBy(xpath="//p[@class='messages']")
	WebElement messages;

	@FindBy(xpath="//*[@id=\"au1c0\"]")
	WebElement statusBtnFileLoadStatus;

	@FindBy(xpath="//a[normalize-space()='Restart Workflow']")
	WebElement restartWorkFlowBtn;

	@FindBy(xpath="//span[@class='glyphicon glyphicon-log-out']")
	WebElement mainPageLogOutButton;

	@FindBy(id="content")
	WebElement mainFrame;

	@FindBy(xpath="//button[@type='button'][normalize-space()='OK']")
	WebElement mainPageLogoutOkBtn;


	//DbLoads Page Constructor
	public DBLoadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.fileReader=new FileReadUtils(driver);
		this.elementUtil=new ElementUtil(driver);
		this.homePage=new HomePage(driver);
	}//end of DBLoadsPage


	//--------------------------Method to ADD IFSC Codes using DBLoads Menu------------------------
	public void addIFSCCodeList(String sheetName) throws InterruptedException, InvalidFormatException, IOException {
		//click on ok button
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(oKBtn);

		//check if Mandatory field message displayed is correct
		if(elementUtil.getText(errormessages).trim().toString().equals("DB: File Name is Required\n" + "DB: File Does not exist:".trim().toString()))
		{
			log.info("Mandatory Fields Validation Message Displayed Is Correct");
		}//end of if
		else
		{
			log.error("Mandatory Fields Validation Message Displayed Is Incorrect");
		}//end of else

		//fetch details
		test_Data=fileReader.readDBLoadsExcel(sheetName);
		for (Map<String, String> map : test_Data) 
		{
			String loadType=map.get("Select LoadType");
			String ForceUpdate=map.get("ForceUpdate");
			String FileName=map.get("FileName");

			//click on restart workflow button
			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(restartWorkFlowBtn);

			//enter details
			elementUtil.selectDropDownByVisibleText(selectLoadtype,loadType);
			elementUtil.selectDropDownByVisibleText(forceUpdate,ForceUpdate);
			elementUtil.enterText(fileName, FileName);

			//click on ok button
			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(oKBtn);

			try {
				if(elementUtil.getText(errormessages).equals("DB: File Does not exist:"+FileName))
				{
					log.info("DB: " +FileName+ " File Does Not Exists");
				}//end of if
			} catch (NoSuchElementException e) {
				//click on Confirm Button
				elementUtil.SHORT_TIMEOUT();
				elementUtil.clickElement(confirmBtn);
				try {
					elementUtil.SHORT_TIMEOUT();
					if(elementUtil.getText(errormessages).trim().equals("DB: Load Started For:IFSC".trim().toString()))
					{
						log.info("DB: Load Started For:IFSC.......");
						
						//click on Status Button
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clickElement(statusBtn);
					}//end of if
					
					} catch (NoSuchElementException e2) {
					log.error("DB Load Not Started........");
				}//end of catch
				
			}//end of catch

		}//end of for

		//perform logout operation
		elementUtil.handlewin1(driver);
		logOutOperation();

	}//end of addIFSCCodeList function


	//-----------------Method to perform Logout Operation----------------------------
	public void logOutOperation() throws InterruptedException
	{
		elementUtil.GoToFrame("app");
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(mainPageLogOutButton);
		elementUtil.SHORT_TIMEOUT();
		driver.switchTo().parentFrame();
		elementUtil.SHORT_TIMEOUT();
		elementUtil.GoToFrame("content");
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(mainPageLogoutOkBtn);
		driver.quit();

	}//end of logOutOperation function
}//end of main class DBLoadsPage

