package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage 
{
	/**
	 * This class contains element,Locators and respective business libraries of organization information page
	 */
	//Declaration
	@FindBy(xpath="//span[contains(text(),'Organization Information')]")
    private WebElement pageHeader;
	
	@FindBy(name="Delete")
    private WebElement deleteBTN;
	
	//Initialization
    public OrganizationInformationPage(WebDriver driver)
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
	 * This method used to delete
	 * 
	 */
	 public void  clickDeleteBTN()
	{
		 deleteBTN.click();	
				
	}
	
	
	
	

}
