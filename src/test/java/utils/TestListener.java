package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.*;

public class TestListener implements ITestListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public void onStart(ITestContext c) {
        ExtentSparkReporter spark = new ExtentSparkReporter("reports/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
}
    public void onTestStart(ITestResult r) {
        test.set(extent.createTest(r.getMethod().getMethodName()));
}
    public void onTestSuccess(ITestResult r) { test.get().pass("Passed"); }
    public void onTestFailure(ITestResult r) { test.get().fail(r.getThrowable()); }
    public void onFinish(ITestContext c) { extent.flush(); }

}
