package testNg;

import org.testng.annotations.Test;

public class DependentTestExample {
	
	@Test(dependsOnMethods = {"testmethod2"})
	public void testmethod1() {
		System.out.println("I am in testmethod1");
	}
	
	@Test
	public void testmethod2() {
		System.out.println("I am in testmethod2");
	}
	
	

}
