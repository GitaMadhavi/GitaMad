import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;


public class TestNGExamples extends MainClass{
	public static class GooglePageTest {
		 static WebDriver driver;
		 static ExtentReports report;
		
		@BeforeSuite
		public void beforeTest1() {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\gitam\\javaSeleniumWd\\Automation\\drivers\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("BeforeSuite passed");
		}

		@Test(priority =1)
		public void googlePage() throws InterruptedException {
			driver.get("http://www.amazon.com");
			driver.manage().window().maximize();
			System.out.println("priority test no 1 is passed");
		}
		@Test(enabled =false)
		public void getTitle(){

			throw new SkipException("Connection Failed");

			/*	WebElement title =driver.findElement(By.xpath("//div[@id ='nav-tools']/a[@data-nav-role ='signin']/span[@class ='nav-line-1']"));
			String Title = title.getText();
			System.out.println(Title);
			 */
		}
		@Test(enabled =false)
		public void AfterTest() {
			System.out.println("get Title Passed");

		}
		@Test(priority =3,enabled =false,dependsOnMethods={"googlePage"})
		public void selFrmDropdown() throws InterruptedException{

			WebElement selectMenu =driver.findElement(By.xpath("//select[@id ='searchDropdownBox']"));
			Select sel =new Select(selectMenu);

			sel.selectByVisibleText("Baby");
			System.out.println("Select Class ,select by visible text: Passed test");
			Thread.sleep(3000);
			
				}
		@Test
		public void assrtTesting(){
			String expected = "ABCD";
			String actual = "ABD";
			
			Assert.assertEquals(actual, expected);
			
		}
		SoftAssert softAsser =new SoftAssert();
		@Test(priority=2)
		public void softAssertTesting(){
			String expected = "ABCD";
			String actual = "ABD";
			
			softAsser.assertEquals(actual, expected);
			System.out.println("+++++++++++++++++");
			
			String exp = "ABCD";
			String act = "ABDE";
			softAsser.assertEquals(act, exp);
			softAsser.assertAll();
		}
	}
}



