package TempTestNg2;

import java.io.IOException;
import java.util.ArrayList;
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

import AmazonePages.ProductPage;
import AmazonePages.SearchProduct;
import Setup.Base;
import utils.Utility;

public class ToVerifyProductPage extends Base
{
		private WebDriver driver;
		private ProductPage productPage ;
		private ArrayList<String> browserList;
		private SearchProduct searchProduct;
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
		   searchProduct=new SearchProduct(driver);
		   productPage  =new  ProductPage  (driver);
	     }
	   @BeforeMethod
	   public void searchProduct() throws IOException
	   {  
		   driver.get("https://www.amazon.in/"); 
		   searchProduct.searchMobile();
		   searchProduct.selectBrand();
		   String data=Utility.featchDatafromExcelSheet("Amazon", 7, 0);
		   searchProduct.selectMobile(data);
		   driver.getWindowHandles();
		   browserList=new ArrayList<String> (driver.getWindowHandles());	  
	   }
	   @Test(priority=1)
	   public void verifyaddToCart() 
	   { 
		   testId=100;
		    driver.switchTo().window(browserList.get(1));		
			productPage.addCart();
			String pageTitle=driver.getTitle();	
			System.out.println(pageTitle);
			Assert.assertEquals(pageTitle, "Samsung Galaxy M32 (Black, 4GB RAM, 64GB | FHD+ sAMOLED 90Hz Display | 6000mAh Battery | 64MP Quad Camera : Amazon.in");
			
	   }  
	   @Test(priority=2)
	   public void verifyBuyNowButton()
	   {
		   testId=101;
		   driver.switchTo().window(browserList.get(2)); 
		   productPage.clickBuyNow();
		   String pageTitle=driver.getTitle();
		   Assert.assertEquals(pageTitle, "Amazon Sign In");	
		   
	   }
	   @Test(priority=3)
	   public void verifyAddtoWishListButton()
	   { 
		   testId=102;
		   driver.switchTo().window(browserList.get(3));  
		   productPage.clickAddtoWishList();
		   String pageTitle=driver.getTitle();
		   Assert.assertEquals(pageTitle, "Amazon Sign In");
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
		public void cleanPOMObjects()
		{
		   searchProduct=null;
			productPage =null;
		}
		@AfterTest
		public void closedBrowser()
		{
			driver.quit();
			driver=null;
			System.gc();
		}
	  
	  
	}



