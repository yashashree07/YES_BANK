package com.yesbank.qa.util;

//imports
import java.io.File;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Class Description:
 * Class namely ExtentReportGenerator is a class used to generate jvm reports 
 */

public class ExtentReportGenerator {
	
	public void generateReport()
	{
		System.out.println("in generate report");

		File reportOutputDirectory = new File("output");
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add(System.getProperty("user.dir") + "\\target\\cucumber-reports\\cucumber.json");
		

		String buildNumber = "1";
		String projectName = "cucumberProject";

		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		// optional configuration - check javadoc for details
		configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
		// do not make scenario failed when step has status SKIPPED
		configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
		configuration.setBuildNumber(buildNumber);
		// addidtional metadata presented on main page
		configuration.addClassifications("Platform", "Windows");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Branch", "release/1.0");

		// optionally specify qualifiers for each of the report json files
		configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
		configuration.setQualifier("cucumber","First report");
	

		ReportBuilder reportBuilder=new ReportBuilder(jsonFiles,configuration);
		Reportable result=reportBuilder.generateReports();

	}//end 


}//end of main class ExtentReportGenerator
