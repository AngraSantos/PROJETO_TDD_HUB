package br.com.rsinet.hub_tdd.testes;

import static br.com.rsinet.hub_tdd.inicio.TelaDeAbertura.FechandoJanela;
import static br.com.rsinet.hub_tdd.inicio.TelaDeAbertura.inicioDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.inicio.Inicio;
import br.com.rsinet.hub_tdd.pageObjects.Produto;

public class BuscarLupaTeste {

	private WebDriver driver;
	Inicio telaInicial;
	Produto Produtos;

	@BeforeMethod
	public void beforeMethod() {

		// Usei a tecla de atalho para importa codigo (CTRL + SFHIT + M)
		// driver = TelaDeAbertura.inicioDriver();
		driver = inicioDriver();
		telaInicial = PageFactory.initElements(driver, Inicio.class);
		Produtos = PageFactory.initElements(driver, Produto.class);
		
	}

	@Test
	public void BuscarTeste() {

		telaInicial.buscarCaixaDeTexto("laptop");
		Produtos.lnk_laptopPavilion.click();
	}

	@AfterMethod
	public void afterMethod() {

		FechandoJanela();
	}

}
