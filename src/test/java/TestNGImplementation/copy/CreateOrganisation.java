package TestNGImplementation.copy;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
//validate is done
public class CreateOrganisation extends BaseClass
{
	@Test(groups="organizations")
	public void createOrgTest()
	{
		OrganizationsPage organization = pageObjectManager.getOrganization();
		CreatingNewOrganizationPage createOrg = pageObjectManager.getCreateOrg();
		OrganizationInformationPage orgInfo = pageObjectManager.getOrgInfo();
		
		home.clickRequiredTab(driverUtil, TabNames.ORGANIZATIONS);
		
		soft.assertTrue(driver.getTitle().contains("Organizations"));
		
		organization.ClickCreateOrgBTN();
		
		soft.assertTrue(createOrg.getPageHeader().equalsIgnoreCase("Creating New Organization"));
		
		
		
		Map<String, String> map = excel.readFromExcel("OrganizationsTestData", "Create Organization");
		createOrg.setOrganizationName(map.get("Organization Name"));
		createOrg.clickSaveBTN();		
		
		soft.assertTrue(orgInfo.getPageHeader().contains(map.get("Organization Name")));
		
		orgInfo.clickDeleteBTN();
        driverUtil.handleAlert("ok");
        soft.assertTrue(driver.getTitle().contains("Organizations"));
        if(driver.getTitle().contains("Organizations"))
		excel.writeToExcel("OrganizationsTestData", "Create Organization", "Pass");
			
		else
		excel.writeToExcel("OrganizationsTestData", "Create Organization", "fail");
		
        soft.assertAll();
        
	}

}
