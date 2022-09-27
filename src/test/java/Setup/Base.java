package Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;


public class Base {

	static WebDriver driver;
		public static WebDriver openChromeBrowser()
		{
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Browser\\chromedriver.exe");
			 driver=new ChromeDriver();
			return driver;
		}
		public static WebDriver openFirefoxBrowser()
		{
			System.setProperty("webdriver.gecko.driver","src\\test\\resources\\Browser\\geckodriver.exe");
			driver=new FirefoxDriver();
			return driver;
		}
		
		
	
}
