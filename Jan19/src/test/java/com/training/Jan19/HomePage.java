package com.training.Jan19;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage {

	
	static ExtentReports extent;
	static ExtentTest homeTest;
	

	
	public static void main(String[] args) throws InterruptedException {


		 extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/HomeExtentReport.html", true);

             
		
		System.setProperty("webdriver.chrome.driver","C:/Users/gitam/javaSeleniumWd/Jan19/drivers/chromedriver/chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		homeTest = extent.startTest("launch Test");
		//WebDriverWait wait = new WebDriverWait(driver,40);
		driver.get(" https://selenium-prd.firebaseapp.com/");
	
		//System.out.println("Application Launched successfully");
		Thread.sleep(4000);		
		WebElement emailField = driver.findElement(By.xpath("//input[@id ='email_field']"));
		emailField.sendKeys("admin123@gmail.com");
		Thread.sleep(3000);
		homeTest.log(LogStatus.PASS, "username entered Successfully");
		WebElement pwdField = driver.findElement(By.xpath("//input[@id ='password_field']"));
		pwdField.clear();
		pwdField.sendKeys("admin123");
		homeTest.log(LogStatus.PASS, "Password entered Successfully");
		WebElement loginBtn = driver.findElement(By.xpath("//button[@onclick ='login()']"));
		loginBtn.click();
		homeTest.log(LogStatus.PASS, "button clicked Successfully");
		//System.out.println("Until here,ALL good");
		Thread.sleep(3000);
		WebElement hometab = driver.findElement(By.xpath("//a[@href ='./home.html']"));
		hometab.click();
		Thread.sleep(2000);
		WebElement nameField = driver.findElement(By.xpath("//input[@id ='name']"));
		nameField.clear();
		nameField.sendKeys("Tekarch");
		Thread.sleep(4000);
		WebElement fatherNameField = driver.findElement(By.xpath("//input[@id = 'lname']"));
		fatherNameField.clear();
		fatherNameField.sendKeys("Abhishek");
		Thread.sleep(3000);
		WebElement postalAddressField = driver.findElement(By.xpath("//input[@id = 'postaladdress']"));
		postalAddressField.clear();
		postalAddressField.sendKeys("Milpitas,California");
		Thread.sleep(2000);
		WebElement personalAddressField = driver.findElement(By.xpath("//input[@id = 'personaladdress']"));
		personalAddressField.clear();
		personalAddressField.sendKeys("Benguluru,India");
		Thread.sleep(2000);
		WebElement femaleRadioButton = driver.findElement(By.xpath("//input[@value = 'female']"));
		femaleRadioButton.click();
		Thread.sleep(3000);
		WebElement cityDrpDown = driver.findElement(By.xpath("//select[@id = 'city']"));
		Select sel = new Select(cityDrpDown);
		sel.selectByIndex(2);
		Thread.sleep(2000);
		WebElement courseDrpDown = driver.findElement(By.xpath("//select[@id = 'course']"));
		Select sel1 = new Select(courseDrpDown);
		sel1.selectByValue("btech");
		Thread.sleep(2000);
		WebElement districtDrpDown = driver.findElement(By.xpath("//select[@id = 'district']"));
		Select sel2 = new Select(districtDrpDown);
		sel2.selectByVisibleText("BIHAR");
		Thread.sleep(2000);
		WebElement stateDrpDown = driver.findElement(By.xpath("//select[@id = 'state']"));
		Select sel3 = new Select(stateDrpDown);
		sel3.selectByVisibleText("NALANDA");
		Thread.sleep(2000);
		WebElement pincodeField = driver.findElement(By.xpath("//input[@id = 'pincode']"));
		pincodeField.clear();		
		pincodeField.sendKeys("94582");
		WebElement emailIdField = driver.findElement(By.xpath("//input[@id = 'emailid']"));
		emailIdField.clear();
		emailIdField.sendKeys("abcd@gmail.com");
		Thread.sleep(2000);
		WebElement submitButton = driver.findElement(By.xpath("//button[@style = 'float:right']"));
		submitButton.click();
		System.out.println("All fields Succesfully Filled");		
		Thread.sleep(2000);
		/**************************Home page Complete********************/
		//Switch to Tab elements
		WebElement switchTo= driver.findElement(By.xpath("//button[contains(text(),'Switch To') ]"));
		switchTo.click();
		Thread.sleep(2000);
		WebElement alertEle = driver.findElement(By.xpath("//a[ contains(text(),'Alert') ]"));
		alertEle.click();
		Thread.sleep(2000);
		WebElement windowAlert = driver.findElement(By.xpath("//button[contains(text(),'Window Alert') ]"));
		windowAlert.click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		WebElement promptAlert = driver.findElement(By.xpath("//button[contains(text(),'Promt Alert') ]"));
        promptAlert.click();
        Thread.sleep(4000);
        Alert promtAler = driver.switchTo().alert();
        promtAler.sendKeys("GitaMadhavi");
        //Thread.sleep(2000);
         promtAler.accept();
         extent.endTest(homeTest);
         extent.flush();
         extent.close();
        //driver.close();
	}           
}
