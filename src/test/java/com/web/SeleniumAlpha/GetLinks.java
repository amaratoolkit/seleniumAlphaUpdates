package com.web.SeleniumAlpha;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetLinks {
	public WebDriver driver;
	public URL url;

	@BeforeTest
	public void startServer() {
		// driver = new SafariDriver();
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
	public void openNewTab() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='Fork me on GitHub']")));

		WebElement logo = driver.findElement(By.cssSelector("img[alt='Fork me on GitHub']"));

		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));

		System.out.println("allLinks Size=======" + allLinks.size());

		for (int j = 0; j < allLinks.size(); j++) {
			System.out.println(allLinks.get(j).getAttribute("href"));
			url = new URL(allLinks.get(j).getAttribute("href"));

			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("GET");
			System.out.println("httpURLConnection.getResponseCode======" + httpURLConnection.getResponseCode());

			try {
				Assert.assertEquals(200, httpURLConnection.getResponseCode());
			}catch (AssertionError ae) {
				Assert.assertEquals(401, httpURLConnection.getResponseCode());

			}

		}

	}

}
