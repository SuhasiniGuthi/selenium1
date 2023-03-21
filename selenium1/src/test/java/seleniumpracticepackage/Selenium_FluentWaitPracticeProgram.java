package seleniumpracticepackage;

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

public class Selenium_FluentWaitPracticeProgram {

	WebDriver driver;
	String msg=null;
	Select combobox_subjects;

	@Test
	public void fluentWaitMerhod() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\Autamation training\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demo.eschool360.in/index.php");
		driver.manage().window().maximize();

		By userName=By.id("auth_user_name");
		By passWord=By.id("auth_password");
		By schoolId=By.id("auth_school");
		By loginButton=By.name("Login");

		By setupButton=By.xpath("//span[contains(text(),'SETUP')]");
		By classSectionSubjects=By.xpath("//a[contains(text(),'Class Section Subjects')]");

		//dropdown
		By class_subjects=By.id("cmb_classname");//1
		By section_subjects=By.id("cmb_section");//2
		By search_edit=By.name("txt_Search");
		By search_click=By.xpath("//a[contains(text(),'Search')]");

		//ADMISSIONS
		By admissionsButton=By.xpath("//span[contains(text(),'ADMISSIONS')]");
		By enroll_PreAdmissions=By.xpath("//a[contains(text(),'Enroll Pre-Admissions')]");

		//search under Enroll Pre-Admissions
		By search_edit_admissions=By.name("txt_Search");
		By search_click_admissions=By.xpath("//a[contains(text(),'Search')]");

		//Students
		By studentsButton=By.xpath("//span[contains(text(),'STUDENTS')]");
		By student_Master=By.xpath("//a[contains(text(),'Student Master')]");

		By class_subjectMaster=By.id("cmb_classmaster");
		By section_subjectMaster=By.id("cmb_sectionmaster");


		// COMMUNICATION button
		By communicationButton=By.xpath("//span[contains(text(),'COMMUNICATION')]");
		By notifications=By.xpath("//a[contains(text(),'Notifications')]");

		//dropdowns under notifications
		By class_notifications=By.id("classid");//class dropdown
		By section_notifications=By.id("sectionid"); //section dropdown

		//Expenses
		By expensesButton=By.xpath("//span[contains(text(),'EXPENSES')]");
		By expenses_Master=By.xpath("//a[contains(text(),'Expenses Master')]");




		editBox_Util(userName, "User Name", "Login Page", "admin");
		editBox_Util(passWord, "Password","Login Page", "admin");
		editBox_Util(schoolId, "School Id","Login Page","1");
		button_menu_click(loginButton, "Login Button", "Login Page");
		Thread.sleep(2000);

		//setup
		button_menu_click(setupButton, "setup Button", "Menu Page");
		button_menu_click(classSectionSubjects, "Class Section Subjects", "menu Page");
		driver.switchTo().frame(1);

		//dropdowns under class section subjects
		dropdown_select(class_subjects, "Class Subjects", "Class Section Subjects Page under setup Menu ", 4);
		dropdown_select(section_subjects, "Section Subjects", "Class Section Subjects Page under setup Menu", 1);

		editBox_Util(search_edit, "Search Text","Class Section Subjects Page under setup Menu" , "Maths");

		button_menu_click(search_click, "Click Search", "Class Section Subjects Page under setup Menu");

		driver.switchTo().defaultContent();

		button_menu_click(admissionsButton, "Admissions Menu", "Admissions Menu Page");
		button_menu_click(enroll_PreAdmissions, "Admissions Menu", "Admissions Menu Page");
		driver.switchTo().frame(1);
		editBox_Util(search_edit_admissions, "Search edit under admissions","Enroll preAdmissions page under Admissions Mecu", "2000");
		button_menu_click(search_click_admissions,"Search click under admissions","Enroll preAdmissions page under Admissions Mecu" );
		Thread.sleep(3000);
		driver.switchTo().defaultContent();

		button_menu_click(studentsButton, "Students Menu", "Students Menu Page");
		button_menu_click(student_Master, "Student Master under Students", "Student Master under Students Menu Page");
		driver.switchTo().frame(1);
		dropdown_select(class_subjectMaster, "Class dropdown", "Class dropdown under SubjectMaster Page", 7);
		dropdown_select(section_subjectMaster, "Section dropdown ","Section dropdown under SubjectMaster Page ", 2);
		driver.switchTo().defaultContent();


		button_menu_click(communicationButton, "Communication Menu", "Communication Menu Page");
		button_menu_click(notifications, "Notifications",  " Communication Menu Page");
		driver.switchTo().frame(1);


		dropdown_select(class_notifications, "Class dropdown under Notifications", "Notifications Page under Communications", 3);
		dropdown_select(section_notifications, "Class dropdown under Notifications", "Notifications Page under Communications", 0);
		driver.switchTo().defaultContent();

		button_menu_click(expensesButton, "Expenses Menu", "Expenses Menu Page");
		button_menu_click(expenses_Master, "Expenses Master under Expenses Menu","Expenses Master under Expenses Menu Page");
		driver.switchTo().frame(1);

	}

	public String elementPresent(By locator,String locatorName,String pageName) {

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








	public void editBox_Util(By locator,String locatorName,String pageName,String value) {
		System.out.println(driver);
		System.out.println(locator);
		msg=elementPresent(locator,locatorName,pageName);
		if(msg==null) {
			locator.findElement(driver).sendKeys(Keys.chord(Keys.CONTROL,"a"),value);

		}else {
			System.out.println(msg);
		}


	}

	public void button_menu_click(By locator,String locatorName,String pageName) {
		System.out.println(driver);
		System.out.println(locator);
		msg=elementPresent(locator,locatorName,pageName);
		if(msg==null) {
			locator.findElement(driver).click();

		}else {
			System.out.println(msg);
		}

	}

	public void dropdown_select(By locator,String locatorName,String pageName,int value) {
		System.out.println(driver);
		System.out.println(locator);
		if(msg==null) {
			locator.findElement(driver).click();
			combobox_subjects=new Select(locator.findElement(driver));
			combobox_subjects.selectByIndex(value);

		}else {
			System.out.println(msg);
		}

	}




}
