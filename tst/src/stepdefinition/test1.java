package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class test1 {


	WebDriver driver=new ChromeDriver();
	
	@Given("open firefox and start app")
	public void open_firefox_and_start_app(){
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
		System.out.println("worked");
	}

	@When("enter details")
	public void enter_details(){
		driver.navigate().to("hi5.com");
	}
	@Then("login happens")
	public void login(){
		driver.findElement(By.xpath("//input[@id='signInBtn'][@tabindex='3']"));
	}

}
