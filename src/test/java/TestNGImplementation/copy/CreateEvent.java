package TestNGImplementation.copy;

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
import org.testng.annotations.Test;

import genericUtility.BaseClass;
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
import objectRepo.PageObjectManager;

public class CreateEvent extends BaseClass
{
   @Test(groups="events")

	public  void createEventTest() 
	{
	    CreateToDoPage createToDo =pageObjectManager.getCreateToDo();
		EventInformationPage eventInfo =pageObjectManager.getEventInfo();

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
		
		soft.assertTrue(eventInfo.getPageHeader().contains("Event"));
		if (eventInfo.getPageHeader().contains("Event")) 
		{
			//System.out.println("Event Created");
			excel.writeToExcel("EventsTestData", "Create New Event", "Pass");
		} 
		else 
		{
			//System.out.println("Event Not Created");
			excel.writeToExcel("EventsTestData", "Create New Event", "Fail");
		}
		eventInfo.clickDeleteBTN();
        driverUtil.handleAlert("ok");
        soft.assertAll();

		
	}
}


