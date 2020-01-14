package br.com.rsinet.hub_tdd.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CadastroCliente {
	
	@FindBy(how = How.ID, using = "menuUserSVGPath")
	public WebElement btn_Login;
	
	@FindBy(how = How.LINK_TEXT, using = "CREATE NEW ACCOUNT")
	public WebElement lnk_CriarUsuario;
	
	@FindBy(how = How.NAME, using = "usernameRegisterPage")
	public WebElement txtbx_Usuario;
	
	@FindBy(how = How.NAME, using = "emailRegisterPage")
	public WebElement txtbx_Email;
	
	@FindBy(how = How.NAME, using = "passwordRegisterPage")
	public WebElement txtbx_Senha;

	@FindBy(how = How.NAME, using = "confirm_passwordRegisterPage")
	public WebElement txtbx_ConfirmeSenha;
	
	@FindBy(how = How.NAME, using = "first_nameRegisterPage")
	public WebElement txtbx_Nome;
	
	@FindBy(how = How.NAME, using = "last_nameRegisterPage")
	public WebElement txtbx_UltimoNome;
	
	@FindBy(how = How.NAME, using = "phone_numberRegisterPage")
	public WebElement txtbx_Telefone;
	
	@FindBy(how = How.NAME, using = "countryListboxRegisterPage")
	public WebElement select_Pais;

	@FindBy(how = How.NAME, using = "cityRegisterPage")
	public WebElement txtbx_Cidade;
	
	@FindBy(how = How.NAME, using = "addressRegisterPage")
	public WebElement txtbx_Estado;
	
	@FindBy(how = How.NAME, using = "addressRegisterPage")
	public WebElement txtbx_CartaoPostal;
	
	@FindBy(how = How.NAME, using = "i_agree")
	public WebElement select_CheckBox;
	
	@FindBy(how = How.ID, using = "register_btnundefined")
	public WebElement btn_Registrar;
	
}
	
	
