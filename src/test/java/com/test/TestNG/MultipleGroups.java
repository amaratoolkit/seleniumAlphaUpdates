package com.test.TestNG;

import org.testng.annotations.Test;

public class MultipleGroups {

	// A test method belongs to Group Window
	@Test(groups = { "Window" })
	public void MethodsBelongToG1() {
		System.out.println("Window");
	}

	// A test method belongs to Group Linux
	@Test(groups = { "Linux" })
	public void MethodsBelongToG2() {
		System.out.println("Linux");
	}

	// A test method belongs to Group Mac
	@Test(groups = { "Mac" })
	public void MethodsBelongToG3() {
		System.out.println("Mac");
	}

	// A test method belongs to Group Window and Linux
	@Test(groups = { "Window", "Linux" })
	public void MethodsBelongToG1G2() {
		System.out.println("Window Linux");
	}

	// A test method belongs to Group Window and Mac
	@Test(groups = { "Window", "Mac" })
	public void MethodsBelongToG1G3() {
		System.out.println("Window Mac");
	}

	// A test method belongs to Group Window, Linux and Mac
	@Test(groups = { "Window", "Linux", "Mac" })
	public void MethodsBelongToG1G2G3() {
		System.out.println("Window Linux Mac");
	}

}