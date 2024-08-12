package HardCodedScripts;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Create_Contact {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		if(driver.getTitle().contains("Vtiger"))
		{
			System.out.println("Login page is displayed");
		}
		else
		{
			System.out.println("Login page is not displayed");
		}
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		if(driver.getTitle().contains("Home"))
		{
			System.out.println("Home is displayed");
		}
		else
		{
			System.out.println("Home is not displayed");
		}
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		if(driver.getTitle().contains("Contacts"))
		{
			System.out.println("contact page is displayed");
		}
		else
		{
			System.out.println("contact page is displayed");
		}
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		WebElement pageheader= driver.findElement(By.xpath("//span[text()='Creating New Contact']"));
		if(pageheader.isDisplayed())
		{
			System.out.println("Creating  new contact page is displayed");
		}
		else
		{
			System.out.println("Creating  new contact page is not  displayed");
			
		}
		driver.findElement(By.name("lastname")).sendKeys("dfg");
		
		driver.findElement(By.xpath("//img[contains(@onclick,'Accounts')]")).click();
		String parentid=driver.getWindowHandle();
		Set<String> childid=driver.getWindowHandles();
		for (String id : childid) 
		{
			driver.switchTo().window(id);
		}
		driver.findElement(By.xpath("//a[text()='asd']")).click();
		driver.switchTo().window(parentid);
		driver.findElement(By.name("button")).click();
		
		WebElement info=driver.findElement(By.xpath("//span[contains(text(), 'Contact Information')]"));
		if(info.isDisplayed())
		{
			System.out.println("Contact Informaton is displayed ");
		}
		else
		{
			System.out.println("Contact Informaton is not displayed ");
		}
		driver.findElement(By.name("Delete")).click();
		driver.switchTo().alert().accept();
		if(driver.getTitle().contains("Contacts"))
		{
			System.out.println("contact page is displayed");
		}
		else
		{
			System.out.println("contact page is displayed");
		}
		 Actions a1 = new Actions(driver);
	        
	       WebElement acc= driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	       a1.moveToElement(acc).perform();
	       driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	       driver.quit();
		
		
		



	}

}
