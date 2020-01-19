package br.com.rsinet.hub_tdd.testesNegativos;

import static br.com.rsinet.hub_tdd.driver.DriverFactory.FechandoJanela;
import static br.com.rsinet.hub_tdd.driver.DriverFactory.inicioDriver;

import java.io.IOException;

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

import br.com.rsinet.hub_tdd.pageObjects.pageObjectBuscar;
import br.com.rsinet.hub_tdd.pageObjects.pageObjectTelaInicial;
import br.com.rsinet.hub_tdd.reporter.Utilitario;

public class CenarioDeBuscaPelaTelaIncialComErro {

	private WebDriver driver;

	pageObjectBuscar buscando;
	pageObjectTelaInicial telaInicial;
	ExtentReports extent;
	ExtentTest logger;

	@BeforeMethod
	public void beforeMethod() {

		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/BuscaPelaTelaNegativa.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest("Teste de busca pela tela Negativa");

		driver = inicioDriver();
		buscando = PageFactory.initElements(driver, pageObjectBuscar.class);

	}

	@Test
	public void BuscandoTeste() throws Exception {

		buscando.deveClicarEmAlgumProdutoDaTelaInicialComErro();

		/*
		 * O wait não estava dando o tempo de espera nesta linha, que serviria para
		 * tirar o print da tela, então usei o Thread.sleep
		 */
		
		Thread.sleep(3000);

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

		logger.log(Status.INFO, "Busca pela tela incial");

		logger.log(Status.PASS, "Concluido");

		extent.flush();

		FechandoJanela();
	}

}