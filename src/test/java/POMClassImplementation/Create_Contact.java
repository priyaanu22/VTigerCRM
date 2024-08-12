package POMClassImplementation;

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
import genericUtility.TabNames;
import genericUtility.WebDriverUtility;
import genericUtility.propertiesutility;
import objectRepo.ContactInformationPage;
import objectRepo.ContactsPage;
import objectRepo.CreateToDoPage;
import objectRepo.CreatingNewContactsPage;
import objectRepo.CreatingNewOrganizationPage;
import objectRepo.EventInformationPage;
import objectRepo.HomePage;
import objectRepo.LoginPage;
import objectRepo.OrganizationInformationPage;
import objectRepo.OrganizationsPage;

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
		
		LoginPage login=new LoginPage(driver);
		HomePage home= new HomePage(driver);
		ContactsPage contact=new ContactsPage(driver);
		CreatingNewContactsPage createContact=new CreatingNewContactsPage(driver);
		ContactInformationPage contactInfo=new ContactInformationPage(driver);
		
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
		
		home.clickRequiredTab(driverUtil, TabNames.CONTACTS);
		if(driver.getTitle().contains("Contacts"))
		{
			System.out.println("contact page is displayed");
		}
		else
		{
			System.out.println("contact page is displayed");
		}
		contact.ClickCreatecontactBTN();
		
		if(createContact.getPageHeader().equalsIgnoreCase("Creating New Contact"))
		{
			System.out.println("Creating  new contact page is displayed");
		}
		else
		{
			System.out.println("Creating  new contact page is not  displayed");
			
		}
		Map<String, String> map = excel.readFromExcel("ContactsTestData", "Create Contact With Organization");
		createContact.setContactLastName(map.get("Last Name"));
		createContact.selectExistingOrganization(driverUtil, map.get("Organization Name"));
		createContact.clickSaveBTN();
		
		
		if (contactInfo.getPageHeader().contains(map.get("Last Name")))
		{
			System.out.println("Contact created successfully");
		}
		else
		{
			System.out.println("Contact not created successfully");
		}
		
		
		contactInfo.clickDeleteBTN();
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
		home.signOutOfVtiger(driverUtil);
        excel.closeExcel();
	    driverUtil.quitAllWindow();
	  
	}

}
