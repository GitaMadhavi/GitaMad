package com.training.jan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TermsAndConditons extends ReusableFunction {

	public static void main(String[] args) throws InterruptedException {

		initializeBrows();
		launchUrl("https://www.xero.com/us/");
		WebElement freeTrial = driver.findElement(By.xpath("//ul//a[contains(text(),'Free trial')]"));
		clickObj(freeTrial);
		Thread.sleep(4000);
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		WebElement termsOfUse = driver.findElement(By.xpath("//a[contains(text(),'terms of use')]"));
		clickObj(termsOfUse);
		//String newUrlOpen = driver.getCurrentUrl();
		//System.out.println(newUrlOpen);
		String titlePage = driver.getTitle();
		String exp = "Terms Of Use";
		if(titlePage.equals(exp)){
			System.out.println("TC passed");
		}
		System.out.println(titlePage);
		driver.navigate().to(actualUrl);
		Thread.sleep(3000);
		WebElement privateNotice = driver.findElement(By.xpath("//a[contains(text(),'privacy notice')]"));
		clickObj(privateNotice);
		String titPage = driver.getTitle();
		System.out.println(titlePage);
		String expected = "Privacy notice";
		if(titPage.equals(expected)){
			System.out.println("TC -02-C passed Whole");
		}
		driver.navigate().to(actualUrl);
		WebElement offerDetails =driver.findElement(By.xpath("//a[contains(text(),'offer details')]"));
		clickObj(offerDetails);
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		String expectedTitle = "Offer details";
		if(pageTitle.equals(expectedTitle)){
			System.out.println("TC -02-D passed ");

		}
		driver.navigate().to(actualUrl);
		WebElement accBookKeeper =driver.findElement(By.xpath("//a[contains(text(),'accountant or bookkeeper')]"));
		clickObj(accBookKeeper);
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
		String accPageTitle = driver.getTitle();
		System.out.println(accPageTitle);
		String expectedTitleAcc = "Offer details";
		if(titPage.equals(expectedTitleAcc)){
			System.out.println("TC -02-E passed ");

			driver.close();
		}

		}

	}
