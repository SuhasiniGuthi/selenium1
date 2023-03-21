package selenium1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class PracticePageProgram {
	WebDriver driver;
	String msg=null;


	@Test
	public void practiceDemoUrl3() throws InterruptedException {

		//System.setProperty("webdriver.chrome.driver", "C:\\Autamation training\\chromedriver_win32 (1)\\chromedriver.exe");
		//driver = new ChromeDriver();
		
		System.setProperty("webdriver.edge.driver", "C:\\Autamation training\\edgedriver_win32\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get("https://courses.letskodeit.com/practice");
		driver.manage().window().maximize();
		Thread.sleep(3000);


		//By radioButton_bmw=By.xpath("//div[contains(@id,'radio-btn-example')]/fieldset/label[1]");//Radio Button
		//By checkBox_benz=By.xpath("//div[contains(@id,'checkbox-example-div')]/fieldset/label[2]"); //check box
		//By dropdown=By.id("carselect");


		//verify_dropdown(dropdown, "BMW", "DROPDOWN", "Dropdown under Home Page");

		driver.findElement(By.xpath("//div[contains(@id,'checkbox-example-div')]/fieldset/label[3]")).click();
		driver.findElement(By.xpath("//div[contains(@id,'radio-btn-example')]/fieldset/label[1]")).click();

		Actions action=new Actions(driver);
		//WebElement mousehoverButton=driver.findElement(By.id("mousehover"));
		action.moveToElement(driver.findElement(By.id("mousehover"))).perform();
		driver.findElement(By.xpath("//a[contains(text(),'Reload')]")).click();

		//checking check box

		String expectedValue="true";
		boolean actualValue=driver.findElement(By.id("hondacheck")).isSelected();
		boolean expectValue=Boolean.parseBoolean(expectedValue);
		if(expectValue==true && actualValue==false) {
			driver.findElement(By.id("hondacheck")).click();
			System.out.println("Check Box not checked then click");

		}else {
			System.out.println("check box already checked");
		}

		//checking radio buttons

		String expectedValue1="true";
		boolean actualValue1=driver.findElement(By.id("benzradio")).isSelected();
		boolean expectValue1=Boolean.parseBoolean(expectedValue);
		if(expectValue==true && actualValue==false) {
			driver.findElement(By.id("benzradio")).click();
			System.out.println("Radio button not click previously now click");

		}else {
			System.out.println("Radio button already click");
		}

		//get selected value from dropdown

		String dropdownSelectedValue="Benz";
		Select select=new Select(driver.findElement(By.id("carselect")));
		if(select.getFirstSelectedOption().getText().equalsIgnoreCase(dropdownSelectedValue)) {
			System.out.println("Dropdown value selected is: "+dropdownSelectedValue);

		}else {
			System.out.println("Dropdown value selected is not: "+dropdownSelectedValue);


		}


	}



	/*public  String elementPresent(By locator, String locatorName, String pageName) {

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

			}else {
				System.out.println("actual value is not equal to expected value");

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

		}*/

}



