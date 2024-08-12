package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsInformationPage 
{
	@FindBy(xpath="//span[contains(text(),'Lead Information')]")
	private WebElement pageHeader;
	
	@FindBy(name="Duplicate")
	  private WebElement duplicateBTN;
	
	// Initialization
	public LeadsInformationPage(WebDriver driver) 
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
	public void clickDuplicateBTN()
	{
		duplicateBTN.click();
	}

}
