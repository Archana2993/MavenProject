package TempTestNg2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import InstaPages.InstaLogInPage;
import Setup.Base;
import utils.Utility;

public class ToVerifyInstaLogInPageWithInvalidCreditioal extends Base
{
	private WebDriver driver;
	private InstaLogInPage instaLogInPage;
	private int testId=0;
	
    @Parameters("browser")
    @BeforeTest
    public void launchBrowser(String browserName)
    {
    	if(browserName.equals("Chrome"))
    	{
    		driver=openChromeBrowser();
    	}
    	if(browserName.equals("Firefox"))
		{
			driver=openFirefoxBrowser();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		
    }
    @BeforeClass
    public void createPOMObjects()
    {
    	instaLogInPage=new InstaLogInPage(driver);
    	
    }
    @BeforeMethod()
    public void openInstaLogInPage()
    {
    	driver.get("https://www.instagram.com/");
    	
    }
    @Test
    public void verifyInstaLogIn() throws IOException
    {
    	boolean result=instaLogInPage.checkButtonisEnabled();
    	Assert.assertFalse(result);
    	String email=Utility.featchDatafromExcelSheet("Insta",1,0);
    	String pass=Utility.featchDatafromExcelSheet("Insta",1,1);
    	instaLogInPage.clicklogInButton(email,pass);
    	String pageTitle=driver.getTitle();
    	System.out.println(pageTitle);
    	Assert.assertEquals(pageTitle,"Instagram");
    	
    	
    }
    @AfterMethod
    public void screenshot(ITestResult result) throws IOException
    {
    	if(ITestResult.FAILURE==result.getStatus())
    	{
    		Utility.captureScreenShot(driver, testId);
    	}
    }
    @AfterClass
    public void clearPOMObject()
    {
    	instaLogInPage=null;
    }
    @AfterTest
    public void closedBrowser()
	{
		driver.close();
		driver=null;
		System.gc();
	}
    
    
}
