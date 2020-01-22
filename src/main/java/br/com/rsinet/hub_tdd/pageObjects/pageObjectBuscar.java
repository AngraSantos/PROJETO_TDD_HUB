//package br.com.rsinet.hub_tdd.pageObjects;
//
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;
//
//public class pageObjectBuscar {
//
//	// tela inicial por click
//	@FindBy(how = How.ID, using = "speakersTxt")
//	private WebElement lnk_CxDeSom;
//
//	// busca pela lupa
//	@FindBy(how = How.NAME, using = "mobile_search")
//	private WebElement txtbx_Buscar;
//
//	
//
//	public void deveClicarEmAlgumProdutoDaTelaInicialComSucesso() {
//
//		lnk_CxDeSom.click();
//	}
//
//	public void deveBuscarAlgumProdutoPelaLupa(String buscarProduto) {
//
//		txtbx_Buscar.sendKeys(buscarProduto);
//		txtbx_Buscar.sendKeys(Keys.ENTER);
//
//	}
//
//}