package genericUtility;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;



import objectRepo.CreatingNewOrganizationPage;
import objectRepo.HomePage;
import objectRepo.LoginPage;
import objectRepo.OrganizationInformationPage;
import objectRepo.OrganizationsPage;
import objectRepo.PageObjectManager;

public class BaseClass 
{
	//@BeforeSuit
	//@BeforeTest
	protected propertiesutility propertyUtil;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility driverUtil;
	protected WebDriver driver;
	
	protected static WebDriver sdriver;
	protected static JavaUtility sjutil;
	
	
	protected PageObjectManager pageObjectManager;
	protected LoginPage login;
	protected HomePage home;
	protected SoftAssert soft;
	//@Parameters("BROWSER")
	@BeforeClass(groups="important")
	public void ClassConfiguration()
	{

        propertyUtil = new propertiesutility();
		 excel = new ExcelUtility();
		 jutil= new JavaUtility();
		 driverUtil= new WebDriverUtility();
		 
		 propertyUtil.PropertiesInit(IConstantPath.PROPERTIES_FILE_PATH);
		 excel.excelInit(IConstantPath.EXCEL_PATH);
		 //driver=driverUtil.lanchBrowser(browser);
		 driver =driverUtil.lanchBrowser(propertyUtil.readFromProperties("browser"));
		 driverUtil.maximizeBrowser();
		 long time = (long)jutil.convertStringToAnyDataType(propertyUtil.readFromProperties("timeouts"),"long");
		 driverUtil.waitTillElementFound(time);
		 
		 sdriver=driver;
		 sjutil=jutil;
	}
	@BeforeMethod(groups="important")
	public void methodConfiguration()
	{
		driverUtil.navigateToApp(propertyUtil.readFromProperties("url"));
		pageObjectManager =new PageObjectManager(driver);
		login =pageObjectManager.getLogin();
		home = pageObjectManager.getHome();
		soft= new SoftAssert();
		Assert.assertTrue(driver.getTitle().contains("vtiger"));
		login.loginToVtiger(propertyUtil.readFromProperties("username"),propertyUtil.readFromProperties("password"));
		Assert.assertTrue(driver.getTitle().contains("Home"));
		
		
	}
	@AfterMethod(groups="important")
	public void methodTeardown()
	{
      excel.saveExcel(IConstantPath.EXCEL_PATH); 
        
        home.signOutOfVtiger(driverUtil);
       
	}
	@AfterClass(groups="important")
	public void classTeardown()
	{
		 excel.closeExcel();
	     driverUtil.quitAllWindow();
	}
	
	//@AfterTest
	//@AfterSuite
	
	
	
	

}
