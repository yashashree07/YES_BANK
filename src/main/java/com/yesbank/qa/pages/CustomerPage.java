package com.yesbank.qa.pages;

/*
 * Class Description :
 * Class namely CustomerPage is a class involving different metjods related to Customer Menu which allows user to perform 
 * different operations related to Customer Module
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

public class CustomerPage {

	private WebDriver driver;
	ElementUtil elementUtil;
	FileReadUtils fileReader;
	HomePage homePage;
	List<Map<String, String>> test_Data;

	Logger log = Logger.getLogger(CustomerPage.class);

	// Customer Page Web elements
	@FindBy(name = "relatedCustId")
	WebElement customerKeyTxtField;

	@FindBy(name = "custCreationType")
	WebElement customerCreationTypeDropDown;

	@FindBy(xpath = "//input[@value='Modify-Confirm']")
	WebElement modifyConfirmBtn;

	@FindBy(name = "name")
	WebElement merchantNameTxtField;

	@FindBy(id = "autoApproveEnable")
	WebElement beneficiaryApprovalTypeDropDown;

	@FindBy(name = "customerEnable")
	WebElement customerEnabledDropDown;

	@FindBy(xpath = "//*[@id=\"LNTablelistable\"]/tbody/tr[2]")
	WebElement screenRecord;

	@FindBy(xpath = "//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[9]")
	WebElement listScreenRecordStatusValue;

	@FindBy(name = "customerKey")
	WebElement merchantIdTxtField;

	@FindBy(name = "legalName")
	WebElement legalNameTxtField;

	@FindBy(name = "addressLine1")
	WebElement permanentAddrLine1TxtField;

	@FindBy(name = "addressLine2")
	WebElement permanentAddrLine2TxtField;

	@FindBy(name = "addressLine3")
	WebElement permanentAddrLineTxt3TxtField;

	@FindBy(name = "permanentPinCode")
	WebElement permanentPincodeTxtField;

	@FindBy(name = "custNatLine1")
	WebElement correspondentAddressLine1TxtField;

	@FindBy(name = "custNatLine2")
	WebElement correspondentAddressLine2TxtField;

	@FindBy(name = "custNatLine3")
	WebElement correspondentAddressLine3TxtField;

	@FindBy(name = "currentPinCode")
	WebElement correspondentPincodeTxtField;

	@FindBy(name = "mobileNo")
	WebElement mobileNoTxtField;

	@FindBy(name = "emailId")
	WebElement emailAddressTxtField;

	@FindBy(name = "encryptionEnabled")
	WebElement encryptionTxtField;

	@FindBy(name = "sendMerchantKey")
	WebElement sendEncryptionTypeDroDown;

	@FindBy(name = "customerType")
	WebElement customerTypeDropDown;

	@FindBy(name = "merchantType")
	WebElement merchantTypeDropDown;

	@FindBy(name = "subMerchantEnable")
	WebElement subMerchantEnabledDropdown;

	@FindBy(name = "updateConsoleSystem")
	WebElement updateConsoleSystemDropDown;

	@FindBy(name = "paymentType")
	WebElement productPaymentField;

	@FindBy(id = "callBackFormList[0].paymentType")
	WebElement paymentTypeDropDown_BENEMGMT;

	@FindBy(id = "callBackFormList[1].paymentType")
	WebElement paymentTypeDropDown_NEFT;

	@FindBy(id = "callBackFormList[2].paymentType")
	WebElement paymentTypeDropDown_RTGS;
	
	@FindBy(id = "callBackFormList[3].paymentType")
	WebElement paymentTypeDropDown_UPI;

	@FindBy(name = "callBackFormList[0].callback")
	WebElement sendCallBackDropDown_BENEMGMT;

	@FindBy(name = "callBackFormList[1].callback")
	WebElement sendCallBackDropDown_NEFT;

	@FindBy(name = "callBackFormList[2].callback")
	WebElement sendCallBackDropDown_RTGS;
	
	@FindBy(name = "callBackFormList[3].callback")
	WebElement sendCallBackDropDown_UPI;

	@FindBy(name = "callBackFormList[0].type")
	WebElement callBackTypeDropDown_BENEMGMT;

	@FindBy(name = "callBackFormList[1].type")
	WebElement callBackTypeDropDown_NEFT;

	@FindBy(name = "callBackFormList[2].type")
	WebElement callBackTypeDropDown_RTGS;
	
	@FindBy(name = "callBackFormList[3].type")
	WebElement callBackTypeDropDown_UPI;

	@FindBy(id = "callBackFormList[0].apiUrl")
	WebElement callBackAPIURLTxtField_BENEMGMT;

	@FindBy(id = "callBackFormList[1].apiUrl")
	WebElement callBackAPIURLTxtField_NEFT;

	@FindBy(id = "callBackFormList[2].apiUrl")
	WebElement callBackAPIURLTxtField_RTGS;
	
	@FindBy(id = "callBackFormList[3].apiUrl")
	WebElement callBackAPIURLTxtField_UPI;

	@FindBy(name = "callBackFormList[0].retries")
	WebElement callBackRetriesTxtField_BENEMGMT;

	@FindBy(name = "callBackFormList[1].retries")
	WebElement callBackRetriesTxtField_NEFT;

	@FindBy(name = "callBackFormList[2].retries")
	WebElement callBackRetriesTxtField_RTGS;
	
	@FindBy(name = "callBackFormList[3].retries")
	WebElement callBackRetriesTxtField_UPI;

	@FindBy(name = "callBackFormList[0].proxy")
	WebElement callbackProxyDropdown_BENEMGMT;

	@FindBy(name = "callBackFormList[1].proxy")
	WebElement callbackProxyDropdown_NEFT;

	@FindBy(name = "callBackFormList[2].proxy")
	WebElement callbackProxyDropdown_RTGS;
	
	@FindBy(name = "callBackFormList[3].proxy")
	WebElement callbackProxyDropdown_UPI;

	@FindBy(name = "cancel")
	WebElement cancelBtn;

	@FindBy(name = "back")
	WebElement backBtn;

	@FindBy(xpath = "//input[@value='Delete']")
	WebElement deleteBtn;

	@FindBy(xpath = "//input[@value='Reset']")
	WebElement resetBtn;

	@FindBy(xpath = "//input[@value='OK']")
	WebElement okBtn;

	@FindBy(name = "custBankCustomer")
	WebElement bankORCustomerDropdown;

	@FindBy(xpath = "//input[@name='ok']")
	WebElement submitBtn;

	@FindBy(xpath = "//a[normalize-space()='Restart Workflow']")
	WebElement restartWorkFlowBtn;

	@FindBy(xpath = "//span[@class='glyphicon glyphicon-log-out']")
	WebElement mainPageLogOutButton;

	@FindBy(id = "content")
	WebElement mainFrame;

	@FindBy(xpath = "//button[@type='button'][normalize-space()='OK']")
	WebElement mainPageLogoutOkBtn;

	@FindBy(name = "approve")
	WebElement approveBtn;

	@FindBy(xpath = "//*[@id=\"printable\"]/center/p/text()")
	WebElement screenValidationMessage;

	@FindBy(id = "rejectionText")
	WebElement rejctionTxtBox;

	@FindBy(xpath = "//p[@class='errormessages']")
	WebElement errormessages;

	@FindBy(xpath = "//p[@class='messages']")
	WebElement messages;

	@FindBy(xpath = "//input[@value='Delete-Confirm']")
	WebElement deleteConfirmBtn;

	@FindBy(xpath = "//input[@value='Cancel Delete Action']")
	WebElement cancelDeleteActionBtn;

	@FindBy(xpath = "//input[@value='Add-Confirm']")
	WebElement addconfirmBtn;

	@FindBy(xpath = "//div[@role='dialog']")
	WebElement custAddScreenDialogBox;

	@FindBy(xpath = "//input[@value='Approve']")
	WebElement approveButton;

	@FindBy(name = "cancelModify")
	WebElement cancelModifyActionBtn;

	@FindBy(xpath = "//button[normalize-space()='Ok']")
	WebElement dialogBox_OkBtn;

	@FindBy(name = "modifyOperation")
	WebElement modifyOperationDropDown;

	// CustomerPage Class Constructor
	public CustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.fileReader = new FileReadUtils(driver);
		this.elementUtil = new ElementUtil(driver);
		this.homePage = new HomePage(driver);
	}// end

	// -----------------------------Method to Add Customer Record---------------------------------------
	public void addCustomerRecord(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		// fetch values
		test_Data = fileReader.readCustomerExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String customerCreationType = map.get("Customer Creation Type");
			String customerKey = map.get("Customer Key");
			String merchantName = map.get("Merchant Name");
			String merchantId = map.get("Merchant Id");
			String LegalName = map.get("Legal Name");
			String permanentAddrLine1 = map.get("Permanent Address Line 1");
			String permanentAddrLine2 = map.get("Permanent Address Line 2");
			String permanentAddrLine3 = map.get("Permanent Address Line 3");
			String correspondentAddrLine1 = map.get("Correspondent Address Line 1");
			String correspondentAddrLine2 = map.get("Correspondent Address Line 2");
			String correspondentAddrLine3 = map.get("Correspondent Address Line 3");
			String permanentPinCode = map.get("Permanent Pin Code");
			String correspondentPinCode = map.get("Correspondent Pin Code");
			String mobileNo = map.get("Mobile No");
			String emailId = map.get("Email Id");
			String encryption = map.get("Encryption");
			String sendEncryptionKey = map.get("Send Encryption Key");
			String customerType = map.get("Customer Type");
			String merchantType = map.get("Merchant Type");
			String submerchantEnabled = map.get("Sub Merchant Enabled");
			String beneficiaryMaintenanceEnabled = map.get("Beneficiary Maintenance Enabled");
			String beneficiaryApprovalType = map.get("Beneficiary Approval Type");
			String customerEnabled = map.get("Customer Enabled");
			String updatedConsoleSystem = map.get("Update Console System");
			String productPaymentType = map.get("Product Payment Type");
			String paymentType = map.get("Payment Type");
			String sendCallBack = map.get("Send Callback");
			String callBackType = map.get("Callback Type");
			String callBackAPIURL = map.get("Callback API URL");
			String callBackRetries = map.get("Callback Retries");
			String callBackProxy = map.get("Callback Proxy");
			String bankORCustomer = map.get("Bank or Customer");
			String sendCallBack_BENEMGMT = map.get("Send Callback_BENEMGMT");
			String sendCallBack_NEFT = map.get("Send Callback_NEFT");
			String sendCallBack_RTGS = map.get("Send Callback_RTGS");
			String sendCallBack_UPI = map.get("Send Callback_UPI");
			String callBackType_BENEMGMT = map.get("Callback Type_BENEMGMT");
			String callBackType_NEFT = map.get("Callback Type_NEFT");
			String callBackType_RTGS = map.get("Callback Type_RTGS");
			String callBackType_UPI = map.get("Callback Type_UPI");
			String callBackAPIURL_BENEMGMT = map.get("Callback API URL_BENEMGMT");
			String callBackAPIURL_NEFT = map.get("Callback API URL_NEFT");
			String callBackAPIURL_RTGS = map.get("Callback API URL_RTGS");
			String callBackAPIURL_UPI = map.get("Callback API URL_UPI");
			String callBackRetries_BENEMGMT = map.get("Callback Retries_BENEMGMT");
			String callBackRetries_NEFT = map.get("Callback Retries_NEFT");
			String callBackRetries_RTGS = map.get("Callback Retries_RTGS");
			String callBackRetries_UPI = map.get("Callback Retries_UPI");
			String callBackProxy_BENEMGMT = map.get("Callback Proxy_BENEMGMT");
			String callBackProxy_NEFT = map.get("Callback Proxy_NEFT");
			String callBackProxy_RTGS = map.get("Callback Proxy_RTGS");
			String callBackProxy_UPI = map.get("Callback Proxy_UPI");


			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(restartWorkFlowBtn);

			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(customerKeyTxtField, customerKey);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(customerCreationTypeDropDown, customerCreationType);

			// click on Reset button
			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(resetBtn);

			// check Reset button working
			if (elementUtil.getText(customerKeyTxtField).isEmpty()) {
				log.info("Reset Button Is Working Properly");
			} // end of if
			else {
				log.error("Reset Button Is Not Working Properly");
			} // end of else

			// enter details after reset operation
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(customerKeyTxtField, customerKey);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(customerCreationTypeDropDown, customerCreationType);

			// click on ok button
			elementUtil.clickElement(okBtn);
			// check if duplicate record exists
			try {
				if (elementUtil.getText(errormessages).trim().toString()
						.equals("Customer Key is already exist".trim().toString())) {
					log.info("Duplicate Record Found : Record With Customer Key " + customerKey + " Already Exists");
				} // end of if
				else if (elementUtil.getText(errormessages).trim().toString()
						.equals("Customer Key should be alphanumeric.".trim().toString())) {
					log.info("Customer Key Value Should be Alphanumeric");
				} // end of else if
				else if (elementUtil.getText(errormessages).trim().toString()
						.equals("Customer Key does not exist in FCR".trim().toString())) {
					log.info("Customer Key " + customerKey + " Does Not Exist In FCR");
				} // end of else if
				else if (elementUtil.getText(errormessages).trim().toString()
						.equals("Record Already in Database".trim().toString())) {
					log.info("Record Already In Database");
				} // end of else if
				else if (elementUtil.getText(errormessages).trim().toString()
						.equals("Customer Key is mandatory.".trim().toString())) {
					log.info("Customer Key Is Mandatory");
				} // end of else if

			} catch (NoSuchElementException e) {

				// click on cancel button
				elementUtil.SHORT_TIMEOUT();
				elementUtil.clickElement(cancelBtn);

				// check working of cancel button
				if (elementUtil.getText(errormessages).trim().toString()
						.equals("Operation Cancelled".trim().toString())) {
					log.info("Cancel Button Is Working Properly");
				} // end of if
				else {
					log.error("Cancel Button Is Not working Properly");
				} // end of else

				// enter details
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(customerKeyTxtField, customerKey);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.selectDropDownByVisibleText(customerCreationTypeDropDown, customerCreationType);

				// click on ok button
				elementUtil.clickElement(okBtn);

				// Fill the details
				elementUtil.SHORT_TIMEOUT();
				elementUtil.clearText(merchantNameTxtField);
				elementUtil.enterText(merchantNameTxtField, merchantName);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.clearText(legalNameTxtField);
				elementUtil.enterText(legalNameTxtField, LegalName);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.clearText(correspondentAddressLine1TxtField);
				elementUtil.enterText(correspondentAddressLine1TxtField, correspondentAddrLine1);
				// if correspondentAddressLine2 field is provided in input file then only enter
				// value in screen
				// else existing value present in screen to be considered
				if (!correspondentAddrLine2.isEmpty()) {
					System.out.println("in if");
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(correspondentAddressLine2TxtField);
					elementUtil.enterText(correspondentAddressLine2TxtField, correspondentAddrLine2);
				} // end of if
				// if correspondentAddressLine3 field is provided in input file then only enter
				// value in screen
				// else existing value present in screen to be considered
				if (!correspondentAddrLine3.isEmpty()) {
					System.out.println("in if");
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(correspondentAddressLine3TxtField);
					elementUtil.enterText(correspondentAddressLine3TxtField, correspondentAddrLine3);

				} // end of if
				elementUtil.SHORT_TIMEOUT();
				elementUtil.clearText(correspondentPincodeTxtField);
				elementUtil.enterText(correspondentPincodeTxtField, correspondentPinCode);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.clearText(mobileNoTxtField);
				elementUtil.enterText(mobileNoTxtField, mobileNo);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.clearText(emailAddressTxtField);
				elementUtil.enterText(emailAddressTxtField, emailId);
				elementUtil.selectDropDownByVisibleText(encryptionTxtField, encryption);
				elementUtil.selectDropDownByVisibleText(merchantTypeDropDown, merchantType);
				elementUtil.selectDropDownByVisibleText(subMerchantEnabledDropdown, submerchantEnabled);
				elementUtil.selectDropDownByVisibleText(bankORCustomerDropdown, bankORCustomer);
				elementUtil.selectDropDownByVisibleText(beneficiaryApprovalTypeDropDown, beneficiaryApprovalType);
				elementUtil.selectDropDownByVisibleText(updateConsoleSystemDropDown, updatedConsoleSystem);

				//splitting all productPaymentField values received from file to select multiple if any
				String select_Values[]=productPaymentType.split(",");
				elementUtil.selectElementValue_FromList(productPaymentField,select_Values);

				elementUtil.SHORT_TIMEOUT();
				//loop through all the values and check product payment type field value
				for(int j=0;j<select_Values.length;j++)
				{
					if (select_Values[j].equals("BENEMGMT")) {
						elementUtil.selectDropDownByVisibleText(sendCallBackDropDown_BENEMGMT, sendCallBack_BENEMGMT);
						// enter values for Callback Type, Callback API URL, Callback Retries, Proxy
						// fields only if
						// value of sendCallBack from input file is Y
						if (sendCallBack_BENEMGMT.equals("Y")) {
							System.out.println("in if for BENEMGMT");
							elementUtil.selectDropDownByVisibleText(callBackTypeDropDown_BENEMGMT, callBackType_BENEMGMT);
							elementUtil.SHORT_TIMEOUT();
							elementUtil.enterText(callBackAPIURLTxtField_BENEMGMT, callBackAPIURL_BENEMGMT);
							elementUtil.SHORT_TIMEOUT();
							elementUtil.clearText(callBackRetriesTxtField_BENEMGMT);
							elementUtil.enterText(callBackRetriesTxtField_BENEMGMT, callBackRetries_BENEMGMT);
							elementUtil.selectDropDownByVisibleText(callbackProxyDropdown_BENEMGMT, callBackProxy_BENEMGMT);
						} // end of if
					} // end of if
					else if (select_Values[j].equals("NEFT")) {
						elementUtil.selectDropDownByVisibleText(sendCallBackDropDown_NEFT, sendCallBack_NEFT);
						// enter values for Callback Type, Callback API URL, Callback Retries, Proxy
						// fields only if
						// value of sendCallBack from input file is Y
						if (sendCallBack_NEFT.equals("Y")) {
							System.out.println("in if for NEFT");
							elementUtil.selectDropDownByVisibleText(callBackTypeDropDown_NEFT, callBackType_NEFT);
							elementUtil.SHORT_TIMEOUT();
							elementUtil.enterText(callBackAPIURLTxtField_NEFT, callBackAPIURL_NEFT);
							elementUtil.SHORT_TIMEOUT();
							elementUtil.clearText(callBackRetriesTxtField_NEFT);
							elementUtil.enterText(callBackRetriesTxtField_NEFT, callBackRetries_NEFT);
							elementUtil.selectDropDownByVisibleText(callbackProxyDropdown_NEFT, callBackProxy_NEFT);
						} // end of if
					} // end of else if
					else if (select_Values[j].equals("RTGS")) {
						elementUtil.selectDropDownByVisibleText(sendCallBackDropDown_RTGS, sendCallBack_RTGS);
						// enter values for Callback Type, Callback API URL, Callback Retries, Proxy
						// fields only if
						// value of sendCallBack from input file is Y
						if (sendCallBack_RTGS.equals("Y")) {
							System.out.println("in if for rtgs");
							elementUtil.selectDropDownByVisibleText(callBackTypeDropDown_RTGS, callBackType_RTGS);
							elementUtil.SHORT_TIMEOUT();
							elementUtil.enterText(callBackAPIURLTxtField_RTGS, callBackAPIURL_RTGS);
							elementUtil.SHORT_TIMEOUT();
							elementUtil.clearText(callBackRetriesTxtField_RTGS);
							elementUtil.enterText(callBackRetriesTxtField_RTGS, callBackRetries_RTGS);
							elementUtil.selectDropDownByVisibleText(callbackProxyDropdown_RTGS, callBackProxy_RTGS);
						} // end of if
					} // end of else if
					else if (select_Values[j].equals("UPI")) {
						elementUtil.selectDropDownByVisibleText(sendCallBackDropDown_UPI, sendCallBack_UPI);
						// enter values for Callback Type, Callback API URL, Callback Retries, Proxy
						// fields only if
						// value of sendCallBack from input file is Y
						if (sendCallBack_UPI.equals("Y")) {
							System.out.println("in if for upi");
							elementUtil.selectDropDownByVisibleText(callBackTypeDropDown_UPI, callBackType_UPI);
							elementUtil.SHORT_TIMEOUT();
							elementUtil.enterText(callBackAPIURLTxtField_UPI, callBackAPIURL_UPI);
							elementUtil.SHORT_TIMEOUT();
							elementUtil.clearText(callBackRetriesTxtField_UPI);
							elementUtil.enterText(callBackRetriesTxtField_UPI, callBackRetries_UPI);
							elementUtil.selectDropDownByVisibleText(callbackProxyDropdown_UPI, callBackProxy_UPI);
						} // end of if
					} // end of else if
				}//end of for loop

				// click on ok button
				elementUtil.SHORT_TIMEOUT();
				elementUtil.clickElement(okBtn);

				// check if dialog box is displayed
				try {
					System.out.println("in try");
					if (custAddScreenDialogBox.isDisplayed()) {
						System.out.println("in if for custAddScreenDialogBox ");
						// accept the alert
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clickElement(dialogBox_OkBtn);
						// check if error message is displayed after clicking on OK in dialog box
						try {
							if (errormessages.isDisplayed()) {

								System.out.println("in if for error message displayed");
								log.info(elementUtil.getText(errormessages));
								log.info("Test Data Provided Is Not as per valid format");

							} // end of if
						} catch (NoSuchElementException e3) {

							// click on Back button
							elementUtil.SHORT_TIMEOUT();
							elementUtil.clickElement(backBtn);

							if (elementUtil.getText(errormessages).trim().toString()
									.equals("User Pressed Back Key".trim().toString())) {
								log.info("Back Button Is Working Properly");
							} // end of if
							else {
								log.error("Back Button Is Not Working Properly");
							} // end of else

							// click on ok button
							elementUtil.SHORT_TIMEOUT();
							elementUtil.clickElement(okBtn);

							// click on Add Confirm Button
							elementUtil.SHORT_TIMEOUT();
							elementUtil.clickElement(addconfirmBtn);

							String expectedRecordAddMessage = "New record added for " + customerKey
									+ " Waiting Approve";
							if (elementUtil.getText(messages).trim().toString()
									.equals(expectedRecordAddMessage.trim().toString())) {
								log.info("Record With Customer Key " + customerKey + " Added Successfully");
							} // end of if

						} // end of catch

					} // end of if

				} catch (NoSuchElementException e2) {
					System.out.println("in catch for dialog box not displayed");
					// check if error message is displayed after clicking on Ok button on dialog box
					try {
						System.out.println("in try for error message dispkayed");
						if (errormessages.isDisplayed()) {

							System.out.println("in if for error message displayed");
							log.info(elementUtil.getText(errormessages));
							log.info("Test Data Provided Is Not as per valid format");

						} // end of if
					} catch (NoSuchElementException e4) {
						System.out.println("in catch");

						// click on Back button
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clickElement(backBtn);

						if (elementUtil.getText(errormessages).trim().toString()
								.equals("User Pressed Back Key".trim().toString())) {
							log.info("Back Button Is Working Properly");
						} // end of if
						else {
							log.error("Back Button Is Not Working Properly");
						} // end of else

						// click on ok button
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clickElement(okBtn);

						// click on Add Confirm Button
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clickElement(addconfirmBtn);

						String expectedRecordAddMessage = "New record added for " + customerKey + " Waiting Approve";
						if (elementUtil.getText(messages).trim().toString()
								.equals(expectedRecordAddMessage.trim().toString())) {
							log.info("Record With Customer Key " + customerKey + " Added Successfully");
						} // end of if

					} // end of catch

				}

			} // end of catch

		} // end of for

		// perform logout operation
		elementUtil.handlewin1(driver);
		logOutOperation();
	}// end of addCustomerRecord function



	// -----------------------------Method to Modify Customer Record---------------------------------------
	public void modifyCustomerRecord(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {

		// fetch values
		test_Data = fileReader.readCustomerExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String modifyOperation = map.get("Modify Operation");
			String customerCreationType = map.get("Customer Creation Type");
			String customerKey = map.get("Customer Key");
			String merchantName = map.get("Merchant Name");
			String merchantId = map.get("Merchant Id");
			String LegalName = map.get("Legal Name");
			String permanentAddrLine1 = map.get("Permanent Address Line 1");
			String permanentAddrLine2 = map.get("Permanent Address Line 2");
			String permanentAddrLine3 = map.get("Permanent Address Line 3");
			String correspondentAddrLine1 = map.get("Correspondent Address Line 1");
			String correspondentAddrLine2 = map.get("Correspondent Address Line 2");
			String correspondentAddrLine3 = map.get("Correspondent Address Line 3");
			String permanentPinCode = map.get("Permanent Pin Code");
			String correspondentPinCode = map.get("Correspondent Pin Code");
			String mobileNo = map.get("Mobile No");
			String emailId = map.get("Email Id");
			String encryption = map.get("Encryption");
			String sendEncryptionKey = map.get("Send Encryption Key");
			String customerType = map.get("Customer Type");
			String merchantType = map.get("Merchant Type");
			String submerchantEnabled = map.get("Sub Merchant Enabled");
			String beneficiaryMaintenanceEnabled = map.get("Beneficiary Maintenance Enabled");
			String beneficiaryApprovalType = map.get("Beneficiary Approval Type");
			String customerEnabled = map.get("Customer Enabled");
			String updatedConsoleSystem = map.get("Update Console System");
			String Select_Product_PaymentType = map.get("Select_ProductPaymentType");
			String paymentType = map.get("Payment Type");
			String sendCallBack_BENEMGMT = map.get("Send Callback_BENEMGMT");
			String sendCallBack_NEFT = map.get("Send Callback_NEFT");
			String sendCallBack_RTGS = map.get("Send Callback_RTGS");
			String sendCallBack_UPI = map.get("Send Callback_UPI");
			String callBackType_BENEMGMT = map.get("Callback Type_BENEMGMT");
			String callBackType_NEFT = map.get("Callback Type_NEFT");
			String callBackType_RTGS = map.get("Callback Type_RTGS");
			String callBackType_UPI = map.get("Callback Type_UPI");
			String callBackAPIURL_BENEMGMT = map.get("Callback API URL_BENEMGMT");
			String callBackAPIURL_NEFT = map.get("Callback API URL_NEFT");
			String callBackAPIURL_RTGS = map.get("Callback API URL_RTGS");
			String callBackAPIURL_UPI = map.get("Callback API URL_UPI");
			String callBackRetries_BENEMGMT = map.get("Callback Retries_BENEMGMT");
			String callBackRetries_NEFT = map.get("Callback Retries_NEFT");
			String callBackRetries_RTGS = map.get("Callback Retries_RTGS");
			String callBackRetries_UPI = map.get("Callback Retries_UPI");
			String callBackProxy_BENEMGMT = map.get("Callback Proxy_BENEMGMT");
			String callBackProxy_NEFT = map.get("Callback Proxy_NEFT");
			String callBackProxy_RTGS = map.get("Callback Proxy_RTGS");
			String callBackProxy_UPI = map.get("Callback Proxy_UPI");
			String modificationReason = map.get("Modification Reason");
			String bankORCustomer = map.get("Bank or Customer");
			String SelectProduct_Payment_Type_Values=map.get("Select_Product_Payment_Type_Values");
			String DeSelect_Product_Payment_Type_Values=map.get("DeSelect_Product_Payment_Type_Values");
			String DeSelect_ProductPaymentType=map.get("DeSelect_ProductPaymentType");

			// click on Restart Workflow
			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(restartWorkFlowBtn);

			//enter values
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(customerKeyTxtField, customerKey);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(modifyOperationDropDown, modifyOperation);

			// click on Reset button
			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(resetBtn);

			// check Reset button working
			if (elementUtil.getText(customerKeyTxtField).isEmpty()) {
				log.info("Reset Button Is Working Properly");
			} // end of if
			else {
				log.error("Reset Button Is Not Working Properly");
			} // end of else

			// enter details after reset operation
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(customerKeyTxtField, customerKey);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(modifyOperationDropDown, modifyOperation);

			// click on ok button
			elementUtil.clickElement(okBtn);
			// check if record exists for modify operation
			try {
				if (elementUtil.getText(errormessages).trim().toString()
						.equals("Please try again later.Unable to get data from FCR".trim().toString())) {
					log.info("Unable to get data from FCR for record with customer key " + customerKey);
				} // end of if
				else if (elementUtil.getText(errormessages).trim().toString()
						.equals("No Records available for Modify operation".trim().toString())) {
					log.info("Record With [ Customer Key : " + customerKey + " Not Found For Modify Operation");
					log.info("No Records available for Modify operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With [ Customer Key : " + customerKey + " Not Found For Modify Operation");
					log.error("No Records available for Modify operation Validation Message Displayed Is Incorrect");

				} // end of else

			} catch (NoSuchElementException e) {

				// click on cancel button
				elementUtil.SHORT_TIMEOUT();
				elementUtil.clickElement(cancelBtn);

				// check working of cancel button
				if (elementUtil.getText(errormessages).trim().toString()
						.equals("Operation Cancelled".trim().toString())) {
					log.info("Cancel Button Is Working Properly");
				} // end of if
				else {
					log.error("Cancel Button Is Not working Properly");
				} // end of else

				// enter details
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(customerKeyTxtField, customerKey);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.selectDropDownByVisibleText(modifyOperationDropDown, modifyOperation);

				// click on ok button
				elementUtil.clickElement(okBtn);

				if (elementUtil.getAttribute(customerKeyTxtField).trim().toString()
						.equals(customerKey.trim().toString())) {

					// check the operation value from input sheet
					// if value is Resend the user can only modify Encryption field value
					if (modifyOperation.equals("RESEND")) {
						elementUtil.selectDropDownByVisibleText(encryptionTxtField, encryption);
					} // end of if
					// if value is Regenerate the user can only modify Encryption field value
					else if (modifyOperation.equals("REGENERATE")) {
						elementUtil.selectDropDownByVisibleText(encryptionTxtField, encryption);
					} // end of else if
					else if (modifyOperation.equals("REINITIATE_CONSOLE_API")) {
						elementUtil.selectDropDownByVisibleText(updateConsoleSystemDropDown, updatedConsoleSystem);
					} else {
						// Fill the details
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(merchantNameTxtField);
						elementUtil.enterText(merchantNameTxtField, merchantName);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(legalNameTxtField);
						elementUtil.enterText(legalNameTxtField, LegalName);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(correspondentAddressLine1TxtField);
						elementUtil.enterText(correspondentAddressLine1TxtField, correspondentAddrLine1);
						// if correspondentAddressLine2 field is provided in input file then only enter
						// value in screen
						// else existing value present in screen to be considered
						if (!correspondentAddrLine2.isEmpty()) {
							System.out.println("in if");
							elementUtil.SHORT_TIMEOUT();
							elementUtil.clearText(correspondentAddressLine2TxtField);
							elementUtil.enterText(correspondentAddressLine2TxtField, correspondentAddrLine2);
						} // end of if
						// if correspondentAddressLine3 field is provided in input file then only enter
						// value in screen
						// else existing value present in screen to be considered
						if (!correspondentAddrLine3.isEmpty()) {
							System.out.println("in if");
							elementUtil.SHORT_TIMEOUT();
							elementUtil.clearText(correspondentAddressLine3TxtField);
							elementUtil.enterText(correspondentAddressLine3TxtField, correspondentAddrLine3);

						} // end of if
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(correspondentPincodeTxtField);
						elementUtil.enterText(correspondentPincodeTxtField, correspondentPinCode);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(mobileNoTxtField);
						elementUtil.enterText(mobileNoTxtField, mobileNo);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(emailAddressTxtField);
						elementUtil.enterText(emailAddressTxtField, emailId);
						elementUtil.selectDropDownByVisibleText(encryptionTxtField, encryption);
						elementUtil.selectDropDownByVisibleText(merchantTypeDropDown, merchantType);
						elementUtil.javascriptExecutorClickElement(subMerchantEnabledDropdown);
						elementUtil.selectDropDownByVisibleText(subMerchantEnabledDropdown, submerchantEnabled);
						elementUtil.selectDropDownByVisibleText(bankORCustomerDropdown, bankORCustomer);
						elementUtil.selectDropDownByVisibleText(beneficiaryApprovalTypeDropDown,
								beneficiaryApprovalType);
						elementUtil.selectDropDownByVisibleText(customerEnabledDropDown, customerEnabled);
						elementUtil.selectDropDownByVisibleText(updateConsoleSystemDropDown, updatedConsoleSystem);

						//To Deselect existing Product Payment Type field Selected values if any
						if(DeSelect_Product_Payment_Type_Values.equals("Y"))
						{

							String DeselectValues_One[]=DeSelect_ProductPaymentType.split(",");
							elementUtil.deselectingElementValue_FromList(productPaymentField,DeselectValues_One);
							elementUtil.SHORT_TIMEOUT();


						}//end of if

						//To Select Product Payment Type field values 
						if(SelectProduct_Payment_Type_Values.equals("Y"))
						{
							//splitting all productPaymentField values received from file to select multiple if any
							String selectValues_Two[]=Select_Product_PaymentType.split(",");
							elementUtil.selectElementValue_FromList(productPaymentField,selectValues_Two);


							elementUtil.SHORT_TIMEOUT();
							//loop through all the values and check product payment type field value
							for(int j=0;j<selectValues_Two.length;j++)
							{
								//If Product Payment Type field value is BENEMGMT perform following
								if (selectValues_Two[j].equals("BENEMGMT")) {
									elementUtil.selectDropDownByVisibleText(sendCallBackDropDown_BENEMGMT, sendCallBack_BENEMGMT);
									// enter values for Callback Type, Callback API URL, Callback Retries, Proxy
									// fields only if
									// value of sendCallBack from input file is Y
									if (sendCallBack_BENEMGMT.equals("Y")) {
										System.out.println("in if for BENEMGMT");
										elementUtil.selectDropDownByVisibleText(callBackTypeDropDown_BENEMGMT, callBackType_BENEMGMT);
										elementUtil.SHORT_TIMEOUT();
										elementUtil.enterText(callBackAPIURLTxtField_BENEMGMT, callBackAPIURL_BENEMGMT);
										elementUtil.SHORT_TIMEOUT();
										elementUtil.clearText(callBackRetriesTxtField_BENEMGMT);
										elementUtil.enterText(callBackRetriesTxtField_BENEMGMT, callBackRetries_BENEMGMT);
										elementUtil.selectDropDownByVisibleText(callbackProxyDropdown_BENEMGMT, callBackProxy_BENEMGMT);
									} // end of if
								} // end of if
								//If Product Payment Type field value is NEFT perform following
								else if (selectValues_Two[j].equals("NEFT")) {
									elementUtil.selectDropDownByVisibleText(sendCallBackDropDown_NEFT, sendCallBack_NEFT);
									// enter values for Callback Type, Callback API URL, Callback Retries, Proxy
									// fields only if
									// value of sendCallBack from input file is Y
									if (sendCallBack_NEFT.equals("Y")) {
										System.out.println("in if for NEFT");
										elementUtil.selectDropDownByVisibleText(callBackTypeDropDown_NEFT, callBackType_NEFT);
										elementUtil.SHORT_TIMEOUT();
										elementUtil.enterText(callBackAPIURLTxtField_NEFT, callBackAPIURL_NEFT);
										elementUtil.SHORT_TIMEOUT();
										elementUtil.clearText(callBackRetriesTxtField_NEFT);
										elementUtil.enterText(callBackRetriesTxtField_NEFT, callBackRetries_NEFT);
										elementUtil.selectDropDownByVisibleText(callbackProxyDropdown_NEFT, callBackProxy_NEFT);
									} // end of if
								} // end of else if
								//If Product Payment Type field value is RTGS perform following
								else if (selectValues_Two[j].equals("RTGS")) {
									elementUtil.selectDropDownByVisibleText(sendCallBackDropDown_RTGS, sendCallBack_RTGS);
									// enter values for Callback Type, Callback API URL, Callback Retries, Proxy
									// fields only if
									// value of sendCallBack from input file is Y
									if (sendCallBack_RTGS.equals("Y")) {
										System.out.println("in if for rtgs");
										elementUtil.selectDropDownByVisibleText(callBackTypeDropDown_RTGS, callBackType_RTGS);
										elementUtil.SHORT_TIMEOUT();
										elementUtil.enterText(callBackAPIURLTxtField_RTGS, callBackAPIURL_RTGS);
										elementUtil.SHORT_TIMEOUT();
										elementUtil.clearText(callBackRetriesTxtField_RTGS);
										elementUtil.enterText(callBackRetriesTxtField_RTGS, callBackRetries_RTGS);
										elementUtil.selectDropDownByVisibleText(callbackProxyDropdown_RTGS, callBackProxy_RTGS);
									} // end of if
								} // end of else if
								else if (selectValues_Two[j].equals("UPI")) {
									elementUtil.selectDropDownByVisibleText(sendCallBackDropDown_UPI, sendCallBack_UPI);
									// enter values for Callback Type, Callback API URL, Callback Retries, Proxy
									// fields only if
									// value of sendCallBack from input file is Y
									if (sendCallBack_RTGS.equals("Y")) {
										System.out.println("in if for upi");
										elementUtil.selectDropDownByVisibleText(callBackTypeDropDown_UPI, callBackType_UPI);
										elementUtil.SHORT_TIMEOUT();
										elementUtil.enterText(callBackAPIURLTxtField_UPI, callBackAPIURL_UPI);
										elementUtil.SHORT_TIMEOUT();
										elementUtil.clearText(callBackRetriesTxtField_UPI);
										elementUtil.enterText(callBackRetriesTxtField_UPI, callBackRetries_UPI);
										elementUtil.selectDropDownByVisibleText(callbackProxyDropdown_UPI, callBackProxy_UPI);
									} // end of if
								} // end of else if
							}//end of for loop
						}//end of if
					} // end of else

					// click on ok button
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(okBtn);

					// check if dialog box is displayed
					try {
						System.out.println("in try");
						if (custAddScreenDialogBox.isDisplayed()) {
							System.out.println("in if for custAddScreenDialogBox ");
							// accept the alert
							elementUtil.SHORT_TIMEOUT();
							elementUtil.clickElement(dialogBox_OkBtn);
							// check if error message is displayed after clicking on OK in dialog box
							try {
								if (errormessages.isDisplayed()) {

									System.out.println("in if for error message displayed");
									log.info(elementUtil.getText(errormessages));
									log.info("Test Data Provided Is Not as per valid format");

								} // end of if
							} catch (NoSuchElementException e3) {

								// click on Back button
								elementUtil.SHORT_TIMEOUT();
								elementUtil.clickElement(backBtn);

								if (elementUtil.getText(errormessages).trim().toString()
										.equals("User Pressed Back Key".trim().toString())) {
									log.info("Back Button Is Working Properly");
								} // end of if
								else {
									log.error("Back Button Is Not Working Properly");
								} // end of else

								// click on ok button
								elementUtil.SHORT_TIMEOUT();
								elementUtil.clickElement(okBtn);

								if (modificationReason.isEmpty()) {
									log.info(
											"Modification Reason Not Provided Hence, No Modification performed on record");
								} else {
									elementUtil.SHORT_TIMEOUT();
									elementUtil.enterText(rejctionTxtBox, modificationReason);

									elementUtil.SHORT_TIMEOUT();
									elementUtil.clickElement(modifyConfirmBtn);
									String expectedRecordAddMessage = "Modifications saved for "
											+ customerKey + " Waiting Approve";
									if (elementUtil.getText(messages).trim().toString()
											.equals(expectedRecordAddMessage.trim().toString())) {
										log.info("Record With Customer Key " + customerKey
												+ " Modified Successfully");
									} // end of if
								} // end of else

							}//end of catch
						}//end of if
					} catch (NoSuchElementException e2) {
						System.out.println("in catch for dialog box not displayed");
						// check if error message is displayed after clicking on Ok button on dialog box
						try {
							System.out.println("in try for error message dispkayed");
							if (errormessages.isDisplayed()) {

								System.out.println("in if for error message displayed");
								log.info(elementUtil.getText(errormessages));
								log.info("Test Data Provided Is Not as per valid format");

							} // end of if
						} catch (NoSuchElementException e4) {
							// click on Back button
							elementUtil.SHORT_TIMEOUT();
							elementUtil.clickElement(backBtn);

							if (elementUtil.getText(errormessages).trim().toString()
									.equals("User Pressed Back Key".trim().toString())) {
								log.info("Back Button Is Working Properly");
							} // end of if
							else {
								log.error("Back Button Is Not Working Properly");
							} // end of else

							// click on ok button
							elementUtil.SHORT_TIMEOUT();
							elementUtil.clickElement(okBtn);

							if (modificationReason.isEmpty()) {
								log.info(
										"Modification Reason Not Provided Hence, No Modification performed on record");
							} else {
								elementUtil.SHORT_TIMEOUT();
								elementUtil.enterText(rejctionTxtBox, modificationReason);

								elementUtil.SHORT_TIMEOUT();
								elementUtil.clickElement(modifyConfirmBtn);
								String expectedRecordAddMessage = "Modifications saved for "
										+ customerKey + " Waiting Approve";
								if (elementUtil.getText(messages).trim().toString()
										.equals(expectedRecordAddMessage.trim().toString())) {
									log.info("Record With Customer Key " + customerKey
											+ " Modified Successfully");
								} // end of if
							} // end of else
						}//end of catch

					}//end of catch
				} // end of if
				else {
					log.info("Record Mismatch, Record With Customer Key, " + customerKey + "Not Found For Modify");
				}
			} // end of catch

		} // end of for loop

		// perform logout operation
		elementUtil.handlewin1(driver);
		logOutOperation();
	}// end of modifyCustomerRecord function

	// -----------------------------Method to Modify Customer Record Invalid Data---------------------------------------
	public void modifyCustomerRecordInvalidData(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {

		// fetch values
		test_Data = fileReader.readCustomerExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String modifyOperation = map.get("Modify Operation");
			String customerKey = map.get("Customer Key");
			String merchantName = map.get("Merchant Name");
			String LegalName = map.get("Legal Name");
			String correspondentAddrLine1 = map.get("Correspondent Address Line 1");
			String correspondentAddrLine2 = map.get("Correspondent Address Line 2");
			String correspondentAddrLine3 = map.get("Correspondent Address Line 3");
			String correspondentPinCode = map.get("Correspondent Pin Code");
			String mobileNo = map.get("Mobile No");
			String emailId = map.get("Email Id");
			String encryption = map.get("Encryption");
			String Select_Product_PaymentType = map.get("Select_ProductPaymentType");
			String sendEncryptionKey = map.get("Send Encryption Key");
			String customerType = map.get("Customer Type");
			String merchantType = map.get("Merchant Type");
			String submerchantEnabled = map.get("Sub Merchant Enabled");
			String beneficiaryMaintenanceEnabled = map.get("Beneficiary Maintenance Enabled");
			String beneficiaryApprovalType = map.get("Beneficiary Approval Type");
			String customerEnabled = map.get("Customer Enabled");
			String updatedConsoleSystem = map.get("Update Console System");
			String productPaymentType = map.get("Product Payment Type");
			String paymentType = map.get("Payment Type");
			String sendCallBack = map.get("Send Callback");
			String callBackType = map.get("Callback Type");
			String callBackAPIURL = map.get("Callback API URL");
			String callBackRetries = map.get("Callback Retries");
			String callBackProxy = map.get("Callback Proxy");
			String modificationReason = map.get("Modification Reason");
			String bankORCustomer = map.get("Bank or Customer");
			String sendCallBack_BENEMGMT = map.get("Send Callback_BENEMGMT");
			String sendCallBack_NEFT = map.get("Send Callback_NEFT");
			String sendCallBack_RTGS = map.get("Send Callback_RTGS");
			String sendCallBack_UPI = map.get("Send Callback_UPI");
			String callBackType_BENEMGMT = map.get("Callback Type_BENEMGMT");
			String callBackType_NEFT = map.get("Callback Type_NEFT");
			String callBackType_RTGS = map.get("Callback Type_RTGS");
			String callBackType_UPI = map.get("Callback Type_UPI");
			String callBackAPIURL_BENEMGMT = map.get("Callback API URL_BENEMGMT");
			String callBackAPIURL_NEFT = map.get("Callback API URL_NEFT");
			String callBackAPIURL_RTGS = map.get("Callback API URL_RTGS");
			String callBackAPIURL_UPI = map.get("Callback API URL_UPI");
			String callBackRetries_BENEMGMT = map.get("Callback Retries_BENEMGMT");
			String callBackRetries_NEFT = map.get("Callback Retries_NEFT");
			String callBackRetries_RTGS = map.get("Callback Retries_RTGS");
			String callBackRetries_UPI = map.get("Callback Retries_UPI");
			String callBackProxy_BENEMGMT = map.get("Callback Proxy_BENEMGMT");
			String callBackProxy_NEFT = map.get("Callback Proxy_NEFT");
			String callBackProxy_RTGS = map.get("Callback Proxy_RTGS");
			String callBackProxy_UPI = map.get("Callback Proxy_UPI");
			String SelectProduct_Payment_Type_Values=map.get("Select_Product_Payment_Type_Values");
			String DeSelect_Product_Payment_Type_Values=map.get("DeSelect_Product_Payment_Type_Values");
			String DeSelect_ProductPaymentType=map.get("DeSelect_ProductPaymentType");



			// click on Restart Workflow
			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(restartWorkFlowBtn);

			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(customerKeyTxtField, customerKey);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(modifyOperationDropDown, modifyOperation);

			// click on ok button
			elementUtil.clickElement(okBtn);
			// check if record exists for modify operation
			try {
				if (elementUtil.getText(errormessages).trim().toString()
						.equals("Please try again later.Unable to get data from FCR".trim().toString())) {
					log.info("Unable to get data from FCR for record with customer key " + customerKey);
				} // end of if
				else if (elementUtil.getText(errormessages).trim().toString()
						.equals("No Records available for Modify operation".trim().toString())) {
					log.info("Record With [ Customer Key : " + customerKey + " Not Found For Modify Operation");
					log.info("No Records available for Modify operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With [ Customer Key : " + customerKey + " Not Found For Modify Operation");
					log.error("No Records available for Modify operation Validation Message Displayed Is Incorrect");

				} // end of else

			} catch (NoSuchElementException e) {


				if (elementUtil.getAttribute(customerKeyTxtField).trim().toString()
						.equals(customerKey.trim().toString())) {

					// check the operation value from input sheet
					// if value is Resend the user can only modify Encryption field value
					if (modifyOperation.equals("RESEND")) {
						elementUtil.selectDropDownByVisibleText(encryptionTxtField, encryption);
					} // end of if
					// if value is Regenerate the user can only modify Encryption field value
					else if (modifyOperation.equals("REGENERATE")) {
						elementUtil.selectDropDownByVisibleText(encryptionTxtField, encryption);
					} // end of else if
					else if (modifyOperation.equals("REINITIATE_CONSOLE_API")) {
						elementUtil.selectDropDownByVisibleText(updateConsoleSystemDropDown, updatedConsoleSystem);
					} else {
						// Fill the details
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(merchantNameTxtField);
						elementUtil.enterText(merchantNameTxtField, merchantName);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(legalNameTxtField);
						elementUtil.enterText(legalNameTxtField, LegalName);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(correspondentAddressLine1TxtField);
						elementUtil.enterText(correspondentAddressLine1TxtField, correspondentAddrLine1);
						// if correspondentAddressLine2 field is provided in input file then only enter
						// value in screen
						// else existing value present in screen to be considered
						if (!correspondentAddrLine2.isEmpty()) {
							System.out.println("in if");
							elementUtil.SHORT_TIMEOUT();
							elementUtil.clearText(correspondentAddressLine2TxtField);
							elementUtil.enterText(correspondentAddressLine2TxtField, correspondentAddrLine2);
						} // end of if
						// if correspondentAddressLine3 field is provided in input file then only enter
						// value in screen
						// else existing value present in screen to be considered
						if (!correspondentAddrLine3.isEmpty()) {
							System.out.println("in if");
							elementUtil.SHORT_TIMEOUT();
							elementUtil.clearText(correspondentAddressLine3TxtField);
							elementUtil.enterText(correspondentAddressLine3TxtField, correspondentAddrLine3);

						} // end of if
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(correspondentPincodeTxtField);
						elementUtil.enterText(correspondentPincodeTxtField, correspondentPinCode);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(mobileNoTxtField);
						elementUtil.enterText(mobileNoTxtField, mobileNo);
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clearText(emailAddressTxtField);
						elementUtil.enterText(emailAddressTxtField, emailId);
						elementUtil.selectDropDownByVisibleText(encryptionTxtField, encryption);
						elementUtil.selectDropDownByVisibleText(merchantTypeDropDown, merchantType);
						elementUtil.javascriptExecutorClickElement(subMerchantEnabledDropdown);
						elementUtil.selectDropDownByVisibleText(subMerchantEnabledDropdown, submerchantEnabled);
						elementUtil.selectDropDownByVisibleText(bankORCustomerDropdown, bankORCustomer);
						elementUtil.selectDropDownByVisibleText(beneficiaryApprovalTypeDropDown,
								beneficiaryApprovalType);
						elementUtil.selectDropDownByVisibleText(customerEnabledDropDown, customerEnabled);
						elementUtil.selectDropDownByVisibleText(updateConsoleSystemDropDown, updatedConsoleSystem);

						if(DeSelect_Product_Payment_Type_Values.equals("Y"))
						{

							if(DeSelect_ProductPaymentType.isEmpty())
							{
								log.info("No Values Provided For Deselection Hence No Modification Will Be Performed");
							}//end of if
							else
							{
								String DeselectValues_One[]=DeSelect_ProductPaymentType.split(",");
								elementUtil.deselectingElementValue_FromList(productPaymentField,DeselectValues_One);
								elementUtil.SHORT_TIMEOUT();
							}//end of else

						}//end of if

						if(SelectProduct_Payment_Type_Values.equals("Y"))
						{
							if(Select_Product_PaymentType.isEmpty())
							{
								log.info("No Values Provided For Selection Hence No Modification Will Be Performed");
							}//end of if
							else
							{

								//splitting all productPaymentField values received from file to select multiple if any
								String selectValues_Two[]=Select_Product_PaymentType.split(",");
								elementUtil.selectElementValue_FromList(productPaymentField,selectValues_Two);


								elementUtil.SHORT_TIMEOUT();
								//loop through all the values and check product payment type field value
								for(int j=0;j<selectValues_Two.length;j++)
								{
									if (selectValues_Two[j].equals("BENEMGMT")) {
										elementUtil.selectDropDownByVisibleText(sendCallBackDropDown_BENEMGMT, sendCallBack_BENEMGMT);
										// enter values for Callback Type, Callback API URL, Callback Retries, Proxy
										// fields only if
										// value of sendCallBack from input file is Y
										if (sendCallBack_BENEMGMT.equals("Y")) {
											System.out.println("in if for BENEMGMT");
											elementUtil.selectDropDownByVisibleText(callBackTypeDropDown_BENEMGMT, callBackType_BENEMGMT);
											elementUtil.SHORT_TIMEOUT();
											elementUtil.enterText(callBackAPIURLTxtField_BENEMGMT, callBackAPIURL_BENEMGMT);
											elementUtil.SHORT_TIMEOUT();
											elementUtil.clearText(callBackRetriesTxtField_BENEMGMT);
											elementUtil.enterText(callBackRetriesTxtField_BENEMGMT, callBackRetries_BENEMGMT);
											elementUtil.selectDropDownByVisibleText(callbackProxyDropdown_BENEMGMT, callBackProxy_BENEMGMT);
										} // end of if
									} // end of if
									else if (selectValues_Two[j].equals("NEFT")) {
										elementUtil.selectDropDownByVisibleText(sendCallBackDropDown_NEFT, sendCallBack_NEFT);
										// enter values for Callback Type, Callback API URL, Callback Retries, Proxy
										// fields only if
										// value of sendCallBack from input file is Y
										if (sendCallBack_NEFT.equals("Y")) {
											System.out.println("in if for NEFT");
											elementUtil.selectDropDownByVisibleText(callBackTypeDropDown_NEFT, callBackType_NEFT);
											elementUtil.SHORT_TIMEOUT();
											elementUtil.enterText(callBackAPIURLTxtField_NEFT, callBackAPIURL_NEFT);
											elementUtil.SHORT_TIMEOUT();
											elementUtil.clearText(callBackRetriesTxtField_NEFT);
											elementUtil.enterText(callBackRetriesTxtField_NEFT, callBackRetries_NEFT);
											elementUtil.selectDropDownByVisibleText(callbackProxyDropdown_NEFT, callBackProxy_NEFT);
										} // end of if
									} // end of else if
									else if (selectValues_Two[j].equals("RTGS")) {
										elementUtil.selectDropDownByVisibleText(sendCallBackDropDown_RTGS, sendCallBack_RTGS);
										// enter values for Callback Type, Callback API URL, Callback Retries, Proxy
										// fields only if
										// value of sendCallBack from input file is Y
										if (sendCallBack_RTGS.equals("Y")) {
											System.out.println("in if for rtgs");
											elementUtil.selectDropDownByVisibleText(callBackTypeDropDown_RTGS, callBackType_RTGS);
											elementUtil.SHORT_TIMEOUT();
											elementUtil.enterText(callBackAPIURLTxtField_RTGS, callBackAPIURL_RTGS);
											elementUtil.SHORT_TIMEOUT();
											elementUtil.clearText(callBackRetriesTxtField_RTGS);
											elementUtil.enterText(callBackRetriesTxtField_RTGS, callBackRetries_RTGS);
											elementUtil.selectDropDownByVisibleText(callbackProxyDropdown_RTGS, callBackProxy_RTGS);
										} // end of if
									} // end of else if
									else if (selectValues_Two[j].equals("UPI")) {
										elementUtil.selectDropDownByVisibleText(sendCallBackDropDown_UPI, sendCallBack_UPI);
										// enter values for Callback Type, Callback API URL, Callback Retries, Proxy
										// fields only if
										// value of sendCallBack from input file is Y
										if (sendCallBack_UPI.equals("Y")) {
											System.out.println("in if for rtgs");
											elementUtil.selectDropDownByVisibleText(callBackTypeDropDown_UPI, callBackType_UPI);
											elementUtil.SHORT_TIMEOUT();
											elementUtil.enterText(callBackAPIURLTxtField_UPI, callBackAPIURL_UPI);
											elementUtil.SHORT_TIMEOUT();
											elementUtil.clearText(callBackRetriesTxtField_UPI);
											elementUtil.enterText(callBackRetriesTxtField_UPI, callBackRetries_UPI);
											elementUtil.selectDropDownByVisibleText(callbackProxyDropdown_UPI, callBackProxy_UPI);
										} // end of if
									} // end of else if
						
								}//end of for loop
							}//end of if
						}//end of if
					} // end of else

					// click on ok button
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(okBtn);

					// check if dialog box is displayed
					try {
						System.out.println("in try");
						if (custAddScreenDialogBox.isDisplayed()) {
							System.out.println("in if for custAddScreenDialogBox ");
							// accept the alert
							elementUtil.SHORT_TIMEOUT();
							elementUtil.clickElement(dialogBox_OkBtn);
							// check if error message is displayed after clicking on OK in dialog box
							try {
								if (errormessages.isDisplayed()) {

									System.out.println("in if for error message displayed");
									log.info(elementUtil.getText(errormessages));
								} // end of if
							} catch (NoSuchElementException e3) {
								log.info("Test Data Provided Is Not Invalid");
							}//end of catch
						}//end of if
					} catch (NoSuchElementException e2) {
						System.out.println("in catch for dialog box not displayed");
						// check if error message is displayed after clicking on Ok button on dialog box
						try {
							System.out.println("in try for error message dispkayed");
							if (errormessages.isDisplayed()) {

								System.out.println("in if for error message displayed");
								log.info(elementUtil.getText(errormessages));
							} // end of if
						} catch (NoSuchElementException e4) {
							log.info("Test Data Provided Is Not Invalid");
						}//end of catch

					}//end of catch
				} // end of if
				else {
					log.info("Record Mismatch, Record With Customer Key, " + customerKey + "Not Found For Modify");
				}
			} // end of catch

		} // end of for loop

		// perform logout operation
		elementUtil.handlewin1(driver);
		logOutOperation();
	}// end of modifyCustomerRecordInvalidData function


	// ------------------------Method to List Customer Record-------------------------------
	public void listCustomerRecord(String SheetName) throws InvalidFormatException, IOException, InterruptedException {
		// merchant name field value entering is not done in code as getting validation
		// message no records after entering merchant name
		// hence as of now code related to it is commented changes to be done after fix

		// fetch details
		test_Data = fileReader.readCustomerExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String Enter_CUSTOMER_Key = map.get("Customer Key");
			String merchantName = map.get("Merchant Name");
			String customerEnabled = map.get("Customer Enabled");

			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(restartWorkFlowBtn);

			// enter details
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(customerKeyTxtField, Enter_CUSTOMER_Key);
			// elementUtil.SHORT_TIMEOUT();
			// elementUtil.enterText(merchantNameTxtField, merchantName);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(customerEnabledDropDown, customerEnabled);

			// click on Reset button
			elementUtil.clickElement(resetBtn);

			// check reset button working
			if (elementUtil.getText(customerKeyTxtField).isEmpty()
					&& elementUtil.getText(merchantNameTxtField).isEmpty()) {
				log.info("Reset Button Is Working Properly");
			} // end of if
			else {
				log.error("Reset Button Is Not Working Properly");
			} // end of else

			// enter details after reset operation
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(customerKeyTxtField, Enter_CUSTOMER_Key);
			// elementUtil.SHORT_TIMEOUT();
			// elementUtil.enterText(merchantNameTxtField, merchantName);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(customerEnabledDropDown, customerEnabled);

			// click on ok button
			elementUtil.clickElement(okBtn);

			try {
				if (elementUtil.getText(errormessages).trim().toString()
						.equals("No Records available for List operation".trim().toString())) {
					log.info("Record With [ Customer Key : " + Enter_CUSTOMER_Key + " , Merchant Name : " + merchantName
							+ " , Customer Enabled : " + customerEnabled + " ] Not Found For List Operation");
					log.info("No Records available for List operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With [ Customer Key : " + Enter_CUSTOMER_Key + " , Merchant Name : " + merchantName
							+ " , Customer Enabled : " + customerEnabled + " ] Not Found For List Operation");
					log.error("No items available for List operation Validation Message Displayed Is Incorrect");
					log.error("No Records available for List operation Validation Message Displayed Is Incorrect");

				} // end of else
			} catch (NoSuchElementException e) {
				// click on record
				String recordStatusValue = elementUtil.getText(listScreenRecordStatusValue);
				elementUtil.clickElement(screenRecord);
				if (elementUtil.getAttribute(customerKeyTxtField).trim().toString()
						.equals(Enter_CUSTOMER_Key.trim().toString())) {
					log.info("Record With [ Customer Key : " + Enter_CUSTOMER_Key + " , Merchant Name : " + merchantName
							+ " , Customer Enabled : " + customerEnabled + " ] Is Displayed In List With Status "
							+ recordStatusValue);

				} // end of if
				else {
					log.info("Record With [ Customer Key : " + Enter_CUSTOMER_Key + " , Merchant Name : " + merchantName
							+ " , Customer Enabled : " + customerEnabled + " ] Is Not Displayed In List");
				} // end of else

			} // end of catch

		} // end of catch

		elementUtil.handlewin1(driver);
		logOutOperation();

	}// end of listCustomerRecord function

	// ------------------------Method to Delete Customer Record -------------------------------
	public void deleteCustomerRecord(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		// as of now if merchant name value entered no items available message displayed
		// hence merchant name entering commented
		// and also checking in if loop removed after fix code to be inserted again
		// fetch details
		test_Data = fileReader.readCustomerExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String Enter_CUSTOMER_Key = map.get("Customer Key");
			String merchantName = map.get("Merchant Name");

			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(restartWorkFlowBtn);

			// enter details
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(customerKeyTxtField, Enter_CUSTOMER_Key);
			// elementUtil.SHORT_TIMEOUT();
			// elementUtil.enterText(merchantNameTxtField, merchantName);

			// click on Reset button
			elementUtil.clickElement(resetBtn);

			// check reset button working
			if (elementUtil.getText(customerKeyTxtField).isEmpty()
					&& elementUtil.getText(merchantNameTxtField).isEmpty()) {
				log.info("Reset Button Is Working Properly");
			} // end of if
			else {
				log.error("Reset Button Is Not Working Properly");
			} // end of else

			// enter details after reset operation
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(customerKeyTxtField, Enter_CUSTOMER_Key);
		
			// click on ok button
			elementUtil.clickElement(okBtn);

			try {
				if (elementUtil.getText(errormessages).trim().toString()
						.equals("No Records available for Delete operation".trim().toString())) {
					log.info("Record With [ Customer Key : " + Enter_CUSTOMER_Key + " , Merchant Name : " + merchantName
							+ " ] Not Found For Delete Operation");
					log.info("No Records available for Delete operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With [ Customer Key : " + Enter_CUSTOMER_Key + " , Merchant Name : " + merchantName
							+ " ] Not Found For Delete Operation");
					log.error("No Records available for Delete operation Validation Message Displayed Is Incorrect");

				} // end of else
			} catch (NoSuchElementException e) {

				if (elementUtil.getAttribute(customerKeyTxtField).trim().toString()
						.equals(Enter_CUSTOMER_Key.trim().toString())) {
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(cancelBtn);

					if (elementUtil.getText(errormessages).trim().toString().equals("Operation Cancelled")) {
						log.info("Cancel Button Is Working Properly");
					} // end of if
					else {
						log.error("Cancel Button Is Not Working Properly");
					} // end of else

					// enter details after cancel operation
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(customerKeyTxtField, Enter_CUSTOMER_Key);
					// elementUtil.SHORT_TIMEOUT();
					// elementUtil.enterText(merchantNameTxtField, merchantName);

					// click on ok button
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(okBtn);

					// click on ok button
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(okBtn);

					// click on cancel button
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(cancelBtn);

					if (elementUtil.getText(errormessages).trim().toString().equals("Operation Cancelled")) {
						log.info("Cancel Button Is Working Properly");
					} // end of if
					else {
						log.error("Cancel Button Is Not Working Properly");
					} // end of else

					// enter details after cancel operation
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(customerKeyTxtField, Enter_CUSTOMER_Key);
			
					// click on ok button
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(okBtn);

					// click on ok button
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(okBtn);

					// click on Delete button
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(deleteBtn);

					String expectedMessage = "Record Marked for deletion for " + Enter_CUSTOMER_Key
							+ " Waiting Confirm";
					elementUtil.SHORT_TIMEOUT();
					if (elementUtil.getText(messages).trim().toString().equals(expectedMessage.trim().toString())) {
						log.info("Record With Customer Key " + Enter_CUSTOMER_Key + " Delete Successfully");
					} // end of if

				} // end of if
				else {
					log.info("Record Mismatch , Record With [ Customer Key : " + Enter_CUSTOMER_Key
							+ " , Merchant Name : " + merchantName + " ] Not Found For Delete");
				} // end of else

			} // end of catch

		} // end of catch

		// perform logout operation
		elementUtil.handlewin1(driver);
		logOutOperation();

	}// end of DeleteCustomerRecord function

	// ------------------------Method to Confirm Delete Customer Record -------------------------------
	public void confirmDeleteCustomerRecord(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		// as of now if merchant name value entered no items available message displayed
		// hence merchant name entering commented
		// and also checking in if loop removed after fix code to be inserted again

		// fetch details
		test_Data = fileReader.readCustomerExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String Enter_CUSTOMER_Key = map.get("Customer Key");
			String merchantName = map.get("Merchant Name");
			String operation = map.get("Operation");

			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(restartWorkFlowBtn);

			// enter details
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(customerKeyTxtField, Enter_CUSTOMER_Key);
			// elementUtil.SHORT_TIMEOUT();
			// elementUtil.enterText(merchantNameTxtField, merchantName);

			// click on Reset button
			elementUtil.clickElement(resetBtn);

			// check reset button working
			if (elementUtil.getText(customerKeyTxtField)
					.isEmpty() /* && elementUtil.getText(merchantNameTxtField).isEmpty() */) {
				log.info("Reset Button Is Working Properly");
			} // end of if
			else {
				log.error("Reset Button Is Not Working Properly");
			} // end of else

			// enter details after reset operation
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(customerKeyTxtField, Enter_CUSTOMER_Key);
			// elementUtil.SHORT_TIMEOUT();
			// elementUtil.enterText(merchantNameTxtField, merchantName);

			// click on ok button
			elementUtil.clickElement(okBtn);

			try {
				String expectedFourEyePrincipleMessage = "Record (" + Enter_CUSTOMER_Key
						+ ") Failed 4 Eyes Principle - You cannot approve your own changes";
				if (elementUtil.getText(errormessages).trim().toString()
						.equals(expectedFourEyePrincipleMessage.trim().toString())) {
					log.info("Four Eye Check Principle Failed : You cannot approve your own changes");
				} else if (elementUtil.getText(errormessages).trim().toString()
						.equals("No Records available for Confirm Delete operation".trim().toString())) {
					log.info("Record With [ Customer Key : " + Enter_CUSTOMER_Key + " , Merchant Name : " + merchantName
							+ " ] Not Found For Confirm Delete Operation");
					log.info(
							"No Records available for Confirm Delete operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With [ Customer Key : " + Enter_CUSTOMER_Key + " , Merchant Name : " + merchantName
							+ " ] Not Found For Confirm Delete Operation");
					log.error(
							"No Records available for Confirm Delete operation Validation Message Displayed Is Incorrect");

				} // end of else
			} catch (NoSuchElementException e) {

				if (elementUtil.getAttribute(customerKeyTxtField).trim().toString()
						.equals(Enter_CUSTOMER_Key.trim().toString())) {
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(cancelBtn);

					if (elementUtil.getText(errormessages).trim().toString().equals("Operation Cancelled")) {
						log.info("Cancel Button Is Working Properly");
					} // end of if
					else {
						log.error("Cancel Button Is Not Working Properly");
					} // end of else

					// enter details after cancel operation
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(customerKeyTxtField, Enter_CUSTOMER_Key);
					// elementUtil.SHORT_TIMEOUT();
					// elementUtil.enterText(merchantNameTxtField, merchantName);

					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(okBtn);

					if (operation.equalsIgnoreCase("Confirm Delete")) {
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clickElement(deleteConfirmBtn);
						String expectedMessage1 = "Record deleted for " + Enter_CUSTOMER_Key;
						if (elementUtil.getText(messages).trim().toString()
								.equals(expectedMessage1.trim().toString())) {
							log.info("Confirm Delete Operation Perform On Record With Customer Key "
									+ Enter_CUSTOMER_Key);
						} // end of if
					} // end of if
					else if (operation.equalsIgnoreCase("Cancel Delete Action")) {
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clickElement(cancelDeleteActionBtn);
						String expectedMessage2 = "Deletion cancelled for " + Enter_CUSTOMER_Key;
						if (elementUtil.getText(messages).trim().toString()
								.equals(expectedMessage2.trim().toString())) {
							log.info("Cancel Delete Action Operation Perform On Record With Customer Key "
									+ Enter_CUSTOMER_Key);
						} // end of if

					} // end of else if
					else {
						log.info("No Operation Performed On Record With Customer Key " + Enter_CUSTOMER_Key
								+ " As Operation Value Not Provided");
					} // end of else

				} // end of if
				else {
					log.info("Record Mismatch , Record With [ Customer Key : " + Enter_CUSTOMER_Key
							+ " , Merchant Name : " + merchantName + " ] Not Found For Delete");
				} // end of else

			} // end of catch

		} // end of catch

		// perform logout operation
		elementUtil.handlewin1(driver);
		logOutOperation();

	}// end of confirmDeleteCustomerRecord function

	// ------------------------Method to Approve/Perform Cancel Modify Action On Customer Record -------------------------------
	public void approveCustomerRecord(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		// as of now if merchant name value entered no items available message displayed
		// hence merchant name entering commented
		// and also checking in if loop removed after fix code to be inserted again

		// fetch details
		test_Data = fileReader.readCustomerExcel(SheetName);// Changes Approved for 77889927436, Modifications Cancelled
		// for 77889927436
		for (Map<String, String> map : test_Data) {
			String Enter_CUSTOMER_Key = map.get("Customer Key");
			String merchantName = map.get("Merchant Name");
			String operation = map.get("Operation");
			String rejectionReason = map.get("Rejection Reason");

			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(restartWorkFlowBtn);

			// enter details
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(customerKeyTxtField, Enter_CUSTOMER_Key);

			// click on Reset button
			elementUtil.clickElement(resetBtn);

			// check reset button working
			if (elementUtil.getText(customerKeyTxtField).isEmpty()) {
				log.info("Reset Button Is Working Properly");
			} // end of if
			else {
				log.error("Reset Button Is Not Working Properly");
			} // end of else

			// enter details after reset operation
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(customerKeyTxtField, Enter_CUSTOMER_Key);

			// click on ok button
			elementUtil.clickElement(okBtn);

			try {
				String expectedFourEyePrincipleMessage = "Record (" + Enter_CUSTOMER_Key
						+ ") Failed 4 Eyes Principle - You cannot approve your own changes";
				if (elementUtil.getText(errormessages).trim().toString()
						.equals(expectedFourEyePrincipleMessage.trim().toString())) {
					log.info("Four Eye Check Principle Failed : You cannot approve your own changes");
				} else if (elementUtil.getText(errormessages).trim().toString()
						.equals("No Records available for Approve operation".trim().toString())) {
					log.info("Record With [ Customer Key : " + Enter_CUSTOMER_Key + " , Merchant Name : " + merchantName
							+ " ] Not Found For Approve Operation");
					log.info("No Records available for Approve operation Validation Message Displayed Is Correct");
				} // end of if
				else {
					log.info("Record With [ Customer Key : " + Enter_CUSTOMER_Key + " , Merchant Name : " + merchantName
							+ " ] Not Found For Approve Operation");
					log.error("No Records available for Approve operation Validation Message Displayed Is Incorrect");

				} // end of else
			} catch (NoSuchElementException e) {
				// check if the record revealed is the expected record
				if (elementUtil.getAttribute(customerKeyTxtField).trim().toString()
						.equals(Enter_CUSTOMER_Key.trim().toString())) {
					// click on Cancel button
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(cancelBtn);

					// check Cancel Button working
					if (elementUtil.getText(errormessages).trim().toString().equals("Operation Cancelled")) {
						log.info("Cancel Button Is Working Properly");
					} // end of if
					else {
						log.error("Cancel Button Is Not Working Properly");
					} // end of else

					// enter details after cancel operation
					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(customerKeyTxtField, Enter_CUSTOMER_Key);

					// click on ok button
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(okBtn);

					// check the operation provided in input file
					// if operation Approve approve the record
					// else if Cancel Modify Action perform Cancel Modify Action on record
					// else No reason then No operation should be performed
					if (operation.equalsIgnoreCase("Approve")) {
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clickElement(approveButton);
						String expectedMessage1 = "Changes Approved for " + Enter_CUSTOMER_Key;
						if (elementUtil.getText(messages).trim().toString()
								.equals(expectedMessage1.trim().toString())) {
							log.info("Approve Operation Perform On Record With Customer Key " + Enter_CUSTOMER_Key);
						} // end of if
					} // end of if
					else if (operation.equalsIgnoreCase("Cancel Modify Action")) {
						if (rejectionReason.isEmpty()) {
							log.info(
									"Failed To Perform Cancel Modify Action Operation As No Rejection Reason Provided");
						} // end of if
						else {
							elementUtil.SHORT_TIMEOUT();
							elementUtil.enterText(rejctionTxtBox, rejectionReason);
							elementUtil.clickElement(cancelModifyActionBtn);
							String expectedMessage2 = "Modifications Cancelled for " + Enter_CUSTOMER_Key;
							if (elementUtil.getText(messages).trim().toString()
									.equals(expectedMessage2.trim().toString())) {
								log.info("Cancel Modify Action Operation Perform On Record With Customer Key "
										+ Enter_CUSTOMER_Key);
							} // end of if
						} // end of else
					} // end of else if
					else {
						log.info("No Operation Performed On Record With Customer Key " + Enter_CUSTOMER_Key
								+ " As Operation Value Not Provided");
					} // end of else

				} // end of if
				else {
					log.info("Record Mismatch , Record With [ Customer Key : " + Enter_CUSTOMER_Key
							+ " , Merchant Name : " + merchantName + " ] Not Found For Approve");
				} // end of else

			} // end of catch

		} // end of catch

		// perform logout operation
		elementUtil.handlewin1(driver);
		logOutOperation();

	}// end of approveCustomerRecord function

	// -----------------------------Method to Add Customer Record With Invalid Data---------------------------------------
	public void addCustomerRecordInvalidData(String SheetName)
			throws InterruptedException, InvalidFormatException, IOException {

		// fetch values
		test_Data = fileReader.readCustomerExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String customerCreationType = map.get("Customer Creation Type");
			String customerKey = map.get("Customer Key");
			String merchantName = map.get("Merchant Name");
			String merchantId = map.get("Merchant Id");
			String LegalName = map.get("Legal Name");
			String permanentAddrLine1 = map.get("Permanent Address Line 1");
			String permanentAddrLine2 = map.get("Permanent Address Line 2");
			String permanentAddrLine3 = map.get("Permanent Address Line 3");
			String correspondentAddrLine1 = map.get("Correspondent Address Line 1");
			String correspondentAddrLine2 = map.get("Correspondent Address Line 2");
			String correspondentAddrLine3 = map.get("Correspondent Address Line 3");
			String permanentPinCode = map.get("Permanent Pin Code");
			String sendCallBack_BENEMGMT = map.get("Send Callback_BENEMGMT");
			String correspondentPinCode = map.get("Correspondent Pin Code");
			String mobileNo = map.get("Mobile No");
			String emailId = map.get("Email Id");
			String encryption = map.get("Encryption");
			String sendEncryptionKey = map.get("Send Encryption Key");
			String customerType = map.get("Customer Type");
			String merchantType = map.get("Merchant Type");
			String submerchantEnabled = map.get("Sub Merchant Enabled");
			String beneficiaryMaintenanceEnabled = map.get("Beneficiary Maintenance Enabled");
			String beneficiaryApprovalType = map.get("Beneficiary Approval Type");
			String customerEnabled = map.get("Customer Enabled");
			String updatedConsoleSystem = map.get("Update Console System");
			String productPaymentType = map.get("Product Payment Type");
			String paymentType = map.get("Payment Type");
			String sendCallBack = map.get("Send Callback");
			String callBackType = map.get("Callback Type");
			String callBackAPIURL = map.get("Callback API URL");
			String callBackRetries = map.get("Callback Retries");
			String callBackProxy = map.get("Callback Proxy");
			String bankORCustomer = map.get("Bank or Customer");
			String sendCallBack_NEFT = map.get("Send Callback_NEFT");
			String sendCallBack_RTGS = map.get("Send Callback_RTGS");
			String sendCallBack_UPI = map.get("Send Callback_UPI");
			String callBackType_BENEMGMT = map.get("Callback Type_BENEMGMT");
			String callBackType_NEFT = map.get("Callback Type_NEFT");
			String callBackType_RTGS = map.get("Callback Type_RTGS");
			String callBackType_UPI = map.get("Callback Type_UPI");
			String callBackAPIURL_BENEMGMT = map.get("Callback API URL_BENEMGMT");
			String callBackAPIURL_NEFT = map.get("Callback API URL_NEFT");
			String callBackAPIURL_RTGS = map.get("Callback API URL_RTGS");
			String callBackAPIURL_UPI = map.get("Callback API URL_UPI");
			String callBackRetries_BENEMGMT = map.get("Callback Retries_BENEMGMT");
			String callBackRetries_NEFT = map.get("Callback Retries_NEFT");
			String callBackRetries_RTGS = map.get("Callback Retries_RTGS");
			String callBackRetries_UPI = map.get("Callback Retries_UPI");
			String callBackProxy_BENEMGMT = map.get("Callback Proxy_BENEMGMT");
			String callBackProxy_NEFT = map.get("Callback Proxy_NEFT");
			String callBackProxy_RTGS = map.get("Callback Proxy_RTGS");
			String callBackProxy_UPI = map.get("Callback Proxy_UPI");

			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(restartWorkFlowBtn);

			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(customerKeyTxtField, customerKey);
			elementUtil.SHORT_TIMEOUT();
			elementUtil.selectDropDownByVisibleText(customerCreationTypeDropDown, customerCreationType);
			// click on ok button
			elementUtil.clickElement(okBtn);
			// check if duplicate record exists
			try {
				if (elementUtil.getText(errormessages).trim().toString()
						.equals("Customer Key is already exist".trim().toString())) {
					log.info("Duplicate Record Found : Record With Customer Key " + customerKey + " Already Exists");
				} // end of if
				else if (elementUtil.getText(errormessages).trim().toString()
						.equals("Customer Key should be alphanumeric.".trim().toString())) {
					log.info("Customer Key Value Should be Alphanumeric");
				} // end of else if
				else if (elementUtil.getText(errormessages).trim().toString()
						.equals("Customer Key does not exist in FCR".trim().toString())) {
					log.info("Customer Key " + customerKey + " Does Not Exist In FCR");
				} // end of else if
				else if (elementUtil.getText(errormessages).trim().toString()
						.equals("Record Already in Database".trim().toString())) {
					log.info("Record Already In Database");
				} // end of else if 4453637377
				else if (elementUtil.getText(errormessages).trim().toString()
						.equals("Customer Key is mandatory.".trim().toString())) {
					log.info("Customer Key Is Mandatory");
				} // end of else if

		
			} catch (NoSuchElementException e) {
				elementUtil.SHORT_TIMEOUT();
				elementUtil.clearText(merchantNameTxtField);
				elementUtil.enterText(merchantNameTxtField, merchantName);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.clearText(legalNameTxtField);
				elementUtil.enterText(legalNameTxtField, LegalName);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.clearText(correspondentAddressLine1TxtField);
				elementUtil.enterText(correspondentAddressLine1TxtField, correspondentAddrLine1);
				// if correspondentAddressLine2 field is provided in input file then only enter
				// value in screen
				// else existing value present in screen to be considered
				if (!correspondentAddrLine2.isEmpty()) {
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(correspondentAddressLine2TxtField);
					elementUtil.enterText(correspondentAddressLine2TxtField, correspondentAddrLine2);
				} // end of if
				// if correspondentAddressLine3 field is provided in input file then only enter
				// value in screen
				// else existing value present in screen to be considered
				if (!correspondentAddrLine3.isEmpty()) {

					elementUtil.SHORT_TIMEOUT();
					elementUtil.clearText(correspondentAddressLine3TxtField);
					elementUtil.enterText(correspondentAddressLine3TxtField, correspondentAddrLine3);

				} // end of if
				elementUtil.SHORT_TIMEOUT();
				elementUtil.clearText(correspondentPincodeTxtField);
				elementUtil.enterText(correspondentPincodeTxtField, correspondentPinCode);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.clearText(mobileNoTxtField);
				elementUtil.enterText(mobileNoTxtField, mobileNo);
				elementUtil.SHORT_TIMEOUT();
				elementUtil.clearText(emailAddressTxtField);
				elementUtil.enterText(emailAddressTxtField, emailId);
				elementUtil.selectDropDownByVisibleText(encryptionTxtField, encryption);
				elementUtil.selectDropDownByVisibleText(merchantTypeDropDown, merchantType);
				elementUtil.selectDropDownByVisibleText(subMerchantEnabledDropdown, submerchantEnabled);
				elementUtil.selectDropDownByVisibleText(bankORCustomerDropdown, bankORCustomer);
				elementUtil.selectDropDownByVisibleText(beneficiaryApprovalTypeDropDown, beneficiaryApprovalType);
				elementUtil.selectDropDownByVisibleText(updateConsoleSystemDropDown, updatedConsoleSystem);

				//splitting all productPaymentField values received from file to select multiple if any
				String selectValues[]=productPaymentType.split(",");
				elementUtil.selectElementValue_FromList(productPaymentField,selectValues);

				elementUtil.SHORT_TIMEOUT();
				//loop through all the values and check product payment type field value
				for(int j=0;j<selectValues.length;j++)
				{
					if (selectValues[j].equals("BENEMGMT")) {
						elementUtil.selectDropDownByVisibleText(sendCallBackDropDown_BENEMGMT, sendCallBack_BENEMGMT);
						// enter values for Callback Type, Callback API URL, Callback Retries, Proxy
						// fields only if
						// value of sendCallBack from input file is Y
						if (sendCallBack_BENEMGMT.equals("Y")) {
							System.out.println("in if for BENEMGMT");
							elementUtil.selectDropDownByVisibleText(callBackTypeDropDown_BENEMGMT, callBackType_BENEMGMT);
							elementUtil.SHORT_TIMEOUT();
							elementUtil.enterText(callBackAPIURLTxtField_BENEMGMT, callBackAPIURL_BENEMGMT);
							elementUtil.SHORT_TIMEOUT();
							elementUtil.clearText(callBackRetriesTxtField_BENEMGMT);
							elementUtil.enterText(callBackRetriesTxtField_BENEMGMT, callBackRetries_BENEMGMT);
							elementUtil.selectDropDownByVisibleText(callbackProxyDropdown_BENEMGMT, callBackProxy_BENEMGMT);
						} // end of if
					} // end of if
					else if (selectValues[j].equals("NEFT")) {
						elementUtil.selectDropDownByVisibleText(sendCallBackDropDown_NEFT, sendCallBack_NEFT);
						// enter values for Callback Type, Callback API URL, Callback Retries, Proxy
						// fields only if
						// value of sendCallBack from input file is Y
						if (sendCallBack_NEFT.equals("Y")) {
							System.out.println("in if for NEFT");
							elementUtil.selectDropDownByVisibleText(callBackTypeDropDown_NEFT, callBackType_NEFT);
							elementUtil.SHORT_TIMEOUT();
							elementUtil.enterText(callBackAPIURLTxtField_NEFT, callBackAPIURL_NEFT);
							elementUtil.SHORT_TIMEOUT();
							elementUtil.clearText(callBackRetriesTxtField_NEFT);
							elementUtil.enterText(callBackRetriesTxtField_NEFT, callBackRetries_NEFT);
							elementUtil.selectDropDownByVisibleText(callbackProxyDropdown_NEFT, callBackProxy_NEFT);
						} // end of if
					} // end of else if
					else if (selectValues[j].equals("RTGS")) {
						elementUtil.selectDropDownByVisibleText(sendCallBackDropDown_RTGS, sendCallBack_RTGS);
						// enter values for Callback Type, Callback API URL, Callback Retries, Proxy
						// fields only if
						// value of sendCallBack from input file is Y
						if (sendCallBack_RTGS.equals("Y")) {
							System.out.println("in if for rtgs");
							elementUtil.selectDropDownByVisibleText(callBackTypeDropDown_RTGS, callBackType_RTGS);
							elementUtil.SHORT_TIMEOUT();
							elementUtil.enterText(callBackAPIURLTxtField_RTGS, callBackAPIURL_RTGS);
							elementUtil.SHORT_TIMEOUT();
							elementUtil.clearText(callBackRetriesTxtField_RTGS);
							elementUtil.enterText(callBackRetriesTxtField_RTGS, callBackRetries_RTGS);
							elementUtil.selectDropDownByVisibleText(callbackProxyDropdown_RTGS, callBackProxy_RTGS);
						} // end of if
					} // end of else if
					else if (selectValues[j].equals("UPI")) {
						elementUtil.selectDropDownByVisibleText(sendCallBackDropDown_UPI, sendCallBack_UPI);
						// enter values for Callback Type, Callback API URL, Callback Retries, Proxy
						// fields only if
						// value of sendCallBack from input file is Y
						if (sendCallBack_UPI.equals("Y")) {
							System.out.println("in if for upi");
							elementUtil.selectDropDownByVisibleText(callBackTypeDropDown_UPI, callBackType_UPI);
							elementUtil.SHORT_TIMEOUT();
							elementUtil.enterText(callBackAPIURLTxtField_UPI, callBackAPIURL_UPI);
							elementUtil.SHORT_TIMEOUT();
							elementUtil.clearText(callBackRetriesTxtField_UPI);
							elementUtil.enterText(callBackRetriesTxtField_UPI, callBackRetries_UPI);
							elementUtil.selectDropDownByVisibleText(callbackProxyDropdown_UPI, callBackProxy_UPI);
						} // end of if
					} // end of else if
				}//end of if

				// click on ok button
				elementUtil.SHORT_TIMEOUT();
				elementUtil.clickElement(okBtn);

				// check if dialog box is displayed
				try {
					System.out.println("in try");
					if (custAddScreenDialogBox.isDisplayed()) {
						System.out.println("in if for custAddScreenDialogBox ");
						// accept the alert
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clickElement(dialogBox_OkBtn);
						// check if error message is displayed after clicking on OK in dialog box
						try {
							if (errormessages.isDisplayed()) {
								System.out.println("in if for error message displayed");
								log.info(elementUtil.getText(errormessages));
							} // end of if
						} catch (NoSuchElementException e3) {
							log.info("Test Data Provided Is Not Invalid");
						} // end of catch

					} // end of if

				} catch (NoSuchElementException e2) {
					System.out.println("in catch for dialog box not displayed");
					// check if error message is displayed after clicking on Ok button on dialog box
					try {
						System.out.println("in try for error message dispkayed");
						if (errormessages.isDisplayed()) {

							System.out.println("in if for error message displayed");
							log.info(elementUtil.getText(errormessages));
						} // end of if
					} catch (NoSuchElementException e4) {
						System.out.println("in catch");
						log.info("Test Data Provided Is Not Invalid");
					} // end of catch

				} // end of catch

			}//end of catch

		} // end of for

		// perform logout operation
		elementUtil.handlewin1(driver);
		logOutOperation();

	}// end of addCustomerRecordInvalidData function

	// -----------------Method to perform Logout Operation----------------------------
	public void logOutOperation() throws InterruptedException {
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

	}// end of logOutOperation function

}// end of main class CustomerPage
