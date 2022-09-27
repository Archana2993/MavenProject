package RedBusPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
   @FindBy (xpath="//input[@id='src']") 
   private WebElement from;
   @FindBy (xpath="//input[@id='dest']")
   private WebElement to;
   @FindBy (xpath="//input[@id='onward_cal']")
   private WebElement date;
   @FindBy (xpath="//button[@id='search_btn']")
   private WebElement searchBuses;
   @FindBy (xpath="//li[@class='sub-city']")
   private List<WebElement> fromBusList;
   @FindBy (xpath="//li[@class='sub-city']")
   private List<WebElement> toBusList;
   @FindBy (xpath="//td[@class='monthTitle']")
   private WebElement month;
   @FindBy (xpath="//td[@class='next']")
   private WebElement next;	
   @FindBy (xpath="//table[@class='rb-monthTable first last']//tr//td")
   private List<WebElement> travellingDate;
   
    WebDriver driver;
  
   //constructor
   public HomePage(WebDriver driver)
   {
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
   }
   //method
   public void fromBus()
   {
	   from.sendKeys("pune");
	  
   }
   public void selectStartingPoint()
   {
	   for(int i=0;i<fromBusList.size();i++)
	   {
		   String list=fromBusList.get(i).getText();
			System.out.println(list);
			if(list.contains("Pimpri Chinchwad, Pune"))
			{
				fromBusList.get(i).click();
				break;
			}
	   }
   }
   public void toBus()
   {
	   to.sendKeys("Bangalore");
   }
   public void selectEndPoint()
   {
		for(int i=0;i<toBusList.size();i++)
		{
			String list=toBusList.get(i).getText();
			System.out.println(list);
			if(list.contains("Anand Rao Circle, Bangalore"))
			{
				toBusList.get(i).click();
				break;
			}
			
		}
   }
   public void clickDate()
   {
	  date.click(); 
   }
   public void mouseActionOnDate()
   {
	   Actions act=new Actions(driver);
	   act.moveToElement(month).moveToElement(next).click().build().perform();   
   }
   public void selectTravellingDate()
   {
	   for(int j=0;j< travellingDate.size();j++)
		{
			String date1= travellingDate.get(j).getText();
			System.out.println(date1);
			if(date1.contains("1"))
			{
				 travellingDate.get(j).click();
				break;
			}
		}
   }
   public void searchBus()
   {
	   searchBuses.click();
   }
}
