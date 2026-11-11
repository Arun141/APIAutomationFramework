package com.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {
	
	private static final String CONFIG_FILE = "config.properties";
	private static final Properties properties = new Properties();
	
	static {
		try (InputStream stream = ConfigReader.class.getClassLoader().getResourceAsStream(CONFIG_FILE)){
			if(stream == null) {
				throw new RuntimeException(CONFIG_FILE + "not found in src/test/resources");
			}
			properties.load(stream);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load "+ CONFIG_FILE, e);
		}
	}
	
	private ConfigReader() {
		//Utility class, no instances
	}
	
	public static String get(String key) {
		//1. JVM argument, e.g. -Dbase.url=...
		String value = System.getProperty(key);
		if(value != null && !value.isBlank()) {
			return value;
		}
		
		//2. Environment variable, e.g. base.url -> BASE_URL
		value = System.getenv(key.replace('.', '_').toUpperCase());
		if(value != null && !value.isBlank()) {
			return value;
		}
		
		//3. config.properties
		value = properties.getProperty(key);
		if(value == null || value.isBlank()) {
			throw new RuntimeException("Missing configuration for key: "+key);
		}
		return value.trim();
	}
}
