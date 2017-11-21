import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromeFacebook {

	static String URL ="https://www.facebook.com";
	static String LinkYT="https://www.youtube.com/watch?v=ulbdFwQqBng";
	
	public static void main(String[] args) throws Exception {
		Date date=new Date();
		SimpleDateFormat df=new SimpleDateFormat("dd MMM yyyy hh:mm:ss ");
		System.out.println("started posting at: "+ df.format(date));
		
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
		  ChromeDriverService chSvc = new ChromeDriverService.Builder().usingDriverExecutable(new File("F:\\chromedriver.exe")).usingAnyFreePort().build(); 
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		//options.addArguments("C:\\Users\\lucian.patrascu\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
		//options.addArguments("--start-maximized");
		
	
		WebDriver driver=new ChromeDriver(options);//(options);
		DesiredCapabilities Capability= DesiredCapabilities.chrome();

		
		driver.navigate().to(URL);
		driver.manage().window().maximize();
		Thread.sleep(3000);	
		
		driver.findElement(By.id("email")).sendKeys("cineva1234567891011@yahoo.com");
		driver.findElement(By.id("pass")).sendKeys("1234rapmananan333333333444");
		driver.findElement(By.id("loginbutton")).click();
		Thread.sleep(6000);	
		
		if (isAlertPresent(driver)) {
		    driver.switchTo().alert();
		    driver.switchTo().alert().accept();
		    driver.switchTo().defaultContent();
		}
		
		//driver.navigate().to("https://www.facebook.com/groups/felicitari/");
		/*try {
			driver.findElement(By.xpath("//*[@id='facebook']/body/div[15]/div[2]/div/div/div/div/div[3]/div/div/div[2]/div/a[1]")).click();
		} catch (Exception e) {
			System.out.println("nu apare");
			e.printStackTrace();
		}  //am gasit xpath cu copy xpath din inspect
		postOnGroupSell(driver,"https://www.facebook.com/groups/grupregie/",":D ghiciti cine e");
		
		/*postOnGroup(driver,"https://www.facebook.com/groups/felicitari/",":)) >");  
		Thread.sleep(3000);	
		
		/*try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver.switchTo().alert();
	        alert.accept();
	        driver.switchTo().defaultContent();
		 } catch (Exception e) { System.out.println("nope");
		    } */  
	
		//postOnGroupSell(driver,"https://www.facebook.com/groups/1178427015505428/",":l cele mai in voga vedete  "); cere approval
		//Thread.sleep(3000);	
		//postOnGroupSell(driver,"https://www.facebook.com/groups/423970747648809/",":) > vedetele noastre favorite!");  continut indisponibil
		//Thread.sleep(3000);	
		postOnGroup(driver,"https://www.facebook.com/groups/RaziSiTu/",":) >ca vedetele");
		Thread.sleep(3000);	
		postOnGroupSell(driver,"https://www.facebook.com/groups/grupregie/",":o > ca vedetele "); 
	    Thread.sleep(3000);	
		//postOnGroup(driver,"https://www.facebook.com/groups/fete.si.femei/",":d mori de ras");  nu mai puteam scrie
		//Thread.sleep(3000);	
		//postOnGroup(driver,"https://www.facebook.com/groups/761454627199977/",">>:)");  need admin aproval
		postOnGroup(driver,"https://www.facebook.com/groups/1072784789444357/",":d :> cele mai cool vedete");
		Thread.sleep(3000);	
		postOnGroup(driver,"https://www.facebook.com/groups/113323502127997/",":d  > Carlas's si Bendeac isi fac de cap");
		Thread.sleep(3000);	
		postOnGroupSell(driver,"https://www.facebook.com/groups/779527135451202/",":o > ca vedetele"); 
	    Thread.sleep(3000);	
	    postOnGroup(driver,"https://www.facebook.com/groups/1419778744996586/",":d > vedetele noastre favorite!");
		Thread.sleep(3000);	
		postOnGroup(driver,"https://www.facebook.com/groups/354287228044384/",":) > ca vedetele :)");
		Thread.sleep(3000);	
		postOnGroupSell(driver,"https://www.facebook.com/groups/Romani.UK/",":o  o > Carlas's si Bendeac isi fac de cap "); 
	    Thread.sleep(3000);	
	    
		driver.quit();
		
		Date date2= new Date();
		System.out.println("finished posting on FB at: "+ df.format(date2));
		
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
	public static boolean isAlertPresent(WebDriver driver) {
	    try {
	        driver.switchTo().alert();
	        return true;
	    } // try
	    catch (Exception e) {
	        return false;
	    } // catch
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
	
}
