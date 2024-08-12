package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage 
{

	//Declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgBTN;
	
	//Initialization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	
	public void ClickCreateOrgBTN()
	{
		createOrgBTN.click();
	}


	}


