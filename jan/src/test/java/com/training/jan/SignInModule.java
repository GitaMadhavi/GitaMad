
//Test Case 01-A,B,C,D

package com.training.jan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SignInModule extends ReusableFunction{
//static WebDriver driver ;

	public static void main(String[] args) throws InterruptedException {
		//Navigate to Xero Website Test Case 01-A
		
		initializeBrows();
		System.out.println("browser launched ");
        launchUrl("https://login.xero.com/");
		System.out.println("login page launched");
		Thread.sleep(5000);
		
		//Correct Password Test Case 01
		WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
		clickObj(emailField);
		enterText(emailField, "mmadhavi1022@gmail.com");
		System.out.println("email is entered");
		
		
		WebElement pwdField = driver.findElement(By.xpath("//input[@id='password']"));
		clickObj(pwdField);
		enterText(pwdField, "Training123!");
		System.out.println("password is entered");
		
		Thread.sleep(4000);
		WebElement logInButton = driver.findElement(By.xpath("//button[@type='submit']"));
		clickObj(logInButton);
		String titleExp = "Welcome";
		String titleOfPage = driver.findElement(By.xpath("//div[@class ='xui-page-title xdash-setupwidget__setup--header-title___1obD5']")).getText();
		Thread.sleep(5000);
		
		//Asserting the page is home Page
		if(titleOfPage.contains(titleExp))
		{
			System.out.println("You are logged into your account HomePage");
		}
		
		WebElement profileName = driver.findElement(By.xpath("//abbr[@class='xrh-avatar xrh-avatar-color-7']"));
		clickObj(profileName);
		Thread.sleep(5000);
		WebElement logOut = driver.findElement(By.xpath("//a[@data-navigation-id='logout']"));
		clickObj(logOut);
		
		//Incorrect Password Test Case 01-B
		

	    launchUrl("https://login.xero.com/");
		System.out.println("login page launched");
		Thread.sleep(5000);
		
		WebElement emailField1 = driver.findElement(By.xpath("//input[@id='email']"));
		clickObj(emailField1);
		enterText(emailField1, "mmadhavi1022@gmail.com");
		System.out.println("email is entered");
		
		
		WebElement pwdField1 = driver.findElement(By.xpath("//input[@id='password']"));
		clickObj(pwdField1);
		enterText(pwdField1, "Training");
		System.out.println("password is entered is incorrect");
		
		Thread.sleep(4000);
		WebElement logInButton1 = driver.findElement(By.xpath("//button[@type='submit']"));
		clickObj(logInButton1);
		
		String expMsg ="email or password is incorrect";
		String errorMsg = driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect ')]")).getText();
		if(expMsg.contains(errorMsg)){
			System.out.println("You have entered incorrect Email or password");
		}
		
	//Incorrect Email ,Test Case 01-C
	
	WebElement emailField2 = driver.findElement(By.xpath("//input[@id='email']"));
	clickObj(emailField2);
	enterText(emailField2, "mmadhavi122@gmail.com");
	System.out.println("email is entered incorrect");
	
	
	WebElement pwdField2 = driver.findElement(By.xpath("//input[@id='password']"));
	clickObj(pwdField2);
	enterText(pwdField2, "Training123!");
	System.out.println("password is entered");
	
	Thread.sleep(4000);
	WebElement logInButton2 = driver.findElement(By.xpath("//button[@type='submit']"));
	clickObj(logInButton2);
	
	String expMsg2 ="email or password is incorrect";
	String errorMsg2 = driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect ')]")).getText();
	if(expMsg2.contains(errorMsg2)){
		System.out.println("You have entered incorrect Email or password");
		Thread.sleep(3000);
	}
	
	//ForgotPassword Test Case 01-D
	WebElement forgotPwd = driver.findElement(By.xpath("//a[@class ='forgot-password-advert']"));
	clickObj(forgotPwd);
	System.out.println(driver.getCurrentUrl());
	System.out.println("Test Case 1-A,B,C,D passed");
/*	String expForgotPwdText = "reset your password";
String actForgotPwdText = driver.findElement(By.xpath("//p[contains(text(),'To reset your password, enter the email address you use to login to Xero. A link will be emailed to this address which will let you reset your password.')]")).getText();
	//String actualResetMsg = actForgotPwdText.getText();
	if(expForgotPwdText.contains(actForgotPwdText)){
		System.out.println("Test Case Forgot Password Passed");
	*/	
	System.out.println("Driver is closing");
	driver.close();

	
	}
	}

	



