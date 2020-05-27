package com.test.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ThreadPoolSize {
	public WebDriver driver;
	@Test(threadPoolSize = 2, invocationCount = 3)
	public void poolSize() {
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/");

	}

	@AfterTest
	public void killServer() {
		driver.quit();
	}
}
