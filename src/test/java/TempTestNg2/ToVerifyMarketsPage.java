package TempTestNg2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AngelOnePages.HeaderPage;
import AngelOnePages.LogInPage;
import AngelOnePages.LogOutPage;

public class ToVerifyMarketsPage 
{
		private WebDriver driver;
		LogInPage logInPage;
		HeaderPage headerPage;
		@BeforeClass
		public void luanchBrowser()
		
		{
			System.setProperty("webdriver.chrome.driver","D:\\Sotware tesing\\Selenium\\New folder\\chromedriver.exe");
		    driver=new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
			
		}
		@BeforeMethod
		public void openApplicationPage()
		{
			driver.get("https://trade.angelbroking.com/Login");
			logInPage=new LogInPage(driver);
			logInPage.clickOnSignInButon();
			logInPage.closePopUp();
		}
		@Test
		public void toVerifyMarketsPage()
		{
		    headerPage=new HeaderPage(driver);
			headerPage.openMarkets();
			String pageTitle=driver.getTitle();
			String pageUrl=driver.getCurrentUrl();	
			Assert.assertEquals(pageTitle,"Web Trading Platform | Angel One");
			Assert.assertEquals(pageUrl, "https://trade.angelbroking.com/trade/trading/watchlist");
			
		}
		
		@AfterMethod
		public void logOutApplication()
		{
			LogOutPage logOutPage=new LogOutPage(driver);
			logOutPage.clickOnLogOut();
		}
		@AfterClass
		public void closeBrowser()
		{
			driver.close();
		}
		

}
