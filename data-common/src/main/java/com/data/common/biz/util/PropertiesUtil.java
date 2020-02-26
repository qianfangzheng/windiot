package com.data.common.biz.util;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	private static Properties properties;
	
    static {
    	try {
    		properties = new Properties();
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("trendDB.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
		
	public static String getValue(String key) {
		String value = properties.getProperty(key.trim());
		if (value == null && value == "") {
			return null;
		}
		return value;
	}
	
	public static String getValue(String key,String defaultValue) {
		String value = properties.getProperty(key.trim());
		if (value == null && value == "") {
			return defaultValue;
		}
		return value;
	}
}
