package com.web.SeleniumAlpha;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HIghlightElements {
public WebDriver driver;
	
	@BeforeTest
	public void startServer() {
		driver = new SafariDriver();
//		System.setProperty("webdriver.chrome.silentOutput", "true");
//		WebDriverManager.chromedriver().setup();
//		
//		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/");
		
	}
	
	
	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}
	
	@Test
	public void elementHighlight() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Fork me on GitHub']")));
		
		WebElement logo = driver.findElement(By.cssSelector("img[alt='Fork me on GitHub']"));
		
		highlightEleemnt(logo);
		
		System.out.println("hault");
		
	}
	
	public void highlightEleemnt(WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid green;');", element);
	}

}
