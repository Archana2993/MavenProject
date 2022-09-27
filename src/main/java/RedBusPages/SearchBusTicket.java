package RedBusPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchBusTicket 
{
	@FindBy (xpath="(//div[text()='View Seats'])[2]")
	private WebElement bus;
	@FindBy (xpath="(//div[text()='View Seats'])[2]")
	private List<WebElement> checkbox;
	
	public SearchBusTicket(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void checkBoxSelect()
	{
		for(int j=0;j<checkbox.size();j++)
		{
			String box=checkbox.get(j).getText();
			System.out.println(box);
			if(box.contains("After 6 pm"))
			{
				checkbox.get(j).click();
				
			}
			if(box.contains("SLEEPER"))
			{
				checkbox.get(j).click();
				break;
			}
		}
	}
	public void searchBus()
	{
		bus.click();
	}
	

}
