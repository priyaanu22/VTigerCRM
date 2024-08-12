package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class CreatingNewOrganizationPage 
{
	/**
	 * This class contains elements,locators and respective business libraries of creating new organizationPage
	 */
	//Declaration
		@FindBy(xpath="//span[text()='Creating New Organization']")
		private WebElement pageHeader;
		
		@FindBy(name="accountname")
		private WebElement organizationNameTF;
		
		@FindBy(name="button")
		private WebElement saveBTN;
		
		@FindBy(name="industry")
		private WebElement industryDD;
		
		@FindBy(name="accounttype")
		private WebElement typeDD;
		
		
		//Initialization
		public CreatingNewOrganizationPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
				
		//utilization
		/**
		 * This method fetches the page header
		 * 

		 */
		public String  getPageHeader()
		{
			return pageHeader.getText();
		
		}
		/**
		 * This method sets the organization name
		 * 
		 */
		public void setOrganizationName(String name)
		{
			organizationNameTF.sendKeys(name);
		}
		/**
		 * This method clicks on  save button
		 * 
		 */
		public void clickSaveBTN()
		{
			saveBTN.click();
		}
		/**
		 * This method is used to select the industry from industry drop down
		 * 
		 */
		public void selectFromIndustryDD(WebDriverUtility driverutil ,String value)
		{
			driverutil.handleDropdown(industryDD,value);
		}
		/**
		 * This method is used to select the type from type drop down
		 * 
		 */
		
		public void selectFromTypeDD(WebDriverUtility driverutil ,String value)
		{
			driverutil.handleDropdown(typeDD,value);
		}
		
		
		

}
