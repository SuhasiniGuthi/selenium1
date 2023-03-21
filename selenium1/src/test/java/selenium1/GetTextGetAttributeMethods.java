package selenium1;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GetTextGetAttributeMethods  extends ExtentReportClass{


	WebDriver driver;
	SoftAssert softAssert=new SoftAssert();
	String msg;

	@Test
	public void loadURL_Login() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Autamation training\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:\\Automation Project\\chromedriver.exe");

		driver = new ChromeDriver();
		test = extent.createTest("login functionality1Test1(with Assertions)");//Extent Reports
		
		driver.get("https://www.catamilacademy.org/cta/login.aspx");
		Thread.sleep(3000);
		By userEmail=By.id("Txt_Mail_Id");
		By password=By.id("Txt_Password");
		By loginButton=By.name("Btn_Login");
		driver.manage().window().maximize();


		//Profile
		By profileMenu=By.xpath("(//span[contains(text(),'Profile')])[1]");
		By  modifyProfile=By.xpath("//span[contains(text(),'Modify My Profile')]");
		//modify profile page
		By userName_label=By.xpath("//div[contains(@id,'pnl_data')]/table/tbody/tr[2]/td");
		By userNameValue=By.id("Txt_Uname");
		By userEmail_label=By.xpath("(//div[contains(@id,'pnl_data')]/table/tbody/tr[3]/td)[1]");
		By userEmailValue=By.id("Txt_Mailid");
		By street_label=By.xpath("(//div[contains(@id,'pnl_data')]/table/tbody/tr[6]/td)[1]");
		By streetValue=By.id("Txt_Street");
		By city_label=By.xpath("(//div[contains(@id,'pnl_data')]/table/tbody/tr[7]/td)[1]");
		By cityValue=By.id("Txt_City");
		By zipPostalCode_label=By.xpath("(//div[contains(@id,'pnl_data')]/table/tbody/tr[9]/td)[1]");
		By zipCodeValue=By.id("Txt_Zip");
		By phone1_label=By.xpath("(//div[contains(@id,'pnl_data')]/table/tbody/tr[10]/td)[1]/p");
		By phone1Value=By.id("Txt_Phone");
		
		//dropdowns
		By genderValue=By.id("Ddl_Gender");
		By country_StateValue=By.id("Ddl_State");
		By c0lorThemeValue=By.id("ddlcolor");








		editBox_Util(userEmail, "User Name", "Login Page", "joycelins@north.aztamilschools.org");
		editBox_Util(password, "Password","Login Page", "Passw0rd.");


		button_menu_click(loginButton, "Login","Login Page");
		Thread.sleep(6000);


		/*Actions action=new Actions(driver);
		action.moveToElement(modifyProfile.findElement(driver)).perform();
		button_menu_click(modifyProfile, "Modify My Profile", "Home Page");*/

		Actions action=new Actions(driver);
		//WebElement element =driver.findElement(By.xpath("(//span[contains(text(),'Profile')])[1]"));
		action.moveToElement(driver.findElement(By.xpath("(//span[contains(text(),'Profile')])[1]"))).perform();
		driver.findElement(By.xpath("(//span[contains(text(),'Modify My Profile')])[1]")).click();
		Thread.sleep(6000);



		driver.switchTo().frame(driver.findElement(By.id("contentFrame")));
		Thread.sleep(3000);

		verify_GetText(userName_label, "User Name", "User Name Label","Modify My Profile Page under Profile Menu");
		verify_GetAttributeValue(userNameValue, "Suhasini","User Name Value", "Modify My Profile Page under Profile Menu");
		verify_GetText(userEmail_label, "User Email", "User Email Label","Modify My Profile Page under Profile Menu");
		verify_GetAttributeValue(userEmailValue, "JoycelinS@north.aztamilschools.org", "User Name Value","Modify My Profile Page under Profile Menu");
		verify_GetText(street_label, "Street","Street Label","Modify My Profile Page under Profile Menu");
		verify_GetAttributeValue(streetValue, "8", "Street value","Modify My Profile Page under Profile Menu");
		verify_GetText(city_label, "City", "City Label", "Modify My Profile Page under Profile Menu");
		verify_GetAttributeValue(cityValue, "1", "City Value", "Modify My Profile Page under Profile Menu");
		verify_GetText(zipPostalCode_label, "Postal Code","Zip/Postal Code Label","Modify My Profile Page under Profile Menu");
		verify_GetAttributeValue(zipCodeValue, "1", "Zip/Postal Code Value","Modify My Profile Page under Profile Menu");
		verify_GetText(phone1_label, "Phone #1", "Phone1 Label","Modify My Profile Page under Profile Menu");
		verify_GetAttributeValue(phone1Value, "3", "Phone1 Value","Modify My Profile Page under Profile Menu");
		
		
		verify_dropdown(genderValue, "Male", "Gender Value","Modify My Profile Page under Profile Menu");
		verify_dropdown(country_StateValue, "USA - AZ - Arizona", "Country State Value" , "Modify My Profile Page under Profile Menu");
		verify_dropdown(c0lorThemeValue, "Blue", "Color Theme Value","Modify My Profile Page under Profile Menu");




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

	public void button_menu_click(By locator, String locatorName, String pageName) {
		System.out.println(driver);
		System.out.println(locator);
		msg = elementPresent(locator, locatorName, pageName);
		if(msg==null) {
			locator.findElement(driver).click();
		}else {
			System.out.println(msg);
		}
	}

	public void verify_GetAttributeValue(By locator,String expectedValue, String locatorName, String pageName) {

		msg = elementPresent(locator, locatorName, pageName);
		if(msg==null) {
			String actualValue=locator.findElement(driver).getAttribute("value");
			System.out.println("Actual Value:"+actualValue);
			System.out.println("Expected Value:"+expectedValue);
			if(actualValue.equalsIgnoreCase(expectedValue)) {
				System.out.println("actual value is same as expected value");
				softAssert.assertEquals(actualValue, expectedValue, "actual value is same as expected value");
			}else {
				System.out.println("actual value is not equal to expected value");
				
				softAssert.assertEquals(actualValue, expectedValue, "actual value is not equal to expected value");
			}

		}

	}


	public void verify_GetText(By locator,String expectedValue, String locatorName, String pageName) {
		msg = elementPresent(locator, locatorName, pageName);
		if(msg==null) {
			String actualValue=locator.findElement(driver).getText();
			System.out.println(actualValue);
			System.out.println(expectedValue);
			if(actualValue.equalsIgnoreCase(expectedValue)) {
				System.out.println("actual value is same as expected value");

			}else {
				System.out.println("actual value is not equal to expected value");
			}

		}
		
		
		
			
		}
	
	public void verify_dropdown(By locator,String expectedValue, String locatorName, String pageName) {
		msg = elementPresent(locator, locatorName, pageName);
		if(msg==null) {
			
			Select select=new Select(locator.findElement(driver));
			if(select.getFirstSelectedOption().getText().equalsIgnoreCase(expectedValue)) {
				System.out.println("Dropdown value selected is: "+expectedValue);
				
			}else {
				System.out.println("Dropdown value selected is not: "+expectedValue);
			}
			
		}
		
	}


	}






