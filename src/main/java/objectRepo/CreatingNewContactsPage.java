package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class CreatingNewContactsPage 
{
	/**
	 * This class contains elements,locators and respective business libraries of creating new contact
	 */
	//Declaration
		@FindBy(xpath="//span[@class='lvtHeaderText']")
		private WebElement pageHeader;
		
		@FindBy(name="lastname")
		private WebElement contactLastNameTF;
		
		@FindBy(name="button")
		private WebElement saveBTN;
		
		@FindBy(xpath="//img[contains(@onclick,'Accounts')]")
		private WebElement organizationPlusBTN;
		
		private String organizationPath="//a[text()='%s']";
		//Initialization
		public CreatingNewContactsPage(WebDriver driver)
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
		 * This method sets the contact name text field
		 * 
		 */
		public void setContactLastName(String name)
		{
			contactLastNameTF.sendKeys(name);
		}
		/**
		 * This method clicks on  save button
		 * 
		 */
		public void clickSaveBTN()
		{
			saveBTN.click();
		}
		
		public void selectExistingOrganization(WebDriverUtility driverUtil,String orgName)
		{
			organizationPlusBTN.click();
			driverUtil.switchToWindow("Account");
			driverUtil.convertDynamicXpathToWebElement(organizationPath, orgName).click();
			driverUtil.switchToWindow("Contacts");
		}

}
