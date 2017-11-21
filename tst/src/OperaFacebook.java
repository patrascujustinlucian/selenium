import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class OperaFacebook {
	
	static String URL ="https://www.facebook.com";
	static String LinkYT="https://www.youtube.com/watch?v=-IyNtz21KQY";
	
	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.opera.driver","F://operadriver.exe");
		
		OperaOptions operaoptions=new OperaOptions();
		operaoptions.setBinary("C://Program Files//Opera_x64//opera.exe");
		
		DesiredCapabilities cap = DesiredCapabilities.operaBlink();
        cap.setCapability("webdriver.opera.driver","f://operadriver.exe");
        cap.setCapability("opera.binary","C://Program Files//Opera_x64//opera.exe");
        
		WebDriver driver = new OperaDriver(operaoptions);

		driver.navigate().to(URL);
		driver.manage().window().maximize();
		Thread.sleep(3000);	
		
	
		
	}
	private static void postOnGroup(WebDriver driver,String group, String emotic) throws InterruptedException {
		Thread.sleep(2000);	
		driver.navigate().to(group);
		Thread.sleep(3000);	
		/*if (isAlertPresent(driver)) {
		    driver.switchTo().alert();
		    driver.switchTo().alert().accept();
		    driver.switchTo().defaultContent();
		}*/
		driver.findElement(By.name("xhpc_message_text")).sendKeys(emotic+" " +LinkYT+"\n");
		Thread.sleep(3000);	
		//driver.findElement(By.xpath("//*[@id='js_48']/div[1]/div/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div/div")).click();
		//driver.findElement(By.name("textarea")).sendKeys(LinkYT);
		//driver.findElement(By.xpath("//button[@type='submit']//span[contains(text(),'Post')]")).sendKeys("\n");
		WebElement elem = driver.findElement(By.xpath("//button[@type='submit']//span[contains(text(),'Postează')]"));
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,340)","");
		Actions actions = new Actions(driver);
		Thread.sleep(2000);
		actions.moveToElement(elem).click().perform();
		//WebDriverWait wait = new WebDriverWait(driver, 5);
		//wait.until(ExpectedConditions.elementToBeClickable(elem));
		
		
		
	}
	public static void postOnGroupSell(WebDriver driver,String group, String emotic) throws Exception{
		Thread.sleep(2000);	
		driver.navigate().to(group);
		Thread.sleep(6000);	
		
		driver.findElement(By.xpath("//label//input[@type='text'][@class='_58al']")).click();   //merge
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//span//span[@class='_5qtp'][text()='Începe o discuţie']")).click();  //merge
		Thread.sleep(2000);	

		WebElement elem2=driver.findElement(By.xpath("//div[@class='_1mf _1mj']/span"));
		Thread.sleep(3000);	
		Actions actions = new Actions(driver);
		Thread.sleep(2000);
		actions.moveToElement(elem2).click().sendKeys(emotic+" " +LinkYT+"\n").perform();
		Thread.sleep(4000);
		((JavascriptExecutor)driver).executeScript("scroll(0,340)");
	 
		WebElement elem = driver.findElement(By.xpath("//button[@type='submit']//span[contains(text(),'Postează')]"));
		Thread.sleep(2000);
		actions.moveToElement(elem).click().perform();
	}
	public static void LoginFB(WebDriver driver, String username, String pass) throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("username");
		driver.findElement(By.id("pass")).sendKeys("pass");
		driver.findElement(By.id("loginbutton")).click();
	}


}
