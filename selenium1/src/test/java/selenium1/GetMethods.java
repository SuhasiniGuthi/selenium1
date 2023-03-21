package selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class GetMethods {
	
	
	WebDriver driver;

	@Test
	public void loadURL_Login() throws InterruptedException {

	System.setProperty("webdriver.chrome.driver", "C:\\Autamation training\\chromedriver_win32\\chromedriver.exe");
	//System.setProperty("webdriver.chrome.driver", "C:\\Automation Project\\chromedriver.exe");

	driver = new ChromeDriver();
	driver.get("https://www.catamilacademy.org/cta/login.aspx");
	Thread.sleep(3000);

	driver.findElement(By.id("Txt_Mail_Id")).sendKeys("joycelins@north.aztamilschools.org");
	driver.findElement(By.id("Txt_Password")).sendKeys("Passw0rd.");
	driver.findElement(By.name("Btn_Login")).click();
	Thread.sleep(3000);

	Actions action=new Actions(driver);
	//WebElement element =driver.findElement(By.xpath("(//span[contains(text(),'Profile')])[1]"));
	action.moveToElement(driver.findElement(By.xpath("(//span[contains(text(),'Profile')])[1]"))).perform();
	driver.findElement(By.xpath("(//span[contains(text(),'Modify My Profile')])[1]")).click();


	Thread.sleep(6000);

	driver.switchTo().frame(driver.findElement(By.id("contentFrame")));
	Thread.sleep(3000);

	String expected_Result = "User Name";

	String var = driver.findElement(By.xpath("//div[contains(@id,'pnl_data')]/table/tbody/tr[2]/td")).getText();
	System.out.println(var);

	if(expected_Result.equalsIgnoreCase(var)) {
	System.out.println("Expectd and Actual values are same");
	}else {
	System.out.println("Expectd and Actual values are not same");
	}
	
	String expected_Result1 ="User Email";
	
	String var1 = driver.findElement(By.xpath("//div[contains(@id,'pnl_data')]/table/tbody/tr[3]/td")).getText();
	System.out.println(var1);
	
	if(expected_Result1.equalsIgnoreCase(var1)) {
		System.out.println("Expectd and Actual values are same");
		}else {
		System.out.println("Expectd and Actual values are not same");
		}
	
	


	expected_Result = "Joycelins123";
	String userNameValue = driver.findElement(By.id("Txt_Uname")).getAttribute("value");
	System.out.println(userNameValue);

	if(expected_Result.equalsIgnoreCase(userNameValue)) {
	System.out.println("Expectd and Actual values are same");
	}else {
	System.out.println("Expectd and Actual values are not same");
	}

	}
	
	expected_Result1 = "Joycelins123@gmail.com";
	String userEmailValue = driver.findElement(By.id("Txt_Mailid")).getAttribute("value");
	System.out.println(userEmailValue);

	if(expected_Result.equalsIgnoreCase(userNameValue)) {
	System.out.println("Expectd and Actual values are same");
	}else {
	System.out.println("Expectd and Actual values are not same");
	}

	}
	
	
	

}
