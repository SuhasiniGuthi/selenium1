package seleniumpracticepackage;
import org.testng.Assert;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import selenium1.ExtentReportClass;
@Listeners(selenium1.TestNGListerners.class)
public class FindByPractice_DemoUrl2 extends ExtentReportClass {
	WebDriver driver;
	String msg=null;
	Select combobox_Value;
	
	
	@FindBy(xpath = "//a[contains(text(),'flights')]") WebElement flights_Menu;
	@FindBy(xpath =  "//a[contains(text(),'flights')]") WebElement   hotels_Menu;
	@FindBy(id="languages")WebElement english_visa;
	
	
	@Test
	public void exampleUrl_FluentWait_FindBy() {
		System.setProperty("webdriver.chrome.driver", "C:\\Autamation training\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		test = extent.createTest("Login Method");
		driver.get("https://phptravels.net/");
		driver.manage().window().maximize();
		
		//button_menu_click(flights_Menu, "Flights Menu", "Home Page");
		//button_menu_click(hotels_Menu, "Hotels Menu","Home Page" );
		//driver.findElement(By.xpath("//a[contains(text(),'flights')]")).click();
		//dropdown_select(english_visa, "English Dropdown", "Home Page", 3);
		
		
	}
	
	
	public  String elementPresent(WebElement element, String locatorName, String pageName) {
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
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println(e.getMessage());
			//e.printStackTrace();
			System.out.println("I have entered into catch block");
			//e.printStackTrace();
			msg = "Locator Name:-"+locatorName+" : "+element+" is not identified in Page : "+pageName;

		}

		return msg;

	}

	public void editBox_Util(WebElement userName, String locatorName, String pageName,String value) {
		System.out.println(driver);
		System.out.println(userName);
		msg=elementPresent(userName,locatorName, pageName);
		if(msg==null) {
			userName.sendKeys(Keys.chord(Keys.CONTROL,"a"),value);

		}else {
			System.out.println(msg);
		}
	}

	public void button_menu_click(WebElement locator,String locatorName,String pageName) {
		System.out.println(driver);
		System.out.println(locator);
		msg=elementPresent(locator,locatorName,pageName);
		if(msg==null) {
			locator.click();

		}else {
			System.out.println(msg);
		}

	}
	
	public void dropdown_select(WebElement  locator,String locatorName,String pageName,int value) {
		System.out.println(driver);
		System.out.println(locator);
		if(msg==null) {
			locator.click();
			combobox_Value=new Select((WebElement) locator);
			combobox_Value.selectByIndex(value);

		}else {
			System.out.println(msg);
		}

	}

	
	
	
	
	
	

}
