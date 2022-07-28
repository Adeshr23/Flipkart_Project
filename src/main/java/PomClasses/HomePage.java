package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.Util1;

public class HomePage extends Util1 {

	WebDriver driver;
	
	
	@FindBy(xpath="//div[text()='Adesh']")
	private WebElement profileName;
	
	@FindBy(xpath="(//li[@class='_2NOVgj'])[1]")
	private WebElement profileText;	

	
	//Constructor
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	//Methods 
	
	
	public boolean getProfileName() throws InterruptedException
	{
		Thread.sleep(1000);
		explicitWait(driver, profileName);
		String pName= profileName.getText();
	
		if (pName.equals("Adesh"))
		{
		return true;
		}
		return false;
	}
	
	public void moveToProfileName()
	{
		Actions act =new Actions(driver);
		act.moveToElement(profileName).perform();
		
	}
	
	public void clickOnProfileText()
	{
		WebElement element=explicitWait(driver, profileText);
		element.click();
		
	}
}
