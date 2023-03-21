package seleniumpracticepackage;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class FluentWaitPracticeFindBy2 {

	String msg=null;
	//Select combobox_value;
	WebDriver driver;

	@FindBy(id="auth_user_name") WebElement userName;
	@FindBy(id="auth_password") WebElement passWord;
	@FindBy(id="auth_school") WebElement schoolId;
	@FindBy(name="Login") WebElement loginButton;



	@Test

	public void loginMethod()  {
		System.setProperty("webdriver.chrome.driver","C:\\Autamation training\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		driver.get("https://demo.eschool360.in/index.php");
		driver.manage().window().maximize();

		editBox_Util(userName,"User Name","Login Page","admin");
		editBox_Util(passWord,"PassWord","Login Page","admin");
		editBox_Util(schoolId,"School Id","Login Page","1");
		button_menu_click(loginButton, "login Button","login page");
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











}
