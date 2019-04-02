package com.training.jan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReusableFunction {
	static WebDriver driver;
	static ExtentReports extentReport;
	static ExtentTest exTest;
	public static void initializeBrows() {
		extentReport = new ExtentReports ("C:\\Users\\gitam\\Desktop\\ExtentReports\\NewestExtentReport.html", true);

		System.setProperty("webdriver.chrome.driver","C:/Users/gitam/javaSeleniumWd/jan/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		exTest = extentReport.startTest("launch Test");
	}
	/* Function Name: Launching URL
	 * Arguments: URL is passed as String
	 * Created by:QA		
	 */
	public static void launchUrl(String url) throws InterruptedException{

		driver.get(url);
		System.out.println("url Launched successfully");
		exTest.log(LogStatus.PASS, "opened successfully");
		Thread.sleep(6000);
		driver.manage().window().maximize();	
		Thread.sleep(3000);

	}

	public static void clickObj(WebElement Obj) throws InterruptedException{

		if(Obj.isDisplayed()){
			Thread.sleep(4000);
			System.out.println("obj is displayed");
			Obj.click();
			System.out.println("is clicked ,success");
		}
		else {
			System.out.println("not success");
		}
	}

	/*
	 * Enter Text into Text Fields
	 * 
	 * 
	 * 
	 */
	public static void enterText(WebElement element,String textVal) throws InterruptedException{

		if(element.isDisplayed())
		{
			Thread.sleep(3000);
			element.sendKeys(textVal);
			System.out.println("Entered email successfully");
		}
		else{
			System.out.println("Entering email is unsuccessful");

		}

	}

	/**
	 * 
	 */
	public void closeBrowser() {
		driver.close();
	}

}


