package AmazonePages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage 
{
	@FindBy (xpath="//input[@id='add-to-cart-button']")
	private WebElement addToCart;
	@FindBy (xpath="//a[@title='Add to Wish List']")
	private WebElement addtoWishList; 
	@FindBy (xpath="//input[@id='buy-now-button']")
	private WebElement buyNow; 
	
	
    private WebDriver driver;
    private  WebDriverWait wait;
    private JavascriptExecutor js;
    
    
    public ProductPage (WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    	this.driver=driver;
    	js=(JavascriptExecutor) driver;

    }
    public void addCart() 
    {
    	wait= new WebDriverWait(driver,10);
    	wait.until(ExpectedConditions.visibilityOf(addToCart));
    	js.executeScript("arguments[0].scrollIntoView(true)",addToCart);
    	
	    addToCart.click();  	
    }
 
    public void clickAddtoWishList()
    {
    	wait= new WebDriverWait(driver,10);
    	wait.until(ExpectedConditions.elementToBeClickable(addtoWishList));  
        js.executeScript("arguments[0].scrollIntoView(true)",addtoWishList);
        addtoWishList.click(); 
    }
    public void clickBuyNow()
    {
    	wait= new WebDriverWait(driver,10);
    	wait.until(ExpectedConditions.elementToBeClickable(buyNow));  
        js.executeScript("arguments[0].scrollIntoView(true)",buyNow);
        buyNow.click(); 
    }
}
