package cucumberSelenium.cucumberSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class steps {
	static WebDriver driver;
	@Given("^user has launched the browser$")
	public void user_has_launched_the_browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gitam\\javaSeleniumWd\\Automation\\drivers\\chromedriver\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("https://login.salesforce.com/");
	   System.out.println("LOgged in SFDC Application");
	    
	}

	@When("^user enters login details$")
	public void user_navigates_to_Login_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    WebElement usrname = driver.findElement(By.xpath("//input[@id ='username']"));
	               usrname.sendKeys("mmadhavi1022@gmail.com");
	               
	               WebElement pwd = driver.findElement(By.xpath("//input[@type ='password']"));
	               pwd.sendKeys("BHU1van2!");
	               System.out.println("Entered username and password ");
	}

	@When("^user clicks Submit$")
	public void user_clicks_Submit() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  driver.findElement(By.xpath("//input[@type ='submit']")).click();
	}

	@Then("^user is logged into SFDC$")
	public void success_message_is_displayed_Title_of_your_feature() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println(driver.getCurrentUrl());
	   
	}
	

@Given("^user clicked Submit$")
public void user_clicked_Submit() throws Throwable {
   System.out.println("browser is loading");
    
}

@When("^user sees pop up$")
public void user_sees_pop_up() throws Throwable {
    System.out.println("user sees a pop up window");
    Thread.sleep(5000);
    
}

@And("^user clicks the close dialogue$")
public void user_clicks_the_close_dialogue() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   WebElement closeDialogue = driver.findElement(By.xpath("//div/a[@class ='dialogClose']"));
   closeDialogue.click();
   Thread.sleep(5000);
   driver.manage().window().maximize();
   
}

@Then("^user is logged into sfdc$")
public void user_is_logged_into_sfdc() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    System.out.println("logged in Successfully");
   
    driver.close();
    
}



}
