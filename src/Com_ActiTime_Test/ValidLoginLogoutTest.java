package Com_ActiTime_Test;

import org.testng.annotations.Test;

import Com_ActiTime_Generic.BaseTest;
import Com_ActiTime_Generic.ExcelData;
import Com_ActiTime_Pages.actiTIMEEnterTimeTrackPage;
import Com_ActiTime_Pages.actiTIMELoginPage;

public class ValidLoginLogoutTest extends BaseTest
{
	@Test(priority = 1)
	public void ValidLoginLogout()
	{
		String un  = ExcelData.getData(file_path, "TC01", 1, 0);
		String pw  = ExcelData.getData(file_path, "TC01", 1, 1);
		String lTitle  = ExcelData.getData(file_path, "TC01", 1, 2);
		String hTitle  = ExcelData.getData(file_path, "TC01", 1, 3);
		actiTIMELoginPage lp = new actiTIMELoginPage(driver);
		actiTIMEEnterTimeTrackPage hp = new actiTIMEEnterTimeTrackPage(driver);
		//verify login page title
		lp.verifyTitle(lTitle);
		// enter valid user name
		lp.enterUserName(un);
		//enter valid password
		lp.enterPassword(pw);
		//click on login button
		lp.clickOnLogin();
		//verify time track page title
		lp.verifyTitle(hTitle);
		//click on logout button
		hp.clickOnLogout();
		//verify login page title
		lp.verifyTitle(lTitle);
	}

}
