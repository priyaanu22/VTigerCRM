package TestNGImplementation.copy;

import java.time.Duration;
import java.util.Map;

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
import objectRepo.CreatingNewLeadPage;
import objectRepo.DuplicatingPage;
import objectRepo.HomePage;
import objectRepo.LeadsInformationPage;
import objectRepo.LeadsPage;
import objectRepo.LoginPage;

public class Create_Lead extends BaseClass
{
	
	@Test(groups="leads")
	public void createLeadTest()
	{
       LeadsPage leads =pageObjectManager.getLeads();
		DuplicatingPage duplicateLead = pageObjectManager.getDuplicateLead();
		LeadsInformationPage leadInfo =pageObjectManager.getLeadInfo();
		CreatingNewLeadPage createLead =pageObjectManager.getCreatelead();

		
		home.clickRequiredTab(driverUtil, TabNames.LEADS);

		soft.assertTrue(driver.getTitle().contains("Leads")) ;

		leads.ClickCreateLeadBTN();

		soft.assertTrue(createLead.getPageHeader().equalsIgnoreCase("creating new lead"));
		

		Map<String, String> map = excel.readFromExcel("LeadsTestData", "Create and Duplicate Lead");
		String lastName = map.get("Last Name")+jutil.generateRandom(100);
		createLead.setLeadsLastName(lastName);
		createLead.setCompanyName(map.get("Company"));
		createLead.clickSaveBTN();

		soft.assertTrue(leadInfo.getPageHeader().contains(lastName));
		
		leadInfo.clickDuplicateBTN();
		soft.assertTrue(duplicateLead.getPageHeader().contains("Duplicating"));
		
		String newLastName = map.get("New Last Name") + jutil.generateRandom(100);
		duplicateLead.setLeadsLastName(newLastName);
		duplicateLead.clickSaveBTN();
		
		soft.assertTrue(leadInfo.getPageHeader().contains(newLastName));

		if (leadInfo.getPageHeader().contains(newLastName)) 
			excel.writeToExcel("LeadsTestData", "Create and Duplicate Lead", "Pass");
		 else 
			 excel.writeToExcel("LeadsTestData", "Create and Duplicate Lead", "Fail");
		
       soft. assertAll();


	}

}
