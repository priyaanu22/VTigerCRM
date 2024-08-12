package TestNGImplementation.copy;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelUtility;
import genericUtility.IConstantPath;
import genericUtility.JavaUtility;
import genericUtility.TabNames;
import genericUtility.WebDriverUtility;
import genericUtility.propertiesutility;
import objectRepo.CreatingNewOrganizationPage;
import objectRepo.HomePage;
import objectRepo.LoginPage;
import objectRepo.OrganizationInformationPage;
import objectRepo.OrganizationsPage;

@Listeners(genericUtility.ListernerImplementation.class)
public class Create_industry  extends BaseClass
{
	@Test(groups="organizations")
	public void createIndustryTest()
	{
	    OrganizationsPage organization=pageObjectManager.getOrganization();
		CreatingNewOrganizationPage createOrg=pageObjectManager.getCreateOrg();
		OrganizationInformationPage orgInfo=pageObjectManager.getOrgInfo();
		
		
		home.clickRequiredTab(driverUtil, TabNames.ORGANIZATIONS);
		soft.assertTrue(driver.getTitle().contains("Organizations"));
		
         organization.ClickCreateOrgBTN();
		
		soft.assertTrue(createOrg.getPageHeader().equalsIgnoreCase("Creating New Organization"));
		
		Map<String, String> map = excel.readFromExcel("OrganizationsTestData", "Create Organization With Industry And Type");
		createOrg.setOrganizationName(map.get("Organization Name"));
		
		createOrg.selectFromIndustryDD(driverUtil,map.get("Industry"));
		createOrg.selectFromTypeDD(driverUtil, map.get("Type"));
		createOrg.clickSaveBTN();
        
        
		soft.assertTrue(orgInfo.getPageHeader().contains(map.get("Organization Name")));
		
        orgInfo.clickDeleteBTN();
       
        driverUtil.handleAlert("ok");
        soft.assertTrue(driver.getTitle().contains("Organizations"));
		if(driver.getTitle().contains("Organizations"))
        
			excel.writeToExcel("OrganizationsTestData", "Create Organization With Industry And Type", "Pass");
		else
		   excel.writeToExcel("OrganizationsTestData", "Create Organization With Industry And Type", "fail");
		   
		soft.assertAll();
        
        


	}

}
