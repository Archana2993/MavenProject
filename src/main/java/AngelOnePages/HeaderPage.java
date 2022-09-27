package AngelOnePages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
	
	@FindBy (xpath="//a[@class='dropdown-toggle']")
	private List< WebElement > headerList;
	public HeaderPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void openDashboard()
	{
		for(int i=0;i<headerList.size();i++)
		{
			String header=headerList.get(i).getText();
			if(header.equals("Dashboard"))
			{
				headerList.get(i).click();
				break;
			}
			
		}
	}
	public void openPortfolio()
	{
		
		for(int i=0;i<headerList.size();i++)
		{
			String header=headerList.get(i).getText();
			if(header.equals("Portfolio"))
			{
				headerList.get(i).click();
				break;
			}
			
		}
	}
	public void openMarkets()
	{
		for(int i=0;i<headerList.size();i++)
		{
			String header=headerList.get(i).getText();
			if(header.equals("Markets"))
			{
				headerList.get(i).click();
				break;
			}
			
		}
		
	}
	public void openOrders()
	{
		for(int i=0;i<headerList.size();i++)
		{
			String header=headerList.get(i).getText();
			if(header.equals("Orders"))
			{
				headerList.get(i).click();
				break;
			}
			
		}
		
	}
	public void openAdvisory()
	{
		for(int i=0;i<headerList.size();i++)
		{
			String header=headerList.get(i).getText();
			if(header.equals("Advisory"))
			{
				headerList.get(i).click();
				break;
			}
			
		}
		
	}
	public void openFunds()
	{
		for(int i=0;i<headerList.size();i++)
		{
			String header=headerList.get(i).getText();
			if(header.equals("Funds"))
			{
				headerList.get(i).click();
				break;
			}	
		}
	}
	public void openReports()
	{
		for(int i=0;i<headerList.size();i++)
		{
			String header=headerList.get(i).getText();
			if(header.equals("Reports"))
			{
				headerList.get(i).click();
				break;
			}	
		}
	}
	public void openMore()
	{
		for(int i=0;i<headerList.size();i++)
		{
			String header=headerList.get(i).getText();
			if(header.equals("More"))
			{
				headerList.get(i).click();
				break;
			}	
		}
	}
}
