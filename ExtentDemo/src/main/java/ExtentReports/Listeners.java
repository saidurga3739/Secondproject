package ExtentReports;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Listeners extends ExtentManager implements ITestListener {
	// executes on the @test execution
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + "++++++++++++ Test is started");
		test=extent.createTest(result.getName());
	}

	// executes on the if @test is passed
	@Override
	public void onTestSuccess(ITestResult result) {
		 System.out.println(result.getName() + "++++++++++++ Test is succeced");
		if (result.getStatus() == ITestResult.SUCCESS) 
		{
			test.log(Status.PASS, "Pass Test case is: " + result.getName());
		}

	}

	// executes on the if @test is failed
	@Override
	public void onTestFailure(ITestResult result) {
		  if (result.getStatus() == ITestResult.FAILURE) {
		   test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
		   test.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		   String pathString = base.screenShot(base.driver, result.getName());
		   try {
		    test.addScreenCaptureFromPath(pathString);
		   } catch (Exception e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		   
		  }
		 }


	@Override
	public void onTestSkipped(ITestResult result) {
	   System.out.println(result.getName() + "++++++++++++ Test is skipped");
	   if (result.getStatus() == ITestResult.SKIP) 
	   {
			test.log(Status.SKIP, "Skipped Test case is: " + result.getName());
	   }

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	// executes before the testcase executes
	@Override
	public void onStart(ITestContext context) {
		System.out.println(context.getName() + "++++++++++++ Execution is started");

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(context.getName() + "++++++++++ Execution is Finished");

	}
}
