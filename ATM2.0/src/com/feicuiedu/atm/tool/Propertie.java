package com.feicuiedu.atm.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Propertie {

	/**
	 * 读取Properties文件中的内容,
	 * 
	 * @return Properties 对象 prop
	 */
	public Properties getProp() {

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("res" + File.separator + "Show.properties")));
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		return prop;
	}

}
