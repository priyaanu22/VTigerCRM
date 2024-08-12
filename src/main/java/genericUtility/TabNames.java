package genericUtility;
/**
 * This Enum store all the tabNames of Vtiger Application
 */

public enum TabNames
{
	ORGANIZATIONS("Accounts"),CONTACTS("Contacts"),LEADS("Leads");
	
	private String tabName;
	
	private TabNames(String tabName)
	{
		this.tabName = tabName;
	}
	public String getTabName()
	{
		return tabName;
		
	}

}
