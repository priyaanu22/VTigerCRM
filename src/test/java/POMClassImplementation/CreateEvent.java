
package POMClassImplementation;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import genericUtility.Datatype;
import genericUtility.ExcelUtility;
import genericUtility.IConstantPath;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;
import genericUtility.propertiesutility;
import objectRepo.CreateToDoPage;
import objectRepo.EventInformationPage;
import objectRepo.HomePage;
import objectRepo.LoginPage;

public class CreateEvent 
{
	
	public static void main(String[] args) throws InterruptedException 
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
		
		LoginPage login=new LoginPage(driver);
		HomePage home= new HomePage(driver);
		CreateToDoPage createToDo = new CreateToDoPage(driver);
		EventInformationPage eventInfo = new EventInformationPage(driver);

		if(driver.getTitle().contains("vtiger"))
		{
			System.out.println("Login page is displayed");
		}
		else
		{
			System.out.println("Login page is not displayed");
		}
		login.loginToVtiger(propertyUtil.readFromProperties("username"),propertyUtil.readFromProperties("password"));
		if(driver.getTitle().contains("Home"))
		{
			System.out.println("Home is displayed");
		}
		else
		{
			System.out.println("Home is not displayed");
		}
		
		
		Map<String, String> map = excel.readFromExcel("EventsTestData", "Create New Event");
		
		home.selectFromQuickCreateDD(driverUtil, map.get("Quick Create"));

		jutil.waiting(3000);

		String subject = map.get("Subject") + jutil.generateRandom(100);
		createToDo.setSubject(subject);
		createToDo.clickStartDateWidget();
		createToDo.datepicker(jutil, driverUtil, map.get("Start Date"));
		jutil.waiting(3000);
		createToDo.clickdueDateWidget();
		createToDo.datepicker(jutil, driverUtil, map.get("Due Date"));
		createToDo.clickSaveBTN();
		Thread.sleep(3000);
		if (eventInfo.getPageHeader().contains("Event")) 
		{
			System.out.println("Event Created");
			excel.writeToExcel("EventsTestData", "Create New Event", "Pass");
		} 
		else 
		{
			System.out.println("Event Not Created");
			excel.writeToExcel("EventsTestData", "Create New Event", "Fail");
		}
		eventInfo.clickDeleteBTN();
        driverUtil.handleAlert("ok");

		excel.saveExcel(IConstantPath.EXCEL_PATH);
		home.signOutOfVtiger(driverUtil);
		
		

		 excel.closeExcel();
	     driverUtil.quitAllWindow();
	     
	}
}


