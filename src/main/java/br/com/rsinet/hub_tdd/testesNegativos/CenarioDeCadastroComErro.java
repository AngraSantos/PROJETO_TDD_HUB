package br.com.rsinet.hub_tdd.testesNegativos;

import static br.com.rsinet.hub_tdd.driver.DriverFactory.FechandoJanela;
import static br.com.rsinet.hub_tdd.driver.DriverFactory.inicioDriver;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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

import br.com.rsinet.hub_tdd.excel.MassaDeDados;
import br.com.rsinet.hub_tdd.pageObjects.pageObjectCadastroCliente;
import br.com.rsinet.hub_tdd.pageObjects.pageObjectTelaInicial;
import br.com.rsinet.hub_tdd.reporter.Utilitario;

public class CenarioDeCadastroComErro {

	private WebDriver driver;
	private pageObjectCadastroCliente cadastroCliente;
	private pageObjectTelaInicial telaInicial;
	ExtentReports extent;
	ExtentTest logger;
	WebDriverWait wait;
	
	MassaDeDados massaDeDadosCriarConta =  new MassaDeDados();

	@BeforeMethod
	public void beforeMethod() {

		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/cadastroNegativo.html");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest("Teste Cadastro Negativo");

		driver = inicioDriver();
		telaInicial = PageFactory.initElements(driver, pageObjectTelaInicial.class);
		cadastroCliente = PageFactory.initElements(driver, pageObjectCadastroCliente.class);
	}

	@Test
	public void deveCadastrarUmUsuarioComErro() throws Exception {

		telaInicial.clicarBotaoLogin();
		telaInicial.clicarCriarUsuario();
	
		cadastroCliente.usuario();
		cadastroCliente.email();
		cadastroCliente.senha();
		cadastroCliente.confirmeSenha();
		
		cadastroCliente.primeiroNome();
		cadastroCliente.ultimoNome();
		cadastroCliente.telefone();
		
		cadastroCliente.pais();
		cadastroCliente.cidade();
		cadastroCliente.endereco();
		cadastroCliente.estado();
		cadastroCliente.cartaoPostal();
		
		cadastroCliente.clicarCheckBox();
		cadastroCliente.clicarRegistrar();

		String url = driver.getCurrentUrl();		
		assertEquals(url, "http://www.advantageonlineshopping.com/#/register");
	
		JavascriptExecutor js;
		js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 3000);");
		
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
