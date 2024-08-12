package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.Datatype;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;

public class CreateToDoPage 
{
	/**
	 * This class contains element,Locators and respective business libraries of create to do
	 */
	//Declaration
	@FindBy(name="subject")
	private WebElement subjectTF;
	
	@FindBy(id="jscal_trigger_date_start")
	private WebElement startDateWidget;
	
	@FindBy(xpath="//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")
	private WebElement calendarTitle;	
	
	private String CalendarCommonPath="//div[@class='calendar' and contains(@style,'block')]/descendant::td[text()='%s']";
	
	@FindBy(id="jscal_trigger_due_date")
	private WebElement dueDateWidget;
	
	@FindBy(xpath="//input[@value='  Save']")
	private WebElement saveBTN;
	
	// Initialization
	public CreateToDoPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}	
	
	// Utilization
	/**
	 * This method is used to see the subject of event
	 * 
	 * 
	 */
	public void setSubject(String subject) 
	{
		subjectTF.sendKeys("subject");
	}
	/**
	 * This method click on the start date calendar widget
	 */
	
	public void clickStartDateWidget() 
	{
		startDateWidget.click();
	}
	/**
	 * This method click on the due date calendar widget
	 * @param subject
	 */
	public void clickdueDateWidget() 
	{
		dueDateWidget.click();
	}
	
	public void datepicker(JavaUtility jutil, WebDriverUtility driverUtil, String reqDate)
	{
		String[] startDate = jutil.splitString(reqDate, "-");
		int reqStartYear = (Integer) jutil.convertStringToAnyDataType(startDate[0], Datatype.INT);
		String reqStartDate = startDate[2];
		int reqStartMonth = jutil.convertMonthToInt(startDate[1]);

		String currentMonthYear = calendarTitle.getText();	
		String[] str = jutil.splitString(currentMonthYear, ", ");
		int currentYear = (Integer) jutil.convertStringToAnyDataType(str[1], "int");

		
		while (currentYear < reqStartYear) 
		{
			driverUtil.convertDynamicXpathToWebElement(CalendarCommonPath, "»").click();
			currentMonthYear =calendarTitle.getText();
			str = jutil.splitString(currentMonthYear, ", ");
			currentYear = (Integer) jutil.convertStringToAnyDataType(str[1], "int");
		}

		int currentMonth = jutil.convertMonthToInt(str[0]);

		while (currentMonth < reqStartMonth) 
		{
			driverUtil.convertDynamicXpathToWebElement(CalendarCommonPath, "›").click();
			currentMonthYear = calendarTitle.getText();
			str = jutil.splitString(currentMonthYear, ", ");
			currentMonth = jutil.convertMonthToInt(str[0]);
		}

		while (currentMonth > reqStartMonth) 
		{
			driverUtil.convertDynamicXpathToWebElement(CalendarCommonPath, "‹").click();
			currentMonthYear = calendarTitle.getText();
			str = jutil.splitString(currentMonthYear, ", ");
			currentMonth = jutil.convertMonthToInt(str[0]);
		}
		driverUtil.convertDynamicXpathToWebElement(CalendarCommonPath, reqStartDate).click();

		
	}
	public void clickSaveBTN()
	{
		saveBTN.click();
	}

	
	

			

	
	

}
