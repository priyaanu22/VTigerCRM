package Addtional_Scenarious;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Sample 
{
	

	@Test
	public void startMaximizedBrowser() 
	{
	
	ChromeOptions Options = new ChromeOptions();
	
	Options.addArguments("start-maximized");
	WebDriver driver = new ChromeDriver(Options);
	driver.get("https://www.google.com/");
	
	driver.quit();
	
	
	}
	
	@Test
	public void headlessExection() 
	{
	
	ChromeOptions Options = new ChromeOptions();
	
	Options.addArguments("--headlesss");
	WebDriver driver = new ChromeDriver(Options);
	driver.get("https://www.google.com/");
	
	driver.quit();
	
	
	}
	
	@Test
	public void incognitoExection() 
	{
	
	ChromeOptions Options = new ChromeOptions();
	
	Options.addArguments("--incognito");
	WebDriver driver = new ChromeDriver(Options);
	driver.get("https://www.google.com/");
	
	driver.quit();
	
	
	}
	//How to avoid automated  status bar
	@Test
	public void removeAutomatedBySoftWare() 
	{
	
	ChromeOptions Options = new ChromeOptions();
	
	Options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
	WebDriver driver = new ChromeDriver(Options);
	driver.get("https://www.google.com/");
	
	driver.quit();
	
	
	}
	
	
	
	
}
