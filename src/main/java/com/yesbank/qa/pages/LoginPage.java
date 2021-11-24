package com.yesbank.qa.pages;

/*
 * Class Description :
 * Class namely Login Page is a class involving methods related to Login functionality 
 */

//imports
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.yesbank.qa.util.ElementUtil;

public class LoginPage {
	private WebDriver driver;
	ElementUtil elementUtil=new ElementUtil(driver);

	//WebElements for Login Page 
	@FindBy(name="j_user")
	WebElement username;

	@FindBy(name="j_pass")
	WebElement password;

	@FindBy(id="login")
	WebElement loginBtn;

	@FindBy(name="j_user")
	WebElement username1;

	@FindBy(name="j_pass")
	WebElement password1;

	@FindBy(id="auth-error")
	WebElement errormessages;
	
	@FindBy(xpath="//a[contains(.,'Accept')]")
	WebElement acceptLink;
	
	@FindBy(id = "details-button")
	WebElement advancedBtn;

	@FindBy(id = "proceed-link")
	WebElement proceedlink;

	Logger log = Logger.getLogger(LoginPage.class);

	//LoginPage Constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}//end 

	//Method to perform Login operation
	public HomePage login(String un,String pwd) throws InterruptedException {
		elementUtil.clickElement(advancedBtn);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.clickElement(proceedlink);
		elementUtil.SHORT_TIMEOUT();
		elementUtil.enterText(username, un);
		log.info("Username entered");
		elementUtil.enterText(password, pwd);
		log.info("Password entered");
		elementUtil.clickElement(loginBtn);
		
		//String expectedLoginPage_ErrMessage="Operation Login failed to execute: Operator already logged on. ";
		
		//check if Login operation is successful or login operation failed
		try {
			
			log.info(elementUtil.getText(errormessages));
		}
		catch (NoSuchElementException e) {
			log.info("Login Successful");
		}//end of catch

		return new HomePage(driver);
	}//end of login function

	
}//end of main class LoginPage
