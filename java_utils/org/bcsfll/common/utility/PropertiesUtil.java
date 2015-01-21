package org.bcsfll.common.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	private static PropertiesUtil instance;
	private static Properties properties = null;

	private PropertiesUtil(File file) {
		properties = new Properties();

		try {
			InputStream inputStream = new FileInputStream(file);
			properties.load(inputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static PropertiesUtil getInstance(String pathname) {
		if (instance == null) {
			
			instance = new PropertiesUtil(new File(pathname));
		}
		return instance;
	}
	public static PropertiesUtil getInstance(File file) {
		if (instance == null) {
			instance = new PropertiesUtil(file);
		}
		return instance;
	}
	public String getValueByKey(String key) {
			return (String) properties.get(key) == null ? "空" : (String) properties.get(key);
	}
}
