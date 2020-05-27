package com.test.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertAndHardAssert {
	SoftAssert softAssert = new SoftAssert();
	
	@Test
	public void softAssertionTest() {
		softAssert.assertEquals("Test1", "Test2");
		softAssert.assertEquals("Test2", "Test3");
		softAssert.assertEquals("Test2", "Test2");
		System.out.println("3rd Assertion Passed");
		softAssert.assertAll();
	}
	
	@Test
	public void hardAssertionTest() {
		Assert.assertEquals("Test1", "Test2");
		Assert.assertEquals("Test2", "Test2");
	}

}
