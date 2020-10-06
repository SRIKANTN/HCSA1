package Com_ActiTime_Generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class  BaseTest implements Autoconstant
{
	static
	{
		System.setProperty(chrome_key, chrome_value);
		System.setProperty(firefox_key, firefox_value);
	}
	public WebDriver driver;
	
	@BeforeMethod
	public void precondition()
	{
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.manage().deleteAllCookies();
		 driver.get("https://demo.actitime.com");
	}
	@AfterMethod
	public void postcondition(ITestResult res)
	{
		int status  = res.getStatus();
		if(status == 2)
		{
			String name = res.getName();
			GenericUtils.getScreenShot(driver, name);
		}
		driver.close();
	}

}
