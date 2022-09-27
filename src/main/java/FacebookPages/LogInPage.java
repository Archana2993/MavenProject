package FacebookPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage
{
	WebDriver driver;
   @FindBy (xpath="//input[@id='email']")
   private WebElement email;
   @FindBy (xpath="//input[@id='pass']")
   private WebElement password;
   @FindBy (xpath="//button[@id='loginbutton']")
   private WebElement logInButton;
   @FindBy (xpath="(//div[contains(@class,'z6erz7xo on4d8346 jkp44r48 l10tt5db s8sjc6am myo4itp8 ekq1a7f9 pym4i58u ldembo95 mwa1sm0y hi696')])[5]")
   private WebElement account;
   @FindBy (xpath="(//span[contains(@class,'gvxzyvdx aeinzg81 t7p7dqev gh25dzvf exr7barw b6ax4al1 gem102v4 ncib64c9 mrvwc6qr sx8pxkcf f597kf1v cpcgwwas m2nijcs8 hxf')])[53]")
   private WebElement logout;
 
   
   public LogInPage(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);	
	   this.driver=driver;
   }
   public void sendusername (String userInfo)
   {
	   email.sendKeys(userInfo);   
   }
   public void sendpassword(String passInfo)
   {
	   password.sendKeys(passInfo);  
   }
   public void clickOnlogInButton()
   {
	   logInButton.click();

   }
   public void logOut()
   {
	   Actions act=new Actions(driver);
	   act.moveToElement(account).moveToElement(logout).click().build().perform();
   }
   
   
   
}
