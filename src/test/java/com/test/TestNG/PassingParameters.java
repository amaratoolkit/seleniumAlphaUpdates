package com.test.TestNG;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PassingParameters {

	public WebDriver driver;
	public URL url;

	@BeforeTest
	@Parameters({"url"})
	public void startServer(String url) {
		// driver = new SafariDriver();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);

	}

	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}
	
	@Test
	@Parameters({"userName","password"})
	public void login(String userName, String password) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".login"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#email"))).sendKeys(userName);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#passwd"))).sendKeys(password);
		
		AssertJUnit.assertTrue(driver.findElement(By.cssSelector("#SubmitLogin")).isDisplayed());
	}

}
