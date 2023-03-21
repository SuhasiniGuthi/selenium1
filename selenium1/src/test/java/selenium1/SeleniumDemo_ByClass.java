package selenium1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class SeleniumDemo_ByClass {

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

		//SETUP
		By setupButton=By.xpath("//span[contains(text(),'SETUP')]");
		By classSectionSubjects=By.xpath("//a[contains(text(),'Class Section Subjects')]");

		//dropdown
		By class_subjects=By.id("cmb_classname");//1
		By section_subjects=By.id("cmb_section");//2

		//subject master
		By subject_master=By.xpath("//a[contains(text(),'Subject Master')]");
		By subjectMaster_SearchButton=By.name("txt_Search");
		By subjectMaster_SearchClick=By.xpath("//a[contains(text(),'Search')]");

		//Exams
		By examsButton=By.xpath("//span[contains(text(),'EXAMS')]");
		By exams_marksEntries=By.xpath("//a[contains(text(),'Marks Entries')]");
		//dropdown
		By marksEntries1=By.id("class_name");
		By marksEntries2=By.id("section_id");
		By marksEntries3=By.id("exam_main_type_id_for_exam_name_combo");
		By marksEntries4=By.id("exam_type_id_for_exam_type_combo");


		//Exam Type Master
		By examTypeMaster=By.xpath("//a[contains(text(),'Exam Type Master')]");


		//FEEs
		By feesButton=By.xpath("//span[contains(text(),'FEES')]");

		//Fee Details
		By feeDetails=By.xpath("//a[contains(text(),'Fee Details')]");


		//General
		By generalButton=By.xpath("//span[contains(text(),'GENERAL')]");
		By holidaysListMaster=By.xpath("//a[contains(text(),'Holidays List Master')]");
		By eventsList=By.xpath("//a[contains(text(),'Event List')]");



		//userName.findElement(driver).sendKeys("admin");
		editBox_Util(userName, "User Name", "Login Page", "admin");
		editBox_Util(passWord, "Password","Login Page","admin");
		//passWord.findElement(driver).sendKeys("admin");
		editBox_Util(schoolId, "School Id","Login Page","1");
		//schoolId.findElement(driver).sendKeys("1");
		button_menu_click(loginButton, "Login Button", "Login Page");
		//loginButton.findElement(driver).click();
		driver.manage().window().maximize();
		Thread.sleep(3000);

		//SETUP

		button_menu_click(setupButton,"setup Button ", " Menu Page ");
		//setupButton.findElement(driver).click();
		button_menu_click(classSectionSubjects, "Class Section Subjects", "Setup Menu Page");
		//classSectionSubjects.findElement(driver).click();
		Thread.sleep(3000);
		driver.switchTo().frame(1);

		//dropdownc
		//Select combobox_Subjects;
		dropdown_select(class_subjects, "Class Subjects", "Subject Master Page Under Setup", 4);
		dropdown_select(section_subjects, "Sectios Subjects", "Subject Master Page Under Setup", 1);



		/*class_subjects.findElement(driver).click();
		combobox_Subjects=new Select(class_subjects.findElement(driver));
		combobox_Subjects.selectByIndex(4);

		section_subjects.findElement(driver).click();
		combobox_Subjects=new Select(section_subjects.findElement(driver));
		combobox_Subjects.selectByIndex(1);*/

		driver.switchTo().defaultContent();

		subject_master.findElement(driver).click();
		driver.switchTo().frame(1);
		subjectMaster_SearchButton.findElement(driver).sendKeys("Social");
		subjectMaster_SearchClick.findElement(driver).click();

		driver.switchTo().defaultContent();

		//exams
		examsButton.findElement(driver).click();
		exams_marksEntries.findElement(driver).click();
		driver.switchTo().frame(1);

		//dropdown

		Select combobox_Exam;
		marksEntries1.findElement(driver).click();
		combobox_Exam=new Select(marksEntries1.findElement(driver));
		combobox_Exam.selectByIndex(3);

		marksEntries2.findElement(driver).click();
		combobox_Exam=new Select(marksEntries2.findElement(driver));
		combobox_Exam.selectByVisibleText("Section A");

		marksEntries3.findElement(driver).click();
		combobox_Exam=new Select(marksEntries3.findElement(driver));
		combobox_Exam.selectByIndex(1);

		marksEntries4.findElement(driver).click();
		combobox_Exam=new Select(marksEntries4.findElement(driver));
		combobox_Exam.selectByIndex(1);

		//By student_marks_element=By.xpath("//th[contains(text(),'Student')]/ancestor::tr[1]/following-sibling::tr[1]/td[2]/input");
		//editBox_Util(student_marks_element, "Student Subjects", "Marks Entry", "65");

		//updating marks for first 5 students
		By student_marks_element;
		for(int student=1;student<=5;student++) {
			for(int marks=2;marks<=7;marks++) {
				student_marks_element=(By.xpath("//th[contains(text(),'Student')]/ancestor::tr[1]/following-sibling::tr["+student+"]/td["+marks+"]/input"));
				//student_marks_element.sendKeys(Keys.chord(Keys.CONTROL,"a"),"85");
				editBox_Util(student_marks_element, "Student Subjects", "Marks Entry", "65");

				//student_marks_element.sendKeys(Keys.chord(Keys.CONTROL,"a"),"80");
				//student_marks_element.clear();
				//student_marks_element.sendKeys("75");

			}
		}

		driver.switchTo().defaultContent();
		//Exam Type Master Click

		examTypeMaster.findElement(driver).click();

		//Fees Click

		feesButton.findElement(driver).click();
		feeDetails.findElement(driver).click();

		//General
		/*generalButton.findElement(driver).click();
		holidaysListMaster.findElement(driver).click();
		eventsList.findElement(driver).click();*/

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