package org.gpf.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 字符编码过滤器，处理乱码
 * @author gaopengfei
 * @date 2015-5-26 下午10:00:30
 */
public class CharsetFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);		// 放行
	}

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

}
