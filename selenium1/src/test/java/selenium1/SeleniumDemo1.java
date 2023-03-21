package selenium1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;
@Listeners(selenium1.TestNGListerners.class)
public class SeleniumDemo1 extends ExtentReportClass {

	WebDriver driver;
	@Test
	public void loginMethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Autamation training\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		test = extent.createTest("login functionality1Test1");//Extent Reports
		
		driver.get("https://demo.eschool360.in/index.php");
		driver.findElement(By.id("auth_user_name")).sendKeys("admin");
		driver.findElement(By.id("auth_password")).sendKeys("admin");
		driver.findElement(By.id("auth_school")).sendKeys("1");
		driver.findElement(By.name("Login")).click();
		driver.manage().window().maximize();
		Thread.sleep(3000);

		//SETUP
		driver.findElement(By.xpath("//span[contains(text(),'SETUP')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Class Section Subjects')]")).click();
		driver.switchTo().frame(1);

		//dropdown

		WebElement class_subjects=driver.findElement(By.id("cmb_classname"));
		Select sel_class_subjects=new Select(class_subjects);
		sel_class_subjects.selectByIndex(4);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[contains(text(),'Subject Master')]")).click();

		//Subject Master- Search
		driver.switchTo().frame(1);
		driver.findElement(By.name("txt_Search")).sendKeys("Maths");
		driver.findElement(By.xpath("//a[contains(text(),'Search')]")).click();


		//ADMISSIONS
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//span[contains(text(),'ADMISSIONS')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Enroll Pre-Admissions')]")).click();
		//search
		driver.switchTo().frame(1);
		driver.findElement(By.name("txt_Search")).sendKeys("abcd");
		driver.findElement(By.xpath("//a[contains(text(),'Search')]")).click();
		driver.switchTo().defaultContent();

		//STUDENTS
		driver.findElement(By.xpath("//span[contains(text(),'STUDENTS')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Student Master')]")).click();
		driver.switchTo().frame(1);
		WebElement class_subjectmaster=driver.findElement(By.xpath("//select[contains(@id,\"cmb_classmaster\")]"));
		Select sel_class_subjectmaster=new Select(class_subjectmaster);
		sel_class_subjectmaster.selectByIndex(5);
		
		//EXAMS

		WebElement section_studentmaster =driver.findElement(By.id("cmb_sectionmaster"));
		Select sel_section_studentmaster=new Select(section_studentmaster);
		sel_section_studentmaster.selectByVisibleText("Section B");
		driver.findElement(By.name("txt_Search")).sendKeys("Female");
		driver.findElement(By.xpath("//a[contains(text(),'Search')]")).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();


		//EXAMS:Marks Entries

		driver.findElement(By.xpath("//span[contains(text(),'EXAMS')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Marks Entries')]")).click();
		driver.switchTo().frame(1);

		//class dropdown under marks entries

		/*WebElement class_MarksEntries=driver.findElement(By.id("class_name"));
		Select sel_class_MarksEntries=new Select(class_MarksEntries);
		sel_class_MarksEntries.selectByIndex(3);

		//section dropdown under marks entries
		WebElement section_MarksEntries=driver.findElement(By.id("section_id"));
		Select sel_section_MarksEntries=new Select(section_MarksEntries);
		sel_section_MarksEntries.selectByIndex(1);

		//Exam main type drop down under marks entries
		WebElement examMaintype_MarksEntries=driver.findElement(By.id("exam_main_type_id_for_exam_name_combo"));
		Select sel_examMaintype_MarksEntries=new Select(examMaintype_MarksEntries);
		sel_examMaintype_MarksEntries.selectByIndex(1);

		//Exam type drop down under marks entries
		WebElement examtype_MarksEntries=driver.findElement(By.id("exam_type_id_for_exam_type_combo"));
		Select sel_examtype_MarksEntries=new Select(exatype_MarksEntries);
		sel_examtype_MarksEntries.selectByIndex(1);*/

		//class dropdown under marks entries
		Select combobox_Exam;

		WebElement marksEntries1=driver.findElement(By.id("class_name"));
		combobox_Exam=new Select(marksEntries1);
		combobox_Exam.selectByIndex(3);

		//section dropdown under marks entries
		WebElement marksEntries2=driver.findElement(By.id("section_id"));
		combobox_Exam=new Select(marksEntries2);
		combobox_Exam.selectByVisibleText("Section A");


		//Exam main type drop down under marks entries
		WebElement marksEntries3=driver.findElement(By.id("exam_main_type_id_for_exam_name_combo"));
		combobox_Exam=new Select(marksEntries3);
		combobox_Exam.selectByIndex(1);

		//Exam type drop down under marks entries
		WebElement marksEntries4=driver.findElement(By.id("exam_type_id_for_exam_type_combo"));
		combobox_Exam=new Select(marksEntries4);
		combobox_Exam.selectByIndex(1);
		
		
		
		/*int items=driver.findElements(By.xpath("//*[@id='MainTable']/tbody/tr[2]/td/table/tbody/tr[3]/td"));

		System.out.println(items);
		
		WebElement student=driver.findElement(By.xpath("//*[@id='MainTable']/tbody/tr[2]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/th[1]"));
		String labelNames=Student:vamsi krishna kadiyam:VALAMETI AKSHITHA:UPPALA SUBRAMANYAM:UDATHA SPOORTHIKA:swaroop;
		String labelValues=English:90:85:40:78:87;
		String[] splitlabelNames=labelNames.split(":");
		String[] splitlabelValues=labelValues.split(":");
		
		for(int totalLabels=0;totalLabels<splitlabelNames.length;totalLabels++) {
			String indName=splitlabelNames[totalLabels];
			String indValue=splitlabelValues[totalLabels];
			for(int i=0;i<items;i++) {
				
			}
			
		}*/


		//updating marks for first 5 students
		/*WebElement student_marks_element;
		for(int student=1;student<=5;student++) {
			for(int marks=2;marks<=7;marks++) {
				student_marks_element=driver.findElement(By.xpath("//th[contains(text(),'Student')]/ancestor::tr[1]/following-sibling::tr["+student+"]/td["+marks+"]/input"));
				student_marks_element.sendKeys(Keys.chord(Keys.CONTROL,"a"),"85");
				//student_marks_element.sendKeys(Keys.chord(Keys.CONTROL,"a"),"80");
				//student_marks_element.clear();
				//student_marks_element.sendKeys("75");

			}
		}*/













	}


}
