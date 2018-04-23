package com.tz.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**安全退出**/
@WebServlet(urlPatterns="/user/safeExit")
public class SafeExitAction extends HttpServlet{
    private static final long serialVersionUID = 1L;

    @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//清空session
		//登陆和不登陆的区别就是看session是否有用户
		req.getSession().invalidate();
		resp.sendRedirect(req.getContextPath());
	}
}
