package AmazonePages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WomensFashionCat 
{
	private WebDriver driver;
	private WebDriverWait wait;
	@FindBy (xpath="//a[contains(text(),'Handbags & Clutches')]")
	private WebElement handbags;
	
	@FindBy (xpath="//a[text()='Fashion Sandals']")
	private WebElement sandals;
	
	public WomensFashionCat(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public void openHandbagsPage()
	{
		wait=new WebDriverWait(driver,30);
		JavascriptExecutor js=(JavascriptExecutor) driver;	
		js.executeScript("arguments[0].scrollIntoView(true);",handbags);
		wait.until(ExpectedConditions.visibilityOf(handbags));
		handbags.click();
	}
	public void openSandalsPage()
	{
		wait=new WebDriverWait(driver,30);
		JavascriptExecutor js=(JavascriptExecutor) driver;	
		js.executeScript("arguments[0].scrollIntoView(true);",sandals);	
		wait.until(ExpectedConditions.visibilityOf(sandals));
		sandals.click();
	}
	

}
