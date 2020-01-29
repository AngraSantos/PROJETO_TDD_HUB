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

import br.com.rsinet.hub_tdd.pageObjects.pageObjectProduto;
import br.com.rsinet.hub_tdd.pageObjects.pageObjectTelaInicial;
import br.com.rsinet.hub_tdd.utilitario.Utilitario;

public class CenarioDeBuscaPelaTelaInicialComSucesso {

	private WebDriver driver;
	private pageObjectProduto produto;
	private pageObjectTelaInicial telaInicial;
	private WebDriverWait wait;
	private ExtentReports extent;
	private ExtentTest logger;
//	private JavascriptExecutor js;

	@BeforeMethod
	public void beforeMethod() {

		/* executando o report */
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./target/BuscaPelaTelaPositiva.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest("Teste de busca pela tela Positiva");

		/* iniciando o driver */
		driver = inicioDriver();

		/* intanciando as classes */
		produto = PageFactory.initElements(driver, pageObjectProduto.class);
		telaInicial = PageFactory.initElements(driver, pageObjectTelaInicial.class);
		wait = new WebDriverWait(driver, 50);

	}

	@Test
	public void BuscandoTeste() throws Exception {
		
		/* executando o teste de busca pela tela inicial */
		telaInicial.deveClicarEmAlgumProdutoDaTelaInicialComSucesso();
		produto.altoFalante();

		/*
		 * tempo para aguardar o print na pagina correta da tela e o assert funcionar da
		 * elemento da tela: imagem da caixa de som
		 */
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html[1]/body[1]/div[3]/section[1]/article[1]/div[2]/div[1]/figure[1]/img[1]")));

//		js = (JavascriptExecutor) driver;
//		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		assertEquals(url, "http://www.advantageonlineshopping.com/#/product/21");
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
		
		logger.log(Status.INFO, "Busca pela tela inicial");

		logger.log(Status.PASS, "Concluido");

		extent.flush();

		/* fechando driver */
		FechandoJanela();
	}

}
