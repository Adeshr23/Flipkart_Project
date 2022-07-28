package TestClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BaseClasses.BaseClass;
import PomClasses.AccountInfo;
import PomClasses.HomePage;

@Listeners(ListenerClasses.listener.class)

public class VerifyAccountInfo {

	static WebDriver driver;
	 HomePage hp;
	 AccountInfo ai;
	
	 
	 ExtentHtmlReporter extentReporter;
	 ExtentReports reports;
	 ExtentTest test;
	
	
	 @BeforeClass
	 public void beforeClass() throws IOException
	 {
		 extentReporter=BaseClass.getHtmlReporter();
		 reports =BaseClass.getReports();
		 test=BaseClass.getExtentTest("VerifyAccountInfo");
		 
		 driver= BaseClass.getDriver("chrome");
	 }
	 
	 @BeforeMethod
	 public void beforeMethod()
	 {
		 hp= new HomePage(driver);
	 }
	 
	@Test
	public void VerifyUserAccountInfo()
	{
		hp.moveToProfileName();
		hp.clickOnProfileText();
		hp.moveMouse(driver);
		
		 ai = new AccountInfo(driver);
		Assert.assertTrue(ai.getFullProfileName());
		
	}
	
	@Test(priority=1)
	public void verifyusercanAddAddress() throws InterruptedException
	{
	ai.clickmanageAddress();
	
	int previousAddressCount = ai.savedAddressCount();
	System.out.println(previousAddressCount);
	
	ai.clickAddAddress();
	ai.fillAddressFields();
	ai.fillFullAddress();
	ai.clickAddressType();
	ai.clickOnSaveBtn();
	
	Thread.sleep(3000);
	int currentcount = ai.savedAddressCount();
	Assert.assertEquals(currentcount, previousAddressCount +1);
	
	ai.clickLogoutBtn();
	
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
			if (result.getStatus()==ITestResult.SUCCESS)
			{
			test.log(Status.PASS, result.getName() + "Test is passed");	
			}else
			{
				String path = hp.getScreenshot(driver, result.getName());
				test.log(Status.FAIL,result.getName() +  " test failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			}
		}
	
	@AfterClass
	public void afterClass()
	{
		reports.flush();
		
	}
}
