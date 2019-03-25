import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MainClass {
	static WebDriver driver;
	static ExtentReports report;
	static ExtentTest logger;


	/*Initializing the driver.
	 * give the Path of driver in the system
	 * initialize driver to the chrome or firefox driver. 
	 * 
	 * */
	public static void initializeDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gitam\\javaSeleniumWd\\Automation\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String path = "C:\\Users\\gitam\\Desktop\\ExtentReports\\report2.html";
		report = new ExtentReports(path,false);
		logger = report.startTest("ReportExt");
        logger.log(LogStatus.INFO, "Driver Initiated");
	}
	
	
	/*for FindElement ,method is created.
	 * **/
	public static WebElement findElement(By id, Object println) {
		
		return null;
	}
	/* *  the path
	 	 * */
	
	public static void initializePath(String path){
		report = new ExtentReports(path);
		}
	
	/*Launch the Browser.
	 * Launch browser with the string url we want to open
	 * */
	public static void launchUrl(String url){
		driver.get(url);
		driver.manage().window().maximize();
		logger.log(LogStatus.PASS, " launched url Successfully");
	
	}
	
	/*Ending the Report
	 * 
	 */
	public static void endReport() {
		report.endTest(logger);
		report.flush();
		System.out.println("test Ended");

	}

	/*
	 * To check if a checkbox is checked or not
	 * on aplication
	 * 
	 */
	
	public static void isChecked() {
		
		if (driver.findElement(By.xpath("//input[@type ='checkbox']")).getAttribute("checked").equals("true")) {
			System.out.println("Check box:pass");
			}
		else {
			System.out.println("fail");
		}
		}
	
	
	/*
	 * verify the userName entered is correct or not
	 * 
	 * 
	 */
	
	public static void userNameChk() {
		String uName = driver.findElement(By.xpath("//div/span[@id ='userNavLabel']")).getText();
		String name = "madhavi M S";
		if(uName.equals(name))
		{
			System.out.println("Landed on users homepage");
		}
	}
	public static void textPresent() {
	
		if(driver.getPageSource().contains("mmadhavi1022@gmail.com"))
		{
 System.out.println("pass");
		}
		else{
			System.out.println("Fail");
		}
	}
	
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
	public static void enterText(By location,String objName,String textValue){

		WebElement obj;
		try {
			obj = driver.findElement(location);

			//System.out.println("Passed"+ obj +" found on page");
			
		} catch (NoSuchElementException errMessage) 
		{
			System.out.println("failed"+ objName +"couldn't found on page");
			return;
		}
		if(obj.isDisplayed()){
			obj.sendKeys(textValue);
			//System.out.println("Passed :"+ textValue + " is entered on the page" );
			logger.log(LogStatus.PASS, " Entered Successfully");
			//logger.log(LogStatus.PASS, "Username Exter Successfully");
			//logger.log(LogStatus.PASS, "Password Entered");
		}
		else
		{
			System.out.println("Failed :"+ objName + " is Not found to enter");
			


		}

	}
	/*close browser
	 * 
	 * 
	 */
	
	public static void closeBrowser(){
		 report.endTest(logger);
			report.flush();
		driver.close();
	}

}
