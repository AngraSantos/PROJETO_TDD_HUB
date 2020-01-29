package br.com.rsinet.hub_tdd.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import br.com.rsinet.hub_tdd.driver.DriverFactory;

public class pageObjectTelaInicial {

	private WebDriver driver;

	@FindBy(how = How.NAME, using = "mobile_search")
	private WebElement txtbx_Buscar;

	@FindBy(how = How.ID, using = "menuUserSVGPath")
	private WebElement btn_Login;

	@FindBy(how = How.LINK_TEXT, using = "CREATE NEW ACCOUNT")
	private WebElement lnk_CriarUsuario;

	@FindBy(how = How.ID, using = "details_10")
	private WebElement lnk_laptopEliteBookErro;

	@FindBy(how = How.ID, using = "speakersTxt")
	private WebElement lnk_CxDeSom;

	/*metodo de usar o wait*/
//	public void tempo(WebElement element, int tempo) {
//		WebDriverWait wait = new WebDriverWait(driver, tempo);
//		wait.until(ExpectedConditions.visibilityOf(element));
//	}

	public void deveClicarEmAlgumProdutoDaTelaInicialComErro() {
		
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.inicioDriver();
		executor.executeScript("arguments[0].click();", lnk_laptopEliteBookErro);
	}

	public void clicarBotaoLogin() {
	
		btn_Login.click();
	}

	public void clicarCriarUsuario() {
		
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.inicioDriver();
		executor.executeScript("arguments[0].click();", lnk_CriarUsuario);
	}

	public void deveClicarEmAlgumProdutoDaTelaInicialComSucesso() {
		
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.inicioDriver();
		executor.executeScript("arguments[0].click();", lnk_CxDeSom);
	}

	public void deveBuscarAlgumProdutoPelaLupa(String buscarProduto) {

		txtbx_Buscar.sendKeys(buscarProduto);
		txtbx_Buscar.sendKeys(Keys.ENTER);

	}
}