package com.automation.Jan;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Interactions extends ReusableFunctions {

	static ExtentReports reports;
	static ExtentTest extTest;

	@BeforeSuite
	public void beforeSuite() {

		//String path = "C:\\Users\\gitam\\Desktop\\ExtentReports\\reportmvn.html";
		String path = System.getProperty("user.dir")+"/test-output/NewExtentReport.html";
		reports = new ExtentReports (path,true);
		initializeDriver();	
		//Logger = reports.startTest("Launched the driver");
		extTest = reports.startTest("Successfully Launched the driver");
	}
	@BeforeTest
	public void beforeTest(){
		launchUrl(" https://selenium-prd.firebaseapp.com/");

	}
	@Test
	public void homePageForm() throws InterruptedException{

		WebElement emailField = driver.findElement(By.xpath("//input[@id ='email_field']"));
		Thread.sleep(2000);
		enterText(emailField, "admin123@gmail.com");
	
		extTest.log(LogStatus.PASS, "Entered email successfully");
		WebElement pwdField = driver.findElement(By.xpath("//input[@id ='password_field']"));
		pwdField.clear();
		extTest.log(LogStatus.PASS,"Entered password successfully");
		enterText(pwdField,"admin123");
		WebElement loginBtn = driver.findElement(By.xpath("//button[@onclick ='login()']"));
		clickObj(loginBtn);
		extTest.log(LogStatus.PASS,"clicked successfully");
		//System.out.println("Until here,ALL good");
		Thread.sleep(3000);
		WebElement hometab = driver.findElement(By.xpath("//a[@href ='./home.html']"));
		clickObj(hometab);
		extTest.log(LogStatus.PASS," HomeTab clicked successfully");
		Thread.sleep(2000);
		WebElement nameField = driver.findElement(By.xpath("//input[@id ='name']"));
		nameField.clear();
		enterText(nameField,"TekArch");
		Thread.sleep(4000);
		WebElement fatherNameField = driver.findElement(By.xpath("//input[@id = 'lname']"));
		fatherNameField.clear();
		enterText(fatherNameField,"AbhishekJ");
		Thread.sleep(3000);
		WebElement postalAddressField = driver.findElement(By.xpath("//input[@id = 'postaladdress']"));
		postalAddressField.clear();
		enterText(postalAddressField,"Milpitas,California");
		Thread.sleep(2000);
		WebElement personalAddressField = driver.findElement(By.xpath("//input[@id = 'personaladdress']"));
		personalAddressField.clear();
		enterText(personalAddressField,"Benguluru,India");
		Thread.sleep(2000);
		WebElement femaleRadioButton = driver.findElement(By.xpath("//input[@value = 'female']"));
		clickObj(femaleRadioButton);
		extTest.log(LogStatus.PASS,"clicked successfully");
		Thread.sleep(3000);
		WebElement cityDrpDown = driver.findElement(By.xpath("//select[@id = 'city']"));
		Select sel = new Select(cityDrpDown);
		sel.selectByIndex(2);
		Thread.sleep(2000);
		WebElement courseDrpDown = driver.findElement(By.xpath("//select[@id = 'course']"));
		selectByValueCOurse(courseDrpDown,"btech");
		Thread.sleep(2000);
		WebElement districtDrpDown = driver.findElement(By.xpath("//select[@id = 'district']"));
		selectByIndexDistrict(districtDrpDown,2);
		Thread.sleep(2000);
		WebElement stateDrpDown = driver.findElement(By.xpath("//select[@id = 'state']"));
		selectByVisibleTextState(stateDrpDown, "BIHAR");
		Thread.sleep(2000);
		WebElement pincodeField = driver.findElement(By.xpath("//input[@id = 'pincode']"));
		pincodeField.clear();		
		enterText(pincodeField,"94582");
		WebElement emailIdField = driver.findElement(By.xpath("//input[@id = 'emailid']"));
		emailIdField.clear();
		enterText(emailIdField,"abcd@gmail.com");
		Thread.sleep(2000);
		WebElement submitButton = driver.findElement(By.xpath("//button[@style = 'float:right']"));
		clickObj(submitButton);
		extTest.log(LogStatus.PASS,"submit clicked successfully");
		System.out.println("All fields Succesfully Filled");		
		Thread.sleep(2000);
		/**************************Home page Completed********************/
		//Switch to Tab elements
		WebElement switchTo= driver.findElement(By.xpath("//button[contains(text(),'Switch To') ]"));
		clickObj(switchTo);
		Thread.sleep(2000);
		WebElement alertEle = driver.findElement(By.xpath("//a[ contains(text(),'Alert') ]"));
		clickObj(alertEle);
		Thread.sleep(2000);
		WebElement windowAlert = driver.findElement(By.xpath("//button[contains(text(),'Window Alert') ]"));
		clickObj(windowAlert);
		extTest.log(LogStatus.PASS,"WIndow Alert clicked successfully");
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		WebElement promptAlert = driver.findElement(By.xpath("//button[contains(text(),'Promt Alert') ]"));
		clickObj(promptAlert);
		extTest.log(LogStatus.PASS,"clicked successfully");
		Thread.sleep(3000);
		Alert promtAler = driver.switchTo().alert();
		promtAler.sendKeys("GitaMadhavi");
		Thread.sleep(2000);
		promtAler.accept();
		Thread.sleep(2000);
		reports.endTest(extTest);
		reports.flush();
		reports.close();

	}
}