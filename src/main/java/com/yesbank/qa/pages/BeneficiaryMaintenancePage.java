package com.yesbank.qa.pages;

/*
 * Class Description :
 * Class Namely BeneficiaryMaintenancePage is class involving all methods related to Beneficiary Maintenance Menu
 * which allows user to perform different operation related to Beneficiary Maintenance Module
 */

//imports
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.yesbank.qa.util.ElementUtil;
import com.yesbank.qa.util.FileReadUtils;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.log4j.Logger;

public class BeneficiaryMaintenancePage {
	private WebDriver driver;
	ElementUtil elementUtil;
	FileReadUtils fileReader;
	HomePage homePage;
	List<Map<String, String>> test_Data;

	Logger log = Logger.getLogger(BeneficiaryMaintenancePage.class);

	//Beneficiary Maintenance Menu Web Elements
	@FindBy(name = "customerKey")
	WebElement custIdTxtField;

	@FindBy(name = "payeeLinkIdValue")
	WebElement srcAccountDropDown;

	@FindBy(name = "customerType")
	WebElement customerTypeDropDown;

	@FindBy(name = "supportedPaymentType")
	WebElement supportedPaymentDropDown;

	@FindBy(name = "purposeCode")
	WebElement PurposeCodeDropDown;

	@FindBy(name = "payeeKey")
	WebElement beneCodeTxtField;

	@FindBy(name = "name")
	WebElement beneNameTxtField;

	@FindBy(name = "addressLine1")
	WebElement addressLine1TxtField;

	@FindBy(name = "addressLine2")
	WebElement addressLine2TxtField;

	@FindBy(name = "phoneNo")
	WebElement phoneNoTxtField;

	@FindBy(name = "emailAddress")
	WebElement emailAddressTxtField;

	@FindBy(name = "accountNumber")
	WebElement beneAccountTxtField;

	@FindBy(name = "bankName")
	WebElement beneBankNameTxtField;

	@FindBy(name = "bankIdType")
	WebElement beneBankIdTypeDropDown;

	@FindBy(name = "bankIdValue")
	WebElement beneBankIdTypeValueTxtField;

	@FindBy(name = "currencyCode")
	WebElement currencyCodeDropDown;

	@FindBy(name = "transactionLimit")
	WebElement transactionLimitTxtField;

	@FindBy(name = "expiryDate")
	WebElement expiryDateTxtField;

	@FindBy(name = "upiHandle")
	WebElement upiHandlerTxtField;

	@FindBy(name = "extParam1")
	WebElement extParam1TxtField;

	@FindBy(name = "extParam2")
	WebElement extParam2TxtField;

	@FindBy(name = "extParam3")
	WebElement extParam3TxtField;

	@FindBy(name = "extParam4")
	WebElement extParam4TxtField;

	@FindBy(name = "extParam5")
	WebElement extParam5TxtField;

	@FindBy(name = "extParam6")
	WebElement extParam6TxtField;

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

	@FindBy(xpath="//body[1]/div[4]/center[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[2]")
	WebElement custIdTxtFieldValue_ListScreen;

	@FindBy(xpath="//body[1]/div[4]/center[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[2]")
	WebElement srcAccountNoTxtFieldValue_ListScreen;

	@FindBy(xpath="//tbody/tr[7]/td[2]")
	WebElement beneCodeTxtFieldValue_ListScreen;

	@FindBy(xpath="//tbody/tr[6]/td[2]")
	WebElement purposeCodeTxtFieldValue_ListScreen;

	@FindBy(xpath="//tbody/tr[5]/td[2]")
	WebElement paymentTypeTxtFieldValue_ListScreen;

	@FindBy(xpath="//*[@id=\"printable\"]/center/p[2]")
	WebElement screenValidationMessage;

	@FindBy(id="rejectionText")
	WebElement rejctionTxtBox;

	@FindBy(id="btnReject")
	WebElement rejectBtn;

	@FindBy(name="approve")
	WebElement deleteBtn;

	//Beneficiary Maintenance Page Constructor
	public BeneficiaryMaintenancePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.fileReader=new FileReadUtils(driver);
		this.elementUtil=new ElementUtil(driver);
		this.homePage=new HomePage(driver);
	}//end of constructor


	//------------------------Method to Enter Beneficiary Record With Valid Data-------------------------------
	public void enterBeneficiaryRecord(String SheetName) throws InvalidFormatException, IOException, InterruptedException  {

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
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(okBtn);

		//Checking Mandatory Fields Message Validation
		String expectedMandatoryFieldMessage="Customer id is mandatory.\n" + "Beneficiary name is mandatory.\n" + "Source account number is mandatory.\n" + "Payment Type is mandatory.\n" + "Beneficiary code is mandatory.";

		//getting actual Message from screen
		elementUtil.SHORT_TIMEOUT();
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
		test_Data=fileReader.readBeneficiaryMaintenanceExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String customerId=map.get("Customer ID");
			String SrcAccNo=map.get("Source Account No.");
			String CustomerType=map.get("Customer Type");
			String supportedPayment=map.get("Supported Payment");
			String PurposeCode=map.get("Purpose Code");
			String beneficiaryCode=map.get("Beneficiary Code");
			String BeneficiaryName=map.get("Beneficiary Name");
			String AddressLine1=map.get("Address Line 1");
			String AddressLine2=map.get("Address Line 2");
			String PhoneNo=map.get("Phone No.");
			String EmailAddress=map.get("Email Address");
			String BeneficiaryAccountNo=map.get("Beneficiary Account Number");
			String BeneficiaryBankName=map.get("Beneficiary Bank Name");
			String BeneficiaryBankId=map.get("Beneficiary Bank Id");
			String BeneficiaryBankIdValue=map.get("Beneficiary Bank Id Value");
			String CurrencyCode=map.get("Currency Code");
			String TransactionLimit=map.get("Transaction Limit");
			String ExpiryDate=map.get("Expiry Date");
			String UPIHandler=map.get("UPI Handler");
			String ExtParam1=map.get("ExtParam1");
			String ExtParam2=map.get("ExtParam2");
			String ExtParam3=map.get("ExtParam3");
			String ExtParam4=map.get("ExtParam4");
			String ExtParam5=map.get("ExtParam5");
			String ExtParam6=map.get("ExtParam6");
			
			//click on RestartWorkFlow
			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(restartWorkFlowBtn);

			//enter details 
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(custIdTxtField,customerId);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(srcAccountDropDown, SrcAccNo);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(supportedPaymentDropDown, supportedPayment);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(PurposeCodeDropDown,PurposeCode);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(beneCodeTxtField, beneficiaryCode);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(beneNameTxtField, BeneficiaryName);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(addressLine1TxtField, AddressLine1);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(addressLine2TxtField,AddressLine2);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(phoneNoTxtField,PhoneNo);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(emailAddressTxtField, EmailAddress);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(beneAccountTxtField,BeneficiaryAccountNo);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(beneBankNameTxtField,BeneficiaryBankName);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(beneBankIdTypeDropDown,BeneficiaryBankId);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(beneBankIdTypeValueTxtField,BeneficiaryBankIdValue);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(currencyCodeDropDown, CurrencyCode);
			if(!TransactionLimit.isEmpty())
			{
				elementUtil.clearText(transactionLimitTxtField);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(transactionLimitTxtField,TransactionLimit);

			}
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(expiryDateTxtField,ExpiryDate);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(upiHandlerTxtField,UPIHandler);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(extParam1TxtField, ExtParam1);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(extParam2TxtField, ExtParam2);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(extParam3TxtField, ExtParam3);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(extParam4TxtField, ExtParam4);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(extParam5TxtField, ExtParam5);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(extParam6TxtField, ExtParam6);

			//click on OK button
			elementUtil.clickElement(okBtn);

			try {
				if(elementUtil.getText(errormessages).trim().toString().equals("Customer ID+ Beneficiary Code+ Source Account Number+ Payment Type same combination record exists".trim().toString()) || elementUtil.getText(errormessages).trim().toString().contains("Record already exists but pending for approval with Beneficiary Code as".trim().toString()) || elementUtil.getText(errormessages).trim().toString().contains("Record already exists with Beneficiary Code as".trim().toString()))
				{
					log.info("Duplicate Record Found");
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

				//enter details after cancel operation
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(custIdTxtField,customerId);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.selectDropDownByVisibleText(srcAccountDropDown, SrcAccNo);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.selectDropDownByVisibleText(customerTypeDropDown,CustomerType);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.selectDropDownByVisibleText(supportedPaymentDropDown, supportedPayment);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.selectDropDownByVisibleText(PurposeCodeDropDown,PurposeCode);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(beneCodeTxtField, beneficiaryCode);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(beneNameTxtField, BeneficiaryName);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(addressLine1TxtField, AddressLine1);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(addressLine2TxtField,AddressLine2);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(phoneNoTxtField,PhoneNo);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(emailAddressTxtField, EmailAddress);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(beneAccountTxtField,BeneficiaryAccountNo);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(beneBankNameTxtField,BeneficiaryBankName);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.selectDropDownByVisibleText(beneBankIdTypeDropDown,BeneficiaryBankId);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(beneBankIdTypeValueTxtField,BeneficiaryBankIdValue);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.selectDropDownByVisibleText(currencyCodeDropDown, CurrencyCode);
				if(!TransactionLimit.isEmpty())
				{
					elementUtil.clearText(transactionLimitTxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(transactionLimitTxtField,TransactionLimit);

				}//end of if
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(expiryDateTxtField,ExpiryDate);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(upiHandlerTxtField,UPIHandler);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(extParam1TxtField, ExtParam1);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(extParam2TxtField, ExtParam2);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(extParam3TxtField, ExtParam3);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(extParam4TxtField, ExtParam4);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(extParam5TxtField, ExtParam5);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(extParam6TxtField, ExtParam6);

				//Click on Reset button
				elementUtil.clickElement(resetBtn);

				//check working of Reset button
				if(elementUtil.getText(custIdTxtField).isEmpty() && elementUtil.getText(customerTypeDropDown).equals("Nodal") && elementUtil.getText(supportedPaymentDropDown).isEmpty() && elementUtil.getText(PurposeCodeDropDown).trim().toString().equals("ALL".trim().toString()) && elementUtil.getText(beneCodeTxtField).isEmpty() && elementUtil.getText(beneNameTxtField).isEmpty() && elementUtil.getText(addressLine1TxtField).isEmpty() && elementUtil.getText(addressLine2TxtField).isEmpty() && elementUtil.getAttribute(phoneNoTxtField).isEmpty() && elementUtil.getText(emailAddressTxtField).isEmpty() && elementUtil.getText(beneAccountTxtField).isEmpty() && elementUtil.getText(beneBankNameTxtField).isEmpty() && elementUtil.getText(beneBankIdTypeDropDown).trim().toString().equals("IFSC".trim().toString()) && elementUtil.getText(beneBankIdTypeValueTxtField).isEmpty() && elementUtil.getText(currencyCodeDropDown).trim().toString().equals("INR".trim().toString()) && elementUtil.getText(transactionLimitTxtField).isEmpty() && elementUtil.getText(expiryDateTxtField).isEmpty() && elementUtil.getText(upiHandlerTxtField).isEmpty() && elementUtil.getText(extParam1TxtField).isEmpty() && elementUtil.getText(extParam2TxtField).isEmpty() && elementUtil.getText(extParam3TxtField).isEmpty() && elementUtil.getText(extParam4TxtField).isEmpty() && elementUtil.getText(extParam5TxtField).isEmpty() && elementUtil.getText(extParam6TxtField).isEmpty())
				{
					log.info("Reset Button Is Working Properly");
				}//end of if
				else
				{
					log.error("Reset Button Is Not Working Properly");
				}//end of else

				//enter details after Reset Operation
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(custIdTxtField,customerId);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.selectDropDownByVisibleText(srcAccountDropDown, SrcAccNo);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.selectDropDownByVisibleText(customerTypeDropDown,CustomerType);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.selectDropDownByVisibleText(supportedPaymentDropDown, supportedPayment);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.selectDropDownByVisibleText(PurposeCodeDropDown,PurposeCode);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(beneCodeTxtField, beneficiaryCode);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(beneNameTxtField, BeneficiaryName);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(addressLine1TxtField, AddressLine1);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(addressLine2TxtField,AddressLine2);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(phoneNoTxtField,PhoneNo);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(emailAddressTxtField, EmailAddress);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(beneAccountTxtField,BeneficiaryAccountNo);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(beneBankNameTxtField,BeneficiaryBankName);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.selectDropDownByVisibleText(beneBankIdTypeDropDown,BeneficiaryBankId);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(beneBankIdTypeValueTxtField,BeneficiaryBankIdValue);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.selectDropDownByVisibleText(currencyCodeDropDown, CurrencyCode);
				if(!TransactionLimit.isEmpty())
				{
					elementUtil.clearText(transactionLimitTxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(transactionLimitTxtField,TransactionLimit);

				}//end of if
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(expiryDateTxtField,ExpiryDate);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(upiHandlerTxtField,UPIHandler);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(extParam1TxtField, ExtParam1);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(extParam2TxtField, ExtParam2);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(extParam3TxtField, ExtParam3);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(extParam4TxtField, ExtParam4);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(extParam5TxtField, ExtParam5);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(extParam6TxtField, ExtParam6);

				//click on ok button
				elementUtil.clickElement(okBtn);

				//click on Submit button
				elementUtil.clickElement(submitBtn);
				//check if record added successfully
				if(elementUtil.getText(messages).trim().toString().equals("Operation Enter executed successfully. Beneficiary record placed in next queue.".trim().toString()))
				{
					log.info("Beneficiary Record With Beneficiary Code " +beneficiaryCode + " Added Successfully ");
				}//end of if

			}//end of catch

		}//end of for loop

		elementUtil.handlewin1(driver);
		logOutOperation();


	}//end of enterBeneficiaryRecord function

	//------------------------Method to Approve OR Reject Beneficiary Record -------------------------------
	public void approveRejectBeneficiaryRecord(String SheetName) throws InvalidFormatException, IOException, InterruptedException  {
		test_Data=fileReader.readBeneficiaryMaintenanceExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String customerId=map.get("Customer ID");
			String SrcAccNo=map.get("Source Account No.");
			String supportedPayment=map.get("Supported Payment");
			String PurposeCode=map.get("Purpose Code");
			String beneficiaryCode=map.get("Beneficiary Code");
			String operation=map.get("Operation");
			String rejectionReason=map.get("Rejection Reason");

			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(restartWorkFlowBtn);

			//enter details
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(beneCodeTxtField, beneficiaryCode);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(custIdTxtField, customerId);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(srcAccountDropDown,SrcAccNo);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(supportedPaymentDropDown,supportedPayment);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(PurposeCodeDropDown, PurposeCode);

			//click on Reset button
			elementUtil.clickElement(resetBtn);


			//check reset button working
			if(elementUtil.getText(custIdTxtField).isEmpty() && elementUtil.getText(srcAccountDropDown).isEmpty() && elementUtil.getText(beneCodeTxtField).isEmpty())
			{
				log.info("Reset Button Is Working Properly");
			}//end of if
			else
			{
				log.error("Reset Button Is Not Working Properly");
			}//end of else

			//enter details after reset operation
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(beneCodeTxtField, beneficiaryCode);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(custIdTxtField, customerId);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(srcAccountDropDown,SrcAccNo);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(supportedPaymentDropDown,supportedPayment);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(PurposeCodeDropDown, PurposeCode);

			//click on ok button
			elementUtil.clickElement(okBtn);

			try {
				if(elementUtil.getText(errormessages).trim().toString().equals("No items available for Approve operation".trim().toString()))
				{
					log.info("Record With [ Beneficiary Code : " +beneficiaryCode+ " , Customer Id : " +customerId+ " , Source Account Number : " +SrcAccNo+ " ,Supported Payment Type : " +supportedPayment+ ", Purpose Code : " +PurposeCode+ " ] Not Found For Approve Operation");
					log.info("No items available for Approve operation Validation Message Displayed Is Correct");
				}//end of if
				else
				{
					log.info("Record With [ Beneficiary Code : " +beneficiaryCode+ " , Customer Id : " +customerId+ " , Source Account Number : " +SrcAccNo+ " ,Supported Payment Type : " +supportedPayment+ ", Purpose Code : " +PurposeCode+ " ] Not Found For Approve Operation");
					log.error("No items available for Approve operation Validation Message Displayed Is Incorrect");
				}//end of else
			} catch (NoSuchElementException e) {
				//click on record
				elementUtil.clickElement(screenRecord);
				try {
					elementUtil.SHORT_TIMEOUT();
					if(elementUtil.getText(errormessages).trim().toString().equals("Operation failed to execute: User cannot approve own modification.".trim().toString()))
					{
						log.info("Record With [ Beneficiary Code : " +beneficiaryCode+ " , Customer Id : " +customerId+ " , Source Account Number : " +SrcAccNo+ " ,Supported Payment Type : " +supportedPayment+ ", Purpose Code : " +PurposeCode+ " ] Approval Failed : User Cannot Approve Own Modification");

					}//end of if
				} catch (NoSuchElementException e2) {
					if(elementUtil.getAttribute(custIdTxtField).trim().toString().equals(customerId.trim().toString()) && elementUtil.getAttribute(beneCodeTxtField).trim().toString().equals(beneficiaryCode.trim().toString()))
					{
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
								
								log.info("Failed To Perform Reject Operation As No Rejection Reason Provided");
							}//end of if
							else
							{
								
								elementUtil.SHORT_TIMEOUT();
								elementUtil.enterText(rejctionTxtBox,rejectionReason);
								elementUtil.clickElement(rejectBtn);
								//checking if record approved successfully
								if(elementUtil.getText(screenValidationMessage).trim().toString().equals("Operation Approve executed successfully. Beneficiary record placed in next queue.".trim().toString()))
								{
									log.info("Record With [ Beneficiary Code : " +beneficiaryCode+ " , Customer Id : " +customerId+ " , Source Account Number : " +SrcAccNo+ " ,Supported Payment Type : " +supportedPayment+ ", Purpose Code : " +PurposeCode+ " ] Rejected Successfully");
								}//end of if
								

							}//end of else

						}//end of if
						else if(operation.equalsIgnoreCase("Approve".trim().toString()))
						{
							System.out.println("in else if for approve");
							//click on Approve button
							elementUtil.clickElement(approveBtn);
							//checking if record approved successfully
							if(elementUtil.getText(screenValidationMessage).trim().toString().equals("Operation Approve executed successfully. Beneficiary record placed in next queue.".trim().toString()))
							{
								log.info("Record With [ Beneficiary Code : " +beneficiaryCode+ " , Customer Id : " +customerId+ " , Source Account Number : " +SrcAccNo+ " ,Supported Payment Type : " +supportedPayment+ ", Purpose Code : " +PurposeCode+ " ] Approved Successfully");
							}//end of if

						}//end of else if
						else
						{
							log.info("No Operation Performed On Beneficiary Record, As Operation Value Not Provided");
						}//end of else

					}//end of if
					else
					{
						log.info("Record Mismatch, Record With [ Beneficiary Code : " +beneficiaryCode+ " , Customer Id : " +customerId+ " , Source Account Number : " +SrcAccNo+ " ,Supported Payment Type : " +supportedPayment+ ", Purpose Code : " +PurposeCode+ " ] Not Found For Approve Operation");
					}//end of else

				}//end of catch

			}//end of catch
		}//end of catch	

		//perform logout operation
		elementUtil.handlewin1(driver);
		logOutOperation();

	}//end of approveBeneficiaryRecord function


	//------------------------Method to List Beneficiary Record -------------------------------
	public void listBeneficiaryRecord(String SheetName) throws InvalidFormatException, IOException, InterruptedException  {
		//checking mandatory fields message
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(okBtn);

		if (elementUtil.getText(errormessages).trim().toString().equals("Customer ID and Beneficiary Code is mandatory.".trim().toString())) {
			log.info("Mandatory Fields Message For Beneficiary Maintenance->List Screen Displayed is correct");
		}//end of if
		else
		{
			log.error("Mandatory Fields Message For Beneficiary Maintenance->List Screen Displayed is Incorrect");
		}//end of else

		//fetch details
		test_Data=fileReader.readBeneficiaryMaintenanceExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String customerId=map.get("Customer ID");
			String SrcAccNo=map.get("Source Account No.");
			String supportedPayment=map.get("Supported Payment");
			String PurposeCode=map.get("Purpose Code");
			String beneficiaryCode=map.get("Beneficiary Code");

			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(restartWorkFlowBtn);

			//enter details
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(beneCodeTxtField, beneficiaryCode);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(custIdTxtField, customerId);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(srcAccountDropDown,SrcAccNo);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(supportedPaymentDropDown,supportedPayment);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(PurposeCodeDropDown, PurposeCode);

			//click on Reset button
			elementUtil.clickElement(resetBtn);

			//check reset button working
			if(elementUtil.getText(custIdTxtField).isEmpty() && elementUtil.getText(srcAccountDropDown).isEmpty()  && elementUtil.getText(beneCodeTxtField).isEmpty())
			{
				log.info("Reset Button Is Working Properly");
			}//end of if
			else
			{
				log.error("Reset Button Is Not Working Properly");
			}//end of else

			//enter details after reset operation
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(beneCodeTxtField, beneficiaryCode);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(custIdTxtField, customerId);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(srcAccountDropDown,SrcAccNo);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(supportedPaymentDropDown,supportedPayment);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(PurposeCodeDropDown, PurposeCode);

			//click on ok button
			elementUtil.clickElement(okBtn);

			try {
				if(elementUtil.getText(errormessages).trim().toString().equals("No items available for List operation".trim().toString()))
				{
					log.info("Record With [ Beneficiary Code : " +beneficiaryCode+ " , Customer Id : " +customerId+ " , Source Account Number : " +SrcAccNo+ " ,Supported Payment Type : " +supportedPayment+ ", Purpose Code : " +PurposeCode+ " ] Not Found For List Operation");
					log.info("No items available for List operation Validation Message Displayed Is Correct");
				}//end of if
				else
				{
					log.info("Record With [ Beneficiary Code : " +beneficiaryCode+ " , Customer Id : " +customerId+ " , Source Account Number : " +SrcAccNo+ " ,Supported Payment Type : " +supportedPayment+ ", Purpose Code : " +PurposeCode+ " ] Not Found For List Operation");
					log.error("No items available for List operation Validation Message Displayed Is Incorrect");
				}//end of else
			} catch (NoSuchElementException e) {
				//click on record
				elementUtil.clickElement(screenRecord);
				if(elementUtil.getText(custIdTxtFieldValue_ListScreen).trim().toString().equals(customerId.trim().toString()) && elementUtil.getText(beneCodeTxtFieldValue_ListScreen).trim().toString().equals(beneficiaryCode.trim().toString()))
				{
					log.info("Record With [ Beneficiary Code : " +beneficiaryCode+ " , Customer Id : " +customerId+ " , Source Account Number : " +SrcAccNo+ " ,Supported Payment Type : " +supportedPayment+ ", Purpose Code : " +PurposeCode+ " ] Is Displayed In List");

				}//end of if
				else
				{
					log.info("Record Mismatch, Record With [ Beneficiary Code : " +beneficiaryCode+ " , Customer Id : " +customerId+ " , Source Account Number : " +SrcAccNo+ " ,Supported Payment Type : " +supportedPayment+ ", Purpose Code : " +PurposeCode+ " ] Is Not Displayed In List");
				}//end of else

			}//end of catch

		}//end of catch	

		elementUtil.handlewin1(driver);
		logOutOperation();

	}//end of listBeneficiaryRecord function

	//------------------------Method to Delete Beneficiary Record -------------------------------
	public void deleteBeneficiaryRecord(String SheetName) throws InvalidFormatException, IOException, InterruptedException  {
		//checking mandatory fields message
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(okBtn);

		if (elementUtil.getText(errormessages).trim().toString().equals("Customer ID and Beneficiary Code is mandatory.".trim().toString())) {
			log.info("Mandatory Fields Message For Beneficiary Maintenance->Delete Screen Displayed is correct");
		}//end of if
		else
		{
			log.error("Mandatory Fields Message For Beneficiary Maintenance->Delete Screen Displayed is Incorrect");
		}//end of else

		//fetch details
		test_Data=fileReader.readBeneficiaryMaintenanceExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String customerId=map.get("Customer ID");
			String SrcAccNo=map.get("Source Account No.");
			String supportedPayment=map.get("Supported Payment");
			String PurposeCode=map.get("Purpose Code");
			String beneficiaryCode=map.get("Beneficiary Code");

			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(restartWorkFlowBtn);

			//enter details
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(beneCodeTxtField, beneficiaryCode);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(custIdTxtField, customerId);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(srcAccountDropDown,SrcAccNo);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(supportedPaymentDropDown,supportedPayment);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(PurposeCodeDropDown, PurposeCode);

			//click on Reset button
			elementUtil.clickElement(resetBtn);

			//check reset button working
			if(elementUtil.getText(custIdTxtField).isEmpty() && elementUtil.getText(srcAccountDropDown).isEmpty()  && elementUtil.getText(beneCodeTxtField).isEmpty())
			{
				log.info("Reset Button Is Working Properly");
			}//end of if
			else
			{
				log.error("Reset Button Is Not Working Properly");
			}//end of else

			//enter details after reset operation
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(beneCodeTxtField, beneficiaryCode);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(custIdTxtField, customerId);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(srcAccountDropDown,SrcAccNo);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(supportedPaymentDropDown,supportedPayment);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(PurposeCodeDropDown, PurposeCode);

			//click on ok button
			elementUtil.clickElement(okBtn);

			try {
				if(elementUtil.getText(errormessages).trim().toString().equals("No items available for Delete operation".trim().toString()))
				{
					log.info("Record With [ Beneficiary Code : " +beneficiaryCode+ " , Customer Id : " +customerId+ " , Source Account Number : " +SrcAccNo+ " ,Supported Payment Type : " +supportedPayment+ ", Purpose Code : " +PurposeCode+ " ] Not Found For Delete Operation");
					log.info("No items available for Delete operation Validation Message Displayed Is Correct");
				}//end of if
				else
				{
					log.info("Record With [ Beneficiary Code : " +beneficiaryCode+ " , Customer Id : " +customerId+ " , Source Account Number : " +SrcAccNo+ " ,Supported Payment Type : " +supportedPayment+ ", Purpose Code : " +PurposeCode+ " ] Not Found For Delete Operation");
					log.error("No items available for Delete operation Validation Message Displayed Is Incorrect");
				}//end of else
			} catch (NoSuchElementException e) {
				//click on record
				elementUtil.clickElement(screenRecord);
				if(elementUtil.getAttribute(custIdTxtField).trim().toString().equals(customerId.trim().toString())  && elementUtil.getAttribute(beneCodeTxtField).trim().toString().equals(beneficiaryCode.trim().toString()))
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
					if(elementUtil.getText(screenValidationMessage).trim().toString().equals("Operation Delete executed successfully. Beneficiary record placed in next queue.".trim().toString()))
					{
						log.info("Record With [ Beneficiary Code : " +beneficiaryCode+ " , Customer Id : " +customerId+ " , Source Account Number : " +SrcAccNo+ " ,Supported Payment Type : " +supportedPayment+ ", Purpose Code : " +PurposeCode+ " ] Deleted Successfully");

					}//end of if


				}//end of if
				else
				{
					log.info("Record Mismatch, Record With [ Beneficiary Code : " +beneficiaryCode+ " , Customer Id : " +customerId+ " , Source Account Number : " +SrcAccNo+ " ,Supported Payment Type : " +supportedPayment+ ", Purpose Code : " +PurposeCode+ " ] Is Not Found For Delete");
				}//end of else

			}//end of catch	

		}//end of catch	

		//perform logout operation
		elementUtil.handlewin1(driver);
		logOutOperation();

	}//end of deleteBeneficiaryRecord function

	//------------------------Method to Modify Beneficiary Record -------------------------------
	public void modifyBeneficiaryRecord(String SheetName) throws InvalidFormatException, IOException, InterruptedException  {
		//checking mandatory fields message
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(okBtn);

		if (elementUtil.getText(errormessages).trim().toString().equals("Customer ID and Beneficiary Code is mandatory.".trim().toString())) {
			log.info("Mandatory Fields Message For Beneficiary Maintenance->Modify Screen Displayed is correct");
		}//end of if
		else
		{
			log.error("Mandatory Fields Message For Beneficiary Maintenance->Modify Screen Displayed is Incorrect");
		}//end of else

		//fetch details
		test_Data=fileReader.readBeneficiaryMaintenanceExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String customerId=map.get("Customer ID");
			String SrcAccNo=map.get("Source Account No.");
			String supportedPayment=map.get("Supported Payment");
			String original_PurposeCode=map.get("Original Purpose Code");
			String PurposeCode=map.get("Purpose Code");
			String beneficiaryCode=map.get("Beneficiary Code");
			String CustomerType=map.get("Customer Type");
			String BeneficiaryName=map.get("Beneficiary Name");
			String AddressLine1=map.get("Address Line 1");
			String AddressLine2=map.get("Address Line 2");
			String PhoneNo=map.get("Phone No.");
			String EmailAddress=map.get("Email Address");
			String BeneficiaryAccountNo=map.get("Beneficiary Account Number");
			String BeneficiaryBankName=map.get("Beneficiary Bank Name");
			String BeneficiaryBankId=map.get("Beneficiary Bank Id");
			String BeneficiaryBankIdValue=map.get("Beneficiary Bank Id Value");
			String CurrencyCode=map.get("Currency Code");
			String TransactionLimit=map.get("Transaction Limit");
			String ExpiryDate=map.get("Expiry Date");
			String UPIHandler=map.get("UPI Handler");
			String ExtParam1=map.get("ExtParam1");
			String ExtParam2=map.get("ExtParam2");
			String ExtParam3=map.get("ExtParam3");
			String ExtParam4=map.get("ExtParam4");
			String ExtParam5=map.get("ExtParam5");
			String ExtParam6=map.get("ExtParam6");

			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(restartWorkFlowBtn);

			//enter details
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(beneCodeTxtField, beneficiaryCode);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(custIdTxtField, customerId);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(srcAccountDropDown,SrcAccNo);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(supportedPaymentDropDown,supportedPayment);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(PurposeCodeDropDown, original_PurposeCode);

			//click on Reset button
			elementUtil.clickElement(resetBtn);

			//check reset button working
			if(elementUtil.getText(custIdTxtField).isEmpty() && elementUtil.getText(srcAccountDropDown).isEmpty()  && elementUtil.getText(beneCodeTxtField).isEmpty())
			{
				log.info("Reset Button Is Working Properly");
			}//end of if
			else
			{
				log.error("Reset Button Is Not Working Properly");
			}//end of else

			//enter details after reset operation
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(beneCodeTxtField, beneficiaryCode);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(custIdTxtField, customerId);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(srcAccountDropDown,SrcAccNo);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(supportedPaymentDropDown,supportedPayment);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(PurposeCodeDropDown, original_PurposeCode);

			//click on ok button
			elementUtil.clickElement(okBtn);

			try {
				if(elementUtil.getText(errormessages).trim().toString().equals("No items available for Modify operation".trim().toString()))
				{
					log.info("Record With [ Beneficiary Code : " +beneficiaryCode+ " , Customer Id : " +customerId+ " , Source Account Number : " +SrcAccNo+ " ,Supported Payment Type : " +supportedPayment+ ", Purpose Code : " +original_PurposeCode+ " ] Not Found For Modify Operation");
					log.info("No items available for Modify operation Validation Message Displayed Is Correct");
				}//end of if
				else
				{
					log.info("Record With [ Beneficiary Code : " +beneficiaryCode+ " , Customer Id : " +customerId+ " , Source Account Number : " +SrcAccNo+ " ,Supported Payment Type : " +supportedPayment+ ", Purpose Code : " +original_PurposeCode+ " ] Not Found For Modify Operation");
					log.error("No items available for Modify operation Validation Message Displayed Is Incorrect");
				}//end of else
			} catch (NoSuchElementException e) {
				//click on record
				elementUtil.clickElement(screenRecord);
				if(elementUtil.getAttribute(custIdTxtField).trim().toString().equals(customerId.trim().toString())  && elementUtil.getAttribute(beneCodeTxtField).trim().toString().equals(beneficiaryCode.trim().toString()))
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

					//clear field values
					elementUtil.SHORT_TIMEOUT();
					elementUtil.selectDropDownByVisibleText(PurposeCodeDropDown, PurposeCode);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(beneNameTxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(beneNameTxtField, BeneficiaryName);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(addressLine1TxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(addressLine1TxtField, AddressLine1);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(addressLine2TxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(addressLine2TxtField,AddressLine2);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(phoneNoTxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(phoneNoTxtField,PhoneNo);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(emailAddressTxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(emailAddressTxtField, EmailAddress);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(beneAccountTxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(beneAccountTxtField,BeneficiaryAccountNo);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(beneBankNameTxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(beneBankNameTxtField,BeneficiaryBankName);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(beneBankIdTypeValueTxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(beneBankIdTypeValueTxtField,BeneficiaryBankIdValue);
					if(!TransactionLimit.isEmpty())
					{
						elementUtil.clearText(transactionLimitTxtField);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.enterText(transactionLimitTxtField,TransactionLimit);

					}//end of if
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(expiryDateTxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(expiryDateTxtField,ExpiryDate);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(upiHandlerTxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(upiHandlerTxtField,UPIHandler);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(extParam1TxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(extParam1TxtField, ExtParam1);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(extParam2TxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(extParam2TxtField, ExtParam2);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(extParam3TxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(extParam3TxtField, ExtParam3);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(extParam4TxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(extParam4TxtField, ExtParam4);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(extParam5TxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(extParam5TxtField, ExtParam5);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(extParam6TxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(extParam6TxtField, ExtParam6);

					//click on ok button
					elementUtil.clickElement(okBtn);
					try {
						if(elementUtil.getText(errormessages).trim().toString().equals("Customer not enabled for Beneficiary Maintenance Service.".trim().toString()))
						{
							log.info("Customer With Customer Id " +customerId+ " Not Enabled for Beneficiary Maintenance Service Hence No Modify Operation Performed");
						}//end of if
						else if(elementUtil.getText(errormessages).trim().toString().equals("Customer ID+ Beneficiary Code+ Source Account Number+ Payment Type same combination record exists".trim().toString()) || elementUtil.getText(errormessages).trim().toString().contains("Record already exists but pending for approval with Beneficiary Code as".trim().toString()) || elementUtil.getText(errormessages).trim().toString().contains("Record already exists with Beneficiary Code as".trim().toString()))
						{
							log.info("Duplicate Record Found");
						}//end of else if
						else
						{
							log.error("Data Provided For Modify operation Is Not As Per Valid Format OR Duplicate Record Validation Message Displayed Is Incorrrect");
						}//end of else
					} catch (NoSuchElementException e2) {
						//click on cancel button
						elementUtil.clickElement(cancelBtn);

						if(elementUtil.getText(errormessages).trim().toString().equals("Customer ID and Beneficiary Code is mandatory.".trim().toString()))
						{
							log.info("Cancel Button Is Working Properly");
						}//end of if
						else
						{
							log.error("Cancel Button Is Not Working Properly");
						}//end of else

						//enter details
						elementUtil.SHORT_TIMEOUT();
						elementUtil.enterText(beneCodeTxtField, beneficiaryCode);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.enterText(custIdTxtField, customerId);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.enterText(srcAccountDropDown,SrcAccNo);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.selectDropDownByVisibleText(supportedPaymentDropDown,supportedPayment);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.selectDropDownByVisibleText(PurposeCodeDropDown, original_PurposeCode);

						//click on ok button
						elementUtil.clickElement(okBtn);

						//click on Record
						elementUtil.clickElement(screenRecord);

						//clear field values
						elementUtil.SHORT_TIMEOUT();
						elementUtil.selectDropDownByVisibleText(PurposeCodeDropDown, PurposeCode);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(beneNameTxtField);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.enterText(beneNameTxtField, BeneficiaryName);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(addressLine1TxtField);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.enterText(addressLine1TxtField, AddressLine1);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(addressLine2TxtField);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.enterText(addressLine2TxtField,AddressLine2);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(phoneNoTxtField);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.enterText(phoneNoTxtField,PhoneNo);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(emailAddressTxtField);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.enterText(emailAddressTxtField, EmailAddress);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(beneAccountTxtField);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.enterText(beneAccountTxtField,BeneficiaryAccountNo);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(beneBankNameTxtField);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.enterText(beneBankNameTxtField,BeneficiaryBankName);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(beneBankIdTypeValueTxtField);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.enterText(beneBankIdTypeValueTxtField,BeneficiaryBankIdValue);
						if(!TransactionLimit.isEmpty())
						{
							elementUtil.clearText(transactionLimitTxtField);
							elementUtil.SHORT_TIMEOUT();
							elementUtil.enterText(transactionLimitTxtField,TransactionLimit);

						}//end of if
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(expiryDateTxtField);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.enterText(expiryDateTxtField,ExpiryDate);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(upiHandlerTxtField);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.enterText(upiHandlerTxtField,UPIHandler);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(extParam1TxtField);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.enterText(extParam1TxtField, ExtParam1);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(extParam2TxtField);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.enterText(extParam2TxtField, ExtParam2);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(extParam3TxtField);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.enterText(extParam3TxtField, ExtParam3);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(extParam4TxtField);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.enterText(extParam4TxtField, ExtParam4);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(extParam5TxtField);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.enterText(extParam5TxtField, ExtParam5);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(extParam6TxtField);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.enterText(extParam6TxtField, ExtParam6);

						//click on ok button
						elementUtil.clickElement(okBtn);

						//click on submit button
						elementUtil.clickElement(submitBtn);

						if(elementUtil.getText(screenValidationMessage).trim().toString().equals("Operation Modify executed successfully. Beneficiary record placed in next queue.".trim().toString()))
						{
							log.info("Record With Original Values [ Beneficiary Code : " +beneficiaryCode+ " , Customer Id : " +customerId+ " , Source Account Number : " +SrcAccNo+ " , Supported Payment Type : " +supportedPayment+ ", Purpose Code : " +original_PurposeCode+ " ] Modified Successfully With Updated Values");
						}//end of if

					}//end of catch


				}//end of if
				else
				{
					log.info("Record Mismatch, Record With [ Beneficiary Code : " +beneficiaryCode+ " , Customer Id : " +customerId+ " , Source Account Number : " +SrcAccNo+ " , Supported Payment Type : " +supportedPayment+ ", Purpose Code : " +original_PurposeCode+ " ] Is Not Found For Modify");
				}//end of else

			}//end of catch	

		}//end of catch	

		//perform logout operation
		elementUtil.handlewin1(driver);
		logOutOperation();

	}//end of modifyBeneficiaryRecord function

	//------------------------Method to Enter Beneficiary Record With Invalid Data-------------------------------
	public void enterBeneficiaryRecordInvalidData(String SheetName) throws InvalidFormatException, IOException, InterruptedException  {

		//click on ok button
		elementUtil.clickElement(okBtn);

		//Checking Mandatory Fields Message Validation
		String expectedMandatoryFieldMessage="Customer id is mandatory.\n" + "Beneficiary name is mandatory.\n" + "Source account number is mandatory.\n" + "Payment Type is mandatory.\n" + "Beneficiary code is mandatory.";

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
		test_Data=fileReader.readBeneficiaryMaintenanceExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String customerId=map.get("Customer ID");
			String SrcAccNo=map.get("Source Account No.");
			String CustomerType=map.get("Customer Type");
			String supportedPayment=map.get("Supported Payment");
			String PurposeCode=map.get("Purpose Code");
			String beneficiaryCode=map.get("Beneficiary Code");
			String BeneficiaryName=map.get("Beneficiary Name");
			String AddressLine1=map.get("Address Line 1");
			String AddressLine2=map.get("Address Line 2");
			String PhoneNo=map.get("Phone No.");
			String EmailAddress=map.get("Email Address");
			String BeneficiaryAccountNo=map.get("Beneficiary Account Number");
			String BeneficiaryBankName=map.get("Beneficiary Bank Name");
			String BeneficiaryBankId=map.get("Beneficiary Bank Id");
			String BeneficiaryBankIdValue=map.get("Beneficiary Bank Id Value");
			String CurrencyCode=map.get("Currency Code");
			String TransactionLimit=map.get("Transaction Limit");
			String ExpiryDate=map.get("Expiry Date");
			String UPIHandler=map.get("UPI Handler");
			String ExtParam1=map.get("ExtParam1");
			String ExtParam2=map.get("ExtParam2");
			String ExtParam3=map.get("ExtParam3");
			String ExtParam4=map.get("ExtParam4");
			String ExtParam5=map.get("ExtParam5");
			String ExtParam6=map.get("ExtParam6");

			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(restartWorkFlowBtn);

			//enter details 
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(custIdTxtField,customerId);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(srcAccountDropDown, SrcAccNo);
			//elementUtil.SHORT_TIMEOUT();
			//elementUtil.selectDropDownByVisibleText(customerTypeDropDown,CustomerType);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(supportedPaymentDropDown, supportedPayment);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(PurposeCodeDropDown,PurposeCode);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(beneCodeTxtField, beneficiaryCode);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(beneNameTxtField, BeneficiaryName);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(addressLine1TxtField, AddressLine1);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(addressLine2TxtField,AddressLine2);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(phoneNoTxtField,PhoneNo);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(emailAddressTxtField, EmailAddress);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(beneAccountTxtField,BeneficiaryAccountNo);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(beneBankNameTxtField,BeneficiaryBankName);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(beneBankIdTypeDropDown,BeneficiaryBankId);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(beneBankIdTypeValueTxtField,BeneficiaryBankIdValue);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(currencyCodeDropDown, CurrencyCode);
			if(!TransactionLimit.isEmpty())
			{
				elementUtil.clearText(transactionLimitTxtField);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(transactionLimitTxtField,TransactionLimit);

			}
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(expiryDateTxtField,ExpiryDate);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(upiHandlerTxtField,UPIHandler);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(extParam1TxtField, ExtParam1);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(extParam2TxtField, ExtParam2);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(extParam3TxtField, ExtParam3);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(extParam4TxtField, ExtParam4);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(extParam5TxtField, ExtParam5);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(extParam6TxtField, ExtParam6);

			//click on OK button
			elementUtil.clickElement(okBtn);

			try {
				String actualScreenMessage=elementUtil.getText(errormessages);
				log.info(actualScreenMessage);
			} catch (NoSuchElementException e) {
				log.info("Test Data Provided Is Not Invalid");
			}//end of catch

		}//end of for loop

		elementUtil.handlewin1(driver);
		logOutOperation();


	}//end of enterBeneficiaryRecord function

	//------------------------Method to Modify Beneficiary Record With Invalid Data -------------------------------
	public void modifyBeneficiaryRecordInvalidData(String SheetName) throws InvalidFormatException, IOException, InterruptedException  {
		//checking mandatory fields message
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(okBtn);

		if (elementUtil.getText(errormessages).trim().toString().equals("Customer ID and Beneficiary Code is mandatory.".trim().toString())) {
			log.info("Mandatory Fields Message For Beneficiary Maintenance->Modify Screen Displayed is correct");
		}//end of if
		else
		{
			log.error("Mandatory Fields Message For Beneficiary Maintenance->Modify Screen Displayed is Incorrect");
		}//end of else

		//fetch details
		test_Data=fileReader.readBeneficiaryMaintenanceExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String customerId=map.get("Customer ID");
			String SrcAccNo=map.get("Source Account No.");
			String supportedPayment=map.get("Supported Payment");
			String original_PurposeCode=map.get("Original Purpose Code");
			String PurposeCode=map.get("Purpose Code");
			String beneficiaryCode=map.get("Beneficiary Code");
			String CustomerType=map.get("Customer Type");
			String BeneficiaryName=map.get("Beneficiary Name");
			String AddressLine1=map.get("Address Line 1");
			String AddressLine2=map.get("Address Line 2");
			String PhoneNo=map.get("Phone No.");
			String EmailAddress=map.get("Email Address");
			String BeneficiaryAccountNo=map.get("Beneficiary Account Number");
			String BeneficiaryBankName=map.get("Beneficiary Bank Name");
			String BeneficiaryBankId=map.get("Beneficiary Bank Id");
			String BeneficiaryBankIdValue=map.get("Beneficiary Bank Id Value");
			String CurrencyCode=map.get("Currency Code");
			String TransactionLimit=map.get("Transaction Limit");
			String ExpiryDate=map.get("Expiry Date");
			String UPIHandler=map.get("UPI Handler");
			String ExtParam1=map.get("ExtParam1");
			String ExtParam2=map.get("ExtParam2");
			String ExtParam3=map.get("ExtParam3");
			String ExtParam4=map.get("ExtParam4");
			String ExtParam5=map.get("ExtParam5");
			String ExtParam6=map.get("ExtParam6");

			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(restartWorkFlowBtn);

			//enter details
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(beneCodeTxtField, beneficiaryCode);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(custIdTxtField, customerId);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(srcAccountDropDown,SrcAccNo);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(supportedPaymentDropDown,supportedPayment);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(PurposeCodeDropDown, original_PurposeCode);

			//click on ok button
			elementUtil.clickElement(okBtn);

			try {
				if(elementUtil.getText(errormessages).trim().toString().equals("Customer ID and Beneficiary Code is mandatory.".trim().toString()))
				{
					log.info("Customer ID and Beneficiary Code Mandatory To be Provided");
				}//end of if
				else if(elementUtil.getText(errormessages).trim().toString().equals("No items available for Modify operation".trim().toString()))
				{
					log.info("Record With [ Beneficiary Code : " +beneficiaryCode+ " , Customer Id : " +customerId+ " , Source Account Number : " +SrcAccNo+ " ,Supported Payment Type : " +supportedPayment+ ", Purpose Code : " +original_PurposeCode+ " ] Not Found For Modify Operation");
					log.info("No items available for Modify operation Validation Message Displayed Is Correct");
				}//end of if

				else
				{
					log.info("Record With [ Beneficiary Code : " +beneficiaryCode+ " , Customer Id : " +customerId+ " , Source Account Number : " +SrcAccNo+ " ,Supported Payment Type : " +supportedPayment+ ", Purpose Code : " +original_PurposeCode+ " ] Not Found For Modify Operation");
					log.error("No items available for Modify operation Validation Message Displayed Is Incorrect");
				}//end of else
			} catch (NoSuchElementException e) {
				//click on record
				elementUtil.clickElement(screenRecord);
				if(elementUtil.getAttribute(custIdTxtField).trim().toString().equals(customerId.trim().toString())  && elementUtil.getAttribute(beneCodeTxtField).trim().toString().equals(beneficiaryCode.trim().toString()))
				{
					//clear field values
					elementUtil.SHORT_TIMEOUT();
					elementUtil.selectDropDownByVisibleText(PurposeCodeDropDown, PurposeCode);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(beneNameTxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(beneNameTxtField, BeneficiaryName);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(addressLine1TxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(addressLine1TxtField, AddressLine1);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(addressLine2TxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(addressLine2TxtField,AddressLine2);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(phoneNoTxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(phoneNoTxtField,PhoneNo);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(emailAddressTxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(emailAddressTxtField, EmailAddress);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(beneAccountTxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(beneAccountTxtField,BeneficiaryAccountNo);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(beneBankNameTxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(beneBankNameTxtField,BeneficiaryBankName);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(beneBankIdTypeValueTxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(beneBankIdTypeValueTxtField,BeneficiaryBankIdValue);
					if(!TransactionLimit.isEmpty())
					{
						elementUtil.clearText(transactionLimitTxtField);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.enterText(transactionLimitTxtField,TransactionLimit);

					}//end of if
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(expiryDateTxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(expiryDateTxtField,ExpiryDate);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(upiHandlerTxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(upiHandlerTxtField,UPIHandler);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(extParam1TxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(extParam1TxtField, ExtParam1);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(extParam2TxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(extParam2TxtField, ExtParam2);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(extParam3TxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(extParam3TxtField, ExtParam3);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(extParam4TxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(extParam4TxtField, ExtParam4);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(extParam5TxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(extParam5TxtField, ExtParam5);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(extParam6TxtField);
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(extParam6TxtField, ExtParam6);

					//click on ok button
					elementUtil.clickElement(okBtn);
					try {
						String actualScreenMessage=elementUtil.getText(errormessages);
						log.info(actualScreenMessage);
					} catch (NoSuchElementException e2) {
						log.info("Test Data Provided Is Not Invalid");
					}//end of catch
				}//end of if
				else
				{
					log.info("Record Mismatch, Record With [ Beneficiary Code : " +beneficiaryCode+ " , Customer Id : " +customerId+ " , Source Account Number : " +SrcAccNo+ " , Supported Payment Type : " +supportedPayment+ ", Purpose Code : " +original_PurposeCode+ " ] Is Not Found For Modify");
				}//end of else

			}//end of catch	

		}//end of catch	

		//perform logout operation
		elementUtil.handlewin1(driver);
		logOutOperation();

	}//end of modifyBeneficiaryRecordInvalidData function



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


}//end of main class BeneficiaryMaintenancePage
