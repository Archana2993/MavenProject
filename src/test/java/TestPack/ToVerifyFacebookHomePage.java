package TestPack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
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

import FacebookPages.FacebookHomePage;
import FacebookPages.LogInPage;
import FacebookPages.SignUpPage;
import Setup.Base;
import utils.Utility;

public class ToVerifyFacebookHomePage extends Base
{
	private WebDriver driver;
	private FacebookHomePage facebookHomePage;
	private SignUpPage signUpPage;
	private LogInPage logInPage;
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
		facebookHomePage=new FacebookHomePage(driver);
		signUpPage =new SignUpPage(driver);
		logInPage=new LogInPage(driver);
		
	}
	@BeforeMethod
	public void verifyHomePage()
	{
		driver.get("https://www.facebook.com/signup");
		
	}
	@Test()
	public void toVerifySignUpPage() throws IOException
	{
		testId=1201;
		facebookHomePage.openSignUpPage();
		String name=Utility.featchDatafromExcelSheet("SignUpData", 1, 0);
		String lastname=Utility.featchDatafromExcelSheet("SignUpData", 1, 1);
		String mail=Utility.featchDatafromExcelSheet("SignUpData", 1, 2);
		String pass=Utility.featchDatafromExcelSheet("SignUpData", 1, 3);
		signUpPage.sendNewUserInformation(name ,lastname,mail,pass);
		boolean status=signUpPage.checkStatusOfEmailField();
		Assert.assertTrue(status);
		signUpPage.sendDataToEmail(mail);
		signUpPage.selectBirthDate();
		signUpPage.selectGender();
		String title=driver.getTitle();
		Assert.assertEquals(title, "Facebook");
	//	signUpPage.clickSignUpButton();
		//Assert.assertEquals(lastname, mail, pass);
	}
	@Test
	public void toVerifyLogInPage() throws IOException,EncryptedDocumentException
	{
		testId=1202;
		facebookHomePage.openLogInPage();
		String user=Utility.featchDatafromExcelSheet("LogIn", 1, 0);
		System.out.println(user);
		String pass=Utility.featchDatafromExcelSheet("LogIn", 1, 1);
		System.out.println(pass);
		logInPage.sendusername(user);
		logInPage.sendpassword(pass);
		logInPage.clickOnlogInButton();
		String title=driver.getTitle();
		Assert.assertEquals(title, "(2) Facebook","The password that you've entered is incorrect. Forgotten password?");
	//	logInPage.logOut();
		
	}
	@AfterMethod()
	public void logOutFromaaplication (ITestResult result) throws IOException
	{
		
		if(ITestResult.FAILURE==result.getStatus())
		   {
			   Utility.captureScreenShot(driver, testId);
		   }
	}
	@AfterClass
	public void cleanPOMObjects()
	{
		facebookHomePage=null;
		signUpPage =null;
	}
	@AfterTest
	public void closedBrowser()
	{
		driver.close();
		driver=null;
		System.gc();
	}
	
	
}
