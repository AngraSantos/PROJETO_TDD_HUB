package br.com.rsinet.hub_tdd.reporter;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemo {
	
	@Test
	public void loginTest() throws IOException {
	
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/report_automacao.html");
		
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		ExtentTest logger = extent.createTest("LoginTest");
		
		
		logger.log(Status.INFO, "Login to amazon");
		
		logger.log(Status.PASS, "Title verified");
		
		
		extent.flush();
		
		
		ExtentTest logger2 = extent.createTest("Logoff Test");
		
		logger2.log(Status.FAIL, "Title Verified");
		
		logger2.fail("Falha devido a alguns problemas", MediaEntityBuilder.createScreenCaptureFromPath("/Users/angra.souza/Documents/projetoTDD-master/logo.jpg").build());
		
		logger2.pass("Falha devido a alguns problemas", MediaEntityBuilder.createScreenCaptureFromPath("/Users/angra.souza/Documento/projetoTDD-master/logo.jpg").build());

		extent .flush();
	}		
		
}
