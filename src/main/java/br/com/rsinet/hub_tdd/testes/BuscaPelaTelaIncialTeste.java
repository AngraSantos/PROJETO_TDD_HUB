package br.com.rsinet.hub_tdd.testes;

import static br.com.rsinet.hub_tdd.driver.DriverFactory.FechandoJanela;
import static br.com.rsinet.hub_tdd.driver.DriverFactory.inicioDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.pageObjects.pageObjectTelaInicial;
import br.com.rsinet.hub_tdd.pageObjects.pageObjectBuscar;

public class BuscaPelaTelaIncialTeste {

	private WebDriver driver;
	
	pageObjectBuscar buscando;
	pageObjectTelaInicial telaInicial;

	@BeforeMethod
	public void beforeMethod() {

		driver = inicioDriver();
		buscando = PageFactory.initElements(driver, pageObjectBuscar.class);

	}

	@Test
	public void BuscandoTeste() {

		
		buscando.buscarPorClick();

	}

	@AfterMethod
	public void afterMethod() {

		FechandoJanela();
	}

}
