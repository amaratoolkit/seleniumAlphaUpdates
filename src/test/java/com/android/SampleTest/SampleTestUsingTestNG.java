package com.android.SampleTest;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class SampleTestUsingTestNG {
	
	
	@Test (groups = {"smoke", "regression"})
	@Parameters({"url"})
	
	public void test1(@Optional("http://automationpractice.com/index.php") String url) {
		System.out.println("url ===========" + url);
		System.out.println("Execute test in both Smoke & Regression");
	}

	@Test (groups = {"smoke"})
	@Parameters({"username"})
	public void test2(@Optional("Shivam")String user) {
		System.out.println("user ===========" + user);
		System.out.println("Execute test in Smoke");
	}
	
	@Test (groups = {"regression"})
	@Parameters({"username", "password"})
	public void test3(@Optional("Shivam")String user, @Optional("Sivas")String pwd) {
		System.out.println("Username ===== "+ user + "Password =========" + pwd);
		System.out.println("Execute test in Regression");
	}
	
	@Test(groups = {"sanity"})
	public void test4() {
	System.out.println("Sanity tests");	
	}
}
