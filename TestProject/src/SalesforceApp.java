import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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

	@Test(priority = 5,dependsOnMethods={"clickUsrNavButton"})
	public void profileSettings() throws InterruptedException{
		click(By.xpath("//a[@title='My Profile']"), "My Profile");
		Thread.sleep(4000);
		click(By.xpath("//a[@class ='contactInfoLaunch editLink']//img[@title ='Edit Profile']"),"click edit profile");
		System.out.println("Switching to Iframe now");
		WebElement iframe =	driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']"));
		driver.switchTo().frame(iframe);
		click(By.xpath("//a[contains(text(),'About')]"),"About Tab");
		WebElement lastName = driver.findElement(By.xpath("//input[@id ='lastName']"));
		lastName.clear();
		enterText(By.xpath("//input[@id ='lastName']"), "lastname", "Munukutla Seshu");
		click(By.xpath("//input[@value = 'Save All']"),"saveAll button");
		click(By.xpath("//a/span[contains(text(),'Post')]")," Post Link");
		
	}
	@Test(priority =6, dependsOnMethods={"clickUsrNavButton"})
	public void leftPane() throws InterruptedException{
		
		 click(By.xpath("//a[@title ='My Settings']"),"My Settings");
         Thread.sleep(5000);
       //a[@title ='My Settings']
         click(By.xpath("//span[@class ='accordionIcon expand_icon']"),"Icon");
         Thread.sleep(4000);
         click(By.xpath("//span[@id ='LoginHistory_font']"),"Login History");
         click(By.xpath("//a[contains(text(),'Download login')]"),"download csv file");
         click(By.xpath("//div[@id ='DisplayAndLayout']//span[@class='accordionIcon expand_icon']"),"display");
         click(By.xpath("//span[@id ='CustomizeTabs_font']"),"customizeTabs");        
      //  WebElement drpdownIcon=driver.findElement(By.xpath("//select[@id='p4']"));
        
        click(By.xpath("//span[@id='DisplayAndLayout_font']"),"Display and Layout");
        click(By.xpath("//span[@id='CustomizeTabs_font']"),"click customize my tabs");
      //span[@id='CustomizeTabs_font']
      //select[@id='duel_select_0']
        WebElement selectbutton=driver.findElement(By.xpath("//select[@id='duel_select_0']"));
        Select sel2=new Select(selectbutton);
    	sel2.selectByVisibleText("Reports");
     sel2.selectByVisibleText("Salesforce Chatter");
         Thread.sleep(4000);
         WebElement add1=driver.findElement(By.xpath("//img[@title='Add']"));
     	add1.click();
	}
	
	@Test(enabled=true,dependsOnMethods={"profileSettings"})
	public void logOutFrmApp() throws InterruptedException{
		click(By.xpath("//a[@title = 'Logout']"),"logOut");
		Thread.sleep(6000);
		textPresent();
		isChecked();
} 
}





