package DriverFactory;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Utilities.ExcelFilesUtils;
import commonfunlibrary.FunctionLibrary;

public class DriverScript


{
	WebDriver driver;
	ExtentReports reports;
	ExtentTest logger;
	
	
	
	
public void startTest() throws Throwable
{
	//Create Object for reusing Excel MEhtods
	
	ExcelFilesUtils excel=new ExcelFilesUtils();
	
  //Working with "MasterTestCases Sheet"
	
	
	for (int i = 1; i <=excel.rowCount("c"); i++)
	
	{
		
		if(excel.getData("MasterTestCases", i, 2).equalsIgnoreCase("Y"))
			
			
		{
			//Define Module (Test Cases) Name
			
			String TcModule=excel.getData("MasterTestCases", i, 1);
			reports=new ExtentReports("C:\\Users\\rahul.rj\\workspace\\Stockaccounting\\Reports"+TcModule+FunctionLibrary)
			//Working with "TCmodule Test cases" Sheet
			
			int rowcount=excel.rowCount(TcModule);
			for (int j = 1; j <=rowcount; j++)
			
			{
				String Description=excel.getData(TcModule, j, 0);
				String Object_Type=excel.getData(TcModule, j, 1);
				String Locator_Type=excel.getData(TcModule, j, 2);
				String Locator_Value=excel.getData(TcModule, j, 3);
				String Test_Data=excel.getData(TcModule, j, 4);
				try
				{

				 if(Object_Type.equalsIgnoreCase("startBrowser"))
				 {
					 driver=FunctionLibrary.startBrowser(driver);
					 Logger.log(Logstatus.INFO, Description);
				 }
				 if(Object_Type.equalsIgnoreCase("openApplication"))
					 
				 {
					 FunctionLibrary.openApplication(driver);
					 Logger.log(Logstatus.INFO,Description);
				
					 }
				 if(Object_Type.equalsIgnoreCase("typeAction"))
						 {
							 
							 FunctionLibrary.typeAction(driver,Locator_Type,Locator_Value,Test_Data);
							 Logger.log(Logstatus.INFO,Description);
						 }
				 if(Object_Type.equalsIgnoreCase("clickAction"))
					 
				 {
					 FunctionLibrary.clickAction(driver, Locator_Type,Locator_Value);
					 Logger.log(Logstatus.INFO,Description);
				
				 }
				 
				 if(Object_Type.equalsIgnoreCase("waitForElement"))
					 
				 {
					 FunctionLibrary.waitForElement(driver, Locator_Type, Locator_Value, Test_Data);
					 Logger.log(Logstatus.INFO,Description);
					 
					 
				 }
				 
				 if(Object_Type.equalsIgnoreCase("closeBrowser"))
					 
				 {
					 FunctionLibrary.closeBrowser(driver);
					 
				 }
			}
			
			
		}
			
	}
}

}
}
