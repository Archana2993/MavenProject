package FacebookPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookHomePage
{
	private WebDriver driver;
	private JavascriptExecutor js;
	
	@FindBy (xpath="//a[text()='Sign Up']")
	private WebElement signUp;
	@FindBy (xpath="//a[text()='Log in']")
	private WebElement logIn;
	@FindBy (xpath="//a[text()='Messenger']")
	private WebElement messenger;
	
	public FacebookHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		js=(JavascriptExecutor) driver;
	}
	public void openSignUpPage()
	{
		js.executeScript("arguments[0].scrollIntoView(true);", signUp);
		signUp.click();
	}
	public void openLogInPage()
	{
		js.executeScript("arguments[0].scrollIntoView(true);", logIn);
		logIn.click();
	}	
	
	public void openMessengerPage()
	{
		js.executeScript("arguments[0].scrollIntoView(true);", messenger);
		messenger.click();
	}	
	
	
	
}
