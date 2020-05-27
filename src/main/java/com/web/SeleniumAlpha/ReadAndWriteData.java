package com.web.SeleniumAlpha;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadAndWriteData {
	static FileWriter fileWriter = null;


	public static String readCsvFile(String fileName,String Key) { 
	    String line = "";
	    String cvsSplitBy = ",";
	    String[] data=null;
	    String keyValue=null;
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

	        while ((line = br.readLine()) != null) {
	        	data = line.split(cvsSplitBy);
	        	if(data[0].equalsIgnoreCase(Key)){
	        		 keyValue = String.valueOf(data[1]);
	        		break;        		
	        	}       	
	        	
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return keyValue;


	}
	public static String readCsvFile(String fileName,String Key,int colnumber) { 
	    String line = "";
	    String cvsSplitBy = ",";
	    String[] data=null;
	    String keyValue=null;
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

	        while ((line = br.readLine()) != null) {
	        	data = line.split(cvsSplitBy);
	        	if(data[0].equalsIgnoreCase(Key)){
	        		 keyValue = data[colnumber];
	        		break;        		
	        	}       	
	        	
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return keyValue;


	}
}
