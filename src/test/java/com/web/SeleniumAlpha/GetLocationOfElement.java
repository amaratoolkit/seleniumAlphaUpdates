package com.web.SeleniumAlpha;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetLocationOfElement {
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
		
		WebElement logo = driver.findElement(By.cssSelector("img[alt='Fork me on GitHub']"));
		
		int height = logo.getRect().getHeight();
		int width = logo.getRect().getWidth();
		
		int x = logo.getRect().getX();
		int y = logo.getRect().getY();
		
		System.out.println("height="+height);
		System.out.println("width="+width);
		System.out.println("x="+x);
		System.out.println("y="+y);
		
	}
}
