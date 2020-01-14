package br.com.rsinet.hub_tdd.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Produto {

	//produto escolhido
	@FindBy(how = How.ID, using = "2")
	public WebElement lnk_laptopPavilion;
	
}
