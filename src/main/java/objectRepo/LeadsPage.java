package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage
{
	/**
	 * This class contains element,Locators and respective business libraries of Leads page
	 */
	//Declaration
	@FindBy(xpath="//img[@alt='Create Lead...']")
	private WebElement creatLeadBTN;	

	//Initialization		
	public LeadsPage(WebDriver driver)
	{
	  PageFactory.initElements(driver,this);
	}
	
	//Utilization
	/**
	 * This method click on the create leads button
	 */	
	public void ClickCreateLeadBTN()
	{
		creatLeadBTN.click();
	}
		
}
