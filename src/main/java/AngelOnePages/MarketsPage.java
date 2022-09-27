package AngelOnePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketsPage
{
	@FindBy (xpath="//a[@id='mnMarkets_MW']")
	private WebElement watchlist;
	@FindBy (xpath="//a[@id='mnMarkets_FNO']")
	private WebElement fandOData;
	@FindBy (xpath="//a[@id='mnMarkets_Charts']")
	private WebElement charts;
	@FindBy (xpath="//a[@id='mnMarkets_OC']")
	private WebElement optionChain;
	@FindBy (xpath="//input[@id='project']")
	private WebElement searchBar;
	@FindBy (xpath="//a[@id='watchlistBuy']")
	private WebElement buy;
	public MarketsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void selectStock()
	{
		searchBar.sendKeys("");
	}
	public void openBuy()
	{
		buy.click();
	}
	
	

}
