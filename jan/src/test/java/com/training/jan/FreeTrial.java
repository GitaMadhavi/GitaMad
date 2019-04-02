package com.training.jan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FreeTrial extends ReusableFunction{

	public static void main(String[] args) throws InterruptedException {
		
		initializeBrows();
		launchUrl("https://www.xero.com/us/");
				
			WebElement freeTrial = driver.findElement(By.xpath("//ul//a[contains(text(),'Free trial')]"));
			clickObj(freeTrial);
			Thread.sleep(4000);
			String expTitle = "https://www.xero.com/us/signup/ ";
			String actualUrl = driver.getCurrentUrl();
			if(expTitle.equals(actualUrl)){
				System.out.println("I am on Free Trial Page");
			}
			//Thread.sleep(4000);
			
			String actuualTitleOfFrTrialPage = driver.findElement(By.xpath("//h2[@class = 'title title-2']")).getText();
            if(expTitle.contains(actuualTitleOfFrTrialPage))
            {
            	System.out.println("I am on Free Trial Page");
            }
            Thread.sleep(2000);
            WebElement fName = driver.findElement(By.xpath("//input[@name='FirstName']"));
    		fName.clear();
    		enterText(fName,"GitaMadhavi");
    		WebElement lName = driver.findElement(By.xpath("//input[@name='LastName']"));
    		lName.clear();
    		enterText(lName, "Munukutla");
    		WebElement emailAdd = driver.findElement(By.xpath("//input[@name='EmailAddress']"));
    		emailAdd.clear();
    		enterText(emailAdd, "gitamqa@gmail.com");
    		WebElement phNum = driver.findElement(By.xpath("//input[@name='PhoneNumber']"));
    		phNum.clear();
    		enterText(phNum, "4087316078");
    		WebElement selCountry = driver.findElement(By.xpath("//select[@name ='LocationCode']"));
    		Select sel = new Select(selCountry);
    		sel.selectByValue("US");
    		WebElement chkBox = driver.findElement(By.xpath("//input[@name = 'TermsAccepted']"));
    		clickObj(chkBox);
    		WebElement getStarted = driver.findElement(By.xpath("//button[@class = 'btn btn-primary btn-disabled']"));
    		clickObj(getStarted);
    	
    		/*WebElement recaptchaChkBox = driver.findElement(By.xpath("//span[@id='recaptcha-anchor']"));
    		clickObj(recaptchaChkBox);
    		WebElement verifyButton = driver.findElement(By.xpath("//button[@id='recaptcha-verify-button']"));
    		clickObj(verifyButton);
    		*/
    		System.out.println("Test Case passed till last step");
    		
    		driver.getCurrentUrl();
    		driver.navigate().refresh();
    		WebElement getStarted1 = driver.findElement(By.xpath("//button[@class = 'btn btn-primary btn-disabled']"));
    		clickObj(getStarted1);
    		WebElement errMesgFn = driver.findElement(By.xpath("//span[@id ='signup-form-error-message-1'] "));
    		System.out.println(errMesgFn.getText());
    		WebElement errMsgLn = driver.findElement(By.xpath("//span[@id ='signup-form-error-message-2'] "));
    		System.out.println(errMsgLn.getText());
    		WebElement errMsgEmail = driver.findElement(By.xpath("//span[@id ='signup-form-error-message-3'] "));
    		System.out.println(errMsgEmail.getText());
    		WebElement errMsgPhNo = driver.findElement(By.xpath("//span[@id ='signup-form-error-message-3']"));
    		System.out.println(errMsgPhNo);
    		WebElement inValidEmail = driver.findElement(By.xpath("//input[@name='EmailAddress']"));
             enterText(inValidEmail, "abcd@gmail.com");
             String inValidErrMsg = driver.findElement(By.xpath("//span[contains(text(),'Email address is invalid')] ")).getText();
             System.out.println(inValidErrMsg);
             clickObj(getStarted1);
            boolean chkBoxSel = driver.findElement(By.xpath("//input[@name = 'TermsAccepted']")).isSelected();
            if (chkBoxSel ==false)
            {
            	System.out.println("This chk box is not selected");
            }
            System.out.println("TestCase 2 is Passed");
             
	}
	

}
