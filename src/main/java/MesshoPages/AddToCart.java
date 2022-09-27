package MesshoPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart 
{
	private WebDriver driver;
	@FindBy (xpath="(//span[text()='30'])[1]")
	private WebElement size;
	@FindBy (xpath="//span[text()='Add to Cart']")
	private WebElement addToCart;
	
	public AddToCart(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void selectSize()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",size);	
	}
	public void clickAddToCart()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",addToCart);
		js.executeScript("arguments[0].click();",addToCart);;
	}
}
