package com.test.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ReTryTests {

	//@Test(retryAnalyzer = ReTryTestNGTest.class)
	public void test1() {

		Assert.assertEquals(false, true);

	}

	@Test
	public void test2() {

		Assert.assertEquals(false, true);

	}
	
	@Test
	public void test3() {

		Assert.assertEquals(true, true);

	}
	
	@Test
	public void test4() {

		Assert.assertEquals(false, true);

	}
	
	@Test
	public void test5() {

		Assert.assertEquals(true, true);

	}
	
	@Test
	public void test6() {

		Assert.assertEquals(true, true);

	}
	
	@Test
	public void test7() {

		Assert.assertEquals(true, true);

	}

}
