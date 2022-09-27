package TempTestNg2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import AmazonePages.AllTab;
import AmazonePages.WomensFashionCat;
import Setup.Base;
import utils.Utility;

public class ToVerifyAllTab extends Base
{
	private WebDriver driver;
	private AllTab allTab;
	private WomensFashionCat womensFashionCat;
	private SoftAssert soft;
	private int testId=0;
	@Parameters ("browser")
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
		allTab=new AllTab(driver);
		womensFashionCat =new WomensFashionCat (driver);		
	}
	@BeforeMethod
	public void toVerifyAllbutton()
	{
		driver.get("https://www.amazon.in/"); 
	    allTab.openAll();
	    allTab.openWomensFashion();	
	}
	
	@Test
	public void verifyHandbagsButton()
	{
		testId=1101;
		 womensFashionCat.openHandbagsPage();
		// String pageTitle=driver.getTitle();
		 String pageUrl=driver.getCurrentUrl();
		// System.out.println(pageTitle+","+pageUrl);
		  soft= new SoftAssert();
		//  soft.assertEquals(pageTitle, "Handbags: Buy Handbags and Clutch bags For Women online at best prices in India - Amazon.in");
		  soft.assertEquals(pageUrl, "https://www.amazon.in/gp/browse.html?node=1983338031&ref_=nav_em_sbc_wfashion_handbags_0_2_11_9");
		  soft.assertAll();
	}
	@Test
	public void  verifySandalsButton()
	{   testId=1102;
		womensFashionCat.openSandalsPage();
		String pageTitle=driver.getTitle();
		String pageUrl=driver.getCurrentUrl();
		 soft= new SoftAssert();
		 soft.assertEquals(pageTitle, "Buy Girls' Sandals online at best prices in India - Amazon.in");
		 soft.assertEquals(pageUrl,"https://www.amazon.in/gp/browse.html?node=1983633031&ref_=nav_em_sbc_wfashion_sandals_0_2_11_15");
		 soft.assertAll();
	}
	@AfterMethod()
	public void sscrenshot(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		   {
			   Utility.captureScreenShot(driver, testId);
		   }
	}
	@AfterClass
	public void cleanPOMObjects()
	{
		allTab=null;
		womensFashionCat =null;
	}
	@AfterTest
	public void closedBrowser()
	{
		driver.close();
		driver=null;
		System.gc();
	}
	
}
