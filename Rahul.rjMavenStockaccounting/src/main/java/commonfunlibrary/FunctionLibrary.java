package commonfunlibrary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.PropertyFileUtil;

public class FunctionLibrary
{
	
	WebDriver driver;

	//StartBrowser
	public static WebDriver startBrowser(WebDriver driver) throws Throwable
	
	{
		
		if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("Chrome"))
			
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\rahul.rj\\workspace\\Stockaccounting\\commonfiles\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}else
			if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "");
				driver=new FirefoxDriver();
				
			}else
				
				if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("ie"));
		{
			
			System.setProperty("Webdriver.ie.driver", "");
			
			driver=new InternetExplorerDriver();
			
		}
				return driver;
	}	
		
	
	
	
	//Openapplication
	public static void openApplication(WebDriver driver) throws Throwable
	
	{
		driver.get(PropertyFileUtil.getValueForKey("URL"));
		driver.manage().window().maximize();
		
	}
	
	//Type action
	
	public static void typeAction(WebDriver driver, String locatorType,String locatorValue, String Data)
	{
		
		if (locatorType.equalsIgnoreCase("id"))
			
		{
			driver.findElement(By.id(locatorValue)).clear();
			driver.findElement(By.id(locatorValue)).sendKeys(Data);
	
		}else
			if(locatorType.equalsIgnoreCase("name"))
			{
				driver.findElement(By.id(locatorValue)).clear();
				driver.findElement(By.id(locatorValue)).sendKeys(Data);
	
			}else
				if(locatorType.equalsIgnoreCase("Xpath"))
					
				{
					driver.findElement(By.xpath("locatorValue")).clear();
					driver.findElement(By.xpath("locatorValue")).sendKeys(Data);
				}
				}
		//Click Action
		
		public static void clickAction(WebDriver driver, String locatorType, String locatorValue)
		
		{
			if(locatorType.equalsIgnoreCase("id"))
			{
				
				driver.findElement(By.id(locatorValue)).click();
			
			}else
				if(locatorType.equalsIgnoreCase("name"))
					
				{
					driver.findElement(By.name(locatorValue)).click();
					
				}else
					if(locatorType.equalsIgnoreCase("xpath"))
			
					{
						driver.findElement(By.xpath(locatorValue)).click();
			
					}
			
			
		}
			//close Browser
			
			public static void closeBrowser(WebDriver driver)
			
			{
				
				driver.close();
			}
			//waitForElement
			
		
			public static void waitForElement(WebDriver Driver,String locatorType,String locatorValue,String waittime)
			{
				WebDriverWait myWait=new WebDriverWait(Driver, Integer.parseInt(waittime));
					
					If(locatorType.equalsIgnoreCase("id"));
				
					{
					
						myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
					
					}
					
						
						if(locatorType.equalsIgnoreCase("name"))
							
						{
							
							myWait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
						}else
							
							if(locatorType.equalsIgnoreCase("xpath"))
							{
								
								myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
							}
					}
			
			private static void If(boolean equalsIgnoreCase) {
				// TODO Auto-generated method stub
				
			}




			//Scroll down Page
			
			public static void pagedown(WebDriver driver)
			{
				Actions action= new Actions(driver);
				
				action.sendKeys(Keys.PAGE_DOWN).build().perform();
		
			}
			//Capture supplier number
			
		public static void CaptureData(WebDriver Driver,String locatorType,String locatorValue)
		
		{
			String data="";
			
			if(locatorType.equalsIgnoreCase("id"))
			{
				
				data=Driver.findElement(By.id(locatorValue)).getAttribute("value");
			}else
				if(locatorType.equalsIgnoreCase("name"))
				{
					data=Driver.findElement(By.className(locatorValue)).getAttribute("value");
					
				}else
					
					if(locatorType.equalsIgnoreCase("xpath"))
					{
						data=Driver.findElement(By.xpath(locatorValue)).getAttribute("Value");
						}
			
			FileWriter fw=new FileWriter("C:\\Users\\rahul.rj\\workspace\\Stockaccounting\\Capturedata\\Data.txt");
			BufferedWriter bw=new BufferedWriter(fw);
				
				bw.write(data);
				bw.close();
			
			}
		
		
			
		//Supplier creation Table validation
		
		public static void tableValidation(WebDriver driver, String Column) throws Throwable
		
		{
			
			//Reading the Supplier Number  from  text file 
			FileReader fr=new FileReader("C:\\Users\\rahul.rj\\workspace\\Stockaccounting\\Capturedata.txt");
			
			BufferedReader br=new BufferedReader(fr);
			
			String exp_data=br.readLine();
			//Converting String value into integer
			int columnNum=Integer.parseInt(Column);
			
			if(driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("Search.Panel"))).isDisplayed())
			{
				driver.findElement(By.xpath("Search.Panel")).click();
				
				driver.findElement(By.id(PropertyFileUtil.getValueForKey("Search.Box"))).clear();
				
				driver.findElement(By.id(PropertyFileUtil.getValueForKey("Search.Box"))).sendKeys(exp_data);
				driver.findElement(By.id(PropertyFileUtil.getValueForKey("Search.Button"))).click();
		
			}else
				driver.findElement(By.id(PropertyFileUtil.getValueForKey("Search.Box"))).clear();
			driver.findElement(By.id(PropertyFileUtil.getValueForKey("Search.Box"))).sendKeys(exp_data);
			driver.findElement(By.id(PropertyFileUtil.getValueForKey("Search.Button"))).click();
				
		}
		
		//identifying Suppliers details WebTable
		WebElement webTable=driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("webtable")));
		
		//row count
		
		List<WebElement> rows=webTable.findElement(By.tagName("tr"));
		
		for(int i =1; i <=rows.size(); i++)
		{
			
			String act_data=driver.findElement(By.xpath(("//*[@id='ewContentColumn']/div[3]/form/div//table[@id='tbl_a_supplierslist']/tbody/tr["+i+"]/td["+columNum+"]/div/span"))).getText();
			System.out.println(act_data);
			
			//Validation
			Assert.assertArrayEquals(exp_data, act_data);
			break;
			
		}
		
		public static String generatedate()
		{
		 Date date=new Date();
		 SimpleDateFormat sdf=new SimpleDateFormat("YYYY_MM_DD_SS");
		 sdf.format(date)
			
		}
		
			
		
}	
	}



