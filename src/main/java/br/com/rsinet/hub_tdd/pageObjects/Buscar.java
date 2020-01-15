package br.com.rsinet.hub_tdd.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Buscar {
	
	//tela inicial 
	@FindBy(how = How.ID, using = "speakersTxt")
	public WebElement lnk_CxDeSom;
	
	//busca pela lupa
	@FindBy(how = How.NAME, using = "mobile_search")
	public WebElement txtbx_Buscar;
	
}