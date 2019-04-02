package com.training.jan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IncorrPwd extends ReusableFunction {

	static WebDriver driver;


public static void main(String[] args) throws InterruptedException {
	
	//Incorrect Password Test Case 02
	initializeBrows();
	System.out.println("browser launched ");
    launchUrl("https://login.xero.com/");
	System.out.println("login page launched");
	Thread.sleep(5000);
	
	WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
	clickObj(emailField);
	enterText(emailField, "mmadhavi1022@gmail.com");
	System.out.println("email is entered");
	
	
	WebElement pwdField = driver.findElement(By.xpath("//input[@id='password']"));
	clickObj(pwdField);
	enterText(pwdField, "Training");
	System.out.println("password is entered is incorrect");
	
	Thread.sleep(4000);
	WebElement logInButton = driver.findElement(By.xpath("//button[@type='submit']"));
	clickObj(logInButton);
	
	String expMsg ="email or password is incorrect";
	String errorMsg = driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect ')]")).getText();
	if(expMsg.contains(errorMsg)){
		System.out.println("You have entered incorrect Email or password");
	}
	}


}










