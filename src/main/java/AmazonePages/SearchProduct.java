package AmazonePages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct
{
	@FindBy (xpath="//input[@id='twotabsearchtextbox']")
	private WebElement search;
	@FindBy (xpath="//span[text()='Samsung']")
	private WebElement brand;
	@FindBy (xpath="//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']//span")
	private List<WebElement> listofmobile;
	private JavascriptExecutor js;
	private WebDriver driver;
	public SearchProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	public void searchMobile()
	{
		search.sendKeys("mobile");
	    search.sendKeys(Keys.ENTER);
	}
	public void selectBrand()
	{
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", brand);
		js.executeScript("arguments[0].click();", brand);	
	}
	public void selectMobile(String searchMobile)
	{
		 for(int i=0;i<listofmobile.size();i++)
		    {
		    	String list=listofmobile.get(i).getText();
		    //	System.out.println(list);
		    	if(list.equals(searchMobile))
		    	{	
		    		listofmobile.get(i).click();
		    		break;
		    	}
		    }
	}

}
