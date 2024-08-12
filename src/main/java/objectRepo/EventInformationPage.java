package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventInformationPage 
{
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
    private WebElement pageHeader;

   @FindBy(name="Delete")
   private WebElement deleteBTN;
	// Initialization
	public EventInformationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	// Utilization
	/**
	 * This method returns page header
	 * 
	 */
	public String getPageHeader()
	{
		return  pageHeader.getText();
	}
	/**
	 * This method clicks on delete button
	 * 
	 */
	public void clickDeleteBTN()
	{
		deleteBTN.click();
	}
	
	

}
