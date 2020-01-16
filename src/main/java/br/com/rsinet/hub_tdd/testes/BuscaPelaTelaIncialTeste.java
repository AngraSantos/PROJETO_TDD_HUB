package br.com.rsinet.hub_tdd.testes;

import static br.com.rsinet.hub_tdd.driver.DriverFactory.FechandoJanela;
import static br.com.rsinet.hub_tdd.driver.DriverFactory.inicioDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.pageObjects.Buscar;
import br.com.rsinet.hub_tdd.pageObjects.Produto;
import br.com.rsinet.hub_tdd.pageObjects.TelaInicial;

public class BuscaPelaTelaIncialTeste {

	private WebDriver driver;
	Buscar buscando;
	TelaInicial telaInicial;
	Produto produtos;

	@BeforeMethod
	public void beforeMethod() {

		driver = inicioDriver();
		telaInicial = PageFactory.initElements(driver, TelaInicial.class);
		produtos = PageFactory.initElements(driver, Produto.class);
	}

	@Test
	public void BuscandoTeste() {

		telaInicial.buscarTelaInicial();
		produtos.lnk_AltoFalanteHP.click();

	}

	@AfterMethod
	public void afterMethod() {

		FechandoJanela();
	}

}
