package com.tz.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 
 * 本类用来演示:该监听器负责获取上下文路径,并且存储在application作用域中
 *
 * @author success
 *
 * @date 2018年3月22日 下午1:58:06
 */
@WebListener
public class CreatePathListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		/*ServletContext sc = arg0.getServletContext();
		
		//获取上下文路径
		String path = sc.getContextPath();
		
		//放入到作用域中
		sc.setAttribute("path", path);	*/
	}
}
