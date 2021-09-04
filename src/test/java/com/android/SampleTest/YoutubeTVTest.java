package com.android.SampleTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class YoutubeTVTest {
	AndroidDriver driver;
	
	
	@Test
	public void startSession() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "11.0");
		dc.setCapability("deviceName", "Nexus");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("app", "/Users/sivareddyk/Documents/APK/YouTube.apk");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}

}
