package com.yesbank.qa.util;

//imports
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.yesbank.qa.factory.DriverFactory;

/**
 * @Author -- Pranjal Mudhalwadkar
 **/
public class ElementUtil {
	private DriverFactory driverFactory;
	private WebDriver driver;

	//ElementUtil Page Class Constructor
	public ElementUtil(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = DriverFactory.getDriver();
	}//end 

	// Method to perform Click action on element
	public void clickElement(WebElement element) {
		element.click();
	}//end 

	// Method to enter text into input text field
	public void enterText(WebElement element, String Text) {
		element.sendKeys(Text);
	}//end 

	// Switching the Frame
	public void GoToFrame(String FrameIDName) {
		driver.switchTo().frame(FrameIDName);
	}//end

	// Method to Clear TextField
	public void clearText(WebElement element) {
		element.clear();
	}//end 

	// Method for Checking element is present
	public void isElementPresent(WebElement element) {
		element.isDisplayed();
	}//end

	//Method to switch to Parent Frame
	public void GoToparentFrame() {
		driver.switchTo().parentFrame();
	}//end

	//Method for Checking element is enabled
	public void isElementEnabled(WebElement element) {

		element.isEnabled();
	}//end

	// MouseHover
	public void moveToElement(WebElement element) {

		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

	}//end

	// Context Click or Right Click on element
	public void rightClickOnElement(WebElement element) {

		Actions action = new Actions(driver);
		action.contextClick().build().perform();
	}//end

	// Selecting dropdown values by visible Text
	public void selectDropDownByVisibleText(WebElement element, String visibleText) throws InterruptedException {
		SHORT_TIMEOUT();
		element.click();
		SHORT_TIMEOUT();
		Select sel = new Select(element);
		SHORT_TIMEOUT();
		sel.selectByVisibleText(visibleText);
	}//end

	// Selecting dropdown values by Value Text-Method specific to one of the field
	//in Customer screen
	public void selectElementValue_FromList(WebElement element, String values[]) throws InterruptedException {
		for(int i=0;i<values.length;i++)
		{
			System.out.println("values " + values[i]);
			Select sel = new Select(element);
			SHORT_TIMEOUT();
			sel.selectByValue(values[i]);

		}//end of for

	}//end

	// Selecting dropdown values by Value Text-Method specific to one of the field
	//in Customer screen
	public void deselectingElementValue_FromList(WebElement element, String values[]) throws InterruptedException {
		for(int i=0;i<values.length;i++)
		{
			System.out.println("values " + values[i]);
			Select select = new Select(element);
			SHORT_TIMEOUT();
			select.deselectByValue(values[i]);

		}//end of for

	}//end

	// Selecting dropdown values by value
	public void selectDropDownByValue(WebElement element, String dropDownValue) {
		element.click();
		Select sel = new Select(element);
		sel.selectByValue(dropDownValue);
	}//end

	// Selecting dropDown values by Index
	public void selectDropDownByIndex(WebElement element, int index) {
		element.click();
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}//end

	// Selecting values from List box
	public void selectElementFromListBox(WebElement element,String visibletext) throws InterruptedException {
		Select s=new Select(element);
		List<WebElement> allvals=s.getOptions();

		for(int i=0;i<allvals.size();i++)
		{
			Thread.sleep(1000);
			System.out.println("CheckBox:"+ allvals.get(i).getAttribute("value"));
			s.selectByIndex(i); //select one by one
		}
	}//end

	// Handling the Windows
	public void handlewin(WebDriver driver) throws InterruptedException {
		System.out.println(driver);

		Set<String> s1 = driver.getWindowHandles();
		String menuWindow = driver.getWindowHandle();
		s1.remove(menuWindow);

		Iterator<String> i1 = s1.iterator();
		String child = null;

		while (i1.hasNext()) {
			child = (String) i1.next();
			driver.switchTo().window(child);
		}
		//		 driver.switchTo().window(menuWindow); // switch back to parent window

	}

	public WebDriver handlewin1(WebDriver driver) {
		String childWindow = driver.getWindowHandle();
		Set<String> pops=driver.getWindowHandles();
		pops.remove(childWindow);
		{
			Iterator<String> it =pops.iterator();
			while (it.hasNext()) {
				String menuWindow=it.next().toString();
				if(!menuWindow.contains(childWindow))
				{
					WebDriver driver1 = driver;
					driver1.close();
					driver.switchTo().window(menuWindow);
					System.out.println("Pop Up Title: "+ driver.switchTo().window(menuWindow).getTitle());

				}
			}
		}
		//    driver.switchTo().window(parent);
		return driver;
	}//end


	// Accepting the Alert Window
	public void acceptAlert() throws InterruptedException {

		SHORT_TIMEOUT();
		driver.switchTo().alert().accept();
	}//end

	// Dismissing the Alert Window
	public void dismissAlert() {

		driver.switchTo().alert().dismiss();
	}//end

	// Entering Text into Alert WindowBox
	public void enterTextInAlertBox(String alertText) throws InterruptedException {

		driver.switchTo().alert().sendKeys(alertText);
		Thread.sleep(4000);

	}

	//clicking on element using Action Class
	public void actionClassClickElement(WebElement Element) throws InterruptedException
	{
		Actions actions = new Actions(driver);
		SHORT_TIMEOUT();
		actions.moveToElement(Element).click().perform();
	}

	public void javascriptExecutorClickElement(WebElement Element) throws InterruptedException
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		SHORT_TIMEOUT();
		jse.executeScript("arguments[0].scrollIntoView()", Element); 
	}

	// Closing browser
	public void quitBrowser() {
		System.out.println(driver);
		driver.quit();
	}

	// Short Timeout
	public void SHORT_TIMEOUT() throws InterruptedException {
		Thread.sleep(1000);
	}

	// Timeout
	public void TIMEOUT() throws InterruptedException {
		Thread.sleep(3000);
	}

	// Long Timeout
	public void LONG_TIMEOUT() throws InterruptedException {
		Thread.sleep(10000);
	}

	// Getting text from field
	public String getText(WebElement element) {
		return element.getText();
	}

	// Getting value from field
	public String getAttribute(WebElement element) {
		return element.getAttribute("value");
	}

	public void explicitWait(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120, 1));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
	}

	// To Select checkbox
	public void isElementSelected(WebElement element, String checkbox) {
		if (checkbox.equals("Select")) {
			element.click();
		} else {
			if (element.isSelected() == true) {
				element.click();
				System.out.println("Checkbox is deselected");
			}
		}
	}

}
