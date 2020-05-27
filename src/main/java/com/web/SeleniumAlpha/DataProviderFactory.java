package com.web.SeleniumAlpha;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderFactory {
	private String userName;
	private String password;
	
	
	static ReadAndWriteData dataobj=new ReadAndWriteData();
	static String fileName = System.getProperty("user.dir") + "\\testData\\guestData.csv";
	static String jsonFileName=System.getProperty("user.dir")+File.separator+"intermediatory.json";
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@SuppressWarnings("static-access")
	@DataProvider(name = "userData")
	public static Object[][] getIntermediatoryRemAvm() throws FileNotFoundException, IOException{
		DataProviderFactory testData =  new DataProviderFactory();
		testData.setUserName(dataobj.readCsvFile(fileName, "userName"));
		testData.setPassword(dataobj.readCsvFile(fileName, "password"));
		return new DataProviderFactory[][] { { testData } };
	}
}