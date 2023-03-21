package seleniumpracticepackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumDemoPractice1 {
	
	WebDriver driver;
	
	@Test
	public void loginMethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Autamation training\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		/*driver.get("https://demo.eschool360.in/index.php");
		driver.findElement(By.id("auth_user_name")).sendKeys("admin");
		driver.findElement(By.id("auth_password")).sendKeys("admin");
		driver.findElement(By.id("auth_school")).sendKeys("1");
		driver.findElement(By.name("Login")).click();
		driver.manage().window().maximize();*/
		//driver.close();
		
		//***GMail
		
		driver.get("https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=1209600&osid=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F%3Ftab%3Drm%26ogbl&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F%3Ftab%3Drm%26ogbl&emr=1&ifkv=AWnogHchkz4b7kph62Ui8g1aeQ9hulGd8MtVGiJc4y3IymU2upQz_8tcOjBKdQQN7x7DAChdqDY7&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.findElement(By.id("identifierId")).sendKeys("guthi.suhasini@cmrec.ac.in");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		
		driver.findElement(By.name("password")).sendKeys("cmrec@1234");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		
		
		
		
		/*driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("suhasini.guthi@gamil.com");
		driver.findElement(By.id("pass")).sendKeys("gsmano");
		driver.findElement(By.name("login")).click();
		driver.manage().window().maximize();*/
		//driver.close();
	}
	
	
	 

}
