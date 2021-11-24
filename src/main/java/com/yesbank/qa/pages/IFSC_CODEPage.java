package com.yesbank.qa.pages;

/*
 * Class Description :
 * Class namely IFSC_CODEPage is a class which involves different methods related to IFSC CODE Menu which helps user in
 * performing operation related to IFSC CODE Module
 */

//imports
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.yesbank.qa.util.ElementUtil;
import com.yesbank.qa.util.FileReadUtils;

/**
 * @Author -- Suvarna Prabhumatkari
 **/

public class IFSC_CODEPage {
	private WebDriver driver;
	List<Map<String, String>> testData;
	FileReadUtils fileReader;
	ElementUtil elementUtil;
	Logger log = Logger.getLogger(IFSC_CODEPage.class);

	// WebElements for IFSC Code screen
	@FindBy(name = "ifscCode")
	WebElement IFSCCodefield;

	@FindBy(name = "micrCode")
	WebElement MICRCodefield;

	@FindBy(name = "iinCode")
	WebElement IINCodefield;

	@FindBy(name = "name")
	WebElement partyNamefield;

	@FindBy(name = "acronym")
	WebElement acronymfield;

	@FindBy(name = "headOffice")
	WebElement headOfficefield;

	@FindBy(xpath = "//input[@value='Reset']")
	WebElement resetBtn;

	@FindBy(xpath = "//input[@value='OK']")
	WebElement okBtn;

	@FindBy(xpath = "//*[@id=\"LNTablelistable\"]/tbody/tr[2]")
	WebElement record;

	@FindBy(id = "btnDelete")
	WebElement deleteBtn;
	
	@FindBy(id = "btnDeleteConf")
	WebElement deleteConfirmBtn;

	@FindBy(xpath = "//input[@name='cancel']")
	WebElement cancelBtn;
	
	@FindBy(xpath = "//*[@id=\"pageBody\"]/form/table/tbody/tr/td/table/tbody/tr[37]/td/input[4]")
	WebElement CANCELBtn;

	@FindBy(name = "addressLine1")
	WebElement addressLine1field;

	@FindBy(name = "addressLine2")
	WebElement addressLine2field;

	@FindBy(name = "addressLine3")
	WebElement addressLine3field;

	@FindBy(name = "branchName")
	WebElement branchfield;

	@FindBy(name = "branchCode")
	WebElement branchCodefield;

	@FindBy(name = "circleCode")
	WebElement circleCodefield;

	@FindBy(name = "circleName")
	WebElement circleNamefield;

	@FindBy(name = "populationCode")
	WebElement populationCodefield;

	@FindBy(name = "moduleName")
	WebElement moduleNamefield;

	@FindBy(name = "city")
	WebElement cityfield;

	@FindBy(name = "bankTypeDirect")
	WebElement bankTypeDirectdropdown;

	@FindBy(name = "contactInfo")
	WebElement contactfield;

	@FindBy(name = "district")
	WebElement districtfield;

	@FindBy(name = "state")
	WebElement statefield;

	@FindBy(name = "achConnect")
	WebElement NACHParticipantdropdown;

	@FindBy(name = "achDebit")
	WebElement ACHDEBITParticipantdropdown;

	@FindBy(name = "achCredit")
	WebElement ACHCREDITParticipantdropdown;

	@FindBy(name = "apbCredit")
	WebElement APBCREDITParticipantdropdown;

	@FindBy(name = "ecsCredit")
	WebElement ECSCREDITParticipantdropdown;

	@FindBy(name = "ebtSingleFF")
	WebElement EBTSingleFileFormatdropdown;

	@FindBy(name = "rtgsParticipant")
	WebElement RTGSParticipantdropdown;

	@FindBy(name = "neftParticipant")
	WebElement NEFTParticipantdropdown;

	@FindBy(name = "lcbgParticipant")
	WebElement LCBGParticipantdropdown;

	@FindBy(name = "retainOnUpdate")
	WebElement retainonUpdatedropdown;

	@FindBy(name = "retainOnDelete")
	WebElement retainonDeletedropdown;

	@FindBy(name = "headOffice")
	WebElement headOfficedropdown;

	@FindBy(name = "isVirtualIfsc")
	WebElement virtualIFSCdropdown;

	@FindBy(name = "isRRBIfsc")
	WebElement RRBIFSCdropdown;

	@FindBy(name = "gstin")
	WebElement GSTINfield;

	@FindBy(xpath = "//p[@class='errormessages']")
	WebElement validationMsg;

	@FindBy(xpath = "//td[@class='HeaderTitle']")
	WebElement confirmScreen;

	@FindBy(id = "btnAddConf")
	WebElement confirmAddBtn;

	@FindBy(xpath = "//*[@id=\"printable\"]/center/p")
	WebElement validateMsg;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/p")
	WebElement screenMsg;

	@FindBy(xpath = "//tr[@class='rowcoloreven']//td[3]")
	WebElement IFSCCodetext;

	@FindBy(xpath = "//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[4]")
	WebElement MICRCodetext;

	@FindBy(xpath = "//tr[@class='rowcoloreven']//td[5]")
	WebElement IINCodetext;

	@FindBy(xpath = "//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[6]")
	WebElement PartyNametext;

	@FindBy(xpath = "//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[7]")
	WebElement Acronymtext;

	// WebElement for IFSC Code list
	@FindBy(xpath = "//*[@id=\"table-reveal\"]/tbody/tr/td/table/tbody/tr[4]/td[2]")
	WebElement verifyMICRCode;

	@FindBy(xpath = "//*[@id=\"table-reveal\"]/tbody/tr/td/table/tbody/tr[3]/td[2]")
	WebElement verifyIFSCCode;

	@FindBy(xpath = "//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[16]")
	WebElement verifyStatus;

	@FindBy(xpath = "//a[normalize-space()='Restart Workflow']")
	WebElement restartWorkflowBtn;
	
	@FindBy(id="btnApprove")
	WebElement approveBtn;

	// WebElements for Logout function
	@FindBy(id = "logoutButtonIcon")
	WebElement logOutBtn;

	@FindBy(xpath = "//button[@type='button'][normalize-space()='OK']")
	WebElement logoutOkBtn;

	// IFSC_CODEPage Class Constructor
	public IFSC_CODEPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.elementUtil = new ElementUtil(driver);
		this.fileReader = new FileReadUtils(driver);
	}//end of constructor

	// ----------View IFSC Code List---------//
	public IFSC_CODEPage viewIFSCCodeList(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		List<Map<String, String>> testData = fileReader.readIFSCCodeExcel(SheetName);
		for (Map<String, String> map : testData) {
			String IFSCCode = map.get("IFSC Code");
			String MICRCode = map.get("MICR Code");
			String IINCode = map.get("IIN Code");
			String PartyName = map.get("Party Name");
			String Acronym = map.get("Acronym");
			String HeadOffice = map.get("Head Office");

			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(IFSCCodefield, IFSCCode);
			elementUtil.enterText(MICRCodefield, MICRCode);
			elementUtil.enterText(IINCodefield, IINCode);
			elementUtil.enterText(partyNamefield, PartyName);
			elementUtil.enterText(acronymfield, Acronym);
			elementUtil.enterText(headOfficefield, HeadOffice);

			elementUtil.clickElement(resetBtn);

			String a = elementUtil.getText(IFSCCodefield);
			String b = elementUtil.getText(MICRCodefield);
			String c = elementUtil.getText(IINCodefield);
			String d = elementUtil.getText(partyNamefield);
			String e = elementUtil.getText(acronymfield);
			String f = elementUtil.getText(headOfficefield);
			if (a.isEmpty() & b.isEmpty() & c.isEmpty() & d.isEmpty() & e.isEmpty() & f.isEmpty()) {
				log.info("Reset button from IFSCCode list screen is working fine");
			} else {
				log.error("Reset button from IFSCCode list screen is not working");
			}
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(IFSCCodefield, IFSCCode);
			elementUtil.enterText(MICRCodefield, MICRCode);
			elementUtil.enterText(IINCodefield, IINCode);
			elementUtil.enterText(partyNamefield, PartyName);
			elementUtil.enterText(acronymfield, Acronym);
			elementUtil.enterText(headOfficefield, HeadOffice);
			elementUtil.clickElement(okBtn);
			elementUtil.SHORT_TIMEOUT();

			String ScreenMsg = "List IFSCCODE";
			String CriteriaMsg = "No Records available for List operation";

			try {
				if (screenMsg.getText().equals(ScreenMsg) || validationMsg.getText().equals(ScreenMsg)) {
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(record);
					elementUtil.TIMEOUT();
					String ActualIFSCCode = verifyIFSCCode.getText();
					String ActualMICRCode = verifyMICRCode.getText();
					if (ActualIFSCCode.trim().toString().equals(IFSCCode)) {
						log.info("IFSC Code " + ActualIFSCCode + " with " + ActualMICRCode + " is displayed");
					} else {
						log.error("Filtered IFSC Code not found in list");
					}
				}
			} catch (NoSuchElementException e1) {
				if (validationMsg.getText().equals(CriteriaMsg)) {
					log.info("IFSC Code " + IFSCCode + " with MICR " + MICRCode
							+ " is not available for View Operation");
				} else {
					log.error("Validation message is not displayed properly");
				}
			}

			elementUtil.clickElement(restartWorkflowBtn);
		}

		elementUtil.handlewin1(driver);
		elementUtil.GoToFrame("app");
		elementUtil.clickElement(logOutBtn);
		elementUtil.GoToparentFrame();
		elementUtil.GoToFrame("content");
		elementUtil.clickElement(logoutOkBtn);
		elementUtil.quitBrowser();

		return new IFSC_CODEPage(driver);
	}

	// -----------------Add IFSC Code-----------------//
	public IFSC_CODEPage addIFSCCodewithInvalidData(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		List<Map<String, String>> testData = fileReader.readIFSCCodeExcel(SheetName);
		for (Map<String, String> map : testData) {
			String IFSCCode = map.get("IFSC Code");
			String MICRCode = map.get("MICR Code");
			String IINCode = map.get("IIN Code");
			String PartyName = map.get("Party Name");
			String Acronym = map.get("Acronym");
			String AddressLine1 = map.get("Address Line 1");
			String AddressLine2 = map.get("Address Line 2");
			String AddressLine3 = map.get("Address Line 3");
			String Branch = map.get("Branch");
			String BranchCode = map.get("Branch Code");
			String CircleCode = map.get("Circle Code");
			String CircleName = map.get("Circle Name");
			String PopulationCode = map.get("Population Code");
			String ModuleName = map.get("Module Name");
			String City = map.get("City");
			String BankTypeDirectorIndirect = map.get("Bank Type Direct/Indirect");
			String Contact = map.get("Contact");
			String District = map.get("District");
			String State = map.get("State");
			String NACHParticipant = map.get("NACH Participant");
			String ACHDEBITParticipant = map.get("ACH DEBIT Participant");
			String ACHCREDITParticipant = map.get("ACH CREDIT Participant");
			String APBCREDITParticipant = map.get("APB CREDIT Participant");
			String ECSCREDITParticipant = map.get("ECS CREDIT Participant");
			String EBTSingleFileFormat = map.get("EBT Single File Format");
			String RTGSParticipant = map.get("RTGS Participant");
			String NEFTParticipant = map.get("NEFT Participant");
			String LCBGParticipant = map.get("LCBG Participant");
			String RetainonUpdate = map.get("Retain on Update");
			String RetainonDelete = map.get("Retain on Delete");
			String HeadOffice = map.get("Head Office");
			String VirtualIFSC = map.get("Virtual IFSC");
			String RRBIFSC = map.get("RRB IFSC");
			String GSTIN = map.get("GSTIN");

			elementUtil.TIMEOUT();
			elementUtil.enterText(IFSCCodefield, IFSCCode);
			elementUtil.enterText(MICRCodefield, MICRCode);
			elementUtil.enterText(IINCodefield, IINCode);
			elementUtil.enterText(partyNamefield, PartyName);
			elementUtil.enterText(acronymfield, Acronym);
			elementUtil.enterText(addressLine1field, AddressLine1);
			elementUtil.enterText(addressLine2field, AddressLine2);
			elementUtil.enterText(addressLine3field, AddressLine3);
			elementUtil.enterText(branchfield, Branch);
			elementUtil.enterText(branchCodefield, BranchCode);
			elementUtil.enterText(circleCodefield, CircleCode);
			elementUtil.enterText(circleNamefield, CircleName);
			elementUtil.enterText(populationCodefield, PopulationCode);
			elementUtil.enterText(moduleNamefield, ModuleName);
			elementUtil.enterText(cityfield, City);
			elementUtil.selectDropDownByVisibleText(bankTypeDirectdropdown, BankTypeDirectorIndirect);
			elementUtil.enterText(contactfield, Contact);
			elementUtil.enterText(districtfield, District);
			elementUtil.enterText(statefield, State);
			elementUtil.clickElement(NACHParticipantdropdown);
			elementUtil.selectDropDownByVisibleText(NACHParticipantdropdown, NACHParticipant);
			elementUtil.clickElement(ACHDEBITParticipantdropdown);
			elementUtil.selectDropDownByVisibleText(ACHDEBITParticipantdropdown, ACHDEBITParticipant);
			elementUtil.selectDropDownByVisibleText(ACHCREDITParticipantdropdown, ACHCREDITParticipant);
			elementUtil.selectDropDownByVisibleText(APBCREDITParticipantdropdown, APBCREDITParticipant);
			elementUtil.selectDropDownByVisibleText(ECSCREDITParticipantdropdown, ECSCREDITParticipant);
			elementUtil.selectDropDownByVisibleText(EBTSingleFileFormatdropdown, EBTSingleFileFormat);
			elementUtil.selectDropDownByVisibleText(RTGSParticipantdropdown, RTGSParticipant);
			elementUtil.selectDropDownByVisibleText(NEFTParticipantdropdown, NEFTParticipant);
			elementUtil.selectDropDownByVisibleText(LCBGParticipantdropdown, LCBGParticipant);
			elementUtil.selectDropDownByVisibleText(retainonUpdatedropdown, RetainonUpdate);
			elementUtil.selectDropDownByVisibleText(retainonDeletedropdown, RetainonDelete);
			elementUtil.selectDropDownByVisibleText(headOfficedropdown, HeadOffice);
			elementUtil.selectDropDownByVisibleText(virtualIFSCdropdown, VirtualIFSC);
			elementUtil.selectDropDownByVisibleText(RRBIFSCdropdown, RRBIFSC);
			elementUtil.enterText(GSTINfield, GSTIN);

			elementUtil.clickElement(okBtn);
			String validateMsg = elementUtil.getText(validationMsg);
			String IFSCCodefieldmsg = "Invalid IFSC Code";
			String MICRCodefieldmsg = "Invalid MICR Code";
			String IINCodefieldmsg = "Invalid IIN Code";
			String PartyNamefieldmsg = "Atleast one code must be present";
			String AddressLine1fieldmsg = "Address Line 1 contains invalid characters";
			String AddressLine1field1msg = "Name: Missing or too Short";
			String AddressLine2fieldmsg = "Address Line 2 contains invalid characters";
			String AddressLine3fieldmsg = "Address Line 3 contains invalid characters";
			String branchfieldmsg = "Atleast one code must be present";
			String branchCodefieldmsg = "Atleast one code must be present";
			String circleCodefieldmsg = "Atleast one code must be present";
			String circleNamefieldmsg = "Atleast one code must be present";
			String populationCodfieldemsg = "Atleast one code must be present";
			String moduleNamefieldmsg = "Atleast one code must be present";
			String cityfieldmsg = "Atleast one code must be present";
			String contactfieldmsg = "Atleast one code must be present";
			String districtfieldmsg = "Atleast one code must be present";
			String statefieldmsg = "Atleast one code must be present";
			String GSTINfieldmsg = "Atleast one code must be present";

			if (validateMsg.contains(IFSCCodefieldmsg)) {
				log.info("Validation is proper for IFSCCode field");
			} else if (validateMsg.contains(MICRCodefieldmsg)) {
				log.info("Validation is proper for MICRCode field");
			} else if (validateMsg.contains(IINCodefieldmsg)) {
				log.info("Validation is proper for IINCode field");
			} 
			/*else if (validateMsg.contains(PartyNamefieldmsg)) {
				//log.info("Validation is proper for PartyName field");
			} */
			else if (validateMsg.contains(AddressLine1fieldmsg)) {
				log.info("Validation is proper for AddressLine1 field");
			} else if (validateMsg.contains(AddressLine1field1msg)) {
				log.info("Validation is proper for AddressLine1 field");
			} else if (validateMsg.equals(AddressLine2fieldmsg)) {
				log.info("Validation is proper for AddressLine2 field");
			} else if (validateMsg.equals(AddressLine3fieldmsg)) {
				log.info("Validation is proper for AddressLine3 field");
				
			} else if (validateMsg.contains(PartyNamefieldmsg) && validateMsg.contains(branchfieldmsg) && validateMsg.contains(branchCodefieldmsg)
					&& validateMsg.contains(circleCodefieldmsg) && validateMsg.contains(circleNamefieldmsg)
					&& validateMsg.contains(populationCodfieldemsg) && validateMsg.contains(moduleNamefieldmsg)
					&& validateMsg.contains(cityfieldmsg) && validateMsg.contains(contactfieldmsg)
					&& validateMsg.contains(districtfieldmsg) && validateMsg.contains(statefieldmsg) && validateMsg.contains(statefieldmsg) && validateMsg.contains(GSTINfieldmsg)) {
				log.info("Validation is proper");
//			} else if (validateMsg.contains(branchCodefieldmsg)) {
//				log.info("Validation is proper for branchCode field");
//			} else if (validateMsg.contains(circleCodefieldmsg)) {
//				log.info("Validation is proper for circleCode field");
//			} else if (validateMsg.contains(circleNamefieldmsg)) {
//				log.info("Validation is proper for circleName field");
//			} else if (validateMsg.contains(populationCodfieldemsg)) {
//				log.info("Validation is proper for populationCode field");
//			} else if (validateMsg.contains(moduleNamefieldmsg)) {
//				log.info("Validation is proper for moduleName field");
//			} else if (validateMsg.contains(cityfieldmsg)) {
//				log.info("Validation is proper for city field");
//			} else if (validateMsg.contains(contactfieldmsg)) {
//				log.info("Validation is proper for contact field");
//			} else if (validateMsg.contains(districtfieldmsg)) {
//				log.info("Validation is proper for district field");
//			} else if (validateMsg.contains(statefieldmsg)) {
//				log.info("Validation is proper for state field");
//			} else if (validateMsg.contains(GSTINfieldmsg)) {
//				log.info("Validation is proper for GSTIN field");
			} else {
				log.error("Validation is failed for checking Invalid data while adding IFSC Code");
			}

			elementUtil.clickElement(restartWorkflowBtn);
		}

		elementUtil.handlewin1(driver);
		elementUtil.GoToFrame("app");
		elementUtil.clickElement(logOutBtn);
		elementUtil.GoToparentFrame();
		elementUtil.GoToFrame("content");
		elementUtil.clickElement(logoutOkBtn);
		elementUtil.quitBrowser();
		return new IFSC_CODEPage(driver);
	}

	public IFSC_CODEPage addIFSCCodewithValidData(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		List<Map<String, String>> testData = fileReader.readIFSCCodeExcel(SheetName);
		for (Map<String, String> map : testData) {
			String IFSCCode = map.get("IFSC Code");
			String MICRCode = map.get("MICR Code");
			String IINCode = map.get("IIN Code");
			String PartyName = map.get("Party Name");
			String Acronym = map.get("Acronym");
			String AddressLine1 = map.get("Address Line 1");
			String AddressLine2 = map.get("Address Line 2");
			String AddressLine3 = map.get("Address Line 3");
			String Branch = map.get("Branch");
			String BranchCode = map.get("Branch Code");
			String CircleCode = map.get("Circle Code");
			String CircleName = map.get("Circle Name");
			String PopulationCode = map.get("Population Code");
			String ModuleName = map.get("Module Name");
			String City = map.get("City");
			String BankTypeDirectorIndirect = map.get("Bank Type Direct/Indirect");
			String Contact = map.get("Contact");
			String District = map.get("District");
			String State = map.get("State");
			String NACHParticipant = map.get("NACH Participant");
			String ACHDEBITParticipant = map.get("ACH DEBIT Participant");
			String ACHCREDITParticipant = map.get("ACH CREDIT Participant");
			String APBCREDITParticipant = map.get("APB CREDIT Participant");
			String ECSCREDITParticipant = map.get("ECS CREDIT Participant");
			String EBTSingleFileFormat = map.get("EBT Single File Format");
			String RTGSParticipant = map.get("RTGS Participant");
			String NEFTParticipant = map.get("NEFT Participant");
			String LCBGParticipant = map.get("LCBG Participant");
			String RetainonUpdate = map.get("Retain on Update");
			String RetainonDelete = map.get("Retain on Delete");
			String HeadOffice = map.get("Head Office");
			String VirtualIFSC = map.get("Virtual IFSC");
			String RRBIFSC = map.get("RRB IFSC");
			String GSTIN = map.get("GSTIN");

			elementUtil.TIMEOUT();
			elementUtil.enterText(IFSCCodefield, IFSCCode);
			elementUtil.enterText(MICRCodefield, MICRCode);
			elementUtil.enterText(IINCodefield, IINCode);
			elementUtil.enterText(partyNamefield, PartyName);
			elementUtil.enterText(acronymfield, Acronym);
			elementUtil.enterText(addressLine1field, AddressLine1);
			elementUtil.enterText(addressLine2field, AddressLine2);
			elementUtil.enterText(addressLine3field, AddressLine3);
			elementUtil.enterText(branchfield, Branch);
			elementUtil.enterText(branchCodefield, BranchCode);
			elementUtil.enterText(circleCodefield, CircleCode);
			elementUtil.enterText(circleNamefield, CircleName);
			elementUtil.enterText(populationCodefield, PopulationCode);
			elementUtil.enterText(moduleNamefield, ModuleName);
			elementUtil.enterText(cityfield, City);
			elementUtil.selectDropDownByVisibleText(bankTypeDirectdropdown, BankTypeDirectorIndirect);
			elementUtil.enterText(contactfield, Contact);
			elementUtil.enterText(districtfield, District);
			elementUtil.enterText(statefield, State);
			elementUtil.clickElement(NACHParticipantdropdown);
			elementUtil.selectDropDownByVisibleText(NACHParticipantdropdown, NACHParticipant);
			elementUtil.clickElement(ACHDEBITParticipantdropdown);
			elementUtil.selectDropDownByVisibleText(ACHDEBITParticipantdropdown, ACHDEBITParticipant);
			elementUtil.selectDropDownByVisibleText(ACHCREDITParticipantdropdown, ACHCREDITParticipant);
			elementUtil.selectDropDownByVisibleText(APBCREDITParticipantdropdown, APBCREDITParticipant);
			elementUtil.selectDropDownByVisibleText(ECSCREDITParticipantdropdown, ECSCREDITParticipant);
			elementUtil.selectDropDownByVisibleText(EBTSingleFileFormatdropdown, EBTSingleFileFormat);
			elementUtil.selectDropDownByVisibleText(RTGSParticipantdropdown, RTGSParticipant);
			elementUtil.selectDropDownByVisibleText(NEFTParticipantdropdown, NEFTParticipant);
			elementUtil.selectDropDownByVisibleText(LCBGParticipantdropdown, LCBGParticipant);
			elementUtil.selectDropDownByVisibleText(retainonUpdatedropdown, RetainonUpdate);
			elementUtil.selectDropDownByVisibleText(retainonDeletedropdown, RetainonDelete);
			elementUtil.selectDropDownByVisibleText(headOfficedropdown, HeadOffice);
			elementUtil.selectDropDownByVisibleText(virtualIFSCdropdown, VirtualIFSC);
			elementUtil.selectDropDownByVisibleText(RRBIFSCdropdown, RRBIFSC);
			elementUtil.enterText(GSTINfield, GSTIN);

			elementUtil.clickElement(okBtn);
			elementUtil.TIMEOUT();

			String ConfirmScreenMsg = "Confirm IFSCCODE Details";
			String validationMsg = "New record added for " + IFSCCode + " Waiting Approve";

			if (elementUtil.getText(confirmScreen).equals(ConfirmScreenMsg)) {
				elementUtil.clickElement(confirmAddBtn);
				elementUtil.SHORT_TIMEOUT();
				try {
					if (elementUtil.getText(validateMsg).equals(validationMsg)) {
						log.info("IFSC Code goes into Approve screen");
					} else {
						log.error("Add IFSC Code functionality is not working fine");
					}
				} catch (Exception e) {
					log.error("Add IFSC Code functionality is not working fine");
				}
			}

			elementUtil.clickElement(restartWorkflowBtn);
		}

		elementUtil.handlewin1(driver);
		elementUtil.GoToFrame("app");
		elementUtil.clickElement(logOutBtn);
		elementUtil.GoToparentFrame();
		elementUtil.GoToFrame("content");
		elementUtil.clickElement(logoutOkBtn);
		elementUtil.quitBrowser();
		return new IFSC_CODEPage(driver);
	}
	
	// ----------Approve IFSC Code List---------//
		public IFSC_CODEPage approveIFSCCode(String SheetName)
				throws InvalidFormatException, IOException, InterruptedException {
			List<Map<String, String>> testData = fileReader.readIFSCCodeExcel(SheetName);
			for (Map<String, String> map : testData) {
				String IFSCCode = map.get("IFSC Code");
				String MICRCode = map.get("MICR Code");
				String IINCode = map.get("IIN Code");
				String PartyName = map.get("Party Name");
				String Acronym = map.get("Acronym");
				String HeadOffice = map.get("Head Office");

				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(IFSCCodefield, IFSCCode);
				elementUtil.enterText(MICRCodefield, MICRCode);
				elementUtil.enterText(IINCodefield, IINCode);
				elementUtil.enterText(partyNamefield, PartyName);
				elementUtil.enterText(acronymfield, Acronym);
				elementUtil.enterText(headOfficefield, HeadOffice);

				elementUtil.clickElement(resetBtn);

				String a = elementUtil.getText(IFSCCodefield);
				String b = elementUtil.getText(MICRCodefield);
				String c = elementUtil.getText(IINCodefield);
				String d = elementUtil.getText(partyNamefield);
				String e = elementUtil.getText(acronymfield);
				String f = elementUtil.getText(headOfficefield);
				if (a.isEmpty() & b.isEmpty() & c.isEmpty() & d.isEmpty() & e.isEmpty() & f.isEmpty()) {
					log.info("Reset button from IFSCCode Approve screen is working fine");
				} else {
					log.error("Reset button from IFSCCode Approve screen is not working");
				}
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(IFSCCodefield, IFSCCode);
				elementUtil.enterText(MICRCodefield, MICRCode);
				elementUtil.enterText(IINCodefield, IINCode);
				elementUtil.enterText(partyNamefield, PartyName);
				elementUtil.enterText(acronymfield, Acronym);
				elementUtil.enterText(headOfficefield, HeadOffice);
				elementUtil.clickElement(okBtn);
				elementUtil.SHORT_TIMEOUT();

				String ScreenMsg = "Approve IFSCCODE";
				String CriteriaMsg = "No Records available for Approve operation";

				try {
					if (screenMsg.getText().equals(ScreenMsg) || validationMsg.getText().equals(ScreenMsg)) {
						elementUtil.SHORT_TIMEOUT();
						elementUtil.clickElement(record);
						elementUtil.TIMEOUT();
						String ActualIFSCCode = verifyIFSCCode.getText();
						String ActualMICRCode = verifyMICRCode.getText();
						if (ActualIFSCCode.trim().toString().equals(IFSCCode)) {
							elementUtil.SHORT_TIMEOUT();
							elementUtil.clickElement(approveBtn);
						} else {
							log.error("Filtered IFSC Code not found in list");
						}
					}
				} catch (NoSuchElementException e1) {
					if (validationMsg.getText().equals(CriteriaMsg)) {
						log.info("IFSC Code " + IFSCCode + " with MICR " + MICRCode
								+ " is not available for Approve Operation");
					} else {
						log.error("Validation message is not displayed properly");
					}
				}

				elementUtil.clickElement(restartWorkflowBtn);
			}

			elementUtil.handlewin1(driver);
			elementUtil.GoToFrame("app");
			elementUtil.clickElement(logOutBtn);
			elementUtil.GoToparentFrame();
			elementUtil.GoToFrame("content");
			elementUtil.clickElement(logoutOkBtn);
			elementUtil.quitBrowser();

			return new IFSC_CODEPage(driver);
		}
	
	// --------------Delete IFSC Code------------------//
	public IFSC_CODEPage deleteIFSCCode(String SheetName)
			throws InvalidFormatException, IOException, InterruptedException {
		List<Map<String, String>> testData = fileReader.readIFSCCodeExcel(SheetName);
		for (Map<String, String> map : testData) {
			String IFSCCode = map.get("IFSC Code");
			String MICRCode = map.get("MICR Code");
			String IINCode = map.get("IIN Code");
			String PartyName = map.get("Party Name");
			String Acronym = map.get("Acronym");
			String HeadOffice = map.get("Head Office");

			elementUtil.TIMEOUT();
			elementUtil.enterText(IFSCCodefield, IFSCCode);
			elementUtil.enterText(MICRCodefield, MICRCode);
			elementUtil.enterText(IINCodefield, IINCode);
			elementUtil.enterText(partyNamefield, PartyName);
			elementUtil.enterText(acronymfield, Acronym);
			elementUtil.enterText(headOfficefield, HeadOffice);

			elementUtil.clickElement(resetBtn);
			String a = elementUtil.getText(IFSCCodefield);
			String b = elementUtil.getText(MICRCodefield);
			String c = elementUtil.getText(IINCodefield);
			String d = elementUtil.getText(partyNamefield);
			String e = elementUtil.getText(acronymfield);
			String f = elementUtil.getText(headOfficefield);

			if (a.isEmpty() & b.isEmpty() & c.isEmpty() & d.isEmpty() & e.isEmpty() & f.isEmpty()) {
				log.info("Reset button from IFSCCode Delete screen is working fine");
			} else {
				log.error("Reset button from IFSCCode Delete screen is not working");
			}
			elementUtil.SHORT_TIMEOUT();
			elementUtil.enterText(IFSCCodefield, IFSCCode);
			elementUtil.enterText(MICRCodefield, MICRCode);
			elementUtil.enterText(IINCodefield, IINCode);
			elementUtil.enterText(partyNamefield, PartyName);
			elementUtil.enterText(acronymfield, Acronym);
			elementUtil.enterText(headOfficefield, HeadOffice);
			elementUtil.clickElement(okBtn);
			elementUtil.SHORT_TIMEOUT();

			String ScreenMsg = "Delete IFSCCODE";
			String CriteriaMsg = "No Records available for Delete operation";
			String CancelMsg = "Operation Cancelled";

			try {
				if (screenMsg.getText().equals(ScreenMsg) || validationMsg.getText().equals(ScreenMsg)) {
					elementUtil.SHORT_TIMEOUT();

					elementUtil.clickElement(cancelBtn);
					elementUtil.SHORT_TIMEOUT();
					if (validationMsg.getText().equals(CancelMsg)) {
						log.info("Validation message on Delete IFSC Code screen is proper for Cancel Button");
					} else {
						log.error("Validation failed on Delete IFSC Code screen for Cancel Button");
					}

					elementUtil.clickElement(restartWorkflowBtn);
					elementUtil.enterText(IFSCCodefield, IFSCCode);
					elementUtil.enterText(MICRCodefield, MICRCode);
					elementUtil.enterText(IINCodefield, IINCode);
					elementUtil.enterText(partyNamefield, PartyName);
					elementUtil.enterText(acronymfield, Acronym);
					elementUtil.enterText(headOfficefield, HeadOffice);
					elementUtil.clickElement(okBtn);
					elementUtil.SHORT_TIMEOUT();

					elementUtil.clickElement(okBtn);
					
					elementUtil.clickElement(cancelBtn);
					elementUtil.SHORT_TIMEOUT();
					if (validationMsg.getText().equals(CancelMsg)) {
						log.info("Validation message on Delete IFSC Code Confirm Screen is proper for Cancel Button");
					} else {
						log.error("Validation failed on Delete IFSC Code Confirm Screen for Cancel Button");
					}
					
					elementUtil.clickElement(restartWorkflowBtn);
					elementUtil.enterText(IFSCCodefield, IFSCCode);
					elementUtil.enterText(MICRCodefield, MICRCode);
					elementUtil.enterText(IINCodefield, IINCode);
					elementUtil.enterText(partyNamefield, PartyName);
					elementUtil.enterText(acronymfield, Acronym);
					elementUtil.enterText(headOfficefield, HeadOffice);
					elementUtil.clickElement(okBtn);
					elementUtil.SHORT_TIMEOUT();

					elementUtil.clickElement(okBtn);
					
					elementUtil.clickElement(deleteBtn);

					String DeleteValidateMsg = "Record Marked for deletion for " + IFSCCode + " Waiting Confirm";
					if (validateMsg.getText().equals(DeleteValidateMsg)) {
						log.info("IFSC Code " + IFSCCode + " goes in Confirm Delete screen");
					} else {
						log.error("Validation is failed for Delete IFSC Code");
					}
				}
			} catch (NoSuchElementException e2) {
				if (validationMsg.getText().equals(CriteriaMsg)) {
					log.info("IFSC Code " + IFSCCode + " with MICR " + MICRCode
							+ " is not available for Delete Operation");
				} else {
					log.error("Validation message is not displayed properly");
				}
			}

			elementUtil.clickElement(restartWorkflowBtn);

		}

		elementUtil.handlewin1(driver);
		elementUtil.GoToFrame("app");
		elementUtil.clickElement(logOutBtn);
		elementUtil.GoToparentFrame();
		elementUtil.GoToFrame("content");
		elementUtil.clickElement(logoutOkBtn);
		elementUtil.quitBrowser();
		return new IFSC_CODEPage(driver);
	}
	
	// --------------Confirm Delete IFSC Code------------------//
		public IFSC_CODEPage confirmDeleteIFSCCode(String SheetName)
				throws InvalidFormatException, IOException, InterruptedException {
			List<Map<String, String>> testData = fileReader.readIFSCCodeExcel(SheetName);
			for (Map<String, String> map : testData) {
				String IFSCCode = map.get("IFSC Code");
				String MICRCode = map.get("MICR Code");
				String IINCode = map.get("IIN Code");
				String PartyName = map.get("Party Name");
				String Acronym = map.get("Acronym");
				String HeadOffice = map.get("Head Office");

				elementUtil.TIMEOUT();
				elementUtil.enterText(IFSCCodefield, IFSCCode);
				elementUtil.enterText(MICRCodefield, MICRCode);
				elementUtil.enterText(IINCodefield, IINCode);
				elementUtil.enterText(partyNamefield, PartyName);
				elementUtil.enterText(acronymfield, Acronym);
				elementUtil.enterText(headOfficefield, HeadOffice);

				elementUtil.clickElement(resetBtn);
				String a = elementUtil.getText(IFSCCodefield);
				String b = elementUtil.getText(MICRCodefield);
				String c = elementUtil.getText(IINCodefield);
				String d = elementUtil.getText(partyNamefield);
				String e = elementUtil.getText(acronymfield);
				String f = elementUtil.getText(headOfficefield);

				if (a.isEmpty() & b.isEmpty() & c.isEmpty() & d.isEmpty() & e.isEmpty() & f.isEmpty()) {
					log.info("Reset button from IFSCCode Confirm Delete screen is working fine");
				} else {
					log.error("Reset button from IFSCCode Confirm Delete screen is not working");
				}
				elementUtil.SHORT_TIMEOUT();
				elementUtil.enterText(IFSCCodefield, IFSCCode);
				elementUtil.enterText(MICRCodefield, MICRCode);
				elementUtil.enterText(IINCodefield, IINCode);
				elementUtil.enterText(partyNamefield, PartyName);
				elementUtil.enterText(acronymfield, Acronym);
				elementUtil.enterText(headOfficefield, HeadOffice);
				elementUtil.clickElement(okBtn);
				elementUtil.SHORT_TIMEOUT();

				String ScreenMsg = "IFSCCODE Delete Confirm";
				String CriteriaMsg = "No Records available for Confirm Delete operation";
				String CancelMsg = "Operation Cancelled";

				try {
					if (screenMsg.getText().equals(ScreenMsg) || validationMsg.getText().equals(ScreenMsg)) {
						elementUtil.SHORT_TIMEOUT();

						elementUtil.clickElement(cancelBtn);
						elementUtil.SHORT_TIMEOUT();
						if (validationMsg.getText().equals(CancelMsg)) {
							log.info("Validation message on Confirm Delete IFSC Code screen is proper for Cancel Button");
						} else {
							log.error("Validation failed on Confirm Delete IFSC Code screen for Cancel Button");
						}

						elementUtil.clickElement(restartWorkflowBtn);
						elementUtil.enterText(IFSCCodefield, IFSCCode);
						elementUtil.enterText(MICRCodefield, MICRCode);
						elementUtil.enterText(IINCodefield, IINCode);
						elementUtil.enterText(partyNamefield, PartyName);
						elementUtil.enterText(acronymfield, Acronym);
						elementUtil.enterText(headOfficefield, HeadOffice);
						elementUtil.clickElement(okBtn);
						elementUtil.SHORT_TIMEOUT();

						elementUtil.clickElement(okBtn);
						
						elementUtil.clickElement(cancelBtn);
						elementUtil.SHORT_TIMEOUT();
						if (validationMsg.getText().equals(CancelMsg)) {
							log.info("Validation message on Confirm Delete IFSC Code Confirm Screen is proper for Cancel Button");
						} else {
							log.error("Validation failed on Confirm Delete IFSC Code Confirm Screen for Cancel Button");
						}
						
						elementUtil.clickElement(restartWorkflowBtn);
						elementUtil.enterText(IFSCCodefield, IFSCCode);
						elementUtil.enterText(MICRCodefield, MICRCode);
						elementUtil.enterText(IINCodefield, IINCode);
						elementUtil.enterText(partyNamefield, PartyName);
						elementUtil.enterText(acronymfield, Acronym);
						elementUtil.enterText(headOfficefield, HeadOffice);
						elementUtil.clickElement(okBtn);
						elementUtil.SHORT_TIMEOUT();

						elementUtil.clickElement(okBtn);
						
						elementUtil.clickElement(deleteConfirmBtn);

						String DeleteValidateMsg = "Record Marked for deletion for " + IFSCCode + " Waiting Confirm";
						if (validateMsg.getText().equals(DeleteValidateMsg)) {
							log.info("IFSC Code " + IFSCCode + " deleted successfully");
						} else {
							log.error("IFSC Code " + IFSCCode + " is failed to Delete IFSC Code");
						}
					}
				} catch (NoSuchElementException e2) {
					if (validationMsg.getText().equals(CriteriaMsg)) {
						log.info("IFSC Code " + IFSCCode + " with MICR " + MICRCode
								+ " is not available for Delete Operation");
					} else {
						log.error("IFSC Code " + IFSCCode + " is failed to Delete IFSC Code");
					}
				}

				elementUtil.clickElement(restartWorkflowBtn);

			}

			elementUtil.handlewin1(driver);
			elementUtil.GoToFrame("app");
			elementUtil.clickElement(logOutBtn);
			elementUtil.GoToparentFrame();
			elementUtil.GoToFrame("content");
			elementUtil.clickElement(logoutOkBtn);
			elementUtil.quitBrowser();
			return new IFSC_CODEPage(driver);
		}
	
}//end of main class IFSC_CODEPage
