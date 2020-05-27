package com.test.TestNG;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.web.SeleniumAlpha.ReadProperties;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderParallelTesting {
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
	public void loginAsUser() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".login"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#email"))).sendKeys(readProperties.readData("userName"));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#passwd"))).sendKeys(readProperties.readData("password"));
		
		AssertJUnit.assertTrue(driver.findElement(By.cssSelector("#SubmitLogin")).isDisplayed());
		
		System.out.println("Testing Thread | " + Thread.currentThread().getName() );
		System.out.println("Testing Thread | " + Thread.currentThread().getId() );
		driver.navigate().back();
	}
	
	@Test
	public void loginAsAdmin() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".login"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#email"))).sendKeys(readProperties.readData("userName"));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#passwd"))).sendKeys(readProperties.readData("password"));
		
		AssertJUnit.assertTrue(driver.findElement(By.cssSelector("#SubmitLogin")).isDisplayed());
		
		System.out.println("Testing Thread | " + Thread.currentThread().getName() );
		System.out.println("Testing Thread | " + Thread.currentThread().getId() );
	}


}
