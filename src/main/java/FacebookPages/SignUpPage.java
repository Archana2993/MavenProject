package FacebookPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage
{
	private WebDriver driver;
	private Select s;	
	@FindBy (xpath="//input[@name='firstname']")
	private WebElement firstname;
	@FindBy (xpath="//input[@name='lastname']")
	private WebElement surname;
	@FindBy (xpath="//input[@name='reg_email__']")
	private WebElement email;
	@FindBy (xpath="//input[@name='reg_email_confirmation__']")
	private WebElement reenteremail;	
	@FindBy (xpath="//input[@id='password_step_input']")
	private WebElement newPassword;
	@FindBy (xpath="//select[@title='Day']")
	private WebElement day;
	@FindBy (xpath="//select[@title='Month']")
	private WebElement month;
	@FindBy (xpath="//select[@title='Year']")
	private WebElement year;
	@FindBy (xpath="//label[text()='Female']")
	private WebElement gender;
	@FindBy (xpath="(//button[text()='Sign Up'])[1]")
	private WebElement signUpButton;
	
	public SignUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public void sendNewUserInformation(String user,String lastname,String mailId,String pass)
	{
		firstname.sendKeys(user);
		surname.sendKeys(lastname);
		email.sendKeys(mailId);
		newPassword.sendKeys(pass);
		
	}
	public boolean checkStatusOfEmailField()
	{
		boolean result=reenteremail.isDisplayed();
		return result;
		
	}
	public void sendDataToEmail(String entermail)
	{
		reenteremail.sendKeys(entermail);
	}
	public void selectBirthDate()
	{
		 s=new Select(day);
		 s.selectByVisibleText("2");
	     s=new Select(month);
	     s.selectByVisibleText("Sep");
	     s=new Select(year);
	     s.selectByVisibleText("1993");	
	}
	public void selectGender()
	{
		gender.click();
	}
	public void clickSignUpButton()
	{
		
		signUpButton.click();
		
	}
		

}
