package genericUtilityImplementationScripts;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import genericUtility.ExcelUtility;
import genericUtility.IConstantPath;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;
import genericUtility.propertiesutility;

public class CreateOrganisation
{
	
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
		
		driver.findElement(By.xpath("//a[contains(@href,'Accounts&action=index')]")).click();
		if(driver.getTitle().contains("Organizations"))
		{
			System.out.println("Organizations page is displayed");
		}
		else
		{
			System.out.println("Organizations page is not displayed");
		}
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.xpath("//span[text()='Creating New Organization']")).isDisplayed();
		Map<String, String> map = excel.readFromExcel("OrganizationsTestData", "Create Organization");
				
		driver.findElement(By.name("accountname")).sendKeys(map.get("Organization Name"));
        driver.findElement(By.name("button")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Organization Information')]")).isDisplayed();
        driver.findElement(By.name("Delete")).click();
        driverUtil.handleAlert("ok");
        if(driver.getTitle().contains("Organizations"))
		{
			System.out.println("Organizations page is displayed");
			excel.writeToExcel("OrganizationsTestData", "Create Organization", "Pass");
			
		}
		else
		{
			System.out.println("Organizations page is not displayed");
			excel.writeToExcel("OrganizationsTestData", "Create Organization", "fail");
		}
        excel.saveExcel(IConstantPath.EXCEL_PATH); 
        WebElement adminWidget =driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        driverUtil.mouseHover(adminWidget);
        
       driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
        excel.closeExcel();
        driverUtil.quitAllWindow();
        

	}

}
