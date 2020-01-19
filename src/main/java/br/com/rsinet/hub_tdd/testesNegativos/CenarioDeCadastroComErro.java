package br.com.rsinet.hub_tdd.testesNegativos;

import static br.com.rsinet.hub_tdd.driver.DriverFactory.FechandoJanela;
import static br.com.rsinet.hub_tdd.driver.DriverFactory.inicioDriver;
import static org.testng.Assert.assertEquals;

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

import br.com.rsinet.hub_tdd.excel.ExcelUtilitarios;
import br.com.rsinet.hub_tdd.pageObjects.pageObjectCadastroCliente;
import br.com.rsinet.hub_tdd.pageObjects.pageObjectTelaInicial;
import br.com.rsinet.hub_tdd.reporter.Utilitario;

public class CenarioDeCadastroComErro {

	private WebDriver driver;
	pageObjectCadastroCliente cadastroCliente;
	pageObjectTelaInicial telaInicial;
	ExtentReports extent;
	ExtentTest logger;

	@BeforeMethod
	public void beforeMethod() throws Exception {

		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/cadastroNegativo.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest("Teste Cadastro Negativo");

		driver = inicioDriver();
		telaInicial = PageFactory.initElements(driver, pageObjectTelaInicial.class);
		cadastroCliente = PageFactory.initElements(driver, pageObjectCadastroCliente.class);
		ExcelUtilitarios.setExcelFile(
				"C:\\Users\\angra.souza\\Desktop\\ToolsQAtest\\TDD_Projeto_HUB\\dadosCadastro.xlsx", "Cadastro");

	}

	@Test
	public void deveCadastrarUmUsuarioComErro() throws Exception {

		telaInicial.clicarBotaoLogin();
		cadastroCliente.preenchendoCadastroInvalido(driver);

		
		assertEquals(driver.getCurrentUrl(), "http://www.advantageonlineshopping.com/#/register");

	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			String temp = Utilitario.getScreenshot(driver);

			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			
			String temp = Utilitario.getScreenshot(driver);

			logger.pass("Sucesso", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}

		logger.log(Status.INFO, "Cadastro de cliente");

		logger.log(Status.PASS, "Concluido");

		extent.flush();

		FechandoJanela();
	}

}
