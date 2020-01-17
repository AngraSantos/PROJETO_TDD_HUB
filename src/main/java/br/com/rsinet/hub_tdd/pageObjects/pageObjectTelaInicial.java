package br.com.rsinet.hub_tdd.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import br.com.rsinet.hub_tdd.driver.DriverFactory;

public class pageObjectTelaInicial {

	final WebDriver driver;

	@FindBy(how = How.ID, using = "menuUserSVGPath")
	private WebElement btn_Login;

	@FindBy(how = How.LINK_TEXT, using = "CREATE NEW ACCOUNT")
	private WebElement lnk_CriarUsuario;

	public pageObjectTelaInicial(WebDriver driver) {
		this.driver = driver;
	}
	
//	
//	// buscar pela barra de pesquisa.
//	public void buscarCaixaDeTexto(String buscarProduto) {
//
//		txtbx_Buscar.sendKeys(buscarProduto);
//		txtbx_Buscar.sendKeys(Keys.RETURN);
//	}
//	
//	
//	// buscar pela tela inicial 
//	public void buscarTelaInicial() {
//		
//		lnk_CxDeSom.click();
//	}
//
//	
	
	
	//clicar no login e criar cadastro
	public void clicarBotaoLogin() {

		btn_Login.click();
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getDriver();
		executor.executeScript("arguments[0].click();", lnk_CriarUsuario);

//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("CREATE NEW ACCOUNT")));
//		Actions Action = new Actions(driver);
//		Action.moveToElement(lnk_CriarUsuario).click().perform();
//		lnk_CriarUsuario.click();
	}
}