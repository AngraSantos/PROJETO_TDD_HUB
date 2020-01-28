package br.com.rsinet.hub_tdd.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import br.com.rsinet.hub_tdd.excel.MassaDeDados;

public class pageObjectCadastroCliente {
	
	private WebDriver driver;
	MassaDeDados massaDeDados = new MassaDeDados();

	@FindBy(how = How.NAME, using = "usernameRegisterPage")
	private WebElement txtbx_Usuario;

	@FindBy(how = How.NAME, using = "emailRegisterPage")
	private WebElement txtbx_Email;

	@FindBy(how = How.NAME, using = "passwordRegisterPage")
	private WebElement txtbx_Senha;

	@FindBy(how = How.NAME, using = "confirm_passwordRegisterPage")
	private WebElement txtbx_ConfirmeSenha;

	@FindBy(how = How.NAME, using = "first_nameRegisterPage")
	private WebElement txtbx_Nome;

	@FindBy(how = How.NAME, using = "last_nameRegisterPage")
	private WebElement txtbx_UltimoNome;

	@FindBy(how = How.NAME, using = "phone_numberRegisterPage")
	private WebElement txtbx_Telefone;

	@FindBy(how = How.NAME, using = "countryListboxRegisterPage")
	private WebElement select_Pais;

	@FindBy(how = How.NAME, using = "cityRegisterPage")
	public WebElement txtbx_Cidade;

	@FindBy(how = How.NAME, using = "addressRegisterPage")
	private WebElement txtbx_Endereco;

	@FindBy(how = How.NAME, using = "state_/_province_/_regionRegisterPage")
	private WebElement txtbx_Estado;

	@FindBy(how = How.NAME, using = "postal_codeRegisterPage")
	private WebElement txtbx_CartaoPostal;

	@FindBy(how = How.NAME, using = "i_agree")
	private WebElement select_CheckBox;

	@FindBy(how = How.ID, using = "register_btnundefined")
	private WebElement btn_Registrar;

	public void page (WebDriver driver) {
		this.driver = driver;
	}

	public void usuario() throws Exception  {
		txtbx_Usuario.sendKeys(massaDeDados.usuario());
	}
	
	public void email() throws Exception {
		txtbx_Email.sendKeys(massaDeDados.email());
	}

	public void senha() throws Exception {
		txtbx_Senha.sendKeys(massaDeDados.senha());
	}

	public void confirmeSenha() throws Exception {
		txtbx_ConfirmeSenha.sendKeys(massaDeDados.confirmeSenha());
	}

	public void primeiroNome() throws Exception {
		txtbx_Nome.sendKeys(massaDeDados.primeiroNome());
	}

	public void ultimoNome() throws Exception {
		txtbx_UltimoNome.sendKeys(massaDeDados.ultimoNome());
	}

	public void telefone() throws Exception {
		txtbx_Telefone.sendKeys(massaDeDados.telefone());
	}

	public void pais() throws Exception {
		Select select = new Select(select_Pais);
		select.selectByVisibleText(massaDeDados.pais());
	}

	public void cidade() throws Exception {
		txtbx_Cidade.sendKeys(massaDeDados.cidade());
	}

	public void endereco() throws Exception {
		txtbx_Endereco.sendKeys(massaDeDados.endereco());
	}

	public void estado() throws Exception {
		txtbx_Estado.sendKeys(massaDeDados.estado());
	}

	public void cartaoPostal() throws Exception {
		txtbx_CartaoPostal.sendKeys(massaDeDados.cartaoPostal());
	}

	public void clicarCheckBox() {
		select_CheckBox.click();
	}

	public void clicarRegistrar() {
		btn_Registrar.click();

	}
}
