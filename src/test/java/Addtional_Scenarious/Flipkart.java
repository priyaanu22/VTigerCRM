package Addtional_Scenarious;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart 
{
	public void ValidationTotalItemsTest() throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys("iphone");
		driver.findElement(By.className("_2iLD__")).click();
		
		
		int sum=0;
		for(;;)
		{
			Thread.sleep(2000);
		  List<WebElement> iphoneList = driver.findElements(By.className("KzDlHZ"));
		  sum= sum+iphoneList.size();
		  Thread.sleep(2000);
		  
		  
		  
		  
		  		
		}
	
		
		
		
		
		
	}

}
