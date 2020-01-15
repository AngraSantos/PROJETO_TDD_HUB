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
		cadastroCliente.txtbx_Usuario.sendKeys("AngraSantos");
		cadastroCliente.txtbx_Email.sendKeys("Angra.santos@hotmail.com.br");
		cadastroCliente.txtbx_Senha.sendKeys("Angra123");
		cadastroCliente.txtbx_ConfirmeSenha.sendKeys("Angra123");

		cadastroCliente.txtbx_Nome.sendKeys("Angra");
		cadastroCliente.txtbx_UltimoNome.sendKeys("Souza");
		cadastroCliente.txtbx_Telefone.sendKeys("11970510060");

		cadastroCliente.select_Pais.sendKeys("Brazil");
		cadastroCliente.txtbx_Cidade.sendKeys("São Paulo");
		cadastroCliente.txtbx_Endereco.sendKeys("Rua três marias");
		cadastroCliente.txtbx_Estado.sendKeys("São Paulo");
		cadastroCliente.txtbx_CartaoPostal.sendKeys("01010-000");

		cadastroCliente.select_CheckBox.click();
		cadastroCliente.btn_Registrar.click();
	}

	@AfterMethod
	public void afterMethod() {

		 FechandoJanela();
	}

}
