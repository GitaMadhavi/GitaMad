package com.training.jan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class logOutModule extends ReusableFunction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

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
	System.out.println("TC-4-A is complete");
		
		
		System.out.println("Driver is Closing");
		driver.close();
		
		
	}
}
/*//ForgotPassword Test Case 01-D
		WebElement forgotPwd = driver.findElement(By.xpath("//a[@class ='forgot-password-advert']"));
		clickObj(forgotPwd);
		String expForgotPwdText = "reset your password";
	WebElement actForgotPwdText = driver.findElement(By.xpath("//p[contains(text(),'To reset your password, enter the email address you use to login to Xero. A link will be emailed to this address which will let you reset your password.')]"));
		String actualResetMsg = actForgotPwdText.getText();
		if(expForgotPwdText.contains(actualResetMsg)){
			System.out.println("Test Case Forgot Password Passed");
			
 * 
 */
