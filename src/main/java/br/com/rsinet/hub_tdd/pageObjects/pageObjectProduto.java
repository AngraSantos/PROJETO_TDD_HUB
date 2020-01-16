package br.com.rsinet.hub_tdd.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class pageObjectProduto {

	//produto escolhido
	@FindBy(how = How.ID, using = "2")
	private WebElement lnk_laptopPavilion;
	
	@FindBy(how = How.ID, using = "21")
	private WebElement lnk_AltoFalanteHP;
	
	
	public void altoFalante() {
		
		lnk_AltoFalanteHP.click();
		
	}
	public void laptop() {
		
		lnk_laptopPavilion.click();
		
	}
	
	
}
