package Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementation implements ITestListener
{
	
	@Override
	public void onStart(ITestContext context) {
		System.err.println("OnStart");
	}

	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.err.println("OnTestSucess");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.err.println("OnTestFailure");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.err.println("OnTestSkipped");
	}

	
	@Override
	public void onFinish(ITestContext context) {
		System.err.println("OnFinsh");
	}

	

}
