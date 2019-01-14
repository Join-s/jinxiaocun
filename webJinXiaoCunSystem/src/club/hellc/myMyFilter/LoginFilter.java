package club.hellc.myMyFilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter extends HttpServlet implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		Object username = ((HttpServletRequest) req).getSession().getAttribute("uname");
		if (username != null) {
			chain.doFilter(req, res);// 传递给后面的过滤器或其他资源处理
		} else {
			((HttpServletResponse) res).sendRedirect("/webJinXiaoCunSystem/WebRoot/login.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
