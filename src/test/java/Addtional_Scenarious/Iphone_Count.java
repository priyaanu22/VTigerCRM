package Addtional_Scenarious;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iphone_Count {

	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone");
		driver.findElement(By.id("nav-search-submit-text")).click();
		List<WebElement> result=driver.findElements(By.xpath("//span[contains(text(),'iPhone')]"));
		
		int count=0;
		for(WebElement  i :result)
		{
			String text=i.getText();
			driver.findElement(By.xpath("//a[text()='Next']")).click();
//			if(text.contains("iphone"))
//			{
//				count++;
//			}
			
		}
		//System.out.println();
		
		



	}

}
