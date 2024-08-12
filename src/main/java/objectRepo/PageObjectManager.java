package objectRepo;

import org.openqa.selenium.WebDriver;

public class PageObjectManager
{
//	LoginPage login;
//    HomePage home;
//	OrganizationsPage organization;
//	ContactsPage contacts;
//	LeadsPage leads;
//	CreateToDoPage createToDo;
//	CreatingNewOrganizationPage createOrg;
//	CreatingNewContactsPage createcontact;
//	CreatingNewLeadPage createlead;
//	OrganizationInformationPage orgInfo;
//	ContactInformationPage contactInfo;
//	LeadsInformationPage leadInfo;
//	EventInformationPage eventInfo;
//	DuplicatingPage duplicateLead;
//	
	WebDriver driver;
	public PageObjectManager(WebDriver driver) 
	{
		this.driver=driver;
	}

	public LoginPage getLogin() 
	{
		return new LoginPage(driver);
	}



	public HomePage getHome() 
	{
		return new HomePage(driver);
	}



	public OrganizationsPage getOrganization() {
		return new OrganizationsPage(driver);
	}



	public ContactsPage getContacts() {
		return new ContactsPage(driver);
	}



	public LeadsPage getLeads() {
		return new LeadsPage(driver);
	}



	public CreateToDoPage getCreateToDo() {
		return new CreateToDoPage(driver);
	}



	public CreatingNewOrganizationPage getCreateOrg() {
		return new CreatingNewOrganizationPage(driver);
	}



	public CreatingNewContactsPage getCreatecontact() 
	{
		return new CreatingNewContactsPage(driver);
	}



	public CreatingNewLeadPage getCreatelead() {
		return new CreatingNewLeadPage(driver);
	}



	public OrganizationInformationPage getOrgInfo() {
		return new OrganizationInformationPage(driver);
	}



	public ContactInformationPage getContactInfo() {
		return new ContactInformationPage(driver);
	}



	public LeadsInformationPage getLeadInfo() 
	{
		return new LeadsInformationPage(driver);
	}



	public EventInformationPage getEventInfo() 
	{
		return new EventInformationPage(driver);
	}



	public DuplicatingPage getDuplicateLead()
	{
		return new DuplicatingPage(driver);
	}



	public WebDriver getDriver() 
	{
		return driver;
	}




}
