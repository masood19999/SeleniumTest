package test;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Success");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failure "+result.getName() );
	}
}
