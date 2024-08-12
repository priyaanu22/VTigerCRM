package genericUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;




/**
 * This class contains reusable method to perform driver related operations 
 * @param <JavaUtility>
 */
public class WebDriverUtility 
{
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	Select select;
	/**
	 * This method lanches the user desired browser
	 * 
	 */
	public WebDriver lanchBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("Chrome"))
			driver=new ChromeDriver();
		else if(browser.equalsIgnoreCase("Edge"))
			driver=new EdgeDriver();
		else if(browser.equalsIgnoreCase("Firefox"))
			driver=new FirefoxDriver();
		return driver;
		
	}
/**
 * This method maximizes the browser window
 */
	public  void maximizeBrowser() 
	{
		driver.manage().window().maximize();
		
	}
	/**
	 * This method navigates to an application 
	 * 
	 */
	public void navigateToApp(String url)
	{
		driver.get(url);
		
	}
	/**
	 * This method waits untill element or elements are found
	 */
	public void waitTillElementFound(long time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	/**
	 * This method waits untill element is displayed on the web page
	 * @param wait 
	 */
	
	
	public WebElement  explicitwait(long time, WebElement element)
	{
		wait =new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method waits untill element 
	 * @param wait 
	 */
	
	
	public WebElement  explicitwait(WebElement element,long time)
	{
		wait =new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method waits untill element 
	 * @param wait 
	 */
	
	
	public Boolean  explicitwait(long time,String title)
	{
		wait =new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * This Method is used to mouse hover on an element
	 * 
	 */
	public void mouseHover(WebElement element)
	{
		actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	/**
	 * This Method is used to perform double click on an element
	 * 
	 */
	public void doubleClickOnElement(WebElement element)
	{
		actions = new Actions(driver);
		actions.doubleClick().perform();
	}
	/**
	 * This Method is used to perform Right click on an element
	 * 
	 */
	public void rightClick(WebElement element)
	{
		actions = new Actions(driver);
		actions.contextClick().perform();
	}
	/**
	 * This method is used to drag and drop an element to destination
	 */
	public void dragAndDropAnElement(WebElement element,WebElement dest)
	{
		actions = new Actions(driver);
		actions.dragAndDrop(element, dest).perform();
		
	}
	/**
	 * This method select an option from drop down based on index
	 * @param element
	 * @param index
	 */
	
	public void handleDropdown(WebElement element,int index)
	{
	 select =new Select(element);
	 select.selectByIndex(index);
		
	}
	/**
	 * This method select an option from drop down based on value attribute
	 * @param element
	 * @param value
	 */
	
	public void handleDropdown(WebElement element,String value)
	{
	 select =new Select(element);
	 select.selectByValue(value);
		
	}
	/**
	 * This method select an option from drop down based on visible text
	 * @param element
	 * @param value
	 */
	
	public void handleDropdown(String text,WebElement element)
	{
	 select =new Select(element);
	 select.selectByVisibleText(text);
		
	}
	
	/**
	 * This method is used to Switch to frame based  index
	 * @param index
	 */
	
	public void switchToFrame(int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to Switch to frame based on id or name attribute
	 * @param idOrNameAttribute
	 */
	
	public void switchToFrame(String idOrNameAttribute)
	{
		driver.switchTo().frame(idOrNameAttribute);
	}
	/**
	 * This method is used to Switch to frame based on frameElement
	 * @param frameElement
	 */
	
	public void switchToFrame(WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	/**
	 * This method is used to Switch to back from frame 
	 */
	public void switchBackFromFrame()
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method captures the screenshot of a web page
	 * @param driver
	 * @return
	 */
	public String getScreenshot(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		return ts.getScreenshotAs(OutputType.BASE64);
	}
	/**
	 * This method captures the screenshot of a web page
	 * @param driver
	 * @param className
	 * @param jutil
	 * @return
	 */
	public String getScreenshot(WebDriver driver, String className, JavaUtility jutil) 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshots/" + className + "_" + jutil.getCurrentTime()+ ".png"); 
																	
		try {
			FileUtils.copyFile(temp, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest.getAbsolutePath();
	}
	
	/**
	 * This method scroll till the element based on element
	 * @param element
	 */
	
	public void scrollToElement(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoview(true)",element);
	}
	
	/**
	 * This method scroll till the element based on element location
	 * @param loction
	 */
	public void scrollToElement(Point location)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+ location.getX()+","+ location.getY()+")");
	}
	/**
	 * This method handles alert popup
	 * @param status
	 */
	
	public void handleAlert(String status)
	{
		if(status.equalsIgnoreCase("ok"))
			driver.switchTo().alert().accept();
		else
			driver.switchTo().alert().dismiss();;
			
	}
	public String getParentWindowId()
	{
		return driver.getWindowHandle();
	}
	
	/**
	 * This methos=d switches to exected window or tab based on window title
	 * @param expectedTitle
	 */
	public void switchToWindow(String expectedurl)
	{
		Set<String> windowIds =driver.getWindowHandles();
//		for (String id :windowIds)
//		{
//			driver.switchTo().window(id);
//			if(driver.getTitle().contains(expectedTitle)) 
//				break;
//		
//		}
		Iterator<String> it = windowIds.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			if(driver.getTitle().contains(expectedurl)) 
				break;
		}
	}
	/**
	 * This method closes the current Window
	 */
	public void closeWindow()
	{
		driver.close();
	}
	/**
	 * This method closes all the  Window
	 */
	public void quitAllWindow()
	{
		driver.quit();
	}
	
	
	public WebElement convertDynamicXpathToWebElement(String dynamicPath, String replaceData) 
	{
		return driver.findElement(By.xpath(String.format(dynamicPath, replaceData)));

	}
	



	
}
