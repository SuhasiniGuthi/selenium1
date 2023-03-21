package testNg;

import org.testng.annotations.Test;

public class ParentDependsOnMethod {
	
	@Test(dependsOnMethods = {"method2"})
	public void method1() {
		System.out.println("I am in method1");
	}
	
	@Test
	public void method2() {
		System.out.println("I am in method2");
	}
	
	
	
	
	

}
