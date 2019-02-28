import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SalesforceApp extends MainClass {
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

	}
	@Test(priority =1)
	public void loginTest() throws InterruptedException{
		enterText(By.xpath("//input[@id ='username']"), "Username", "mmadhavi1022@gmail.com");
		enterText(By.xpath("//input[@type ='password']"), "password", "BHU1van2!");
		Thread.sleep(5000);
	}

	@Test(priority =2,dependsOnMethods={"loginTest"})
	public void logIn() throws InterruptedException{
		click(By.xpath("//input[@type ='submit']"),"Log In");
		Thread.sleep(5000);
	}

	@Test(priority =3,dependsOnMethods={"logIn"})
	public void closeDialogue() throws InterruptedException{


		click(By.xpath("//div/a[@class ='dialogClose']"),"Close");
		System.out.println("closed dialogue window");

	}


	@Test(priority =4,dependsOnMethods={"closeDialogue"})
	public void clickUsrNavButton() throws InterruptedException{
		click(By.xpath("//div[@id ='userNav-arrow']"),"userNavLabel");
		userNameChk();
		Thread.sleep(5000);
	}

	@Test(enabled = false,dependsOnMethods={"clickUsrNavButton"})
	public void logOutFrmApp() throws InterruptedException{
		click(By.xpath("//a[@title = 'Logout']"),"logOut");
		Thread.sleep(6000);
		textPresent();
		isChecked();

	} 
}





