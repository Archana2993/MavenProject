package TempTestNg2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import InstaPages.InstaLogInPage;
import Setup.Base;

public class ToVerifyInstaLogInPageWithInvalidCreditioal extends Base
{
	private WebDriver driver;
	private InstaLogInPage instaLogInPage;
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
    public void verifyInstaLogIn()
    {
    	boolean result=instaLogInPage.checkButtonisEnabled();
    	Assert.assertFalse(result);
    	instaLogInPage.clicklogInButton();
    	String pageTitle=driver.getTitle();
    	System.out.println(pageTitle);
    	Assert.assertEquals(pageTitle,"Instagram");
    	
    	
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
