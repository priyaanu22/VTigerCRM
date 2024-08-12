package genericUtility;


import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class JavaUtility
{
/**
 *  This method generates random number within specified limit
 * @param limit
 * @return
 */
	public int generateRandom(int limit)
	{
		Random random = new Random();
		return random.nextInt(limit);
	
	}
	/**
	 * This method pauses the script for the specified time
	 * @param time
	 */
	
	public void waiting(long time)
	{
		try {
			Thread.sleep(time);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		
		}
	}
	/**
	 * This me
	 * 
	 * thod returns system date and time in string format
	 * @author Priya Anvesh
	 * 
	 */
	public String getCurrentTime()
	{
		 Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yy_hh_ss");
		return sdf.format(date);
	}
	
	public Object  convertStringToAnyDataType(String data ,String datatype)
	{
		Object obj = null;
		switch(datatype)
		{
		case "int":
			obj = Integer.parseInt(data);
			break;
		case "float":
			obj=Float.parseFloat(data);
			break;
		case "double":
			obj=Double.parseDouble(data);
			break;
		case "long":
			obj=Long.parseLong(data);
			break;
		default:
			System.out.println("Invalid dataType");
		}
		return obj;
		
	}
	
	public Object  convertStringToAnyDataType(String data ,Datatype datatype)
	{
		Object obj = null;
		if (datatype.toString().equalsIgnoreCase("int"))
			obj =Integer.parseInt(data);
		else if (datatype.toString().equalsIgnoreCase("float"))
		    obj=Float.parseFloat(data);
		else if (datatype.toString().equalsIgnoreCase("double"))	
			obj=Double.parseDouble(data);
		else if (datatype.toString().equalsIgnoreCase("long"))	
			obj=Long.parseLong(data);
		else 
			System.out.println("Invalid dataType");
		
		return obj;
		
	}
	
	
		public int convertMonthToInt(String month) 
		{
			return DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(month).get(ChronoField.MONTH_OF_YEAR);		
	     
		}
		/**
		 * This method spilts a string based on the split strategy provided
		 * @param str
		 * @param splitstrategy
		 * @return
		 */
		
		public String[] splitString(String str,String splitstrategy)
		{
			return str.split(splitstrategy);
		}


	
}


