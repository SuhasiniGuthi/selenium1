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

public class Selenium_GetOutput {

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

		//Staff
		By staffButton=By.xpath("//span[contains(text(),'STAFF')]");
		By teachers_staff=By.xpath("(//a[contains(text(),'Teachers')])[2]");
		By new_TeacherMaster=By.id("newicon");
		//By teacherMaster_SINo=By.name("txt_NYslno");
		By teacherMaster_SINo=By.xpath("//*[@id='TRXslno']/td[1]");
		By teacherMaster_TeacherId=By.id("txt_AYidentityid");
		By teacherMaster_FirstName=By.id("txt_AYfirstname");
		By teacherMaster_MiddleName=By.id("txt_ANmiddlename");
		By teacherMaster_LastName=By.id("txt_ANlastname");
		By teacherMaster_DateOfBirth=By.name("txd_ANdateofbirth");
		By techerMaster_Gender=By.id("cmb_AYgender");
		By teacherMaster_Qualification=By.id("txt_AYqualification");
		By teacherMaster_Designation=By.id("txt_AYdesignation");
		By TeacherMaster_TeachingSubjects=By.id("10");
		By TeacherMaster_SubmitClick=By.id("EditSubmit");



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



		//Staff
		button_menu_click(staffButton, "Staff Menu", "Staff Menu Page");
		button_menu_click(teachers_staff,"Teachers under Staff Menu", "Staff Menu Page");
		driver.switchTo().frame(1);
		button_menu_click(new_TeacherMaster, "New Under Teacher Master", "Teacher Master Page under Staff Menu");
		editBox_Util(teacherMaster_TeacherId, "TeacherId", "Teacher Master under Staff Menu", "Emp_1988");
		editBox_Util(teacherMaster_FirstName, "First Name", "Teacher Master Page under Staff Menu", "Sasi");
		editBox_Util(teacherMaster_MiddleName, "Middle Name", "Teacher Master Page under Staff Menu", "Priya");
		editBox_Util(teacherMaster_LastName, "Last Name", "Teacher Master Page under Staff Menu", "Sajja");



		dropdown_select(techerMaster_Gender, "Gender", "x",2);
		editBox_Util(teacherMaster_Qualification, "Qualification", "New Page under Teacher Master Sub Menu under Staff Menu", "M.Sc B.Ed");
		editBox_Util(teacherMaster_Designation, "Designation", "New Page under Teacher Master Sub Menu under Staff Menu", "Teacher");
		button_menu_click(TeacherMaster_TeachingSubjects, "Teaching Subjects", "Teaching Subjects under Teacher Master Sub Menu under Staff Menu");
		//button_menu_click(TeacherMaster_SubmitClick, "Submit", "Teaching Subjects under Teacher Master Sub Menu under Staff Menu");

		//verify_GetAttributeValue(teacherMaster_SINo, "903", "SI.No", "SINo in Details under Teacher Master page");

		//verify_GetAttributeValue(teacherMaster_DateOfBirth, "03-03-2023", "Date of Birth","Date of Birth under Teacher Master page");
		//verify_GetAttributeValue(techerMaster_Gender, "Female", "Gender","Gender under Teacher MasterPage");

		verify_GetText(teacherMaster_SINo, "SI.No....", "SI No","New Page under Teacher Master Sub Menu under Staff Menu");
		verify_GetText(teacherMaster_SINo, "Teacher ID...", "SI No","New Page under Teacher Master Sub Menu under Staff Menu");





		driver.switchTo().defaultContent();
		Thread.sleep(3000);


		//Exams Menu
		/*button_menu_click(examsButton, "Exams Menu", "Home Page");
		button_menu_click(exams_marksEntries, "Exams Menu", "Home Page");
		driver.switchTo().frame(1);

		//dropdowns under marks entries in Exams Menu
		dropdown_select(marksEntries1, "Marks Entries under Exams Menu", "Marks Entries Page under Exams Menu", 2);
		dropdown_select(marksEntries2, "Marks Entries under Exams Menu", "Marks Entries Page under Exams Menu", 1);
		dropdown_select(marksEntries3, "Marks Entries under Exams Menu", "Marks Entries Page under Exams Menu", 1);
		dropdown_select(marksEntries4, "Marks Entries under Exams Menu", "Marks Entries Page under Exams Menu", 1);

		verify_GetAttributeValue(marksEntries1, "CLS10177", "Marks Entries under Exams Menu", "Marks Entries Page under Exams Menu");
		verify_GetAttributeValue(marksEntries2, "10068", "Marks Entries under Exams Menu", "Marks Entries Page under Exams Menu");
		verify_GetAttributeValue(marksEntries3, "30001105", "Marks Entries under Exams Menu", "Marks Entries Page under Exams Menu");
		verify_GetAttributeValue(marksEntries4, "30100282", "Marks Entries under Exams Menu", "Marks Entries Page under Exams Menu");
		driver.switchTo().defaultContent();*/










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






}



