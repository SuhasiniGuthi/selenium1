package testNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass1 {
	
	@DataProvider
	public Object[][] dataMethod() {
		return new Object[][] {{"Sasi","2015"},{"Suresh","38"}};
		
	}
	
	@DataProvider
	public Object[][] dataMethod1() {
		return new Object[][] {{"Suhasini","34"},{"Shravya","2"}};
		
	}
		
	@Test(dataProvider="dataMethod") //link between test and dataProvider
	public void testmethod1(String param1,String param2) {
		System.out.println("testmethod1 param1: "+param1);
		System.out.println("testmethod1 param2: "+param2);
	}
	
		
	@Test(dataProvider="dataMethod1")
	public void testmethod2(String param3,String param4) {
		System.out.println("testmethod2 param3: "+param3);
		System.out.println("testmethod2 param4: "+param4);
	}
	
	
	@Test(dataProvider="dataMethod1")
	public void testmethod3(String param5,String param6) {
		System.out.println("testmethod3 param5: "+param5);
		System.out.println("testmethod3 param6: "+param6);
	}
	
	
	
	
	
	
	

}
