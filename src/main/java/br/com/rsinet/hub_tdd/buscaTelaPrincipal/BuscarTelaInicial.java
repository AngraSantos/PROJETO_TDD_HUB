package br.com.rsinet.hub_tdd.buscaTelaPrincipal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class BuscarTelaInicial {
	
	public static WebDriver driver;
	
	public static void main(String[] args) {
	
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String URL = "http://www.advantageonlineshopping.com/#/";
		driver.get(URL);
		
		
		Actions actions = new Actions(driver);
		
		WebElement produtoSelecionado = driver.findElement(By.id("laptopsImg"));
		actions.moveToElement(produtoSelecionado).perform();
		
		WebElement botaoSelecionado = driver.findElement(By.id("laptopsLink"));
		actions.moveToElement(botaoSelecionado).click().perform();
		System.out.println("Clicando nos laptops, tela inicial");
		
		driver.findElement(By.id("5")).click();
		System.out.println("selecionou o laptop");
	}
}

