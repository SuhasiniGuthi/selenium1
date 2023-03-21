package testNg;

import org.testng.annotations.Test;

public class ChildDependsOnMethods extends ParentDependsOnMethod {
	
	@Test(dependsOnMethods = {"method1"})
	public void method3() {
		System.out.println("I am in method3");
	}
	
	@Test
	public void method4() {
		System.out.println("I am in method4");
	}
	
	
	

}
