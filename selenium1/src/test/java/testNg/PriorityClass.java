package testNg;

import org.testng.annotations.Test;

public class PriorityClass {
	
	
	@Test(priority=5)
	public void method1() {
		System.out.println("I am in test method1");
	}
	
	@Test(priority=1)
	public void method2() {
		System.out.println("I am in test method2");
	}
	
	@Test(priority=4)
	public void method3() {
		System.out.println("I am in test method3");
	}
	
	@Test(priority=3)
	public void method4() {
		System.out.println("I am in test method4");
	}
	
	@Test(priority=2)
	public void method5() {
		System.out.println("I am in test method5");
	}
	
	
	
	
	

}
