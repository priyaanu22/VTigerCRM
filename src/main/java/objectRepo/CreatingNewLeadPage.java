package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewLeadPage 
{
	/**
	 * This class contains elements,locators and respective business libraries of Duplicating 
	 */
	//Declaration
		@FindBy(xpath="//span[text()='Creating New Lead']")
		private WebElement pageHeader;
		
		@FindBy(name="lastname")
		private WebElement leadLastNameTF;
		
		@FindBy(name="company")
		private WebElement CompanyTF;
		
		@FindBy(name="button")
		private WebElement SaveBTN;
		
		//Initialization
		public CreatingNewLeadPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		public String  getPageHeader()
		{
			return pageHeader.getText();
		
		}
		
		public void setLeadsLastName(String name)
		{
			
			leadLastNameTF.sendKeys(name);
		}
		
		public void setCompanyName(String company)
		{
			
			CompanyTF.sendKeys(company);
		}
		
		
		
		public void clickSaveBTN()
		{
			SaveBTN.click();
		}
		
		

}
