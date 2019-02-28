import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class MainClass {

	static WebDriver driver;
	static ExtentReports report;
	static ExtentTest logger;

	public static void click(By location, String objName){
		WebElement obj = null;
		try {
			obj =driver.findElement(location);

		} catch (Exception e) {

			e.printStackTrace();
		}
		if(obj.isDisplayed()){
			obj.click();
			System.out.println((objName +" is clicked"));
			
			 System.out.println("Error message displayed for incorrect password");
		}
		
	}

	/*Initializing the driver.
	 * give the Path of driver in the system
	 * initialize driver to the chrome or firefox driver. 
	 * 
	 * */
	public static void initializeDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gitam\\javaSeleniumWd\\Automation\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	/*for FindElement ,method is created.
	 * **/
	public static WebElement findElement(By id, Object println) {
		// TODO Auto-generated method stub
		return null;
	}

	/* * Initialze the path
	 	 * */
	
	public static void initializePath(String path){
		report = new ExtentReports(path);
		
		
	}
	 
	/*Launch the Browser.
	 * Launch browser with the string url we want to open
	 * */
	public static void launchBrowser(String url,String logFileName){
		driver.get(url);
		driver.manage().window().maximize();
		logger = report.startTest(logFileName);
	}
	/**
	 * 
	 */
	public static void endReport() {
		report.endTest(logger);
		report.flush();
		System.out.println("test Ended");
		
	}
	public static void closeBrowser(){
		driver.close();
	}
	public static void enterText(By location,String objName,String textValue){

		WebElement obj;
		try {
			obj = driver.findElement(location);

			System.out.println("Passed"+ obj +" found on page");
			
		} catch (NoSuchElementException errMessage) 
		{

			System.out.println("failed"+ objName +"couldn't found on page");
			
			return;

		}
		if(obj.isDisplayed()){
			obj.sendKeys(textValue);
			System.out.println("Passed :"+ textValue + " is entered on the page" );
		}
		else
		{
			System.out.println("Failed :"+ objName + " is Not found to enter");


		}

	}	

}
