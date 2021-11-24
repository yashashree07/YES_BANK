package com.yesbank.qa.pages;

/*
 * Class Description :
 * Class namely PurposeCodePage is a class which involves different methods related to Purpose Code Menu which helps user in
 * performing different operations related to Purpose Code menu
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

public class PurposeCodePage {

	private WebDriver driver;
	ElementUtil elementUtil;
	FileReadUtils fileReader;
	HomePage homePage;
	List<Map<String, String>> test_Data;

	Logger log = Logger.getLogger(PurposeCodePage.class);

	//PurposeCode Menu Web Elements

	@FindBy(name="purposeCode")
	WebElement purposeCodeTxtField;

	@FindBy(name="description")
	WebElement DescriptionTxtField;

	@FindBy(name = "paymentType")
	WebElement PaymentTypeDropDown;

	@FindBy(name="paymentToRegisteredBeneOnly")
	WebElement paymentToRegisteredBeneOnlyDropDown;

	@FindBy(name="purposeCodeEnable")
	WebElement purposeCodeEnableDropDown;

	@FindBy(xpath = "//p[@class='errormessages']")
	WebElement errormessages;

	@FindBy(xpath="//p[@class='messages']")
	WebElement messages;

	@FindBy(name="org.apache.struts.taglib.html.CANCEL")
	WebElement cancelBtn;

	@FindBy(xpath="//input[@value='Reset']")
	WebElement resetBtn;

	@FindBy(xpath="//input[@value='OK']")
	WebElement okBtn;

	@FindBy(xpath="//input[@name='ok']")
	WebElement submitBtn;

	@FindBy(xpath="//a[normalize-space()='Restart Workflow']")
	WebElement restartWorkFlowBtn;

	@FindBy(xpath="//span[@class='glyphicon glyphicon-log-out']")
	WebElement mainPageLogOutButton;

	@FindBy(id="content")
	WebElement mainFrame;

	@FindBy(xpath="//button[@type='button'][normalize-space()='OK']")
	WebElement mainPageLogoutOkBtn;

	@FindBy(xpath="//*[@id=\"LNTablelistable\"]/tbody/tr[2]")
	WebElement screenRecord;

	@FindBy(name="approve")
	WebElement approveBtn;

	@FindBy(xpath="//*[@id=\"printable\"]/center/p[2]")
	WebElement screenValidationMessage;

	@FindBy(id="rejectionText")
	WebElement rejctionTxtBox;

	@FindBy(id="btnReject")
	WebElement rejectBtn;

	@FindBy(name="approve")
	WebElement deleteBtn;


	//PurposeCodePage Class Constructor
	public PurposeCodePage(WebDriver driver)
	{	
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.fileReader=new FileReadUtils(driver);
		this.elementUtil=new ElementUtil(driver);
		this.homePage=new HomePage(driver);

	}//end

	//------------------------Method to Enter Purpose Code Record With Valid Data-------------------------------
	public void enterPurposeCodeRecord(String SheetName) throws InvalidFormatException, IOException, InterruptedException  {

		//click on Cancel Button
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(cancelBtn);

		elementUtil.SHORT_TIMEOUT();
		//checking cancel button working
		if(elementUtil.getText(errormessages).trim().toString().equals("Operation was cancelled.".trim().toString()))
		{
			log.info("Cancel Button Is Working Properly");
		}//end of if
		else
		{
			log.error("Cancel Button Is Not Working Properly");
		}//end of else

		//click on RestartWorkFlow
		elementUtil.clickElement(restartWorkFlowBtn);

		//click on ok button
		elementUtil.clickElement(okBtn);

		//Checking Mandatory Fields Message Validation
		String expectedMandatoryFieldMessage="All fields are mandatory.";

		//getting actual Message from screen
		String actualMandatoryFieldMessage=elementUtil.getText(errormessages);

		if(actualMandatoryFieldMessage.trim().toString().equals(expectedMandatoryFieldMessage))
		{
			log.info("Mandatory Fields Validation Message Displayed Is Correct");
		}//end of if
		else
		{
			log.error("Mandatory Fields Validation Message Displayed Is Incorrect");
		}//end of else

		//fetch details
		test_Data=fileReader.readPurposeCodeExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String purposeCode=map.get("Purpose Code");
			String description=map.get("Description");
			String paymentType=map.get("Payment Type");
			String PaymentToRegisteredBeneficiaryOnly=map.get("Payment To Registered Beneficiary Only(Y/N)");
			
			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(restartWorkFlowBtn);

			//enter details 
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(purposeCodeTxtField,purposeCode);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(DescriptionTxtField,description);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(PaymentTypeDropDown,paymentType);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(paymentToRegisteredBeneOnlyDropDown,PaymentToRegisteredBeneficiaryOnly);

			//click on OK button
			elementUtil.clickElement(okBtn);

			try {
				String expected="Purpose Code " +purposeCode+ " already exists";
				if(elementUtil.getText(errormessages).trim().toString().equals(expected))
				{
					
					log.info("Duplicate Record Found : Record With Purpose Code " +purposeCode+ " Already Exists");//Purpose Code PCODE5 already exists
				}//end of if
				else
				{
					log.error("Data Provided For Add operation Is Not As Per Valid Format OR Duplicate Record Validation Message Displayed Is Incorrrect");
				}//end of else
			} catch (NoSuchElementException e) {
				//click on Cancel button on Next screen
				elementUtil.SHORT_TIMEOUT();
				elementUtil.clickElement(cancelBtn);

				//check working of Cancel button on Next Screen
				if(elementUtil.getText(errormessages).trim().toString().equals("Operation was cancelled.".trim().toString()))
				{
					log.info("Cancel Button Is Working Properly");
				}//end of if
				else
				{
					log.error("Cancel Button Is Not Working Properly");
				}//end of else

				//enter details 
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(purposeCodeTxtField,purposeCode);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(DescriptionTxtField,description);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.selectDropDownByVisibleText(PaymentTypeDropDown,paymentType);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.selectDropDownByVisibleText(paymentToRegisteredBeneOnlyDropDown,PaymentToRegisteredBeneficiaryOnly);

				//Click on Reset button
				elementUtil.clickElement(resetBtn);

				//check working of Reset button
				if(elementUtil.getText(purposeCodeTxtField).isEmpty() && elementUtil.getText(DescriptionTxtField).isEmpty())
				{
					log.info("Reset Button Is Working Properly");
				}//end of if
				else
				{
					log.error("Reset Button Is Not Working Properly");
				}//end of else

				//enter details 
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(purposeCodeTxtField,purposeCode);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(DescriptionTxtField,description);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.selectDropDownByVisibleText(PaymentTypeDropDown,paymentType);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.selectDropDownByVisibleText(paymentToRegisteredBeneOnlyDropDown,PaymentToRegisteredBeneficiaryOnly);

				//click on ok button
				elementUtil.clickElement(okBtn);

				//click on Submit button
				elementUtil.clickElement(submitBtn);
				//check if record added successfully
				if(elementUtil.getText(messages).trim().toString().equals("Operation Enter executed successfully. PurposeCode placed in next queue.".trim().toString()))
				{
					log.info("PurposeCode Record With Values [ Purpose Code : " +purposeCode + " Description : " +description+ " Payment Type : " +paymentType+ " Payment To Registered Beneficiary Only : " +PaymentToRegisteredBeneficiaryOnly+ " ] Added Successfully ");
				}//end of if
				
			}//end of catch

		}//end of for loop

		//perform logout operation
		elementUtil.handlewin1(driver);
		logOutOperation();

	}//end of enterPurposeCodeRecord function

	//------------------------Method to Approve OR Reject Purpose Code Record -------------------------------
	public void approveRejectPurposeCodeRecord(String SheetName) throws InvalidFormatException, IOException, InterruptedException  {
		test_Data=fileReader.readPurposeCodeExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String purposeCode=map.get("Purpose Code");
			String paymentType=map.get("Payment Type");
			String PaymentToRegisteredBeneficiaryOnly=map.get("Payment To Registered Beneficiary Only(Y/N)");
			String PurposeCodeEnable=map.get("Purpose Code Enable(Y/N)");
			String operation=map.get("Operation");
			String rejectionReason=map.get("Rejection Reason");
			
			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(restartWorkFlowBtn);

			//enter details 
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(purposeCodeTxtField,purposeCode);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(PaymentTypeDropDown,paymentType);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(paymentToRegisteredBeneOnlyDropDown,PaymentToRegisteredBeneficiaryOnly);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(purposeCodeEnableDropDown,PurposeCodeEnable);

			//click on Reset button
			elementUtil.clickElement(resetBtn);

			//check reset button working
			if(elementUtil.getText(purposeCodeTxtField).isEmpty())
			{
				log.info("Reset Button Is Working Properly");
			}//end of if
			else
			{
				log.error("Reset Button Is Not Working Properly");
			}//end of else

			//enter details after reset operation
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(purposeCodeTxtField,purposeCode);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(PaymentTypeDropDown,paymentType);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(paymentToRegisteredBeneOnlyDropDown,PaymentToRegisteredBeneficiaryOnly);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(purposeCodeEnableDropDown,PurposeCodeEnable);

			//click on ok button
			elementUtil.clickElement(okBtn);

			try {
				if(elementUtil.getText(errormessages).trim().toString().equals("No items available for Approve operation".trim().toString()))
				{
					log.info("Record With [ Purpose Code : " +purposeCode+ " , Payment Type : " +paymentType+ " , PaymentToRegisteredBeneficiaryOnly : " +PaymentToRegisteredBeneficiaryOnly+ " , Purpose Code Enable : " +PurposeCodeEnable+  " ] Not Found For Approve Operation");
					log.info("No items available for Approve operation Validation Message Displayed Is Correct");
				}//end of if
				else
				{
					log.info("Record With [ Purpose Code : " +purposeCode+ " , Payment Type : " +paymentType+ " , PaymentToRegisteredBeneficiaryOnly : " +PaymentToRegisteredBeneficiaryOnly+ " , Purpose Code Enable : " +PurposeCodeEnable+  " ] Not Found For Approve Operation");
					log.error("No items available for Approve operation Validation Message Displayed Is Incorrect");
				}//end of else
			} catch (NoSuchElementException e) {
				//click on record
				System.out.println("in catch");
				elementUtil.clickElement(screenRecord);
				try {
					System.out.println("in try");
					elementUtil.SHORT_TIMEOUT();
					if(elementUtil.getText(errormessages).trim().toString().equals("Operation failed to execute: User cannot approve own modification.".trim().toString()))
					{
						log.info("Record With [ Purpose Code : " +purposeCode+ " , Payment Type : " +paymentType+ " , PaymentToRegisteredBeneficiaryOnly : " +PaymentToRegisteredBeneficiaryOnly+ " , Purpose Code Enable : " +PurposeCodeEnable+  " ] Approve Operation Failed : User Cannot Approve Own Modification");

					}//end of if
				} catch (NoSuchElementException e2) {
					if(elementUtil.getAttribute(purposeCodeTxtField).trim().toString().equals(purposeCode.trim().toString()))
					{
						System.out.println("in if");
						//click on Cancel button
						elementUtil.clickElement(cancelBtn);
						if(elementUtil.getText(errormessages).trim().toString().equals("Operation was cancelled.".trim().toString()))
						{
							log.info("Cancel Button Is Working Properly");
						}//end of if
						else
						{
							log.error("Cancel Button Is Not Working Properly"); 
						}//end of else

						//click on Record
						elementUtil.clickElement(screenRecord);

						//check if operation is Reject OR Approve
						if(operation.equalsIgnoreCase("Reject".trim().toString()))
						{
							System.out.println("in if for reject");
							if(rejectionReason.isEmpty())
							{
								System.out.println("in if no reject reason");
								log.info("Failed To Perform Reject Operation As No Rejection Reason Provided");
							}//end of if
							else
							{
//								System.out.println("in else reject reASON provided");
								elementUtil.SHORT_TIMEOUT();
								elementUtil.enterText(rejctionTxtBox,rejectionReason);
								elementUtil.clickElement(rejectBtn);
								//checking if record approved successfully
								if(elementUtil.getText(screenValidationMessage).trim().toString().equals("Operation Approve executed successfully. PurposeCode placed in next queue.".trim().toString()))
								{
									log.info("Record With [ Purpose Code : " +purposeCode+ " , Payment Type : " +paymentType+ " , Payment To Registered Beneficiary Only : " +PaymentToRegisteredBeneficiaryOnly+ " , Purpose Code Enable : " +PurposeCodeEnable+ " ] Rejected Successfully");
								}//end of if

							}//end of else

						}//end of if
						else if(operation.equalsIgnoreCase("Approve".trim().toString()))
						{
							System.out.println("in else if for approve");
							//click on Approve button
							elementUtil.clickElement(approveBtn);
							//checking if record approved successfully
							if(elementUtil.getText(screenValidationMessage).trim().toString().equals("Operation Approve executed successfully. PurposeCode placed in next queue.".trim().toString()))
							{
								log.info("Record With [ Purpose Code : " +purposeCode+ " , Payment Type : " +paymentType+ " , Payment To Registered Beneficiary Only : " +PaymentToRegisteredBeneficiaryOnly+ " , Purpose Code Enable : " +PurposeCodeEnable+ " ] Approved Successfully");
							}//end of if

						}//end of else if
						else
						{
							log.info("No Operation Performed On Purpose Code Record, As Operation Value Not Provided");
						}//end of else

					}//end of if
					else
					{
						log.info("Record Mismatch, Record With [ Purpose Code : " +purposeCode+ " , Payment Type : " +paymentType+ " , Payment To Registered Beneficiary Only : " +PaymentToRegisteredBeneficiaryOnly+ " , Purpose Code Enable : " +PurposeCodeEnable+ " ] Not Found For Approve Operation");
					}//end of else

				}//end of catch

			}//end of catch
		}//end of catch	

		//perform logout operation
		elementUtil.handlewin1(driver);
		logOutOperation();

	}//end of approvePurposeCodeRecord function

	//------------------------Method to List Purpose Code Record -------------------------------
	public void listPurposeCodeRecord(String SheetName) throws InvalidFormatException, IOException, InterruptedException  {
		//fetch details
		test_Data=fileReader.readPurposeCodeExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String purposeCode=map.get("Purpose Code");
			String paymentType=map.get("Payment Type");
			String PaymentToRegisteredBeneficiaryOnly=map.get("Payment To Registered Beneficiary Only(Y/N)");
			String PurposeCodeEnable=map.get("Purpose Code Enable(Y/N)");
			
			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(restartWorkFlowBtn);

			//enter details 
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(purposeCodeTxtField,purposeCode);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(PaymentTypeDropDown,paymentType);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(paymentToRegisteredBeneOnlyDropDown,PaymentToRegisteredBeneficiaryOnly);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(purposeCodeEnableDropDown,PurposeCodeEnable);

			//click on Reset button
			elementUtil.clickElement(resetBtn);

			//check reset button working
			if(elementUtil.getText(purposeCodeTxtField).isEmpty())
			{
				log.info("Reset Button Is Working Properly");
			}//end of if
			else
			{
				log.error("Reset Button Is Not Working Properly");
			}//end of else

			//enter details 
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(purposeCodeTxtField,purposeCode);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(PaymentTypeDropDown,paymentType);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(paymentToRegisteredBeneOnlyDropDown,PaymentToRegisteredBeneficiaryOnly);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(purposeCodeEnableDropDown,PurposeCodeEnable);

			//click on ok button
			elementUtil.clickElement(okBtn);

			try {
				if(elementUtil.getText(errormessages).trim().toString().equals("No items available for List operation".trim().toString()))
				{
					log.info("Record With [ Purpose Code : " +purposeCode+ " , Payment Type : " +paymentType+ " , PaymentToRegisteredBeneficiaryOnly : " +PaymentToRegisteredBeneficiaryOnly+ " , Purpose Code Enable : " +PurposeCodeEnable+  " ] Not Found For List Operation");
					log.info("No items available for List operation Validation Message Displayed Is Correct");
				}//end of if
				else
				{
					log.info("Record With [ Purpose Code : " +purposeCode+ " , Payment Type : " +paymentType+ " , PaymentToRegisteredBeneficiaryOnly : " +PaymentToRegisteredBeneficiaryOnly+ " , Purpose Code Enable : " +PurposeCodeEnable+  " ] Not Found For List Operation");
					log.error("No items available for List operation Validation Message Displayed Is Incorrect");
				}//end of else
			} catch (NoSuchElementException e) {
				//click on record
				elementUtil.clickElement(screenRecord);
				if(elementUtil.getAttribute(purposeCodeTxtField).trim().toString().equals(purposeCode.trim().toString()))
				{
					log.info("Record With [ Purpose Code : " +purposeCode+ " , Payment Type : " +paymentType+ " , PaymentToRegisteredBeneficiaryOnly : " +PaymentToRegisteredBeneficiaryOnly+ " , Purpose Code Enable : " +PurposeCodeEnable+  " ] Is Displayed In List");

				}//end of if
				else
				{
					log.info("Record Mismatch, Record With [ Purpose Code : " +purposeCode+ " , Payment Type : " +paymentType+ " , PaymentToRegisteredBeneficiaryOnly : " +PaymentToRegisteredBeneficiaryOnly+ " , Purpose Code Enable : " +PurposeCodeEnable+  " ] Is Not Displayed In List");
				}//end of else

			}//end of catch

		}//end of catch	

		elementUtil.handlewin1(driver);
		logOutOperation();

	}//end of listPurposeCodeRecord function

	//------------------------Method to Delete Purpose Code Record -------------------------------
	public void deletepurposeCodeRecord(String SheetName) throws InvalidFormatException, IOException, InterruptedException  {
		//fetch details
		test_Data=fileReader.readPurposeCodeExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String purposeCode=map.get("Purpose Code");
			String paymentType=map.get("Payment Type");
			String PaymentToRegisteredBeneficiaryOnly=map.get("Payment To Registered Beneficiary Only(Y/N)");
			String PurposeCodeEnable=map.get("Purpose Code Enable(Y/N)");
			
			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(restartWorkFlowBtn);

			//enter details 
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(purposeCodeTxtField,purposeCode);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(PaymentTypeDropDown,paymentType);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(paymentToRegisteredBeneOnlyDropDown,PaymentToRegisteredBeneficiaryOnly);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(purposeCodeEnableDropDown,PurposeCodeEnable);

			//click on Reset button
			elementUtil.clickElement(resetBtn);

			//check reset button working
			if(elementUtil.getText(purposeCodeTxtField).isEmpty())
			{
				log.info("Reset Button Is Working Properly");
			}//end of if
			else
			{
				log.error("Reset Button Is Not Working Properly");
			}//end of else

			//enter details 
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(purposeCodeTxtField,purposeCode);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(PaymentTypeDropDown,paymentType);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(paymentToRegisteredBeneOnlyDropDown,PaymentToRegisteredBeneficiaryOnly);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(purposeCodeEnableDropDown,PurposeCodeEnable);

			//click on ok button
			elementUtil.clickElement(okBtn);

			try {
				if(elementUtil.getText(errormessages).trim().toString().equals("No items available for Delete operation".trim().toString()))
				{
					log.info("Record With [ Purpose Code : " +purposeCode+ " , Payment Type : " +paymentType+ " , PaymentToRegisteredBeneficiaryOnly : " +PaymentToRegisteredBeneficiaryOnly+ " , Purpose Code Enable : " +PurposeCodeEnable+  " ] Not Found For Delete Operation");
					log.info("No items available for Delete operation Validation Message Displayed Is Correct");
				}//end of if
				else
				{
					log.info("Record With [ Purpose Code : " +purposeCode+ " , Payment Type : " +paymentType+ " , PaymentToRegisteredBeneficiaryOnly : " +PaymentToRegisteredBeneficiaryOnly+ " , Purpose Code Enable : " +PurposeCodeEnable+  " ] Not Found For Delete Operation");
					log.error("No items available for Delete operation Validation Message Displayed Is Incorrect");
				}//end of else
			} catch (NoSuchElementException e) {
				//click on record
				elementUtil.clickElement(screenRecord);
				if(elementUtil.getAttribute(purposeCodeTxtField).trim().toString().equals(purposeCode.trim().toString()))
				{
					//click on cancel button
					elementUtil.clickElement(cancelBtn);
					//check working of cancel button
					if(elementUtil.getText(errormessages).trim().toString().equals("Operation was cancelled.".trim().toString()))
					{
						log.info("Cancel Button Is Working Properly");
					}//end of if
					else
					{
						log.error("Cancel Button Is Not Working Properly");
					}//end of else

					//click on record
					elementUtil.clickElement(screenRecord);

					//click on Delete button
					elementUtil.clickElement(deleteBtn);
					if(elementUtil.getText(screenValidationMessage).trim().toString().equals("Operation Delete executed successfully. PurposeCode placed in next queue.".trim().toString()))
					{
						log.info("Record With [ Purpose Code : " +purposeCode+ " , Payment Type : " +paymentType+ " , PaymentToRegisteredBeneficiaryOnly : " +PaymentToRegisteredBeneficiaryOnly+ " , Purpose Code Enable : " +PurposeCodeEnable+  " ] Deleted Successfully");

					}//end of if


				}//end of if
				else
				{
					log.info("Record Mismatch, Record With [ Purpose Code : " +purposeCode+ " , Payment Type : " +paymentType+ " , PaymentToRegisteredBeneficiaryOnly : " +PaymentToRegisteredBeneficiaryOnly+ " , Purpose Code Enable : " +PurposeCodeEnable+  " ] Not Found For Delete");
				}//end of else

			}//end of catch	

		}//end of catch	

		//perform logout operation
		elementUtil.handlewin1(driver);
		logOutOperation();

	}//end of deletePurposeCodeRecord function

	//------------------------Method to Modify Purpose Code Record -------------------------------
	public void modifyPurposeCodeRecord(String SheetName) throws InvalidFormatException, IOException, InterruptedException  {
		//fetch details
		test_Data=fileReader.readPurposeCodeExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String purposeCode=map.get("Purpose Code");
			String originalPaymentType=map.get("Original Payment Type");
			String paymentType=map.get("Payment Type");
			String originalPaymentToRegisteredBeneficiaryOnly=map.get("Original Payment To Registered Beneficiary Only(Y/N)");
			String PaymentToRegisteredBeneficiaryOnly=map.get("Payment To Registered Beneficiary Only(Y/N)");
			String originalPurposeCodeEnable=map.get("Original Purpose Code Enable(Y/N)");
			String PurposeCodeEnable=map.get("Purpose Code Enable(Y/N)");
			String description=map.get("Description");

			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(restartWorkFlowBtn);
			
			//enter details 
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(purposeCodeTxtField,purposeCode);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(PaymentTypeDropDown,originalPaymentType);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(paymentToRegisteredBeneOnlyDropDown,originalPaymentToRegisteredBeneficiaryOnly);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(purposeCodeEnableDropDown,originalPurposeCodeEnable);

			
			//click on ok button
			elementUtil.clickElement(okBtn);

			try {
				if(elementUtil.getText(errormessages).trim().toString().equals("No items available for Modify operation".trim().toString()))
				{
					log.info("Record With [ Purpose Code : " +purposeCode+ " , Payment Type : " +originalPaymentType+ " , PaymentToRegisteredBeneficiaryOnly : " +originalPaymentToRegisteredBeneficiaryOnly+ " , Purpose Code Enable : " +originalPurposeCodeEnable+  " ] Not Found For Modify Operation");
					log.info("No items available for Modify operation Validation Message Displayed Is Correct");
				}//end of if
				else
				{
					log.info("Record With [ Purpose Code : " +purposeCode+ " , Payment Type : " +originalPaymentType+ " , PaymentToRegisteredBeneficiaryOnly : " +originalPaymentToRegisteredBeneficiaryOnly+ " , Purpose Code Enable : " +originalPurposeCodeEnable+  " ] Not Found For Modify Operation");
					log.error("No items available for Modify operation Validation Message Displayed Is Incorrect");
				}//end of else
			} catch (NoSuchElementException e) {
				//click on record
				elementUtil.clickElement(screenRecord);
				if(elementUtil.getAttribute(purposeCodeTxtField).trim().toString().equals(purposeCode.trim().toString()))
				{
					//click on cancel button
					elementUtil.clickElement(cancelBtn);
					//check working of cancel button
					if(elementUtil.getText(errormessages).trim().toString().equals("Operation was cancelled.".trim().toString()))
					{
						log.info("Cancel Button Is Working Properly");
					}//end of if
					else
					{
						log.error("Cancel Button Is Not Working Properly");
					}//end of else

					//click on record
					elementUtil.clickElement(screenRecord);

					//enter details 
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(DescriptionTxtField);
					elementUtil.enterText(DescriptionTxtField, description);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.selectDropDownByVisibleText(PaymentTypeDropDown,paymentType);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.selectDropDownByVisibleText(paymentToRegisteredBeneOnlyDropDown,PaymentToRegisteredBeneficiaryOnly);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.selectDropDownByVisibleText(purposeCodeEnableDropDown,PurposeCodeEnable);

					//click on ok button
					elementUtil.clickElement(okBtn);
					try {
						String expected="Purpose Code " +purposeCode+ " already exists";
						if(elementUtil.getText(errormessages).trim().toString().equals(expected))
						{
							
							log.info("Duplicate Record Found : Record With Purpose Code " +purposeCode+ " Already Exists");
						}//end of if
						else
						{
							log.error("Data Provided For Modify operation Is Not As Per Valid Format OR Duplicate Record Validation Message Displayed Is Incorrrect");
						}//end of else
					} catch (NoSuchElementException e2) {
						//click on cancel button
						elementUtil.clickElement(cancelBtn);

						if(elementUtil.getText(errormessages).trim().toString().equals("Operation was cancelled.".trim().toString()))
						{
							log.info("Cancel Button Is Working Properly");
						}//end of if
						else
						{
							log.error("Cancel Button Is Not Working Properly");
						}//end of else

						//click on Record
						elementUtil.clickElement(screenRecord);

						//clear field values
						//enter details 
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(DescriptionTxtField);
						elementUtil.enterText(DescriptionTxtField, description);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.selectDropDownByVisibleText(PaymentTypeDropDown,paymentType);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.selectDropDownByVisibleText(paymentToRegisteredBeneOnlyDropDown,PaymentToRegisteredBeneficiaryOnly);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.selectDropDownByVisibleText(purposeCodeEnableDropDown,PurposeCodeEnable);

						//click on ok button
						elementUtil.clickElement(okBtn);

						//click on submit button
						elementUtil.clickElement(submitBtn);

						if(elementUtil.getText(screenValidationMessage).trim().toString().equals("Operation Modify executed successfully. PurposeCode placed in next queue.".trim().toString()))
						{
							log.info("Record With Original Values [ Purpose Code : " +purposeCode+ " , Payment Type : " +originalPaymentType+ " , PaymentToRegisteredBeneficiaryOnly : " +originalPaymentToRegisteredBeneficiaryOnly+ " , Purpose Code Enable : " +originalPurposeCodeEnable+  " ] Modified Successfully With Updated Values [ Purpose Code : " +purposeCode+ " , Payment Type : " +paymentType+ " , PaymentToRegisteredBeneficiaryOnly : " +PaymentToRegisteredBeneficiaryOnly+ " , Purpose Code Enable : " +PurposeCodeEnable+  " ]");
						}//end of if

					}//end of catch


				}//end of if
				else
				{
					log.info("Record Mismatch, Record With Original Values [ Purpose Code : " +purposeCode+ " , Payment Type : " +originalPaymentType+ " , PaymentToRegisteredBeneficiaryOnly : " +originalPaymentToRegisteredBeneficiaryOnly+ " , Purpose Code Enable : " +originalPurposeCodeEnable+  " ] Not Found For Modify");
				}//end of else

			}//end of catch	

		}//end of catch	

		//perform logout operation
		elementUtil.handlewin1(driver);
		logOutOperation();

	}//end of modifyPurposeCodeRecord function

	//-----------------------Method To Enter Purpose Code With Invalid Data---------------------------

	public void enterPurposeCodeRecordInvalidData(String SheetName) throws InvalidFormatException, IOException, InterruptedException  {

		//click on ok button
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(okBtn);

		//Checking Mandatory Fields Message Validation
		String expectedMandatoryFieldMessage="All fields are mandatory.";

		//getting actual Message from screen
		String actualMandatoryFieldMessage=elementUtil.getText(errormessages);

		if(actualMandatoryFieldMessage.trim().toString().equals(expectedMandatoryFieldMessage))
		{
			log.info("Mandatory Fields Validation Message Displayed Is Correct");
		}//end of if
		else
		{
			log.error("Mandatory Fields Validation Message Displayed Is Incorrect");
		}//end of else

		//fetch details
		test_Data=fileReader.readPurposeCodeExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String purposeCode=map.get("Purpose Code");
			String description=map.get("Description");
			String paymentType=map.get("Payment Type");
			String PaymentToRegisteredBeneficiaryOnly=map.get("Payment To Registered Beneficiary Only(Y/N)");
			
			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(restartWorkFlowBtn);

			//enter details 
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(purposeCodeTxtField,purposeCode);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(DescriptionTxtField,description);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(PaymentTypeDropDown,paymentType);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(paymentToRegisteredBeneOnlyDropDown,PaymentToRegisteredBeneficiaryOnly);

			//click on OK button
			elementUtil.clickElement(okBtn);

			try {
				String actualErrorMessage=elementUtil.getText(errormessages);
				log.info(actualErrorMessage);
			} catch (NoSuchElementException e) {
				log.info("Test Data Provided Is Not Invalid");
			}//end of catch

		}//end of for loop

		//perform logout operation
		elementUtil.handlewin1(driver);
		logOutOperation();

	}//end of enterPurposeCodeRecordInvalidData function

	//--------------------------------Modify Purpose Code With Invalid Data-------------------------
	public void modifyPurposeCodeRecordInvalidData(String SheetName) throws InvalidFormatException, IOException, InterruptedException  {
		//fetch details
		test_Data=fileReader.readPurposeCodeExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String purposeCode=map.get("Purpose Code");
			String originalPaymentType=map.get("Original Payment Type");
			String paymentType=map.get("Payment Type");
			String originalPaymentToRegisteredBeneficiaryOnly=map.get("Original Payment To Registered Beneficiary Only(Y/N)");
			String PaymentToRegisteredBeneficiaryOnly=map.get("Payment To Registered Beneficiary Only(Y/N)");
			String originalPurposeCodeEnable=map.get("Original Purpose Code Enable(Y/N)");
			String PurposeCodeEnable=map.get("Purpose Code Enable(Y/N)");
			String description=map.get("Description");
			
			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(restartWorkFlowBtn);
			

			//enter details 
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(purposeCodeTxtField,purposeCode);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(PaymentTypeDropDown,originalPaymentType);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(paymentToRegisteredBeneOnlyDropDown,originalPaymentToRegisteredBeneficiaryOnly);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(purposeCodeEnableDropDown,originalPurposeCodeEnable);

			//click on ok button
			elementUtil.clickElement(okBtn);

			try {
				if(elementUtil.getText(errormessages).trim().toString().equals("No items available for Modify operation".trim().toString()))
				{
					log.info("Record With [ Purpose Code : " +purposeCode+ " , Payment Type : " +originalPaymentType+ " , PaymentToRegisteredBeneficiaryOnly : " +originalPaymentToRegisteredBeneficiaryOnly+ " , Purpose Code Enable : " +originalPurposeCodeEnable+  " ] Not Found For Modify Operation");
					log.info("No items available for Modify operation Validation Message Displayed Is Correct");
				}//end of if
				else
				{
					log.info("Record With [ Purpose Code : " +purposeCode+ " , Payment Type : " +originalPaymentType+ " , PaymentToRegisteredBeneficiaryOnly : " +originalPaymentToRegisteredBeneficiaryOnly+ " , Purpose Code Enable : " +originalPurposeCodeEnable+  " ] Not Found For Modify Operation");
					log.error("No items available for Modify operation Validation Message Displayed Is Incorrect");
				}//end of else
			} catch (NoSuchElementException e) {
				//click on record
				elementUtil.clickElement(screenRecord);
				if(elementUtil.getAttribute(purposeCodeTxtField).trim().toString().equals(purposeCode.trim().toString()))
				{
					
					//enter details 
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(DescriptionTxtField);
					elementUtil.enterText(DescriptionTxtField, description);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.selectDropDownByVisibleText(PaymentTypeDropDown,paymentType);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.selectDropDownByVisibleText(paymentToRegisteredBeneOnlyDropDown,PaymentToRegisteredBeneficiaryOnly);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.selectDropDownByVisibleText(purposeCodeEnableDropDown,PurposeCodeEnable);

					//click on ok button
					elementUtil.clickElement(okBtn);
					try {
						String actualErrorMessage=elementUtil.getText(errormessages);
						log.info(actualErrorMessage);
					} catch (NoSuchElementException e2) {
						log.info("Test Data Provided Is Not Invalid");
					}//end of catch
				}//end of if
				else
				{
					log.info("Record Mismatch, Record With Original Values [ Purpose Code : " +purposeCode+ " , Payment Type : " +originalPaymentType+ " , PaymentToRegisteredBeneficiaryOnly : " +originalPaymentToRegisteredBeneficiaryOnly+ " , Purpose Code Enable : " +originalPurposeCodeEnable+  " ] Not Found For Modify");
				}//end of else

			}//end of catch	

		}//end of catch	

		//perform logout operation
		elementUtil.handlewin1(driver);
		logOutOperation();

	}//end of modifyPurposeCodeRecord function


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



}//end of main class PurposeCodePage
