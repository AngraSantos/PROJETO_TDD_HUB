package br.com.rsinet.hub_tdd.testes;

import static br.com.rsinet.hub_tdd.driver.DriverFactory.FechandoJanela;
import static br.com.rsinet.hub_tdd.driver.DriverFactory.inicioDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.pageObjects.pageObjectBuscar;
import br.com.rsinet.hub_tdd.pageObjects.pageObjectProduto;
import br.com.rsinet.hub_tdd.pageObjects.pageObjectTelaInicial;

public class BuscarLupaTeste {

	private WebDriver driver;

	
	pageObjectTelaInicial telaInicial;
	pageObjectProduto Produtos;
	pageObjectBuscar buscando;

	@BeforeMethod
	public void beforeMethod() {

		// Usei a tecla de atalho para importa codigo (CTRL + SFHIT + M)
		// driver = TelaDeAbertura.inicioDriver();
		
		driver = inicioDriver();
		telaInicial = PageFactory.initElements(driver, pageObjectTelaInicial.class);
		Produtos = PageFactory.initElements(driver, pageObjectProduto.class);
		buscando = PageFactory.initElements(driver, pageObjectBuscar.class);
	}

	@Test
	public void BuscarTeste() {

		buscando.buscandoPelaLupa("laptop");
		Produtos.laptop();
	}
	

	@AfterMethod
	public void afterMethod() {

		FechandoJanela();
	}

}
