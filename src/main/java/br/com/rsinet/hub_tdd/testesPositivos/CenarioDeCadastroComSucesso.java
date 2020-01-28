package br.com.rsinet.hub_tdd.testesPositivos;

import static br.com.rsinet.hub_tdd.driver.DriverFactory.FechandoJanela;
import static br.com.rsinet.hub_tdd.driver.DriverFactory.inicioDriver;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
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

import br.com.rsinet.hub_tdd.excel.MassaDeDados;
import br.com.rsinet.hub_tdd.pageObjects.pageObjectCadastroCliente;
import br.com.rsinet.hub_tdd.pageObjects.pageObjectTelaInicial;
import br.com.rsinet.hub_tdd.utilitario.Utilitario;

public class CenarioDeCadastroComSucesso {

	private WebDriver driver;
	private pageObjectCadastroCliente cadastroCliente;
	private pageObjectTelaInicial telaInicial;
	private ExtentReports extent;
	private ExtentTest logger;
	private WebDriverWait wait;
//  private JavascriptExecutor js;

	MassaDeDados massaDeDadosCriarConta = new MassaDeDados();

	@BeforeMethod
	public void beforeMethod() throws Exception {

		/* executando o report */
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/cadastroPositivo.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest("Teste Cadastro positivo");

		/* iniciando o driver */
		driver = inicioDriver();

		/* intanciando as classes */
		telaInicial = PageFactory.initElements(driver, pageObjectTelaInicial.class);
		cadastroCliente = PageFactory.initElements(driver, pageObjectCadastroCliente.class);
		wait = new WebDriverWait(driver, 50);

	}

	@Test
	public void deveCadastrarUmUsuarioComSucesso() throws Exception {

		/* lançando informações do teste de cadastro */
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

		/*
		 * tempo para aguardar o print na pagina correta da tela e o assert funcionar da
		 * elemento da tela: nome usuario
		 */
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html[1]/body[1]/header[1]/nav[1]/ul[1]/li[3]/a[1]/span[1]")));
		
		// js = (JavascriptExecutor) driver;
		// js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");

		String url = driver.getCurrentUrl();
		System.out.println(url);
		assertEquals(url, "http://www.advantageonlineshopping.com/#/");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		
		/* print junto com o report */
		if (result.getStatus() == ITestResult.SUCCESS) {
			String temp = Utilitario.getScreenshot(driver);
			logger.pass("Efetuado com Sucesso: ", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			String temp = Utilitario.getScreenshot(driver);
			logger.fail("Ocorreu um erro: ", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		
		logger.log(Status.INFO, "Cadastro do cliente");
		logger.log(Status.PASS, "Concluido");

		extent.flush();

		/* fechando driver */
		FechandoJanela();
	}

}
