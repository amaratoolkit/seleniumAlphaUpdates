package com.test.TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgDataProvider {
	
	@DataProvider(name = "test1")
	public Object[][] testData1(){
		
		Object[][] data = new Object[2][2];
		
		data[0][0] = "data_00";
		data[0][1] = "data_01";
		
		data[1][0] = "data_10";
		data[1][1] = "data_11";
		
		return data;
		
	}
	
	@DataProvider(name = "test2")
	public Object[][] testData2(){
		
		Object[][] data = new Object[2][2];
		
		data[0][0] = "data_000";
		data[0][1] = "data_001";
		
		data[1][0] = "data_010";
		data[1][1] = "data_011";
		
		return data;
		
	}
	
	@Test(dataProvider = "test1")
	public void readData1(String s1, String s2) {
	
		System.out.println("s1==" + s1);
		
		System.out.println("s2==" + s2);
	}
	
	@Test(dataProvider = "test2")
	public void readData2(String s1, String s2) {
	
		System.out.println("s1==" + s1);
		
		System.out.println("s2==" + s2);
	}

}
