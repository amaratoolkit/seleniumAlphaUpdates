package com.web.SeleniumAlpha;

import java.io.IOException;
import java.time.Duration;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.emulation.Emulation;
import org.openqa.selenium.devtools.network.Network;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkRelated {
	public WebDriver driver;
	@BeforeTest
	public void startServer() {		
		//System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		DevTools devTools = ((ChromiumDriver)driver).getDevTools();
//		
//		devTools.createSession();
//		devTools.send(Network.enable(Optional.of(1000000),null,null));
		
		
		
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
		System.out.println("Successfull app is launched");
		
		
	}
}
