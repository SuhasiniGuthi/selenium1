package testNg;

import org.testng.annotations.Test;

public class DependsOnGroupExample {
	
	@Test(groups = {"test-group1"})
	public void method1() {
		System.out.println("I am in method1");
	}
	
	@Test(groups = {"test-group1"})
	public void method2() {
		System.out.println("I am in method2");
	}
	
	@Test(groups = {"test-group2","test-group3"})
	public void method3() {
		System.out.println("I am in method3");
	}
	
	@Test(groups = {"test-group2"})
	public void method4() {
		System.out.println("I am in method4");
	}
	
	@Test(groups = {"test-group3"})
	public void method5() {
		System.out.println("I am in method5");
	}
	
	
	
	
	
	

}
