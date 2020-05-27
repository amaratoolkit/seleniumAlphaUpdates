package com.android.SampleTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidBrowser {
	public AndroidDriver<AndroidElement> androidDriver;

	@BeforeTest
	public void startServer() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UIAutomator2");
		dc.setCapability("browserName", "Chrome");
		
		dc.setCapability("deviceName", "Nexus");
		dc.setCapability("platformVersion", "10.0");

		androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		androidDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public void waitSleep() throws InterruptedException {
		Thread.sleep(15);
	}

	@Test
	public void launchBrowser() throws InterruptedException {
		androidDriver.get("http://the-internet.herokuapp.com/");
		waitSleep();
	}

}
