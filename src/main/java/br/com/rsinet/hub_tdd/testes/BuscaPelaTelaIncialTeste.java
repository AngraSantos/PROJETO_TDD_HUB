package br.com.rsinet.hub_tdd.testes;

import static br.com.rsinet.hub_tdd.inicio.TelaDeAbertura.FechandoJanela;
import static br.com.rsinet.hub_tdd.inicio.TelaDeAbertura.inicioDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.pageObjects.Buscar;
import br.com.rsinet.hub_tdd.pageObjects.Inicio;
import br.com.rsinet.hub_tdd.pageObjects.Produto;

public class BuscaPelaTelaIncialTeste {

	private WebDriver driver;
	Buscar buscando;
	Inicio telaInicial;
	Produto produtos;

	@BeforeMethod
	public void beforeMethod() {

		driver = inicioDriver();
		telaInicial = PageFactory.initElements(driver, Inicio.class);
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
