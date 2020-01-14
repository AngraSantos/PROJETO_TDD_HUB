package br.com.rsinet.hub_tdd.testes;

import static br.com.rsinet.hub_tdd.inicio.TelaDeAbertura.FechandoJanela;
import static br.com.rsinet.hub_tdd.inicio.TelaDeAbertura.inicioDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.pageObjects.CadastroCliente;
import br.com.rsinet.hub_tdd.pageObjects.Inicio;


public class CadastrarTeste {
	
	private WebDriver driver;
	CadastroCliente cadastroCliente;
	Inicio telaInicial;
	 
	
	@BeforeMethod
	public void beforeMethod() {
		
		driver = inicioDriver();
		telaInicial = PageFactory.initElements(driver, Inicio.class);
		cadastroCliente = PageFactory.initElements(driver, CadastroCliente.class);
		}
	
	
	@Test
	public void cadastrando() {
		
		telaInicial.clicarBotaoLogin();
		cadastroCliente.("AngraSantos");
		
		
		
		
		
		}

	
	
	@AfterMethod
	public void afterMethod() {
	
		//FechandoJanela();
	}

}
