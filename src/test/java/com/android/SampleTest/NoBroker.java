package com.android.SampleTest;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class NoBroker {
	public AndroidDriver<AndroidElement> androidDriver;
	
	@BeforeTest
	public void launchApp() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformVersion", "9.0");
		dc.setCapability("platform", "Android");
		dc.setCapability("deviceName", "Pixel");
		dc.setCapability("app", "/Users/sivareddyk/Documents/APK/NoBroker.apk");
		dc.setCapability("automationName", "UiAutomator2");
		
		androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		androidDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@Test
	public void sampleTest() {
		WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[ends-with(@resource-id,'yesPhoneState')]"))).click();
		
		System.out.println("Continue button is clicked");
	}
	

}
