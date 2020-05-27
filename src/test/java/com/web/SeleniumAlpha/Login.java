package com.web.SeleniumAlpha;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	public WebDriver driver;
	public ReadProperties readProperties;


	@BeforeTest
	public void startServer() {
		readProperties = new ReadProperties();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(readProperties.readData("url"));

	}

	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}
	
	@Test
	public void login() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".login"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#email"))).sendKeys(readProperties.readData("userName"));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#passwd"))).sendKeys(readProperties.readData("password"));
		
		AssertJUnit.assertTrue(driver.findElement(By.cssSelector("#SubmitLogin")).isDisplayed());
	}

}
