package com.tz.util;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 
 * 本类用来演示:主要就是为了封装获取SqlSession的代码
 *
 * @author success
 * 
 * 2017年11月28日上午9:32:19
 */
public class MybatisUtil {
	//2.提供这个类的唯一实例
	private static SqlSessionFactory sf;
	
	//可以通过静态代码块来初始化SqllSessionFactory;
	static{
		try {
			sf = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("可能资源文件加载失败...");
		}
	}
	

	//3.提供一个公开的静态的方法,来返回这个类的唯一实例.
	public static SqlSession getSqlSession(){
		return null==sf?null:sf.openSession();
	}
}
