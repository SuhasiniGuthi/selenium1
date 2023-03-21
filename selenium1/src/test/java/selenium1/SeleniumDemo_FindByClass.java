package selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SeleniumDemo_FindByClass {
	WebDriver driver;
	@FindBy(id="auth_user_name")WebElement userName;
	@FindBy(id="auth_password")WebElement password;
	@FindBy(id="auth_school") WebElement schoolId;
	@FindBy(name="Login") WebElement loginButton;

	// setup///
	@FindBy(xpath="//span[contains(text(),'SETUP')]") WebElement setupButton;
	@FindBy(xpath="//a[contains(text(),'Class Section Subjects')]") WebElement classSectionSubjectsButton;

	//dropdown xpath
	@FindBy(id="cmb_classname")WebElement class_subjects;
	@FindBy(id="cmb_section")WebElement section_subjects;

	//subjectmaster//
	@FindBy(xpath="//a[contains(text(),'Subject Master')]") WebElement  subjectMasterButton;
	@FindBy(name="txt_Search")WebElement subjectMaster_SearchButton;
	@FindBy(xpath = "//a[contains(text(),'Search')]") WebElement search_click;

	//Admission
	@FindBy(xpath = "//span[contains(text(),'ADMISSIONS')]")WebElement admissionButton;
	@FindBy(xpath = "//a[contains(text(),'Enroll Pre-Admissions')]")WebElement enrollPreAdmissions;

	//search button
	@FindBy(name="txt_Search")WebElement admission_SearchButton;
	@FindBy(xpath = "//a[contains(text(),'Search')]") WebElement admission_SearchClick;

	//Exams
	@FindBy(xpath = "//span[contains(text(),'EXAMS')]") WebElement examsButton;
	@FindBy(xpath = "//a[contains(text(),'Marks Entries')]") WebElement exams_marksEntries;
	//dropdowns
	@FindBy(id="class_name")WebElement marksEntries1;
	@FindBy(id="section_id") WebElement marksEntries2;
	@FindBy(id="exam_main_type_id_for_exam_name_combo") WebElement marksEntries3;
	@FindBy(id="exam_type_id_for_exam_type_combo") WebElement marksEntries4;

	//Exam Type Master
	@FindBy(xpath = "//a[contains(text(),'Exam Type Master')]") WebElement examTypeMaster;


	//FEES
	@FindBy(xpath = "//span[contains(text(),'FEES')]")	WebElement feesButton;
	//fee details click
	@FindBy(xpath = "//a[contains(text(),'Fee Details')]")WebElement feeDetails;

	//General
	@FindBy(xpath = "//span[contains(text(),'GENERAL')]")WebElement generalButton;
	@FindBy(xpath = "//a[contains(text(),'Holidays List Master')]")WebElement holidaysListMaster;
	@FindBy(xpath = "//a[contains(text(),'Event List')]")WebElement eventList;


	@Test
	public void loginMethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Autamation training\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,30), this);
		driver.get("https://demo.eschool360.in/index.php");
		userName.sendKeys("admin");
		password.sendKeys("admin");
		schoolId.sendKeys("1");
		loginButton.click();
		driver.manage().window().maximize();

		//setup
		setupButton.click();
		classSectionSubjectsButton.click();
		driver.switchTo().frame(1);

		//dropdown
		Select combobox_Subjects;


		combobox_Subjects=new Select(class_subjects);//dropdown 1
		combobox_Subjects.selectByIndex(4);

		combobox_Subjects=new Select(section_subjects);//dropdown 2
		combobox_Subjects.selectByIndex(1);

		driver.switchTo().defaultContent();


		subjectMasterButton.click();
		driver.switchTo().frame(1);
		subjectMaster_SearchButton.sendKeys("Social");
		search_click.click();

		driver.switchTo().defaultContent();

		//Admission click
		admissionButton.click();
		enrollPreAdmissions.click();

		//search
		driver.switchTo().frame(1);
		admission_SearchButton.sendKeys("Sudhakar");
		admission_SearchClick.click();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);



		//Exams
		examsButton.click();
		exams_marksEntries.click();
		driver.switchTo().frame(1);

		Select combobox_Exams;

		combobox_Exams=new Select(marksEntries1);//dropdown 1
		combobox_Exams.selectByIndex(3);

		combobox_Exams=new Select(marksEntries2);
		combobox_Exams.selectByVisibleText("Section A");//dropdown 2

		combobox_Exams=new Select(marksEntries3);
		combobox_Exams.selectByIndex(1);//dropdown 3

		combobox_Exams=new Select(marksEntries4);
		combobox_Exams.selectByIndex(1);//dropdown 4

		//updating marks for first 5 students
		WebElement student_marks_element;
		for(int student=1;student<=5;student++) {
			for(int marks=2;marks<=7;marks++) {
				student_marks_element=driver.findElement(By.xpath("//th[contains(text(),'Student')]/ancestor::tr[1]/following-sibling::tr["+student+"]/td["+marks+"]/input"));
				student_marks_element.sendKeys(Keys.chord(Keys.CONTROL,"a"),"85");
				//student_marks_element.sendKeys(Keys.chord(Keys.CONTROL,"a"),"80");
				//student_marks_element.clear();
				//student_marks_element.sendKeys("75");

			}
		}

		driver.switchTo().defaultContent();
		examTypeMaster.click();


		//Fees button click
		feesButton.click();
		feeDetails.click();





		/*generalButton.click();
		holidaysListMaster.click();
		Thread.sleep(3000);
		eventList.click();*/














	}


}
