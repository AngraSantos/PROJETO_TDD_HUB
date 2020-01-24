package br.com.rsinet.hub_tdd.testesPositivos;

import static br.com.rsinet.hub_tdd.driver.DriverFactory.FechandoJanela;
import static br.com.rsinet.hub_tdd.driver.DriverFactory.inicioDriver;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.hub_tdd.pageObjects.pageObjectProduto;
import br.com.rsinet.hub_tdd.pageObjects.pageObjectTelaInicial;
import br.com.rsinet.hub_tdd.utilitario.Utilitario;

public class CenarioDeBuscaPelaTelaIncialComSucesso {

	private WebDriver driver;

	pageObjectTelaInicial telaInicial;
	ExtentReports extent;
	ExtentTest logger;
	pageObjectProduto produto;
	JavascriptExecutor js;

	@BeforeMethod
	public void beforeMethod() {

		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/BuscaPelaTelaPositiva.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest("Teste de busca pela tela Positiva");

		driver = inicioDriver();
		produto = PageFactory.initElements(driver, pageObjectProduto.class);
		telaInicial = PageFactory.initElements(driver, pageObjectTelaInicial.class);

	}

	@Test
	public void BuscandoTeste() throws Exception {

		telaInicial.deveClicarEmAlgumProdutoDaTelaInicialComSucesso();
		produto.altoFalante();
		
		String url = driver.getCurrentUrl();		
		assertEquals(url, "http://www.advantageonlineshopping.com/#/product/21");
		
		js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");
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

		logger.log(Status.INFO, "Busca pela tela inicial");

		logger.log(Status.PASS, "Concluido");

		extent.flush();

		FechandoJanela();
	}

}
