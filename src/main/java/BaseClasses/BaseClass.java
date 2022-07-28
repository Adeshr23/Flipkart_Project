package BaseClasses;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import UtilityClasses.Util1;

public class BaseClass {
static WebDriver driver=null;
static ExtentHtmlReporter extentReporter = null;
static ExtentReports reports =null;
static ExtentTest test = null;



	public static WebDriver getDriver(String browser) throws IOException
	{
		System.out.println(driver);
		
		if(driver==null) 
		{
			if(browser.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Browsers\\chromedriver.exe");
				driver=new ChromeDriver();
				
			}
			else if (browser.equals("edge")) 
			{
				
				System.setProperty("webdriver.edge.driver", "src\\main\\resources\\Browsers\\msedgedriver.exe");
				driver=new EdgeDriver();
			}
			driver.get(Util1.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			return driver;
		}
		else
		{
			System.out.println("in else");
			return driver;
		}	
	}
	
	public static ExtentHtmlReporter getHtmlReporter()
	{
		if(extentReporter==null)
		{
			extentReporter=new ExtentHtmlReporter("TestReport.html");
		}
		return extentReporter;
	}
	
public static ExtentReports getReports()
{
	if(reports==null)
	{
		reports=new ExtentReports();
		reports.attachReporter(extentReporter);
	}
	return reports;
}

public static ExtentTest getExtentTest(String testName)
{
	test=reports.createTest(testName);
	return test;
			
}

	}
