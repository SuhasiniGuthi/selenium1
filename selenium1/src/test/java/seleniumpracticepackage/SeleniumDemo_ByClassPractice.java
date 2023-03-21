package seleniumpracticepackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SeleniumDemo_ByClassPractice {

	WebDriver driver;
	@Test
	public void loginDemoUrl() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Autamation training\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demo.eschool360.in/index.php");

		By userName=By.id("auth_user_name");
		By password=By.id("auth_password");
		By branchId=By.id("auth_school");
		By loginButton=By.name("Login");

		//   COMMUNICATION button
		By communicationButton=By.xpath("//span[contains(text(),'COMMUNICATION')]");
		By notifications=By.xpath("//a[contains(text(),'Notifications')]");

		//dropdowns under notifications
		By class_notifications=By.id("classid");//class dropdown
		By section_notifications=By.id("sectionid"); //section dropdown
		By datePicker=By.id("datepicker");
		By month=By.xpath("//span[contains(text(),'February')]");
		
			//SMS message master
		By sms_messageMaster=By.xpath("//a[contains(text(),'SMS Message Master')]");
			//send voice message
		By sendVoiceMessage=By.xpath("//a[contains(text(),'Send Voice Message')]");
		By voiceMsgToBeSent=By.id("voice_sms");
		By fromDataBase=By.id("SMS_receiver_group");
		By sectionDB=By.id("db_sectionid");
		By mobileNumber=By.id("test_SMS_mobile_numbers");
		By sendMessage=By.xpath("/html/body/form/table/tbody/tr[5]/td/input");
		
		
		





		userName.findElement(driver).sendKeys("admin");
		password.findElement(driver).sendKeys("admin");
		branchId.findElement(driver).sendKeys("1");
		loginButton.findElement(driver).click();
		driver.manage().window().maximize();
		Thread.sleep(3000);


		communicationButton.findElement(driver).click();
		notifications.findElement(driver).click();
		
		
		driver.switchTo().frame(1);

		//To access dropdowns

		Select combobox_notifications;

		class_notifications.findElement(driver).click();
		combobox_notifications=new Select(class_notifications.findElement(driver));
		combobox_notifications.selectByIndex(3);

		section_notifications.findElement(driver).click();
		combobox_notifications=new Select(section_notifications.findElement(driver));
		combobox_notifications.selectByIndex(0);
		datePicker.findElement(driver).click();
		//month.findElement(driver).getText();
		
		
		
		driver.switchTo().defaultContent();
		
		
		sms_messageMaster.findElement(driver).click();
		Thread.sleep(3000);
		sendVoiceMessage.findElement(driver).click();
		driver.switchTo().frame(1);
		Thread.sleep(3000);
		
		Select combobox_voicemsg;
		
		voiceMsgToBeSent.findElement(driver).click();
		combobox_voicemsg=new Select(voiceMsgToBeSent.findElement(driver));
		combobox_voicemsg.selectByIndex(7);
		
		fromDataBase.findElement(driver).click();
		combobox_voicemsg=new Select(fromDataBase.findElement(driver));
		combobox_voicemsg.selectByIndex(7);
		
		sectionDB.findElement(driver).click();
		combobox_voicemsg=new Select(sectionDB.findElement(driver));
		combobox_voicemsg.selectByIndex(2);
		
		mobileNumber.findElement(driver).sendKeys("9247356514");
		sendMessage.findElement(driver).click();








	}





}
