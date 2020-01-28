package br.com.rsinet.hub_tdd.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.driver.DriverFactory;

public class pageObjectProduto {
	
	private WebDriverWait wait = new WebDriverWait(DriverFactory.inicioDriver(), 20);
	private JavascriptExecutor js;
	
	@FindBy(how = How.ID, using = "2")
	private WebElement lnk_laptopPavilion;

	@FindBy(how = How.ID, using = "21")
	private WebElement lnk_altoFalanteHP;
	

	public void altoFalante() {
		
		wait.until(ExpectedConditions.elementToBeClickable(lnk_altoFalanteHP));
		
		js = (JavascriptExecutor) DriverFactory.inicioDriver();
		js.executeScript("arguments[0].click();", lnk_altoFalanteHP);
	}

	public void laptop15z() {
		
		wait.until(ExpectedConditions.elementToBeClickable(lnk_laptopPavilion));
		
		js = (JavascriptExecutor) DriverFactory.inicioDriver();
		js.executeScript("arguments[0].click();", lnk_laptopPavilion);
	}	
	
}
