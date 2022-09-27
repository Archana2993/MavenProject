package MesshoPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShortsForWomen
{
	
	@FindBy (xpath="//p[text()='Ravishing Glamarous Women Shorts']")
	private WebElement shorts;
	WebDriver driver;
	public ShortsForWomen(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public void selectShorts()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",shorts);
		js.executeScript("arguments[0].click();",shorts);
	}
}
