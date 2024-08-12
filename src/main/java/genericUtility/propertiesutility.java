package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*
 * This class contains resuable method to read data from properties file
 */

public class propertiesutility 
{
	private Properties property;
	
	/*
	 * 
	 * This method initializes properties file
	 */
	public void PropertiesInit(String filepath)
	{
		//properties pr=new properties ();
		//FileInputStream fis =new FileInputStream();
		//pr.load(fis);
		FileInputStream fis = null;
		try {
			fis=new FileInputStream(filepath);
		    }
		catch(FileNotFoundException e) 
		{
			e.printStackTrace();
			
		}
		 property = new Properties();
		try
		{
			property.load(fis);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			
		}
	}
	
		
		/*
		 * This method fetches the value of the key specified from properties file 		 */
		
		public String readFromProperties(String key)
		{
			return property.getProperty(key);
		}
		
	}

	


