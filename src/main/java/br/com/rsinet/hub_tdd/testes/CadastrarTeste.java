package br.com.rsinet.hub_tdd.testes;

import static br.com.rsinet.hub_tdd.driver.DriverFactory.FechandoJanela;
import static br.com.rsinet.hub_tdd.driver.DriverFactory.inicioDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.pageObjects.pageObjectCadastroCliente;
import br.com.rsinet.hub_tdd.pageObjects.pageObjectTelaInicial;
import br.com.rsinet.hub_tdd.utilitarios.ExcelUtilitarios;

public class CadastrarTeste {

	private WebDriver driver;
	pageObjectCadastroCliente cadastroCliente;
	pageObjectTelaInicial telaInicial;
	
	@BeforeMethod
	public void beforeMethod() throws Exception {

		driver = inicioDriver();
		telaInicial = PageFactory.initElements(driver, pageObjectTelaInicial.class);
		cadastroCliente = PageFactory.initElements(driver, pageObjectCadastroCliente.class);
		ExcelUtilitarios.setExcelFile("C:\\Users\\angra.souza\\Desktop\\ToolsQAtest\\TDD_Projeto_HUB\\dadosCadastro.xlsx", "Cadastro");
	}

	@Test
	public void cadastrando() throws Exception {

		telaInicial.clicarBotaoLogin();
		cadastroCliente.preenchendoCadastro();
		
	}
	

	@AfterMethod
	public void afterMethod() {

		
		 FechandoJanela();
	}

}
