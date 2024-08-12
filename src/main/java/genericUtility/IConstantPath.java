package genericUtility;


/**
 * This interface  contains external file paths and JDBC URL
 * @author Priya Anvesh
 */

public interface IConstantPath
{
	String JDBC_URL ="jdbc:mysql://localhost:3306/advel";
	String PROPERTIES_FILE_PATH =System.getProperty("user.dir")+"/src/test/resources/data.properties";
    String EXCEL_PATH = System.getProperty("user.dir")+"/src/test/resources/VtigerCRMTestData (3).xlsx";
}
