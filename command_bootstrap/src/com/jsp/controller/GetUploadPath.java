package com.jsp.controller;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.apache.ibatis.io.Resources;

public class GetUploadPath {
	private static Properties properties = new Properties();
	
	// properties 파일이 객체화되는 과정
	static {
		String resource = "com/jsp/properties/uploadPath.properties";
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			properties.load(reader);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getUploadPath(String key) {
		String uploadPath = null;
		
		uploadPath = properties.getProperty(key);
		uploadPath = uploadPath.replace("/", File.separator);
		
		return uploadPath;
	}
}
