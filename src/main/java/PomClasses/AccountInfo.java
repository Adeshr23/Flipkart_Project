package PomClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.Util1;

public class AccountInfo extends Util1 {

	WebDriver driver;
	
	//Webelements
	
	@FindBy(xpath="//div[@class='_1ruvv2']")
	private WebElement profileFullName;
	
	@FindBy(xpath="//div[text()='Manage Addresses']")
	private WebElement manageAddress;
	
	@FindBy(xpath="//div[@class='_1QhEVk']")
	private WebElement addBtn;
	
	@FindBy(xpath="//div[@class='_1lRtwc _1Jqgld']/input")
	private List<WebElement> addressFields;
	
	@FindBy(xpath="//textarea")
	private WebElement fullAddress;

	@FindBy(xpath="//div[@class='_1XFPmK']")
	private WebElement addressType;
   
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//div[@class='_1CeZIA']")
	private List<WebElement> savedAddressCount;
	
	@FindBy(xpath="//span[text()='Logout']")
	private WebElement logoutBtn;
	

//Constructor	
	
	
	public AccountInfo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	//Methods
	
	public boolean getFullProfileName()
	{
		WebElement element=explicitWait(driver, profileFullName);
		String fullName=element.getText();
		//String fullname =profileFullName.getText();
		
		if(fullName.contains("Adesh"))
		{
			return true;
		}
		return false;
	}
	
	public void clickmanageAddress()
	{
		manageAddress.click();
	}
	
	public void clickAddAddress()
	{
		addBtn.click();
	}
	
	public void fillAddressFields()
	{
		String[] a = {"Sandesh Raut", "9130838618", "411046", "Katraj"};
		
		for(int i=0; i<4; i++)
		{
			addressFields.get(i).sendKeys(a[i]);
		}
	}
	
	public void fillFullAddress()
	{
		fullAddress.sendKeys("A Wing, Flat No.27, Near Katraj Udyan");
   }
	
	
	public void clickAddressType()
	{
	addressType.click();	
	}
	
	public void clickOnSaveBtn()
	{
		saveBtn.click();
		
	}
	
	public int savedAddressCount()
	{
		return savedAddressCount.size();
	}
	
	public void clickLogoutBtn()
	{
	logoutBtn.click();	
	}
	
	
}
