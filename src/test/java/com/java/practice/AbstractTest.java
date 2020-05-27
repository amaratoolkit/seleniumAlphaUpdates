package com.java.practice;

import org.testng.annotations.Test;

public class AbstractTest extends Motor{
	
	void engine() {
		System.out.println("Motor running");
	}
	
	@Test
	public void test() {
		engine();
	}

}
