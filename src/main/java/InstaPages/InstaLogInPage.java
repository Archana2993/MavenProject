package InstaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InstaLogInPage {
	
	WebDriver driver;

		//private WebElement(Variable) Encapsulation
		@FindBy (xpath="//input[@name='username']") 
		private WebElement userName;
		@FindBy (xpath="//input[@name='password']") 
		private WebElement password;
		@FindBy (xpath="//button[@type='submit']") 
		private WebElement logInButton;
		//constructor 
		public InstaLogInPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			this.driver=driver;
		}
        
		//method
		public boolean checkButtonisEnabled()
		{
			
			return logInButton.isEnabled();
		}
		

		public void clicklogInButton(String mail,String passw)
		{
			userName.sendKeys(mail);
			password.sendKeys(passw);                                      
			WebDriverWait wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(logInButton));
			logInButton.click();
			
		}
		
		
	

}
