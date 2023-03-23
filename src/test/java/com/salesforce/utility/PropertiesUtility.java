package com.salesforce.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {

	private FileInputStream stream = null;
	private Properties propertyFile = null;

	public Properties loadFile(String filename)  {
		propertyFile = new Properties();
		String propertyFilePath = null;
		if(filename.equals("applicationData.Properties")) {
			propertyFilePath = Constants.APPLICATION_PROPERTIES;
		}
		else
		{
			System.out.println("No constants file found");
		}
		try {
			stream = new FileInputStream(propertyFilePath);
			
			propertyFile.load(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return propertyFile;
	}

	public String getPropertyValue(String key) {
		String value = propertyFile.getProperty(key);
		System.out.println("Property we get from the file is : " + value);
		try {
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
}
