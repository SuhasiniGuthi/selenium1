package testNg;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterAnnotationExample {
	
	
	@Parameters({"suite-param"})
	@Test
	public void method1(String param) {
		System.out.println("I am in test method1");
		System.out.println("value of param:"+param);
	}
	
	
	@Parameters({"suite-param"})
	@Test
	public void method2(String param) {
		System.out.println("I am in test method2");
		System.out.println("value of param:"+param);
	}
	
	@Parameters({"suite-param","suite-param2"})
	@Test
	public void method3(String param,String param2) {
		System.out.println("I am in test method3");
		System.out.println("value of param:"+param);
		System.out.println("value of param2:"+param2);
	}
	
	
	
	
	
	
	

}
