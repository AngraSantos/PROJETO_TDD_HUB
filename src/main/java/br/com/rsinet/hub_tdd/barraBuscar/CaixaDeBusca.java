package br.com.rsinet.hub_tdd.barraBuscar;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaixaDeBusca {

	public static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String URL = "http://www.advantageonlineshopping.com/#/";
		driver.get(URL);
		
		WebElement caixaDeBusca = driver.findElement(By.name("mobile_search"));
		caixaDeBusca.sendKeys("laptop");
		caixaDeBusca.sendKeys(Keys.RETURN);
		System.out.println("Escreveu");
			
		driver.findElement(By.id("6")).click();
		System.out.println("selecionou o laptop");
	
	}
}
