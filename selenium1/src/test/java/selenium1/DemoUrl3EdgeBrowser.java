package selenium1;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DemoUrl3EdgeBrowser {
	WebDriver driver;
	@Test
	
	public void samplemethod() throws InterruptedException {
		
		System.setProperty("webdriver.edge.driver", "C:\\Autamation training\\edgedriver_win32\\msedgedriver.exe");
		driver = new EdgeDriver();
		
		driver.get("https://courses.letskodeit.com/practice");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
		WebElement groupid_selection=driver.findElement(By.id("multiple-select-example"));
		Select group=new Select(groupid_selection);
		
		group.selectByVisibleText("Apple");
		//group.selectByVisibleText("Orange");
		//group.selectByVisibleText("Peach");
		
		List<WebElement>options=group.getAllSelectedOptions();
		for(int i=0;i<options.size();i++) {
			System.out.println(options.get(i).getText());
			
			
		}
		
		//Auto Suggest Example
		WebElement autoSuggestExample=driver.findElement(By.xpath("//legend[contains(text(),'Auto Suggest Example')]"));
		driver.findElement(By.id("autosuggest")).sendKeys("I am learning selenium with java");
		
		//Enabled/Disabled example
		
		WebElement enbleDisableElement=driver.findElement(By.xpath("//div[contains(@id,'enabled-example-div')]/fieldset/legend"));
		//driver.findElement(By.id("disabled-button")).click();
		driver.findElement(By.id("enabled-button")).click();
		driver.findElement(By.id("enabled-example-input")).sendKeys("Hi everyone");
		System.out.println(driver.findElement(By.id("enabled-example-input")).getAttribute("value"));
		
		//Element Displayed Example
		driver.findElement(By.xpath("//div[contains(@id,'hide-show-example-div')]/fieldset/legend"));
		driver.findElement(By.id("hide-textbox")).click();
		//driver.findElement(By.xpath("//div[contains(@id,'hide-show-example-div')]/fieldset/input[2]")).click();
		
		
		//Switch to alert example
		driver.findElement(By.id("name")).sendKeys("Suhasini");
		Thread.sleep(2000);
		//driver.findElement(By.id("alertbtn")).click();
		driver.findElement(By.id("confirmbtn")).click();
		Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);
		alert.dismiss();
		//alert.accept();
		
		
		
		
	}
	

}
