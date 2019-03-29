package com.automation.Jan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ReusableFunctions {

	static WebDriver driver;

	/*Initializing Driver
	 *  Setting the System Property  of the driver
	 *  and location of the driver, Path 
	 *  Created by:Gita M
	 */

	public void initializeDriver(){
		System.setProperty("webdriver.chrome.driver","C:/Users/gitam/javaSeleniumWd/Jan19/drivers/chromedriver/chromedriver.exe");
		System.out.println("Driver is Initialized by Chrome driver");
		driver = new ChromeDriver();
	}

	/* Function Name: Launching URL
	 * Arguments: URL is passed as String
	 * Created by:QA		
	 */
	public void launchUrl(String url){

		driver.get(url);
		driver.manage().window().maximize();
	
		//WebDriverWait wait = new WebDriverWait(driver,40);
		driver.get(" https://selenium-prd.firebaseapp.com/");
		System.out.println("Application Launched successfully");

	}
	/* Function Name:ENtering text into any textBox.
	 * Arguments: WebElement element,String textVal
	 * Created by:QA		
	 */

	public static void enterText(WebElement element,String textVal) throws InterruptedException{

		if(element.isDisplayed())
		{
			Thread.sleep(3000);
			element.sendKeys(textVal);
			System.out.println("Text Value is entered into: ");
		}
		else{
			System.out.println( "Field doesn't exist,Please check");

		}

	}
	/*Reusasble Function Name: ClickObj
	 * Arguments: Webelement Obj
	 * Created by: QA
	 * 
	 */
	public static void clickObj(WebElement Obj) throws InterruptedException{
		
		if(Obj.isDisplayed()){
			Thread.sleep(1000);
			Obj.click();
			System.out.println( " Object is clicked");
		}
		else {
			System.out.println("Object is Not clicked,unable to find the element");
			
		}
		
		
	}
	/*Reusable Function Name: SelectByIndex fro district Dropdown
	 * Arguments: WebElement Obj,int index
	 * Created by:QA
	 * 
	 */
	public static void selectByIndexDistrict(WebElement Obj,int index) throws InterruptedException{
		if(Obj.isDisplayed()){
			Thread.sleep(2000);
			Select districtDropDown = new Select(Obj);
			districtDropDown.selectByIndex(3);
			System.out.println("districtDropDown is selected from dropdown" );
		}
		else{
			System.out.println("Element not reachable");
		}
	}
	
	/*Reusable Function Name: SelectByValue for Course Dropdown
	 * Arguments: WebElement Obj,String Value
	 * Created by:Gita M
	 * 
	 */

	public static void selectByValueCOurse(WebElement Obj,String Value) throws InterruptedException{
		if(Obj.isDisplayed()){
			Thread.sleep(2000);
			Select courseDrpDown = new Select(Obj);
			courseDrpDown.selectByValue("btech");
			System.out.println("courseDrpDown is selected");
		}
		else{
			System.out.println("Element not reachable");
		}
	}
	/*Reusable Function Name: SelectByVisibleText
	 * Description: SelectByVisibleText for State Dropdown
	 * Arguments: WebElement Obj,String Value
	 * Created by:QA
	 * 
	 */
	
	public static void selectByVisibleTextState(WebElement obj,String text) throws InterruptedException{
		if(obj.isDisplayed()){
			Thread.sleep(3000);
		Select sel3 = new Select(obj);
		sel3.selectByVisibleText("NALANDA");
		System.out.println("state is selected");
	}
		else{
			System.out.println("Element not reachable");
		}

}}







