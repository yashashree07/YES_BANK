package com.yesbank.qa.main;

//imports
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;

import com.yesbank.qa.util.ExtentReportGenerator;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {"src/main/resources/Features/TC04-PurposeCode.feature"},
		monochrome=true,
		dryRun=false,
		glue= {"com.yesbank.qa.stepDefination"},
		tags="@TC04_07_PurposeCode_List",
		plugin = {"pretty", "html:target/cucumber-html-report","json:target/cucumber-reports/Cucumber.json","junit:target/cucumber-reports/Cucumber.xml",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
		)

public class TestRunner {

		public static void main(String[] args) {
		    System.out.println("in main method");
		    PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/main/resources/log4j.properties");
		    BasicConfigurator.configure();
		    CreateCucumberOptions cucumberOptions = new CreateCucumberOptions();
		    ExtentReportGenerator reportGenerator=new ExtentReportGenerator();
		    JUnitCore junitRunner = new JUnitCore();
			cucumberOptions.loadPropertiesFile();
			cucumberOptions.setOptions();
		    System.out.println(TestRunner.class.getName()); 
		 
		    junitRunner.run(TestRunner.class);
		    reportGenerator.generateReport();
		    System.out.println("end");
		    System.exit(0);
		  }//end of main
	
}
