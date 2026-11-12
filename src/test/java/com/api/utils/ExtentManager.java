package com.api.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	private static final String REPORT_PATH = "target/extent-report/report.html";
	private static ExtentReports extent;
	private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	
	private ExtentManager() {
		// Utility class, no instances
	}
	
	public static synchronized ExtentReports getInstance() {
		if(extent == null) {
			ExtentSparkReporter reporter = new ExtentSparkReporter(REPORT_PATH);
			reporter.config().setDocumentTitle("API Automation Report");
			reporter.config().setReportName("API Automation Framework");
			
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Base URL", ConfigReader.get("base.url"));
			extent.setSystemInfo("Java Version", System.getProperty("java.version"));
			extent.setSystemInfo("OS", System.getProperty("os.name"));
		}
		return extent;
	}
	
	public static void setTest(ExtentTest extentTest) {
		test.set(extentTest);
	}
	
	public static ExtentTest getTest() {
		return test.get();
	}
	
	public static void removeTest() {
		test.remove();
	}

}
