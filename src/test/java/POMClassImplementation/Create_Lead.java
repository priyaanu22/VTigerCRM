package POMClassImplementation;

import java.time.Duration;
import java.util.Map;

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
import objectRepo.CreatingNewLeadPage;
import objectRepo.DuplicatingPage;
import objectRepo.HomePage;
import objectRepo.LeadsInformationPage;
import objectRepo.LeadsPage;
import objectRepo.LoginPage;

public class Create_Lead {

	public static void main(String[] args) {
		propertiesutility propertyUtil = new propertiesutility();
		ExcelUtility excel = new ExcelUtility();
		JavaUtility jutil = new JavaUtility();
		WebDriverUtility driverUtil = new WebDriverUtility();

		propertyUtil.PropertiesInit(IConstantPath.PROPERTIES_FILE_PATH);
		excel.excelInit(IConstantPath.EXCEL_PATH);

		WebDriver driver = driverUtil.lanchBrowser(propertyUtil.readFromProperties("browser"));
		driverUtil.maximizeBrowser();
		driverUtil.navigateToApp(propertyUtil.readFromProperties("url"));
		long time = (long) jutil.convertStringToAnyDataType(propertyUtil.readFromProperties("timeouts"), "long");
		driverUtil.waitTillElementFound(time);

		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);
		LeadsPage leads = new LeadsPage(driver);
		DuplicatingPage duplicateLead = new DuplicatingPage(driver);
		LeadsInformationPage leadInfo = new LeadsInformationPage(driver);
		CreatingNewLeadPage createLead = new CreatingNewLeadPage(driver);

		if (driver.getTitle().contains("vtiger")) {
			System.out.println("Login page is displayed");
		} else {
			System.out.println("Login page is not displayed");
		}

		login.loginToVtiger(propertyUtil.readFromProperties("username"), propertyUtil.readFromProperties("password"));
		if (driver.getTitle().contains("Home")) {
			System.out.println("Home is displayed");
		} else {
			System.out.println("Home is not displayed");
		}
		home.clickRequiredTab(driverUtil, TabNames.LEADS);

		if (driver.getTitle().contains("Leads")) {
			System.out.println("Leads page is displayed");
		} else {
			System.out.println("Leads page is not displayed");
		}

		leads.ClickCreateLeadBTN();

		if (createLead.getPageHeader().equalsIgnoreCase("creating new lead")) {
			System.out.println("Creating  new Lead page is displayed");
		} else {
			System.out.println("Creating  new Lead page is not  displayed");

		}

		Map<String, String> map = excel.readFromExcel("LeadsTestData", "Create and Duplicate Lead");
		String lastName = map.get("Last Name")+jutil.generateRandom(100);
		createLead.setLeadsLastName(lastName);
		createLead.setCompanyName(map.get("Company"));
		createLead.clickSaveBTN();

		if (leadInfo.getPageHeader().contains(lastName))
		{
			System.out.println("Lead created successfully");
		}


		else {
			System.out.println("Lead not created successfully");
		}

		
		leadInfo.clickDuplicateBTN();
		if (duplicateLead.getPageHeader().contains("Duplicating")) 
		{
			System.out.println("Duplicate lead is displayed");

		} 
		else 
		{
			System.out.println("Duplicate lead is not displayed");

		}
		String newLastName = map.get("New Last Name") + jutil.generateRandom(100);
		duplicateLead.setLeadsLastName(newLastName);
		duplicateLead.clickSaveBTN();

		if (leadInfo.getPageHeader().contains(newLastName)) {
			System.out.println("Duplicate Lead created successfully");
			excel.writeToExcel("LeadsTestData", "Create and Duplicate Lead", "Pass");
		} else {

			System.out.println("Duplicate Lead not created successfully");
			excel.writeToExcel("LeadsTestData", "Create and Duplicate Lead", "Fail");
		}

		excel.saveExcel(IConstantPath.EXCEL_PATH);
		home.signOutOfVtiger(driverUtil);
		excel.closeExcel();
		driverUtil.quitAllWindow();

	}

}
