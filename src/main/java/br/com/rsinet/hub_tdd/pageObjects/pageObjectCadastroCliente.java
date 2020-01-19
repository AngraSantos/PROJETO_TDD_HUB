package br.com.rsinet.hub_tdd.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.excel.ExcelUtilitarios;

public class pageObjectCadastroCliente {

	@FindBy(how = How.ID, using = "menuUserSVGPath")
	private WebElement btn_Login;

	@FindBy(how = How.LINK_TEXT, using = "CREATE NEW ACCOUNT")
	private WebElement lnk_CriarUsuario;

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

	// cadastro de cliente valido
	public void preenchendoCadastroValido(WebDriver driver) throws Exception {

		String usuario = ExcelUtilitarios.getCellData(1, 0);
		txtbx_Usuario.sendKeys(usuario);

		String email = ExcelUtilitarios.getCellData(1, 1);
		txtbx_Email.sendKeys(email);

		String senha = ExcelUtilitarios.getCellData(1, 2);
		txtbx_Senha.sendKeys(senha);

		String confirmeSenha = ExcelUtilitarios.getCellData(1, 3);
		txtbx_ConfirmeSenha.sendKeys(confirmeSenha);

		String nome = ExcelUtilitarios.getCellData(1, 4);
		txtbx_Nome.sendKeys(nome);

		String ultimoNome = ExcelUtilitarios.getCellData(1, 5);
		txtbx_UltimoNome.sendKeys(ultimoNome);

		String telefone = ExcelUtilitarios.getCellData(1, 6);
		txtbx_Telefone.sendKeys(telefone);

		select_Pais.sendKeys("Brazil");

		String cidade = ExcelUtilitarios.getCellData(1, 7);
		txtbx_Cidade.sendKeys(cidade);

		String endereco = ExcelUtilitarios.getCellData(1, 8);
		txtbx_Endereco.sendKeys(endereco);

		String estado = ExcelUtilitarios.getCellData(1, 9);
		txtbx_Estado.sendKeys(estado);

		String cartaoPostal = ExcelUtilitarios.getCellData(1, 10);
		txtbx_CartaoPostal.sendKeys(cartaoPostal);

		select_CheckBox.click();
		btn_Registrar.click();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.urlToBe("http://www.advantageonlineshopping.com/#/"));

	}
//cadastro do cliente invalido
	public void preenchendoCadastroInvalido(WebDriver driver) throws Exception {

		String usuario = ExcelUtilitarios.getCellData(2, 0);
		txtbx_Usuario.sendKeys(usuario);

		String email = ExcelUtilitarios.getCellData(2, 1);
		txtbx_Email.sendKeys(email);

		String senha = ExcelUtilitarios.getCellData(2, 2);
		txtbx_Senha.sendKeys(senha);

		String confirmeSenha = ExcelUtilitarios.getCellData(2, 3);
		txtbx_ConfirmeSenha.sendKeys(confirmeSenha);

		String nome = ExcelUtilitarios.getCellData(2, 4);
		txtbx_Nome.sendKeys(nome);

		String ultimoNome = ExcelUtilitarios.getCellData(2, 5);
		txtbx_UltimoNome.sendKeys(ultimoNome);

		String telefone = ExcelUtilitarios.getCellData(2, 6);
		txtbx_Telefone.sendKeys(telefone);

		select_Pais.sendKeys("Brazil");

		String cidade = ExcelUtilitarios.getCellData(2, 7);
		txtbx_Cidade.sendKeys(cidade);

		String endereco = ExcelUtilitarios.getCellData(2, 8);
		txtbx_Endereco.sendKeys(endereco);

		String estado = ExcelUtilitarios.getCellData(2, 9);
		txtbx_Estado.sendKeys(estado);

		String cartaoPostal = ExcelUtilitarios.getCellData(2, 10);
		txtbx_CartaoPostal.sendKeys(cartaoPostal);

		select_CheckBox.click();
		btn_Registrar.click();

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0, -200)", "");

	}
}
