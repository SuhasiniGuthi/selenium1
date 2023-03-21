package selenium1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotEqualsDeep;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssertPracticeProgram extends ExtentReportClass {

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
		//System.out.println(driver.getTitle());
		String ActualTitle=driver.getTitle();//ActualTitle=California Tamil Academy
		String verifyAssertNull=null;
		String ExpectedTitle="California Tamil Academy";
		Boolean verifyTitleIsPresent=driver.getTitle().equalsIgnoreCase("California Tamil Academy");//true
		Boolean verifyTitleIsChanged=driver.getTitle().equalsIgnoreCase("School");//False
		assertEquals(ActualTitle, ExpectedTitle);
		assertNotEquals(ExpectedTitle, "catamilacademy");
		assertTrue(verifyTitleIsPresent);
		assertFalse(verifyTitleIsChanged);
		assertNotNull(verifyTitleIsPresent);
		assertNull(verifyAssertNull);


		Thread.sleep(3000);
		/*By userEmail=By.id("Txt_Mail_Id");
		By password=By.id("Txt_Password");
		By loginButton=By.name("Btn_Login");*/
		driver.manage().window().maximize();
	}


}
