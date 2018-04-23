package com.tz.util;
/**
 * 利用建档工厂设计模式来构建bean的对象
 */
public class BeansFactory {

	public static Object getInstance(String key){
		Object obj = null;
		//获取的是一个类的全限定名.
		String className = PropConfigUtils.getValue(key);
		//获取class实例
		try {
			Class<?> c = Class.forName(className);
			obj = c.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}
