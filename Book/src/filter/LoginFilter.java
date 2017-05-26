package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("filter===================");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String requestUri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String url = requestUri.substring(contextPath.length());
		if(url.indexOf("login.jsf") > 0 || url.indexOf("regist.jsf") > 0){
			chain.doFilter(request, response);
			return;
		}
		
		 String userId = (String) req.getSession().getAttribute("userId");
		 System.out.println("=userId=" + userId);
		if(userId == null || "".equals(userId)){
			System.out.println("没有登陆");
			request.setAttribute("msg", "您没有登陆!");
			request.getRequestDispatcher("login.jsf").forward(request, response);
		}
		
		chain.doFilter(request, response);
		return;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
}
