import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SalesforceApp extends MainClass {
	static WebDriver driver;	
	static ExtentReports report;
	static ExtentTest logger;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("hi");
		initializeDriver();
		String path ="C:\\Users\\gitam\\Desktop\\ExtentReports\\report.html";
		initializePath(path);
		launchBrowser("https://login.salesforce.com/","TC01");
		enterText(By.xpath("//input[@id ='username']"), "Username", "abc@gmail.com");
		enterText(By.xpath("//input[@type ='password']"), "password", "training");
		Thread.sleep(5000);
		click(By.xpath("//input[@type ='submit']"),"Log In");
		
		System.out.println("TC01 passed");
		endReport();
        closeBrowser();
		//System.out.println("End");

	}

	
	
}



