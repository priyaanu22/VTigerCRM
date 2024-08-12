package Listener;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.ListenersImplementation.class)

public class TestClass extends BaseClass
{
  @Test
  public void demo()
  {
	  System.out.println("@Test");
	  
  }
  
}
