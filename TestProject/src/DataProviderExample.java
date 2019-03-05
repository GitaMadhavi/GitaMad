import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class DataProviderExample extends MainClass{
	static WebDriver driver;	
	static ExtentReports report;
	static ExtentTest logger;
	@ BeforeSuite
	public void befSuite(){
		initializeDriver();
	}
	@BeforeTest
	public void befClass(){
	launchUrl("https://login.salesforce.com/");	

	click(By.xpath("//input[@type ='submit']"),"Log In");
	System.out.println("logged in after submitting");
	driver.close();

	}
	@Test(dataProvider = "getData")
	public void doLogin(String userName,String password){
						
	}
	
	@DataProvider(parallel =true)
	public Object[][] getData()

	{
		Object [][] data = new Object[2][2];

		data[0][0] = "mmadhavi1022@gmail.com";
		data[0][1] = "BHU1van2!";
		data[1][0] = "mmadhavi1022@gmail.com";
		data[1][1] = "BHU1van2!!!";
		//data[2][0] = "cde@gmail.com";
		//data[2][1] = "abc123";
		//data[3][0] = "abc@gmail.com";
		//data[3][1] = "hike345";
		return data;

	}
}