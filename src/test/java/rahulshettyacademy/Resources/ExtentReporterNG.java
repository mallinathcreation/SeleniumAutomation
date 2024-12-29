package rahulshettyacademy.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	//public static ExtentReports extent;
	
	public static ExtentReports getExtentReport()
	
	{
		// two classes are there for Extent Report -- 1) ExtentSparkReporter - Helper
		// class that is used to create the report
		// 2) ExtentReports - it is responsible for drive all your report that is being
		// created by ExtendSparkReporter

		// ExtentSparkReporter - this class accepts the string- the path of the report
		// or file

		String path = System.getProperty("user.dir") + "//reports//index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		// to set the report name
		reporter.config().setReportName("Web Automation Report");

		// to set the report title
		reporter.config().setDocumentTitle("Test Results");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);

		// to give the tester name in the info
		extent.setSystemInfo("Tester", "Mallinath Basu");
		
		return extent;

	}





}
