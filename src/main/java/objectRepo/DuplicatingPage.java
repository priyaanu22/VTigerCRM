package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DuplicatingPage
{
	/**
	 * This class contains elements,locators and respective business libraries of Duplicating 
	 */
	//Declaration
		@FindBy(xpath="//span[contains(text(),'Duplicating')]")
		private WebElement pageHeader;
		
		@FindBy(name="lastname")
		private WebElement leadLastNameTF;
		
		@FindBy(name="company")
		private WebElement CompanyTF;
		
		@FindBy(name="button")
		private WebElement SaveBTN;
		
		//Initialization
		public DuplicatingPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		public String  getPageHeader()
		{
			return pageHeader.getText();
		
		}
		
		public void setLeadsLastName(String name)
		{
			leadLastNameTF.clear();
			leadLastNameTF.sendKeys(name);
		}
		
		public void setCompanyName(String company)
		{
			leadLastNameTF.clear();
			leadLastNameTF.sendKeys(company);
		}
		
		
		
		public void clickSaveBTN()
		{
			SaveBTN.click();
		}
		
		
		
		

}
