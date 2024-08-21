package Addtional_Scenarious;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HandleanyNotifications

{
	@Test
	public void handleNotification() throws InterruptedException
	{
		HashMap<String,Integer> contentSettings = new HashMap<>();
		HashMap<String,Object> profile = new HashMap<>();
		HashMap<String,Object> preference = new HashMap<>();
		
		contentSettings.put("media_stream",1);
		contentSettings.put("notifications",1);
		profile.put("managed_default_content_settings", contentSettings);
		preference.put("profile", profile);
		
		
		ChromeOptions Options = new ChromeOptions();
		
		Options.setExperimentalOption("prefs",preference);
		
		WebDriver driver = new ChromeDriver(Options);
		driver.manage().window().maximize();
		
		driver.get("https://webcamtests.com/check");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("webcam-launcher")).click();
		Thread.sleep(6000);
		driver.quit();
		
		
		
		
		
	}
	

}
