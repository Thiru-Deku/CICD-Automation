package testng.source;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReportNG {
	
	

	public static ExtentReports getReportObj() {
	String path = System.getProperty("user.dir")+"/reports/index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Automation Result");
	reporter.config().setDocumentTitle("Test Results");
	
	
	ExtentReports report = new ExtentReports();
	report.attachReporter(reporter);
	report.setSystemInfo("Tester", "Thiru");
	return report;
}}
