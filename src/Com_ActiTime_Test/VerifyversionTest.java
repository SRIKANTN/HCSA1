package Com_ActiTime_Test;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Com_ActiTime_Generic.BaseTest;
import Com_ActiTime_Generic.ExcelData;
import Com_ActiTime_Pages.actiTIMELoginPage;

public class VerifyversionTest extends BaseTest
{
	@Test(priority = 3)
	public void Verifyversion()
	{
		String title = ExcelData.getData(file_path, "TC01", 1, 2);
		actiTIMELoginPage lp = new actiTIMELoginPage(driver);
		lp.verifyTitle(title);
		
		String aVersion = lp.verifyVersion();
		String eVersion = ExcelData.getData(file_path, "TC03", 1, 0);
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(aVersion, eVersion);
		Reporter.log("Application version is "+aVersion,true);
		sa.assertAll();
		
	}

}
