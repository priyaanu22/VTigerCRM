package testng;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class RetryTest 
{
	@Test(retryAnalyzer = genericUtility.RetryImplementation.class)
	public void demo()
	{
		Reporter.log("demo",true);
		//Assert.fail();
	}
	

}
