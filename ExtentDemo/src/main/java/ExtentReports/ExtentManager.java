package ExtentReports;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager 
{
	public static WebDriver driver;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	
	public static void setExtent() throws IOException 
	{
		sparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/test-output/ExtentReport/MyReport_"+ base.getCurrentTime()+".html");
		
		sparkReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		// SETS NAMES
//		sparkReporter.config().setDocumentTitle("Automation Test Report");
//		sparkReporter.config().setReportName("OrangeHRM Test Automation Report");
//		sparkReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		// TABLE WHEN VIEWED IN GRAPHICAL MODE
		extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "OrangeHRM");
		extent.setSystemInfo("Tester", "Durga");
		extent.setSystemInfo("OS", "Win10");
		extent.setSystemInfo("Browser", "Chrome");
	}
	
	public static void endReport() {
		extent.flush();
	}
	
}
