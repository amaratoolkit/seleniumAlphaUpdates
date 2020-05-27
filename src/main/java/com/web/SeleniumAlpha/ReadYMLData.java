package com.web.SeleniumAlpha;

import java.io.File;
import java.lang.reflect.Method;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class ReadYMLData {
	
	 public Method readData(Method myMethod) {
		 Method data = null;
	        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
	        try {
	        	String projectPath = System.getProperty("user.dir");
	            UserData user = mapper.readValue(new File(projectPath + "/testData/userData.yaml"), UserData.class);
	        	

	            
	            //To read entire file
	           // System.out.println(ReflectionToStringBuilder.toString(user,ToStringStyle.MULTI_LINE_STYLE));
	            
	            
	            System.out.println(user.getName());
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return data;
	    }

	
}
