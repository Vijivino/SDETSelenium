package com.testNG;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Testlistener implements ITestListener{
	
	public void onTestStart(ITestResult result) {
	    // not implemented
		System.out.println(result.getName()+"started...");
	  }
	
	public void onTestSuccess(ITestResult result) {
	    // not implemented
		System.out.println(result.getStatus()+"successfully...");
	  }

	 
	  public void onTestFailure(ITestResult result) {
	    // not implemented
		  System.out.println(result.getStatus()+"failed,check screenshot...");
	  }


}
