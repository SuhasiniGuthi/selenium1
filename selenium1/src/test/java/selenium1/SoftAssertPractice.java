package selenium1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertPractice extends ExtentReportClass {
	WebDriver driver;
	SoftAssert softAssert=new SoftAssert();

	@Test
	public void loadURL_Login() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Autamation training\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:\\Automation Project\\chromedriver.exe");

		driver = new ChromeDriver();
		test = extent.createTest("login functionality1Test1(with Assertions)");//Extent Reports

		driver.get("https://www.catamilacademy.org/cta/login.aspx");
		String actualTitle=driver.getTitle();
		Boolean verifyActualTitle=driver.getTitle().equalsIgnoreCase("California Tamil Academy");
		softAssert.assertEquals(actualTitle, "California Tamil Academy");
		softAssert.assertNotEquals(actualTitle, "catamilacademy");
		softAssert.assertNull(verifyActualTitle);
		softAssert.assertNotNull(verifyActualTitle);
		softAssert.assertTrue("catamilacademy".equals("catamilacademy"),"first soft assert failed"); 
		softAssert.assertFalse("catamilacademy".equals("catamilacademy"),"first soft assert failed");
		//softAssert.assertAll();






	}




}
