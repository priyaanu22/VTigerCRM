package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class SampleTest 
{
	@Test
	
		public void Demo()
		{
			Reporter.log("Hello World", true);
		}
	
}
