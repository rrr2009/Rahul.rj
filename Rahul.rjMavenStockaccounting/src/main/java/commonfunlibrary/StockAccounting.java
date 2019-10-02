package commonfunlibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class StockAccounting
{

	WebDriver driver;
	
   String res;
	public String appLaunch(String url)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rahul.rj\\workspace\\Stockaccounting\\commonfiles\\chromedriver.exe");

				driver=new ChromeDriver();
				driver.manage().window().maximize();
		        driver.get(url);
		        
		        if (driver.findElement(By.id("username")).isDisplayed())
		        {
		        	res="Pass";
		        }else
		        
		        {
		        res="fail";
		        }
		        
		        return res;
	}  	
	
	
	//appLogin
	public String appLogin (String username,String password)
	{
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		
		driver.findElement(By.id("btnsubmit")).click();
		//validation
		if(driver.findElement(By.id("logout")).isDisplayed())
{
	res="pass";
}else
	
{
	res="fail";
	
	
}

    return res;
	
	}
	
	//applogout
	public String applogout() throws Throwable
	
	{
		Thread.sleep(2000);
		driver.findElement(By.id("logout")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='OK!']")).click();
		Thread.sleep(2000);
		
		//validation
		
		if(driver.findElement(By.id("username")).isDisplayed())

		{
			res="pass";
			
		}else
			
		{
			res="fail";
			
		}
		
		return res;
	}
		//appclose
	
	public void appclose()
	
	{
		
		driver.close();
		
	}
	
	//supplierCreation
			public void supplierCreation(String sName,String add,String City,String Country,String cPerson,String pNumber,String email,String mNumber,String Notes)
			
			{
				driver.findElement(By.id("mi_a_suppliers"));
				driver.findElement(By.xpath("//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
				String Exp_data=driver.findElement(By.id("x_Supplier_Number")).getAttribute("value");
				System.out.println(Exp_data);
				driver.findElement(By.id("el_a_suppliers_Supplier_Name")).sendKeys(sName);
				driver.findElement(By.id("el_a_suppliers_Address")).sendKeys(add);
				driver.findElement(By.id("el_a_suppliers_City")).sendKeys(City);
				driver.findElement(By.id("el_a_suppliers_Country")).sendKeys(Country);
				driver.findElement(By.id("el_a_suppliers_Contact_Person")).sendKeys(cPerson);
				driver.findElement(By.id("el_a_suppliers_Phone_Number")).sendKeys(pNumber);
				driver.findElement(By.id("el_a_suppliers__Email")).sendKeys(email);
				driver.findElement(By.id("el_a_suppliers_Mobile_Number")).sendKeys(mNumber);
				driver.findElement(By.id("el_a_suppliers_Notes")).sendKeys(Notes);
				driver.findElement(By.id("btn btn-primary ewButton")).click();
			
			//scroll down the page
				Actions Action=new Actions(driver);
				
			}	
		
	
	public static void main (String[] args) throws Throwable
	
	{
		StockAccounting app=new StockAccounting();
		
		System.out.println(app.appLaunch("http://webapp.qedge.com"));
		System.out.println(app.appLogin("admin", "master"));
		
		
				//System.out.println(app.appLogout());
				//app.appClose();
		
	}
	
	
}
