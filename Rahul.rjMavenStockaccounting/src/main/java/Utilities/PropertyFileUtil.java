package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtil {
	
	public static String getValueForKey(String key) throws Throwable
	
	{
		
		Properties configProperties=new Properties();
		FileInputStream fis=newFileInputStream("C:\\Users\\rahul.rj\\workspace\\Stockaccounting\\commonfiles\\chromedriver.exe");
		configProperties.load(fis);
		
		return configProperties.getProperty(key);
		
	}

}
