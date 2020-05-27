package com.test.TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Groups {

	@Test(groups = { "functest", "checkintest" })
	public void testMethod1() {
		System.out.println("testMethod1 - groups: functest, checkintest");
	}

	@Test(groups = { "functest", "checkintest" })
	public void testMethod2() {
		System.out.println("testMethod2 - groups: functest, checkintest");
	}

	@Test(groups = { "functest" })
	public void testMethod3() {
		System.out.println("testMethod3 - groups: functest");
	}
	
	
	@Test(groups = { "checkintest" })
	public void testMethod4() {
		System.out.println("testMethod4 - groups: checkintest");
	}
}
