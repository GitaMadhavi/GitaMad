package pack1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {
	WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser) throws Exception{
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\gitam\\javaSeleniumWd\\Automation\\drivers\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
				else if(browser.equalsIgnoreCase("MicrosoftWebDriver")) 
		{
			System.setProperty("webdriver.edge.driver","C:\\Users\\gitam\\javaSeleniumWd\\Automation\\drivers\\MicrosoftWebDriver\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		
		else{
			throw new Exception("Browser is Not correct");
		}
	}
	
	
	@Test(priority =1)
	public void googlePage() throws InterruptedException {
		driver.get("http://www.amazon.com");
		driver.manage().window().maximize();
	}
	@Test(priority =2)
	public void getTitle(){
		
		//throw new SkipException("Connection Failed");
		
		WebElement title =driver.findElement(By.xpath("//div[@id ='nav-tools']/a[@data-nav-role ='signin']/span[@class ='nav-line-1']"));
		String Title = title.getText();
		System.out.println(Title);
		
	}
	@Test(priority =3)
	public void AfterTest() {
		System.out.println("get Title Passed");

	}
	@Test(priority =4,dependsOnMethods={"getTitle"})
	public void selFrmDropdown() throws InterruptedException{

		WebElement selectMenu =driver.findElement(By.xpath("//select[@id ='searchDropdownBox']"));
		Select sel =new Select(selectMenu);

		sel.selectByVisibleText("Baby");
		System.out.println("Select Class ,select by visible text: Passed test");
		Thread.sleep(3000);
	}
	@Test(priority =6)
	public void selByVal() throws InterruptedException{
		WebElement selectMenu =driver.findElement(By.xpath("//select[@id ='searchDropdownBox']"));
		Select sel =new Select(selectMenu);
		sel.selectByValue("search-alias=mobile-apps");

		System.out.println("select by value: test passed");
		Thread.sleep(5000);
	}
@Test(priority = 5,dependsOnMethods={"getTitle"})
	public void selByIndex() throws InterruptedException{
		WebElement selectMenu =driver.findElement(By.xpath("//select[@id ='searchDropdownBox']"));
		Select sel =new Select(selectMenu);
		sel.selectByIndex(11);
		System.out.println("select by Index : test passed,testing priority in testNG");
		Thread.sleep(5000);
	}
@AfterClass(enabled =false)
public void testAfterClass(){
	System.out.println("testing annotation @afterClass");
	
}
	@AfterSuite(enabled = false)
	public void closeSuite(){
		driver.quit();
	}

}
	

/*
 * else if(browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\gitam\\javaSeleniumWd\\Automation\\drivers\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
			
			<test name="FirefoxTest">
			<parameter name="browser" value="Firefox" />
			<classes>
				<class name="pack1.CrossBrowserTesting" />
			</classes>
		</test>
		}
 */
