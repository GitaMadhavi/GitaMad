import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ReportExt extends MainClass{

	static WebDriver driver ;
	static ExtentReports report;
	static ExtentTest logger;

	public static void main(String[] args) {
		//String path = "C:\\Users\\gitam\\Desktop\\ExtentReports\\report2.html";
		//report = new ExtentReports(path);
		initializeDriver();
		System.out.println("Start");
		launchUrl("https://login.salesforce.com/");
		enterText(By.xpath("//input[@id ='username']"), "Username", "abc@gmail.com");
		enterText(By.xpath("//input[@type ='password']"), "password", "training");
		//click(By.xpath("//input[@type='checkBox']"),"Remember me","remMe");
		click(By.xpath("//input[@type ='submit']"),"Log In");
       	closeBrowser();
		System.out.println("End");
		

	}

}

