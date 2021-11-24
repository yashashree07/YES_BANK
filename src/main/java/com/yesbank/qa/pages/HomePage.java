package com.yesbank.qa.pages;

/*
 * Class Description :
 * Class namely HomePage is a class involving different methods which are used to navigate to different menus
 * in YES BANK TPH Application
 */

//imports
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.yesbank.qa.util.ElementUtil;

public class HomePage {
	private WebDriver driver;
	ElementUtil elementUtil;

	//WebElements For Application Menu
	@FindBy(xpath = "//a[contains(text(),'Application')]")
	WebElement applicationMenu;

	//WebElements for IFSC Code
	@FindBy(xpath = "//a[normalize-space()='IFSCCODE']")
	WebElement ifscCodeMenu;

	@FindBy(xpath = "//a[@title='Add IFSCCODE']")
	WebElement ifscCodeAddMenu;

	@FindBy(xpath = "//a[@title='List IFSCCODE']")
	WebElement ifscCodeListMenu;

	@FindBy(xpath = "//a[@title='Approve IFSCCODE']")
	WebElement ifscCodeApproveMenu;

	@FindBy(xpath = "//a[@title='Modify IFSCCODE']")
	WebElement ifscCodeModifyMenu;

	@FindBy(xpath = "//a[@title='Delete IFSCCODE']")
	WebElement ifscCodeDeleteMenu;

	@FindBy(xpath = "//a[@title='IFSCCODE Delete Confirm']")
	WebElement ifscCodeConfirmDeleteMenu;

	//WebElement For Master Data Maintenance Menu
	@FindBy(xpath = "//a[normalize-space()='Master Data Maintenance']")
	WebElement masterDataMaintenanceMenu;

	//WebElements For Beneficiary Maintenance Menu
	@FindBy(xpath = "//a[contains(text(),'Beneficiary Maintenance ')]")
	WebElement beneficiaryMaintenanceMenu;

	@FindBy(xpath = "//*[@id=\"1l3l4l15l1\"]/a")
	WebElement beneficiaryMaintenanceListMenu;

	@FindBy(xpath = "//*[@id=\"1l3l4l15l2\"]/a")
	WebElement beneficiaryMaintenanceEnterMenu;

	@FindBy(xpath = "//*[@id=\"1l3l4l15l3\"]/a")
	WebElement beneficiaryMaintenanceModifyMenu;

	@FindBy(xpath = "//*[@id=\"1l3l4l15l4\"]/a")
	WebElement beneficiaryMaintenanceApproveMenu;

	@FindBy(xpath = "//*[@id=\"1l3l4l15l5\"]/a")
	WebElement beneficiaryMaintenanceDeleteMenu;

	//WebElements For Purpose Code Menu
	@FindBy(xpath="//a[normalize-space()='Purpose Code']")
	WebElement purposeCodeMenu;

	@FindBy(xpath = "//*[@id=\"1l3l4l11l1\"]/a")//*[@id="1l3l4l11l1"]/a
	WebElement purposeCodeListMenu;

	@FindBy(xpath = "//*[@id=\"1l3l4l11l2\"]/a")
	WebElement purposeCodeEnterMenu;

	@FindBy(xpath = "//*[@id=\"1l3l4l11l3\"]/a")
	WebElement purposeCodeModifyMenu;

	@FindBy(xpath = "//*[@id=\"1l3l4l11l4\"]/a")
	WebElement purposeCodeApproveMenu;

	@FindBy(xpath = "//*[@id=\"1l3l4l11l5\"]/i")
	WebElement purposeCodeDeleteMenu;

	//Customer Menu WebElements
	@FindBy(xpath = "//a[normalize-space()='CUSTOMER']")
	WebElement customerMenu;

	@FindBy(xpath = "//a[@title='Add CUSTOMER']")
	WebElement customerAddMenu;

	@FindBy(xpath = "//a[@title='Approve CUSTOMER']")
	WebElement customerApproveMenu;

	@FindBy(xpath = "//a[@title='List CUSTOMER']")
	WebElement customerListMenu;

	@FindBy(xpath="//a[@title='Modify CUSTOMER']")
	WebElement customerModifyMenu;

	@FindBy(xpath="//a[@title='Delete CUSTOMER']")
	WebElement customerDeleteMenu;

	@FindBy(xpath="//a[@title='Confirm Delete CUSTOMER']")
	WebElement customerConfirmDeleteMenu;


	//Home Page WebElements
	@FindBy(xpath="//span[@class='glyphicon glyphicon-log-out']")
	WebElement mainPageLogOutButton;

	@FindBy(id="content")
	WebElement mainFrame;

	@FindBy(xpath="//button[@type='button'][normalize-space()='OK']")
	WebElement mainPageLogoutOkBtn;

	//DBLoads Menu WebElements
	@FindBy(xpath="//*[@id=\"1l3l4l1\"]/a")
	WebElement dbLoadsMenu;

	// HomePage Class Constructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.elementUtil = new ElementUtil(driver);
	}//end

	//-------------------Beneficiary Maintenance Menu Methods-------------------------------

	//Method to navigate to Beneficiary Maintenance->Add
	public BeneficiaryMaintenancePage beneMaintainEnterMenu() throws InterruptedException {
		elementUtil.clickElement(applicationMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(masterDataMaintenanceMenu);
		elementUtil.javascriptExecutorClickElement(beneficiaryMaintenanceMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(beneficiaryMaintenanceMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(beneficiaryMaintenanceEnterMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.handlewin(driver);
		return new BeneficiaryMaintenancePage(driver);
	}//end of beneMaintainEnterMenu function

	//Method to navigate to Beneficiary Maintenance->Approve
	public BeneficiaryMaintenancePage beneMaintainApproveMenu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.clickElement(applicationMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(masterDataMaintenanceMenu);
		elementUtil.javascriptExecutorClickElement(beneficiaryMaintenanceMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(beneficiaryMaintenanceMenu);
		elementUtil.javascriptExecutorClickElement(beneficiaryMaintenanceApproveMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(beneficiaryMaintenanceApproveMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.handlewin(driver);
		return new BeneficiaryMaintenancePage(driver);
	}//end of beneMaintainApproveMenu function

	//Method to navigate to Beneficiary Maintenance->List
	public BeneficiaryMaintenancePage beneMaintainListMenu() throws InterruptedException {
		elementUtil.clickElement(applicationMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(masterDataMaintenanceMenu);
		elementUtil.javascriptExecutorClickElement(beneficiaryMaintenanceMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(beneficiaryMaintenanceMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(beneficiaryMaintenanceListMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.handlewin(driver);
		return new BeneficiaryMaintenancePage(driver);
	}//end of beneMaintainListMenu function

	//Method to navigate to Beneficiary Maintenance->Modify
	public BeneficiaryMaintenancePage beneMaintainModifyMenu() throws InterruptedException {
		elementUtil.clickElement(applicationMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(masterDataMaintenanceMenu);
		elementUtil.javascriptExecutorClickElement(beneficiaryMaintenanceMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(beneficiaryMaintenanceMenu);
		elementUtil.javascriptExecutorClickElement(beneficiaryMaintenanceModifyMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(beneficiaryMaintenanceModifyMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.handlewin(driver);
		return new BeneficiaryMaintenancePage(driver);
	}//end of beneMaintainModifyMenu function

	//Method to navigate to Beneficiary Maintenance->Delete
	public BeneficiaryMaintenancePage beneMaintainDeleteMenu() throws InterruptedException {
		elementUtil.clickElement(applicationMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(masterDataMaintenanceMenu);
		elementUtil.javascriptExecutorClickElement(beneficiaryMaintenanceMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(beneficiaryMaintenanceMenu);
		elementUtil.javascriptExecutorClickElement(beneficiaryMaintenanceDeleteMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(beneficiaryMaintenanceDeleteMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.handlewin(driver);
		return new BeneficiaryMaintenancePage(driver);
	}//end of beneMaintainDeleteMenu function

	//-----------------------------Methods For DBLoads Menu-------------------------------

	//Method to navigate to DBLoads Menu
	public DBLoadsPage dbloadsMenu() throws InterruptedException {
		elementUtil.clickElement(applicationMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(masterDataMaintenanceMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(dbLoadsMenu);
		elementUtil.handlewin(driver);
		return new DBLoadsPage(driver);
	}//end of dbloadsMenu function

	//----------------------------Methods For Purpose Code Menu-----------------------------
	//Method to navigate to Purpose Code->Enter
	public PurposeCodePage purposeCodeEnterMenu() throws InterruptedException {
		elementUtil.clickElement(applicationMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(masterDataMaintenanceMenu);
		elementUtil.javascriptExecutorClickElement(purposeCodeMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(purposeCodeMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(purposeCodeEnterMenu);
		elementUtil.handlewin(driver);
		return new PurposeCodePage(driver);
	}//end of purposeCodeEnterMenu function

	//Method to navigate to Purpose Code->Approve
	public PurposeCodePage purposeCodeApproveMenu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.clickElement(applicationMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(masterDataMaintenanceMenu);
		elementUtil.javascriptExecutorClickElement(purposeCodeMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(purposeCodeMenu);
		elementUtil.javascriptExecutorClickElement(purposeCodeApproveMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(purposeCodeApproveMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.handlewin(driver);
		return new PurposeCodePage(driver);
	}//end of purposeCodeApproveMenu function

	//Method to navigate to Purpose Code->List
	public PurposeCodePage purposeCodeListMenu() throws InterruptedException {
		elementUtil.clickElement(applicationMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(masterDataMaintenanceMenu);
		elementUtil.javascriptExecutorClickElement(purposeCodeMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(purposeCodeMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(purposeCodeListMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.handlewin(driver);
		return new PurposeCodePage(driver);
	}//end of purposeCodeListMenu function

	//Method to navigate to Purpose Code->Modify
	public PurposeCodePage purposeCodeModifyMenu() throws InterruptedException {
		elementUtil.clickElement(applicationMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(masterDataMaintenanceMenu);
		elementUtil.javascriptExecutorClickElement(purposeCodeMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(purposeCodeMenu);
		elementUtil.javascriptExecutorClickElement(purposeCodeModifyMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(purposeCodeModifyMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.handlewin(driver);
		return new PurposeCodePage(driver);
	}//end of purposeCodeModifyMenu function

	//Method to navigate to Purpose Code->Delete
	public PurposeCodePage purposeCodeDeleteMenu() throws InterruptedException {
		elementUtil.clickElement(applicationMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(masterDataMaintenanceMenu);
		elementUtil.javascriptExecutorClickElement(purposeCodeMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(purposeCodeMenu);
		elementUtil.javascriptExecutorClickElement(purposeCodeDeleteMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(purposeCodeDeleteMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.handlewin(driver);
		return new PurposeCodePage(driver);
	}//end of purposeCodeDeleteMenu function

	//-------------------------Customer Menu Methods---------------------------------------
	//Method to navigate to Customer->Enter
	public CustomerPage customerAddMenu() throws InterruptedException {
		elementUtil.clickElement(applicationMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(masterDataMaintenanceMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(customerMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(customerAddMenu);
		elementUtil.handlewin(driver);
		return new CustomerPage(driver);
	}//end of customerAddMenu function

	//Method to navigate to Customer->Approve
	public CustomerPage customerApproveMenu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.clickElement(applicationMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(masterDataMaintenanceMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(customerMenu);
		elementUtil.javascriptExecutorClickElement(customerApproveMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(customerApproveMenu);
		elementUtil.handlewin(driver);
		return new CustomerPage(driver);
	}//end of customerApproveMenu function

	//Method to navigate to Customer->List
	public CustomerPage customerListMenu() throws InterruptedException {
		elementUtil.clickElement(applicationMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(masterDataMaintenanceMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(customerMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(customerListMenu);
		elementUtil.handlewin(driver);
		return new CustomerPage(driver);
	}//end of customerListMenu function

	//Method to navigate to Customer->Modify
	public CustomerPage customerModifyMenu() throws InterruptedException {
		elementUtil.clickElement(applicationMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(masterDataMaintenanceMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(customerMenu);
		elementUtil.javascriptExecutorClickElement(customerModifyMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(customerModifyMenu);
		elementUtil.handlewin(driver);
		return new CustomerPage(driver);
	}//end of customerModifyMenu function

	//Method to navigate to Customer->Delete
	public CustomerPage customerDeleteMenu() throws InterruptedException {
		elementUtil.clickElement(applicationMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(masterDataMaintenanceMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(customerMenu);
		elementUtil.javascriptExecutorClickElement(customerDeleteMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(customerDeleteMenu);
		elementUtil.handlewin(driver);
		return new CustomerPage(driver);
	}//end of customerDeleteMenu function

	//Method to navigate to Customer->Confirm Delete
	public CustomerPage customerConfirmDeleteMenu() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.clickElement(applicationMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(masterDataMaintenanceMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(customerMenu);
		elementUtil.javascriptExecutorClickElement(customerConfirmDeleteMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(customerConfirmDeleteMenu);
		elementUtil.handlewin(driver);
		return new CustomerPage(driver);
	}//end of customerConfirmDeleteMenu function
	
	//-------------------------IFSC Code Menu Methods---------------------------------------

	//Method to reach to IFSC Code->Add Link
	public IFSC_CODEPage clickonIFSCCODEAddLink() throws InterruptedException {
		elementUtil.clickElement(applicationMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(masterDataMaintenanceMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(ifscCodeMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(ifscCodeAddMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.handlewin(driver);
		return new IFSC_CODEPage(driver);
	}//end of clickonIFSCCODEAddLink function

	//Method to reach to IFSC Code->Approve Link
	public IFSC_CODEPage clickonIFSCCODEApproveLink() throws InterruptedException {
		elementUtil.clickElement(applicationMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(masterDataMaintenanceMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(ifscCodeMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(ifscCodeApproveMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.handlewin(driver);
		return new IFSC_CODEPage(driver);
	}//end of clickonIFSCCODEApproveLink function

	//Method to reach to IFSC Code->Modify Link
	public IFSC_CODEPage clickonIFSCCODEModifyLink() throws InterruptedException {
		elementUtil.clickElement(applicationMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(masterDataMaintenanceMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(ifscCodeMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(ifscCodeModifyMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.handlewin(driver);
		return new IFSC_CODEPage(driver);
	}//end of clickonIFSCCODEModifyLink function

	//-Method to reach to IFSC Code->Delete Link
	public IFSC_CODEPage clickonIFSCCODEDeleteLink() throws InterruptedException {
		elementUtil.clickElement(applicationMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(masterDataMaintenanceMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(ifscCodeMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(ifscCodeDeleteMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.handlewin(driver);
		return new IFSC_CODEPage(driver);
	}//end of clickonIFSCCODEDeleteLink function

	//Method to reach to IFSC Code->Confirm Delete Link
	public IFSC_CODEPage clickonIFSCCODEConfirmDeleteLink() throws InterruptedException {
		elementUtil.GoToFrame("toc");
		elementUtil.clickElement(applicationMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(masterDataMaintenanceMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(ifscCodeMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(ifscCodeConfirmDeleteMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.handlewin(driver);
		return new IFSC_CODEPage(driver);
	}//end of clickonIFSCCODEConfirmDeleteLink function
	
	//Method to reach to IFSC Code->List Link
	public IFSC_CODEPage clickonIFSCCODEListLink() throws InterruptedException {
		elementUtil.clickElement(applicationMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(masterDataMaintenanceMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(ifscCodeMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(ifscCodeListMenu);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.handlewin(driver);
		return new IFSC_CODEPage(driver);
	}//end of clickonIFSCCODEListLink function



	//-------------------------Method For Logout Operation----------------------------------
	//Method to perform logout operation
	public void LogOut() throws InterruptedException {
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
	}//end of LogOut function



}//end of main class HomePage
