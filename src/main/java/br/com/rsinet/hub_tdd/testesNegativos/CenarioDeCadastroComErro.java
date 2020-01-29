package br.com.rsinet.hub_tdd.testesNegativos;

import static br.com.rsinet.hub_tdd.driver.DriverFactory.FechandoJanela;
import static br.com.rsinet.hub_tdd.driver.DriverFactory.inicioDriver;
import static org.testng.Assert.assertEquals;

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

import br.com.rsinet.hub_tdd.excel.MassaDeDados;
import br.com.rsinet.hub_tdd.pageObjects.pageObjectCadastroCliente;
import br.com.rsinet.hub_tdd.pageObjects.pageObjectTelaInicial;
import br.com.rsinet.hub_tdd.utilitario.Utilitario;

public class CenarioDeCadastroComErro {

	private WebDriver driver;
	private pageObjectCadastroCliente cadastroCliente;
	private pageObjectTelaInicial telaInicial;
	private ExtentReports extent;
	private ExtentTest logger;
	private JavascriptExecutor js;
	private WebDriverWait wait;

	MassaDeDados massaDeDadosCriarConta = new MassaDeDados();

	@BeforeMethod
	public void beforeMethod() {

		/* executando o report */
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./target/cadastroNegativo.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest("Teste Cadastro Negativo");

		/* iniciando o driver */
		driver = inicioDriver();
		
		/* intanciando as classes */
		telaInicial = PageFactory.initElements(driver, pageObjectTelaInicial.class);
		cadastroCliente = PageFactory.initElements(driver, pageObjectCadastroCliente.class);
		wait = new WebDriverWait(driver, 50);
		
	}

	@Test
	public void deveCadastrarUmUsuarioComErro() throws Exception {

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
		
		/* rolar a tela para baixo */
		js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,100)");

		/*
		 * tempo para aguardar o print na pagina correta da tela e o assert funcionar da
		 * elemento da tela: ja tenho uma conta
		 */
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html[1]/body[1]/div[3]/section[1]/article[1]/sec-form[1]/div[2]/label[2]")));

		String url = driver.getCurrentUrl();
		System.out.println(url);
		assertEquals(url, "http://www.advantageonlineshopping.com/#/register");


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
