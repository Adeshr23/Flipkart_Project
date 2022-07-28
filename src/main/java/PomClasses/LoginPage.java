package PomClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.Util1;

public class LoginPage extends Util1 {


	WebDriver driver;
	
	//webElements 
	@FindBy(xpath="//input[@class='_2IX_2- VJZDxU']")
	private WebElement email;
	
	@FindBy(xpath="//input[@class='_2IX_2- _3mctLh VJZDxU']")
	private WebElement password;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	private WebElement btn;
	
	
	
	//Constructor 
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	//public Methods 
	public void enterEmail() throws IOException
	{
		email.sendKeys(getProperty("username"));
	}

	public void enterPass() throws IOException
	{
	password.sendKeys(getProperty("password"));
	}
	
	public void clickBtn()
	{
		btn.click();
	}
	
	
}
