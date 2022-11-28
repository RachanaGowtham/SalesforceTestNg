package com.training.utilities;

import java.io.FileInputStream;

import static com.training.utilities.Constants.USER_DIR;
import static com.training.utilities.Constants.FILE_SEPARATOR;
import static com.training.utilities.Constants.APPLICATION_PROPERTIES;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CommonUtilities {
	
	public String getproperty(String key) throws IOException {
		
		//String sPath="/Users/gowthamsuresh/eclipse-workspace/TestNgFramework/properties/application.properties";
		
		String sPath=USER_DIR+FILE_SEPARATOR+APPLICATION_PROPERTIES; // to remove hardcoding from constant class (import manually)
		
		FileInputStream fileput=new FileInputStream(sPath);
		Properties prop=new Properties();
		prop.load(fileput);
		String value=prop.getProperty(key);
		return value;
	}

}
