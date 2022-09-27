package MesshoPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnlineShoppingSiteForFashion 
{
   @FindBy (xpath="//span[text()='Women Western']")
   private WebElement womenWestern;
   @FindBy (xpath="//p[text()='Shorts']")
   private WebElement listOfWomenWestern;
   
   WebDriver driver;
   public OnlineShoppingSiteForFashion (WebDriver driver)
   {
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
   }
   public void openWomenWestern()
   {
	   Actions act=new Actions(driver);
	   act.moveToElement(womenWestern).moveToElement(listOfWomenWestern).click().build().perform();	    
	   
   }
}
