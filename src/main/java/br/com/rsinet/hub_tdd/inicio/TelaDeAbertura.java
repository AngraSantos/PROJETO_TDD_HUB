package br.com.rsinet.hub_tdd.inicio;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TelaDeAbertura {

	static  WebDriver driver;
	
	private TelaDeAbertura () {
		
	}

	public static WebDriver inicioDriver() {
		
		driver = new ChromeDriver();
		driver.get("http:www.advantageonlineshopping.com/#/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}


	public static void FechandoJanela() {

		driver.quit();
	}

}
