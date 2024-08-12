package POM_Class;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginScript {

	public static void main(String[] args) 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapp.skillrary.com/login.php?type=login");
		Login login =new Login(driver);
		
		login.setEmailTF("admin");
		login.setpswdTF("admin");
		login.clickforgetpswdLink();
		login.clickKeepMeLoggedInCB();
		
		



	}

}
