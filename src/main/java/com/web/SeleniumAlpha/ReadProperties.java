package com.web.SeleniumAlpha;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadProperties {

	public String readData(String key) {
		String data = null;
		String projectPath = System.getProperty("user.dir");
		try(FileReader reader = new FileReader(projectPath+ "/testData/test.properties")){
			Properties properties = new Properties();
			properties.load(reader);
			data = properties.getProperty(key);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	//@Test
	public void test() {
		String url = readData("url");
		System.out.println(url);
	}
}
