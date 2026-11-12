package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.api.utils.ExtentManager;
import com.aventstack.extentreports.ExtentTest;

public class TestListener implements ITestListener {
	private static final Logger logger = LogManager.getLogger(TestListener.class);

	public void onStart(ITestContext context) {
		logger.info("Test Suite Started!!");
		ExtentManager.getInstance();
	}

	public void onFinish(ITestContext context) {
		logger.info("Test Suite Completed!!");
		ExtentManager.getInstance().flush();
	}
	
	public void onTestStart(ITestResult result) {
		logger.info("Started!! " + result.getMethod().getMethodName());
		logger.info("Descripton:-" + result.getMethod().getDescription());
		ExtentTest extentTest = ExtentManager.getInstance()
				.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
		ExtentManager.setTest(extentTest);
	  }

	public void onTestSuccess(ITestResult result) {
		logger.info("Success!! " + result.getMethod().getMethodName());
		ExtentManager.getTest().pass("Test passed");
		ExtentManager.removeTest();
	}

	public void onTestFailure(ITestResult result) {
		logger.error("Failed!! " + result.getMethod().getMethodName());
		ExtentManager.getTest().fail(result.getThrowable());
		ExtentManager.removeTest();
	}

	public void onTestSkipped(ITestResult result) {
		logger.error("Skipped!! " + result.getMethod().getMethodName());
		ExtentManager.getTest().skip(result.getThrowable() != null ? result.getThrowable().getMessage() : "Test skipped");
		ExtentManager.removeTest();
	}
}
