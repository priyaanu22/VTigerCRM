package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage 
{
	/**
	 * This class contains element,Locators and respective business libraries of Contacts page
	 */
	//Declaration
		@FindBy(xpath="//img[@alt='Create Contact...']")
		private WebElement creatContactBTN;
		
	//Initialization
	public ContactsPage(WebDriver driver)
	{
	  PageFactory.initElements(driver,this);
	}
		
	//Utilization
	/**
	 * This method click on the create contact button
	 */
	public void ClickCreatecontactBTN()
	{
		creatContactBTN.click();
	}

}
