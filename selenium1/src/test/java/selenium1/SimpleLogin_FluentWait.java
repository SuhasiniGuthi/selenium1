package selenium1;
import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.StaleElementReferenceException;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.FluentWait;

import org.openqa.selenium.support.ui.Wait;

import org.testng.annotations.Test;



public class SimpleLogin_FluentWait {

	public static By Loginname = By.id("123auth_user_name123");
	public static By password = By.id("auth_password");
	public static By school = By.id("auth_school");
	public static By Login = By.name("Login");

	WebDriver driver;

	//FluentWait_BYClassPgm obj;
	public String  msg =null;

	@Test

	public void demoMethod() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Autamation training\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.eschool360.in/index.php");
		driver.manage().window().maximize();

		// driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

		/* Loginname.findElement(driver).sendKeys("admin");

password.findElement(driver).sendKeys("admin");

school.findElement(driver).sendKeys("1");

Login.findElement(driver).click();

		 */
		editBox_Util( Loginname, "UserName", "Login Page", "admin");
		editBox_Util( password, "PassWord", "Login Page", "admin");
		editBox_Util(school, "School", "Login Page", "1");
		Login.findElement(driver).click();

	}


	public  String elementPresent(By locator, String locatorName, String pageName) {

		// Waiting 30 seconds for an element to be present on the page, checking

		// for its presence once every 5 seconds.

		//WebElement element =(WebElement) locator;

		try {

			Wait<WebDriver> wait =  new FluentWait<WebDriver>(driver)

					//new FluentWait<WebDriver>(driver)

					.withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(StaleElementReferenceException.class);

			//.ignoring(StaleElementReferenceException.class);

			//.until(ExpectedConditions.visibilityOfElementLocated(By.id("auth_user_name")));

			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		} catch (Exception e) {

			// TODO Auto-generated catch block

			//System.out.println(e.getMessage());

			//e.printStackTrace();

			System.out.println("I have entered into catch block");

			//e.printStackTrace();

			msg = "Locator Name:-"+locatorName+" : "+locator+" is not identified in Page : "+pageName;
		}
		return msg;

	}

	public void editBox_Util(By locator, String locatorName, String pageName, String value) {

		System.out.println(driver);
		System.out.println(locator);
		msg = elementPresent(locator, locatorName, pageName);
		if(msg==null) {
			locator.findElement(driver).sendKeys(Keys.chord(Keys.CONTROL,"a"),value);
		}else {
			System.out.println(msg);
		}
	}
	
	
	

}