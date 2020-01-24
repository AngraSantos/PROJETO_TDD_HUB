package br.com.rsinet.hub_tdd.testesNegativos;

import static br.com.rsinet.hub_tdd.driver.DriverFactory.FechandoJanela;
import static br.com.rsinet.hub_tdd.driver.DriverFactory.inicioDriver;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.hub_tdd.pageObjects.pageObjectTelaInicial;
import br.com.rsinet.hub_tdd.utilitario.Utilitario;

public class CenarioDeBuscaDeProdutoPelaLupaComErro {

	private WebDriver driver;

	private pageObjectTelaInicial telaInicial;
	private WebDriverWait wait;
	ExtentReports extent;
	ExtentTest logger;
	JavascriptExecutor js;

	@BeforeMethod
	public void beforeMethod() throws Exception {

		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/BuscaPelaLupaNegativa.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest("Teste de busca pela lupa negativa");

		// Usei a tecla de atalho para importa codigo (CTRL + SFHIT + M)
		// driver = TelaDeAbertura.inicioDriver();
		driver = inicioDriver();
		telaInicial = PageFactory.initElements(driver, pageObjectTelaInicial.class);
		wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void deveBuscarUmProdutoPelaLupa() throws Exception {

		telaInicial.deveBuscarAlgumProdutoPelaLupa("HP ZBOOK G2 MOBILE WORKSTATION");

		js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 3000);");
		
		assertTrue(driver.getPageSource().contains("No results for"));
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.SUCCESS) {

			String temp = Utilitario.getScreenshot(driver);

			logger.pass("Efetuado com Sucesso: ", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

		} else if (result.getStatus() == ITestResult.FAILURE) {

			String temp = Utilitario.getScreenshot(driver);

			logger.fail("Ocorreu um erro: ", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}

		logger.log(Status.INFO, "Busca pela lupa");

		logger.log(Status.PASS, "Concluido");

		extent.flush();

		FechandoJanela();
	}

}
