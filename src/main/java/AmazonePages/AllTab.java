package AmazonePages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllTab 
{
	private WebDriver driver;
	private JavascriptExecutor js;
	@FindBy (xpath="//a[@id='nav-hamburger-menu']")
	private WebElement all;
	@FindBy (xpath="//a[@data-menu-id='11']")
	private WebElement womensFashion;
	
	public AllTab (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	public void openAll()
	{
		all.click();
	}
	public void openWomensFashion()
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(womensFashion));
	    js= (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true)",womensFashion);
	    womensFashion.click();
	}

}
