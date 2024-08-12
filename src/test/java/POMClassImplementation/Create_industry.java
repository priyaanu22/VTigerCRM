package POMClassImplementation;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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

public class Create_industry {

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
		OrganizationsPage organization=new OrganizationsPage(driver);
		CreatingNewOrganizationPage createOrg=new CreatingNewOrganizationPage(driver);
		OrganizationInformationPage orgInfo=new OrganizationInformationPage(driver);
		
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
		
		home.clickRequiredTab(driverUtil, TabNames.ORGANIZATIONS);
		if(driver.getTitle().contains("Organizations"))
		{
			System.out.println("Organizations page is displayed");
		}
		else
		{
			System.out.println("Organizations page is not displayed");
		}
		
         organization.ClickCreateOrgBTN();
		
		if(createOrg.getPageHeader().equalsIgnoreCase("Creating New Organization"))
		{
			System.out.println("Creating New Organization page is diaplayed");
		}
		else
		{
			System.out.println("Creating New Organization page is not displayed");
		}
		
		Map<String, String> map = excel.readFromExcel("OrganizationsTestData", "Create Organization With Industry And Type");
		createOrg.setOrganizationName(map.get("Organization Name"));
		
		createOrg.selectFromIndustryDD(driverUtil,map.get("Industry"));
		createOrg.selectFromTypeDD(driverUtil, map.get("Type"));
		createOrg.clickSaveBTN();
        
        
		if(orgInfo.getPageHeader().contains(map.get("Organization Name")))
		{
			System.out.println("Organization created successfully");
		}
		else
		{
			System.out.println("Organization created successfully");
		}
        orgInfo.clickDeleteBTN();
       
        driverUtil.handleAlert("ok");
        if(driver.getTitle().contains("Organizations"))
		{
			System.out.println("Organizations page is displayed");
			excel.writeToExcel("OrganizationsTestData", "Create Organization With Industry And Type", "Pass");
		}
		else
		{
			System.out.println("Organizations page is not displayed");
			excel.writeToExcel("OrganizationsTestData", "Create Organization With Industry And Type", "fail");
		}
        
        excel.saveExcel(IConstantPath.EXCEL_PATH);
       home.signOutOfVtiger(driverUtil);
        excel.closeExcel();
        driverUtil.quitAllWindow();



	}

}
