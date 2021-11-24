package com.yesbank.qa.stepDefination;

//imports
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.yesbank.qa.factory.DriverFactory;
import com.yesbank.qa.pages.HomePage;
import com.yesbank.qa.pages.LoginPage;
import com.yesbank.qa.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.core.api.Scenario;
import org.apache.log4j.Logger;


public class Hooks {
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	public static Properties prop;
	HomePage homePage;
	LoginPage loginPage;
	Scenario scenario;
	Logger log = Logger.getLogger(Hooks.class);
	
	
	@Before(order=0)
	public void getProperty() {
		configReader=new ConfigReader();
		prop=configReader.init_prop();
	}//end of getProperty function
	
	@Before(order=1)
	public void launchBrowser(Scenario scenario) throws InterruptedException {
		this.scenario=scenario;
		log.info("****LAUNCH BROWSER****");
		log.info("------------------------------------------------------------");
		log.info(""+scenario.getName()+"");
		log.info("------------------------------------------------------------");
		String browserName=prop.getProperty("browser");
		driverFactory=new DriverFactory();
		driver=driverFactory.init_driver(browserName);
		DriverFactory.getDriver().get(prop.getProperty("URL"));
		loginPage = new LoginPage(driver);
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}//end of launchBrowser function
	
	
	public HomePage launchBrowser1() throws InterruptedException {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
		DriverFactory.getDriver().get(prop.getProperty("URL"));
		loginPage = new LoginPage(driver);
		homePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password1"));
		return new HomePage(driver);
	}//end of launchBrowser1 function
	
	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}//end of quitBrowser function
	
	@After(order=1)
	public void tearDown(Scenario scenario) {
		
		if(scenario.isFailed()) {
		String screenshot=scenario.getName().replaceAll(" ", "_");
		byte[]sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		//scenario.attach(sourcepath, "image/png",screenshot);
		}
	}//end of tearDown function
}
