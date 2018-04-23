package com.tz.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropConfigUtils {
	//1.声明一个properties对象
	private static Properties prop;
	
	//2.通过静态代码块来加载该配置文件
	static{
		prop = new Properties();
		//准备该配置文件的字节输入流
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("bean.properties");
		//加载该配置文件
		try {
			prop.load(in);
		} catch (IOException e) {
			throw new RuntimeException("配置文件加载失败!可能路径不正确!");
		}
	}
	/**
	 * 根据key来查询value
	 */
	public static String getValue(String key){
		return prop==null?null:prop.getProperty(key);
	}
}
