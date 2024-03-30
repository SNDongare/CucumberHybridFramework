package utils;

import java.util.*;
import java.io.*;
public class ConfigReader {

	public Properties initializeProperties() {
		
		Properties prop= new Properties();
		File proFile=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties");
		try {
		FileInputStream fis=new FileInputStream(proFile);
		prop.load(fis);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return prop;
	}
}
