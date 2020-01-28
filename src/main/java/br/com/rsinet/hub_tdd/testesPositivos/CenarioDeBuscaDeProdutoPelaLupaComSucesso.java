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

public class CenarioDeBuscaDeProdutoPelaLupaComSucesso {

	private WebDriver driver;
	private pageObjectTelaInicial telaInicial;
	private pageObjectProduto Produtos;
	private ExtentReports extent;
	private ExtentTest logger;
	private WebDriverWait wait;
//	private JavascriptExecutor  js;

	@BeforeMethod
	public void beforeMethod() throws Exception {
	
		/* executando o report */
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/BuscaPelaLupaPositiva.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest("Teste de busca positiva");

		// Usei a tecla de atalho para importa codigo (CTRL + SFHIT + M)
		// driver = TelaDeAbertura.inicioDriver();
		/* iniciando o driver */
		driver = inicioDriver();
		
		telaInicial = PageFactory.initElements(driver, pageObjectTelaInicial.class);
		Produtos = PageFactory.initElements(driver, pageObjectProduto.class);
		wait = new WebDriverWait(driver, 20);
	}

	@Test
	public void deveBuscarUmProdutoPelaLupa() throws Exception {

		/*Buscando produto existente no site*/
		telaInicial.deveBuscarAlgumProdutoPelaLupa("laptop");
		Produtos.laptop15z();

		/*
		 * tempo para aguardar o print na pagina correta da tela e o assert funcionar da
		 * elemento da tela: imagem do laptop
		 */
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html[1]/body[1]/div[3]/section[1]/article[1]/div[2]/div[1]/figure[1]/img[1]")));
		
//		js = (JavascriptExecutor) driver;
//		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");

		String url = driver.getCurrentUrl();	
		System.out.println(url);
		assertEquals(url, "http://www.advantageonlineshopping.com/#/product/2?viewAll=laptop");

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
		
		logger.log(Status.INFO, "Busca pela lupa");
		logger.log(Status.PASS, "Concluido");
		
		extent.flush();

		FechandoJanela();
	}

}
