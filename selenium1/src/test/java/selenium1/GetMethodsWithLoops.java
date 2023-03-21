package selenium1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class GetMethodsWithLoops {
	
	
	WebDriver driver;
	public String  msg =null;
	Select combobox_Value;
	@Test

	public void loginMethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Autamation training\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.eschool360.in/index.php");

		By userName=By.id("auth_user_name");
		By passWord=By.id("auth_password");
		By schoolId=By.id("auth_school");
		By loginButton=By.name("Login");
		
		//Exams
				By examsButton=By.xpath("//span[contains(text(),'EXAMS')]");
				By exams_marksEntries=By.xpath("//a[contains(text(),'Marks Entries')]");
				//dropdown
				By marksEntries1=By.id("class_name");
				By marksEntries2=By.id("section_id");
				By marksEntries3=By.id("exam_main_type_id_for_exam_name_combo");
				By marksEntries4=By.id("exam_type_id_for_exam_type_combo");
				
				
				editBox_Util(userName, "User Name", "Login Page", "admin");
				editBox_Util(passWord, "Password","Login Page","admin");
				editBox_Util(schoolId, "School Id","Login Page","1");
				button_menu_click(loginButton, "Login Button", "Login Page");
				driver.manage().window().maximize();
				Thread.sleep(3000);
				
				button_menu_click(examsButton, "Exams Button", "Exams Menu Page");
				button_menu_click(exams_marksEntries, "Marks Entries", "Marks Entries under Exams Menu");
				driver.switchTo().frame(1);
				
				dropdown_select(marksEntries1, "Marks Entries1", "Marks Entries Page under Exams Menu", 3);
				dropdown_select(marksEntries2, "Marks Entries2", "Marks Entries Page under Exams Menu", 1);
				dropdown_select(marksEntries3, "Marks Entries3", "Marks Entries Page under Exams Menu", 1);
				dropdown_select(marksEntries4, "Marks Entries4", "Marks Entries Page under Exams Menu", 1);
				
				
				
				
				
				
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

	public void dropdown_select(By locator, String locatorName, String pageName,int value ) {
		System.out.println(driver);
		System.out.println(locator);
		msg = elementPresent(locator, locatorName, pageName);
		if(msg==null) {
			locator.findElement(driver).click();
			combobox_Value=new Select(locator.findElement(driver));
			combobox_Value.selectByIndex(value);
		}else {
			System.out.println(msg);
		}

	}




}
