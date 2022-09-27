package AngelOnePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage 
{
	private WebDriver driver;
	@FindBy (xpath="//a[text()='A1131253 ']")
	private WebElement account;
	@FindBy (xpath="//a[text()='Logout']")
	private WebElement louOut;
	public LogOutPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	public void clickOnLogOut()
	{
		Actions act=new Actions(driver);
		account.click();
		act.moveToElement(louOut).click().build().perform();
		
	}

}
