
package Assertion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Hard_Assert 
{
	@Test
	public void demo()
	{
		String s1="Hello";
		String  s2= "Hi";
		Assert.assertEquals(s1,s2);
		
		System.out.println(s1);
		System.out.println(s2);
	}

}
