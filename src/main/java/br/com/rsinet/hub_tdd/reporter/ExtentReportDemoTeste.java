package br.com.rsinet.hub_tdd.reporter;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemoTeste {
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
		
	@BeforeMethod
	public void setup() {
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/report_automacaooo.html");
		
		extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		logger = extent.createTest("LoginTest");
	}
	
	@Test
	public void loginTest() throws IOException	{
		
		driver=new ChromeDriver();

		driver.get("http://www.google.com.br");
	
		
		System.out.println("title is " + driver.getTitle());
		
		Assert.assertTrue(driver.getTitle().contains("Angra"));
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		
		if (result.getStatus() == ITestResult.FAILURE)
		{
			String temp = Utilitario.getScreenshot(driver);
			
			logger.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(temp).build());		
		}
		
		extent.flush();
		driver.quit();
	}
}


