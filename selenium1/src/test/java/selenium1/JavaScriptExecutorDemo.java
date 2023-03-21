package selenium1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import net.bytebuddy.implementation.bind.annotation.Argument;

public class JavaScriptExecutorDemo {


	WebDriver driver;
	@Test
	public void loginMethod() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Autamation training\\chromedriver_win32\\chromedriver.exe");
		//driver = new ChromeDriver();
		
		System.setProperty("webdriver.edge.driver", "C:\\Autamation training\\edgedriver_win32\\msedgedriver.exe");
		driver = new EdgeDriver();

		//test = extent.createTest("login functionality1Test1");//Extent Reports

		driver.get("https://demo.eschool360.in/index.php");
		driver.findElement(By.id("auth_user_name")).sendKeys("admin");
		driver.findElement(By.id("auth_password")).sendKeys("admin");
		driver.findElement(By.id("auth_school")).sendKeys("1");
		driver.findElement(By.name("Login")).click();
		driver.manage().window().maximize();
		Thread.sleep(3000);

		//my first pull request


		//EXAMS:Marks Entries

		driver.findElement(By.xpath("//span[contains(text(),'EXAMS')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Marks Entries')]")).click();
		driver.switchTo().frame(1);

		//class dropdown under marks entries

		WebElement class_MarksEntries=driver.findElement(By.id("class_name"));
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
		Select sel_examtype_MarksEntries=new Select(examtype_MarksEntries);
		sel_examtype_MarksEntries.selectByIndex(1);
		
		
		JavascriptExecutor jse=(JavascriptExecutor)driver; // casting the driver into javaScript executor
		String existing_marks="95/85/92/88/80/100";
		String[] indv_marks=existing_marks.split("/");
		
		//Adding values into textboxes
		WebElement student_marks_element ;
		for(int student = 20;student <= 23;student ++) {
		int marks_iter = 0;
		for(int marks = 2; marks <= 7; marks++) {
		student_marks_element = driver.findElement(By.xpath("//th[contains(text(),'Student')]/ancestor::tr[1]/following-sibling::tr["+student+"]/td["+marks+"]/input"));
		//student_marks_element.sendKeys(Keys.chord(Keys.CONTROL,"a"),"95");
		jse.executeScript("arguments[0].value= '"+indv_marks[marks_iter]+"';",student_marks_element );
		marks_iter = marks_iter+1;
		// jse.executeScript("arguments[0].value= '"+existing_marks+"';",student_marks_element );
		}
		}
		WebElement save = driver.findElement(By.xpath("//input[contains(@id,'mode')]"));
		jse.executeScript("arguments[0].click()", save);
		Thread.sleep(2000);
		
		
		
		Alert alert=driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
		







	}






}
