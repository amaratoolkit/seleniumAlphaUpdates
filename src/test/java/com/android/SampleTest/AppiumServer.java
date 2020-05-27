package com.android.SampleTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServer {
	public static AndroidDriver<AndroidElement> driver;
	public String nodepath = "/usr/local/bin/node";
	public String appiumJSPath = "/usr/local/bin/appium";
	public AppiumDriverLocalService service;
	public SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//public String appiumUrl = null;

	@Test
	public void startServer() throws InterruptedException, MalformedURLException {
		service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File(nodepath))
						.withAppiumJS(new File(appiumJSPath)).withIPAddress("127.0.0.1").usingAnyFreePort());
// .withLogFile(new
// File("C:\\Users\\sikolli\\eclipse-workspace\\MobileAutomation\\appiumServerLog.txt")));
		System.out.println("Started Appium server" + "\n" + df.format(new Date()));

		service.start();
		String appiumUrl = service.getUrl().toString();
		System.out.println("Appium URL -----" + appiumUrl);
		Thread.sleep(20000);
		/*
		 * }
		 * 
		 * @Test public void launchApp() throws MalformedURLException {
		 */
		DesiredCapabilities dCap = new DesiredCapabilities();
		dCap.setCapability("platformName", "Android");
		dCap.setCapability("platform", "Mac");
		dCap.setCapability("platformVersion", "10.0");
// dCap.setCapability("privateDevicesOnly", "true");
		dCap.setCapability("deviceName", "Pixel1");
//dCap.setCapability("deviceName", "iPhone X");
		//dCap.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT, 8100);
		dCap.setCapability("automationName", "UiAutomator2");
//dCap.setCapability("app", "sauce-storage:UICatalog.zip");
		//dCap.setCapability("browserName", "Chrome");
		dCap.setCapability("app", "/Users/sivareddyk/Documents/AppiumJavaTest/SeleniumAutomation/mobileApps/NoBroker.apk");

		driver = new AndroidDriver<AndroidElement>(new URL(appiumUrl), dCap);

		System.out.println("App Launched successfully");

	}

//@AfterClass
	public void killApp() {
		driver.quit();
	}

	@AfterSuite
	public void killSession() {
		driver.quit();
		if (service.isRunning() == true) {
			service.stop();

			System.out.println("\n" + "Stopping Appium server" + "\n" + df.format(new Date()));
		}
	}
}
