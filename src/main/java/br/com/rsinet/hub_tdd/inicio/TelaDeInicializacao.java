package br.com.rsinet.hub_tdd.inicio;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TelaDeInicializacao {

	public static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void AbrindoJanela() {

		String URL = "http://www.advantageonlineshopping.com/#/";
		driver.get(URL);

	}

	public void FechandoJanela() {

		driver.quit();
	}
}
