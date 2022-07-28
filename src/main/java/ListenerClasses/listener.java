package ListenerClasses;


import org.testng.ITestListener;
import org.testng.ITestResult;



public class listener implements ITestListener {

	public void onTestStart(ITestResult result)
	{
	System.out.println(result.getName() + "Test is Start");	

	}
	
	  public void onTestSuccess(ITestResult result) 
	  {
			System.out.println(result.getName() + "Test is Passed");		    		  
	  }
	
	  public void onTestFailure(ITestResult result) 
	  {
			System.out.println(result.getName() + "Test is Failed");
	  }
	  
	  public void onTestSkipped(ITestResult result) 
	  {
			System.out.println(result.getName() + "Test is Skipped");
	 }

	}


