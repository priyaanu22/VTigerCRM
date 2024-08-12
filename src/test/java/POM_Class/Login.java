package POM_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v122.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login 
{
	//Declartion
	@FindBy(id="email")
	private WebElement emailTF;
	
	@FindBy(id="password")
	private WebElement pswdTF;
	
	@FindBy(id="keepLoggedInCheckBox")
	private WebElement KeepMeLoggedInCB;
	
	@FindBy(id="toPasswordRecoveryPageLink")
	private WebElement forgetpswdLink;
	
	@FindBy(id="last")
	private WebElement loginBTN;
	
	//Initialization
	public  Login(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	

	//utilization
	public void setEmailTF(String email) 
	{
		emailTF.sendKeys(email);
		
	}
	public void setpswdTF(String pswd) 
	{
		pswdTF.sendKeys(pswd);
		
	}
	public void clickKeepMeLoggedInCB()
	{
		KeepMeLoggedInCB.click();
	}
	public void clickforgetpswdLink()
	{
		forgetpswdLink.click();
	}
	
	public void loginBTN()
	{
		loginBTN.click();
	}
	
	

}
