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
import PomClasses.HomePage;
import PomClasses.LoginPage;

@Listeners(ListenerClasses.listener.class)


public class VerifyUserCanLogin {

	static WebDriver driver;
	LoginPage lp;
	
	ExtentHtmlReporter extentReporter;
	ExtentReports reports;
	ExtentTest test;
	
	
	@BeforeClass
	public void beforeClass() throws IOException
	{
		extentReporter=BaseClass.getHtmlReporter();
		reports = BaseClass.getReports();
		test=BaseClass.getExtentTest("VerifyUserCanLogin");
	
		
		driver=BaseClass.getDriver("chrome");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		lp=new LoginPage(driver);
	}
	
	@Test
	public void VerifyUserCanLogIn() throws IOException, InterruptedException 
	{
	lp.enterEmail();
	lp.enterPass();
	lp.clickBtn();
	
	HomePage hp =new HomePage(driver);
	Assert.assertTrue(hp.getProfileName());
	
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		
		if (result.getStatus()==ITestResult.SUCCESS)
		{
		test.log(Status.PASS, result.getName() + "Test is passed");	
		}else
		{
			String path = lp.getScreenshot(driver, result.getName());
			test.log(Status.FAIL,result.getName() +"test Failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
	}
	
	@AfterClass
	public void afterClass()
	{
		
	reports.flush();
	}
}




