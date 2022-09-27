package AngelOnePages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage
{
	private WebDriver driver;
	@FindBy (xpath="//input[@id='txtUserID']")
	private WebElement user;
	@FindBy (xpath="//input[@id='txtTradingPassword']")
	private WebElement password;
	@FindBy (xpath="//a[@id='loginBtn']")
	private WebElement loginButton;
	@FindBy (xpath="//button[@id='tabclose']")
	private WebElement tabClose;
	@FindBy (xpath="(//button[@data-ipocode='HARSHA_Upcoming'])[3]")
	private WebElement upcoming;
	
	public LogInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public void clickOnSignInButon()
	{
		user.sendKeys("A1131253");
		password.sendKeys("Sameer@2993");
		loginButton.click();
	}
	public void closePopUp()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		tabClose.click();
		js.executeScript("arguments[0].click();",upcoming);
	}
}
