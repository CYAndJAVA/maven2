package com.tz.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns="/*",initParams={@WebInitParam(name = "encoding", value = "utf-8"),
										@WebInitParam(name = "contentType", value = "text/html;charset=utf-8")})
public class EncodingFilter implements Filter{
	private String encoding;
	
	private String contentType;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
		contentType = config.getInitParameter("contentType");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		
		//处理post请求的乱码问题
		req.setCharacterEncoding(encoding);
		//设置输出编码
		resp.setCharacterEncoding(encoding);
		//设置文档类型
		resp.setContentType(contentType);
		
		chain.doFilter(req, resp);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
