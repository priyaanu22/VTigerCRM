package TestNGImplementation.copy;

import java.time.Duration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
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
import objectRepo.PageObjectManager;

public class Create_Contact extends BaseClass
{
   @Test(groups="contacts")
   public void createContact()
   {
	
	    CreatingNewContactsPage createContact=pageObjectManager.getCreatecontact();
		ContactInformationPage contactInfo=pageObjectManager.getContactInfo();
		ContactsPage contact=pageObjectManager.getContacts();
		
		
		home.clickRequiredTab(driverUtil, TabNames.CONTACTS);
		soft.assertTrue(driver.getTitle().contains("Contacts"));
		
		contact.ClickCreatecontactBTN();
		
		soft.assertTrue(createContact.getPageHeader().equalsIgnoreCase("Creating New Contact"));
		
		Map<String, String> map = excel.readFromExcel("ContactsTestData", "Create Contact With Organization");
		createContact.setContactLastName(map.get("Last Name"));
		createContact.selectExistingOrganization(driverUtil, map.get("Organization Name"));
		createContact.clickSaveBTN();
		
		
		soft.assertTrue(contactInfo.getPageHeader().contains(map.get("Last Name")));
		
		
		
		contactInfo.clickDeleteBTN();
		driverUtil.handleAlert("ok");
		soft.assertTrue(driver.getTitle().contains("Contacts"));
		if(driver.getTitle().contains("Contacts"))
		 excel.writeToExcel("ContactsTestData", "Create Contact With Organization", "Pass");
		
		else
			excel.writeToExcel("ContactsTestData", "Create Contact With Organization", "fail");
			
		
		soft.assertAll();
		
	  
	}

}
