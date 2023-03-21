package selenium1;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExtentReports2 extends ExtentReportClass {
	
	@Test

	public void functionality1Test1() {

	test = extent.createTest("functionality1Test1");
	Assert.assertTrue(1 > 0);

	}

	 
	@Test

	public void functionality1Test2() {

	test = extent.createTest("functionality1Test2");
	Assert.assertEquals("xx", "xx");

	}

	 
	
	

}
