package com.web.SeleniumAlpha;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.*;

import io.netty.handler.codec.http.multipart.FileUpload;

public class ScreenShotTest {
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
	public void takeScreenshotOfElement() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Fork me on GitHub']")));
		
		WebElement logo = driver.findElement(By.cssSelector("img[alt='Fork me on GitHub']"));
		
		File file = logo.getScreenshotAs(OutputType.FILE);
		
		File destFile = new File("testLogo.png");
		
		FileUtils.copyFile(file, destFile);
	}

}
