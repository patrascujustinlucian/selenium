

import java.util.concurrent.TimeUnit;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;


public class firefox_test {
	
	WebDriver driver = new FirefoxDriver();
	String url="https://www.youtube.com/watch?v=0OP1Fg50C9M";
	//WebDriverWait wait= new WebDriverWait(driver, 2000);
	
	@Test (priority = 1)
	public void ceva(){
		System.setProperty("webdriver.firefox.driver", "F://soft/geckodriver-v0.18.0-win64./geckodriver.exe");
	
	
	//System.setProperty("webdriver.firefox.driver", "F://geckodriver.exe");
	}
	
	@Test (dependsOnMethods="ceva", priority=2)
	public void before(){
		
		
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.navigate().to("http://10.16.8.64:81"); 
		driver.manage().window().maximize();
		
	}
	@Test (priority = 3)
	  public void contactform() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		
		//driver.findElement(By.xpath("//div[2]/a"));
		driver.get("http://10.16.8.64:81/Account/Login");
		   //clickLinkByHrefs("Login");
		//driver.findElement(By.linkText("Autentificare"));
		//wait.until(visibilityOfElementLocated(By.linkText("Autentificare"))).click();

		//driver.findElement(By.tagName("a")).click();
		//WebElement elem = driver.findElement(By.partialLinkText("Autentificare"));
		//new WebDriverWait(driver, 2000).until(ExpectedConditions.visibilityOf(elem));
		 // elem.click();
		//clickLinkByHref("a", 1);
}
	
	
	@Test (dependsOnMethods="contactform", priority=4)
	public void insertDetails() throws InterruptedException{
		Thread.sleep(2000);
		//driver.findElement(By.xpath("/input[@id,'UserName']")).sendKeys("contact@euroofficeinvest.ro");
		driver.findElement(By.id("Password")).sendKeys("1234%Asd");
		driver.findElement(By.id("UserName")).sendKeys("contact@euroofficeinvest.ro");
		WebElement elem = driver.findElement(By.xpath(".//*[@id='loginForm']/div/form/div[3]/div[2]/button"));
		elem.click();
	}
 
	
	//@Test	
 	//public void close(){
	//	driver.close();
	 
	@Test(priority=5)
	public void AccesProiecte() throws InterruptedException{
		Thread.sleep(2000); 
		driver.get("http://10.16.8.64:81/Proiect");
		//WebElement elem2 = driver.findElement(By. 
		//clickLinkByHref("proiect",2);
	}
	
	
	@Test(priority=6)
	public void declaratieEsalonare() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Declara")).click();
		Thread.sleep(3000);
		//driver.findElement(By.partialLinkText("Detalii")).click();
		driver.get("http://10.16.8.64:81/DeclaratieEsalonare/10");
		
	}
	
	@Test(priority=7)
	public void butonIncarca() throws InterruptedException{
		Thread.sleep(3000);
		boolean a = driver.findElement(By.name("DeclaratieEsalonare")).isEnabled();
		System.out.println(a);
		//WebDriverWait wait = new WebDriverWait(driver, 120);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnIncarcaDeclaratieEsalonare']")));
		/*WebElement elem3=*/
		//driver.findElement(By.xpath("//*[@id='btnIncarcaDeclaratieEsalonare']")).sendKeys("C:\\AP_0.1_declaratie_de_esalonare_sM_4.3_var3rectt.pdf");
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click();", elem3);
		//elem3.sendKeys("C://Users/lucian.patrascu/Desktop/afir/PDF-uri Acceptanta noi/modif 9.1/9.1 grupsiretu/AP1.2.3sM9.1var1.pdf");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id='btnIncarcaDeclaratieEsalonareScan']")).sendKeys("c:\\AP_1.1_cerere_de_plata_transa1sM_4.3_var2.pdf");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='btnIncarcaDeclaratieEsalonareMemoriu']")).sendKeys("c:\\AP_1.1_cerere_de_plata_transa1sM_4.3_var22.pdf");
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Transmite")).click();
	}
	
	

public void clickLinkByHref(String href, int position) {
        List<WebElement> anchors = driver.findElements(By.tagName("a"));
        Iterator<WebElement> i = anchors.iterator();
 
        int j = 0;
        while(i.hasNext()) {
            WebElement anchor = i.next();
 
            if(anchor.getAttribute("href").contains(href)) {
                j++;
            }
 
            if(anchor.getAttribute("href").contains(href)
                    && j == position) {
                anchor.click();
                break;
            }
        }
}
public void clickLinkByHrefs(String href) {
    List<WebElement> anchors = driver.findElements(By.tagName("a"));
    Iterator<WebElement> i = anchors.iterator();

    while(i.hasNext()) {
        WebElement anchor = i.next();
        if(anchor.getAttribute("href").contains(href)) {
            anchor.click();
            break;
        }
    }
}


}