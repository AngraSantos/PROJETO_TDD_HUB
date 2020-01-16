package br.com.rsinet.hub_tdd.testes;

import static br.com.rsinet.hub_tdd.driver.DriverFactory.FechandoJanela;
import static br.com.rsinet.hub_tdd.driver.DriverFactory.inicioDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.pageObjects.CadastroCliente;
import br.com.rsinet.hub_tdd.pageObjects.TelaInicial;
import br.com.rsinet.hub_tdd.utilitarios.ExcelUtilitarios;

public class CadastrarTeste {

	private WebDriver driver;
	CadastroCliente cadastroCliente;
	TelaInicial telaInicial;
	
	@BeforeMethod
	public void beforeMethod() throws Exception {

		driver = inicioDriver();
		telaInicial = PageFactory.initElements(driver, TelaInicial.class);
		cadastroCliente = PageFactory.initElements(driver, CadastroCliente.class);
		ExcelUtilitarios.setExcelFile("C:\\Users\\angra.souza\\Desktop\\ToolsQAtest\\TDD_Projeto_HUB\\dadosCadastro.xlsx", "Cadastro");
	}

	@Test
	public void cadastrando() throws Exception {

		telaInicial.clicarBotaoLogin();
		
		
		String usuario = ExcelUtilitarios.getCellData(1, 0);
		cadastroCliente.txtbx_Usuario.sendKeys(usuario);
		
		String email = ExcelUtilitarios.getCellData(1, 1);
		cadastroCliente.txtbx_Email.sendKeys(email);
		
		String senha = ExcelUtilitarios.getCellData(1, 2);
		cadastroCliente.txtbx_Senha.sendKeys(senha);
		
		String confirmeSenha = ExcelUtilitarios.getCellData(1, 3);
		cadastroCliente.txtbx_ConfirmeSenha.sendKeys(confirmeSenha);

		
		String nome = ExcelUtilitarios.getCellData(1, 4);
		cadastroCliente.txtbx_Nome.sendKeys(nome);
		
		String ultimoNome = ExcelUtilitarios.getCellData(1, 5);
		cadastroCliente.txtbx_UltimoNome.sendKeys(ultimoNome);
		
		String telefone = ExcelUtilitarios.getCellData(1, 6);
		cadastroCliente.txtbx_Telefone.sendKeys(telefone);
		
		cadastroCliente.select_Pais.sendKeys("Brazil");
		
		String cidade = ExcelUtilitarios.getCellData(1, 7);
		cadastroCliente.txtbx_Cidade.sendKeys(cidade);
		
		String endereco = ExcelUtilitarios.getCellData(1, 8);
		cadastroCliente.txtbx_Endereco.sendKeys(endereco);
		
		String estado = ExcelUtilitarios.getCellData(1, 9);
		cadastroCliente.txtbx_Estado.sendKeys(estado);
		
		String cartaoPostal = ExcelUtilitarios.getCellData(1, 10);
		cadastroCliente.txtbx_CartaoPostal.sendKeys(cartaoPostal);

		
		cadastroCliente.select_CheckBox.click();
		cadastroCliente.btn_Registrar.click();
		
	}

	@AfterMethod
	public void afterMethod() {

		
		 FechandoJanela();
	}

}
