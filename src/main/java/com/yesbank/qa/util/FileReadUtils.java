package com.yesbank.qa.util;

//imports
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FileReadUtils {

	/*
	 * Class Description :
	 * Class namely FileReadUtils is a generic class for all Menus in the
	 * application which is used to read the excel workbook,sheet once get data from
	 * it and forward the data back so that it can be used wherever required
	 */

	private WebDriver driver;
	ElementUtil elementUtils;
	ExcelReader excelReader = new ExcelReader();

	List<Map<String, String>> testData;

	// constructor of FileReadUtils Page
	public FileReadUtils(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}//end of constructor

	// Generic Method to read excel sheet data from BeneficiaryMaintenance.xlsx
	public List<Map<String, String>> readBeneficiaryMaintenanceExcel(String sheetName) throws InvalidFormatException, IOException {
		System.out.println("in read excel function");
		testData = excelReader.getData(System.getProperty("user.dir") + "/src/main/java/com/yesbank/qa/config/BeneficiaryMaintenance.xlsx",
				sheetName);

		return testData;
	}// end of readBeneficiaryMaintenanceExcel function

	// Generic Method to read excel sheet data from DBLoads.xlsx
	public List<Map<String, String>> readDBLoadsExcel(String sheetName) throws InvalidFormatException, IOException {
		System.out.println("in read excel function");
		testData = excelReader.getData(System.getProperty("user.dir") + "/src/main/java/com/yesbank/qa/config/DBLoads.xlsx",
				sheetName);

		return testData;
	}// end of readDBLoadsExcel function

	// Generic Method to read excel sheet data from PurposeCode.xlsx
	public List<Map<String, String>> readPurposeCodeExcel(String sheetName) throws InvalidFormatException, IOException {
		System.out.println("in read excel function");
		testData = excelReader.getData(System.getProperty("user.dir") + "/src/main/java/com/yesbank/qa/config/PurposeCode.xlsx",
				sheetName);

		return testData;
	}// end of readPurposeCodeExcel function

	// Generic Method to read excel sheet data from Customer.xlsx
	public List<Map<String, String>> readCustomerExcel(String sheetName) throws InvalidFormatException, IOException {
		System.out.println("in read excel function");
		testData = excelReader.getData(System.getProperty("user.dir") + "/src/main/java/com/yesbank/qa/config/Customer.xlsx",
				sheetName);

		return testData;
	}// end of readCustomerExcel function

	// Generic Method to read excel sheet data from IFSC_CODE.xlsx
	public List<Map<String, String>> readIFSCCodeExcel(String sheetName) throws InvalidFormatException, IOException {
		System.out.println("in read excel function");
		testData = excelReader.getData(System.getProperty("user.dir") + "/src/main/java/com/yesbank/qa/config/IFSCCode.xlsx",
				sheetName);

		return testData;
	}// end of readIFSCCodeExcel function

}//end of main class FileReadUtils
