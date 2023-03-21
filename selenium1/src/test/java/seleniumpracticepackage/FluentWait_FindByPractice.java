package seleniumpracticepackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import selenium1.ExtentReportClass;




public class FluentWait_FindByPractice  extends ExtentReportClass{

	String msg=null;
	Select combobox_Value;
	WebDriver  driver;

	@FindBy(id = "auth_user_name")WebElement userName;
	@FindBy(id ="auth_password")WebElement password;
	@FindBy(id="auth_school") WebElement schoolId;
	@FindBy(name="Login") WebElement loginButton;
	
	

	//Inventory menu
	@FindBy(xpath = "//span[contains(text(),'INVENTORY')]")WebElement inventoryButton;

	@FindBy(xpath = "//a[contains(text(),'Masters')]") WebElement masters_Inventory;
	@FindBy(xpath = "//a[contains(text(),'Category Master')]") WebElement categoryMaster_Masters;
	@FindBy(xpath = "//a[contains(text(),'Sub-Category Master')]") WebElement subcategoryMaster_Masters;

	@FindBy(id = "categoryID")WebElement category_subCategory; //dropdown
	//Stock Details
	@FindBy(xpath = "//a[contains(text(),'Stock Details')]")WebElement stock_details;
	@FindBy(id ="categoryID" )WebElement category_stockDetails;//dropdown1
	@FindBy(id="itemGroupID")WebElement subcategory_stockDetails;//dropdown2
	@FindBy(id="itemID")WebElement item_stockDetails; //dropdown3

	//Transport
	@FindBy(xpath = "//span[contains(text(),'TRANSPORT')]") WebElement transportButton;
	@FindBy(xpath = "//a[contains(text(),'Route vs Pickup Area')]") WebElement routeVs_PickupArea;

	@FindBy(id="routeid2")WebElement route_RouteVsPickupArea;//dropdown
	//Reports
	@FindBy(xpath = "(//a[contains(text(),'Reports')])[8]")WebElement reports_Transport;
	@FindBy(xpath = "//a[contains(text(),'Transport Fee Dues')]") WebElement transport_fee_dues;

	//General Menu
	@FindBy(xpath = "//span[contains(text(),'GENERAL')]")WebElement generalButton;
	@FindBy(xpath = "//a[contains(text(),'Holidays List Master')]")WebElement holidays_list_master;
	@FindBy(xpath = "//a[contains(text(),'Event List')]") WebElement eventList_general;

	//LOGS Menu
	@FindBy(xpath = "//span[contains(text(),'LOGS')]") WebElement logsButton;
	@FindBy(xpath = "//a[contains(text(),'Login History')]")WebElement login_history;
	@FindBy(xpath = "//a[contains(text(),'General Logs')]") WebElement general_logs;

	@FindBy(id="search_str")WebElement search_text_general_logs;



	@Test
	public void fluentWait_FindByMethod() {
		System.setProperty("webdriver.chrome.driver","C:\\Autamation training\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		
		test = extent.createTest("login functionalityTest");
		
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,30), this);
		driver.get("https://demo.eschool360.in/index.php");
		driver.manage().window().maximize();


		editBox_Util(userName, "User Name", "Login Page", "admin");
		editBox_Util(password, "Password","Login Page", "admin");
		editBox_Util(schoolId, "School Id","Login Page","1");
		button_menu_click(loginButton, "Login Button", "Login Page");

		//Inventory menu
		button_menu_click(inventoryButton, "Inventory Menu", "Inventory Menu Page");

		Actions action=new Actions(driver);
		action.moveToElement(masters_Inventory).perform();
		//button_menu_click(categoryMaster_Masters, "Category master SubMenu", "Masters under InventoryMenu");
		button_menu_click(subcategoryMaster_Masters, "Category master SubMenu", "Masters under InventoryMenu");
		driver.switchTo().frame(1);
		dropdown_select(category_subCategory, "Category under sub-category", "sub-category under Masters SubMenu", 4);
		driver.switchTo().defaultContent();
		//Stock Details
		button_menu_click(stock_details, "Stock Details","Stock Details under Inventory Menu Page");
		driver.switchTo().frame(1);
		dropdown_select(category_stockDetails, "Stock Details under Inventory", "Stock Details under Inventory Menu page", 3);
		dropdown_select(subcategory_stockDetails,"Stock Details under Inventory", "Stock Details under Inventory Menu page",0); 
		dropdown_select(item_stockDetails, "Stock Details under Inventory", "Stock Details under Inventory Menu page", 0);
		driver.switchTo().defaultContent();

		//Transport
		button_menu_click(transportButton, "Transport Menu", "Transport Menu Page");
		button_menu_click(routeVs_PickupArea, "Route Vs Pickup Area", "Route vs Pickup Area Page under Transport");
		driver.switchTo().frame(1);	
		dropdown_select(route_RouteVsPickupArea, "Route  underRoute vs Pickup Area", "Route vs Pickup Area under Transport Menu Page", 2);
		driver.switchTo().defaultContent();

		action.moveToElement(reports_Transport).perform();
		button_menu_click(transport_fee_dues, "Transport Fee Dues", "Transport Fee Dues Page Under Reports submenu under Transport Menu Page");

		//General
		button_menu_click(generalButton, "General Button", "General Menu Page");
		button_menu_click(holidays_list_master, "Holidays List Master under General", "Holidays List Master Page under General Menu");
		button_menu_click(eventList_general,"Holidays List Master under General", "Holidays List Master Page under General Menu");

		//Logs

		button_menu_click(logsButton, "Logs Menu", "Logs Menu Page");
		button_menu_click(login_history, "Login History", "Login History Page under Logs Menu");
		button_menu_click(general_logs, "General Logs", "General Logs Page under Logs Menu");
		driver.switchTo().frame(1);
		editBox_Util(search_text_general_logs, "Search Text under General Logs SubMenu", "General Logs Page under Logs Menu", "venumal");
		driver.switchTo().defaultContent();









	}

	public String elementPresent(WebElement element,String locatorName,String pageName) {

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

			wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {

			// TODO Auto-generated catch block

			//System.out.println(e.getMessage());

			//e.printStackTrace();

			System.out.println("I have entered into catch block");

			//e.printStackTrace();

			msg = "Locator Name:-"+locatorName+" : "+element+" is not identified in Page : "+pageName;
		}
		return msg;

	}


	public void editBox_Util(WebElement userName,String locatorName,String pageName,String value) {
		System.out.println(driver);
		System.out.println(userName);
		msg=elementPresent(userName,locatorName,pageName);
		if(msg==null) {
			//userName.findElement((By) driver).sendKeys(Keys.chord(Keys.CONTROL,"a"),value);
			userName.sendKeys(Keys.chord(Keys.CONTROL,"a"),value);
		}else {
			System.out.println(msg);
		}

	}

	public void button_menu_click(WebElement locator,String locatorName,String pageName) {
		System.out.println(driver);
		System.out.println(locator);
		msg=elementPresent(locator,locatorName,pageName);
		if(msg==null) {
			locator.click();

		}else {
			System.out.println(msg);
		}

	}

	public void dropdown_select(WebElement  locator,String locatorName,String pageName,int value) {
		System.out.println(driver);
		System.out.println(locator);
		if(msg==null) {
			locator.click();
			combobox_Value=new Select((WebElement) locator);
			combobox_Value.selectByIndex(value);

		}else {
			System.out.println(msg);
		}

	}







}
