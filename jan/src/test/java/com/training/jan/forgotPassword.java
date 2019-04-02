package com.training.jan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class forgotPassword extends ReusableFunction{

	public static void main(String[] args) throws InterruptedException {
		

		initializeBrows();
		launchUrl("https://login.xero.com/");
		
		
	//ForgotPassword Test Case 01-D
			WebElement forgotPwd = driver.findElement(By.xpath("//a[@class ='forgot-password-advert']"));
			clickObj(forgotPwd);
			
			System.out.println(driver.getCurrentUrl());
			
		/*	String expForgotPwdText = "reset your password";
	String actForgotPwdText = driver.findElement(By.xpath("//p[contains(text(),'To reset your password, enter the email address you use to login to Xero. A link will be emailed to this address which will let you reset your password.')]")).getText();
			//String actualResetMsg = actForgotPwdText.getText();
			if(expForgotPwdText.contains(actForgotPwdText)){
				System.out.println("Test Case Forgot Password Passed");
			*/	
			
}
	}

