package com.tz.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 
 * 本类用来演示:统计当前在线人数...
 *
 * @author success
 *
 * @date 2018年3月19日 上午11:41:07
 */
@WebListener
public class OnlineCountListener implements HttpSessionListener,ServletContextListener{
	
	//定义一个变量,用来保存当前在线人数
	private Integer count = 0;

	private ServletContext sc;
	/**
	 * 进来一个人...
	 */
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		count++;
		//将该值放入到servletContext作用域中
		sc.setAttribute("online", count);
	}

	/**
	 * 退出一个人...
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		count--;
		sc.setAttribute("online", count);
	}

	/**
	 * 监听容器关闭...
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 监听容器开启...
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("容器开启...");
		//获取ServletContext对象
		sc = event.getServletContext();
	}

}
