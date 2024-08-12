package genericUtilityImplementationScripts;

import java.time.Duration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtility.ExcelUtility;
import genericUtility.IConstantPath;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;
import genericUtility.propertiesutility;

public class Create_Contact {

	public static void main(String[] args) 
	{
		propertiesutility propertyUtil = new propertiesutility();
		ExcelUtility excel = new ExcelUtility();
		JavaUtility jutil= new JavaUtility();
		WebDriverUtility driverUtil= new WebDriverUtility();
		
		propertyUtil.PropertiesInit(IConstantPath.PROPERTIES_FILE_PATH);
		excel.excelInit(IConstantPath.EXCEL_PATH);
		
		WebDriver driver =driverUtil.lanchBrowser(propertyUtil.readFromProperties("browser"));
		driverUtil.maximizeBrowser();
		driverUtil.navigateToApp(propertyUtil.readFromProperties("url"));
		long time = (long)jutil.convertStringToAnyDataType(propertyUtil.readFromProperties("timeouts"),"long");
		driverUtil.waitTillElementFound(time);
		

		if(driver.getTitle().contains("vtiger"))
		{
			System.out.println("Login page is displayed");
		}
		else
		{
			System.out.println("Login page is not displayed");
		}
		
		driver.findElement(By.name("user_name")).sendKeys(propertyUtil.readFromProperties("username"));
		driver.findElement(By.name("user_password")).sendKeys(propertyUtil.readFromProperties("password"));
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
		Map<String, String> map = excel.readFromExcel("ContactsTestData", "Create Contact With Organization");
		driver.findElement(By.name("lastname")).sendKeys(map.get("Last Name"));
		
		driver.findElement(By.xpath("//img[contains(@onclick,'Accounts')]")).click();
		
		driverUtil.switchToWindow("Accounts");
		driver.findElement(By.xpath("//a[text()='"+map.get("Organization Name")+"']")).click();
		
		
		
		driverUtil.switchToWindow("Contact");
		
		driver.findElement(By.xpath("//input[contains(@title,'Save')]")).click();
		String newContactPageHeader = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		if (newContactPageHeader.contains(map.get("Last Name")))
		{
			System.out.println("Contact created successfully");
		}
		else
		{
			driverUtil.quitAllWindow();
		}
		
		driver.findElement(By.name("Delete")).click();
		driverUtil.handleAlert("ok");
		if(driver.getTitle().contains("Contacts"))
		{
			System.out.println("contact page is displayed");
			excel.writeToExcel("ContactsTestData", "Create Contact With Organization", "Pass");
		}
		else
		{
			System.out.println("contact page is displayed");
			excel.writeToExcel("ContactsTestData", "Create Contact With Organization", "fail");
			
		}
		
		excel.saveExcel(IConstantPath.EXCEL_PATH); 
        WebElement adminWidget =driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        driverUtil.mouseHover(adminWidget);
        driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	    excel.closeExcel();
	    driverUtil.quitAllWindow();
	  
	}

}
