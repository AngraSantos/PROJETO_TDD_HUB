package br.com.rsinet.hub_tdd.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home{

	WebDriver driver;

	public Home(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.NAME, using = "mobile_search")
	public WebElement txtbx_Buscar;

	@FindBy(how = How.ID, using = "laptopsTxt")
	public WebElement lnk_laptop;

	@FindBy(how = How.ID, using = "menuUserSVGPath")
	public WebElement btn_Login;

	@FindBy(how = How.LINK_TEXT, using = "CREATE NEW ACCOUNT")
	public WebElement lnk_CriarUsuario;

	// buscar pela barra de pesquisa.
	public void buscarCaixaDeTexto(String buscarProduto) {

		txtbx_Buscar.sendKeys(buscarProduto);
		txtbx_Buscar.sendKeys(Keys.RETURN);
	}
// buscar pela tela inicial 
	public void buscarTelainicial() {
		lnk_laptop.click();
	}

//clicar no ligin e criar cadastro
	public void clicarBotaoLogin() {

		btn_Login.click();

		WebElement btn_CriarUsuario = driver.findElement(By.linkText("CREATE NEW ACCOUNT"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("CREATE NEW ACCOUNT")));
		Actions Action = new Actions(driver);
		Action.moveToElement(btn_CriarUsuario).click().perform();
		lnk_CriarUsuario.click();
	}
}