package com.training.jan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AllTabs extends ReusableFunction {

	public static void main(String[] args) throws InterruptedException {
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
		
		String titleOfLoginactual = driver.findElement(By.xpath("//span[contains(text(),'You’re using a trial account.')]")).getText();
		String titleOfLoginExp = "You’re using a trial account";
		if(titleOfLoginactual.equals(titleOfLoginExp)){
			System.out.println("TC for login title passed");
			
			
			WebElement dashB = driver.findElement(By.xpath("//a[@data-navigation-id='dashboard']"));
			clickObj(dashB);
			System.out.println(driver.getCurrentUrl());
			
			WebElement accountingDrpdown = driver.findElement(By.xpath("//button[@data-navigation-id='accounting']"));
			clickObj(accountingDrpdown);
			System.out.println("You are on Acconts Dropdown");
			WebElement reportDrpdown = driver.findElement(By.xpath("//a[@data-navigation-id='accounting-reports']"));
			clickObj(reportDrpdown);
			
			String repPageTitle = driver.findElement(By.xpath("//h1[@class ='xui-pageheading--title']")).getText();
			if (repPageTitle.equals("Reports"))
			{
				System.out.println("I am on Reports Dropdown Page");
			}
			
			
			WebElement contact = driver.findElement(By.xpath("//button[@data-event-action='Clicked NAVIGATION: contacts']"));
			clickObj(contact);
			System.out.println("You are on Contacts Dropdown");
			
			WebElement settingsDropDownIcon = driver.findElement(By.xpath("xrh-appbutton--body"));
			clickObj(settingsDropDownIcon);
			WebElement settings = driver.findElement(By.xpath("//a[contains(text(),'Settings')]"));
			clickObj(settings);
			
			String pgTitleSettings = driver.findElement(By.xpath("//span[contains(text(),'Organization settings')]")).getText();
			System.out.println(pgTitleSettings);
			
			WebElement createNewBtn = driver.findElement(By.xpath("//button[@title ='Create new']"));
			clickObj(createNewBtn);
			driver.navigate().refresh();
			

			WebElement dropDownIcon = driver.findElement(By.xpath("xrh-appbutton--body"));
			clickObj(dropDownIcon);
			WebElement files = driver.findElement(By.xpath("//a[@data-navigation-id='files']"));
			clickObj(files);
			String fileText = driver.findElement(By.xpath("//h1[contains(text(),'Files')]")).getText();
			if (fileText.equals("Files"))
			{
				System.out.println("I am on Files Page");
			}
			System.out.println(driver.getCurrentUrl());
		WebElement notif = driver.findElement(By.xpath("//button[@title='Notifications']"));
		clickObj(notif);
		String notifText = driver.findElement(By.xpath("//button[@class='xui-pickitem--body']")).getText();
		System.out.println(notifText);
		System.out.println("I am on notifications");
		
		WebElement srch = driver.findElement(By.xpath("//button[@title='Search']"));
		clickObj(srch);
		WebElement srchBox = driver.findElement(By.xpath("//div/input[@id='queryInput']"));
		enterText(srchBox, "inbox");
		
		WebElement helpQ = driver.findElement(By.xpath("//button[@title='Help']"));
		clickObj(helpQ);
		String expHelpText ="What do you need help with";
		String actualHelpText = driver.findElement(By.xpath("//input[@placeholder='What do you need help with?']")).getText();
		if(expHelpText.equals(actualHelpText))
		{
			System.out.println("TC-3-APassed Whole");
		}
		}
		

	}
}


