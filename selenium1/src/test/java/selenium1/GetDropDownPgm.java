package selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class GetDropDownPgm {


	WebDriver driver;

	@Test
	public void loginMethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Autamation training\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		//test = extent.createTest("login functionality1Test1");//Extent Reports

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
		//driver.findElement(By.id("chkAll")).click();
		Thread.sleep(3000);
		//driver.switchTo().defaultContent();



		//driver.findElement(By.xpath("//span[contains(text(),'EXAMS')]")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'Marks Entries')]")).click();
		
		
		
		//driver.findElement(By.id("chkAll")).click();
		
		
		
		
		
		//driver.switchTo().frame(1);
		/*Select combobox_Exam;
		//class dropdown under marks entries
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
		combobox_Exam.selectByIndex(1);*/

		//get selected value from dropdown

		/*String dropdownSelectedValue="IV CLASS";
		Select select=new Select(driver.findElement(By.id("class_name")));
		if(select.getFirstSelectedOption().getText().equalsIgnoreCase(dropdownSelectedValue)) {
			System.out.println("Dropdown value selected is: "+dropdownSelectedValue);

		}else {
			System.out.println("Dropdown value selected is not: "+dropdownSelectedValue);
			
			
		}*/
		
		
		
		//checking check box status

				String expectedValue="true";
				boolean actualValue=driver.findElement(By.id("chkAll")).isSelected();
				boolean expectValue=Boolean.parseBoolean(expectedValue);
				if(expectValue==true && actualValue==false) {
					driver.findElement(By.id("chkAll")).click();
					System.out.println("Check Box not checked then click");
					
				}else {
					System.out.println("check box already checked");
				}



		
	
	}

}


