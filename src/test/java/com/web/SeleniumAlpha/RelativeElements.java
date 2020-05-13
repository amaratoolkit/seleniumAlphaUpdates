package com.web.SeleniumAlpha;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeElements {
	
	public WebDriver driver;
	
	@BeforeTest
	public void startServer() {
		//driver = new SafariDriver();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/");
		
	}
	
	
	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}
	
	@Test
	public void takeScreenshotOfElement() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Fork me on GitHub']")));
		
		WebElement shadowDomElementLink = driver.findElement(By.cssSelector("a[href='/shadowdom']"));
		
		WebElement reDirectorLink = driver.findElement(By.cssSelector("a[href='/redirector']"));
		
		WebElement secureDownloadLink = 
				driver.findElement(RelativeLocator.withTagName("a").above(shadowDomElementLink).below(reDirectorLink));
		secureDownloadLink.click();
		
		driver.get("http://admin:admin@the-internet.herokuapp.com/download_secure");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'webdriverIO.png')]")));
		assertTrue(driver.findElement(By.xpath("//a[contains(text(),'webdriverIO.png')]")).isDisplayed());
		
		
	}


}
