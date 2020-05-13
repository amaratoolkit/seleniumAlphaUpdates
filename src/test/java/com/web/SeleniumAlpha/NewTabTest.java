package com.web.SeleniumAlpha;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTabTest {
	public WebDriver driver;
	
	@BeforeTest
	public void startServer() {
		driver = new SafariDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/");
		
	}
	
	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}
	
	@Test
	public void openNewTab() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Fork me on GitHub']")));
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("http://automationpractice.com/index.php");
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='View my shopping cart']")));
	}
	
	@Test
	public void openNewWindow() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Fork me on GitHub']")));
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("http://automationpractice.com/index.php");
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='View my shopping cart']")));
	}
}
